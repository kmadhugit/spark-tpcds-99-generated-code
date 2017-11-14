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
/* 021 */   private scala.collection.Iterator smj_leftInput;
/* 022 */   private scala.collection.Iterator smj_rightInput;
/* 023 */   private InternalRow smj_leftRow;
/* 024 */   private InternalRow smj_rightRow;
/* 025 */   private int smj_value4;
/* 026 */   private int smj_value5;
/* 027 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 028 */   private int smj_value6;
/* 029 */   private int smj_value7;
/* 030 */   private int smj_value8;
/* 031 */   private boolean smj_isNull4;
/* 032 */   private int smj_value9;
/* 033 */   private boolean smj_isNull5;
/* 034 */   private double smj_value10;
/* 035 */   private boolean smj_isNull6;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 037 */   private UnsafeRow smj_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 040 */   private UnsafeRow project_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 043 */   private UnsafeRow agg_result1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 046 */   private int agg_value6;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 050 */
/* 051 */   public GeneratedIterator(Object[] references) {
/* 052 */     this.references = references;
/* 053 */   }
/* 054 */
/* 055 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 056 */     partitionIndex = index;
/* 057 */     this.inputs = inputs;
/* 058 */     wholestagecodegen_init_0();
/* 059 */     wholestagecodegen_init_1();
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private void wholestagecodegen_init_0() {
/* 064 */     agg_initAgg = false;
/* 065 */
/* 066 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 067 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 068 */
/* 069 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 070 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 071 */     smj_leftInput = inputs[0];
/* 072 */     smj_rightInput = inputs[1];
/* 073 */
/* 074 */     smj_rightRow = null;
/* 075 */
/* 076 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 077 */
/* 078 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 079 */     smj_result = new UnsafeRow(8);
/* 080 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 081 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 8);
/* 082 */     project_result = new UnsafeRow(5);
/* 083 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   public class agg_FastHashMap {
/* 088 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 089 */     private int[] buckets;
/* 090 */     private int capacity = 1 << 16;
/* 091 */     private double loadFactor = 0.5;
/* 092 */     private int numBuckets = (int) (capacity / loadFactor);
/* 093 */     private int maxSteps = 2;
/* 094 */     private int numRows = 0;
/* 095 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 096 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 097 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 098 */     private Object emptyVBase;
/* 099 */     private long emptyVOff;
/* 100 */     private int emptyVLen;
/* 101 */     private boolean isBatchFull = false;
/* 102 */
/* 103 */     public agg_FastHashMap(
/* 104 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 105 */       InternalRow emptyAggregationBuffer) {
/* 106 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 107 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 108 */
/* 109 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 110 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 111 */
/* 112 */       emptyVBase = emptyBuffer;
/* 113 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 114 */       emptyVLen = emptyBuffer.length;
/* 115 */
/* 116 */       buckets = new int[numBuckets];
/* 117 */       java.util.Arrays.fill(buckets, -1);
/* 118 */     }
/* 119 */
/* 120 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 121 */       long h = hash(agg_key);
/* 122 */       int step = 0;
/* 123 */       int idx = (int) h & (numBuckets - 1);
/* 124 */       while (step < maxSteps) {
/* 125 */         // Return bucket index if it's either an empty slot or already contains the key
/* 126 */         if (buckets[idx] == -1) {
/* 127 */           if (numRows < capacity && !isBatchFull) {
/* 128 */             // creating the unsafe for new entry
/* 129 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 130 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 131 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 132 */               0);
/* 133 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 134 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 135 */               agg_holder,
/* 136 */               1);
/* 137 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 138 */             agg_rowWriter.zeroOutNullBytes();
/* 139 */             agg_rowWriter.write(0, agg_key);
/* 140 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 141 */             Object kbase = agg_result.getBaseObject();
/* 142 */             long koff = agg_result.getBaseOffset();
/* 143 */             int klen = agg_result.getSizeInBytes();
/* 144 */
/* 145 */             UnsafeRow vRow
/* 146 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 147 */             if (vRow == null) {
/* 148 */               isBatchFull = true;
/* 149 */             } else {
/* 150 */               buckets[idx] = numRows++;
/* 151 */             }
/* 152 */             return vRow;
/* 153 */           } else {
/* 154 */             // No more space
/* 155 */             return null;
/* 156 */           }
/* 157 */         } else if (equals(idx, agg_key)) {
/* 158 */           return batch.getValueRow(buckets[idx]);
/* 159 */         }
/* 160 */         idx = (idx + 1) & (numBuckets - 1);
/* 161 */         step++;
/* 162 */       }
/* 163 */       // Didn't find it
/* 164 */       return null;
/* 165 */     }
/* 166 */
/* 167 */     private boolean equals(int idx, int agg_key) {
/* 168 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 169 */       return (row.getInt(0) == agg_key);
/* 170 */     }
/* 171 */
/* 172 */     private long hash(int agg_key) {
/* 173 */       long agg_hash = 0;
/* 174 */
/* 175 */       int agg_result = agg_key;
/* 176 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 177 */
/* 178 */       return agg_hash;
/* 179 */     }
/* 180 */
/* 181 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 182 */       return batch.rowIterator();
/* 183 */     }
/* 184 */
/* 185 */     public void close() {
/* 186 */       batch.close();
/* 187 */     }
/* 188 */
/* 189 */   }
/* 190 */
/* 191 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 192 */     agg_hashMap = agg_plan.createHashMap();
/* 193 */
/* 194 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 195 */       smj_isNull4 = smj_leftRow.isNullAt(0);
/* 196 */       smj_value8 = smj_isNull4 ? -1 : (smj_leftRow.getInt(0));
/* 197 */       smj_isNull5 = smj_leftRow.isNullAt(1);
/* 198 */       smj_value9 = smj_isNull5 ? -1 : (smj_leftRow.getInt(1));
/* 199 */       smj_isNull6 = smj_leftRow.isNullAt(2);
/* 200 */       smj_value10 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(2));
/* 201 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 202 */       while (smj_iterator.hasNext()) {
/* 203 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 204 */
/* 205 */         smj_numOutputRows.add(1);
/* 206 */
/* 207 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(2);
/* 208 */         double smj_value13 = smj_isNull9 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 209 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(3);
/* 210 */         double smj_value14 = smj_isNull10 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 211 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(4);
/* 212 */         double smj_value15 = smj_isNull11 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 213 */
/* 214 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 215 */
/* 216 */         UnsafeRow agg_fastAggBuffer = null;
/* 217 */
/* 218 */         if (true) {
/* 219 */           if (!smj_isNull4) {
/* 220 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 221 */               smj_value8);
/* 222 */           }
/* 223 */         }
/* 224 */
/* 225 */         if (agg_fastAggBuffer == null) {
/* 226 */           // generate grouping key
/* 227 */           agg_rowWriter.zeroOutNullBytes();
/* 228 */
/* 229 */           if (smj_isNull4) {
/* 230 */             agg_rowWriter.setNullAt(0);
/* 231 */           } else {
/* 232 */             agg_rowWriter.write(0, smj_value8);
/* 233 */           }
/* 234 */           agg_value6 = 42;
/* 235 */
/* 236 */           if (!smj_isNull4) {
/* 237 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value8, agg_value6);
/* 238 */           }
/* 239 */           if (true) {
/* 240 */             // try to get the buffer from hash map
/* 241 */             agg_unsafeRowAggBuffer =
/* 242 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 243 */           }
/* 244 */           if (agg_unsafeRowAggBuffer == null) {
/* 245 */             if (agg_sorter == null) {
/* 246 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 247 */             } else {
/* 248 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 249 */             }
/* 250 */
/* 251 */             // the hash map had be spilled, it should have enough memory now,
/* 252 */             // try  to allocate buffer again.
/* 253 */             agg_unsafeRowAggBuffer =
/* 254 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 255 */             if (agg_unsafeRowAggBuffer == null) {
/* 256 */               // failed to allocate the first page
/* 257 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 258 */             }
/* 259 */           }
/* 260 */         }
/* 261 */
/* 262 */         if (agg_fastAggBuffer != null) {
/* 263 */           // update fast row
/* 264 */
/* 265 */           // common sub-expressions
/* 266 */
/* 267 */           // evaluate aggregate function
/* 268 */           boolean agg_isNull27 = true;
/* 269 */           double agg_value29 = -1.0;
/* 270 */
/* 271 */           boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 272 */           double agg_value31 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 273 */           boolean agg_isNull28 = agg_isNull29;
/* 274 */           double agg_value30 = agg_value31;
/* 275 */           if (agg_isNull28) {
/* 276 */             boolean agg_isNull30 = false;
/* 277 */             double agg_value32 = -1.0;
/* 278 */             if (!false) {
/* 279 */               agg_value32 = (double) 0;
/* 280 */             }
/* 281 */             if (!agg_isNull30) {
/* 282 */               agg_isNull28 = false;
/* 283 */               agg_value30 = agg_value32;
/* 284 */             }
/* 285 */           }
/* 286 */
/* 287 */           if (!smj_isNull6) {
/* 288 */             agg_isNull27 = false; // resultCode could change nullability.
/* 289 */             agg_value29 = agg_value30 + smj_value10;
/* 290 */
/* 291 */           }
/* 292 */           boolean agg_isNull26 = agg_isNull27;
/* 293 */           double agg_value28 = agg_value29;
/* 294 */           if (agg_isNull26) {
/* 295 */             boolean agg_isNull33 = agg_fastAggBuffer.isNullAt(0);
/* 296 */             double agg_value35 = agg_isNull33 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 297 */             if (!agg_isNull33) {
/* 298 */               agg_isNull26 = false;
/* 299 */               agg_value28 = agg_value35;
/* 300 */             }
/* 301 */           }
/* 302 */           boolean agg_isNull35 = true;
/* 303 */           double agg_value37 = -1.0;
/* 304 */
/* 305 */           boolean agg_isNull37 = agg_fastAggBuffer.isNullAt(1);
/* 306 */           double agg_value39 = agg_isNull37 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 307 */           boolean agg_isNull36 = agg_isNull37;
/* 308 */           double agg_value38 = agg_value39;
/* 309 */           if (agg_isNull36) {
/* 310 */             boolean agg_isNull38 = false;
/* 311 */             double agg_value40 = -1.0;
/* 312 */             if (!false) {
/* 313 */               agg_value40 = (double) 0;
/* 314 */             }
/* 315 */             if (!agg_isNull38) {
/* 316 */               agg_isNull36 = false;
/* 317 */               agg_value38 = agg_value40;
/* 318 */             }
/* 319 */           }
/* 320 */
/* 321 */           boolean agg_isNull40 = true;
/* 322 */           double agg_value42 = -1.0;
/* 323 */
/* 324 */           boolean agg_isNull41 = true;
/* 325 */           double agg_value43 = -1.0;
/* 326 */
/* 327 */           if (!smj_isNull9) {
/* 328 */             if (!smj_isNull10) {
/* 329 */               agg_isNull41 = false; // resultCode could change nullability.
/* 330 */               agg_value43 = smj_value13 + smj_value14;
/* 331 */
/* 332 */             }
/* 333 */
/* 334 */           }
/* 335 */           if (!agg_isNull41) {
/* 336 */             if (!smj_isNull11) {
/* 337 */               agg_isNull40 = false; // resultCode could change nullability.
/* 338 */               agg_value42 = agg_value43 + smj_value15;
/* 339 */
/* 340 */             }
/* 341 */
/* 342 */           }
/* 343 */           if (!agg_isNull40) {
/* 344 */             agg_isNull35 = false; // resultCode could change nullability.
/* 345 */             agg_value37 = agg_value38 + agg_value42;
/* 346 */
/* 347 */           }
/* 348 */           boolean agg_isNull34 = agg_isNull35;
/* 349 */           double agg_value36 = agg_value37;
/* 350 */           if (agg_isNull34) {
/* 351 */             boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(1);
/* 352 */             double agg_value47 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 353 */             if (!agg_isNull45) {
/* 354 */               agg_isNull34 = false;
/* 355 */               agg_value36 = agg_value47;
/* 356 */             }
/* 357 */           }
/* 358 */           // update fast row
/* 359 */           if (!agg_isNull26) {
/* 360 */             agg_fastAggBuffer.setDouble(0, agg_value28);
/* 361 */           } else {
/* 362 */             agg_fastAggBuffer.setNullAt(0);
/* 363 */           }
/* 364 */
/* 365 */           if (!agg_isNull34) {
/* 366 */             agg_fastAggBuffer.setDouble(1, agg_value36);
/* 367 */           } else {
/* 368 */             agg_fastAggBuffer.setNullAt(1);
/* 369 */           }
/* 370 */
/* 371 */         } else {
/* 372 */           // update unsafe row
/* 373 */
/* 374 */           // common sub-expressions
/* 375 */
/* 376 */           // evaluate aggregate function
/* 377 */           boolean agg_isNull7 = true;
/* 378 */           double agg_value9 = -1.0;
/* 379 */
/* 380 */           boolean agg_isNull9 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 381 */           double agg_value11 = agg_isNull9 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 382 */           boolean agg_isNull8 = agg_isNull9;
/* 383 */           double agg_value10 = agg_value11;
/* 384 */           if (agg_isNull8) {
/* 385 */             boolean agg_isNull10 = false;
/* 386 */             double agg_value12 = -1.0;
/* 387 */             if (!false) {
/* 388 */               agg_value12 = (double) 0;
/* 389 */             }
/* 390 */             if (!agg_isNull10) {
/* 391 */               agg_isNull8 = false;
/* 392 */               agg_value10 = agg_value12;
/* 393 */             }
/* 394 */           }
/* 395 */
/* 396 */           if (!smj_isNull6) {
/* 397 */             agg_isNull7 = false; // resultCode could change nullability.
/* 398 */             agg_value9 = agg_value10 + smj_value10;
/* 399 */
/* 400 */           }
/* 401 */           boolean agg_isNull6 = agg_isNull7;
/* 402 */           double agg_value8 = agg_value9;
/* 403 */           if (agg_isNull6) {
/* 404 */             boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 405 */             double agg_value15 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 406 */             if (!agg_isNull13) {
/* 407 */               agg_isNull6 = false;
/* 408 */               agg_value8 = agg_value15;
/* 409 */             }
/* 410 */           }
/* 411 */           boolean agg_isNull15 = true;
/* 412 */           double agg_value17 = -1.0;
/* 413 */
/* 414 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 415 */           double agg_value19 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 416 */           boolean agg_isNull16 = agg_isNull17;
/* 417 */           double agg_value18 = agg_value19;
/* 418 */           if (agg_isNull16) {
/* 419 */             boolean agg_isNull18 = false;
/* 420 */             double agg_value20 = -1.0;
/* 421 */             if (!false) {
/* 422 */               agg_value20 = (double) 0;
/* 423 */             }
/* 424 */             if (!agg_isNull18) {
/* 425 */               agg_isNull16 = false;
/* 426 */               agg_value18 = agg_value20;
/* 427 */             }
/* 428 */           }
/* 429 */
/* 430 */           boolean agg_isNull20 = true;
/* 431 */           double agg_value22 = -1.0;
/* 432 */
/* 433 */           boolean agg_isNull21 = true;
/* 434 */           double agg_value23 = -1.0;
/* 435 */
/* 436 */           if (!smj_isNull9) {
/* 437 */             if (!smj_isNull10) {
/* 438 */               agg_isNull21 = false; // resultCode could change nullability.
/* 439 */               agg_value23 = smj_value13 + smj_value14;
/* 440 */
/* 441 */             }
/* 442 */
/* 443 */           }
/* 444 */           if (!agg_isNull21) {
/* 445 */             if (!smj_isNull11) {
/* 446 */               agg_isNull20 = false; // resultCode could change nullability.
/* 447 */               agg_value22 = agg_value23 + smj_value15;
/* 448 */
/* 449 */             }
/* 450 */
/* 451 */           }
/* 452 */           if (!agg_isNull20) {
/* 453 */             agg_isNull15 = false; // resultCode could change nullability.
/* 454 */             agg_value17 = agg_value18 + agg_value22;
/* 455 */
/* 456 */           }
/* 457 */           boolean agg_isNull14 = agg_isNull15;
/* 458 */           double agg_value16 = agg_value17;
/* 459 */           if (agg_isNull14) {
/* 460 */             boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 461 */             double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 462 */             if (!agg_isNull25) {
/* 463 */               agg_isNull14 = false;
/* 464 */               agg_value16 = agg_value27;
/* 465 */             }
/* 466 */           }
/* 467 */           // update unsafe row buffer
/* 468 */           if (!agg_isNull6) {
/* 469 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value8);
/* 470 */           } else {
/* 471 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 472 */           }
/* 473 */
/* 474 */           if (!agg_isNull14) {
/* 475 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value16);
/* 476 */           } else {
/* 477 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 478 */           }
/* 479 */
/* 480 */         }
/* 481 */
/* 482 */       }
/* 483 */       if (shouldStop()) return;
/* 484 */     }
/* 485 */
/* 486 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 487 */
/* 488 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 489 */   }
/* 490 */
/* 491 */   private boolean findNextInnerJoinRows(
/* 492 */     scala.collection.Iterator leftIter,
/* 493 */     scala.collection.Iterator rightIter) {
/* 494 */     smj_leftRow = null;
/* 495 */     int comp = 0;
/* 496 */     while (smj_leftRow == null) {
/* 497 */       if (!leftIter.hasNext()) return false;
/* 498 */       smj_leftRow = (InternalRow) leftIter.next();
/* 499 */
/* 500 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 501 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 502 */
/* 503 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 504 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 505 */       if (smj_isNull || smj_isNull1) {
/* 506 */         smj_leftRow = null;
/* 507 */         continue;
/* 508 */       }
/* 509 */       if (!smj_matches.isEmpty()) {
/* 510 */         comp = 0;
/* 511 */         if (comp == 0) {
/* 512 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 513 */         }
/* 514 */         if (comp == 0) {
/* 515 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 516 */         }
/* 517 */
/* 518 */         if (comp == 0) {
/* 519 */           return true;
/* 520 */         }
/* 521 */         smj_matches.clear();
/* 522 */       }
/* 523 */
/* 524 */       do {
/* 525 */         if (smj_rightRow == null) {
/* 526 */           if (!rightIter.hasNext()) {
/* 527 */             smj_value6 = smj_value;
/* 528 */             smj_value7 = smj_value1;
/* 529 */             return !smj_matches.isEmpty();
/* 530 */           }
/* 531 */           smj_rightRow = (InternalRow) rightIter.next();
/* 532 */
/* 533 */           boolean smj_isNull2 = smj_rightRow.isNullAt(0);
/* 534 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(0));
/* 535 */
/* 536 */           boolean smj_isNull3 = smj_rightRow.isNullAt(1);
/* 537 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(1));
/* 538 */           if (smj_isNull2 || smj_isNull3) {
/* 539 */             smj_rightRow = null;
/* 540 */             continue;
/* 541 */           }
/* 542 */           smj_value4 = smj_value2;
/* 543 */           smj_value5 = smj_value3;
/* 544 */         }
/* 545 */
/* 546 */         comp = 0;
/* 547 */         if (comp == 0) {
/* 548 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 549 */         }
/* 550 */         if (comp == 0) {
/* 551 */           comp = (smj_value1 > smj_value5 ? 1 : smj_value1 < smj_value5 ? -1 : 0);
/* 552 */         }
/* 553 */
/* 554 */         if (comp > 0) {
/* 555 */           smj_rightRow = null;
/* 556 */         } else if (comp < 0) {
/* 557 */           if (!smj_matches.isEmpty()) {
/* 558 */             smj_value6 = smj_value;
/* 559 */             smj_value7 = smj_value1;
/* 560 */             return true;
/* 561 */           }
/* 562 */           smj_leftRow = null;
/* 563 */         } else {
/* 564 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 565 */           smj_rightRow = null;;
/* 566 */         }
/* 567 */       } while (smj_leftRow != null);
/* 568 */     }
/* 569 */     return false; // unreachable
/* 570 */   }
/* 571 */
/* 572 */   private void wholestagecodegen_init_1() {
/* 573 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 574 */     agg_result1 = new UnsafeRow(1);
/* 575 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 576 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 577 */
/* 578 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 579 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 580 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 581 */
/* 582 */   }
/* 583 */
/* 584 */   protected void processNext() throws java.io.IOException {
/* 585 */     if (!agg_initAgg) {
/* 586 */       agg_initAgg = true;
/* 587 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 588 */       agg_doAggregateWithKeys();
/* 589 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 590 */     }
/* 591 */
/* 592 */     // output the result
/* 593 */
/* 594 */     while (agg_fastHashMapIter.next()) {
/* 595 */       wholestagecodegen_numOutputRows.add(1);
/* 596 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 597 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 598 */
/* 599 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 600 */
/* 601 */       append(agg_resultRow.copy());
/* 602 */
/* 603 */       if (shouldStop()) return;
/* 604 */     }
/* 605 */     agg_fastHashMap.close();
/* 606 */
/* 607 */     while (agg_mapIter.next()) {
/* 608 */       wholestagecodegen_numOutputRows.add(1);
/* 609 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 610 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 611 */
/* 612 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 613 */
/* 614 */       append(agg_resultRow.copy());
/* 615 */
/* 616 */       if (shouldStop()) return;
/* 617 */     }
/* 618 */
/* 619 */     agg_mapIter.close();
/* 620 */     if (agg_sorter == null) {
/* 621 */       agg_hashMap.free();
/* 622 */     }
/* 623 */   }
/* 624 */ }
