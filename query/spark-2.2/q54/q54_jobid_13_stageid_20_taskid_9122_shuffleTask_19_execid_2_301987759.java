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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private boolean agg_initAgg1;
/* 020 */   private boolean agg_bufIsNull1;
/* 021 */   private double agg_bufValue1;
/* 022 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 023 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 024 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 028 */   private boolean agg_initAgg2;
/* 029 */   private boolean agg_bufIsNull2;
/* 030 */   private double agg_bufValue2;
/* 031 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan2;
/* 032 */   private agg_FastHashMap2 agg_fastHashMap2;
/* 033 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter2;
/* 034 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap2;
/* 035 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter2;
/* 036 */   private org.apache.spark.unsafe.KVIterator agg_mapIter2;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory2;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize2;
/* 039 */   private scala.collection.Iterator smj_leftInput;
/* 040 */   private scala.collection.Iterator smj_rightInput;
/* 041 */   private InternalRow smj_leftRow;
/* 042 */   private InternalRow smj_rightRow;
/* 043 */   private int smj_value2;
/* 044 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 045 */   private int smj_value3;
/* 046 */   private int smj_value4;
/* 047 */   private boolean smj_isNull2;
/* 048 */   private int smj_value5;
/* 049 */   private boolean smj_isNull3;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 051 */   private UnsafeRow smj_result;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 054 */   private UnsafeRow project_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 060 */   private UnsafeRow bhj_result;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 063 */   private UnsafeRow project_result1;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 066 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 067 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation1;
/* 068 */   private UnsafeRow bhj_result1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 072 */   private UnsafeRow bhj_result2;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 075 */   private UnsafeRow project_result2;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 078 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 079 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 080 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 081 */   private UnsafeRow bhj_result3;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 084 */   private UnsafeRow project_result3;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 087 */   private UnsafeRow agg_result2;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 090 */   private int agg_value8;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 092 */   private UnsafeRow agg_result3;
/* 093 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 095 */   private int agg_value30;
/* 096 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 097 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 098 */   private UnsafeRow agg_result4;
/* 099 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 100 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 101 */   private UnsafeRow agg_result5;
/* 102 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder3;
/* 103 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter3;
/* 104 */   private int agg_value50;
/* 105 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 106 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 107 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner1;
/* 108 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 109 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 110 */
/* 111 */   public GeneratedIterator(Object[] references) {
/* 112 */     this.references = references;
/* 113 */   }
/* 114 */
/* 115 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 116 */     partitionIndex = index;
/* 117 */     this.inputs = inputs;
/* 118 */     wholestagecodegen_init_0();
/* 119 */     wholestagecodegen_init_1();
/* 120 */     wholestagecodegen_init_2();
/* 121 */     wholestagecodegen_init_3();
/* 122 */     wholestagecodegen_init_4();
/* 123 */     wholestagecodegen_init_5();
/* 124 */
/* 125 */   }
/* 126 */
/* 127 */   private void wholestagecodegen_init_0() {
/* 128 */     agg_initAgg = false;
/* 129 */
/* 130 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 131 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 132 */
/* 133 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 134 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 135 */     agg_initAgg1 = false;
/* 136 */
/* 137 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[5];
/* 138 */
/* 139 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 140 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 141 */     agg_initAgg2 = false;
/* 142 */
/* 143 */     this.agg_plan2 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[8];
/* 144 */     agg_fastHashMap2 = new agg_FastHashMap2(agg_plan2.getTaskMemoryManager(), agg_plan2.getEmptyAggregationBuffer());
/* 145 */
/* 146 */     this.agg_peakMemory2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 147 */     this.agg_spillSize2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 148 */
/* 149 */   }
/* 150 */
/* 151 */   private void wholestagecodegen_init_3() {
/* 152 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 153 */     bhj_result2 = new UnsafeRow(7);
/* 154 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 128);
/* 155 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 156 */     project_result2 = new UnsafeRow(3);
/* 157 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 158 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 159 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 160 */
/* 161 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 162 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 163 */
/* 164 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 165 */     bhj_result3 = new UnsafeRow(4);
/* 166 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 0);
/* 167 */
/* 168 */   }
/* 169 */
/* 170 */   public class agg_FastHashMap {
/* 171 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 172 */     private int[] buckets;
/* 173 */     private int capacity = 1 << 16;
/* 174 */     private double loadFactor = 0.5;
/* 175 */     private int numBuckets = (int) (capacity / loadFactor);
/* 176 */     private int maxSteps = 2;
/* 177 */     private int numRows = 0;
/* 178 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 179 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.LongType);
/* 180 */     private Object emptyVBase;
/* 181 */     private long emptyVOff;
/* 182 */     private int emptyVLen;
/* 183 */     private boolean isBatchFull = false;
/* 184 */
/* 185 */     public agg_FastHashMap(
/* 186 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 187 */       InternalRow emptyAggregationBuffer) {
/* 188 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 189 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 190 */
/* 191 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 192 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 193 */
/* 194 */       emptyVBase = emptyBuffer;
/* 195 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 196 */       emptyVLen = emptyBuffer.length;
/* 197 */
/* 198 */       buckets = new int[numBuckets];
/* 199 */       java.util.Arrays.fill(buckets, -1);
/* 200 */     }
/* 201 */
/* 202 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 203 */       long h = hash(agg_key);
/* 204 */       int step = 0;
/* 205 */       int idx = (int) h & (numBuckets - 1);
/* 206 */       while (step < maxSteps) {
/* 207 */         // Return bucket index if it's either an empty slot or already contains the key
/* 208 */         if (buckets[idx] == -1) {
/* 209 */           if (numRows < capacity && !isBatchFull) {
/* 210 */             // creating the unsafe for new entry
/* 211 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 212 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 213 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 214 */               0);
/* 215 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 216 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 217 */               agg_holder,
/* 218 */               1);
/* 219 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 220 */             agg_rowWriter.zeroOutNullBytes();
/* 221 */             agg_rowWriter.write(0, agg_key);
/* 222 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 223 */             Object kbase = agg_result.getBaseObject();
/* 224 */             long koff = agg_result.getBaseOffset();
/* 225 */             int klen = agg_result.getSizeInBytes();
/* 226 */
/* 227 */             UnsafeRow vRow
/* 228 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 229 */             if (vRow == null) {
/* 230 */               isBatchFull = true;
/* 231 */             } else {
/* 232 */               buckets[idx] = numRows++;
/* 233 */             }
/* 234 */             return vRow;
/* 235 */           } else {
/* 236 */             // No more space
/* 237 */             return null;
/* 238 */           }
/* 239 */         } else if (equals(idx, agg_key)) {
/* 240 */           return batch.getValueRow(buckets[idx]);
/* 241 */         }
/* 242 */         idx = (idx + 1) & (numBuckets - 1);
/* 243 */         step++;
/* 244 */       }
/* 245 */       // Didn't find it
/* 246 */       return null;
/* 247 */     }
/* 248 */
/* 249 */     private boolean equals(int idx, int agg_key) {
/* 250 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 251 */       return (row.getInt(0) == agg_key);
/* 252 */     }
/* 253 */
/* 254 */     private long hash(int agg_key) {
/* 255 */       long agg_hash = 0;
/* 256 */
/* 257 */       int agg_result = agg_key;
/* 258 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 259 */
/* 260 */       return agg_hash;
/* 261 */     }
/* 262 */
/* 263 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 264 */       return batch.rowIterator();
/* 265 */     }
/* 266 */
/* 267 */     public void close() {
/* 268 */       batch.close();
/* 269 */     }
/* 270 */
/* 271 */   }
/* 272 */
/* 273 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 274 */     agg_hashMap = agg_plan.createHashMap();
/* 275 */
/* 276 */     if (!agg_initAgg1) {
/* 277 */       agg_initAgg1 = true;
/* 278 */       long agg_beforeAgg1 = System.nanoTime();
/* 279 */       agg_doAggregateWithKeys1();
/* 280 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 281 */     }
/* 282 */
/* 283 */     // output the result
/* 284 */
/* 285 */     while (agg_mapIter1.next()) {
/* 286 */       agg_numOutputRows1.add(1);
/* 287 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter1.getKey();
/* 288 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter1.getValue();
/* 289 */
/* 290 */       boolean agg_isNull37 = agg_aggKey1.isNullAt(0);
/* 291 */       int agg_value40 = agg_isNull37 ? -1 : (agg_aggKey1.getInt(0));
/* 292 */       boolean agg_isNull38 = agg_aggBuffer1.isNullAt(0);
/* 293 */       double agg_value41 = agg_isNull38 ? -1.0 : (agg_aggBuffer1.getDouble(0));
/* 294 */
/* 295 */       boolean agg_isNull41 = false;
/* 296 */       double agg_value44 = -1.0;
/* 297 */       if (false || 50.0D == 0) {
/* 298 */         agg_isNull41 = true;
/* 299 */       } else {
/* 300 */         if (agg_isNull38) {
/* 301 */           agg_isNull41 = true;
/* 302 */         } else {
/* 303 */           agg_value44 = (double)(agg_value41 / 50.0D);
/* 304 */         }
/* 305 */       }
/* 306 */       boolean agg_isNull40 = agg_isNull41;
/* 307 */       int agg_value43 = -1;
/* 308 */       if (!agg_isNull41) {
/* 309 */         agg_value43 = (int) agg_value44;
/* 310 */       }
/* 311 */
/* 312 */       UnsafeRow agg_unsafeRowAggBuffer2 = null;
/* 313 */
/* 314 */       UnsafeRow agg_fastAggBuffer2 = null;
/* 315 */
/* 316 */       if (true) {
/* 317 */         if (!agg_isNull40) {
/* 318 */           agg_fastAggBuffer2 = agg_fastHashMap.findOrInsert(
/* 319 */             agg_value43);
/* 320 */         }
/* 321 */       }
/* 322 */
/* 323 */       if (agg_fastAggBuffer2 == null) {
/* 324 */         // generate grouping key
/* 325 */         agg_rowWriter3.zeroOutNullBytes();
/* 326 */
/* 327 */         if (agg_isNull40) {
/* 328 */           agg_rowWriter3.setNullAt(0);
/* 329 */         } else {
/* 330 */           agg_rowWriter3.write(0, agg_value43);
/* 331 */         }
/* 332 */         agg_value50 = 42;
/* 333 */
/* 334 */         if (!agg_isNull40) {
/* 335 */           agg_value50 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value43, agg_value50);
/* 336 */         }
/* 337 */         if (true) {
/* 338 */           // try to get the buffer from hash map
/* 339 */           agg_unsafeRowAggBuffer2 =
/* 340 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value50);
/* 341 */         }
/* 342 */         if (agg_unsafeRowAggBuffer2 == null) {
/* 343 */           if (agg_sorter == null) {
/* 344 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 345 */           } else {
/* 346 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 347 */           }
/* 348 */
/* 349 */           // the hash map had be spilled, it should have enough memory now,
/* 350 */           // try  to allocate buffer again.
/* 351 */           agg_unsafeRowAggBuffer2 =
/* 352 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value50);
/* 353 */           if (agg_unsafeRowAggBuffer2 == null) {
/* 354 */             // failed to allocate the first page
/* 355 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 356 */           }
/* 357 */         }
/* 358 */       }
/* 359 */
/* 360 */       if (agg_fastAggBuffer2 != null) {
/* 361 */         // update fast row
/* 362 */
/* 363 */         // common sub-expressions
/* 364 */
/* 365 */         // evaluate aggregate function
/* 366 */         boolean agg_isNull52 = false;
/* 367 */
/* 368 */         long agg_value56 = agg_fastAggBuffer2.getLong(0);
/* 369 */
/* 370 */         long agg_value55 = -1L;
/* 371 */         agg_value55 = agg_value56 + 1L;
/* 372 */         // update fast row
/* 373 */         agg_fastAggBuffer2.setLong(0, agg_value55);
/* 374 */
/* 375 */       } else {
/* 376 */         // update unsafe row
/* 377 */
/* 378 */         // common sub-expressions
/* 379 */
/* 380 */         // evaluate aggregate function
/* 381 */         boolean agg_isNull49 = false;
/* 382 */
/* 383 */         long agg_value53 = agg_unsafeRowAggBuffer2.getLong(0);
/* 384 */
/* 385 */         long agg_value52 = -1L;
/* 386 */         agg_value52 = agg_value53 + 1L;
/* 387 */         // update unsafe row buffer
/* 388 */         agg_unsafeRowAggBuffer2.setLong(0, agg_value52);
/* 389 */
/* 390 */       }
/* 391 */
/* 392 */       if (shouldStop()) return;
/* 393 */     }
/* 394 */
/* 395 */     agg_mapIter1.close();
/* 396 */     if (agg_sorter1 == null) {
/* 397 */       agg_hashMap1.free();
/* 398 */     }
/* 399 */
/* 400 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 401 */
/* 402 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 403 */   }
/* 404 */
/* 405 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 406 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 407 */
/* 408 */     if (!agg_initAgg2) {
/* 409 */       agg_initAgg2 = true;
/* 410 */       long agg_beforeAgg = System.nanoTime();
/* 411 */       agg_doAggregateWithKeys2();
/* 412 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 413 */     }
/* 414 */
/* 415 */     // output the result
/* 416 */
/* 417 */     while (agg_fastHashMapIter2.next()) {
/* 418 */       agg_numOutputRows.add(1);
/* 419 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter2.getKey();
/* 420 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter2.getValue();
/* 421 */
/* 422 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 423 */
/* 424 */       boolean agg_isNull23 = agg_resultRow.isNullAt(0);
/* 425 */       int agg_value26 = agg_isNull23 ? -1 : (agg_resultRow.getInt(0));
/* 426 */       boolean agg_isNull24 = agg_resultRow.isNullAt(1);
/* 427 */       double agg_value27 = agg_isNull24 ? -1.0 : (agg_resultRow.getDouble(1));
/* 428 */
/* 429 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 430 */
/* 431 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 432 */
/* 433 */       if (agg_fastAggBuffer1 == null) {
/* 434 */         // generate grouping key
/* 435 */         agg_rowWriter1.zeroOutNullBytes();
/* 436 */
/* 437 */         if (agg_isNull23) {
/* 438 */           agg_rowWriter1.setNullAt(0);
/* 439 */         } else {
/* 440 */           agg_rowWriter1.write(0, agg_value26);
/* 441 */         }
/* 442 */         agg_value30 = 42;
/* 443 */
/* 444 */         if (!agg_isNull23) {
/* 445 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value26, agg_value30);
/* 446 */         }
/* 447 */         if (true) {
/* 448 */           // try to get the buffer from hash map
/* 449 */           agg_unsafeRowAggBuffer1 =
/* 450 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value30);
/* 451 */         }
/* 452 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 453 */           if (agg_sorter1 == null) {
/* 454 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 455 */           } else {
/* 456 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 457 */           }
/* 458 */
/* 459 */           // the hash map had be spilled, it should have enough memory now,
/* 460 */           // try  to allocate buffer again.
/* 461 */           agg_unsafeRowAggBuffer1 =
/* 462 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value30);
/* 463 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 464 */             // failed to allocate the first page
/* 465 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 466 */           }
/* 467 */         }
/* 468 */       }
/* 469 */
/* 470 */       if (agg_fastAggBuffer1 != null) {
/* 471 */         // update fast row
/* 472 */
/* 473 */       } else {
/* 474 */         // update unsafe row
/* 475 */
/* 476 */         // common sub-expressions
/* 477 */
/* 478 */         // evaluate aggregate function
/* 479 */         boolean agg_isNull30 = true;
/* 480 */         double agg_value33 = -1.0;
/* 481 */
/* 482 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 483 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 484 */         boolean agg_isNull31 = agg_isNull32;
/* 485 */         double agg_value34 = agg_value35;
/* 486 */         if (agg_isNull31) {
/* 487 */           boolean agg_isNull33 = false;
/* 488 */           double agg_value36 = -1.0;
/* 489 */           if (!false) {
/* 490 */             agg_value36 = (double) 0;
/* 491 */           }
/* 492 */           if (!agg_isNull33) {
/* 493 */             agg_isNull31 = false;
/* 494 */             agg_value34 = agg_value36;
/* 495 */           }
/* 496 */         }
/* 497 */
/* 498 */         if (!agg_isNull24) {
/* 499 */           agg_isNull30 = false; // resultCode could change nullability.
/* 500 */           agg_value33 = agg_value34 + agg_value27;
/* 501 */
/* 502 */         }
/* 503 */         boolean agg_isNull29 = agg_isNull30;
/* 504 */         double agg_value32 = agg_value33;
/* 505 */         if (agg_isNull29) {
/* 506 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 507 */           double agg_value39 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 508 */           if (!agg_isNull36) {
/* 509 */             agg_isNull29 = false;
/* 510 */             agg_value32 = agg_value39;
/* 511 */           }
/* 512 */         }
/* 513 */         // update unsafe row buffer
/* 514 */         if (!agg_isNull29) {
/* 515 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value32);
/* 516 */         } else {
/* 517 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 518 */         }
/* 519 */
/* 520 */       }
/* 521 */
/* 522 */       if (shouldStop()) return;
/* 523 */     }
/* 524 */     agg_fastHashMap2.close();
/* 525 */
/* 526 */     while (agg_mapIter2.next()) {
/* 527 */       agg_numOutputRows.add(1);
/* 528 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter2.getKey();
/* 529 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter2.getValue();
/* 530 */
/* 531 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 532 */
/* 533 */       boolean agg_isNull23 = agg_resultRow.isNullAt(0);
/* 534 */       int agg_value26 = agg_isNull23 ? -1 : (agg_resultRow.getInt(0));
/* 535 */       boolean agg_isNull24 = agg_resultRow.isNullAt(1);
/* 536 */       double agg_value27 = agg_isNull24 ? -1.0 : (agg_resultRow.getDouble(1));
/* 537 */
/* 538 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 539 */
/* 540 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 541 */
/* 542 */       if (agg_fastAggBuffer1 == null) {
/* 543 */         // generate grouping key
/* 544 */         agg_rowWriter1.zeroOutNullBytes();
/* 545 */
/* 546 */         if (agg_isNull23) {
/* 547 */           agg_rowWriter1.setNullAt(0);
/* 548 */         } else {
/* 549 */           agg_rowWriter1.write(0, agg_value26);
/* 550 */         }
/* 551 */         agg_value30 = 42;
/* 552 */
/* 553 */         if (!agg_isNull23) {
/* 554 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value26, agg_value30);
/* 555 */         }
/* 556 */         if (true) {
/* 557 */           // try to get the buffer from hash map
/* 558 */           agg_unsafeRowAggBuffer1 =
/* 559 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value30);
/* 560 */         }
/* 561 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 562 */           if (agg_sorter1 == null) {
/* 563 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 564 */           } else {
/* 565 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 566 */           }
/* 567 */
/* 568 */           // the hash map had be spilled, it should have enough memory now,
/* 569 */           // try  to allocate buffer again.
/* 570 */           agg_unsafeRowAggBuffer1 =
/* 571 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value30);
/* 572 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 573 */             // failed to allocate the first page
/* 574 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 575 */           }
/* 576 */         }
/* 577 */       }
/* 578 */
/* 579 */       if (agg_fastAggBuffer1 != null) {
/* 580 */         // update fast row
/* 581 */
/* 582 */       } else {
/* 583 */         // update unsafe row
/* 584 */
/* 585 */         // common sub-expressions
/* 586 */
/* 587 */         // evaluate aggregate function
/* 588 */         boolean agg_isNull30 = true;
/* 589 */         double agg_value33 = -1.0;
/* 590 */
/* 591 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 592 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 593 */         boolean agg_isNull31 = agg_isNull32;
/* 594 */         double agg_value34 = agg_value35;
/* 595 */         if (agg_isNull31) {
/* 596 */           boolean agg_isNull33 = false;
/* 597 */           double agg_value36 = -1.0;
/* 598 */           if (!false) {
/* 599 */             agg_value36 = (double) 0;
/* 600 */           }
/* 601 */           if (!agg_isNull33) {
/* 602 */             agg_isNull31 = false;
/* 603 */             agg_value34 = agg_value36;
/* 604 */           }
/* 605 */         }
/* 606 */
/* 607 */         if (!agg_isNull24) {
/* 608 */           agg_isNull30 = false; // resultCode could change nullability.
/* 609 */           agg_value33 = agg_value34 + agg_value27;
/* 610 */
/* 611 */         }
/* 612 */         boolean agg_isNull29 = agg_isNull30;
/* 613 */         double agg_value32 = agg_value33;
/* 614 */         if (agg_isNull29) {
/* 615 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 616 */           double agg_value39 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 617 */           if (!agg_isNull36) {
/* 618 */             agg_isNull29 = false;
/* 619 */             agg_value32 = agg_value39;
/* 620 */           }
/* 621 */         }
/* 622 */         // update unsafe row buffer
/* 623 */         if (!agg_isNull29) {
/* 624 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value32);
/* 625 */         } else {
/* 626 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 627 */         }
/* 628 */
/* 629 */       }
/* 630 */
/* 631 */       if (shouldStop()) return;
/* 632 */     }
/* 633 */
/* 634 */     agg_mapIter2.close();
/* 635 */     if (agg_sorter2 == null) {
/* 636 */       agg_hashMap2.free();
/* 637 */     }
/* 638 */
/* 639 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 640 */   }
/* 641 */
/* 642 */   private boolean findNextInnerJoinRows(
/* 643 */     scala.collection.Iterator leftIter,
/* 644 */     scala.collection.Iterator rightIter) {
/* 645 */     smj_leftRow = null;
/* 646 */     int comp = 0;
/* 647 */     while (smj_leftRow == null) {
/* 648 */       if (!leftIter.hasNext()) return false;
/* 649 */       smj_leftRow = (InternalRow) leftIter.next();
/* 650 */
/* 651 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 652 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 653 */       if (smj_isNull) {
/* 654 */         smj_leftRow = null;
/* 655 */         continue;
/* 656 */       }
/* 657 */       if (!smj_matches.isEmpty()) {
/* 658 */         comp = 0;
/* 659 */         if (comp == 0) {
/* 660 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 661 */         }
/* 662 */
/* 663 */         if (comp == 0) {
/* 664 */           return true;
/* 665 */         }
/* 666 */         smj_matches.clear();
/* 667 */       }
/* 668 */
/* 669 */       do {
/* 670 */         if (smj_rightRow == null) {
/* 671 */           if (!rightIter.hasNext()) {
/* 672 */             smj_value3 = smj_value;
/* 673 */             return !smj_matches.isEmpty();
/* 674 */           }
/* 675 */           smj_rightRow = (InternalRow) rightIter.next();
/* 676 */
/* 677 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 678 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 679 */           if (smj_isNull1) {
/* 680 */             smj_rightRow = null;
/* 681 */             continue;
/* 682 */           }
/* 683 */           smj_value2 = smj_value1;
/* 684 */         }
/* 685 */
/* 686 */         comp = 0;
/* 687 */         if (comp == 0) {
/* 688 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 689 */         }
/* 690 */
/* 691 */         if (comp > 0) {
/* 692 */           smj_rightRow = null;
/* 693 */         } else if (comp < 0) {
/* 694 */           if (!smj_matches.isEmpty()) {
/* 695 */             smj_value3 = smj_value;
/* 696 */             return true;
/* 697 */           }
/* 698 */           smj_leftRow = null;
/* 699 */         } else {
/* 700 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 701 */           smj_rightRow = null;;
/* 702 */         }
/* 703 */       } while (smj_leftRow != null);
/* 704 */     }
/* 705 */     return false; // unreachable
/* 706 */   }
/* 707 */
/* 708 */   private void wholestagecodegen_init_5() {
/* 709 */     agg_result4 = new UnsafeRow(1);
/* 710 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 0);
/* 711 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 712 */     agg_result5 = new UnsafeRow(1);
/* 713 */     this.agg_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 0);
/* 714 */     this.agg_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder3, 1);
/* 715 */
/* 716 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 717 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 718 */     agg_unsafeRowJoiner1 = agg_plan.createUnsafeJoiner();
/* 719 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 720 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[25];
/* 721 */
/* 722 */   }
/* 723 */
/* 724 */   private void wholestagecodegen_init_2() {
/* 725 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 726 */     bhj_result = new UnsafeRow(7);
/* 727 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 728 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 729 */     project_result1 = new UnsafeRow(5);
/* 730 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 731 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 732 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 733 */
/* 734 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 735 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 736 */
/* 737 */     bhj_result1 = new UnsafeRow(2);
/* 738 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 739 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 2);
/* 740 */
/* 741 */   }
/* 742 */
/* 743 */   private void wholestagecodegen_init_1() {
/* 744 */     smj_leftInput = inputs[0];
/* 745 */     smj_rightInput = inputs[1];
/* 746 */
/* 747 */     smj_rightRow = null;
/* 748 */
/* 749 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 750 */
/* 751 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 752 */     smj_result = new UnsafeRow(5);
/* 753 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 754 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 755 */     project_result = new UnsafeRow(4);
/* 756 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 757 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 758 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 759 */
/* 760 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 761 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 762 */
/* 763 */   }
/* 764 */
/* 765 */   private void wholestagecodegen_init_4() {
/* 766 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 4);
/* 767 */     project_result3 = new UnsafeRow(2);
/* 768 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 769 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 770 */     agg_result2 = new UnsafeRow(1);
/* 771 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 772 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 773 */
/* 774 */     agg_unsafeRowJoiner = agg_plan2.createUnsafeJoiner();
/* 775 */     agg_result3 = new UnsafeRow(1);
/* 776 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 777 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 778 */
/* 779 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 780 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 781 */
/* 782 */   }
/* 783 */
/* 784 */   public class agg_FastHashMap2 {
/* 785 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 786 */     private int[] buckets;
/* 787 */     private int capacity = 1 << 16;
/* 788 */     private double loadFactor = 0.5;
/* 789 */     private int numBuckets = (int) (capacity / loadFactor);
/* 790 */     private int maxSteps = 2;
/* 791 */     private int numRows = 0;
/* 792 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 793 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 794 */     private Object emptyVBase;
/* 795 */     private long emptyVOff;
/* 796 */     private int emptyVLen;
/* 797 */     private boolean isBatchFull = false;
/* 798 */
/* 799 */     public agg_FastHashMap2(
/* 800 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 801 */       InternalRow emptyAggregationBuffer) {
/* 802 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 803 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 804 */
/* 805 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 806 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 807 */
/* 808 */       emptyVBase = emptyBuffer;
/* 809 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 810 */       emptyVLen = emptyBuffer.length;
/* 811 */
/* 812 */       buckets = new int[numBuckets];
/* 813 */       java.util.Arrays.fill(buckets, -1);
/* 814 */     }
/* 815 */
/* 816 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key2) {
/* 817 */       long h = hash(agg_key2);
/* 818 */       int step = 0;
/* 819 */       int idx = (int) h & (numBuckets - 1);
/* 820 */       while (step < maxSteps) {
/* 821 */         // Return bucket index if it's either an empty slot or already contains the key
/* 822 */         if (buckets[idx] == -1) {
/* 823 */           if (numRows < capacity && !isBatchFull) {
/* 824 */             // creating the unsafe for new entry
/* 825 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 826 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 827 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 828 */               0);
/* 829 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 830 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 831 */               agg_holder,
/* 832 */               1);
/* 833 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 834 */             agg_rowWriter.zeroOutNullBytes();
/* 835 */             agg_rowWriter.write(0, agg_key2);
/* 836 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 837 */             Object kbase = agg_result.getBaseObject();
/* 838 */             long koff = agg_result.getBaseOffset();
/* 839 */             int klen = agg_result.getSizeInBytes();
/* 840 */
/* 841 */             UnsafeRow vRow
/* 842 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 843 */             if (vRow == null) {
/* 844 */               isBatchFull = true;
/* 845 */             } else {
/* 846 */               buckets[idx] = numRows++;
/* 847 */             }
/* 848 */             return vRow;
/* 849 */           } else {
/* 850 */             // No more space
/* 851 */             return null;
/* 852 */           }
/* 853 */         } else if (equals(idx, agg_key2)) {
/* 854 */           return batch.getValueRow(buckets[idx]);
/* 855 */         }
/* 856 */         idx = (idx + 1) & (numBuckets - 1);
/* 857 */         step++;
/* 858 */       }
/* 859 */       // Didn't find it
/* 860 */       return null;
/* 861 */     }
/* 862 */
/* 863 */     private boolean equals(int idx, int agg_key2) {
/* 864 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 865 */       return (row.getInt(0) == agg_key2);
/* 866 */     }
/* 867 */
/* 868 */     private long hash(int agg_key2) {
/* 869 */       long agg_hash1 = 0;
/* 870 */
/* 871 */       int agg_result1 = agg_key2;
/* 872 */       agg_hash1 = (agg_hash1 ^ (0x9e3779b9)) + agg_result1 + (agg_hash1 << 6) + (agg_hash1 >>> 2);
/* 873 */
/* 874 */       return agg_hash1;
/* 875 */     }
/* 876 */
/* 877 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 878 */       return batch.rowIterator();
/* 879 */     }
/* 880 */
/* 881 */     public void close() {
/* 882 */       batch.close();
/* 883 */     }
/* 884 */
/* 885 */   }
/* 886 */
/* 887 */   private void agg_doAggregateWithKeys2() throws java.io.IOException {
/* 888 */     agg_hashMap2 = agg_plan2.createHashMap();
/* 889 */
/* 890 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 891 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 892 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 893 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 894 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 895 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 896 */       while (smj_iterator.hasNext()) {
/* 897 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 898 */
/* 899 */         smj_numOutputRows.add(1);
/* 900 */
/* 901 */         // generate join key for stream side
/* 902 */
/* 903 */         boolean bhj_isNull = smj_isNull3;
/* 904 */         long bhj_value = -1L;
/* 905 */         if (!smj_isNull3) {
/* 906 */           bhj_value = (long) smj_value5;
/* 907 */         }
/* 908 */         // find matches from HashedRelation
/* 909 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 910 */         if (bhj_matched == null) continue;
/* 911 */
/* 912 */         bhj_numOutputRows.add(1);
/* 913 */
/* 914 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 915 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 916 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 917 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 918 */
/* 919 */         // generate join key for stream side
/* 920 */
/* 921 */         bhj_holder1.reset();
/* 922 */
/* 923 */         bhj_rowWriter1.zeroOutNullBytes();
/* 924 */
/* 925 */         if (bhj_isNull3) {
/* 926 */           bhj_rowWriter1.setNullAt(0);
/* 927 */         } else {
/* 928 */           bhj_rowWriter1.write(0, bhj_value3);
/* 929 */         }
/* 930 */
/* 931 */         if (bhj_isNull4) {
/* 932 */           bhj_rowWriter1.setNullAt(1);
/* 933 */         } else {
/* 934 */           bhj_rowWriter1.write(1, bhj_value4);
/* 935 */         }
/* 936 */         bhj_result1.setTotalSize(bhj_holder1.totalSize());
/* 937 */
/* 938 */         // find matches from HashRelation
/* 939 */         scala.collection.Iterator bhj_matches = bhj_result1.anyNull() ? null : (scala.collection.Iterator)bhj_relation1.get(bhj_result1);
/* 940 */         if (bhj_matches == null) continue;
/* 941 */         while (bhj_matches.hasNext()) {
/* 942 */           UnsafeRow bhj_matched1 = (UnsafeRow) bhj_matches.next();
/* 943 */
/* 944 */           bhj_numOutputRows1.add(1);
/* 945 */
/* 946 */           boolean smj_isNull6 = smj_rightRow1.isNullAt(2);
/* 947 */           int smj_value8 = smj_isNull6 ? -1 : (smj_rightRow1.getInt(2));
/* 948 */
/* 949 */           // generate join key for stream side
/* 950 */
/* 951 */           boolean bhj_isNull23 = smj_isNull6;
/* 952 */           long bhj_value23 = -1L;
/* 953 */           if (!smj_isNull6) {
/* 954 */             bhj_value23 = (long) smj_value8;
/* 955 */           }
/* 956 */           // find matches from HashedRelation
/* 957 */           UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 958 */           if (bhj_matched2 == null) continue;
/* 959 */
/* 960 */           bhj_numOutputRows2.add(1);
/* 961 */
/* 962 */           boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 963 */           double smj_value7 = smj_isNull5 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 964 */
/* 965 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 966 */
/* 967 */           UnsafeRow agg_fastAggBuffer = null;
/* 968 */
/* 969 */           if (true) {
/* 970 */             if (!smj_isNull2) {
/* 971 */               agg_fastAggBuffer = agg_fastHashMap2.findOrInsert(
/* 972 */                 smj_value4);
/* 973 */             }
/* 974 */           }
/* 975 */
/* 976 */           if (agg_fastAggBuffer == null) {
/* 977 */             // generate grouping key
/* 978 */             agg_rowWriter.zeroOutNullBytes();
/* 979 */
/* 980 */             if (smj_isNull2) {
/* 981 */               agg_rowWriter.setNullAt(0);
/* 982 */             } else {
/* 983 */               agg_rowWriter.write(0, smj_value4);
/* 984 */             }
/* 985 */             agg_value8 = 42;
/* 986 */
/* 987 */             if (!smj_isNull2) {
/* 988 */               agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value4, agg_value8);
/* 989 */             }
/* 990 */             if (true) {
/* 991 */               // try to get the buffer from hash map
/* 992 */               agg_unsafeRowAggBuffer =
/* 993 */               agg_hashMap2.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 994 */             }
/* 995 */             if (agg_unsafeRowAggBuffer == null) {
/* 996 */               if (agg_sorter2 == null) {
/* 997 */                 agg_sorter2 = agg_hashMap2.destructAndCreateExternalSorter();
/* 998 */               } else {
/* 999 */                 agg_sorter2.merge(agg_hashMap2.destructAndCreateExternalSorter());
/* 1000 */               }
/* 1001 */
/* 1002 */               // the hash map had be spilled, it should have enough memory now,
/* 1003 */               // try  to allocate buffer again.
/* 1004 */               agg_unsafeRowAggBuffer =
/* 1005 */               agg_hashMap2.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 1006 */               if (agg_unsafeRowAggBuffer == null) {
/* 1007 */                 // failed to allocate the first page
/* 1008 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 1009 */               }
/* 1010 */             }
/* 1011 */           }
/* 1012 */
/* 1013 */           if (agg_fastAggBuffer != null) {
/* 1014 */             // update fast row
/* 1015 */
/* 1016 */             // common sub-expressions
/* 1017 */
/* 1018 */             // evaluate aggregate function
/* 1019 */             boolean agg_isNull16 = true;
/* 1020 */             double agg_value19 = -1.0;
/* 1021 */
/* 1022 */             boolean agg_isNull18 = agg_fastAggBuffer.isNullAt(0);
/* 1023 */             double agg_value21 = agg_isNull18 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 1024 */             boolean agg_isNull17 = agg_isNull18;
/* 1025 */             double agg_value20 = agg_value21;
/* 1026 */             if (agg_isNull17) {
/* 1027 */               boolean agg_isNull19 = false;
/* 1028 */               double agg_value22 = -1.0;
/* 1029 */               if (!false) {
/* 1030 */                 agg_value22 = (double) 0;
/* 1031 */               }
/* 1032 */               if (!agg_isNull19) {
/* 1033 */                 agg_isNull17 = false;
/* 1034 */                 agg_value20 = agg_value22;
/* 1035 */               }
/* 1036 */             }
/* 1037 */
/* 1038 */             if (!smj_isNull5) {
/* 1039 */               agg_isNull16 = false; // resultCode could change nullability.
/* 1040 */               agg_value19 = agg_value20 + smj_value7;
/* 1041 */
/* 1042 */             }
/* 1043 */             boolean agg_isNull15 = agg_isNull16;
/* 1044 */             double agg_value18 = agg_value19;
/* 1045 */             if (agg_isNull15) {
/* 1046 */               boolean agg_isNull22 = agg_fastAggBuffer.isNullAt(0);
/* 1047 */               double agg_value25 = agg_isNull22 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 1048 */               if (!agg_isNull22) {
/* 1049 */                 agg_isNull15 = false;
/* 1050 */                 agg_value18 = agg_value25;
/* 1051 */               }
/* 1052 */             }
/* 1053 */             // update fast row
/* 1054 */             if (!agg_isNull15) {
/* 1055 */               agg_fastAggBuffer.setDouble(0, agg_value18);
/* 1056 */             } else {
/* 1057 */               agg_fastAggBuffer.setNullAt(0);
/* 1058 */             }
/* 1059 */
/* 1060 */           } else {
/* 1061 */             // update unsafe row
/* 1062 */
/* 1063 */             // common sub-expressions
/* 1064 */
/* 1065 */             // evaluate aggregate function
/* 1066 */             boolean agg_isNull8 = true;
/* 1067 */             double agg_value11 = -1.0;
/* 1068 */
/* 1069 */             boolean agg_isNull10 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 1070 */             double agg_value13 = agg_isNull10 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 1071 */             boolean agg_isNull9 = agg_isNull10;
/* 1072 */             double agg_value12 = agg_value13;
/* 1073 */             if (agg_isNull9) {
/* 1074 */               boolean agg_isNull11 = false;
/* 1075 */               double agg_value14 = -1.0;
/* 1076 */               if (!false) {
/* 1077 */                 agg_value14 = (double) 0;
/* 1078 */               }
/* 1079 */               if (!agg_isNull11) {
/* 1080 */                 agg_isNull9 = false;
/* 1081 */                 agg_value12 = agg_value14;
/* 1082 */               }
/* 1083 */             }
/* 1084 */
/* 1085 */             if (!smj_isNull5) {
/* 1086 */               agg_isNull8 = false; // resultCode could change nullability.
/* 1087 */               agg_value11 = agg_value12 + smj_value7;
/* 1088 */
/* 1089 */             }
/* 1090 */             boolean agg_isNull7 = agg_isNull8;
/* 1091 */             double agg_value10 = agg_value11;
/* 1092 */             if (agg_isNull7) {
/* 1093 */               boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 1094 */               double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 1095 */               if (!agg_isNull14) {
/* 1096 */                 agg_isNull7 = false;
/* 1097 */                 agg_value10 = agg_value17;
/* 1098 */               }
/* 1099 */             }
/* 1100 */             // update unsafe row buffer
/* 1101 */             if (!agg_isNull7) {
/* 1102 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value10);
/* 1103 */             } else {
/* 1104 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 1105 */             }
/* 1106 */
/* 1107 */           }
/* 1108 */
/* 1109 */         }
/* 1110 */
/* 1111 */       }
/* 1112 */       if (shouldStop()) return;
/* 1113 */     }
/* 1114 */
/* 1115 */     agg_fastHashMapIter2 = agg_fastHashMap2.rowIterator();
/* 1116 */
/* 1117 */     agg_mapIter2 = agg_plan2.finishAggregate(agg_hashMap2, agg_sorter2, agg_peakMemory2, agg_spillSize2);
/* 1118 */   }
/* 1119 */
/* 1120 */   protected void processNext() throws java.io.IOException {
/* 1121 */     if (!agg_initAgg) {
/* 1122 */       agg_initAgg = true;
/* 1123 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1124 */       agg_doAggregateWithKeys();
/* 1125 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1126 */     }
/* 1127 */
/* 1128 */     // output the result
/* 1129 */
/* 1130 */     while (agg_fastHashMapIter.next()) {
/* 1131 */       wholestagecodegen_numOutputRows.add(1);
/* 1132 */       UnsafeRow agg_aggKey2 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1133 */       UnsafeRow agg_aggBuffer2 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1134 */
/* 1135 */       UnsafeRow agg_resultRow1 = agg_unsafeRowJoiner1.join(agg_aggKey2, agg_aggBuffer2);
/* 1136 */
/* 1137 */       append(agg_resultRow1);
/* 1138 */
/* 1139 */       if (shouldStop()) return;
/* 1140 */     }
/* 1141 */     agg_fastHashMap.close();
/* 1142 */
/* 1143 */     while (agg_mapIter.next()) {
/* 1144 */       wholestagecodegen_numOutputRows.add(1);
/* 1145 */       UnsafeRow agg_aggKey2 = (UnsafeRow) agg_mapIter.getKey();
/* 1146 */       UnsafeRow agg_aggBuffer2 = (UnsafeRow) agg_mapIter.getValue();
/* 1147 */
/* 1148 */       UnsafeRow agg_resultRow1 = agg_unsafeRowJoiner1.join(agg_aggKey2, agg_aggBuffer2);
/* 1149 */
/* 1150 */       append(agg_resultRow1);
/* 1151 */
/* 1152 */       if (shouldStop()) return;
/* 1153 */     }
/* 1154 */
/* 1155 */     agg_mapIter.close();
/* 1156 */     if (agg_sorter == null) {
/* 1157 */       agg_hashMap.free();
/* 1158 */     }
/* 1159 */   }
/* 1160 */ }
