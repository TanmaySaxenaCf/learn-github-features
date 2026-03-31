"""Incremental generation — skip unchanged files.

Uses SHA-256 checksums of source files to determine which
test files need regeneration.  Checksums are stored in
<project>/.testgen/checksums.json.
"""

from __future__ import annotations

import logging
from pathlib import Path

from ..models import ClassInfo
from ..discovery.serialiser import (
    load_checksums, save_checksums, compute_file_checksum
)

logger = logging.getLogger(__name__)


class IncrementalChecker:
    """Determines which classes need test regeneration."""

    def __init__(self, project_path: str | Path):
        self.project_path = Path(project_path)
        self._old_checksums = load_checksums(self.project_path)
        self._new_checksums: dict[str, str] = {}

    def needs_regeneration(self, ci: ClassInfo) -> bool:
        """Return True if the source file has changed since last run."""
        try:
            current = compute_file_checksum(ci.file_path)
        except OSError:
            return True
        self._new_checksums[ci.file_path] = current
        return self._old_checksums.get(ci.file_path) != current

    def save(self) -> None:
        """Persist the new checksums for next run."""
        # Merge: keep entries for files we didn't check this run
        merged = {**self._old_checksums, **self._new_checksums}
        save_checksums(self.project_path, merged)
        logger.debug("Saved %d checksums", len(merged))
