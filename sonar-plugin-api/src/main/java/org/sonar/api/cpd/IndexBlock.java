/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2011 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.api.cpd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "IndexBlock")
@Table(name = "index_blocks")
public class IndexBlock {

  public static final int RESOURCE_ID_SIZE = 400;
  public static final int BLOCK_HASH_SIZE = 50;

  @Column(name = "resource_id", updatable = false, nullable = false, length = RESOURCE_ID_SIZE)
  private String resourceId;

  @Column(name = "block_hash", updatable = false, nullable = false, length = BLOCK_HASH_SIZE)
  private String blockHash;

  @Column(name = "index_in_file", updatable = false, nullable = false)
  private Integer indexInFile;

  @Column(name = "start_line", updatable = false, nullable = false)
  private Integer startLine;

  @Column(name = "end_line", updatable = false, nullable = false)
  private Integer endLine;

  /**
   * Default constructor
   */
  public IndexBlock() {
  }

  /**
   * <p>Creates a block model</p>
   *
   * @param resourceId  id of resource (full path of file)
   * @param blockHash   hash of block
   * @param indexInFile index number of block in file
   * @param startLine   index number of first line of block in file
   * @param endLine     index number of last line of block in file
   */
  public IndexBlock(String resourceId, String blockHash, Integer indexInFile, Integer startLine, Integer endLine) {
    this.resourceId = resourceId;
    this.blockHash = blockHash;
    this.indexInFile = indexInFile;
    this.startLine = startLine;
    this.endLine = endLine;
  }

  public String getResourceId() {
    return resourceId;
  }

  public String getBlockHash() {
    return blockHash;
  }

  public Integer getIndexInFile() {
    return indexInFile;
  }

  public Integer getStartLine() {
    return startLine;
  }

  public Integer getEndLine() {
    return endLine;
  }
}
