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
/* 019 */   private scala.collection.Iterator smj_leftInput;
/* 020 */   private scala.collection.Iterator smj_rightInput;
/* 021 */   private InternalRow smj_leftRow;
/* 022 */   private InternalRow smj_rightRow;
/* 023 */   private long smj_value6;
/* 024 */   private long smj_value7;
/* 025 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 026 */   private long smj_value8;
/* 027 */   private long smj_value9;
/* 028 */   private int smj_value10;
/* 029 */   private boolean smj_isNull6;
/* 030 */   private int smj_value11;
/* 031 */   private boolean smj_isNull7;
/* 032 */   private int smj_value12;
/* 033 */   private boolean smj_isNull8;
/* 034 */   private int smj_value13;
/* 035 */   private boolean smj_isNull9;
/* 036 */   private double smj_value14;
/* 037 */   private boolean smj_isNull10;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 039 */   private UnsafeRow smj_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private UnsafeRow project_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 054 */   private UnsafeRow agg_result1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 057 */   private int agg_value4;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 060 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 061 */
/* 062 */   public GeneratedIterator(Object[] references) {
/* 063 */     this.references = references;
/* 064 */   }
/* 065 */
/* 066 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 067 */     partitionIndex = index;
/* 068 */     this.inputs = inputs;
/* 069 */     wholestagecodegen_init_0();
/* 070 */     wholestagecodegen_init_1();
/* 071 */     wholestagecodegen_init_2();
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */   private void wholestagecodegen_init_0() {
/* 076 */     agg_initAgg = false;
/* 077 */
/* 078 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 079 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 080 */
/* 081 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 082 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 083 */     smj_leftInput = inputs[0];
/* 084 */     smj_rightInput = inputs[1];
/* 085 */
/* 086 */     smj_rightRow = null;
/* 087 */
/* 088 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 089 */
/* 090 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 091 */     smj_result = new UnsafeRow(9);
/* 092 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 093 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 094 */     project_result = new UnsafeRow(5);
/* 095 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 096 */
/* 097 */   }
/* 098 */
/* 099 */   public class agg_FastHashMap {
/* 100 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 101 */     private int[] buckets;
/* 102 */     private int capacity = 1 << 16;
/* 103 */     private double loadFactor = 0.5;
/* 104 */     private int numBuckets = (int) (capacity / loadFactor);
/* 105 */     private int maxSteps = 2;
/* 106 */     private int numRows = 0;
/* 107 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 108 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 109 */     private Object emptyVBase;
/* 110 */     private long emptyVOff;
/* 111 */     private int emptyVLen;
/* 112 */     private boolean isBatchFull = false;
/* 113 */
/* 114 */     public agg_FastHashMap(
/* 115 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 116 */       InternalRow emptyAggregationBuffer) {
/* 117 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 118 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 119 */
/* 120 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 121 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 122 */
/* 123 */       emptyVBase = emptyBuffer;
/* 124 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 125 */       emptyVLen = emptyBuffer.length;
/* 126 */
/* 127 */       buckets = new int[numBuckets];
/* 128 */       java.util.Arrays.fill(buckets, -1);
/* 129 */     }
/* 130 */
/* 131 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 132 */       long h = hash(agg_key);
/* 133 */       int step = 0;
/* 134 */       int idx = (int) h & (numBuckets - 1);
/* 135 */       while (step < maxSteps) {
/* 136 */         // Return bucket index if it's either an empty slot or already contains the key
/* 137 */         if (buckets[idx] == -1) {
/* 138 */           if (numRows < capacity && !isBatchFull) {
/* 139 */             // creating the unsafe for new entry
/* 140 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 141 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 142 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 143 */               0);
/* 144 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 145 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 146 */               agg_holder,
/* 147 */               1);
/* 148 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 149 */             agg_rowWriter.zeroOutNullBytes();
/* 150 */             agg_rowWriter.write(0, agg_key);
/* 151 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 152 */             Object kbase = agg_result.getBaseObject();
/* 153 */             long koff = agg_result.getBaseOffset();
/* 154 */             int klen = agg_result.getSizeInBytes();
/* 155 */
/* 156 */             UnsafeRow vRow
/* 157 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 158 */             if (vRow == null) {
/* 159 */               isBatchFull = true;
/* 160 */             } else {
/* 161 */               buckets[idx] = numRows++;
/* 162 */             }
/* 163 */             return vRow;
/* 164 */           } else {
/* 165 */             // No more space
/* 166 */             return null;
/* 167 */           }
/* 168 */         } else if (equals(idx, agg_key)) {
/* 169 */           return batch.getValueRow(buckets[idx]);
/* 170 */         }
/* 171 */         idx = (idx + 1) & (numBuckets - 1);
/* 172 */         step++;
/* 173 */       }
/* 174 */       // Didn't find it
/* 175 */       return null;
/* 176 */     }
/* 177 */
/* 178 */     private boolean equals(int idx, int agg_key) {
/* 179 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 180 */       return (row.getInt(0) == agg_key);
/* 181 */     }
/* 182 */
/* 183 */     private long hash(int agg_key) {
/* 184 */       long agg_hash = 0;
/* 185 */
/* 186 */       int agg_result = agg_key;
/* 187 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 188 */
/* 189 */       return agg_hash;
/* 190 */     }
/* 191 */
/* 192 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 193 */       return batch.rowIterator();
/* 194 */     }
/* 195 */
/* 196 */     public void close() {
/* 197 */       batch.close();
/* 198 */     }
/* 199 */
/* 200 */   }
/* 201 */
/* 202 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 203 */     agg_hashMap = agg_plan.createHashMap();
/* 204 */
/* 205 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 206 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 207 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 208 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 209 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 210 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 211 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 212 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 213 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 214 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 215 */       smj_value14 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 216 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 217 */       while (smj_iterator.hasNext()) {
/* 218 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 219 */
/* 220 */         smj_numOutputRows.add(1);
/* 221 */
/* 222 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(1);
/* 223 */         long smj_value16 = smj_isNull12 ? -1L : (smj_rightRow1.getLong(1));
/* 224 */
/* 225 */         // generate join key for stream side
/* 226 */
/* 227 */         // find matches from HashedRelation
/* 228 */         UnsafeRow bhj_matched = smj_isNull12 ? null: (UnsafeRow)bhj_relation.getValue(smj_value16);
/* 229 */         if (bhj_matched == null) continue;
/* 230 */
/* 231 */         bhj_numOutputRows.add(1);
/* 232 */
/* 233 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(3);
/* 234 */         long smj_value18 = smj_isNull14 ? -1L : (smj_rightRow1.getLong(3));
/* 235 */
/* 236 */         boolean project_isNull11 = true;
/* 237 */         double project_value11 = -1.0;
/* 238 */
/* 239 */         if (!false && (!(smj_isNull14))) {
/* 240 */           boolean project_isNull14 = true;
/* 241 */           double project_value14 = -1.0;
/* 242 */
/* 243 */           boolean project_isNull16 = true;
/* 244 */           long project_value16 = -1L;
/* 245 */
/* 246 */           boolean project_isNull17 = smj_isNull9;
/* 247 */           long project_value17 = -1L;
/* 248 */           if (!smj_isNull9) {
/* 249 */             project_value17 = (long) smj_value13;
/* 250 */           }
/* 251 */           if (!project_isNull17) {
/* 252 */             if (!smj_isNull14) {
/* 253 */               project_isNull16 = false; // resultCode could change nullability.
/* 254 */               project_value16 = project_value17 - smj_value18;
/* 255 */
/* 256 */             }
/* 257 */
/* 258 */           }
/* 259 */           boolean project_isNull15 = project_isNull16;
/* 260 */           double project_value15 = -1.0;
/* 261 */           if (!project_isNull16) {
/* 262 */             project_value15 = (double) project_value16;
/* 263 */           }
/* 264 */           if (!project_isNull15) {
/* 265 */             if (!smj_isNull10) {
/* 266 */               project_isNull14 = false; // resultCode could change nullability.
/* 267 */               project_value14 = project_value15 * smj_value14;
/* 268 */
/* 269 */             }
/* 270 */
/* 271 */           }
/* 272 */           project_isNull11 = project_isNull14;
/* 273 */           project_value11 = project_value14;
/* 274 */         }
/* 275 */
/* 276 */         else {
/* 277 */           boolean project_isNull21 = true;
/* 278 */           double project_value21 = -1.0;
/* 279 */
/* 280 */           boolean project_isNull22 = smj_isNull9;
/* 281 */           double project_value22 = -1.0;
/* 282 */           if (!smj_isNull9) {
/* 283 */             project_value22 = (double) smj_value13;
/* 284 */           }
/* 285 */           if (!project_isNull22) {
/* 286 */             if (!smj_isNull10) {
/* 287 */               project_isNull21 = false; // resultCode could change nullability.
/* 288 */               project_value21 = project_value22 * smj_value14;
/* 289 */
/* 290 */             }
/* 291 */
/* 292 */           }
/* 293 */           project_isNull11 = project_isNull21;
/* 294 */           project_value11 = project_value21;
/* 295 */         }
/* 296 */
/* 297 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 298 */
/* 299 */         UnsafeRow agg_fastAggBuffer = null;
/* 300 */
/* 301 */         if (true) {
/* 302 */           if (!smj_isNull7) {
/* 303 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 304 */               smj_value11);
/* 305 */           }
/* 306 */         }
/* 307 */
/* 308 */         if (agg_fastAggBuffer == null) {
/* 309 */           // generate grouping key
/* 310 */           agg_rowWriter.zeroOutNullBytes();
/* 311 */
/* 312 */           if (smj_isNull7) {
/* 313 */             agg_rowWriter.setNullAt(0);
/* 314 */           } else {
/* 315 */             agg_rowWriter.write(0, smj_value11);
/* 316 */           }
/* 317 */           agg_value4 = 42;
/* 318 */
/* 319 */           if (!smj_isNull7) {
/* 320 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value11, agg_value4);
/* 321 */           }
/* 322 */           if (true) {
/* 323 */             // try to get the buffer from hash map
/* 324 */             agg_unsafeRowAggBuffer =
/* 325 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 326 */           }
/* 327 */           if (agg_unsafeRowAggBuffer == null) {
/* 328 */             if (agg_sorter == null) {
/* 329 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 330 */             } else {
/* 331 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 332 */             }
/* 333 */
/* 334 */             // the hash map had be spilled, it should have enough memory now,
/* 335 */             // try  to allocate buffer again.
/* 336 */             agg_unsafeRowAggBuffer =
/* 337 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 338 */             if (agg_unsafeRowAggBuffer == null) {
/* 339 */               // failed to allocate the first page
/* 340 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 341 */             }
/* 342 */           }
/* 343 */         }
/* 344 */
/* 345 */         if (agg_fastAggBuffer != null) {
/* 346 */           // update fast row
/* 347 */
/* 348 */           // common sub-expressions
/* 349 */
/* 350 */           // evaluate aggregate function
/* 351 */           boolean agg_isNull14 = true;
/* 352 */           double agg_value15 = -1.0;
/* 353 */
/* 354 */           boolean agg_isNull16 = agg_fastAggBuffer.isNullAt(0);
/* 355 */           double agg_value17 = agg_isNull16 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 356 */           boolean agg_isNull15 = agg_isNull16;
/* 357 */           double agg_value16 = agg_value17;
/* 358 */           if (agg_isNull15) {
/* 359 */             boolean agg_isNull17 = false;
/* 360 */             double agg_value18 = -1.0;
/* 361 */             if (!false) {
/* 362 */               agg_value18 = (double) 0;
/* 363 */             }
/* 364 */             if (!agg_isNull17) {
/* 365 */               agg_isNull15 = false;
/* 366 */               agg_value16 = agg_value18;
/* 367 */             }
/* 368 */           }
/* 369 */
/* 370 */           if (!project_isNull11) {
/* 371 */             agg_isNull14 = false; // resultCode could change nullability.
/* 372 */             agg_value15 = agg_value16 + project_value11;
/* 373 */
/* 374 */           }
/* 375 */           boolean agg_isNull13 = agg_isNull14;
/* 376 */           double agg_value14 = agg_value15;
/* 377 */           if (agg_isNull13) {
/* 378 */             boolean agg_isNull20 = agg_fastAggBuffer.isNullAt(0);
/* 379 */             double agg_value21 = agg_isNull20 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 380 */             if (!agg_isNull20) {
/* 381 */               agg_isNull13 = false;
/* 382 */               agg_value14 = agg_value21;
/* 383 */             }
/* 384 */           }
/* 385 */           // update fast row
/* 386 */           if (!agg_isNull13) {
/* 387 */             agg_fastAggBuffer.setDouble(0, agg_value14);
/* 388 */           } else {
/* 389 */             agg_fastAggBuffer.setNullAt(0);
/* 390 */           }
/* 391 */
/* 392 */         } else {
/* 393 */           // update unsafe row
/* 394 */
/* 395 */           // common sub-expressions
/* 396 */
/* 397 */           // evaluate aggregate function
/* 398 */           boolean agg_isNull6 = true;
/* 399 */           double agg_value7 = -1.0;
/* 400 */
/* 401 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 402 */           double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 403 */           boolean agg_isNull7 = agg_isNull8;
/* 404 */           double agg_value8 = agg_value9;
/* 405 */           if (agg_isNull7) {
/* 406 */             boolean agg_isNull9 = false;
/* 407 */             double agg_value10 = -1.0;
/* 408 */             if (!false) {
/* 409 */               agg_value10 = (double) 0;
/* 410 */             }
/* 411 */             if (!agg_isNull9) {
/* 412 */               agg_isNull7 = false;
/* 413 */               agg_value8 = agg_value10;
/* 414 */             }
/* 415 */           }
/* 416 */
/* 417 */           if (!project_isNull11) {
/* 418 */             agg_isNull6 = false; // resultCode could change nullability.
/* 419 */             agg_value7 = agg_value8 + project_value11;
/* 420 */
/* 421 */           }
/* 422 */           boolean agg_isNull5 = agg_isNull6;
/* 423 */           double agg_value6 = agg_value7;
/* 424 */           if (agg_isNull5) {
/* 425 */             boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 426 */             double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 427 */             if (!agg_isNull12) {
/* 428 */               agg_isNull5 = false;
/* 429 */               agg_value6 = agg_value13;
/* 430 */             }
/* 431 */           }
/* 432 */           // update unsafe row buffer
/* 433 */           if (!agg_isNull5) {
/* 434 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 435 */           } else {
/* 436 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 437 */           }
/* 438 */
/* 439 */         }
/* 440 */
/* 441 */       }
/* 442 */       if (shouldStop()) return;
/* 443 */     }
/* 444 */
/* 445 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 446 */
/* 447 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 448 */   }
/* 449 */
/* 450 */   private boolean findNextInnerJoinRows(
/* 451 */     scala.collection.Iterator leftIter,
/* 452 */     scala.collection.Iterator rightIter) {
/* 453 */     smj_leftRow = null;
/* 454 */     int comp = 0;
/* 455 */     while (smj_leftRow == null) {
/* 456 */       if (!leftIter.hasNext()) return false;
/* 457 */       smj_leftRow = (InternalRow) leftIter.next();
/* 458 */
/* 459 */       boolean smj_isNull1 = smj_leftRow.isNullAt(0);
/* 460 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(0));
/* 461 */       boolean smj_isNull = smj_isNull1;
/* 462 */       long smj_value = -1L;
/* 463 */       if (!smj_isNull1) {
/* 464 */         smj_value = (long) smj_value1;
/* 465 */       }
/* 466 */
/* 467 */       boolean smj_isNull3 = smj_leftRow.isNullAt(2);
/* 468 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(2));
/* 469 */       boolean smj_isNull2 = smj_isNull3;
/* 470 */       long smj_value2 = -1L;
/* 471 */       if (!smj_isNull3) {
/* 472 */         smj_value2 = (long) smj_value3;
/* 473 */       }
/* 474 */       if (smj_isNull || smj_isNull2) {
/* 475 */         smj_leftRow = null;
/* 476 */         continue;
/* 477 */       }
/* 478 */       if (!smj_matches.isEmpty()) {
/* 479 */         comp = 0;
/* 480 */         if (comp == 0) {
/* 481 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 482 */         }
/* 483 */         if (comp == 0) {
/* 484 */           comp = (smj_value2 > smj_value9 ? 1 : smj_value2 < smj_value9 ? -1 : 0);
/* 485 */         }
/* 486 */
/* 487 */         if (comp == 0) {
/* 488 */           return true;
/* 489 */         }
/* 490 */         smj_matches.clear();
/* 491 */       }
/* 492 */
/* 493 */       do {
/* 494 */         if (smj_rightRow == null) {
/* 495 */           if (!rightIter.hasNext()) {
/* 496 */             smj_value8 = smj_value;
/* 497 */             smj_value9 = smj_value2;
/* 498 */             return !smj_matches.isEmpty();
/* 499 */           }
/* 500 */           smj_rightRow = (InternalRow) rightIter.next();
/* 501 */
/* 502 */           boolean smj_isNull4 = smj_rightRow.isNullAt(0);
/* 503 */           long smj_value4 = smj_isNull4 ? -1L : (smj_rightRow.getLong(0));
/* 504 */
/* 505 */           boolean smj_isNull5 = smj_rightRow.isNullAt(2);
/* 506 */           long smj_value5 = smj_isNull5 ? -1L : (smj_rightRow.getLong(2));
/* 507 */           if (smj_isNull4 || smj_isNull5) {
/* 508 */             smj_rightRow = null;
/* 509 */             continue;
/* 510 */           }
/* 511 */           smj_value6 = smj_value4;
/* 512 */           smj_value7 = smj_value5;
/* 513 */         }
/* 514 */
/* 515 */         comp = 0;
/* 516 */         if (comp == 0) {
/* 517 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 518 */         }
/* 519 */         if (comp == 0) {
/* 520 */           comp = (smj_value2 > smj_value7 ? 1 : smj_value2 < smj_value7 ? -1 : 0);
/* 521 */         }
/* 522 */
/* 523 */         if (comp > 0) {
/* 524 */           smj_rightRow = null;
/* 525 */         } else if (comp < 0) {
/* 526 */           if (!smj_matches.isEmpty()) {
/* 527 */             smj_value8 = smj_value;
/* 528 */             smj_value9 = smj_value2;
/* 529 */             return true;
/* 530 */           }
/* 531 */           smj_leftRow = null;
/* 532 */         } else {
/* 533 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 534 */           smj_rightRow = null;;
/* 535 */         }
/* 536 */       } while (smj_leftRow != null);
/* 537 */     }
/* 538 */     return false; // unreachable
/* 539 */   }
/* 540 */
/* 541 */   private void wholestagecodegen_init_2() {
/* 542 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 543 */
/* 544 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 545 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 546 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 547 */
/* 548 */   }
/* 549 */
/* 550 */   private void wholestagecodegen_init_1() {
/* 551 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 552 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 553 */
/* 554 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 555 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 556 */
/* 557 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 558 */     bhj_result = new UnsafeRow(6);
/* 559 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 560 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 561 */     project_result1 = new UnsafeRow(2);
/* 562 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 563 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 564 */     agg_result1 = new UnsafeRow(1);
/* 565 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 566 */
/* 567 */   }
/* 568 */
/* 569 */   protected void processNext() throws java.io.IOException {
/* 570 */     if (!agg_initAgg) {
/* 571 */       agg_initAgg = true;
/* 572 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 573 */       agg_doAggregateWithKeys();
/* 574 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 575 */     }
/* 576 */
/* 577 */     // output the result
/* 578 */
/* 579 */     while (agg_fastHashMapIter.next()) {
/* 580 */       wholestagecodegen_numOutputRows.add(1);
/* 581 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 582 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 583 */
/* 584 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 585 */
/* 586 */       append(agg_resultRow.copy());
/* 587 */
/* 588 */       if (shouldStop()) return;
/* 589 */     }
/* 590 */     agg_fastHashMap.close();
/* 591 */
/* 592 */     while (agg_mapIter.next()) {
/* 593 */       wholestagecodegen_numOutputRows.add(1);
/* 594 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 595 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 596 */
/* 597 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 598 */
/* 599 */       append(agg_resultRow.copy());
/* 600 */
/* 601 */       if (shouldStop()) return;
/* 602 */     }
/* 603 */
/* 604 */     agg_mapIter.close();
/* 605 */     if (agg_sorter == null) {
/* 606 */       agg_hashMap.free();
/* 607 */     }
/* 608 */   }
/* 609 */ }
