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
/* 025 */   private java.util.ArrayList smj_matches;
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
/* 088 */     smj_matches = new java.util.ArrayList();
/* 089 */
/* 090 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 091 */     smj_result = new UnsafeRow(9);
/* 092 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 093 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 094 */     project_result = new UnsafeRow(5);
/* 095 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 096 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   public class agg_FastHashMap {
/* 101 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 102 */     private int[] buckets;
/* 103 */     private int capacity = 1 << 16;
/* 104 */     private double loadFactor = 0.5;
/* 105 */     private int numBuckets = (int) (capacity / loadFactor);
/* 106 */     private int maxSteps = 2;
/* 107 */     private int numRows = 0;
/* 108 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("ss_customer_sk", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 109 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 110 */     private Object emptyVBase;
/* 111 */     private long emptyVOff;
/* 112 */     private int emptyVLen;
/* 113 */     private boolean isBatchFull = false;
/* 114 */
/* 115 */     public agg_FastHashMap(
/* 116 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 117 */       InternalRow emptyAggregationBuffer) {
/* 118 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 119 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 120 */
/* 121 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 122 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 123 */
/* 124 */       emptyVBase = emptyBuffer;
/* 125 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 126 */       emptyVLen = emptyBuffer.length;
/* 127 */
/* 128 */       buckets = new int[numBuckets];
/* 129 */       java.util.Arrays.fill(buckets, -1);
/* 130 */     }
/* 131 */
/* 132 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 133 */       long h = hash(agg_key);
/* 134 */       int step = 0;
/* 135 */       int idx = (int) h & (numBuckets - 1);
/* 136 */       while (step < maxSteps) {
/* 137 */         // Return bucket index if it's either an empty slot or already contains the key
/* 138 */         if (buckets[idx] == -1) {
/* 139 */           if (numRows < capacity && !isBatchFull) {
/* 140 */             // creating the unsafe for new entry
/* 141 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 142 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 143 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 144 */               0);
/* 145 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 146 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 147 */               agg_holder,
/* 148 */               1);
/* 149 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 150 */             agg_rowWriter.zeroOutNullBytes();
/* 151 */             agg_rowWriter.write(0, agg_key);
/* 152 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 153 */             Object kbase = agg_result.getBaseObject();
/* 154 */             long koff = agg_result.getBaseOffset();
/* 155 */             int klen = agg_result.getSizeInBytes();
/* 156 */
/* 157 */             UnsafeRow vRow
/* 158 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 159 */             if (vRow == null) {
/* 160 */               isBatchFull = true;
/* 161 */             } else {
/* 162 */               buckets[idx] = numRows++;
/* 163 */             }
/* 164 */             return vRow;
/* 165 */           } else {
/* 166 */             // No more space
/* 167 */             return null;
/* 168 */           }
/* 169 */         } else if (equals(idx, agg_key)) {
/* 170 */           return batch.getValueRow(buckets[idx]);
/* 171 */         }
/* 172 */         idx = (idx + 1) & (numBuckets - 1);
/* 173 */         step++;
/* 174 */       }
/* 175 */       // Didn't find it
/* 176 */       return null;
/* 177 */     }
/* 178 */
/* 179 */     private boolean equals(int idx, int agg_key) {
/* 180 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 181 */       return (row.getInt(0) == agg_key);
/* 182 */     }
/* 183 */
/* 184 */     private long hash(int agg_key) {
/* 185 */       long agg_hash = 0;
/* 186 */
/* 187 */       int agg_result = agg_key;
/* 188 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 189 */
/* 190 */       return agg_hash;
/* 191 */     }
/* 192 */
/* 193 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 194 */       return batch.rowIterator();
/* 195 */     }
/* 196 */
/* 197 */     public void close() {
/* 198 */       batch.close();
/* 199 */     }
/* 200 */
/* 201 */   }
/* 202 */
/* 203 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 204 */     agg_hashMap = agg_plan.createHashMap();
/* 205 */
/* 206 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 207 */       int smj_size = smj_matches.size();
/* 208 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 209 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 210 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 211 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 212 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 213 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 214 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 215 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 216 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 217 */       smj_value14 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 218 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 219 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 220 */
/* 221 */         smj_numOutputRows.add(1);
/* 222 */
/* 223 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(1);
/* 224 */         long smj_value16 = smj_isNull12 ? -1L : (smj_rightRow1.getLong(1));
/* 225 */
/* 226 */         // generate join key for stream side
/* 227 */
/* 228 */         // find matches from HashedRelation
/* 229 */         UnsafeRow bhj_matched = smj_isNull12 ? null: (UnsafeRow)bhj_relation.getValue(smj_value16);
/* 230 */         if (bhj_matched == null) continue;
/* 231 */
/* 232 */         bhj_numOutputRows.add(1);
/* 233 */
/* 234 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(3);
/* 235 */         long smj_value18 = smj_isNull14 ? -1L : (smj_rightRow1.getLong(3));
/* 236 */
/* 237 */         boolean project_isNull11 = true;
/* 238 */         double project_value11 = -1.0;
/* 239 */
/* 240 */         if (!false && (!(smj_isNull14))) {
/* 241 */           boolean project_isNull14 = true;
/* 242 */           double project_value14 = -1.0;
/* 243 */
/* 244 */           boolean project_isNull16 = true;
/* 245 */           long project_value16 = -1L;
/* 246 */
/* 247 */           boolean project_isNull17 = smj_isNull9;
/* 248 */           long project_value17 = -1L;
/* 249 */           if (!smj_isNull9) {
/* 250 */             project_value17 = (long) smj_value13;
/* 251 */           }
/* 252 */           if (!project_isNull17) {
/* 253 */             if (!smj_isNull14) {
/* 254 */               project_isNull16 = false; // resultCode could change nullability.
/* 255 */               project_value16 = project_value17 - smj_value18;
/* 256 */
/* 257 */             }
/* 258 */
/* 259 */           }
/* 260 */           boolean project_isNull15 = project_isNull16;
/* 261 */           double project_value15 = -1.0;
/* 262 */           if (!project_isNull16) {
/* 263 */             project_value15 = (double) project_value16;
/* 264 */           }
/* 265 */           if (!project_isNull15) {
/* 266 */             if (!smj_isNull10) {
/* 267 */               project_isNull14 = false; // resultCode could change nullability.
/* 268 */               project_value14 = project_value15 * smj_value14;
/* 269 */
/* 270 */             }
/* 271 */
/* 272 */           }
/* 273 */           project_isNull11 = project_isNull14;
/* 274 */           project_value11 = project_value14;
/* 275 */         }
/* 276 */
/* 277 */         else {
/* 278 */           boolean project_isNull21 = true;
/* 279 */           double project_value21 = -1.0;
/* 280 */
/* 281 */           boolean project_isNull22 = smj_isNull9;
/* 282 */           double project_value22 = -1.0;
/* 283 */           if (!smj_isNull9) {
/* 284 */             project_value22 = (double) smj_value13;
/* 285 */           }
/* 286 */           if (!project_isNull22) {
/* 287 */             if (!smj_isNull10) {
/* 288 */               project_isNull21 = false; // resultCode could change nullability.
/* 289 */               project_value21 = project_value22 * smj_value14;
/* 290 */
/* 291 */             }
/* 292 */
/* 293 */           }
/* 294 */           project_isNull11 = project_isNull21;
/* 295 */           project_value11 = project_value21;
/* 296 */         }
/* 297 */
/* 298 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 299 */
/* 300 */         UnsafeRow agg_fastAggBuffer = null;
/* 301 */
/* 302 */         if (true) {
/* 303 */           if (!smj_isNull7) {
/* 304 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 305 */               smj_value11);
/* 306 */           }
/* 307 */         }
/* 308 */
/* 309 */         if (agg_fastAggBuffer == null) {
/* 310 */           // generate grouping key
/* 311 */           agg_rowWriter.zeroOutNullBytes();
/* 312 */
/* 313 */           if (smj_isNull7) {
/* 314 */             agg_rowWriter.setNullAt(0);
/* 315 */           } else {
/* 316 */             agg_rowWriter.write(0, smj_value11);
/* 317 */           }
/* 318 */           agg_value4 = 42;
/* 319 */
/* 320 */           if (!smj_isNull7) {
/* 321 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value11, agg_value4);
/* 322 */           }
/* 323 */           if (true) {
/* 324 */             // try to get the buffer from hash map
/* 325 */             agg_unsafeRowAggBuffer =
/* 326 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 327 */           }
/* 328 */           if (agg_unsafeRowAggBuffer == null) {
/* 329 */             if (agg_sorter == null) {
/* 330 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 331 */             } else {
/* 332 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 333 */             }
/* 334 */
/* 335 */             // the hash map had be spilled, it should have enough memory now,
/* 336 */             // try  to allocate buffer again.
/* 337 */             agg_unsafeRowAggBuffer =
/* 338 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 339 */             if (agg_unsafeRowAggBuffer == null) {
/* 340 */               // failed to allocate the first page
/* 341 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 342 */             }
/* 343 */           }
/* 344 */         }
/* 345 */
/* 346 */         if (agg_fastAggBuffer != null) {
/* 347 */           // update fast row
/* 348 */
/* 349 */           // common sub-expressions
/* 350 */
/* 351 */           // evaluate aggregate function
/* 352 */           boolean agg_isNull15 = true;
/* 353 */           double agg_value16 = -1.0;
/* 354 */
/* 355 */           boolean agg_isNull17 = agg_fastAggBuffer.isNullAt(0);
/* 356 */           double agg_value18 = agg_isNull17 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 357 */           boolean agg_isNull16 = agg_isNull17;
/* 358 */           double agg_value17 = agg_value18;
/* 359 */           if (agg_isNull16) {
/* 360 */             boolean agg_isNull18 = false;
/* 361 */             double agg_value19 = -1.0;
/* 362 */             if (!false) {
/* 363 */               agg_value19 = (double) 0;
/* 364 */             }
/* 365 */             if (!agg_isNull18) {
/* 366 */               agg_isNull16 = false;
/* 367 */               agg_value17 = agg_value19;
/* 368 */             }
/* 369 */           }
/* 370 */
/* 371 */           boolean agg_isNull20 = project_isNull11;
/* 372 */           double agg_value21 = -1.0;
/* 373 */           if (!project_isNull11) {
/* 374 */             agg_value21 = project_value11;
/* 375 */           }
/* 376 */           if (!agg_isNull20) {
/* 377 */             agg_isNull15 = false; // resultCode could change nullability.
/* 378 */             agg_value16 = agg_value17 + agg_value21;
/* 379 */
/* 380 */           }
/* 381 */           boolean agg_isNull14 = agg_isNull15;
/* 382 */           double agg_value15 = agg_value16;
/* 383 */           if (agg_isNull14) {
/* 384 */             boolean agg_isNull22 = agg_fastAggBuffer.isNullAt(0);
/* 385 */             double agg_value23 = agg_isNull22 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 386 */             if (!agg_isNull22) {
/* 387 */               agg_isNull14 = false;
/* 388 */               agg_value15 = agg_value23;
/* 389 */             }
/* 390 */           }
/* 391 */           // update fast row
/* 392 */           if (!agg_isNull14) {
/* 393 */             agg_fastAggBuffer.setDouble(0, agg_value15);
/* 394 */           } else {
/* 395 */             agg_fastAggBuffer.setNullAt(0);
/* 396 */           }
/* 397 */
/* 398 */         } else {
/* 399 */           // update unsafe row
/* 400 */
/* 401 */           // common sub-expressions
/* 402 */
/* 403 */           // evaluate aggregate function
/* 404 */           boolean agg_isNull6 = true;
/* 405 */           double agg_value7 = -1.0;
/* 406 */
/* 407 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 408 */           double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 409 */           boolean agg_isNull7 = agg_isNull8;
/* 410 */           double agg_value8 = agg_value9;
/* 411 */           if (agg_isNull7) {
/* 412 */             boolean agg_isNull9 = false;
/* 413 */             double agg_value10 = -1.0;
/* 414 */             if (!false) {
/* 415 */               agg_value10 = (double) 0;
/* 416 */             }
/* 417 */             if (!agg_isNull9) {
/* 418 */               agg_isNull7 = false;
/* 419 */               agg_value8 = agg_value10;
/* 420 */             }
/* 421 */           }
/* 422 */
/* 423 */           boolean agg_isNull11 = project_isNull11;
/* 424 */           double agg_value12 = -1.0;
/* 425 */           if (!project_isNull11) {
/* 426 */             agg_value12 = project_value11;
/* 427 */           }
/* 428 */           if (!agg_isNull11) {
/* 429 */             agg_isNull6 = false; // resultCode could change nullability.
/* 430 */             agg_value7 = agg_value8 + agg_value12;
/* 431 */
/* 432 */           }
/* 433 */           boolean agg_isNull5 = agg_isNull6;
/* 434 */           double agg_value6 = agg_value7;
/* 435 */           if (agg_isNull5) {
/* 436 */             boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 437 */             double agg_value14 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 438 */             if (!agg_isNull13) {
/* 439 */               agg_isNull5 = false;
/* 440 */               agg_value6 = agg_value14;
/* 441 */             }
/* 442 */           }
/* 443 */           // update unsafe row buffer
/* 444 */           if (!agg_isNull5) {
/* 445 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 446 */           } else {
/* 447 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 448 */           }
/* 449 */
/* 450 */         }
/* 451 */
/* 452 */       }
/* 453 */       if (shouldStop()) return;
/* 454 */     }
/* 455 */
/* 456 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 457 */
/* 458 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 459 */   }
/* 460 */
/* 461 */   private boolean findNextInnerJoinRows(
/* 462 */     scala.collection.Iterator leftIter,
/* 463 */     scala.collection.Iterator rightIter) {
/* 464 */     smj_leftRow = null;
/* 465 */     int comp = 0;
/* 466 */     while (smj_leftRow == null) {
/* 467 */       if (!leftIter.hasNext()) return false;
/* 468 */       smj_leftRow = (InternalRow) leftIter.next();
/* 469 */
/* 470 */       boolean smj_isNull1 = smj_leftRow.isNullAt(0);
/* 471 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(0));
/* 472 */       boolean smj_isNull = smj_isNull1;
/* 473 */       long smj_value = -1L;
/* 474 */       if (!smj_isNull1) {
/* 475 */         smj_value = (long) smj_value1;
/* 476 */       }
/* 477 */
/* 478 */       boolean smj_isNull3 = smj_leftRow.isNullAt(2);
/* 479 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(2));
/* 480 */       boolean smj_isNull2 = smj_isNull3;
/* 481 */       long smj_value2 = -1L;
/* 482 */       if (!smj_isNull3) {
/* 483 */         smj_value2 = (long) smj_value3;
/* 484 */       }
/* 485 */       if (smj_isNull || smj_isNull2) {
/* 486 */         smj_leftRow = null;
/* 487 */         continue;
/* 488 */       }
/* 489 */       if (!smj_matches.isEmpty()) {
/* 490 */         comp = 0;
/* 491 */         if (comp == 0) {
/* 492 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 493 */         }
/* 494 */         if (comp == 0) {
/* 495 */           comp = (smj_value2 > smj_value9 ? 1 : smj_value2 < smj_value9 ? -1 : 0);
/* 496 */         }
/* 497 */
/* 498 */         if (comp == 0) {
/* 499 */           return true;
/* 500 */         }
/* 501 */         smj_matches.clear();
/* 502 */       }
/* 503 */
/* 504 */       do {
/* 505 */         if (smj_rightRow == null) {
/* 506 */           if (!rightIter.hasNext()) {
/* 507 */             smj_value8 = smj_value;
/* 508 */             smj_value9 = smj_value2;
/* 509 */             return !smj_matches.isEmpty();
/* 510 */           }
/* 511 */           smj_rightRow = (InternalRow) rightIter.next();
/* 512 */
/* 513 */           boolean smj_isNull4 = smj_rightRow.isNullAt(0);
/* 514 */           long smj_value4 = smj_isNull4 ? -1L : (smj_rightRow.getLong(0));
/* 515 */
/* 516 */           boolean smj_isNull5 = smj_rightRow.isNullAt(2);
/* 517 */           long smj_value5 = smj_isNull5 ? -1L : (smj_rightRow.getLong(2));
/* 518 */           if (smj_isNull4 || smj_isNull5) {
/* 519 */             smj_rightRow = null;
/* 520 */             continue;
/* 521 */           }
/* 522 */           smj_value6 = smj_value4;
/* 523 */           smj_value7 = smj_value5;
/* 524 */         }
/* 525 */
/* 526 */         comp = 0;
/* 527 */         if (comp == 0) {
/* 528 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 529 */         }
/* 530 */         if (comp == 0) {
/* 531 */           comp = (smj_value2 > smj_value7 ? 1 : smj_value2 < smj_value7 ? -1 : 0);
/* 532 */         }
/* 533 */
/* 534 */         if (comp > 0) {
/* 535 */           smj_rightRow = null;
/* 536 */         } else if (comp < 0) {
/* 537 */           if (!smj_matches.isEmpty()) {
/* 538 */             smj_value8 = smj_value;
/* 539 */             smj_value9 = smj_value2;
/* 540 */             return true;
/* 541 */           }
/* 542 */           smj_leftRow = null;
/* 543 */         } else {
/* 544 */           smj_matches.add(smj_rightRow.copy());
/* 545 */           smj_rightRow = null;;
/* 546 */         }
/* 547 */       } while (smj_leftRow != null);
/* 548 */     }
/* 549 */     return false; // unreachable
/* 550 */   }
/* 551 */
/* 552 */   private void wholestagecodegen_init_2() {
/* 553 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 554 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 555 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 556 */
/* 557 */   }
/* 558 */
/* 559 */   private void wholestagecodegen_init_1() {
/* 560 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 561 */
/* 562 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 563 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 564 */
/* 565 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 566 */     bhj_result = new UnsafeRow(6);
/* 567 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 568 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 569 */     project_result1 = new UnsafeRow(2);
/* 570 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 571 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 572 */     agg_result1 = new UnsafeRow(1);
/* 573 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 574 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 575 */
/* 576 */   }
/* 577 */
/* 578 */   protected void processNext() throws java.io.IOException {
/* 579 */     if (!agg_initAgg) {
/* 580 */       agg_initAgg = true;
/* 581 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 582 */       agg_doAggregateWithKeys();
/* 583 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 584 */     }
/* 585 */
/* 586 */     // output the result
/* 587 */
/* 588 */     while (agg_fastHashMapIter.next()) {
/* 589 */       wholestagecodegen_numOutputRows.add(1);
/* 590 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 591 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 592 */
/* 593 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 594 */
/* 595 */       append(agg_resultRow.copy());
/* 596 */
/* 597 */       if (shouldStop()) return;
/* 598 */     }
/* 599 */     agg_fastHashMap.close();
/* 600 */
/* 601 */     while (agg_mapIter.next()) {
/* 602 */       wholestagecodegen_numOutputRows.add(1);
/* 603 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 604 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 605 */
/* 606 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 607 */
/* 608 */       append(agg_resultRow.copy());
/* 609 */
/* 610 */       if (shouldStop()) return;
/* 611 */     }
/* 612 */
/* 613 */     agg_mapIter.close();
/* 614 */     if (agg_sorter == null) {
/* 615 */       agg_hashMap.free();
/* 616 */     }
/* 617 */   }
/* 618 */ }
