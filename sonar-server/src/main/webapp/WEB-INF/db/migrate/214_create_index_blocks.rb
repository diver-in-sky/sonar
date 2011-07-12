#
# Sonar, entreprise quality control tool.
# Copyright (C) 2008-2011 SonarSource
# mailto:contact AT sonarsource DOT com
#
# Sonar is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; either
# version 3 of the License, or (at your option) any later version.
#
# Sonar is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
# Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public
# License along with Sonar; if not, write to the Free Software
# Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
#

#
# Sonar GSoC 2011
#
class CreateIndexBlocks < ActiveRecord::Migration

  def self.up
    create_table :index_blocks do |t|
      t.column :resource_id,        :string,  :null => false, :limit => 400
      t.column :block_hash,         :string,  :null => false, :limit => 50
      t.column :start_line,         :integer, :null => false
      t.column :end_line,           :integer, :null => false
      t.column :index_in_file,      :integer, :null => false
    end

    add_index :index_blocks, [:resource_id], :name => 'index_blocks_resource'
    add_index :index_blocks, [:block_hash], :name => 'index_blocks_hash'
  end

end