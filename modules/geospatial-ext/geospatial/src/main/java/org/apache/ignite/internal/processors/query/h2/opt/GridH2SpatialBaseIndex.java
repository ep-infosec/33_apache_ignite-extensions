/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.query.h2.opt;

import java.util.HashSet;
import org.h2.engine.Session;
import org.h2.index.IndexType;
import org.h2.index.SpatialIndex;
import org.h2.index.SpatialTreeIndex;
import org.h2.result.SearchRow;
import org.h2.result.SortOrder;
import org.h2.table.Column;
import org.h2.table.IndexColumn;
import org.h2.table.TableFilter;

/** Base class for Geo-Spatial indexes to register in the H2 engine. */
public abstract class GridH2SpatialBaseIndex extends GridH2IndexBase implements SpatialIndex {
    /**
     * Constructor.
     *
     * @param tbl  Table.
     * @param name Index name.
     * @param cols Indexed columns.
     * @param type Index type.
     */
    protected GridH2SpatialBaseIndex(GridH2Table tbl, String name, IndexColumn[] cols, IndexType type) {
        super(tbl, name, cols, type);
    }

    /** {@inheritDoc} */
    @Override public H2CacheRow put(H2CacheRow row) {
        throw new IllegalStateException("Must not be invoked.");
    }

    /** {@inheritDoc} */
    @Override public boolean putx(H2CacheRow row) {
        throw new IllegalStateException("Must not be invoked.");
    }

    /** {@inheritDoc} */
    @Override public boolean removex(SearchRow row) {
        throw new IllegalStateException("Must not be invoked.");
    }

    /** {@inheritDoc} */
    @Override public double getCost(Session ses, int[] masks, TableFilter[] filters, int filter,
        SortOrder sortOrder, HashSet<Column> cols) {
        return SpatialTreeIndex.getCostRangeIndex(masks, columns) / 10d;
    }
}
