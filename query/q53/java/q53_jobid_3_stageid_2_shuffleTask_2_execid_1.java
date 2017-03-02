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
/* 021 */   private scala.collection.Iterator scan_input;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 024 */   private long scan_scanTime1;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 026 */   private int scan_batchIdx;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 032 */   private UnsafeRow scan_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 036 */   private UnsafeRow filter_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 039 */   private UnsafeRow project_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 042 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 043 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 045 */   private UnsafeRow bhj_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 048 */   private UnsafeRow project_result1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 051 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 052 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 054 */   private UnsafeRow bhj_result1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 057 */   private UnsafeRow project_result2;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 060 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 061 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 063 */   private UnsafeRow bhj_result2;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 066 */   private UnsafeRow project_result3;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 069 */   private UnsafeRow agg_result2;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 072 */   private int agg_value8;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 075 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 076 */
/* 077 */   public GeneratedIterator(Object[] references) {
/* 078 */     this.references = references;
/* 079 */   }
/* 080 */
/* 081 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 082 */     partitionIndex = index;
/* 083 */     this.inputs = inputs;
/* 084 */     wholestagecodegen_init_0();
/* 085 */     wholestagecodegen_init_1();
/* 086 */     wholestagecodegen_init_2();
/* 087 */     wholestagecodegen_init_3();
/* 088 */     wholestagecodegen_init_4();
/* 089 */
/* 090 */   }
/* 091 */
/* 092 */   private void wholestagecodegen_init_0() {
/* 093 */     agg_initAgg = false;
/* 094 */
/* 095 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 096 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 097 */
/* 098 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 099 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 100 */     scan_input = inputs[0];
/* 101 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 102 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 103 */     scan_scanTime1 = 0;
/* 104 */     scan_batch = null;
/* 105 */     scan_batchIdx = 0;
/* 106 */     scan_colInstance0 = null;
/* 107 */     scan_colInstance1 = null;
/* 108 */     scan_colInstance2 = null;
/* 109 */     scan_colInstance3 = null;
/* 110 */     scan_colInstance4 = null;
/* 111 */     scan_result = new UnsafeRow(5);
/* 112 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 96);
/* 113 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 114 */
/* 115 */   }
/* 116 */
/* 117 */   private void wholestagecodegen_init_3() {
/* 118 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 119 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[32];
/* 120 */
/* 121 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 122 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 123 */
/* 124 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[33];
/* 125 */     bhj_result2 = new UnsafeRow(5);
/* 126 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 127 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 5);
/* 128 */     project_result3 = new UnsafeRow(3);
/* 129 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 130 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 3);
/* 131 */     agg_result2 = new UnsafeRow(2);
/* 132 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 133 */
/* 134 */   }
/* 135 */
/* 136 */   private void scan_nextBatch() throws java.io.IOException {
/* 137 */     long getBatchStart = System.nanoTime();
/* 138 */     if (scan_input.hasNext()) {
/* 139 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 140 */       scan_numOutputRows.add(scan_batch.numRows());
/* 141 */       scan_batchIdx = 0;
/* 142 */       scan_colInstance0 = scan_batch.column(0);
/* 143 */       scan_colInstance1 = scan_batch.column(1);
/* 144 */       scan_colInstance2 = scan_batch.column(2);
/* 145 */       scan_colInstance3 = scan_batch.column(3);
/* 146 */       scan_colInstance4 = scan_batch.column(4);
/* 147 */
/* 148 */     }
/* 149 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 150 */   }
/* 151 */
/* 152 */   public class agg_FastHashMap {
/* 153 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 154 */     private int[] buckets;
/* 155 */     private int capacity = 1 << 16;
/* 156 */     private double loadFactor = 0.5;
/* 157 */     private int numBuckets = (int) (capacity / loadFactor);
/* 158 */     private int maxSteps = 2;
/* 159 */     private int numRows = 0;
/* 160 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_manufact_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 161 */     .add("d_qoy", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 162 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 163 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 164 */     private Object emptyVBase;
/* 165 */     private long emptyVOff;
/* 166 */     private int emptyVLen;
/* 167 */     private boolean isBatchFull = false;
/* 168 */
/* 169 */     public agg_FastHashMap(
/* 170 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 171 */       InternalRow emptyAggregationBuffer) {
/* 172 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 173 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 174 */
/* 175 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 176 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 177 */
/* 178 */       emptyVBase = emptyBuffer;
/* 179 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 180 */       emptyVLen = emptyBuffer.length;
/* 181 */
/* 182 */       buckets = new int[numBuckets];
/* 183 */       java.util.Arrays.fill(buckets, -1);
/* 184 */     }
/* 185 */
/* 186 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1) {
/* 187 */       long h = hash(agg_key, agg_key1);
/* 188 */       int step = 0;
/* 189 */       int idx = (int) h & (numBuckets - 1);
/* 190 */       while (step < maxSteps) {
/* 191 */         // Return bucket index if it's either an empty slot or already contains the key
/* 192 */         if (buckets[idx] == -1) {
/* 193 */           if (numRows < capacity && !isBatchFull) {
/* 194 */             // creating the unsafe for new entry
/* 195 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 196 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 197 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 198 */               0);
/* 199 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 200 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 201 */               agg_holder,
/* 202 */               2);
/* 203 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 204 */             agg_rowWriter.zeroOutNullBytes();
/* 205 */             agg_rowWriter.write(0, agg_key);
/* 206 */             agg_rowWriter.write(1, agg_key1);
/* 207 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 208 */             Object kbase = agg_result.getBaseObject();
/* 209 */             long koff = agg_result.getBaseOffset();
/* 210 */             int klen = agg_result.getSizeInBytes();
/* 211 */
/* 212 */             UnsafeRow vRow
/* 213 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 214 */             if (vRow == null) {
/* 215 */               isBatchFull = true;
/* 216 */             } else {
/* 217 */               buckets[idx] = numRows++;
/* 218 */             }
/* 219 */             return vRow;
/* 220 */           } else {
/* 221 */             // No more space
/* 222 */             return null;
/* 223 */           }
/* 224 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 225 */           return batch.getValueRow(buckets[idx]);
/* 226 */         }
/* 227 */         idx = (idx + 1) & (numBuckets - 1);
/* 228 */         step++;
/* 229 */       }
/* 230 */       // Didn't find it
/* 231 */       return null;
/* 232 */     }
/* 233 */
/* 234 */     private boolean equals(int idx, int agg_key, int agg_key1) {
/* 235 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 236 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1);
/* 237 */     }
/* 238 */
/* 239 */     private long hash(int agg_key, int agg_key1) {
/* 240 */       long agg_hash = 0;
/* 241 */
/* 242 */       int agg_result = agg_key;
/* 243 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 244 */
/* 245 */       int agg_result1 = agg_key1;
/* 246 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 247 */
/* 248 */       return agg_hash;
/* 249 */     }
/* 250 */
/* 251 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 252 */       return batch.rowIterator();
/* 253 */     }
/* 254 */
/* 255 */     public void close() {
/* 256 */       batch.close();
/* 257 */     }
/* 258 */
/* 259 */   }
/* 260 */
/* 261 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 262 */     agg_hashMap = agg_plan.createHashMap();
/* 263 */
/* 264 */     if (scan_batch == null) {
/* 265 */       scan_nextBatch();
/* 266 */     }
/* 267 */     while (scan_batch != null) {
/* 268 */       int numRows = scan_batch.numRows();
/* 269 */       while (scan_batchIdx < numRows) {
/* 270 */         int scan_rowIdx = scan_batchIdx++;
/* 271 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 272 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 273 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 274 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 275 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 276 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 277 */
/* 278 */         boolean filter_value3 = false;
/* 279 */         boolean filter_isNull3 = scan_isNull3;
/* 280 */         if (!filter_isNull3) {
/* 281 */           if (!filter_value3) {
/* 282 */             Object filter_obj = ((Expression) references[6]).eval(null);
/* 283 */             UTF8String filter_value5 = (UTF8String) filter_obj;
/* 284 */             if (false) {
/* 285 */               filter_isNull3 = true;
/* 286 */             } else if (scan_value3.equals(filter_value5)) {
/* 287 */               filter_isNull3 = false;
/* 288 */               filter_value3 = true;
/* 289 */             }
/* 290 */           }
/* 291 */
/* 292 */           if (!filter_value3) {
/* 293 */             Object filter_obj1 = ((Expression) references[7]).eval(null);
/* 294 */             UTF8String filter_value6 = (UTF8String) filter_obj1;
/* 295 */             if (false) {
/* 296 */               filter_isNull3 = true;
/* 297 */             } else if (scan_value3.equals(filter_value6)) {
/* 298 */               filter_isNull3 = false;
/* 299 */               filter_value3 = true;
/* 300 */             }
/* 301 */           }
/* 302 */
/* 303 */           if (!filter_value3) {
/* 304 */             Object filter_obj2 = ((Expression) references[8]).eval(null);
/* 305 */             UTF8String filter_value7 = (UTF8String) filter_obj2;
/* 306 */             if (false) {
/* 307 */               filter_isNull3 = true;
/* 308 */             } else if (scan_value3.equals(filter_value7)) {
/* 309 */               filter_isNull3 = false;
/* 310 */               filter_value3 = true;
/* 311 */             }
/* 312 */           }
/* 313 */
/* 314 */         }
/* 315 */         boolean filter_isNull2 = false;
/* 316 */         boolean filter_value2 = false;
/* 317 */
/* 318 */         if (!filter_isNull3 && !filter_value3) {
/* 319 */         } else {
/* 320 */           boolean filter_value8 = false;
/* 321 */           boolean filter_isNull8 = scan_isNull2;
/* 322 */           if (!filter_isNull8) {
/* 323 */             if (!filter_value8) {
/* 324 */               Object filter_obj3 = ((Expression) references[9]).eval(null);
/* 325 */               UTF8String filter_value10 = (UTF8String) filter_obj3;
/* 326 */               if (false) {
/* 327 */                 filter_isNull8 = true;
/* 328 */               } else if (scan_value2.equals(filter_value10)) {
/* 329 */                 filter_isNull8 = false;
/* 330 */                 filter_value8 = true;
/* 331 */               }
/* 332 */             }
/* 333 */
/* 334 */             if (!filter_value8) {
/* 335 */               Object filter_obj4 = ((Expression) references[10]).eval(null);
/* 336 */               UTF8String filter_value11 = (UTF8String) filter_obj4;
/* 337 */               if (false) {
/* 338 */                 filter_isNull8 = true;
/* 339 */               } else if (scan_value2.equals(filter_value11)) {
/* 340 */                 filter_isNull8 = false;
/* 341 */                 filter_value8 = true;
/* 342 */               }
/* 343 */             }
/* 344 */
/* 345 */             if (!filter_value8) {
/* 346 */               Object filter_obj5 = ((Expression) references[11]).eval(null);
/* 347 */               UTF8String filter_value12 = (UTF8String) filter_obj5;
/* 348 */               if (false) {
/* 349 */                 filter_isNull8 = true;
/* 350 */               } else if (scan_value2.equals(filter_value12)) {
/* 351 */                 filter_isNull8 = false;
/* 352 */                 filter_value8 = true;
/* 353 */               }
/* 354 */             }
/* 355 */
/* 356 */             if (!filter_value8) {
/* 357 */               Object filter_obj6 = ((Expression) references[12]).eval(null);
/* 358 */               UTF8String filter_value13 = (UTF8String) filter_obj6;
/* 359 */               if (false) {
/* 360 */                 filter_isNull8 = true;
/* 361 */               } else if (scan_value2.equals(filter_value13)) {
/* 362 */                 filter_isNull8 = false;
/* 363 */                 filter_value8 = true;
/* 364 */               }
/* 365 */             }
/* 366 */
/* 367 */           }
/* 368 */           if (!filter_isNull8 && !filter_value8) {
/* 369 */           } else if (!filter_isNull3 && !filter_isNull8) {
/* 370 */             filter_value2 = true;
/* 371 */           } else {
/* 372 */             filter_isNull2 = true;
/* 373 */           }
/* 374 */         }
/* 375 */         boolean filter_isNull1 = false;
/* 376 */         boolean filter_value1 = false;
/* 377 */
/* 378 */         if (!filter_isNull2 && !filter_value2) {
/* 379 */         } else {
/* 380 */           boolean filter_value14 = false;
/* 381 */           boolean filter_isNull14 = scan_isNull1;
/* 382 */           if (!filter_isNull14) {
/* 383 */             if (!filter_value14) {
/* 384 */               Object filter_obj7 = ((Expression) references[13]).eval(null);
/* 385 */               UTF8String filter_value16 = (UTF8String) filter_obj7;
/* 386 */               if (false) {
/* 387 */                 filter_isNull14 = true;
/* 388 */               } else if (scan_value1.equals(filter_value16)) {
/* 389 */                 filter_isNull14 = false;
/* 390 */                 filter_value14 = true;
/* 391 */               }
/* 392 */             }
/* 393 */
/* 394 */             if (!filter_value14) {
/* 395 */               Object filter_obj8 = ((Expression) references[14]).eval(null);
/* 396 */               UTF8String filter_value17 = (UTF8String) filter_obj8;
/* 397 */               if (false) {
/* 398 */                 filter_isNull14 = true;
/* 399 */               } else if (scan_value1.equals(filter_value17)) {
/* 400 */                 filter_isNull14 = false;
/* 401 */                 filter_value14 = true;
/* 402 */               }
/* 403 */             }
/* 404 */
/* 405 */             if (!filter_value14) {
/* 406 */               Object filter_obj9 = ((Expression) references[15]).eval(null);
/* 407 */               UTF8String filter_value18 = (UTF8String) filter_obj9;
/* 408 */               if (false) {
/* 409 */                 filter_isNull14 = true;
/* 410 */               } else if (scan_value1.equals(filter_value18)) {
/* 411 */                 filter_isNull14 = false;
/* 412 */                 filter_value14 = true;
/* 413 */               }
/* 414 */             }
/* 415 */
/* 416 */             if (!filter_value14) {
/* 417 */               Object filter_obj10 = ((Expression) references[16]).eval(null);
/* 418 */               UTF8String filter_value19 = (UTF8String) filter_obj10;
/* 419 */               if (false) {
/* 420 */                 filter_isNull14 = true;
/* 421 */               } else if (scan_value1.equals(filter_value19)) {
/* 422 */                 filter_isNull14 = false;
/* 423 */                 filter_value14 = true;
/* 424 */               }
/* 425 */             }
/* 426 */
/* 427 */           }
/* 428 */           if (!filter_isNull14 && !filter_value14) {
/* 429 */           } else if (!filter_isNull2 && !filter_isNull14) {
/* 430 */             filter_value1 = true;
/* 431 */           } else {
/* 432 */             filter_isNull1 = true;
/* 433 */           }
/* 434 */         }
/* 435 */         boolean filter_isNull = false;
/* 436 */         boolean filter_value = true;
/* 437 */
/* 438 */         if (!filter_isNull1 && filter_value1) {
/* 439 */         } else {
/* 440 */           boolean filter_value22 = false;
/* 441 */           boolean filter_isNull22 = scan_isNull3;
/* 442 */           if (!filter_isNull22) {
/* 443 */             if (!filter_value22) {
/* 444 */               Object filter_obj11 = ((Expression) references[17]).eval(null);
/* 445 */               UTF8String filter_value24 = (UTF8String) filter_obj11;
/* 446 */               if (false) {
/* 447 */                 filter_isNull22 = true;
/* 448 */               } else if (scan_value3.equals(filter_value24)) {
/* 449 */                 filter_isNull22 = false;
/* 450 */                 filter_value22 = true;
/* 451 */               }
/* 452 */             }
/* 453 */
/* 454 */             if (!filter_value22) {
/* 455 */               Object filter_obj12 = ((Expression) references[18]).eval(null);
/* 456 */               UTF8String filter_value25 = (UTF8String) filter_obj12;
/* 457 */               if (false) {
/* 458 */                 filter_isNull22 = true;
/* 459 */               } else if (scan_value3.equals(filter_value25)) {
/* 460 */                 filter_isNull22 = false;
/* 461 */                 filter_value22 = true;
/* 462 */               }
/* 463 */             }
/* 464 */
/* 465 */             if (!filter_value22) {
/* 466 */               Object filter_obj13 = ((Expression) references[19]).eval(null);
/* 467 */               UTF8String filter_value26 = (UTF8String) filter_obj13;
/* 468 */               if (false) {
/* 469 */                 filter_isNull22 = true;
/* 470 */               } else if (scan_value3.equals(filter_value26)) {
/* 471 */                 filter_isNull22 = false;
/* 472 */                 filter_value22 = true;
/* 473 */               }
/* 474 */             }
/* 475 */
/* 476 */           }
/* 477 */           boolean filter_isNull21 = false;
/* 478 */           boolean filter_value21 = false;
/* 479 */
/* 480 */           if (!filter_isNull22 && !filter_value22) {
/* 481 */           } else {
/* 482 */             boolean filter_value27 = false;
/* 483 */             boolean filter_isNull27 = scan_isNull2;
/* 484 */             if (!filter_isNull27) {
/* 485 */               if (!filter_value27) {
/* 486 */                 Object filter_obj14 = ((Expression) references[20]).eval(null);
/* 487 */                 UTF8String filter_value29 = (UTF8String) filter_obj14;
/* 488 */                 if (false) {
/* 489 */                   filter_isNull27 = true;
/* 490 */                 } else if (scan_value2.equals(filter_value29)) {
/* 491 */                   filter_isNull27 = false;
/* 492 */                   filter_value27 = true;
/* 493 */                 }
/* 494 */               }
/* 495 */
/* 496 */               if (!filter_value27) {
/* 497 */                 Object filter_obj15 = ((Expression) references[21]).eval(null);
/* 498 */                 UTF8String filter_value30 = (UTF8String) filter_obj15;
/* 499 */                 if (false) {
/* 500 */                   filter_isNull27 = true;
/* 501 */                 } else if (scan_value2.equals(filter_value30)) {
/* 502 */                   filter_isNull27 = false;
/* 503 */                   filter_value27 = true;
/* 504 */                 }
/* 505 */               }
/* 506 */
/* 507 */               if (!filter_value27) {
/* 508 */                 Object filter_obj16 = ((Expression) references[22]).eval(null);
/* 509 */                 UTF8String filter_value31 = (UTF8String) filter_obj16;
/* 510 */                 if (false) {
/* 511 */                   filter_isNull27 = true;
/* 512 */                 } else if (scan_value2.equals(filter_value31)) {
/* 513 */                   filter_isNull27 = false;
/* 514 */                   filter_value27 = true;
/* 515 */                 }
/* 516 */               }
/* 517 */
/* 518 */               if (!filter_value27) {
/* 519 */                 Object filter_obj17 = ((Expression) references[23]).eval(null);
/* 520 */                 UTF8String filter_value32 = (UTF8String) filter_obj17;
/* 521 */                 if (false) {
/* 522 */                   filter_isNull27 = true;
/* 523 */                 } else if (scan_value2.equals(filter_value32)) {
/* 524 */                   filter_isNull27 = false;
/* 525 */                   filter_value27 = true;
/* 526 */                 }
/* 527 */               }
/* 528 */
/* 529 */             }
/* 530 */             if (!filter_isNull27 && !filter_value27) {
/* 531 */             } else if (!filter_isNull22 && !filter_isNull27) {
/* 532 */               filter_value21 = true;
/* 533 */             } else {
/* 534 */               filter_isNull21 = true;
/* 535 */             }
/* 536 */           }
/* 537 */           boolean filter_isNull20 = false;
/* 538 */           boolean filter_value20 = false;
/* 539 */
/* 540 */           if (!filter_isNull21 && !filter_value21) {
/* 541 */           } else {
/* 542 */             boolean filter_value33 = false;
/* 543 */             boolean filter_isNull33 = scan_isNull1;
/* 544 */             if (!filter_isNull33) {
/* 545 */               if (!filter_value33) {
/* 546 */                 Object filter_obj18 = ((Expression) references[24]).eval(null);
/* 547 */                 UTF8String filter_value35 = (UTF8String) filter_obj18;
/* 548 */                 if (false) {
/* 549 */                   filter_isNull33 = true;
/* 550 */                 } else if (scan_value1.equals(filter_value35)) {
/* 551 */                   filter_isNull33 = false;
/* 552 */                   filter_value33 = true;
/* 553 */                 }
/* 554 */               }
/* 555 */
/* 556 */               if (!filter_value33) {
/* 557 */                 Object filter_obj19 = ((Expression) references[25]).eval(null);
/* 558 */                 UTF8String filter_value36 = (UTF8String) filter_obj19;
/* 559 */                 if (false) {
/* 560 */                   filter_isNull33 = true;
/* 561 */                 } else if (scan_value1.equals(filter_value36)) {
/* 562 */                   filter_isNull33 = false;
/* 563 */                   filter_value33 = true;
/* 564 */                 }
/* 565 */               }
/* 566 */
/* 567 */               if (!filter_value33) {
/* 568 */                 Object filter_obj20 = ((Expression) references[26]).eval(null);
/* 569 */                 UTF8String filter_value37 = (UTF8String) filter_obj20;
/* 570 */                 if (false) {
/* 571 */                   filter_isNull33 = true;
/* 572 */                 } else if (scan_value1.equals(filter_value37)) {
/* 573 */                   filter_isNull33 = false;
/* 574 */                   filter_value33 = true;
/* 575 */                 }
/* 576 */               }
/* 577 */
/* 578 */               if (!filter_value33) {
/* 579 */                 Object filter_obj21 = ((Expression) references[27]).eval(null);
/* 580 */                 UTF8String filter_value38 = (UTF8String) filter_obj21;
/* 581 */                 if (false) {
/* 582 */                   filter_isNull33 = true;
/* 583 */                 } else if (scan_value1.equals(filter_value38)) {
/* 584 */                   filter_isNull33 = false;
/* 585 */                   filter_value33 = true;
/* 586 */                 }
/* 587 */               }
/* 588 */
/* 589 */             }
/* 590 */             if (!filter_isNull33 && !filter_value33) {
/* 591 */             } else if (!filter_isNull21 && !filter_isNull33) {
/* 592 */               filter_value20 = true;
/* 593 */             } else {
/* 594 */               filter_isNull20 = true;
/* 595 */             }
/* 596 */           }
/* 597 */           if (!filter_isNull20 && filter_value20) {
/* 598 */           } else if (!filter_isNull1 && !filter_isNull20) {
/* 599 */             filter_value = false;
/* 600 */           } else {
/* 601 */             filter_isNull = true;
/* 602 */           }
/* 603 */         }
/* 604 */         if (filter_isNull || !filter_value) continue;
/* 605 */
/* 606 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 607 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 608 */
/* 609 */         if (!(!(scan_isNull))) continue;
/* 610 */
/* 611 */         filter_numOutputRows.add(1);
/* 612 */
/* 613 */         // generate join key for stream side
/* 614 */
/* 615 */         boolean bhj_isNull = false;
/* 616 */         long bhj_value = -1L;
/* 617 */         if (!false) {
/* 618 */           bhj_value = (long) scan_value;
/* 619 */         }
/* 620 */         // find matches from HashedRelation
/* 621 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 622 */         if (bhj_matched == null) continue;
/* 623 */
/* 624 */         bhj_numOutputRows.add(1);
/* 625 */
/* 626 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 627 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 628 */
/* 629 */         // generate join key for stream side
/* 630 */
/* 631 */         boolean bhj_isNull12 = bhj_isNull5;
/* 632 */         long bhj_value12 = -1L;
/* 633 */         if (!bhj_isNull5) {
/* 634 */           bhj_value12 = (long) bhj_value5;
/* 635 */         }
/* 636 */         // find matches from HashedRelation
/* 637 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 638 */         if (bhj_matched1 == null) continue;
/* 639 */
/* 640 */         bhj_numOutputRows1.add(1);
/* 641 */
/* 642 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 643 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 644 */
/* 645 */         // generate join key for stream side
/* 646 */
/* 647 */         boolean bhj_isNull22 = bhj_isNull3;
/* 648 */         long bhj_value22 = -1L;
/* 649 */         if (!bhj_isNull3) {
/* 650 */           bhj_value22 = (long) bhj_value3;
/* 651 */         }
/* 652 */         // find matches from HashedRelation
/* 653 */         UnsafeRow bhj_matched2 = bhj_isNull22 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value22);
/* 654 */         if (bhj_matched2 == null) continue;
/* 655 */
/* 656 */         bhj_numOutputRows2.add(1);
/* 657 */
/* 658 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 659 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 660 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 661 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 662 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(1);
/* 663 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(1));
/* 664 */
/* 665 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 666 */
/* 667 */         UnsafeRow agg_fastAggBuffer = null;
/* 668 */
/* 669 */         if (true) {
/* 670 */           if (!scan_isNull4 && !bhj_isNull15) {
/* 671 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 672 */               scan_value4, bhj_value15);
/* 673 */           }
/* 674 */         }
/* 675 */
/* 676 */         if (agg_fastAggBuffer == null) {
/* 677 */           // generate grouping key
/* 678 */           agg_rowWriter.zeroOutNullBytes();
/* 679 */
/* 680 */           if (scan_isNull4) {
/* 681 */             agg_rowWriter.setNullAt(0);
/* 682 */           } else {
/* 683 */             agg_rowWriter.write(0, scan_value4);
/* 684 */           }
/* 685 */
/* 686 */           if (bhj_isNull15) {
/* 687 */             agg_rowWriter.setNullAt(1);
/* 688 */           } else {
/* 689 */             agg_rowWriter.write(1, bhj_value15);
/* 690 */           }
/* 691 */           agg_value8 = 42;
/* 692 */
/* 693 */           if (!scan_isNull4) {
/* 694 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value4, agg_value8);
/* 695 */           }
/* 696 */
/* 697 */           if (!bhj_isNull15) {
/* 698 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value8);
/* 699 */           }
/* 700 */           if (true) {
/* 701 */             // try to get the buffer from hash map
/* 702 */             agg_unsafeRowAggBuffer =
/* 703 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 704 */           }
/* 705 */           if (agg_unsafeRowAggBuffer == null) {
/* 706 */             if (agg_sorter == null) {
/* 707 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 708 */             } else {
/* 709 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 710 */             }
/* 711 */
/* 712 */             // the hash map had be spilled, it should have enough memory now,
/* 713 */             // try  to allocate buffer again.
/* 714 */             agg_unsafeRowAggBuffer =
/* 715 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 716 */             if (agg_unsafeRowAggBuffer == null) {
/* 717 */               // failed to allocate the first page
/* 718 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 719 */             }
/* 720 */           }
/* 721 */         }
/* 722 */
/* 723 */         if (agg_fastAggBuffer != null) {
/* 724 */           // update fast row
/* 725 */
/* 726 */           // common sub-expressions
/* 727 */           boolean agg_isNull23 = false;
/* 728 */           double agg_value25 = -1.0;
/* 729 */           if (!false) {
/* 730 */             agg_value25 = (double) 0;
/* 731 */           }
/* 732 */           boolean agg_isNull25 = bhj_isNull4;
/* 733 */           double agg_value27 = -1.0;
/* 734 */           if (!bhj_isNull4) {
/* 735 */             agg_value27 = bhj_value4;
/* 736 */           }
/* 737 */           // evaluate aggregate function
/* 738 */           boolean agg_isNull28 = true;
/* 739 */           double agg_value30 = -1.0;
/* 740 */
/* 741 */           boolean agg_isNull30 = agg_fastAggBuffer.isNullAt(0);
/* 742 */           double agg_value32 = agg_isNull30 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 743 */           boolean agg_isNull29 = agg_isNull30;
/* 744 */           double agg_value31 = agg_value32;
/* 745 */           if (agg_isNull29) {
/* 746 */             if (!agg_isNull23) {
/* 747 */               agg_isNull29 = false;
/* 748 */               agg_value31 = agg_value25;
/* 749 */             }
/* 750 */           }
/* 751 */
/* 752 */           if (!agg_isNull25) {
/* 753 */             agg_isNull28 = false; // resultCode could change nullability.
/* 754 */             agg_value30 = agg_value31 + agg_value27;
/* 755 */
/* 756 */           }
/* 757 */           boolean agg_isNull27 = agg_isNull28;
/* 758 */           double agg_value29 = agg_value30;
/* 759 */           if (agg_isNull27) {
/* 760 */             boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(0);
/* 761 */             double agg_value33 = agg_isNull31 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 762 */             if (!agg_isNull31) {
/* 763 */               agg_isNull27 = false;
/* 764 */               agg_value29 = agg_value33;
/* 765 */             }
/* 766 */           }
/* 767 */           boolean agg_isNull33 = true;
/* 768 */           double agg_value35 = -1.0;
/* 769 */
/* 770 */           boolean agg_isNull35 = agg_fastAggBuffer.isNullAt(1);
/* 771 */           double agg_value37 = agg_isNull35 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 772 */           boolean agg_isNull34 = agg_isNull35;
/* 773 */           double agg_value36 = agg_value37;
/* 774 */           if (agg_isNull34) {
/* 775 */             if (!agg_isNull23) {
/* 776 */               agg_isNull34 = false;
/* 777 */               agg_value36 = agg_value25;
/* 778 */             }
/* 779 */           }
/* 780 */
/* 781 */           if (!agg_isNull25) {
/* 782 */             agg_isNull33 = false; // resultCode could change nullability.
/* 783 */             agg_value35 = agg_value36 + agg_value27;
/* 784 */
/* 785 */           }
/* 786 */           boolean agg_isNull32 = agg_isNull33;
/* 787 */           double agg_value34 = agg_value35;
/* 788 */           if (agg_isNull32) {
/* 789 */             boolean agg_isNull36 = agg_fastAggBuffer.isNullAt(1);
/* 790 */             double agg_value38 = agg_isNull36 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 791 */             if (!agg_isNull36) {
/* 792 */               agg_isNull32 = false;
/* 793 */               agg_value34 = agg_value38;
/* 794 */             }
/* 795 */           }
/* 796 */           // update fast row
/* 797 */           if (!agg_isNull27) {
/* 798 */             agg_fastAggBuffer.setDouble(0, agg_value29);
/* 799 */           } else {
/* 800 */             agg_fastAggBuffer.setNullAt(0);
/* 801 */           }
/* 802 */
/* 803 */           if (!agg_isNull32) {
/* 804 */             agg_fastAggBuffer.setDouble(1, agg_value34);
/* 805 */           } else {
/* 806 */             agg_fastAggBuffer.setNullAt(1);
/* 807 */           }
/* 808 */
/* 809 */         } else {
/* 810 */           // update unsafe row
/* 811 */
/* 812 */           // common sub-expressions
/* 813 */           boolean agg_isNull9 = false;
/* 814 */           double agg_value11 = -1.0;
/* 815 */           if (!false) {
/* 816 */             agg_value11 = (double) 0;
/* 817 */           }
/* 818 */           boolean agg_isNull11 = bhj_isNull4;
/* 819 */           double agg_value13 = -1.0;
/* 820 */           if (!bhj_isNull4) {
/* 821 */             agg_value13 = bhj_value4;
/* 822 */           }
/* 823 */           // evaluate aggregate function
/* 824 */           boolean agg_isNull14 = true;
/* 825 */           double agg_value16 = -1.0;
/* 826 */
/* 827 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 828 */           double agg_value18 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 829 */           boolean agg_isNull15 = agg_isNull16;
/* 830 */           double agg_value17 = agg_value18;
/* 831 */           if (agg_isNull15) {
/* 832 */             if (!agg_isNull9) {
/* 833 */               agg_isNull15 = false;
/* 834 */               agg_value17 = agg_value11;
/* 835 */             }
/* 836 */           }
/* 837 */
/* 838 */           if (!agg_isNull11) {
/* 839 */             agg_isNull14 = false; // resultCode could change nullability.
/* 840 */             agg_value16 = agg_value17 + agg_value13;
/* 841 */
/* 842 */           }
/* 843 */           boolean agg_isNull13 = agg_isNull14;
/* 844 */           double agg_value15 = agg_value16;
/* 845 */           if (agg_isNull13) {
/* 846 */             boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 847 */             double agg_value19 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 848 */             if (!agg_isNull17) {
/* 849 */               agg_isNull13 = false;
/* 850 */               agg_value15 = agg_value19;
/* 851 */             }
/* 852 */           }
/* 853 */           boolean agg_isNull19 = true;
/* 854 */           double agg_value21 = -1.0;
/* 855 */
/* 856 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 857 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 858 */           boolean agg_isNull20 = agg_isNull21;
/* 859 */           double agg_value22 = agg_value23;
/* 860 */           if (agg_isNull20) {
/* 861 */             if (!agg_isNull9) {
/* 862 */               agg_isNull20 = false;
/* 863 */               agg_value22 = agg_value11;
/* 864 */             }
/* 865 */           }
/* 866 */
/* 867 */           if (!agg_isNull11) {
/* 868 */             agg_isNull19 = false; // resultCode could change nullability.
/* 869 */             agg_value21 = agg_value22 + agg_value13;
/* 870 */
/* 871 */           }
/* 872 */           boolean agg_isNull18 = agg_isNull19;
/* 873 */           double agg_value20 = agg_value21;
/* 874 */           if (agg_isNull18) {
/* 875 */             boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 876 */             double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 877 */             if (!agg_isNull22) {
/* 878 */               agg_isNull18 = false;
/* 879 */               agg_value20 = agg_value24;
/* 880 */             }
/* 881 */           }
/* 882 */           // update unsafe row buffer
/* 883 */           if (!agg_isNull13) {
/* 884 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 885 */           } else {
/* 886 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 887 */           }
/* 888 */
/* 889 */           if (!agg_isNull18) {
/* 890 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value20);
/* 891 */           } else {
/* 892 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 893 */           }
/* 894 */
/* 895 */         }
/* 896 */         if (shouldStop()) return;
/* 897 */       }
/* 898 */       scan_batch = null;
/* 899 */       scan_nextBatch();
/* 900 */     }
/* 901 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 902 */     scan_scanTime1 = 0;
/* 903 */
/* 904 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 905 */
/* 906 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 907 */   }
/* 908 */
/* 909 */   private void wholestagecodegen_init_2() {
/* 910 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 911 */     project_result1 = new UnsafeRow(4);
/* 912 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 913 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 914 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[30];
/* 915 */
/* 916 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 917 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 918 */
/* 919 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[31];
/* 920 */     bhj_result1 = new UnsafeRow(6);
/* 921 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 922 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 923 */     project_result2 = new UnsafeRow(4);
/* 924 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 925 */
/* 926 */   }
/* 927 */
/* 928 */   private void wholestagecodegen_init_1() {
/* 929 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 930 */     filter_result = new UnsafeRow(5);
/* 931 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 932 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 933 */     project_result = new UnsafeRow(2);
/* 934 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 935 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 936 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[28];
/* 937 */
/* 938 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 939 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 940 */
/* 941 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[29];
/* 942 */     bhj_result = new UnsafeRow(6);
/* 943 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 944 */
/* 945 */   }
/* 946 */
/* 947 */   private void wholestagecodegen_init_4() {
/* 948 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 949 */
/* 950 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 951 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[34];
/* 952 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[35];
/* 953 */
/* 954 */   }
/* 955 */
/* 956 */   protected void processNext() throws java.io.IOException {
/* 957 */     if (!agg_initAgg) {
/* 958 */       agg_initAgg = true;
/* 959 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 960 */       agg_doAggregateWithKeys();
/* 961 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 962 */     }
/* 963 */
/* 964 */     // output the result
/* 965 */
/* 966 */     while (agg_fastHashMapIter.next()) {
/* 967 */       wholestagecodegen_numOutputRows.add(1);
/* 968 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 969 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 970 */
/* 971 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 972 */
/* 973 */       append(agg_resultRow);
/* 974 */
/* 975 */       if (shouldStop()) return;
/* 976 */     }
/* 977 */     agg_fastHashMap.close();
/* 978 */
/* 979 */     while (agg_mapIter.next()) {
/* 980 */       wholestagecodegen_numOutputRows.add(1);
/* 981 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 982 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 983 */
/* 984 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 985 */
/* 986 */       append(agg_resultRow);
/* 987 */
/* 988 */       if (shouldStop()) return;
/* 989 */     }
/* 990 */
/* 991 */     agg_mapIter.close();
/* 992 */     if (agg_sorter == null) {
/* 993 */       agg_hashMap.free();
/* 994 */     }
/* 995 */   }
/* 996 */ }
