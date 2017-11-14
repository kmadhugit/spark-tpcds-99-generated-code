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
/* 019 */   private scala.collection.Iterator scan_input;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 022 */   private long scan_scanTime1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 024 */   private int scan_batchIdx;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 028 */   private UnsafeRow scan_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 032 */   private UnsafeRow filter_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 041 */   private UnsafeRow bhj_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 048 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 050 */   private UnsafeRow bhj_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 053 */   private UnsafeRow project_result2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 056 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 057 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 059 */   private UnsafeRow bhj_result2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 062 */   private UnsafeRow project_result3;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 065 */   private UnsafeRow agg_result1;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 068 */   private int agg_value4;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 070 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 072 */
/* 073 */   public GeneratedIterator(Object[] references) {
/* 074 */     this.references = references;
/* 075 */   }
/* 076 */
/* 077 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 078 */     partitionIndex = index;
/* 079 */     this.inputs = inputs;
/* 080 */     wholestagecodegen_init_0();
/* 081 */     wholestagecodegen_init_1();
/* 082 */     wholestagecodegen_init_2();
/* 083 */     wholestagecodegen_init_3();
/* 084 */     wholestagecodegen_init_4();
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */   private void wholestagecodegen_init_0() {
/* 089 */     agg_initAgg = false;
/* 090 */
/* 091 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 092 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 093 */
/* 094 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 095 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 096 */     scan_input = inputs[0];
/* 097 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 098 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 099 */     scan_scanTime1 = 0;
/* 100 */     scan_batch = null;
/* 101 */     scan_batchIdx = 0;
/* 102 */     scan_colInstance0 = null;
/* 103 */     scan_colInstance1 = null;
/* 104 */     scan_colInstance2 = null;
/* 105 */     scan_result = new UnsafeRow(3);
/* 106 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 107 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 108 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 109 */
/* 110 */   }
/* 111 */
/* 112 */   private void wholestagecodegen_init_3() {
/* 113 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[24];
/* 114 */
/* 115 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 116 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 117 */
/* 118 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[25];
/* 119 */     bhj_result2 = new UnsafeRow(4);
/* 120 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 121 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 4);
/* 122 */     project_result3 = new UnsafeRow(2);
/* 123 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 124 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 125 */     agg_result1 = new UnsafeRow(1);
/* 126 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 127 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void scan_nextBatch() throws java.io.IOException {
/* 132 */     long getBatchStart = System.nanoTime();
/* 133 */     if (scan_input.hasNext()) {
/* 134 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 135 */       scan_numOutputRows.add(scan_batch.numRows());
/* 136 */       scan_batchIdx = 0;
/* 137 */       scan_colInstance0 = scan_batch.column(0);
/* 138 */       scan_colInstance1 = scan_batch.column(1);
/* 139 */       scan_colInstance2 = scan_batch.column(2);
/* 140 */
/* 141 */     }
/* 142 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 143 */   }
/* 144 */
/* 145 */   public class agg_FastHashMap {
/* 146 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 147 */     private int[] buckets;
/* 148 */     private int capacity = 1 << 16;
/* 149 */     private double loadFactor = 0.5;
/* 150 */     private int numBuckets = (int) (capacity / loadFactor);
/* 151 */     private int maxSteps = 2;
/* 152 */     private int numRows = 0;
/* 153 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 154 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 155 */     private Object emptyVBase;
/* 156 */     private long emptyVOff;
/* 157 */     private int emptyVLen;
/* 158 */     private boolean isBatchFull = false;
/* 159 */
/* 160 */     public agg_FastHashMap(
/* 161 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 162 */       InternalRow emptyAggregationBuffer) {
/* 163 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 164 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 165 */
/* 166 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 167 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 168 */
/* 169 */       emptyVBase = emptyBuffer;
/* 170 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 171 */       emptyVLen = emptyBuffer.length;
/* 172 */
/* 173 */       buckets = new int[numBuckets];
/* 174 */       java.util.Arrays.fill(buckets, -1);
/* 175 */     }
/* 176 */
/* 177 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 178 */       long h = hash(agg_key);
/* 179 */       int step = 0;
/* 180 */       int idx = (int) h & (numBuckets - 1);
/* 181 */       while (step < maxSteps) {
/* 182 */         // Return bucket index if it's either an empty slot or already contains the key
/* 183 */         if (buckets[idx] == -1) {
/* 184 */           if (numRows < capacity && !isBatchFull) {
/* 185 */             // creating the unsafe for new entry
/* 186 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 187 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 188 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 189 */               32);
/* 190 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 191 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 192 */               agg_holder,
/* 193 */               1);
/* 194 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 195 */             agg_rowWriter.zeroOutNullBytes();
/* 196 */             agg_rowWriter.write(0, agg_key);
/* 197 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 198 */             Object kbase = agg_result.getBaseObject();
/* 199 */             long koff = agg_result.getBaseOffset();
/* 200 */             int klen = agg_result.getSizeInBytes();
/* 201 */
/* 202 */             UnsafeRow vRow
/* 203 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 204 */             if (vRow == null) {
/* 205 */               isBatchFull = true;
/* 206 */             } else {
/* 207 */               buckets[idx] = numRows++;
/* 208 */             }
/* 209 */             return vRow;
/* 210 */           } else {
/* 211 */             // No more space
/* 212 */             return null;
/* 213 */           }
/* 214 */         } else if (equals(idx, agg_key)) {
/* 215 */           return batch.getValueRow(buckets[idx]);
/* 216 */         }
/* 217 */         idx = (idx + 1) & (numBuckets - 1);
/* 218 */         step++;
/* 219 */       }
/* 220 */       // Didn't find it
/* 221 */       return null;
/* 222 */     }
/* 223 */
/* 224 */     private boolean equals(int idx, UTF8String agg_key) {
/* 225 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 226 */       return (row.getUTF8String(0).equals(agg_key));
/* 227 */     }
/* 228 */
/* 229 */     private long hash(UTF8String agg_key) {
/* 230 */       long agg_hash = 0;
/* 231 */
/* 232 */       int agg_result = 0;
/* 233 */       byte[] agg_bytes = agg_key.getBytes();
/* 234 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 235 */         int agg_hash1 = agg_bytes[i];
/* 236 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 237 */       }
/* 238 */
/* 239 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 240 */
/* 241 */       return agg_hash;
/* 242 */     }
/* 243 */
/* 244 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 245 */       return batch.rowIterator();
/* 246 */     }
/* 247 */
/* 248 */     public void close() {
/* 249 */       batch.close();
/* 250 */     }
/* 251 */
/* 252 */   }
/* 253 */
/* 254 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 255 */     agg_hashMap = agg_plan.createHashMap();
/* 256 */
/* 257 */     if (scan_batch == null) {
/* 258 */       scan_nextBatch();
/* 259 */     }
/* 260 */     while (scan_batch != null) {
/* 261 */       int scan_numRows = scan_batch.numRows();
/* 262 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 263 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 264 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 265 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 266 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 267 */
/* 268 */         if (!(!(scan_isNull))) continue;
/* 269 */
/* 270 */         filter_numOutputRows.add(1);
/* 271 */
/* 272 */         // generate join key for stream side
/* 273 */
/* 274 */         boolean bhj_isNull = false;
/* 275 */         long bhj_value = -1L;
/* 276 */         if (!false) {
/* 277 */           bhj_value = (long) scan_value;
/* 278 */         }
/* 279 */         // find matches from HashedRelation
/* 280 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 281 */         if (bhj_matched == null) continue;
/* 282 */
/* 283 */         bhj_numOutputRows.add(1);
/* 284 */
/* 285 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 286 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 287 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 288 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 289 */
/* 290 */         // generate join key for stream side
/* 291 */
/* 292 */         boolean bhj_isNull9 = bhj_isNull3;
/* 293 */         long bhj_value9 = -1L;
/* 294 */         if (!bhj_isNull3) {
/* 295 */           bhj_value9 = (long) bhj_value3;
/* 296 */         }
/* 297 */         // find matches from HashedRelation
/* 298 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 299 */         if (bhj_matched1 == null) continue;
/* 300 */
/* 301 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 302 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(1));
/* 303 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(2);
/* 304 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(2));
/* 305 */
/* 306 */         boolean bhj_isNull17 = true;
/* 307 */         UTF8String bhj_value17 = null;
/* 308 */
/* 309 */         if (!bhj_isNull13) {
/* 310 */           bhj_isNull17 = false; // resultCode could change nullability.
/* 311 */           bhj_value17 = bhj_value13.substringSQL(1, 5);
/* 312 */
/* 313 */         }
/* 314 */         boolean bhj_value16 = false;
/* 315 */         boolean bhj_isNull16 = bhj_isNull17;
/* 316 */         if (!bhj_isNull16) {
/* 317 */           if (!bhj_value16) {
/* 318 */             if (false) {
/* 319 */               bhj_isNull16 = true;
/* 320 */             } else if (bhj_value17.equals(((UTF8String) references[11]))) {
/* 321 */               bhj_isNull16 = false;
/* 322 */               bhj_value16 = true;
/* 323 */             }
/* 324 */           }
/* 325 */
/* 326 */           if (!bhj_value16) {
/* 327 */             if (false) {
/* 328 */               bhj_isNull16 = true;
/* 329 */             } else if (bhj_value17.equals(((UTF8String) references[12]))) {
/* 330 */               bhj_isNull16 = false;
/* 331 */               bhj_value16 = true;
/* 332 */             }
/* 333 */           }
/* 334 */
/* 335 */           if (!bhj_value16) {
/* 336 */             if (false) {
/* 337 */               bhj_isNull16 = true;
/* 338 */             } else if (bhj_value17.equals(((UTF8String) references[13]))) {
/* 339 */               bhj_isNull16 = false;
/* 340 */               bhj_value16 = true;
/* 341 */             }
/* 342 */           }
/* 343 */
/* 344 */           if (!bhj_value16) {
/* 345 */             if (false) {
/* 346 */               bhj_isNull16 = true;
/* 347 */             } else if (bhj_value17.equals(((UTF8String) references[14]))) {
/* 348 */               bhj_isNull16 = false;
/* 349 */               bhj_value16 = true;
/* 350 */             }
/* 351 */           }
/* 352 */
/* 353 */           if (!bhj_value16) {
/* 354 */             if (false) {
/* 355 */               bhj_isNull16 = true;
/* 356 */             } else if (bhj_value17.equals(((UTF8String) references[15]))) {
/* 357 */               bhj_isNull16 = false;
/* 358 */               bhj_value16 = true;
/* 359 */             }
/* 360 */           }
/* 361 */
/* 362 */           if (!bhj_value16) {
/* 363 */             if (false) {
/* 364 */               bhj_isNull16 = true;
/* 365 */             } else if (bhj_value17.equals(((UTF8String) references[16]))) {
/* 366 */               bhj_isNull16 = false;
/* 367 */               bhj_value16 = true;
/* 368 */             }
/* 369 */           }
/* 370 */
/* 371 */           if (!bhj_value16) {
/* 372 */             if (false) {
/* 373 */               bhj_isNull16 = true;
/* 374 */             } else if (bhj_value17.equals(((UTF8String) references[17]))) {
/* 375 */               bhj_isNull16 = false;
/* 376 */               bhj_value16 = true;
/* 377 */             }
/* 378 */           }
/* 379 */
/* 380 */           if (!bhj_value16) {
/* 381 */             if (false) {
/* 382 */               bhj_isNull16 = true;
/* 383 */             } else if (bhj_value17.equals(((UTF8String) references[18]))) {
/* 384 */               bhj_isNull16 = false;
/* 385 */               bhj_value16 = true;
/* 386 */             }
/* 387 */           }
/* 388 */
/* 389 */           if (!bhj_value16) {
/* 390 */             if (false) {
/* 391 */               bhj_isNull16 = true;
/* 392 */             } else if (bhj_value17.equals(((UTF8String) references[19]))) {
/* 393 */               bhj_isNull16 = false;
/* 394 */               bhj_value16 = true;
/* 395 */             }
/* 396 */           }
/* 397 */
/* 398 */         }
/* 399 */         boolean bhj_isNull15 = false;
/* 400 */         boolean bhj_value15 = true;
/* 401 */
/* 402 */         if (!bhj_isNull16 && bhj_value16) {
/* 403 */         } else {
/* 404 */           boolean bhj_value30 = false;
/* 405 */           boolean bhj_isNull30 = bhj_isNull12;
/* 406 */           if (!bhj_isNull30) {
/* 407 */             if (!bhj_value30) {
/* 408 */               if (false) {
/* 409 */                 bhj_isNull30 = true;
/* 410 */               } else if (bhj_value12.equals(((UTF8String) references[20]))) {
/* 411 */                 bhj_isNull30 = false;
/* 412 */                 bhj_value30 = true;
/* 413 */               }
/* 414 */             }
/* 415 */
/* 416 */             if (!bhj_value30) {
/* 417 */               if (false) {
/* 418 */                 bhj_isNull30 = true;
/* 419 */               } else if (bhj_value12.equals(((UTF8String) references[21]))) {
/* 420 */                 bhj_isNull30 = false;
/* 421 */                 bhj_value30 = true;
/* 422 */               }
/* 423 */             }
/* 424 */
/* 425 */             if (!bhj_value30) {
/* 426 */               if (false) {
/* 427 */                 bhj_isNull30 = true;
/* 428 */               } else if (bhj_value12.equals(((UTF8String) references[22]))) {
/* 429 */                 bhj_isNull30 = false;
/* 430 */                 bhj_value30 = true;
/* 431 */               }
/* 432 */             }
/* 433 */
/* 434 */           }
/* 435 */           if (!bhj_isNull30 && bhj_value30) {
/* 436 */           } else if (!bhj_isNull16 && !bhj_isNull30) {
/* 437 */             bhj_value15 = false;
/* 438 */           } else {
/* 439 */             bhj_isNull15 = true;
/* 440 */           }
/* 441 */         }
/* 442 */         boolean bhj_isNull14 = false;
/* 443 */         boolean bhj_value14 = true;
/* 444 */
/* 445 */         if (!bhj_isNull15 && bhj_value15) {
/* 446 */         } else {
/* 447 */           boolean bhj_isNull35 = true;
/* 448 */           boolean bhj_value35 = false;
/* 449 */
/* 450 */           if (!scan_isNull1) {
/* 451 */             bhj_isNull35 = false; // resultCode could change nullability.
/* 452 */             bhj_value35 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 500.0D) > 0;
/* 453 */
/* 454 */           }
/* 455 */           if (!bhj_isNull35 && bhj_value35) {
/* 456 */           } else if (!bhj_isNull15 && !bhj_isNull35) {
/* 457 */             bhj_value14 = false;
/* 458 */           } else {
/* 459 */             bhj_isNull14 = true;
/* 460 */           }
/* 461 */         }
/* 462 */         if (bhj_isNull14 || !bhj_value14) continue;
/* 463 */
/* 464 */         bhj_numOutputRows1.add(1);
/* 465 */
/* 466 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 467 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 468 */
/* 469 */         // generate join key for stream side
/* 470 */
/* 471 */         boolean bhj_isNull44 = scan_isNull2;
/* 472 */         long bhj_value44 = -1L;
/* 473 */         if (!scan_isNull2) {
/* 474 */           bhj_value44 = (long) scan_value2;
/* 475 */         }
/* 476 */         // find matches from HashedRelation
/* 477 */         UnsafeRow bhj_matched2 = bhj_isNull44 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value44);
/* 478 */         if (bhj_matched2 == null) continue;
/* 479 */
/* 480 */         bhj_numOutputRows2.add(1);
/* 481 */
/* 482 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 483 */
/* 484 */         UnsafeRow agg_fastAggBuffer = null;
/* 485 */
/* 486 */         if (true) {
/* 487 */           if (!bhj_isNull13) {
/* 488 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 489 */               bhj_value13);
/* 490 */           }
/* 491 */         }
/* 492 */
/* 493 */         if (agg_fastAggBuffer == null) {
/* 494 */           // generate grouping key
/* 495 */           agg_holder.reset();
/* 496 */
/* 497 */           agg_rowWriter.zeroOutNullBytes();
/* 498 */
/* 499 */           if (bhj_isNull13) {
/* 500 */             agg_rowWriter.setNullAt(0);
/* 501 */           } else {
/* 502 */             agg_rowWriter.write(0, bhj_value13);
/* 503 */           }
/* 504 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 505 */           agg_value4 = 42;
/* 506 */
/* 507 */           if (!bhj_isNull13) {
/* 508 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value4);
/* 509 */           }
/* 510 */           if (true) {
/* 511 */             // try to get the buffer from hash map
/* 512 */             agg_unsafeRowAggBuffer =
/* 513 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 514 */           }
/* 515 */           if (agg_unsafeRowAggBuffer == null) {
/* 516 */             if (agg_sorter == null) {
/* 517 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 518 */             } else {
/* 519 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 520 */             }
/* 521 */
/* 522 */             // the hash map had be spilled, it should have enough memory now,
/* 523 */             // try  to allocate buffer again.
/* 524 */             agg_unsafeRowAggBuffer =
/* 525 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 526 */             if (agg_unsafeRowAggBuffer == null) {
/* 527 */               // failed to allocate the first page
/* 528 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 529 */             }
/* 530 */           }
/* 531 */         }
/* 532 */
/* 533 */         if (agg_fastAggBuffer != null) {
/* 534 */           // update fast row
/* 535 */
/* 536 */           // common sub-expressions
/* 537 */
/* 538 */           // evaluate aggregate function
/* 539 */           boolean agg_isNull14 = true;
/* 540 */           double agg_value15 = -1.0;
/* 541 */
/* 542 */           boolean agg_isNull16 = agg_fastAggBuffer.isNullAt(0);
/* 543 */           double agg_value17 = agg_isNull16 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 544 */           boolean agg_isNull15 = agg_isNull16;
/* 545 */           double agg_value16 = agg_value17;
/* 546 */           if (agg_isNull15) {
/* 547 */             boolean agg_isNull17 = false;
/* 548 */             double agg_value18 = -1.0;
/* 549 */             if (!false) {
/* 550 */               agg_value18 = (double) 0;
/* 551 */             }
/* 552 */             if (!agg_isNull17) {
/* 553 */               agg_isNull15 = false;
/* 554 */               agg_value16 = agg_value18;
/* 555 */             }
/* 556 */           }
/* 557 */
/* 558 */           if (!scan_isNull1) {
/* 559 */             agg_isNull14 = false; // resultCode could change nullability.
/* 560 */             agg_value15 = agg_value16 + scan_value1;
/* 561 */
/* 562 */           }
/* 563 */           boolean agg_isNull13 = agg_isNull14;
/* 564 */           double agg_value14 = agg_value15;
/* 565 */           if (agg_isNull13) {
/* 566 */             boolean agg_isNull20 = agg_fastAggBuffer.isNullAt(0);
/* 567 */             double agg_value21 = agg_isNull20 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 568 */             if (!agg_isNull20) {
/* 569 */               agg_isNull13 = false;
/* 570 */               agg_value14 = agg_value21;
/* 571 */             }
/* 572 */           }
/* 573 */           // update fast row
/* 574 */           if (!agg_isNull13) {
/* 575 */             agg_fastAggBuffer.setDouble(0, agg_value14);
/* 576 */           } else {
/* 577 */             agg_fastAggBuffer.setNullAt(0);
/* 578 */           }
/* 579 */
/* 580 */         } else {
/* 581 */           // update unsafe row
/* 582 */
/* 583 */           // common sub-expressions
/* 584 */
/* 585 */           // evaluate aggregate function
/* 586 */           boolean agg_isNull6 = true;
/* 587 */           double agg_value7 = -1.0;
/* 588 */
/* 589 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 590 */           double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 591 */           boolean agg_isNull7 = agg_isNull8;
/* 592 */           double agg_value8 = agg_value9;
/* 593 */           if (agg_isNull7) {
/* 594 */             boolean agg_isNull9 = false;
/* 595 */             double agg_value10 = -1.0;
/* 596 */             if (!false) {
/* 597 */               agg_value10 = (double) 0;
/* 598 */             }
/* 599 */             if (!agg_isNull9) {
/* 600 */               agg_isNull7 = false;
/* 601 */               agg_value8 = agg_value10;
/* 602 */             }
/* 603 */           }
/* 604 */
/* 605 */           if (!scan_isNull1) {
/* 606 */             agg_isNull6 = false; // resultCode could change nullability.
/* 607 */             agg_value7 = agg_value8 + scan_value1;
/* 608 */
/* 609 */           }
/* 610 */           boolean agg_isNull5 = agg_isNull6;
/* 611 */           double agg_value6 = agg_value7;
/* 612 */           if (agg_isNull5) {
/* 613 */             boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 614 */             double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 615 */             if (!agg_isNull12) {
/* 616 */               agg_isNull5 = false;
/* 617 */               agg_value6 = agg_value13;
/* 618 */             }
/* 619 */           }
/* 620 */           // update unsafe row buffer
/* 621 */           if (!agg_isNull5) {
/* 622 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 623 */           } else {
/* 624 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 625 */           }
/* 626 */
/* 627 */         }
/* 628 */         // shouldStop check is eliminated
/* 629 */       }
/* 630 */       scan_batchIdx = scan_numRows;
/* 631 */       scan_batch = null;
/* 632 */       scan_nextBatch();
/* 633 */     }
/* 634 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 635 */     scan_scanTime1 = 0;
/* 636 */
/* 637 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 638 */
/* 639 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 640 */   }
/* 641 */
/* 642 */   private void wholestagecodegen_init_2() {
/* 643 */     project_result1 = new UnsafeRow(3);
/* 644 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 645 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 646 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 647 */
/* 648 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 649 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 650 */
/* 651 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 652 */     bhj_result1 = new UnsafeRow(6);
/* 653 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 654 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 655 */     project_result2 = new UnsafeRow(3);
/* 656 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 657 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 658 */
/* 659 */   }
/* 660 */
/* 661 */   private void wholestagecodegen_init_1() {
/* 662 */     filter_result = new UnsafeRow(3);
/* 663 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 664 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 665 */     project_result = new UnsafeRow(3);
/* 666 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 667 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 668 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 669 */
/* 670 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 671 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 672 */
/* 673 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 674 */     bhj_result = new UnsafeRow(5);
/* 675 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 676 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 677 */
/* 678 */   }
/* 679 */
/* 680 */   private void wholestagecodegen_init_4() {
/* 681 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 682 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[26];
/* 683 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[27];
/* 684 */
/* 685 */   }
/* 686 */
/* 687 */   protected void processNext() throws java.io.IOException {
/* 688 */     if (!agg_initAgg) {
/* 689 */       agg_initAgg = true;
/* 690 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 691 */       agg_doAggregateWithKeys();
/* 692 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 693 */     }
/* 694 */
/* 695 */     // output the result
/* 696 */
/* 697 */     while (agg_fastHashMapIter.next()) {
/* 698 */       wholestagecodegen_numOutputRows.add(1);
/* 699 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 700 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 701 */
/* 702 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 703 */
/* 704 */       append(agg_resultRow);
/* 705 */
/* 706 */       if (shouldStop()) return;
/* 707 */     }
/* 708 */     agg_fastHashMap.close();
/* 709 */
/* 710 */     while (agg_mapIter.next()) {
/* 711 */       wholestagecodegen_numOutputRows.add(1);
/* 712 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 713 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 714 */
/* 715 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 716 */
/* 717 */       append(agg_resultRow);
/* 718 */
/* 719 */       if (shouldStop()) return;
/* 720 */     }
/* 721 */
/* 722 */     agg_mapIter.close();
/* 723 */     if (agg_sorter == null) {
/* 724 */       agg_hashMap.free();
/* 725 */     }
/* 726 */   }
/* 727 */ }
