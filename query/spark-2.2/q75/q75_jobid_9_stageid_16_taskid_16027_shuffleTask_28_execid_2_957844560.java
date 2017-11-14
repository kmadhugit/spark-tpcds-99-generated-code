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
/* 067 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[10];
/* 068 */
/* 069 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 070 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
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
/* 089 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 090 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 091 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 092 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 093 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 094 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.LongType)
/* 095 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 331 */         boolean agg_isNull71 = true;
/* 332 */         long agg_value73 = -1L;
/* 333 */
/* 334 */         boolean agg_isNull73 = agg_fastAggBuffer1.isNullAt(0);
/* 335 */         long agg_value75 = agg_isNull73 ? -1L : (agg_fastAggBuffer1.getLong(0));
/* 336 */         boolean agg_isNull72 = agg_isNull73;
/* 337 */         long agg_value74 = agg_value75;
/* 338 */         if (agg_isNull72) {
/* 339 */           boolean agg_isNull74 = false;
/* 340 */           long agg_value76 = -1L;
/* 341 */           if (!false) {
/* 342 */             agg_value76 = (long) 0;
/* 343 */           }
/* 344 */           if (!agg_isNull74) {
/* 345 */             agg_isNull72 = false;
/* 346 */             agg_value74 = agg_value76;
/* 347 */           }
/* 348 */         }
/* 349 */
/* 350 */         if (!agg_isNull29) {
/* 351 */           agg_isNull71 = false; // resultCode could change nullability.
/* 352 */           agg_value73 = agg_value74 + agg_value31;
/* 353 */
/* 354 */         }
/* 355 */         boolean agg_isNull70 = agg_isNull71;
/* 356 */         long agg_value72 = agg_value73;
/* 357 */         if (agg_isNull70) {
/* 358 */           boolean agg_isNull77 = agg_fastAggBuffer1.isNullAt(0);
/* 359 */           long agg_value79 = agg_isNull77 ? -1L : (agg_fastAggBuffer1.getLong(0));
/* 360 */           if (!agg_isNull77) {
/* 361 */             agg_isNull70 = false;
/* 362 */             agg_value72 = agg_value79;
/* 363 */           }
/* 364 */         }
/* 365 */         boolean agg_isNull79 = true;
/* 366 */         double agg_value81 = -1.0;
/* 367 */
/* 368 */         boolean agg_isNull81 = agg_fastAggBuffer1.isNullAt(1);
/* 369 */         double agg_value83 = agg_isNull81 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 370 */         boolean agg_isNull80 = agg_isNull81;
/* 371 */         double agg_value82 = agg_value83;
/* 372 */         if (agg_isNull80) {
/* 373 */           boolean agg_isNull82 = false;
/* 374 */           double agg_value84 = -1.0;
/* 375 */           if (!false) {
/* 376 */             agg_value84 = (double) 0;
/* 377 */           }
/* 378 */           if (!agg_isNull82) {
/* 379 */             agg_isNull80 = false;
/* 380 */             agg_value82 = agg_value84;
/* 381 */           }
/* 382 */         }
/* 383 */
/* 384 */         if (!agg_isNull30) {
/* 385 */           agg_isNull79 = false; // resultCode could change nullability.
/* 386 */           agg_value81 = agg_value82 + agg_value32;
/* 387 */
/* 388 */         }
/* 389 */         boolean agg_isNull78 = agg_isNull79;
/* 390 */         double agg_value80 = agg_value81;
/* 391 */         if (agg_isNull78) {
/* 392 */           boolean agg_isNull85 = agg_fastAggBuffer1.isNullAt(1);
/* 393 */           double agg_value87 = agg_isNull85 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 394 */           if (!agg_isNull85) {
/* 395 */             agg_isNull78 = false;
/* 396 */             agg_value80 = agg_value87;
/* 397 */           }
/* 398 */         }
/* 399 */         // update fast row
/* 400 */         if (!agg_isNull70) {
/* 401 */           agg_fastAggBuffer1.setLong(0, agg_value72);
/* 402 */         } else {
/* 403 */           agg_fastAggBuffer1.setNullAt(0);
/* 404 */         }
/* 405 */
/* 406 */         if (!agg_isNull78) {
/* 407 */           agg_fastAggBuffer1.setDouble(1, agg_value80);
/* 408 */         } else {
/* 409 */           agg_fastAggBuffer1.setNullAt(1);
/* 410 */         }
/* 411 */
/* 412 */       } else {
/* 413 */         // update unsafe row
/* 414 */
/* 415 */         // common sub-expressions
/* 416 */
/* 417 */         // evaluate aggregate function
/* 418 */         boolean agg_isNull55 = true;
/* 419 */         long agg_value57 = -1L;
/* 420 */
/* 421 */         boolean agg_isNull57 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 422 */         long agg_value59 = agg_isNull57 ? -1L : (agg_unsafeRowAggBuffer1.getLong(0));
/* 423 */         boolean agg_isNull56 = agg_isNull57;
/* 424 */         long agg_value58 = agg_value59;
/* 425 */         if (agg_isNull56) {
/* 426 */           boolean agg_isNull58 = false;
/* 427 */           long agg_value60 = -1L;
/* 428 */           if (!false) {
/* 429 */             agg_value60 = (long) 0;
/* 430 */           }
/* 431 */           if (!agg_isNull58) {
/* 432 */             agg_isNull56 = false;
/* 433 */             agg_value58 = agg_value60;
/* 434 */           }
/* 435 */         }
/* 436 */
/* 437 */         if (!agg_isNull29) {
/* 438 */           agg_isNull55 = false; // resultCode could change nullability.
/* 439 */           agg_value57 = agg_value58 + agg_value31;
/* 440 */
/* 441 */         }
/* 442 */         boolean agg_isNull54 = agg_isNull55;
/* 443 */         long agg_value56 = agg_value57;
/* 444 */         if (agg_isNull54) {
/* 445 */           boolean agg_isNull61 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 446 */           long agg_value63 = agg_isNull61 ? -1L : (agg_unsafeRowAggBuffer1.getLong(0));
/* 447 */           if (!agg_isNull61) {
/* 448 */             agg_isNull54 = false;
/* 449 */             agg_value56 = agg_value63;
/* 450 */           }
/* 451 */         }
/* 452 */         boolean agg_isNull63 = true;
/* 453 */         double agg_value65 = -1.0;
/* 454 */
/* 455 */         boolean agg_isNull65 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 456 */         double agg_value67 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 457 */         boolean agg_isNull64 = agg_isNull65;
/* 458 */         double agg_value66 = agg_value67;
/* 459 */         if (agg_isNull64) {
/* 460 */           boolean agg_isNull66 = false;
/* 461 */           double agg_value68 = -1.0;
/* 462 */           if (!false) {
/* 463 */             agg_value68 = (double) 0;
/* 464 */           }
/* 465 */           if (!agg_isNull66) {
/* 466 */             agg_isNull64 = false;
/* 467 */             agg_value66 = agg_value68;
/* 468 */           }
/* 469 */         }
/* 470 */
/* 471 */         if (!agg_isNull30) {
/* 472 */           agg_isNull63 = false; // resultCode could change nullability.
/* 473 */           agg_value65 = agg_value66 + agg_value32;
/* 474 */
/* 475 */         }
/* 476 */         boolean agg_isNull62 = agg_isNull63;
/* 477 */         double agg_value64 = agg_value65;
/* 478 */         if (agg_isNull62) {
/* 479 */           boolean agg_isNull69 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 480 */           double agg_value71 = agg_isNull69 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 481 */           if (!agg_isNull69) {
/* 482 */             agg_isNull62 = false;
/* 483 */             agg_value64 = agg_value71;
/* 484 */           }
/* 485 */         }
/* 486 */         // update unsafe row buffer
/* 487 */         if (!agg_isNull54) {
/* 488 */           agg_unsafeRowAggBuffer1.setLong(0, agg_value56);
/* 489 */         } else {
/* 490 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 491 */         }
/* 492 */
/* 493 */         if (!agg_isNull62) {
/* 494 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value64);
/* 495 */         } else {
/* 496 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 497 */         }
/* 498 */
/* 499 */       }
/* 500 */
/* 501 */       if (shouldStop()) return;
/* 502 */     }
/* 503 */
/* 504 */     agg_mapIter1.close();
/* 505 */     if (agg_sorter1 == null) {
/* 506 */       agg_hashMap1.free();
/* 507 */     }
/* 508 */
/* 509 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 510 */
/* 511 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 512 */   }
/* 513 */
/* 514 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 515 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 516 */
/* 517 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 518 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 519 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 520 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 521 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 522 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 523 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 524 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 525 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 526 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 527 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 528 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 529 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 530 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 531 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 532 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 533 */
/* 534 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 535 */
/* 536 */       UnsafeRow agg_fastAggBuffer = null;
/* 537 */
/* 538 */       if (agg_fastAggBuffer == null) {
/* 539 */         // generate grouping key
/* 540 */         agg_rowWriter.zeroOutNullBytes();
/* 541 */
/* 542 */         if (inputadapter_isNull) {
/* 543 */           agg_rowWriter.setNullAt(0);
/* 544 */         } else {
/* 545 */           agg_rowWriter.write(0, inputadapter_value);
/* 546 */         }
/* 547 */
/* 548 */         if (inputadapter_isNull1) {
/* 549 */           agg_rowWriter.setNullAt(1);
/* 550 */         } else {
/* 551 */           agg_rowWriter.write(1, inputadapter_value1);
/* 552 */         }
/* 553 */
/* 554 */         if (inputadapter_isNull2) {
/* 555 */           agg_rowWriter.setNullAt(2);
/* 556 */         } else {
/* 557 */           agg_rowWriter.write(2, inputadapter_value2);
/* 558 */         }
/* 559 */
/* 560 */         if (inputadapter_isNull3) {
/* 561 */           agg_rowWriter.setNullAt(3);
/* 562 */         } else {
/* 563 */           agg_rowWriter.write(3, inputadapter_value3);
/* 564 */         }
/* 565 */
/* 566 */         if (inputadapter_isNull4) {
/* 567 */           agg_rowWriter.setNullAt(4);
/* 568 */         } else {
/* 569 */           agg_rowWriter.write(4, inputadapter_value4);
/* 570 */         }
/* 571 */
/* 572 */         if (inputadapter_isNull5) {
/* 573 */           agg_rowWriter.setNullAt(5);
/* 574 */         } else {
/* 575 */           agg_rowWriter.write(5, inputadapter_value5);
/* 576 */         }
/* 577 */
/* 578 */         if (inputadapter_isNull6) {
/* 579 */           agg_rowWriter.setNullAt(6);
/* 580 */         } else {
/* 581 */           agg_rowWriter.write(6, inputadapter_value6);
/* 582 */         }
/* 583 */         agg_value18 = 42;
/* 584 */
/* 585 */         if (!inputadapter_isNull) {
/* 586 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value18);
/* 587 */         }
/* 588 */
/* 589 */         if (!inputadapter_isNull1) {
/* 590 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value18);
/* 591 */         }
/* 592 */
/* 593 */         if (!inputadapter_isNull2) {
/* 594 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value18);
/* 595 */         }
/* 596 */
/* 597 */         if (!inputadapter_isNull3) {
/* 598 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value18);
/* 599 */         }
/* 600 */
/* 601 */         if (!inputadapter_isNull4) {
/* 602 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value18);
/* 603 */         }
/* 604 */
/* 605 */         if (!inputadapter_isNull5) {
/* 606 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value5, agg_value18);
/* 607 */         }
/* 608 */
/* 609 */         if (!inputadapter_isNull6) {
/* 610 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value6), agg_value18);
/* 611 */         }
/* 612 */         if (true) {
/* 613 */           // try to get the buffer from hash map
/* 614 */           agg_unsafeRowAggBuffer =
/* 615 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result5, agg_value18);
/* 616 */         }
/* 617 */         if (agg_unsafeRowAggBuffer == null) {
/* 618 */           if (agg_sorter1 == null) {
/* 619 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 620 */           } else {
/* 621 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 622 */           }
/* 623 */
/* 624 */           // the hash map had be spilled, it should have enough memory now,
/* 625 */           // try  to allocate buffer again.
/* 626 */           agg_unsafeRowAggBuffer =
/* 627 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result5, agg_value18);
/* 628 */           if (agg_unsafeRowAggBuffer == null) {
/* 629 */             // failed to allocate the first page
/* 630 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 631 */           }
/* 632 */         }
/* 633 */       }
/* 634 */
/* 635 */       if (agg_fastAggBuffer != null) {
/* 636 */         // update fast row
/* 637 */
/* 638 */       } else {
/* 639 */         // update unsafe row
/* 640 */
/* 641 */         // common sub-expressions
/* 642 */
/* 643 */         // evaluate aggregate function
/* 644 */
/* 645 */         // update unsafe row buffer
/* 646 */
/* 647 */       }
/* 648 */       if (shouldStop()) return;
/* 649 */     }
/* 650 */
/* 651 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 652 */   }
/* 653 */
/* 654 */   private void wholestagecodegen_init_1() {
/* 655 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 656 */     agg_result7 = new UnsafeRow(5);
/* 657 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result7, 0);
/* 658 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 5);
/* 659 */
/* 660 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 661 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 662 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 663 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 664 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 665 */
/* 666 */   }
/* 667 */
/* 668 */   protected void processNext() throws java.io.IOException {
/* 669 */     if (!agg_initAgg) {
/* 670 */       agg_initAgg = true;
/* 671 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 672 */       agg_doAggregateWithKeys();
/* 673 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 674 */     }
/* 675 */
/* 676 */     // output the result
/* 677 */
/* 678 */     while (agg_fastHashMapIter.next()) {
/* 679 */       wholestagecodegen_numOutputRows.add(1);
/* 680 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 681 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 682 */
/* 683 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 684 */
/* 685 */       append(agg_resultRow);
/* 686 */
/* 687 */       if (shouldStop()) return;
/* 688 */     }
/* 689 */     agg_fastHashMap.close();
/* 690 */
/* 691 */     while (agg_mapIter.next()) {
/* 692 */       wholestagecodegen_numOutputRows.add(1);
/* 693 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 694 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 695 */
/* 696 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 697 */
/* 698 */       append(agg_resultRow);
/* 699 */
/* 700 */       if (shouldStop()) return;
/* 701 */     }
/* 702 */
/* 703 */     agg_mapIter.close();
/* 704 */     if (agg_sorter == null) {
/* 705 */       agg_hashMap.free();
/* 706 */     }
/* 707 */   }
/* 708 */ }
