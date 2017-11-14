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
/* 027 */   private java.util.ArrayList smj_matches;
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
/* 076 */     smj_matches = new java.util.ArrayList();
/* 077 */
/* 078 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 079 */     smj_result = new UnsafeRow(8);
/* 080 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 081 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 8);
/* 082 */     project_result = new UnsafeRow(5);
/* 083 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 084 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */   public class agg_FastHashMap {
/* 089 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 090 */     private int[] buckets;
/* 091 */     private int capacity = 1 << 16;
/* 092 */     private double loadFactor = 0.5;
/* 093 */     private int numBuckets = (int) (capacity / loadFactor);
/* 094 */     private int maxSteps = 2;
/* 095 */     private int numRows = 0;
/* 096 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("cs_item_sk", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 097 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 098 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 099 */     private Object emptyVBase;
/* 100 */     private long emptyVOff;
/* 101 */     private int emptyVLen;
/* 102 */     private boolean isBatchFull = false;
/* 103 */
/* 104 */     public agg_FastHashMap(
/* 105 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 106 */       InternalRow emptyAggregationBuffer) {
/* 107 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 108 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 109 */
/* 110 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 111 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 112 */
/* 113 */       emptyVBase = emptyBuffer;
/* 114 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 115 */       emptyVLen = emptyBuffer.length;
/* 116 */
/* 117 */       buckets = new int[numBuckets];
/* 118 */       java.util.Arrays.fill(buckets, -1);
/* 119 */     }
/* 120 */
/* 121 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 122 */       long h = hash(agg_key);
/* 123 */       int step = 0;
/* 124 */       int idx = (int) h & (numBuckets - 1);
/* 125 */       while (step < maxSteps) {
/* 126 */         // Return bucket index if it's either an empty slot or already contains the key
/* 127 */         if (buckets[idx] == -1) {
/* 128 */           if (numRows < capacity && !isBatchFull) {
/* 129 */             // creating the unsafe for new entry
/* 130 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 131 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 132 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 133 */               0);
/* 134 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 135 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 136 */               agg_holder,
/* 137 */               1);
/* 138 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 139 */             agg_rowWriter.zeroOutNullBytes();
/* 140 */             agg_rowWriter.write(0, agg_key);
/* 141 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 142 */             Object kbase = agg_result.getBaseObject();
/* 143 */             long koff = agg_result.getBaseOffset();
/* 144 */             int klen = agg_result.getSizeInBytes();
/* 145 */
/* 146 */             UnsafeRow vRow
/* 147 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 148 */             if (vRow == null) {
/* 149 */               isBatchFull = true;
/* 150 */             } else {
/* 151 */               buckets[idx] = numRows++;
/* 152 */             }
/* 153 */             return vRow;
/* 154 */           } else {
/* 155 */             // No more space
/* 156 */             return null;
/* 157 */           }
/* 158 */         } else if (equals(idx, agg_key)) {
/* 159 */           return batch.getValueRow(buckets[idx]);
/* 160 */         }
/* 161 */         idx = (idx + 1) & (numBuckets - 1);
/* 162 */         step++;
/* 163 */       }
/* 164 */       // Didn't find it
/* 165 */       return null;
/* 166 */     }
/* 167 */
/* 168 */     private boolean equals(int idx, int agg_key) {
/* 169 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 170 */       return (row.getInt(0) == agg_key);
/* 171 */     }
/* 172 */
/* 173 */     private long hash(int agg_key) {
/* 174 */       long agg_hash = 0;
/* 175 */
/* 176 */       int agg_result = agg_key;
/* 177 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 178 */
/* 179 */       return agg_hash;
/* 180 */     }
/* 181 */
/* 182 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 183 */       return batch.rowIterator();
/* 184 */     }
/* 185 */
/* 186 */     public void close() {
/* 187 */       batch.close();
/* 188 */     }
/* 189 */
/* 190 */   }
/* 191 */
/* 192 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 193 */     agg_hashMap = agg_plan.createHashMap();
/* 194 */
/* 195 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 196 */       int smj_size = smj_matches.size();
/* 197 */       smj_isNull4 = smj_leftRow.isNullAt(0);
/* 198 */       smj_value8 = smj_isNull4 ? -1 : (smj_leftRow.getInt(0));
/* 199 */       smj_isNull5 = smj_leftRow.isNullAt(1);
/* 200 */       smj_value9 = smj_isNull5 ? -1 : (smj_leftRow.getInt(1));
/* 201 */       smj_isNull6 = smj_leftRow.isNullAt(2);
/* 202 */       smj_value10 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(2));
/* 203 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 204 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 205 */
/* 206 */         smj_numOutputRows.add(1);
/* 207 */
/* 208 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(2);
/* 209 */         double smj_value13 = smj_isNull9 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 210 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(3);
/* 211 */         double smj_value14 = smj_isNull10 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 212 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(4);
/* 213 */         double smj_value15 = smj_isNull11 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 214 */
/* 215 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 216 */
/* 217 */         UnsafeRow agg_fastAggBuffer = null;
/* 218 */
/* 219 */         if (true) {
/* 220 */           if (!smj_isNull4) {
/* 221 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 222 */               smj_value8);
/* 223 */           }
/* 224 */         }
/* 225 */
/* 226 */         if (agg_fastAggBuffer == null) {
/* 227 */           // generate grouping key
/* 228 */           agg_rowWriter.zeroOutNullBytes();
/* 229 */
/* 230 */           if (smj_isNull4) {
/* 231 */             agg_rowWriter.setNullAt(0);
/* 232 */           } else {
/* 233 */             agg_rowWriter.write(0, smj_value8);
/* 234 */           }
/* 235 */           agg_value6 = 42;
/* 236 */
/* 237 */           if (!smj_isNull4) {
/* 238 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value8, agg_value6);
/* 239 */           }
/* 240 */           if (true) {
/* 241 */             // try to get the buffer from hash map
/* 242 */             agg_unsafeRowAggBuffer =
/* 243 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 244 */           }
/* 245 */           if (agg_unsafeRowAggBuffer == null) {
/* 246 */             if (agg_sorter == null) {
/* 247 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 248 */             } else {
/* 249 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 250 */             }
/* 251 */
/* 252 */             // the hash map had be spilled, it should have enough memory now,
/* 253 */             // try  to allocate buffer again.
/* 254 */             agg_unsafeRowAggBuffer =
/* 255 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 256 */             if (agg_unsafeRowAggBuffer == null) {
/* 257 */               // failed to allocate the first page
/* 258 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 259 */             }
/* 260 */           }
/* 261 */         }
/* 262 */
/* 263 */         if (agg_fastAggBuffer != null) {
/* 264 */           // update fast row
/* 265 */
/* 266 */           // common sub-expressions
/* 267 */           boolean agg_isNull26 = false;
/* 268 */           double agg_value28 = -1.0;
/* 269 */           if (!false) {
/* 270 */             agg_value28 = (double) 0;
/* 271 */           }
/* 272 */           // evaluate aggregate function
/* 273 */           boolean agg_isNull29 = true;
/* 274 */           double agg_value31 = -1.0;
/* 275 */
/* 276 */           boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(0);
/* 277 */           double agg_value33 = agg_isNull31 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 278 */           boolean agg_isNull30 = agg_isNull31;
/* 279 */           double agg_value32 = agg_value33;
/* 280 */           if (agg_isNull30) {
/* 281 */             if (!agg_isNull26) {
/* 282 */               agg_isNull30 = false;
/* 283 */               agg_value32 = agg_value28;
/* 284 */             }
/* 285 */           }
/* 286 */
/* 287 */           boolean agg_isNull32 = smj_isNull6;
/* 288 */           double agg_value34 = -1.0;
/* 289 */           if (!smj_isNull6) {
/* 290 */             agg_value34 = smj_value10;
/* 291 */           }
/* 292 */           if (!agg_isNull32) {
/* 293 */             agg_isNull29 = false; // resultCode could change nullability.
/* 294 */             agg_value31 = agg_value32 + agg_value34;
/* 295 */
/* 296 */           }
/* 297 */           boolean agg_isNull28 = agg_isNull29;
/* 298 */           double agg_value30 = agg_value31;
/* 299 */           if (agg_isNull28) {
/* 300 */             boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(0);
/* 301 */             double agg_value36 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 302 */             if (!agg_isNull34) {
/* 303 */               agg_isNull28 = false;
/* 304 */               agg_value30 = agg_value36;
/* 305 */             }
/* 306 */           }
/* 307 */           boolean agg_isNull36 = true;
/* 308 */           double agg_value38 = -1.0;
/* 309 */
/* 310 */           boolean agg_isNull38 = agg_fastAggBuffer.isNullAt(1);
/* 311 */           double agg_value40 = agg_isNull38 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 312 */           boolean agg_isNull37 = agg_isNull38;
/* 313 */           double agg_value39 = agg_value40;
/* 314 */           if (agg_isNull37) {
/* 315 */             if (!agg_isNull26) {
/* 316 */               agg_isNull37 = false;
/* 317 */               agg_value39 = agg_value28;
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
/* 343 */           boolean agg_isNull39 = agg_isNull40;
/* 344 */           double agg_value41 = -1.0;
/* 345 */           if (!agg_isNull40) {
/* 346 */             agg_value41 = agg_value42;
/* 347 */           }
/* 348 */           if (!agg_isNull39) {
/* 349 */             agg_isNull36 = false; // resultCode could change nullability.
/* 350 */             agg_value38 = agg_value39 + agg_value41;
/* 351 */
/* 352 */           }
/* 353 */           boolean agg_isNull35 = agg_isNull36;
/* 354 */           double agg_value37 = agg_value38;
/* 355 */           if (agg_isNull35) {
/* 356 */             boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(1);
/* 357 */             double agg_value47 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 358 */             if (!agg_isNull45) {
/* 359 */               agg_isNull35 = false;
/* 360 */               agg_value37 = agg_value47;
/* 361 */             }
/* 362 */           }
/* 363 */           // update fast row
/* 364 */           if (!agg_isNull28) {
/* 365 */             agg_fastAggBuffer.setDouble(0, agg_value30);
/* 366 */           } else {
/* 367 */             agg_fastAggBuffer.setNullAt(0);
/* 368 */           }
/* 369 */
/* 370 */           if (!agg_isNull35) {
/* 371 */             agg_fastAggBuffer.setDouble(1, agg_value37);
/* 372 */           } else {
/* 373 */             agg_fastAggBuffer.setNullAt(1);
/* 374 */           }
/* 375 */
/* 376 */         } else {
/* 377 */           // update unsafe row
/* 378 */
/* 379 */           // common sub-expressions
/* 380 */           boolean agg_isNull6 = false;
/* 381 */           double agg_value8 = -1.0;
/* 382 */           if (!false) {
/* 383 */             agg_value8 = (double) 0;
/* 384 */           }
/* 385 */           // evaluate aggregate function
/* 386 */           boolean agg_isNull9 = true;
/* 387 */           double agg_value11 = -1.0;
/* 388 */
/* 389 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 390 */           double agg_value13 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 391 */           boolean agg_isNull10 = agg_isNull11;
/* 392 */           double agg_value12 = agg_value13;
/* 393 */           if (agg_isNull10) {
/* 394 */             if (!agg_isNull6) {
/* 395 */               agg_isNull10 = false;
/* 396 */               agg_value12 = agg_value8;
/* 397 */             }
/* 398 */           }
/* 399 */
/* 400 */           boolean agg_isNull12 = smj_isNull6;
/* 401 */           double agg_value14 = -1.0;
/* 402 */           if (!smj_isNull6) {
/* 403 */             agg_value14 = smj_value10;
/* 404 */           }
/* 405 */           if (!agg_isNull12) {
/* 406 */             agg_isNull9 = false; // resultCode could change nullability.
/* 407 */             agg_value11 = agg_value12 + agg_value14;
/* 408 */
/* 409 */           }
/* 410 */           boolean agg_isNull8 = agg_isNull9;
/* 411 */           double agg_value10 = agg_value11;
/* 412 */           if (agg_isNull8) {
/* 413 */             boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 414 */             double agg_value16 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 415 */             if (!agg_isNull14) {
/* 416 */               agg_isNull8 = false;
/* 417 */               agg_value10 = agg_value16;
/* 418 */             }
/* 419 */           }
/* 420 */           boolean agg_isNull16 = true;
/* 421 */           double agg_value18 = -1.0;
/* 422 */
/* 423 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 424 */           double agg_value20 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 425 */           boolean agg_isNull17 = agg_isNull18;
/* 426 */           double agg_value19 = agg_value20;
/* 427 */           if (agg_isNull17) {
/* 428 */             if (!agg_isNull6) {
/* 429 */               agg_isNull17 = false;
/* 430 */               agg_value19 = agg_value8;
/* 431 */             }
/* 432 */           }
/* 433 */
/* 434 */           boolean agg_isNull20 = true;
/* 435 */           double agg_value22 = -1.0;
/* 436 */
/* 437 */           boolean agg_isNull21 = true;
/* 438 */           double agg_value23 = -1.0;
/* 439 */
/* 440 */           if (!smj_isNull9) {
/* 441 */             if (!smj_isNull10) {
/* 442 */               agg_isNull21 = false; // resultCode could change nullability.
/* 443 */               agg_value23 = smj_value13 + smj_value14;
/* 444 */
/* 445 */             }
/* 446 */
/* 447 */           }
/* 448 */           if (!agg_isNull21) {
/* 449 */             if (!smj_isNull11) {
/* 450 */               agg_isNull20 = false; // resultCode could change nullability.
/* 451 */               agg_value22 = agg_value23 + smj_value15;
/* 452 */
/* 453 */             }
/* 454 */
/* 455 */           }
/* 456 */           boolean agg_isNull19 = agg_isNull20;
/* 457 */           double agg_value21 = -1.0;
/* 458 */           if (!agg_isNull20) {
/* 459 */             agg_value21 = agg_value22;
/* 460 */           }
/* 461 */           if (!agg_isNull19) {
/* 462 */             agg_isNull16 = false; // resultCode could change nullability.
/* 463 */             agg_value18 = agg_value19 + agg_value21;
/* 464 */
/* 465 */           }
/* 466 */           boolean agg_isNull15 = agg_isNull16;
/* 467 */           double agg_value17 = agg_value18;
/* 468 */           if (agg_isNull15) {
/* 469 */             boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 470 */             double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 471 */             if (!agg_isNull25) {
/* 472 */               agg_isNull15 = false;
/* 473 */               agg_value17 = agg_value27;
/* 474 */             }
/* 475 */           }
/* 476 */           // update unsafe row buffer
/* 477 */           if (!agg_isNull8) {
/* 478 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value10);
/* 479 */           } else {
/* 480 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 481 */           }
/* 482 */
/* 483 */           if (!agg_isNull15) {
/* 484 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value17);
/* 485 */           } else {
/* 486 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 487 */           }
/* 488 */
/* 489 */         }
/* 490 */
/* 491 */       }
/* 492 */       if (shouldStop()) return;
/* 493 */     }
/* 494 */
/* 495 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 496 */
/* 497 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 498 */   }
/* 499 */
/* 500 */   private boolean findNextInnerJoinRows(
/* 501 */     scala.collection.Iterator leftIter,
/* 502 */     scala.collection.Iterator rightIter) {
/* 503 */     smj_leftRow = null;
/* 504 */     int comp = 0;
/* 505 */     while (smj_leftRow == null) {
/* 506 */       if (!leftIter.hasNext()) return false;
/* 507 */       smj_leftRow = (InternalRow) leftIter.next();
/* 508 */
/* 509 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 510 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 511 */
/* 512 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 513 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 514 */       if (smj_isNull || smj_isNull1) {
/* 515 */         smj_leftRow = null;
/* 516 */         continue;
/* 517 */       }
/* 518 */       if (!smj_matches.isEmpty()) {
/* 519 */         comp = 0;
/* 520 */         if (comp == 0) {
/* 521 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 522 */         }
/* 523 */         if (comp == 0) {
/* 524 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 525 */         }
/* 526 */
/* 527 */         if (comp == 0) {
/* 528 */           return true;
/* 529 */         }
/* 530 */         smj_matches.clear();
/* 531 */       }
/* 532 */
/* 533 */       do {
/* 534 */         if (smj_rightRow == null) {
/* 535 */           if (!rightIter.hasNext()) {
/* 536 */             smj_value6 = smj_value;
/* 537 */             smj_value7 = smj_value1;
/* 538 */             return !smj_matches.isEmpty();
/* 539 */           }
/* 540 */           smj_rightRow = (InternalRow) rightIter.next();
/* 541 */
/* 542 */           boolean smj_isNull2 = smj_rightRow.isNullAt(0);
/* 543 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(0));
/* 544 */
/* 545 */           boolean smj_isNull3 = smj_rightRow.isNullAt(1);
/* 546 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(1));
/* 547 */           if (smj_isNull2 || smj_isNull3) {
/* 548 */             smj_rightRow = null;
/* 549 */             continue;
/* 550 */           }
/* 551 */           smj_value4 = smj_value2;
/* 552 */           smj_value5 = smj_value3;
/* 553 */         }
/* 554 */
/* 555 */         comp = 0;
/* 556 */         if (comp == 0) {
/* 557 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 558 */         }
/* 559 */         if (comp == 0) {
/* 560 */           comp = (smj_value1 > smj_value5 ? 1 : smj_value1 < smj_value5 ? -1 : 0);
/* 561 */         }
/* 562 */
/* 563 */         if (comp > 0) {
/* 564 */           smj_rightRow = null;
/* 565 */         } else if (comp < 0) {
/* 566 */           if (!smj_matches.isEmpty()) {
/* 567 */             smj_value6 = smj_value;
/* 568 */             smj_value7 = smj_value1;
/* 569 */             return true;
/* 570 */           }
/* 571 */           smj_leftRow = null;
/* 572 */         } else {
/* 573 */           smj_matches.add(smj_rightRow.copy());
/* 574 */           smj_rightRow = null;;
/* 575 */         }
/* 576 */       } while (smj_leftRow != null);
/* 577 */     }
/* 578 */     return false; // unreachable
/* 579 */   }
/* 580 */
/* 581 */   private void wholestagecodegen_init_1() {
/* 582 */     agg_result1 = new UnsafeRow(1);
/* 583 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 584 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 585 */
/* 586 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 587 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 588 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 589 */
/* 590 */   }
/* 591 */
/* 592 */   protected void processNext() throws java.io.IOException {
/* 593 */     if (!agg_initAgg) {
/* 594 */       agg_initAgg = true;
/* 595 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 596 */       agg_doAggregateWithKeys();
/* 597 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 598 */     }
/* 599 */
/* 600 */     // output the result
/* 601 */
/* 602 */     while (agg_fastHashMapIter.next()) {
/* 603 */       wholestagecodegen_numOutputRows.add(1);
/* 604 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 605 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 606 */
/* 607 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 608 */
/* 609 */       append(agg_resultRow.copy());
/* 610 */
/* 611 */       if (shouldStop()) return;
/* 612 */     }
/* 613 */     agg_fastHashMap.close();
/* 614 */
/* 615 */     while (agg_mapIter.next()) {
/* 616 */       wholestagecodegen_numOutputRows.add(1);
/* 617 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 618 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 619 */
/* 620 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 621 */
/* 622 */       append(agg_resultRow.copy());
/* 623 */
/* 624 */       if (shouldStop()) return;
/* 625 */     }
/* 626 */
/* 627 */     agg_mapIter.close();
/* 628 */     if (agg_sorter == null) {
/* 629 */       agg_hashMap.free();
/* 630 */     }
/* 631 */   }
/* 632 */ }
