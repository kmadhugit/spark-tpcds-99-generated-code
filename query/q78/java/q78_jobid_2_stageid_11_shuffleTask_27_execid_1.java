/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private agg_FastHashMap agg_fastHashMap;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 025 */   private UnsafeRow filter_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 028 */   private UnsafeRow project_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 031 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 032 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 034 */   private UnsafeRow bhj_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 037 */   private UnsafeRow project_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 040 */   private UnsafeRow agg_result3;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 043 */   private int agg_value12;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 047 */
/* 048 */   public GeneratedIterator(Object[] references) {
/* 049 */     this.references = references;
/* 050 */   }
/* 051 */
/* 052 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 053 */     partitionIndex = index;
/* 054 */     this.inputs = inputs;
/* 055 */     wholestagecodegen_init_0();
/* 056 */     wholestagecodegen_init_1();
/* 057 */     wholestagecodegen_init_2();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     agg_initAgg = false;
/* 063 */
/* 064 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 065 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 066 */
/* 067 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 068 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 069 */     inputadapter_input = inputs[0];
/* 070 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 071 */     filter_result = new UnsafeRow(9);
/* 072 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 073 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 074 */     project_result = new UnsafeRow(6);
/* 075 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 076 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */   public class agg_FastHashMap {
/* 081 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 082 */     private int[] buckets;
/* 083 */     private int capacity = 1 << 16;
/* 084 */     private double loadFactor = 0.5;
/* 085 */     private int numBuckets = (int) (capacity / loadFactor);
/* 086 */     private int maxSteps = 2;
/* 087 */     private int numRows = 0;
/* 088 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 089 */     .add("ss_item_sk", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 090 */     .add("ss_customer_sk", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 091 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.LongType)
/* 092 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 093 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 094 */     private Object emptyVBase;
/* 095 */     private long emptyVOff;
/* 096 */     private int emptyVLen;
/* 097 */     private boolean isBatchFull = false;
/* 098 */
/* 099 */     public agg_FastHashMap(
/* 100 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 101 */       InternalRow emptyAggregationBuffer) {
/* 102 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 103 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 104 */
/* 105 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 106 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 107 */
/* 108 */       emptyVBase = emptyBuffer;
/* 109 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 110 */       emptyVLen = emptyBuffer.length;
/* 111 */
/* 112 */       buckets = new int[numBuckets];
/* 113 */       java.util.Arrays.fill(buckets, -1);
/* 114 */     }
/* 115 */
/* 116 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1, int agg_key2) {
/* 117 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 118 */       int step = 0;
/* 119 */       int idx = (int) h & (numBuckets - 1);
/* 120 */       while (step < maxSteps) {
/* 121 */         // Return bucket index if it's either an empty slot or already contains the key
/* 122 */         if (buckets[idx] == -1) {
/* 123 */           if (numRows < capacity && !isBatchFull) {
/* 124 */             // creating the unsafe for new entry
/* 125 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 126 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 127 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 128 */               0);
/* 129 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 130 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 131 */               agg_holder,
/* 132 */               3);
/* 133 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 134 */             agg_rowWriter.zeroOutNullBytes();
/* 135 */             agg_rowWriter.write(0, agg_key);
/* 136 */             agg_rowWriter.write(1, agg_key1);
/* 137 */             agg_rowWriter.write(2, agg_key2);
/* 138 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 139 */             Object kbase = agg_result.getBaseObject();
/* 140 */             long koff = agg_result.getBaseOffset();
/* 141 */             int klen = agg_result.getSizeInBytes();
/* 142 */
/* 143 */             UnsafeRow vRow
/* 144 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 145 */             if (vRow == null) {
/* 146 */               isBatchFull = true;
/* 147 */             } else {
/* 148 */               buckets[idx] = numRows++;
/* 149 */             }
/* 150 */             return vRow;
/* 151 */           } else {
/* 152 */             // No more space
/* 153 */             return null;
/* 154 */           }
/* 155 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 156 */           return batch.getValueRow(buckets[idx]);
/* 157 */         }
/* 158 */         idx = (idx + 1) & (numBuckets - 1);
/* 159 */         step++;
/* 160 */       }
/* 161 */       // Didn't find it
/* 162 */       return null;
/* 163 */     }
/* 164 */
/* 165 */     private boolean equals(int idx, int agg_key, int agg_key1, int agg_key2) {
/* 166 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 167 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2);
/* 168 */     }
/* 169 */
/* 170 */     private long hash(int agg_key, int agg_key1, int agg_key2) {
/* 171 */       long agg_hash = 0;
/* 172 */
/* 173 */       int agg_result = agg_key;
/* 174 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 175 */
/* 176 */       int agg_result1 = agg_key1;
/* 177 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 178 */
/* 179 */       int agg_result2 = agg_key2;
/* 180 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 181 */
/* 182 */       return agg_hash;
/* 183 */     }
/* 184 */
/* 185 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 186 */       return batch.rowIterator();
/* 187 */     }
/* 188 */
/* 189 */     public void close() {
/* 190 */       batch.close();
/* 191 */     }
/* 192 */
/* 193 */   }
/* 194 */
/* 195 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 196 */     agg_hashMap = agg_plan.createHashMap();
/* 197 */
/* 198 */     while (inputadapter_input.hasNext()) {
/* 199 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 200 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 201 */       long inputadapter_value8 = inputadapter_isNull8 ? -1L : (inputadapter_row.getLong(8));
/* 202 */
/* 203 */       if (!inputadapter_isNull8) continue;
/* 204 */
/* 205 */       filter_numOutputRows.add(1);
/* 206 */
/* 207 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 208 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 209 */
/* 210 */       // generate join key for stream side
/* 211 */
/* 212 */       boolean bhj_isNull = inputadapter_isNull6;
/* 213 */       long bhj_value = -1L;
/* 214 */       if (!inputadapter_isNull6) {
/* 215 */         bhj_value = (long) inputadapter_value6;
/* 216 */       }
/* 217 */       // find matches from HashedRelation
/* 218 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 219 */       if (bhj_matched == null) continue;
/* 220 */
/* 221 */       bhj_numOutputRows.add(1);
/* 222 */
/* 223 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 224 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 225 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 226 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 227 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 228 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 229 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 230 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 231 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 232 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 233 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 234 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 235 */
/* 236 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 237 */
/* 238 */       UnsafeRow agg_fastAggBuffer = null;
/* 239 */
/* 240 */       if (true) {
/* 241 */         if (!bhj_isNull3 && !inputadapter_isNull && !inputadapter_isNull1) {
/* 242 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 243 */             bhj_value3, inputadapter_value, inputadapter_value1);
/* 244 */         }
/* 245 */       }
/* 246 */
/* 247 */       if (agg_fastAggBuffer == null) {
/* 248 */         // generate grouping key
/* 249 */         agg_rowWriter.zeroOutNullBytes();
/* 250 */
/* 251 */         if (bhj_isNull3) {
/* 252 */           agg_rowWriter.setNullAt(0);
/* 253 */         } else {
/* 254 */           agg_rowWriter.write(0, bhj_value3);
/* 255 */         }
/* 256 */
/* 257 */         if (inputadapter_isNull) {
/* 258 */           agg_rowWriter.setNullAt(1);
/* 259 */         } else {
/* 260 */           agg_rowWriter.write(1, inputadapter_value);
/* 261 */         }
/* 262 */
/* 263 */         if (inputadapter_isNull1) {
/* 264 */           agg_rowWriter.setNullAt(2);
/* 265 */         } else {
/* 266 */           agg_rowWriter.write(2, inputadapter_value1);
/* 267 */         }
/* 268 */         agg_value12 = 42;
/* 269 */
/* 270 */         if (!bhj_isNull3) {
/* 271 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value12);
/* 272 */         }
/* 273 */
/* 274 */         if (!inputadapter_isNull) {
/* 275 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 276 */         }
/* 277 */
/* 278 */         if (!inputadapter_isNull1) {
/* 279 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 280 */         }
/* 281 */         if (true) {
/* 282 */           // try to get the buffer from hash map
/* 283 */           agg_unsafeRowAggBuffer =
/* 284 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 285 */         }
/* 286 */         if (agg_unsafeRowAggBuffer == null) {
/* 287 */           if (agg_sorter == null) {
/* 288 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 289 */           } else {
/* 290 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 291 */           }
/* 292 */
/* 293 */           // the hash map had be spilled, it should have enough memory now,
/* 294 */           // try  to allocate buffer again.
/* 295 */           agg_unsafeRowAggBuffer =
/* 296 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 297 */           if (agg_unsafeRowAggBuffer == null) {
/* 298 */             // failed to allocate the first page
/* 299 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 300 */           }
/* 301 */         }
/* 302 */       }
/* 303 */
/* 304 */       if (agg_fastAggBuffer != null) {
/* 305 */         // update fast row
/* 306 */
/* 307 */         // common sub-expressions
/* 308 */         boolean agg_isNull39 = false;
/* 309 */         double agg_value42 = -1.0;
/* 310 */         if (!false) {
/* 311 */           agg_value42 = (double) 0;
/* 312 */         }
/* 313 */         // evaluate aggregate function
/* 314 */         boolean agg_isNull42 = true;
/* 315 */         long agg_value45 = -1L;
/* 316 */
/* 317 */         boolean agg_isNull44 = agg_fastAggBuffer.isNullAt(0);
/* 318 */         long agg_value47 = agg_isNull44 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 319 */         boolean agg_isNull43 = agg_isNull44;
/* 320 */         long agg_value46 = agg_value47;
/* 321 */         if (agg_isNull43) {
/* 322 */           boolean agg_isNull45 = false;
/* 323 */           long agg_value48 = -1L;
/* 324 */           if (!false) {
/* 325 */             agg_value48 = (long) 0;
/* 326 */           }
/* 327 */           if (!agg_isNull45) {
/* 328 */             agg_isNull43 = false;
/* 329 */             agg_value46 = agg_value48;
/* 330 */           }
/* 331 */         }
/* 332 */
/* 333 */         boolean agg_isNull48 = inputadapter_isNull3;
/* 334 */         long agg_value51 = -1L;
/* 335 */         if (!inputadapter_isNull3) {
/* 336 */           agg_value51 = (long) inputadapter_value3;
/* 337 */         }
/* 338 */         boolean agg_isNull47 = agg_isNull48;
/* 339 */         long agg_value50 = -1L;
/* 340 */         if (!agg_isNull48) {
/* 341 */           agg_value50 = agg_value51;
/* 342 */         }
/* 343 */         if (!agg_isNull47) {
/* 344 */           agg_isNull42 = false; // resultCode could change nullability.
/* 345 */           agg_value45 = agg_value46 + agg_value50;
/* 346 */
/* 347 */         }
/* 348 */         boolean agg_isNull41 = agg_isNull42;
/* 349 */         long agg_value44 = agg_value45;
/* 350 */         if (agg_isNull41) {
/* 351 */           boolean agg_isNull50 = agg_fastAggBuffer.isNullAt(0);
/* 352 */           long agg_value53 = agg_isNull50 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 353 */           if (!agg_isNull50) {
/* 354 */             agg_isNull41 = false;
/* 355 */             agg_value44 = agg_value53;
/* 356 */           }
/* 357 */         }
/* 358 */         boolean agg_isNull52 = true;
/* 359 */         double agg_value55 = -1.0;
/* 360 */
/* 361 */         boolean agg_isNull54 = agg_fastAggBuffer.isNullAt(1);
/* 362 */         double agg_value57 = agg_isNull54 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 363 */         boolean agg_isNull53 = agg_isNull54;
/* 364 */         double agg_value56 = agg_value57;
/* 365 */         if (agg_isNull53) {
/* 366 */           if (!agg_isNull39) {
/* 367 */             agg_isNull53 = false;
/* 368 */             agg_value56 = agg_value42;
/* 369 */           }
/* 370 */         }
/* 371 */
/* 372 */         boolean agg_isNull55 = inputadapter_isNull4;
/* 373 */         double agg_value58 = -1.0;
/* 374 */         if (!inputadapter_isNull4) {
/* 375 */           agg_value58 = inputadapter_value4;
/* 376 */         }
/* 377 */         if (!agg_isNull55) {
/* 378 */           agg_isNull52 = false; // resultCode could change nullability.
/* 379 */           agg_value55 = agg_value56 + agg_value58;
/* 380 */
/* 381 */         }
/* 382 */         boolean agg_isNull51 = agg_isNull52;
/* 383 */         double agg_value54 = agg_value55;
/* 384 */         if (agg_isNull51) {
/* 385 */           boolean agg_isNull57 = agg_fastAggBuffer.isNullAt(1);
/* 386 */           double agg_value60 = agg_isNull57 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 387 */           if (!agg_isNull57) {
/* 388 */             agg_isNull51 = false;
/* 389 */             agg_value54 = agg_value60;
/* 390 */           }
/* 391 */         }
/* 392 */         boolean agg_isNull59 = true;
/* 393 */         double agg_value62 = -1.0;
/* 394 */
/* 395 */         boolean agg_isNull61 = agg_fastAggBuffer.isNullAt(2);
/* 396 */         double agg_value64 = agg_isNull61 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 397 */         boolean agg_isNull60 = agg_isNull61;
/* 398 */         double agg_value63 = agg_value64;
/* 399 */         if (agg_isNull60) {
/* 400 */           if (!agg_isNull39) {
/* 401 */             agg_isNull60 = false;
/* 402 */             agg_value63 = agg_value42;
/* 403 */           }
/* 404 */         }
/* 405 */
/* 406 */         boolean agg_isNull62 = inputadapter_isNull5;
/* 407 */         double agg_value65 = -1.0;
/* 408 */         if (!inputadapter_isNull5) {
/* 409 */           agg_value65 = inputadapter_value5;
/* 410 */         }
/* 411 */         if (!agg_isNull62) {
/* 412 */           agg_isNull59 = false; // resultCode could change nullability.
/* 413 */           agg_value62 = agg_value63 + agg_value65;
/* 414 */
/* 415 */         }
/* 416 */         boolean agg_isNull58 = agg_isNull59;
/* 417 */         double agg_value61 = agg_value62;
/* 418 */         if (agg_isNull58) {
/* 419 */           boolean agg_isNull64 = agg_fastAggBuffer.isNullAt(2);
/* 420 */           double agg_value67 = agg_isNull64 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 421 */           if (!agg_isNull64) {
/* 422 */             agg_isNull58 = false;
/* 423 */             agg_value61 = agg_value67;
/* 424 */           }
/* 425 */         }
/* 426 */         // update fast row
/* 427 */         if (!agg_isNull41) {
/* 428 */           agg_fastAggBuffer.setLong(0, agg_value44);
/* 429 */         } else {
/* 430 */           agg_fastAggBuffer.setNullAt(0);
/* 431 */         }
/* 432 */
/* 433 */         if (!agg_isNull51) {
/* 434 */           agg_fastAggBuffer.setDouble(1, agg_value54);
/* 435 */         } else {
/* 436 */           agg_fastAggBuffer.setNullAt(1);
/* 437 */         }
/* 438 */
/* 439 */         if (!agg_isNull58) {
/* 440 */           agg_fastAggBuffer.setDouble(2, agg_value61);
/* 441 */         } else {
/* 442 */           agg_fastAggBuffer.setNullAt(2);
/* 443 */         }
/* 444 */
/* 445 */       } else {
/* 446 */         // update unsafe row
/* 447 */
/* 448 */         // common sub-expressions
/* 449 */         boolean agg_isNull13 = false;
/* 450 */         double agg_value16 = -1.0;
/* 451 */         if (!false) {
/* 452 */           agg_value16 = (double) 0;
/* 453 */         }
/* 454 */         // evaluate aggregate function
/* 455 */         boolean agg_isNull16 = true;
/* 456 */         long agg_value19 = -1L;
/* 457 */
/* 458 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 459 */         long agg_value21 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 460 */         boolean agg_isNull17 = agg_isNull18;
/* 461 */         long agg_value20 = agg_value21;
/* 462 */         if (agg_isNull17) {
/* 463 */           boolean agg_isNull19 = false;
/* 464 */           long agg_value22 = -1L;
/* 465 */           if (!false) {
/* 466 */             agg_value22 = (long) 0;
/* 467 */           }
/* 468 */           if (!agg_isNull19) {
/* 469 */             agg_isNull17 = false;
/* 470 */             agg_value20 = agg_value22;
/* 471 */           }
/* 472 */         }
/* 473 */
/* 474 */         boolean agg_isNull22 = inputadapter_isNull3;
/* 475 */         long agg_value25 = -1L;
/* 476 */         if (!inputadapter_isNull3) {
/* 477 */           agg_value25 = (long) inputadapter_value3;
/* 478 */         }
/* 479 */         boolean agg_isNull21 = agg_isNull22;
/* 480 */         long agg_value24 = -1L;
/* 481 */         if (!agg_isNull22) {
/* 482 */           agg_value24 = agg_value25;
/* 483 */         }
/* 484 */         if (!agg_isNull21) {
/* 485 */           agg_isNull16 = false; // resultCode could change nullability.
/* 486 */           agg_value19 = agg_value20 + agg_value24;
/* 487 */
/* 488 */         }
/* 489 */         boolean agg_isNull15 = agg_isNull16;
/* 490 */         long agg_value18 = agg_value19;
/* 491 */         if (agg_isNull15) {
/* 492 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 493 */           long agg_value27 = agg_isNull24 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 494 */           if (!agg_isNull24) {
/* 495 */             agg_isNull15 = false;
/* 496 */             agg_value18 = agg_value27;
/* 497 */           }
/* 498 */         }
/* 499 */         boolean agg_isNull26 = true;
/* 500 */         double agg_value29 = -1.0;
/* 501 */
/* 502 */         boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 503 */         double agg_value31 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 504 */         boolean agg_isNull27 = agg_isNull28;
/* 505 */         double agg_value30 = agg_value31;
/* 506 */         if (agg_isNull27) {
/* 507 */           if (!agg_isNull13) {
/* 508 */             agg_isNull27 = false;
/* 509 */             agg_value30 = agg_value16;
/* 510 */           }
/* 511 */         }
/* 512 */
/* 513 */         boolean agg_isNull29 = inputadapter_isNull4;
/* 514 */         double agg_value32 = -1.0;
/* 515 */         if (!inputadapter_isNull4) {
/* 516 */           agg_value32 = inputadapter_value4;
/* 517 */         }
/* 518 */         if (!agg_isNull29) {
/* 519 */           agg_isNull26 = false; // resultCode could change nullability.
/* 520 */           agg_value29 = agg_value30 + agg_value32;
/* 521 */
/* 522 */         }
/* 523 */         boolean agg_isNull25 = agg_isNull26;
/* 524 */         double agg_value28 = agg_value29;
/* 525 */         if (agg_isNull25) {
/* 526 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 527 */           double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 528 */           if (!agg_isNull31) {
/* 529 */             agg_isNull25 = false;
/* 530 */             agg_value28 = agg_value34;
/* 531 */           }
/* 532 */         }
/* 533 */         boolean agg_isNull33 = true;
/* 534 */         double agg_value36 = -1.0;
/* 535 */
/* 536 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 537 */         double agg_value38 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 538 */         boolean agg_isNull34 = agg_isNull35;
/* 539 */         double agg_value37 = agg_value38;
/* 540 */         if (agg_isNull34) {
/* 541 */           if (!agg_isNull13) {
/* 542 */             agg_isNull34 = false;
/* 543 */             agg_value37 = agg_value16;
/* 544 */           }
/* 545 */         }
/* 546 */
/* 547 */         boolean agg_isNull36 = inputadapter_isNull5;
/* 548 */         double agg_value39 = -1.0;
/* 549 */         if (!inputadapter_isNull5) {
/* 550 */           agg_value39 = inputadapter_value5;
/* 551 */         }
/* 552 */         if (!agg_isNull36) {
/* 553 */           agg_isNull33 = false; // resultCode could change nullability.
/* 554 */           agg_value36 = agg_value37 + agg_value39;
/* 555 */
/* 556 */         }
/* 557 */         boolean agg_isNull32 = agg_isNull33;
/* 558 */         double agg_value35 = agg_value36;
/* 559 */         if (agg_isNull32) {
/* 560 */           boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 561 */           double agg_value41 = agg_isNull38 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 562 */           if (!agg_isNull38) {
/* 563 */             agg_isNull32 = false;
/* 564 */             agg_value35 = agg_value41;
/* 565 */           }
/* 566 */         }
/* 567 */         // update unsafe row buffer
/* 568 */         if (!agg_isNull15) {
/* 569 */           agg_unsafeRowAggBuffer.setLong(0, agg_value18);
/* 570 */         } else {
/* 571 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 572 */         }
/* 573 */
/* 574 */         if (!agg_isNull25) {
/* 575 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value28);
/* 576 */         } else {
/* 577 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 578 */         }
/* 579 */
/* 580 */         if (!agg_isNull32) {
/* 581 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value35);
/* 582 */         } else {
/* 583 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 584 */         }
/* 585 */
/* 586 */       }
/* 587 */       if (shouldStop()) return;
/* 588 */     }
/* 589 */
/* 590 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 591 */
/* 592 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 593 */   }
/* 594 */
/* 595 */   private void wholestagecodegen_init_2() {
/* 596 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 597 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 598 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 599 */
/* 600 */   }
/* 601 */
/* 602 */   private void wholestagecodegen_init_1() {
/* 603 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 604 */
/* 605 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 606 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 607 */
/* 608 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 609 */     bhj_result = new UnsafeRow(8);
/* 610 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 611 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 612 */     project_result1 = new UnsafeRow(6);
/* 613 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 614 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 615 */     agg_result3 = new UnsafeRow(3);
/* 616 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 617 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 618 */
/* 619 */   }
/* 620 */
/* 621 */   protected void processNext() throws java.io.IOException {
/* 622 */     if (!agg_initAgg) {
/* 623 */       agg_initAgg = true;
/* 624 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 625 */       agg_doAggregateWithKeys();
/* 626 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 627 */     }
/* 628 */
/* 629 */     // output the result
/* 630 */
/* 631 */     while (agg_fastHashMapIter.next()) {
/* 632 */       wholestagecodegen_numOutputRows.add(1);
/* 633 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 634 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 635 */
/* 636 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 637 */
/* 638 */       append(agg_resultRow);
/* 639 */
/* 640 */       if (shouldStop()) return;
/* 641 */     }
/* 642 */     agg_fastHashMap.close();
/* 643 */
/* 644 */     while (agg_mapIter.next()) {
/* 645 */       wholestagecodegen_numOutputRows.add(1);
/* 646 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 647 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 648 */
/* 649 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 650 */
/* 651 */       append(agg_resultRow);
/* 652 */
/* 653 */       if (shouldStop()) return;
/* 654 */     }
/* 655 */
/* 656 */     agg_mapIter.close();
/* 657 */     if (agg_sorter == null) {
/* 658 */       agg_hashMap.free();
/* 659 */     }
/* 660 */   }
/* 661 */ }
