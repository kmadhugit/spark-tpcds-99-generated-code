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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private agg_FastHashMap agg_fastHashMap;
/* 019 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 020 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 021 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 025 */   private scala.collection.Iterator smj_leftInput;
/* 026 */   private scala.collection.Iterator smj_rightInput;
/* 027 */   private InternalRow smj_leftRow;
/* 028 */   private InternalRow smj_rightRow;
/* 029 */   private int smj_value4;
/* 030 */   private int smj_value5;
/* 031 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 032 */   private int smj_value6;
/* 033 */   private int smj_value7;
/* 034 */   private int smj_value8;
/* 035 */   private boolean smj_isNull4;
/* 036 */   private int smj_value9;
/* 037 */   private boolean smj_isNull5;
/* 038 */   private int smj_value10;
/* 039 */   private boolean smj_isNull6;
/* 040 */   private double smj_value11;
/* 041 */   private boolean smj_isNull7;
/* 042 */   private int smj_value12;
/* 043 */   private boolean smj_isNull8;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 045 */   private UnsafeRow smj_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 048 */   private UnsafeRow project_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 051 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 052 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 054 */   private UnsafeRow bhj_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 057 */   private UnsafeRow project_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 060 */   private UnsafeRow agg_result1;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 063 */   private int agg_value10;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 067 */
/* 068 */   public GeneratedIterator(Object[] references) {
/* 069 */     this.references = references;
/* 070 */   }
/* 071 */
/* 072 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 073 */     partitionIndex = index;
/* 074 */     this.inputs = inputs;
/* 075 */     wholestagecodegen_init_0();
/* 076 */     wholestagecodegen_init_1();
/* 077 */     wholestagecodegen_init_2();
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   private void wholestagecodegen_init_0() {
/* 082 */     agg_initAgg = false;
/* 083 */
/* 084 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 085 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 086 */
/* 087 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 088 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 089 */     smj_leftInput = inputs[0];
/* 090 */     smj_rightInput = inputs[1];
/* 091 */
/* 092 */     smj_rightRow = null;
/* 093 */
/* 094 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 095 */
/* 096 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 097 */     smj_result = new UnsafeRow(9);
/* 098 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 099 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 100 */     project_result = new UnsafeRow(6);
/* 101 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */   public class agg_FastHashMap {
/* 106 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 107 */     private int[] buckets;
/* 108 */     private int capacity = 1 << 16;
/* 109 */     private double loadFactor = 0.5;
/* 110 */     private int numBuckets = (int) (capacity / loadFactor);
/* 111 */     private int maxSteps = 2;
/* 112 */     private int numRows = 0;
/* 113 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 114 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.LongType)
/* 115 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType)
/* 116 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 117 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 118 */     private Object emptyVBase;
/* 119 */     private long emptyVOff;
/* 120 */     private int emptyVLen;
/* 121 */     private boolean isBatchFull = false;
/* 122 */
/* 123 */     public agg_FastHashMap(
/* 124 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 125 */       InternalRow emptyAggregationBuffer) {
/* 126 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 127 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 128 */
/* 129 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 130 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 131 */
/* 132 */       emptyVBase = emptyBuffer;
/* 133 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 134 */       emptyVLen = emptyBuffer.length;
/* 135 */
/* 136 */       buckets = new int[numBuckets];
/* 137 */       java.util.Arrays.fill(buckets, -1);
/* 138 */     }
/* 139 */
/* 140 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 141 */       long h = hash(agg_key);
/* 142 */       int step = 0;
/* 143 */       int idx = (int) h & (numBuckets - 1);
/* 144 */       while (step < maxSteps) {
/* 145 */         // Return bucket index if it's either an empty slot or already contains the key
/* 146 */         if (buckets[idx] == -1) {
/* 147 */           if (numRows < capacity && !isBatchFull) {
/* 148 */             // creating the unsafe for new entry
/* 149 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 150 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 151 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 152 */               0);
/* 153 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 154 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 155 */               agg_holder,
/* 156 */               1);
/* 157 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 158 */             agg_rowWriter.zeroOutNullBytes();
/* 159 */             agg_rowWriter.write(0, agg_key);
/* 160 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 161 */             Object kbase = agg_result.getBaseObject();
/* 162 */             long koff = agg_result.getBaseOffset();
/* 163 */             int klen = agg_result.getSizeInBytes();
/* 164 */
/* 165 */             UnsafeRow vRow
/* 166 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 167 */             if (vRow == null) {
/* 168 */               isBatchFull = true;
/* 169 */             } else {
/* 170 */               buckets[idx] = numRows++;
/* 171 */             }
/* 172 */             return vRow;
/* 173 */           } else {
/* 174 */             // No more space
/* 175 */             return null;
/* 176 */           }
/* 177 */         } else if (equals(idx, agg_key)) {
/* 178 */           return batch.getValueRow(buckets[idx]);
/* 179 */         }
/* 180 */         idx = (idx + 1) & (numBuckets - 1);
/* 181 */         step++;
/* 182 */       }
/* 183 */       // Didn't find it
/* 184 */       return null;
/* 185 */     }
/* 186 */
/* 187 */     private boolean equals(int idx, int agg_key) {
/* 188 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 189 */       return (row.getInt(0) == agg_key);
/* 190 */     }
/* 191 */
/* 192 */     private long hash(int agg_key) {
/* 193 */       long agg_hash = 0;
/* 194 */
/* 195 */       int agg_result = agg_key;
/* 196 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 197 */
/* 198 */       return agg_hash;
/* 199 */     }
/* 200 */
/* 201 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 202 */       return batch.rowIterator();
/* 203 */     }
/* 204 */
/* 205 */     public void close() {
/* 206 */       batch.close();
/* 207 */     }
/* 208 */
/* 209 */   }
/* 210 */
/* 211 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 212 */     agg_hashMap = agg_plan.createHashMap();
/* 213 */
/* 214 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 215 */       smj_isNull4 = smj_leftRow.isNullAt(0);
/* 216 */       smj_value8 = smj_isNull4 ? -1 : (smj_leftRow.getInt(0));
/* 217 */       smj_isNull5 = smj_leftRow.isNullAt(1);
/* 218 */       smj_value9 = smj_isNull5 ? -1 : (smj_leftRow.getInt(1));
/* 219 */       smj_isNull6 = smj_leftRow.isNullAt(2);
/* 220 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(2));
/* 221 */       smj_isNull7 = smj_leftRow.isNullAt(3);
/* 222 */       smj_value11 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(3));
/* 223 */       smj_isNull8 = smj_leftRow.isNullAt(4);
/* 224 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(4));
/* 225 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 226 */       while (smj_iterator.hasNext()) {
/* 227 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 228 */
/* 229 */         smj_numOutputRows.add(1);
/* 230 */
/* 231 */         // generate join key for stream side
/* 232 */
/* 233 */         boolean bhj_isNull = smj_isNull8;
/* 234 */         long bhj_value = -1L;
/* 235 */         if (!smj_isNull8) {
/* 236 */           bhj_value = (long) smj_value12;
/* 237 */         }
/* 238 */         // find matches from HashedRelation
/* 239 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 240 */         if (bhj_matched == null) continue;
/* 241 */
/* 242 */         bhj_numOutputRows.add(1);
/* 243 */
/* 244 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(2);
/* 245 */         int smj_value15 = smj_isNull11 ? -1 : (smj_rightRow1.getInt(2));
/* 246 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(3);
/* 247 */         double smj_value16 = smj_isNull12 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 248 */
/* 249 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 250 */
/* 251 */         UnsafeRow agg_fastAggBuffer = null;
/* 252 */
/* 253 */         if (true) {
/* 254 */           if (!smj_isNull4) {
/* 255 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 256 */               smj_value8);
/* 257 */           }
/* 258 */         }
/* 259 */
/* 260 */         if (agg_fastAggBuffer == null) {
/* 261 */           // generate grouping key
/* 262 */           agg_rowWriter.zeroOutNullBytes();
/* 263 */
/* 264 */           if (smj_isNull4) {
/* 265 */             agg_rowWriter.setNullAt(0);
/* 266 */           } else {
/* 267 */             agg_rowWriter.write(0, smj_value8);
/* 268 */           }
/* 269 */           agg_value10 = 42;
/* 270 */
/* 271 */           if (!smj_isNull4) {
/* 272 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value8, agg_value10);
/* 273 */           }
/* 274 */           if (true) {
/* 275 */             // try to get the buffer from hash map
/* 276 */             agg_unsafeRowAggBuffer =
/* 277 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value10);
/* 278 */           }
/* 279 */           if (agg_unsafeRowAggBuffer == null) {
/* 280 */             if (agg_sorter == null) {
/* 281 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 282 */             } else {
/* 283 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 284 */             }
/* 285 */
/* 286 */             // the hash map had be spilled, it should have enough memory now,
/* 287 */             // try  to allocate buffer again.
/* 288 */             agg_unsafeRowAggBuffer =
/* 289 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value10);
/* 290 */             if (agg_unsafeRowAggBuffer == null) {
/* 291 */               // failed to allocate the first page
/* 292 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 293 */             }
/* 294 */           }
/* 295 */         }
/* 296 */
/* 297 */         if (agg_fastAggBuffer != null) {
/* 298 */           // update fast row
/* 299 */
/* 300 */           // common sub-expressions
/* 301 */
/* 302 */           // evaluate aggregate function
/* 303 */           boolean agg_isNull42 = false;
/* 304 */
/* 305 */           boolean agg_isNull44 = agg_fastAggBuffer.isNullAt(0);
/* 306 */           long agg_value48 = agg_isNull44 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 307 */           boolean agg_isNull43 = agg_isNull44;
/* 308 */           long agg_value47 = agg_value48;
/* 309 */           if (agg_isNull43) {
/* 310 */             boolean agg_isNull45 = false;
/* 311 */             long agg_value49 = -1L;
/* 312 */             if (!false) {
/* 313 */               agg_value49 = (long) 0;
/* 314 */             }
/* 315 */             if (!agg_isNull45) {
/* 316 */               agg_isNull43 = false;
/* 317 */               agg_value47 = agg_value49;
/* 318 */             }
/* 319 */           }
/* 320 */
/* 321 */           boolean agg_isNull48 = smj_isNull11;
/* 322 */           int agg_value52 = smj_value15;
/* 323 */           if (agg_isNull48) {
/* 324 */             if (!false) {
/* 325 */               agg_isNull48 = false;
/* 326 */               agg_value52 = 0;
/* 327 */             }
/* 328 */           }
/* 329 */           boolean agg_isNull47 = agg_isNull48;
/* 330 */           long agg_value51 = -1L;
/* 331 */           if (!agg_isNull48) {
/* 332 */             agg_value51 = (long) agg_value52;
/* 333 */           }
/* 334 */           long agg_value46 = -1L;
/* 335 */           agg_value46 = agg_value47 + agg_value51;
/* 336 */           boolean agg_isNull51 = false;
/* 337 */
/* 338 */           boolean agg_isNull53 = agg_fastAggBuffer.isNullAt(1);
/* 339 */           long agg_value57 = agg_isNull53 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 340 */           boolean agg_isNull52 = agg_isNull53;
/* 341 */           long agg_value56 = agg_value57;
/* 342 */           if (agg_isNull52) {
/* 343 */             boolean agg_isNull54 = false;
/* 344 */             long agg_value58 = -1L;
/* 345 */             if (!false) {
/* 346 */               agg_value58 = (long) 0;
/* 347 */             }
/* 348 */             if (!agg_isNull54) {
/* 349 */               agg_isNull52 = false;
/* 350 */               agg_value56 = agg_value58;
/* 351 */             }
/* 352 */           }
/* 353 */
/* 354 */           boolean agg_isNull57 = smj_isNull6;
/* 355 */           int agg_value61 = smj_value10;
/* 356 */           if (agg_isNull57) {
/* 357 */             if (!false) {
/* 358 */               agg_isNull57 = false;
/* 359 */               agg_value61 = 0;
/* 360 */             }
/* 361 */           }
/* 362 */           boolean agg_isNull56 = agg_isNull57;
/* 363 */           long agg_value60 = -1L;
/* 364 */           if (!agg_isNull57) {
/* 365 */             agg_value60 = (long) agg_value61;
/* 366 */           }
/* 367 */           long agg_value55 = -1L;
/* 368 */           agg_value55 = agg_value56 + agg_value60;
/* 369 */           boolean agg_isNull60 = false;
/* 370 */
/* 371 */           boolean agg_isNull62 = agg_fastAggBuffer.isNullAt(2);
/* 372 */           double agg_value66 = agg_isNull62 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 373 */           boolean agg_isNull61 = agg_isNull62;
/* 374 */           double agg_value65 = agg_value66;
/* 375 */           if (agg_isNull61) {
/* 376 */             boolean agg_isNull63 = false;
/* 377 */             double agg_value67 = -1.0;
/* 378 */             if (!false) {
/* 379 */               agg_value67 = (double) 0;
/* 380 */             }
/* 381 */             if (!agg_isNull63) {
/* 382 */               agg_isNull61 = false;
/* 383 */               agg_value65 = agg_value67;
/* 384 */             }
/* 385 */           }
/* 386 */
/* 387 */           boolean agg_isNull65 = smj_isNull12;
/* 388 */           double agg_value69 = smj_value16;
/* 389 */           if (agg_isNull65) {
/* 390 */             if (!false) {
/* 391 */               agg_isNull65 = false;
/* 392 */               agg_value69 = 0.0D;
/* 393 */             }
/* 394 */           }
/* 395 */           double agg_value64 = -1.0;
/* 396 */           agg_value64 = agg_value65 + agg_value69;
/* 397 */           boolean agg_isNull68 = false;
/* 398 */
/* 399 */           boolean agg_isNull70 = agg_fastAggBuffer.isNullAt(3);
/* 400 */           double agg_value74 = agg_isNull70 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 401 */           boolean agg_isNull69 = agg_isNull70;
/* 402 */           double agg_value73 = agg_value74;
/* 403 */           if (agg_isNull69) {
/* 404 */             boolean agg_isNull71 = false;
/* 405 */             double agg_value75 = -1.0;
/* 406 */             if (!false) {
/* 407 */               agg_value75 = (double) 0;
/* 408 */             }
/* 409 */             if (!agg_isNull71) {
/* 410 */               agg_isNull69 = false;
/* 411 */               agg_value73 = agg_value75;
/* 412 */             }
/* 413 */           }
/* 414 */
/* 415 */           boolean agg_isNull73 = smj_isNull7;
/* 416 */           double agg_value77 = smj_value11;
/* 417 */           if (agg_isNull73) {
/* 418 */             if (!false) {
/* 419 */               agg_isNull73 = false;
/* 420 */               agg_value77 = 0.0D;
/* 421 */             }
/* 422 */           }
/* 423 */           double agg_value72 = -1.0;
/* 424 */           agg_value72 = agg_value73 + agg_value77;
/* 425 */           // update fast row
/* 426 */           agg_fastAggBuffer.setLong(0, agg_value46);
/* 427 */           agg_fastAggBuffer.setLong(1, agg_value55);
/* 428 */           agg_fastAggBuffer.setDouble(2, agg_value64);
/* 429 */           agg_fastAggBuffer.setDouble(3, agg_value72);
/* 430 */
/* 431 */         } else {
/* 432 */           // update unsafe row
/* 433 */
/* 434 */           // common sub-expressions
/* 435 */
/* 436 */           // evaluate aggregate function
/* 437 */           boolean agg_isNull8 = false;
/* 438 */
/* 439 */           boolean agg_isNull10 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 440 */           long agg_value14 = agg_isNull10 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 441 */           boolean agg_isNull9 = agg_isNull10;
/* 442 */           long agg_value13 = agg_value14;
/* 443 */           if (agg_isNull9) {
/* 444 */             boolean agg_isNull11 = false;
/* 445 */             long agg_value15 = -1L;
/* 446 */             if (!false) {
/* 447 */               agg_value15 = (long) 0;
/* 448 */             }
/* 449 */             if (!agg_isNull11) {
/* 450 */               agg_isNull9 = false;
/* 451 */               agg_value13 = agg_value15;
/* 452 */             }
/* 453 */           }
/* 454 */
/* 455 */           boolean agg_isNull14 = smj_isNull11;
/* 456 */           int agg_value18 = smj_value15;
/* 457 */           if (agg_isNull14) {
/* 458 */             if (!false) {
/* 459 */               agg_isNull14 = false;
/* 460 */               agg_value18 = 0;
/* 461 */             }
/* 462 */           }
/* 463 */           boolean agg_isNull13 = agg_isNull14;
/* 464 */           long agg_value17 = -1L;
/* 465 */           if (!agg_isNull14) {
/* 466 */             agg_value17 = (long) agg_value18;
/* 467 */           }
/* 468 */           long agg_value12 = -1L;
/* 469 */           agg_value12 = agg_value13 + agg_value17;
/* 470 */           boolean agg_isNull17 = false;
/* 471 */
/* 472 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 473 */           long agg_value23 = agg_isNull19 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 474 */           boolean agg_isNull18 = agg_isNull19;
/* 475 */           long agg_value22 = agg_value23;
/* 476 */           if (agg_isNull18) {
/* 477 */             boolean agg_isNull20 = false;
/* 478 */             long agg_value24 = -1L;
/* 479 */             if (!false) {
/* 480 */               agg_value24 = (long) 0;
/* 481 */             }
/* 482 */             if (!agg_isNull20) {
/* 483 */               agg_isNull18 = false;
/* 484 */               agg_value22 = agg_value24;
/* 485 */             }
/* 486 */           }
/* 487 */
/* 488 */           boolean agg_isNull23 = smj_isNull6;
/* 489 */           int agg_value27 = smj_value10;
/* 490 */           if (agg_isNull23) {
/* 491 */             if (!false) {
/* 492 */               agg_isNull23 = false;
/* 493 */               agg_value27 = 0;
/* 494 */             }
/* 495 */           }
/* 496 */           boolean agg_isNull22 = agg_isNull23;
/* 497 */           long agg_value26 = -1L;
/* 498 */           if (!agg_isNull23) {
/* 499 */             agg_value26 = (long) agg_value27;
/* 500 */           }
/* 501 */           long agg_value21 = -1L;
/* 502 */           agg_value21 = agg_value22 + agg_value26;
/* 503 */           boolean agg_isNull26 = false;
/* 504 */
/* 505 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 506 */           double agg_value32 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 507 */           boolean agg_isNull27 = agg_isNull28;
/* 508 */           double agg_value31 = agg_value32;
/* 509 */           if (agg_isNull27) {
/* 510 */             boolean agg_isNull29 = false;
/* 511 */             double agg_value33 = -1.0;
/* 512 */             if (!false) {
/* 513 */               agg_value33 = (double) 0;
/* 514 */             }
/* 515 */             if (!agg_isNull29) {
/* 516 */               agg_isNull27 = false;
/* 517 */               agg_value31 = agg_value33;
/* 518 */             }
/* 519 */           }
/* 520 */
/* 521 */           boolean agg_isNull31 = smj_isNull12;
/* 522 */           double agg_value35 = smj_value16;
/* 523 */           if (agg_isNull31) {
/* 524 */             if (!false) {
/* 525 */               agg_isNull31 = false;
/* 526 */               agg_value35 = 0.0D;
/* 527 */             }
/* 528 */           }
/* 529 */           double agg_value30 = -1.0;
/* 530 */           agg_value30 = agg_value31 + agg_value35;
/* 531 */           boolean agg_isNull34 = false;
/* 532 */
/* 533 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 534 */           double agg_value40 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 535 */           boolean agg_isNull35 = agg_isNull36;
/* 536 */           double agg_value39 = agg_value40;
/* 537 */           if (agg_isNull35) {
/* 538 */             boolean agg_isNull37 = false;
/* 539 */             double agg_value41 = -1.0;
/* 540 */             if (!false) {
/* 541 */               agg_value41 = (double) 0;
/* 542 */             }
/* 543 */             if (!agg_isNull37) {
/* 544 */               agg_isNull35 = false;
/* 545 */               agg_value39 = agg_value41;
/* 546 */             }
/* 547 */           }
/* 548 */
/* 549 */           boolean agg_isNull39 = smj_isNull7;
/* 550 */           double agg_value43 = smj_value11;
/* 551 */           if (agg_isNull39) {
/* 552 */             if (!false) {
/* 553 */               agg_isNull39 = false;
/* 554 */               agg_value43 = 0.0D;
/* 555 */             }
/* 556 */           }
/* 557 */           double agg_value38 = -1.0;
/* 558 */           agg_value38 = agg_value39 + agg_value43;
/* 559 */           // update unsafe row buffer
/* 560 */           agg_unsafeRowAggBuffer.setLong(0, agg_value12);
/* 561 */           agg_unsafeRowAggBuffer.setLong(1, agg_value21);
/* 562 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value30);
/* 563 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value38);
/* 564 */
/* 565 */         }
/* 566 */
/* 567 */       }
/* 568 */       if (shouldStop()) return;
/* 569 */     }
/* 570 */
/* 571 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 572 */
/* 573 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 574 */   }
/* 575 */
/* 576 */   private boolean findNextInnerJoinRows(
/* 577 */     scala.collection.Iterator leftIter,
/* 578 */     scala.collection.Iterator rightIter) {
/* 579 */     smj_leftRow = null;
/* 580 */     int comp = 0;
/* 581 */     while (smj_leftRow == null) {
/* 582 */       if (!leftIter.hasNext()) return false;
/* 583 */       smj_leftRow = (InternalRow) leftIter.next();
/* 584 */
/* 585 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 586 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 587 */
/* 588 */       boolean smj_isNull1 = smj_leftRow.isNullAt(0);
/* 589 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(0));
/* 590 */       if (smj_isNull || smj_isNull1) {
/* 591 */         smj_leftRow = null;
/* 592 */         continue;
/* 593 */       }
/* 594 */       if (!smj_matches.isEmpty()) {
/* 595 */         comp = 0;
/* 596 */         if (comp == 0) {
/* 597 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 598 */         }
/* 599 */         if (comp == 0) {
/* 600 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 601 */         }
/* 602 */
/* 603 */         if (comp == 0) {
/* 604 */           return true;
/* 605 */         }
/* 606 */         smj_matches.clear();
/* 607 */       }
/* 608 */
/* 609 */       do {
/* 610 */         if (smj_rightRow == null) {
/* 611 */           if (!rightIter.hasNext()) {
/* 612 */             smj_value6 = smj_value;
/* 613 */             smj_value7 = smj_value1;
/* 614 */             return !smj_matches.isEmpty();
/* 615 */           }
/* 616 */           smj_rightRow = (InternalRow) rightIter.next();
/* 617 */
/* 618 */           boolean smj_isNull2 = smj_rightRow.isNullAt(1);
/* 619 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(1));
/* 620 */
/* 621 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 622 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 623 */           if (smj_isNull2 || smj_isNull3) {
/* 624 */             smj_rightRow = null;
/* 625 */             continue;
/* 626 */           }
/* 627 */           smj_value4 = smj_value2;
/* 628 */           smj_value5 = smj_value3;
/* 629 */         }
/* 630 */
/* 631 */         comp = 0;
/* 632 */         if (comp == 0) {
/* 633 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 634 */         }
/* 635 */         if (comp == 0) {
/* 636 */           comp = (smj_value1 > smj_value5 ? 1 : smj_value1 < smj_value5 ? -1 : 0);
/* 637 */         }
/* 638 */
/* 639 */         if (comp > 0) {
/* 640 */           smj_rightRow = null;
/* 641 */         } else if (comp < 0) {
/* 642 */           if (!smj_matches.isEmpty()) {
/* 643 */             smj_value6 = smj_value;
/* 644 */             smj_value7 = smj_value1;
/* 645 */             return true;
/* 646 */           }
/* 647 */           smj_leftRow = null;
/* 648 */         } else {
/* 649 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 650 */           smj_rightRow = null;;
/* 651 */         }
/* 652 */       } while (smj_leftRow != null);
/* 653 */     }
/* 654 */     return false; // unreachable
/* 655 */   }
/* 656 */
/* 657 */   private void wholestagecodegen_init_2() {
/* 658 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 659 */
/* 660 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 661 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 662 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 663 */
/* 664 */   }
/* 665 */
/* 666 */   private void wholestagecodegen_init_1() {
/* 667 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 668 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 669 */
/* 670 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 671 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 672 */
/* 673 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 674 */     bhj_result = new UnsafeRow(7);
/* 675 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 676 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 677 */     project_result1 = new UnsafeRow(5);
/* 678 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 679 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 680 */     agg_result1 = new UnsafeRow(1);
/* 681 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 682 */
/* 683 */   }
/* 684 */
/* 685 */   protected void processNext() throws java.io.IOException {
/* 686 */     if (!agg_initAgg) {
/* 687 */       agg_initAgg = true;
/* 688 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 689 */       agg_doAggregateWithKeys();
/* 690 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 691 */     }
/* 692 */
/* 693 */     // output the result
/* 694 */
/* 695 */     while (agg_fastHashMapIter.next()) {
/* 696 */       wholestagecodegen_numOutputRows.add(1);
/* 697 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 698 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 699 */
/* 700 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 701 */
/* 702 */       append(agg_resultRow.copy());
/* 703 */
/* 704 */       if (shouldStop()) return;
/* 705 */     }
/* 706 */     agg_fastHashMap.close();
/* 707 */
/* 708 */     while (agg_mapIter.next()) {
/* 709 */       wholestagecodegen_numOutputRows.add(1);
/* 710 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 711 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 712 */
/* 713 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 714 */
/* 715 */       append(agg_resultRow.copy());
/* 716 */
/* 717 */       if (shouldStop()) return;
/* 718 */     }
/* 719 */
/* 720 */     agg_mapIter.close();
/* 721 */     if (agg_sorter == null) {
/* 722 */       agg_hashMap.free();
/* 723 */     }
/* 724 */   }
/* 725 */ }
