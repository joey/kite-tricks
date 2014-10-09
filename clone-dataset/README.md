clone-dataset
===========

Create a Hive table in Parquet format that is like an existing Avro table:
```bash
cp /etc/hive/conf/hive-site.xml src/main/resources
cp /etc/hadoop/conf/core-site.xml src/main/resources
mvn compile
mvn exec:java -Dexec.mainClass="com.cloudera.kite.tricks.CreateParquetDatasetLike" -Dexec.arguments="dataset:hive?dataset=avrotable,dataset:hive?dataset=parquettable" -Dexec.classpathScope=compile
```
