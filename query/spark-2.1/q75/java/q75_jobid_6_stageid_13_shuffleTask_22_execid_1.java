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
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private agg_FastHashMap agg_fastHashMap;
/* 015 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private boolean agg_initAgg1;
/* 022 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 023 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 024 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 028 */   private scala.collection.Iterator inputadapter_input;
/* 029 */   private UnsafeRow agg_result5;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 032 */   private int agg_value18;
/* 033 */   private UnsafeRow agg_result6;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 036 */   private UnsafeRow agg_result7;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 039 */   private int agg_value50;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     wholestagecodegen_init_0();
/* 054 */     wholestagecodegen_init_1();
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void wholestagecodegen_init_0() {
/* 059 */     agg_initAgg = false;
/* 060 */
/* 061 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 062 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 063 */
/* 064 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 065 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 066 */     agg_initAgg1 = false;
/* 067 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[3];
/* 068 */
/* 069 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 070 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 071 */     inputadapter_input = inputs[0];
/* 072 */     agg_result5 = new UnsafeRow(7);
/* 073 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 0);
/* 074 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 7);
/* 075 */
/* 076 */     agg_result6 = new UnsafeRow(7);
/* 077 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 0);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   public class agg_FastHashMap {
/* 082 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 083 */     private int[] buckets;
/* 084 */     private int capacity = 1 << 16;
/* 085 */     private double loadFactor = 0.5;
/* 086 */     private int numBuckets = (int) (capacity / loadFactor);
/* 087 */     private int maxSteps = 2;
/* 088 */     private int numRows = 0;
/* 089 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 090 */     .add("i_brand_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 091 */     .add("i_class_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 092 */     .add("i_category_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 093 */     .add("i_manufact_id", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 094 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.LongType)
/* 095 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 096 */     private Object emptyVBase;
/* 097 */     private long emptyVOff;
/* 098 */     private int emptyVLen;
/* 099 */     private boolean isBatchFull = false;
/* 100 */
/* 101 */     public agg_FastHashMap(
/* 102 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 103 */       InternalRow emptyAggregationBuffer) {
/* 104 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 105 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 106 */
/* 107 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 108 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 109 */
/* 110 */       emptyVBase = emptyBuffer;
/* 111 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 112 */       emptyVLen = emptyBuffer.length;
/* 113 */
/* 114 */       buckets = new int[numBuckets];
/* 115 */       java.util.Arrays.fill(buckets, -1);
/* 116 */     }
/* 117 */
/* 118 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1, int agg_key2, int agg_key3, int agg_key4) {
/* 119 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 120 */       int step = 0;
/* 121 */       int idx = (int) h & (numBuckets - 1);
/* 122 */       while (step < maxSteps) {
/* 123 */         // Return bucket index if it's either an empty slot or already contains the key
/* 124 */         if (buckets[idx] == -1) {
/* 125 */           if (numRows < capacity && !isBatchFull) {
/* 126 */             // creating the unsafe for new entry
/* 127 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 128 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 129 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 130 */               0);
/* 131 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 132 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 133 */               agg_holder,
/* 134 */               5);
/* 135 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 136 */             agg_rowWriter.zeroOutNullBytes();
/* 137 */             agg_rowWriter.write(0, agg_key);
/* 138 */             agg_rowWriter.write(1, agg_key1);
/* 139 */             agg_rowWriter.write(2, agg_key2);
/* 140 */             agg_rowWriter.write(3, agg_key3);
/* 141 */             agg_rowWriter.write(4, agg_key4);
/* 142 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 143 */             Object kbase = agg_result.getBaseObject();
/* 144 */             long koff = agg_result.getBaseOffset();
/* 145 */             int klen = agg_result.getSizeInBytes();
/* 146 */
/* 147 */             UnsafeRow vRow
/* 148 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 149 */             if (vRow == null) {
/* 150 */               isBatchFull = true;
/* 151 */             } else {
/* 152 */               buckets[idx] = numRows++;
/* 153 */             }
/* 154 */             return vRow;
/* 155 */           } else {
/* 156 */             // No more space
/* 157 */             return null;
/* 158 */           }
/* 159 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 160 */           return batch.getValueRow(buckets[idx]);
/* 161 */         }
/* 162 */         idx = (idx + 1) & (numBuckets - 1);
/* 163 */         step++;
/* 164 */       }
/* 165 */       // Didn't find it
/* 166 */       return null;
/* 167 */     }
/* 168 */
/* 169 */     private boolean equals(int idx, int agg_key, int agg_key1, int agg_key2, int agg_key3, int agg_key4) {
/* 170 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 171 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getInt(3) == agg_key3) && (row.getInt(4) == agg_key4);
/* 172 */     }
/* 173 */
/* 174 */     private long hash(int agg_key, int agg_key1, int agg_key2, int agg_key3, int agg_key4) {
/* 175 */       long agg_hash = 0;
/* 176 */
/* 177 */       int agg_result = agg_key;
/* 178 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 179 */
/* 180 */       int agg_result1 = agg_key1;
/* 181 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 182 */
/* 183 */       int agg_result2 = agg_key2;
/* 184 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 185 */
/* 186 */       int agg_result3 = agg_key3;
/* 187 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 188 */
/* 189 */       int agg_result4 = agg_key4;
/* 190 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 191 */
/* 192 */       return agg_hash;
/* 193 */     }
/* 194 */
/* 195 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 196 */       return batch.rowIterator();
/* 197 */     }
/* 198 */
/* 199 */     public void close() {
/* 200 */       batch.close();
/* 201 */     }
/* 202 */
/* 203 */   }
/* 204 */
/* 205 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 206 */     agg_hashMap = agg_plan.createHashMap();
/* 207 */
/* 208 */     if (!agg_initAgg1) {
/* 209 */       agg_initAgg1 = true;
/* 210 */       long agg_beforeAgg = System.nanoTime();
/* 211 */       agg_doAggregateWithKeys1();
/* 212 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 213 */     }
/* 214 */
/* 215 */     // output the result
/* 216 */
/* 217 */     while (agg_mapIter1.next()) {
/* 218 */       agg_numOutputRows.add(1);
/* 219 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 220 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 221 */
/* 222 */       boolean agg_isNull24 = agg_aggKey.isNullAt(0);
/* 223 */       int agg_value26 = agg_isNull24 ? -1 : (agg_aggKey.getInt(0));
/* 224 */       boolean agg_isNull25 = agg_aggKey.isNullAt(1);
/* 225 */       int agg_value27 = agg_isNull25 ? -1 : (agg_aggKey.getInt(1));
/* 226 */       boolean agg_isNull26 = agg_aggKey.isNullAt(2);
/* 227 */       int agg_value28 = agg_isNull26 ? -1 : (agg_aggKey.getInt(2));
/* 228 */       boolean agg_isNull27 = agg_aggKey.isNullAt(3);
/* 229 */       int agg_value29 = agg_isNull27 ? -1 : (agg_aggKey.getInt(3));
/* 230 */       boolean agg_isNull28 = agg_aggKey.isNullAt(4);
/* 231 */       int agg_value30 = agg_isNull28 ? -1 : (agg_aggKey.getInt(4));
/* 232 */       boolean agg_isNull29 = agg_aggKey.isNullAt(5);
/* 233 */       long agg_value31 = agg_isNull29 ? -1L : (agg_aggKey.getLong(5));
/* 234 */       boolean agg_isNull30 = agg_aggKey.isNullAt(6);
/* 235 */       double agg_value32 = agg_isNull30 ? -1.0 : (agg_aggKey.getDouble(6));
/* 236 */
/* 237 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 238 */
/* 239 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 240 */
/* 241 */       if (true) {
/* 242 */         if (!agg_isNull24 && !agg_isNull25 && !agg_isNull26 && !agg_isNull27 && !agg_isNull28) {
/* 243 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 244 */             agg_value26, agg_value27, agg_value28, agg_value29, agg_value30);
/* 245 */         }
/* 246 */       }
/* 247 */
/* 248 */       if (agg_fastAggBuffer1 == null) {
/* 249 */         // generate grouping key
/* 250 */         agg_rowWriter2.zeroOutNullBytes();
/* 251 */
/* 252 */         if (agg_isNull24) {
/* 253 */           agg_rowWriter2.setNullAt(0);
/* 254 */         } else {
/* 255 */           agg_rowWriter2.write(0, agg_value26);
/* 256 */         }
/* 257 */
/* 258 */         if (agg_isNull25) {
/* 259 */           agg_rowWriter2.setNullAt(1);
/* 260 */         } else {
/* 261 */           agg_rowWriter2.write(1, agg_value27);
/* 262 */         }
/* 263 */
/* 264 */         if (agg_isNull26) {
/* 265 */           agg_rowWriter2.setNullAt(2);
/* 266 */         } else {
/* 267 */           agg_rowWriter2.write(2, agg_value28);
/* 268 */         }
/* 269 */
/* 270 */         if (agg_isNull27) {
/* 271 */           agg_rowWriter2.setNullAt(3);
/* 272 */         } else {
/* 273 */           agg_rowWriter2.write(3, agg_value29);
/* 274 */         }
/* 275 */
/* 276 */         if (agg_isNull28) {
/* 277 */           agg_rowWriter2.setNullAt(4);
/* 278 */         } else {
/* 279 */           agg_rowWriter2.write(4, agg_value30);
/* 280 */         }
/* 281 */         agg_value50 = 42;
/* 282 */
/* 283 */         if (!agg_isNull24) {
/* 284 */           agg_value50 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value26, agg_value50);
/* 285 */         }
/* 286 */
/* 287 */         if (!agg_isNull25) {
/* 288 */           agg_value50 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value27, agg_value50);
/* 289 */         }
/* 290 */
/* 291 */         if (!agg_isNull26) {
/* 292 */           agg_value50 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value28, agg_value50);
/* 293 */         }
/* 294 */
/* 295 */         if (!agg_isNull27) {
/* 296 */           agg_value50 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value29, agg_value50);
/* 297 */         }
/* 298 */
/* 299 */         if (!agg_isNull28) {
/* 300 */           agg_value50 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value30, agg_value50);
/* 301 */         }
/* 302 */         if (true) {
/* 303 */           // try to get the buffer from hash map
/* 304 */           agg_unsafeRowAggBuffer1 =
/* 305 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result7, agg_value50);
/* 306 */         }
/* 307 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 308 */           if (agg_sorter == null) {
/* 309 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 310 */           } else {
/* 311 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 312 */           }
/* 313 */
/* 314 */           // the hash map had be spilled, it should have enough memory now,
/* 315 */           // try  to allocate buffer again.
/* 316 */           agg_unsafeRowAggBuffer1 =
/* 317 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result7, agg_value50);
/* 318 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 319 */             // failed to allocate the first page
/* 320 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 321 */           }
/* 322 */         }
/* 323 */       }
/* 324 */
/* 325 */       if (agg_fastAggBuffer1 != null) {
/* 326 */         // update fast row
/* 327 */
/* 328 */         // common sub-expressions
/* 329 */
/* 330 */         // evaluate aggregate function
/* 331 */         boolean agg_isNull73 = true;
/* 332 */         long agg_value75 = -1L;
/* 333 */
/* 334 */         boolean agg_isNull75 = agg_fastAggBuffer1.isNullAt(0);
/* 335 */         long agg_value77 = agg_isNull75 ? -1L : (agg_fastAggBuffer1.getLong(0));
/* 336 */         boolean agg_isNull74 = agg_isNull75;
/* 337 */         long agg_value76 = agg_value77;
/* 338 */         if (agg_isNull74) {
/* 339 */           boolean agg_isNull76 = false;
/* 340 */           long agg_value78 = -1L;
/* 341 */           if (!false) {
/* 342 */             agg_value78 = (long) 0;
/* 343 */           }
/* 344 */           if (!agg_isNull76) {
/* 345 */             agg_isNull74 = false;
/* 346 */             agg_value76 = agg_value78;
/* 347 */           }
/* 348 */         }
/* 349 */
/* 350 */         boolean agg_isNull78 = agg_isNull29;
/* 351 */         long agg_value80 = -1L;
/* 352 */         if (!agg_isNull29) {
/* 353 */           agg_value80 = agg_value31;
/* 354 */         }
/* 355 */         if (!agg_isNull78) {
/* 356 */           agg_isNull73 = false; // resultCode could change nullability.
/* 357 */           agg_value75 = agg_value76 + agg_value80;
/* 358 */
/* 359 */         }
/* 360 */         boolean agg_isNull72 = agg_isNull73;
/* 361 */         long agg_value74 = agg_value75;
/* 362 */         if (agg_isNull72) {
/* 363 */           boolean agg_isNull80 = agg_fastAggBuffer1.isNullAt(0);
/* 364 */           long agg_value82 = agg_isNull80 ? -1L : (agg_fastAggBuffer1.getLong(0));
/* 365 */           if (!agg_isNull80) {
/* 366 */             agg_isNull72 = false;
/* 367 */             agg_value74 = agg_value82;
/* 368 */           }
/* 369 */         }
/* 370 */         boolean agg_isNull82 = true;
/* 371 */         double agg_value84 = -1.0;
/* 372 */
/* 373 */         boolean agg_isNull84 = agg_fastAggBuffer1.isNullAt(1);
/* 374 */         double agg_value86 = agg_isNull84 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 375 */         boolean agg_isNull83 = agg_isNull84;
/* 376 */         double agg_value85 = agg_value86;
/* 377 */         if (agg_isNull83) {
/* 378 */           boolean agg_isNull85 = false;
/* 379 */           double agg_value87 = -1.0;
/* 380 */           if (!false) {
/* 381 */             agg_value87 = (double) 0;
/* 382 */           }
/* 383 */           if (!agg_isNull85) {
/* 384 */             agg_isNull83 = false;
/* 385 */             agg_value85 = agg_value87;
/* 386 */           }
/* 387 */         }
/* 388 */
/* 389 */         boolean agg_isNull87 = agg_isNull30;
/* 390 */         double agg_value89 = -1.0;
/* 391 */         if (!agg_isNull30) {
/* 392 */           agg_value89 = agg_value32;
/* 393 */         }
/* 394 */         if (!agg_isNull87) {
/* 395 */           agg_isNull82 = false; // resultCode could change nullability.
/* 396 */           agg_value84 = agg_value85 + agg_value89;
/* 397 */
/* 398 */         }
/* 399 */         boolean agg_isNull81 = agg_isNull82;
/* 400 */         double agg_value83 = agg_value84;
/* 401 */         if (agg_isNull81) {
/* 402 */           boolean agg_isNull89 = agg_fastAggBuffer1.isNullAt(1);
/* 403 */           double agg_value91 = agg_isNull89 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 404 */           if (!agg_isNull89) {
/* 405 */             agg_isNull81 = false;
/* 406 */             agg_value83 = agg_value91;
/* 407 */           }
/* 408 */         }
/* 409 */         // update fast row
/* 410 */         if (!agg_isNull72) {
/* 411 */           agg_fastAggBuffer1.setLong(0, agg_value74);
/* 412 */         } else {
/* 413 */           agg_fastAggBuffer1.setNullAt(0);
/* 414 */         }
/* 415 */
/* 416 */         if (!agg_isNull81) {
/* 417 */           agg_fastAggBuffer1.setDouble(1, agg_value83);
/* 418 */         } else {
/* 419 */           agg_fastAggBuffer1.setNullAt(1);
/* 420 */         }
/* 421 */
/* 422 */       } else {
/* 423 */         // update unsafe row
/* 424 */
/* 425 */         // common sub-expressions
/* 426 */
/* 427 */         // evaluate aggregate function
/* 428 */         boolean agg_isNull55 = true;
/* 429 */         long agg_value57 = -1L;
/* 430 */
/* 431 */         boolean agg_isNull57 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 432 */         long agg_value59 = agg_isNull57 ? -1L : (agg_unsafeRowAggBuffer1.getLong(0));
/* 433 */         boolean agg_isNull56 = agg_isNull57;
/* 434 */         long agg_value58 = agg_value59;
/* 435 */         if (agg_isNull56) {
/* 436 */           boolean agg_isNull58 = false;
/* 437 */           long agg_value60 = -1L;
/* 438 */           if (!false) {
/* 439 */             agg_value60 = (long) 0;
/* 440 */           }
/* 441 */           if (!agg_isNull58) {
/* 442 */             agg_isNull56 = false;
/* 443 */             agg_value58 = agg_value60;
/* 444 */           }
/* 445 */         }
/* 446 */
/* 447 */         boolean agg_isNull60 = agg_isNull29;
/* 448 */         long agg_value62 = -1L;
/* 449 */         if (!agg_isNull29) {
/* 450 */           agg_value62 = agg_value31;
/* 451 */         }
/* 452 */         if (!agg_isNull60) {
/* 453 */           agg_isNull55 = false; // resultCode could change nullability.
/* 454 */           agg_value57 = agg_value58 + agg_value62;
/* 455 */
/* 456 */         }
/* 457 */         boolean agg_isNull54 = agg_isNull55;
/* 458 */         long agg_value56 = agg_value57;
/* 459 */         if (agg_isNull54) {
/* 460 */           boolean agg_isNull62 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 461 */           long agg_value64 = agg_isNull62 ? -1L : (agg_unsafeRowAggBuffer1.getLong(0));
/* 462 */           if (!agg_isNull62) {
/* 463 */             agg_isNull54 = false;
/* 464 */             agg_value56 = agg_value64;
/* 465 */           }
/* 466 */         }
/* 467 */         boolean agg_isNull64 = true;
/* 468 */         double agg_value66 = -1.0;
/* 469 */
/* 470 */         boolean agg_isNull66 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 471 */         double agg_value68 = agg_isNull66 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 472 */         boolean agg_isNull65 = agg_isNull66;
/* 473 */         double agg_value67 = agg_value68;
/* 474 */         if (agg_isNull65) {
/* 475 */           boolean agg_isNull67 = false;
/* 476 */           double agg_value69 = -1.0;
/* 477 */           if (!false) {
/* 478 */             agg_value69 = (double) 0;
/* 479 */           }
/* 480 */           if (!agg_isNull67) {
/* 481 */             agg_isNull65 = false;
/* 482 */             agg_value67 = agg_value69;
/* 483 */           }
/* 484 */         }
/* 485 */
/* 486 */         boolean agg_isNull69 = agg_isNull30;
/* 487 */         double agg_value71 = -1.0;
/* 488 */         if (!agg_isNull30) {
/* 489 */           agg_value71 = agg_value32;
/* 490 */         }
/* 491 */         if (!agg_isNull69) {
/* 492 */           agg_isNull64 = false; // resultCode could change nullability.
/* 493 */           agg_value66 = agg_value67 + agg_value71;
/* 494 */
/* 495 */         }
/* 496 */         boolean agg_isNull63 = agg_isNull64;
/* 497 */         double agg_value65 = agg_value66;
/* 498 */         if (agg_isNull63) {
/* 499 */           boolean agg_isNull71 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 500 */           double agg_value73 = agg_isNull71 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 501 */           if (!agg_isNull71) {
/* 502 */             agg_isNull63 = false;
/* 503 */             agg_value65 = agg_value73;
/* 504 */           }
/* 505 */         }
/* 506 */         // update unsafe row buffer
/* 507 */         if (!agg_isNull54) {
/* 508 */           agg_unsafeRowAggBuffer1.setLong(0, agg_value56);
/* 509 */         } else {
/* 510 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 511 */         }
/* 512 */
/* 513 */         if (!agg_isNull63) {
/* 514 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value65);
/* 515 */         } else {
/* 516 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 517 */         }
/* 518 */
/* 519 */       }
/* 520 */
/* 521 */       if (shouldStop()) return;
/* 522 */     }
/* 523 */
/* 524 */     agg_mapIter1.close();
/* 525 */     if (agg_sorter1 == null) {
/* 526 */       agg_hashMap1.free();
/* 527 */     }
/* 528 */
/* 529 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 530 */
/* 531 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 532 */   }
/* 533 */
/* 534 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 535 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 536 */
/* 537 */     while (inputadapter_input.hasNext()) {
/* 538 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 539 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 540 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 541 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 542 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 543 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 544 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 545 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 546 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 547 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 548 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 549 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 550 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 551 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 552 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 553 */
/* 554 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 555 */
/* 556 */       UnsafeRow agg_fastAggBuffer = null;
/* 557 */
/* 558 */       if (agg_fastAggBuffer == null) {
/* 559 */         // generate grouping key
/* 560 */         agg_rowWriter.zeroOutNullBytes();
/* 561 */
/* 562 */         if (inputadapter_isNull) {
/* 563 */           agg_rowWriter.setNullAt(0);
/* 564 */         } else {
/* 565 */           agg_rowWriter.write(0, inputadapter_value);
/* 566 */         }
/* 567 */
/* 568 */         if (inputadapter_isNull1) {
/* 569 */           agg_rowWriter.setNullAt(1);
/* 570 */         } else {
/* 571 */           agg_rowWriter.write(1, inputadapter_value1);
/* 572 */         }
/* 573 */
/* 574 */         if (inputadapter_isNull2) {
/* 575 */           agg_rowWriter.setNullAt(2);
/* 576 */         } else {
/* 577 */           agg_rowWriter.write(2, inputadapter_value2);
/* 578 */         }
/* 579 */
/* 580 */         if (inputadapter_isNull3) {
/* 581 */           agg_rowWriter.setNullAt(3);
/* 582 */         } else {
/* 583 */           agg_rowWriter.write(3, inputadapter_value3);
/* 584 */         }
/* 585 */
/* 586 */         if (inputadapter_isNull4) {
/* 587 */           agg_rowWriter.setNullAt(4);
/* 588 */         } else {
/* 589 */           agg_rowWriter.write(4, inputadapter_value4);
/* 590 */         }
/* 591 */
/* 592 */         if (inputadapter_isNull5) {
/* 593 */           agg_rowWriter.setNullAt(5);
/* 594 */         } else {
/* 595 */           agg_rowWriter.write(5, inputadapter_value5);
/* 596 */         }
/* 597 */
/* 598 */         if (inputadapter_isNull6) {
/* 599 */           agg_rowWriter.setNullAt(6);
/* 600 */         } else {
/* 601 */           agg_rowWriter.write(6, inputadapter_value6);
/* 602 */         }
/* 603 */         agg_value18 = 42;
/* 604 */
/* 605 */         if (!inputadapter_isNull) {
/* 606 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value18);
/* 607 */         }
/* 608 */
/* 609 */         if (!inputadapter_isNull1) {
/* 610 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value18);
/* 611 */         }
/* 612 */
/* 613 */         if (!inputadapter_isNull2) {
/* 614 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value18);
/* 615 */         }
/* 616 */
/* 617 */         if (!inputadapter_isNull3) {
/* 618 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value18);
/* 619 */         }
/* 620 */
/* 621 */         if (!inputadapter_isNull4) {
/* 622 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value18);
/* 623 */         }
/* 624 */
/* 625 */         if (!inputadapter_isNull5) {
/* 626 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value5, agg_value18);
/* 627 */         }
/* 628 */
/* 629 */         if (!inputadapter_isNull6) {
/* 630 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value6), agg_value18);
/* 631 */         }
/* 632 */         if (true) {
/* 633 */           // try to get the buffer from hash map
/* 634 */           agg_unsafeRowAggBuffer =
/* 635 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result5, agg_value18);
/* 636 */         }
/* 637 */         if (agg_unsafeRowAggBuffer == null) {
/* 638 */           if (agg_sorter1 == null) {
/* 639 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 640 */           } else {
/* 641 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 642 */           }
/* 643 */
/* 644 */           // the hash map had be spilled, it should have enough memory now,
/* 645 */           // try  to allocate buffer again.
/* 646 */           agg_unsafeRowAggBuffer =
/* 647 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result5, agg_value18);
/* 648 */           if (agg_unsafeRowAggBuffer == null) {
/* 649 */             // failed to allocate the first page
/* 650 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 651 */           }
/* 652 */         }
/* 653 */       }
/* 654 */
/* 655 */       if (agg_fastAggBuffer != null) {
/* 656 */         // update fast row
/* 657 */
/* 658 */       } else {
/* 659 */         // update unsafe row
/* 660 */
/* 661 */         // common sub-expressions
/* 662 */
/* 663 */         // evaluate aggregate function
/* 664 */
/* 665 */         // update unsafe row buffer
/* 666 */
/* 667 */       }
/* 668 */       if (shouldStop()) return;
/* 669 */     }
/* 670 */
/* 671 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 672 */   }
/* 673 */
/* 674 */   private void wholestagecodegen_init_1() {
/* 675 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 676 */     agg_result7 = new UnsafeRow(5);
/* 677 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result7, 0);
/* 678 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 5);
/* 679 */
/* 680 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 681 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 682 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 683 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 684 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 685 */
/* 686 */   }
/* 687 */
/* 688 */   protected void processNext() throws java.io.IOException {
/* 689 */     if (!agg_initAgg) {
/* 690 */       agg_initAgg = true;
/* 691 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 692 */       agg_doAggregateWithKeys();
/* 693 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 694 */     }
/* 695 */
/* 696 */     // output the result
/* 697 */
/* 698 */     while (agg_fastHashMapIter.next()) {
/* 699 */       wholestagecodegen_numOutputRows.add(1);
/* 700 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 701 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 702 */
/* 703 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 704 */
/* 705 */       append(agg_resultRow);
/* 706 */
/* 707 */       if (shouldStop()) return;
/* 708 */     }
/* 709 */     agg_fastHashMap.close();
/* 710 */
/* 711 */     while (agg_mapIter.next()) {
/* 712 */       wholestagecodegen_numOutputRows.add(1);
/* 713 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 714 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 715 */
/* 716 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 717 */
/* 718 */       append(agg_resultRow);
/* 719 */
/* 720 */       if (shouldStop()) return;
/* 721 */     }
/* 722 */
/* 723 */     agg_mapIter.close();
/* 724 */     if (agg_sorter == null) {
/* 725 */       agg_hashMap.free();
/* 726 */     }
/* 727 */   }
/* 728 */ }
