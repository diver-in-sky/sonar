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

import javax.persistence.*;

@Entity(name = "IndexBlock")
@Table(name = "index_blocks")
public class IndexBlock {

  public static final int RESOURCE_ID_SIZE = 400;
  public static final int BLOCK_HASH_SIZE = 50;

  @Id
  @Column(name = "id")
  @GeneratedValue
  private Integer id;

  @Column(name = "resource_id", updatable = true, nullable = true, length = RESOURCE_ID_SIZE)
  private String resourceId;

  @Column(name = "block_hash", updatable = true, nullable = true, length = BLOCK_HASH_SIZE)
  private String blockHash;

  @Column(name = "index_in_file", updatable = true, nullable = true)
  private Integer indexInFile;

  @Column(name = "start_line", updatable = true, nullable = true)
  private Integer startLine;

  @Column(name = "end_line", updatable = true, nullable = true)
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getBlockHash() {
    return blockHash;
  }

  public void setBlockHash(String blockHash) {
    this.blockHash = blockHash;
  }

  public Integer getIndexInFile() {
    return indexInFile;
  }

  public void setIndexInFile(Integer indexInFile) {
    this.indexInFile = indexInFile;
  }

  public Integer getStartLine() {
    return startLine;
  }

  public void setStartLine(Integer startLine) {
    this.startLine = startLine;
  }

  public Integer getEndLine() {
    return endLine;
  }

  public void setEndLine(Integer endLine) {
    this.endLine = endLine;
  }
}
