/*
 * Copyright 2014 Cloudera, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.kite.tricks;

import org.kitesdk.data.DatasetDescriptor;
import org.kitesdk.data.Datasets;
import org.kitesdk.data.Formats;


public class CreateParquetDatasetLike {

  private void clone(String dataset, String parquetDataset) {
    DatasetDescriptor avroDescriptor = Datasets.load(dataset)
        .getDataset().getDescriptor();

    DatasetDescriptor parquetDescriptor = 
        new DatasetDescriptor.Builder(avroDescriptor)
            .format(Formats.PARQUET).build();

    Datasets.create(parquetDataset, parquetDescriptor);
  }

  public static void main(String[] args) {
    new CreateParquetDatasetLike().clone(args[0], args[1]);
  }

}
