/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private boolean agg_initAgg1;
/* 020 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 021 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 022 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 023 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 026 */   private scala.collection.Iterator inputadapter_input;
/* 027 */   private UnsafeRow agg_result1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 030 */   private int agg_value6;
/* 031 */   private UnsafeRow agg_result2;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 035 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 037 */   private UnsafeRow bhj_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 040 */   private UnsafeRow project_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 043 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 044 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 046 */   private UnsafeRow bhj_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 049 */   private UnsafeRow project_result1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 052 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 053 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation2;
/* 054 */   private UnsafeRow bhj_result2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 058 */   private UnsafeRow bhj_result3;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 061 */   private UnsafeRow project_result2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 064 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 065 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 067 */   private UnsafeRow bhj_result4;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 070 */   private UnsafeRow project_result3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 073 */   private UnsafeRow agg_result3;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 076 */   private int agg_value15;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 078 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 080 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 081 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 082 */
/* 083 */   public GeneratedIterator(Object[] references) {
/* 084 */     this.references = references;
/* 085 */   }
/* 086 */
/* 087 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 088 */     partitionIndex = index;
/* 089 */     this.inputs = inputs;
/* 090 */     wholestagecodegen_init_0();
/* 091 */     wholestagecodegen_init_1();
/* 092 */     wholestagecodegen_init_2();
/* 093 */     wholestagecodegen_init_3();
/* 094 */     wholestagecodegen_init_4();
/* 095 */     wholestagecodegen_init_5();
/* 096 */
/* 097 */   }
/* 098 */
/* 099 */   private void wholestagecodegen_init_0() {
/* 100 */     agg_initAgg = false;
/* 101 */
/* 102 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 103 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 104 */
/* 105 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 106 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 107 */     agg_initAgg1 = false;
/* 108 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[3];
/* 109 */
/* 110 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 111 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 112 */     inputadapter_input = inputs[0];
/* 113 */     agg_result1 = new UnsafeRow(2);
/* 114 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 115 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 116 */
/* 117 */     agg_result2 = new UnsafeRow(2);
/* 118 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 119 */
/* 120 */   }
/* 121 */
/* 122 */   private void wholestagecodegen_init_3() {
/* 123 */     bhj_result2 = new UnsafeRow(2);
/* 124 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 64);
/* 125 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 2);
/* 126 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 127 */     bhj_result3 = new UnsafeRow(7);
/* 128 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 128);
/* 129 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 7);
/* 130 */     project_result2 = new UnsafeRow(3);
/* 131 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 132 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 133 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 134 */
/* 135 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 136 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 137 */
/* 138 */   }
/* 139 */
/* 140 */   public class agg_FastHashMap {
/* 141 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 142 */     private int[] buckets;
/* 143 */     private int capacity = 1 << 16;
/* 144 */     private double loadFactor = 0.5;
/* 145 */     private int numBuckets = (int) (capacity / loadFactor);
/* 146 */     private int maxSteps = 2;
/* 147 */     private int numRows = 0;
/* 148 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("c_customer_sk", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 149 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 150 */     private Object emptyVBase;
/* 151 */     private long emptyVOff;
/* 152 */     private int emptyVLen;
/* 153 */     private boolean isBatchFull = false;
/* 154 */
/* 155 */     public agg_FastHashMap(
/* 156 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 157 */       InternalRow emptyAggregationBuffer) {
/* 158 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 159 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 160 */
/* 161 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 162 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 163 */
/* 164 */       emptyVBase = emptyBuffer;
/* 165 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 166 */       emptyVLen = emptyBuffer.length;
/* 167 */
/* 168 */       buckets = new int[numBuckets];
/* 169 */       java.util.Arrays.fill(buckets, -1);
/* 170 */     }
/* 171 */
/* 172 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 173 */       long h = hash(agg_key);
/* 174 */       int step = 0;
/* 175 */       int idx = (int) h & (numBuckets - 1);
/* 176 */       while (step < maxSteps) {
/* 177 */         // Return bucket index if it's either an empty slot or already contains the key
/* 178 */         if (buckets[idx] == -1) {
/* 179 */           if (numRows < capacity && !isBatchFull) {
/* 180 */             // creating the unsafe for new entry
/* 181 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 182 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 183 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 184 */               0);
/* 185 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 186 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 187 */               agg_holder,
/* 188 */               1);
/* 189 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 190 */             agg_rowWriter.zeroOutNullBytes();
/* 191 */             agg_rowWriter.write(0, agg_key);
/* 192 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 193 */             Object kbase = agg_result.getBaseObject();
/* 194 */             long koff = agg_result.getBaseOffset();
/* 195 */             int klen = agg_result.getSizeInBytes();
/* 196 */
/* 197 */             UnsafeRow vRow
/* 198 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 199 */             if (vRow == null) {
/* 200 */               isBatchFull = true;
/* 201 */             } else {
/* 202 */               buckets[idx] = numRows++;
/* 203 */             }
/* 204 */             return vRow;
/* 205 */           } else {
/* 206 */             // No more space
/* 207 */             return null;
/* 208 */           }
/* 209 */         } else if (equals(idx, agg_key)) {
/* 210 */           return batch.getValueRow(buckets[idx]);
/* 211 */         }
/* 212 */         idx = (idx + 1) & (numBuckets - 1);
/* 213 */         step++;
/* 214 */       }
/* 215 */       // Didn't find it
/* 216 */       return null;
/* 217 */     }
/* 218 */
/* 219 */     private boolean equals(int idx, int agg_key) {
/* 220 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 221 */       return (row.getInt(0) == agg_key);
/* 222 */     }
/* 223 */
/* 224 */     private long hash(int agg_key) {
/* 225 */       long agg_hash = 0;
/* 226 */
/* 227 */       int agg_result = agg_key;
/* 228 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 229 */
/* 230 */       return agg_hash;
/* 231 */     }
/* 232 */
/* 233 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 234 */       return batch.rowIterator();
/* 235 */     }
/* 236 */
/* 237 */     public void close() {
/* 238 */       batch.close();
/* 239 */     }
/* 240 */
/* 241 */   }
/* 242 */
/* 243 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 244 */     agg_hashMap = agg_plan.createHashMap();
/* 245 */
/* 246 */     if (!agg_initAgg1) {
/* 247 */       agg_initAgg1 = true;
/* 248 */       long agg_beforeAgg = System.nanoTime();
/* 249 */       agg_doAggregateWithKeys1();
/* 250 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 251 */     }
/* 252 */
/* 253 */     // output the result
/* 254 */
/* 255 */     while (agg_mapIter1.next()) {
/* 256 */       agg_numOutputRows.add(1);
/* 257 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 258 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 259 */
/* 260 */       boolean agg_isNull8 = agg_aggKey.isNullAt(0);
/* 261 */       int agg_value9 = agg_isNull8 ? -1 : (agg_aggKey.getInt(0));
/* 262 */
/* 263 */       // generate join key for stream side
/* 264 */
/* 265 */       boolean bhj_isNull = agg_isNull8;
/* 266 */       long bhj_value = -1L;
/* 267 */       if (!agg_isNull8) {
/* 268 */         bhj_value = (long) agg_value9;
/* 269 */       }
/* 270 */       // find matches from HashedRelation
/* 271 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 272 */       if (bhj_matched == null) continue;
/* 273 */
/* 274 */       bhj_numOutputRows.add(1);
/* 275 */
/* 276 */       boolean agg_isNull9 = agg_aggKey.isNullAt(1);
/* 277 */       int agg_value10 = agg_isNull9 ? -1 : (agg_aggKey.getInt(1));
/* 278 */
/* 279 */       // generate join key for stream side
/* 280 */
/* 281 */       boolean bhj_isNull10 = agg_isNull9;
/* 282 */       long bhj_value10 = -1L;
/* 283 */       if (!agg_isNull9) {
/* 284 */         bhj_value10 = (long) agg_value10;
/* 285 */       }
/* 286 */       // find matches from HashedRelation
/* 287 */       UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 288 */       if (bhj_matched1 == null) continue;
/* 289 */
/* 290 */       bhj_numOutputRows1.add(1);
/* 291 */
/* 292 */       boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 293 */       UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(1));
/* 294 */       boolean bhj_isNull14 = bhj_matched1.isNullAt(2);
/* 295 */       UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(2));
/* 296 */
/* 297 */       // generate join key for stream side
/* 298 */
/* 299 */       bhj_holder2.reset();
/* 300 */
/* 301 */       bhj_rowWriter2.zeroOutNullBytes();
/* 302 */
/* 303 */       if (bhj_isNull13) {
/* 304 */         bhj_rowWriter2.setNullAt(0);
/* 305 */       } else {
/* 306 */         bhj_rowWriter2.write(0, bhj_value13);
/* 307 */       }
/* 308 */
/* 309 */       if (bhj_isNull14) {
/* 310 */         bhj_rowWriter2.setNullAt(1);
/* 311 */       } else {
/* 312 */         bhj_rowWriter2.write(1, bhj_value14);
/* 313 */       }
/* 314 */       bhj_result2.setTotalSize(bhj_holder2.totalSize());
/* 315 */
/* 316 */       // find matches from HashRelation
/* 317 */       scala.collection.Iterator bhj_matches = bhj_result2.anyNull() ? null : (scala.collection.Iterator)bhj_relation2.get(bhj_result2);
/* 318 */       if (bhj_matches == null) continue;
/* 319 */       while (bhj_matches.hasNext()) {
/* 320 */         UnsafeRow bhj_matched2 = (UnsafeRow) bhj_matches.next();
/* 321 */
/* 322 */         bhj_numOutputRows2.add(1);
/* 323 */
/* 324 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 325 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 326 */
/* 327 */         // generate join key for stream side
/* 328 */
/* 329 */         boolean bhj_isNull33 = bhj_isNull4;
/* 330 */         long bhj_value33 = -1L;
/* 331 */         if (!bhj_isNull4) {
/* 332 */           bhj_value33 = (long) bhj_value4;
/* 333 */         }
/* 334 */         // find matches from HashedRelation
/* 335 */         UnsafeRow bhj_matched3 = bhj_isNull33 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value33);
/* 336 */         if (bhj_matched3 == null) continue;
/* 337 */
/* 338 */         bhj_numOutputRows3.add(1);
/* 339 */
/* 340 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 341 */         double bhj_value3 = bhj_isNull3 ? -1.0 : (bhj_matched.getDouble(1));
/* 342 */
/* 343 */         UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 344 */
/* 345 */         UnsafeRow agg_fastAggBuffer1 = null;
/* 346 */
/* 347 */         if (true) {
/* 348 */           if (!agg_isNull8) {
/* 349 */             agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 350 */               agg_value9);
/* 351 */           }
/* 352 */         }
/* 353 */
/* 354 */         if (agg_fastAggBuffer1 == null) {
/* 355 */           // generate grouping key
/* 356 */           agg_rowWriter2.zeroOutNullBytes();
/* 357 */
/* 358 */           if (agg_isNull8) {
/* 359 */             agg_rowWriter2.setNullAt(0);
/* 360 */           } else {
/* 361 */             agg_rowWriter2.write(0, agg_value9);
/* 362 */           }
/* 363 */           agg_value15 = 42;
/* 364 */
/* 365 */           if (!agg_isNull8) {
/* 366 */             agg_value15 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value9, agg_value15);
/* 367 */           }
/* 368 */           if (true) {
/* 369 */             // try to get the buffer from hash map
/* 370 */             agg_unsafeRowAggBuffer1 =
/* 371 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value15);
/* 372 */           }
/* 373 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 374 */             if (agg_sorter == null) {
/* 375 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 376 */             } else {
/* 377 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 378 */             }
/* 379 */
/* 380 */             // the hash map had be spilled, it should have enough memory now,
/* 381 */             // try  to allocate buffer again.
/* 382 */             agg_unsafeRowAggBuffer1 =
/* 383 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value15);
/* 384 */             if (agg_unsafeRowAggBuffer1 == null) {
/* 385 */               // failed to allocate the first page
/* 386 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 387 */             }
/* 388 */           }
/* 389 */         }
/* 390 */
/* 391 */         if (agg_fastAggBuffer1 != null) {
/* 392 */           // update fast row
/* 393 */
/* 394 */           // common sub-expressions
/* 395 */
/* 396 */           // evaluate aggregate function
/* 397 */           boolean agg_isNull26 = true;
/* 398 */           double agg_value27 = -1.0;
/* 399 */
/* 400 */           boolean agg_isNull28 = agg_fastAggBuffer1.isNullAt(0);
/* 401 */           double agg_value29 = agg_isNull28 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 402 */           boolean agg_isNull27 = agg_isNull28;
/* 403 */           double agg_value28 = agg_value29;
/* 404 */           if (agg_isNull27) {
/* 405 */             boolean agg_isNull29 = false;
/* 406 */             double agg_value30 = -1.0;
/* 407 */             if (!false) {
/* 408 */               agg_value30 = (double) 0;
/* 409 */             }
/* 410 */             if (!agg_isNull29) {
/* 411 */               agg_isNull27 = false;
/* 412 */               agg_value28 = agg_value30;
/* 413 */             }
/* 414 */           }
/* 415 */
/* 416 */           boolean agg_isNull31 = bhj_isNull3;
/* 417 */           double agg_value32 = -1.0;
/* 418 */           if (!bhj_isNull3) {
/* 419 */             agg_value32 = bhj_value3;
/* 420 */           }
/* 421 */           if (!agg_isNull31) {
/* 422 */             agg_isNull26 = false; // resultCode could change nullability.
/* 423 */             agg_value27 = agg_value28 + agg_value32;
/* 424 */
/* 425 */           }
/* 426 */           boolean agg_isNull25 = agg_isNull26;
/* 427 */           double agg_value26 = agg_value27;
/* 428 */           if (agg_isNull25) {
/* 429 */             boolean agg_isNull33 = agg_fastAggBuffer1.isNullAt(0);
/* 430 */             double agg_value34 = agg_isNull33 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 431 */             if (!agg_isNull33) {
/* 432 */               agg_isNull25 = false;
/* 433 */               agg_value26 = agg_value34;
/* 434 */             }
/* 435 */           }
/* 436 */           // update fast row
/* 437 */           if (!agg_isNull25) {
/* 438 */             agg_fastAggBuffer1.setDouble(0, agg_value26);
/* 439 */           } else {
/* 440 */             agg_fastAggBuffer1.setNullAt(0);
/* 441 */           }
/* 442 */
/* 443 */         } else {
/* 444 */           // update unsafe row
/* 445 */
/* 446 */           // common sub-expressions
/* 447 */
/* 448 */           // evaluate aggregate function
/* 449 */           boolean agg_isNull17 = true;
/* 450 */           double agg_value18 = -1.0;
/* 451 */
/* 452 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 453 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 454 */           boolean agg_isNull18 = agg_isNull19;
/* 455 */           double agg_value19 = agg_value20;
/* 456 */           if (agg_isNull18) {
/* 457 */             boolean agg_isNull20 = false;
/* 458 */             double agg_value21 = -1.0;
/* 459 */             if (!false) {
/* 460 */               agg_value21 = (double) 0;
/* 461 */             }
/* 462 */             if (!agg_isNull20) {
/* 463 */               agg_isNull18 = false;
/* 464 */               agg_value19 = agg_value21;
/* 465 */             }
/* 466 */           }
/* 467 */
/* 468 */           boolean agg_isNull22 = bhj_isNull3;
/* 469 */           double agg_value23 = -1.0;
/* 470 */           if (!bhj_isNull3) {
/* 471 */             agg_value23 = bhj_value3;
/* 472 */           }
/* 473 */           if (!agg_isNull22) {
/* 474 */             agg_isNull17 = false; // resultCode could change nullability.
/* 475 */             agg_value18 = agg_value19 + agg_value23;
/* 476 */
/* 477 */           }
/* 478 */           boolean agg_isNull16 = agg_isNull17;
/* 479 */           double agg_value17 = agg_value18;
/* 480 */           if (agg_isNull16) {
/* 481 */             boolean agg_isNull24 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 482 */             double agg_value25 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 483 */             if (!agg_isNull24) {
/* 484 */               agg_isNull16 = false;
/* 485 */               agg_value17 = agg_value25;
/* 486 */             }
/* 487 */           }
/* 488 */           // update unsafe row buffer
/* 489 */           if (!agg_isNull16) {
/* 490 */             agg_unsafeRowAggBuffer1.setDouble(0, agg_value17);
/* 491 */           } else {
/* 492 */             agg_unsafeRowAggBuffer1.setNullAt(0);
/* 493 */           }
/* 494 */
/* 495 */         }
/* 496 */
/* 497 */       }
/* 498 */
/* 499 */       if (shouldStop()) return;
/* 500 */     }
/* 501 */
/* 502 */     agg_mapIter1.close();
/* 503 */     if (agg_sorter1 == null) {
/* 504 */       agg_hashMap1.free();
/* 505 */     }
/* 506 */
/* 507 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 508 */
/* 509 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 510 */   }
/* 511 */
/* 512 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 513 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 514 */
/* 515 */     while (inputadapter_input.hasNext()) {
/* 516 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 517 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 518 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 519 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 520 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 521 */
/* 522 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 523 */
/* 524 */       UnsafeRow agg_fastAggBuffer = null;
/* 525 */
/* 526 */       if (agg_fastAggBuffer == null) {
/* 527 */         // generate grouping key
/* 528 */         agg_rowWriter.zeroOutNullBytes();
/* 529 */
/* 530 */         if (inputadapter_isNull) {
/* 531 */           agg_rowWriter.setNullAt(0);
/* 532 */         } else {
/* 533 */           agg_rowWriter.write(0, inputadapter_value);
/* 534 */         }
/* 535 */
/* 536 */         if (inputadapter_isNull1) {
/* 537 */           agg_rowWriter.setNullAt(1);
/* 538 */         } else {
/* 539 */           agg_rowWriter.write(1, inputadapter_value1);
/* 540 */         }
/* 541 */         agg_value6 = 42;
/* 542 */
/* 543 */         if (!inputadapter_isNull) {
/* 544 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 545 */         }
/* 546 */
/* 547 */         if (!inputadapter_isNull1) {
/* 548 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value6);
/* 549 */         }
/* 550 */         if (true) {
/* 551 */           // try to get the buffer from hash map
/* 552 */           agg_unsafeRowAggBuffer =
/* 553 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 554 */         }
/* 555 */         if (agg_unsafeRowAggBuffer == null) {
/* 556 */           if (agg_sorter1 == null) {
/* 557 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 558 */           } else {
/* 559 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 560 */           }
/* 561 */
/* 562 */           // the hash map had be spilled, it should have enough memory now,
/* 563 */           // try  to allocate buffer again.
/* 564 */           agg_unsafeRowAggBuffer =
/* 565 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 566 */           if (agg_unsafeRowAggBuffer == null) {
/* 567 */             // failed to allocate the first page
/* 568 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 569 */           }
/* 570 */         }
/* 571 */       }
/* 572 */
/* 573 */       if (agg_fastAggBuffer != null) {
/* 574 */         // update fast row
/* 575 */
/* 576 */       } else {
/* 577 */         // update unsafe row
/* 578 */
/* 579 */         // common sub-expressions
/* 580 */
/* 581 */         // evaluate aggregate function
/* 582 */
/* 583 */         // update unsafe row buffer
/* 584 */
/* 585 */       }
/* 586 */       if (shouldStop()) return;
/* 587 */     }
/* 588 */
/* 589 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 590 */   }
/* 591 */
/* 592 */   private void wholestagecodegen_init_5() {
/* 593 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 594 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 595 */
/* 596 */   }
/* 597 */
/* 598 */   private void wholestagecodegen_init_2() {
/* 599 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 600 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 601 */
/* 602 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 603 */     bhj_result1 = new UnsafeRow(7);
/* 604 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 605 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 606 */     project_result1 = new UnsafeRow(5);
/* 607 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 608 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 609 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 610 */
/* 611 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 612 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 613 */
/* 614 */   }
/* 615 */
/* 616 */   private void wholestagecodegen_init_1() {
/* 617 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 618 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 619 */
/* 620 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 621 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 622 */
/* 623 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 624 */     bhj_result = new UnsafeRow(5);
/* 625 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 626 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 627 */     project_result = new UnsafeRow(4);
/* 628 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 629 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 630 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 631 */
/* 632 */   }
/* 633 */
/* 634 */   private void wholestagecodegen_init_4() {
/* 635 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 636 */     bhj_result4 = new UnsafeRow(4);
/* 637 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 0);
/* 638 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 4);
/* 639 */     project_result3 = new UnsafeRow(2);
/* 640 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 641 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 642 */     agg_result3 = new UnsafeRow(1);
/* 643 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 644 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 645 */
/* 646 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 647 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 648 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 649 */
/* 650 */   }
/* 651 */
/* 652 */   protected void processNext() throws java.io.IOException {
/* 653 */     if (!agg_initAgg) {
/* 654 */       agg_initAgg = true;
/* 655 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 656 */       agg_doAggregateWithKeys();
/* 657 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 658 */     }
/* 659 */
/* 660 */     // output the result
/* 661 */
/* 662 */     while (agg_fastHashMapIter.next()) {
/* 663 */       wholestagecodegen_numOutputRows.add(1);
/* 664 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 665 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 666 */
/* 667 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 668 */
/* 669 */       append(agg_resultRow);
/* 670 */
/* 671 */       if (shouldStop()) return;
/* 672 */     }
/* 673 */     agg_fastHashMap.close();
/* 674 */
/* 675 */     while (agg_mapIter.next()) {
/* 676 */       wholestagecodegen_numOutputRows.add(1);
/* 677 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 678 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 679 */
/* 680 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 681 */
/* 682 */       append(agg_resultRow);
/* 683 */
/* 684 */       if (shouldStop()) return;
/* 685 */     }
/* 686 */
/* 687 */     agg_mapIter.close();
/* 688 */     if (agg_sorter == null) {
/* 689 */       agg_hashMap.free();
/* 690 */     }
/* 691 */   }
/* 692 */ }
