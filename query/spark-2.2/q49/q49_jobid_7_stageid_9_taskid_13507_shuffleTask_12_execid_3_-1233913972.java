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
/* 029 */   private long smj_value6;
/* 030 */   private long smj_value7;
/* 031 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 032 */   private long smj_value8;
/* 033 */   private long smj_value9;
/* 034 */   private int smj_value10;
/* 035 */   private boolean smj_isNull6;
/* 036 */   private int smj_value11;
/* 037 */   private boolean smj_isNull7;
/* 038 */   private int smj_value12;
/* 039 */   private boolean smj_isNull8;
/* 040 */   private double smj_value13;
/* 041 */   private boolean smj_isNull9;
/* 042 */   private int smj_value14;
/* 043 */   private boolean smj_isNull10;
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
/* 215 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 216 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 217 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 218 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 219 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 220 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 221 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 222 */       smj_value13 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(3));
/* 223 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 224 */       smj_value14 = smj_isNull10 ? -1 : (smj_leftRow.getInt(4));
/* 225 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 226 */       while (smj_iterator.hasNext()) {
/* 227 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 228 */
/* 229 */         smj_numOutputRows.add(1);
/* 230 */
/* 231 */         // generate join key for stream side
/* 232 */
/* 233 */         boolean bhj_isNull = smj_isNull10;
/* 234 */         long bhj_value = -1L;
/* 235 */         if (!smj_isNull10) {
/* 236 */           bhj_value = (long) smj_value14;
/* 237 */         }
/* 238 */         // find matches from HashedRelation
/* 239 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 240 */         if (bhj_matched == null) continue;
/* 241 */
/* 242 */         bhj_numOutputRows.add(1);
/* 243 */
/* 244 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(2);
/* 245 */         long smj_value17 = smj_isNull13 ? -1L : (smj_rightRow1.getLong(2));
/* 246 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(3);
/* 247 */         double smj_value18 = smj_isNull14 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 248 */
/* 249 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 250 */
/* 251 */         UnsafeRow agg_fastAggBuffer = null;
/* 252 */
/* 253 */         if (true) {
/* 254 */           if (!smj_isNull6) {
/* 255 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 256 */               smj_value10);
/* 257 */           }
/* 258 */         }
/* 259 */
/* 260 */         if (agg_fastAggBuffer == null) {
/* 261 */           // generate grouping key
/* 262 */           agg_rowWriter.zeroOutNullBytes();
/* 263 */
/* 264 */           if (smj_isNull6) {
/* 265 */             agg_rowWriter.setNullAt(0);
/* 266 */           } else {
/* 267 */             agg_rowWriter.write(0, smj_value10);
/* 268 */           }
/* 269 */           agg_value10 = 42;
/* 270 */
/* 271 */           if (!smj_isNull6) {
/* 272 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(smj_value10, agg_value10);
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
/* 303 */           boolean agg_isNull41 = false;
/* 304 */
/* 305 */           boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 306 */           long agg_value47 = agg_isNull43 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 307 */           boolean agg_isNull42 = agg_isNull43;
/* 308 */           long agg_value46 = agg_value47;
/* 309 */           if (agg_isNull42) {
/* 310 */             boolean agg_isNull44 = false;
/* 311 */             long agg_value48 = -1L;
/* 312 */             if (!false) {
/* 313 */               agg_value48 = (long) 0;
/* 314 */             }
/* 315 */             if (!agg_isNull44) {
/* 316 */               agg_isNull42 = false;
/* 317 */               agg_value46 = agg_value48;
/* 318 */             }
/* 319 */           }
/* 320 */
/* 321 */           boolean agg_isNull46 = smj_isNull13;
/* 322 */           long agg_value50 = smj_value17;
/* 323 */           if (agg_isNull46) {
/* 324 */             if (!false) {
/* 325 */               agg_isNull46 = false;
/* 326 */               agg_value50 = 0L;
/* 327 */             }
/* 328 */           }
/* 329 */           long agg_value45 = -1L;
/* 330 */           agg_value45 = agg_value46 + agg_value50;
/* 331 */           boolean agg_isNull49 = false;
/* 332 */
/* 333 */           boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(1);
/* 334 */           long agg_value55 = agg_isNull51 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 335 */           boolean agg_isNull50 = agg_isNull51;
/* 336 */           long agg_value54 = agg_value55;
/* 337 */           if (agg_isNull50) {
/* 338 */             boolean agg_isNull52 = false;
/* 339 */             long agg_value56 = -1L;
/* 340 */             if (!false) {
/* 341 */               agg_value56 = (long) 0;
/* 342 */             }
/* 343 */             if (!agg_isNull52) {
/* 344 */               agg_isNull50 = false;
/* 345 */               agg_value54 = agg_value56;
/* 346 */             }
/* 347 */           }
/* 348 */
/* 349 */           boolean agg_isNull55 = smj_isNull8;
/* 350 */           int agg_value59 = smj_value12;
/* 351 */           if (agg_isNull55) {
/* 352 */             if (!false) {
/* 353 */               agg_isNull55 = false;
/* 354 */               agg_value59 = 0;
/* 355 */             }
/* 356 */           }
/* 357 */           boolean agg_isNull54 = agg_isNull55;
/* 358 */           long agg_value58 = -1L;
/* 359 */           if (!agg_isNull55) {
/* 360 */             agg_value58 = (long) agg_value59;
/* 361 */           }
/* 362 */           long agg_value53 = -1L;
/* 363 */           agg_value53 = agg_value54 + agg_value58;
/* 364 */           boolean agg_isNull58 = false;
/* 365 */
/* 366 */           boolean agg_isNull60 = agg_fastAggBuffer.isNullAt(2);
/* 367 */           double agg_value64 = agg_isNull60 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 368 */           boolean agg_isNull59 = agg_isNull60;
/* 369 */           double agg_value63 = agg_value64;
/* 370 */           if (agg_isNull59) {
/* 371 */             boolean agg_isNull61 = false;
/* 372 */             double agg_value65 = -1.0;
/* 373 */             if (!false) {
/* 374 */               agg_value65 = (double) 0;
/* 375 */             }
/* 376 */             if (!agg_isNull61) {
/* 377 */               agg_isNull59 = false;
/* 378 */               agg_value63 = agg_value65;
/* 379 */             }
/* 380 */           }
/* 381 */
/* 382 */           boolean agg_isNull63 = smj_isNull14;
/* 383 */           double agg_value67 = smj_value18;
/* 384 */           if (agg_isNull63) {
/* 385 */             if (!false) {
/* 386 */               agg_isNull63 = false;
/* 387 */               agg_value67 = 0.0D;
/* 388 */             }
/* 389 */           }
/* 390 */           double agg_value62 = -1.0;
/* 391 */           agg_value62 = agg_value63 + agg_value67;
/* 392 */           boolean agg_isNull66 = false;
/* 393 */
/* 394 */           boolean agg_isNull68 = agg_fastAggBuffer.isNullAt(3);
/* 395 */           double agg_value72 = agg_isNull68 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 396 */           boolean agg_isNull67 = agg_isNull68;
/* 397 */           double agg_value71 = agg_value72;
/* 398 */           if (agg_isNull67) {
/* 399 */             boolean agg_isNull69 = false;
/* 400 */             double agg_value73 = -1.0;
/* 401 */             if (!false) {
/* 402 */               agg_value73 = (double) 0;
/* 403 */             }
/* 404 */             if (!agg_isNull69) {
/* 405 */               agg_isNull67 = false;
/* 406 */               agg_value71 = agg_value73;
/* 407 */             }
/* 408 */           }
/* 409 */
/* 410 */           boolean agg_isNull71 = smj_isNull9;
/* 411 */           double agg_value75 = smj_value13;
/* 412 */           if (agg_isNull71) {
/* 413 */             if (!false) {
/* 414 */               agg_isNull71 = false;
/* 415 */               agg_value75 = 0.0D;
/* 416 */             }
/* 417 */           }
/* 418 */           double agg_value70 = -1.0;
/* 419 */           agg_value70 = agg_value71 + agg_value75;
/* 420 */           // update fast row
/* 421 */           agg_fastAggBuffer.setLong(0, agg_value45);
/* 422 */           agg_fastAggBuffer.setLong(1, agg_value53);
/* 423 */           agg_fastAggBuffer.setDouble(2, agg_value62);
/* 424 */           agg_fastAggBuffer.setDouble(3, agg_value70);
/* 425 */
/* 426 */         } else {
/* 427 */           // update unsafe row
/* 428 */
/* 429 */           // common sub-expressions
/* 430 */
/* 431 */           // evaluate aggregate function
/* 432 */           boolean agg_isNull8 = false;
/* 433 */
/* 434 */           boolean agg_isNull10 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 435 */           long agg_value14 = agg_isNull10 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 436 */           boolean agg_isNull9 = agg_isNull10;
/* 437 */           long agg_value13 = agg_value14;
/* 438 */           if (agg_isNull9) {
/* 439 */             boolean agg_isNull11 = false;
/* 440 */             long agg_value15 = -1L;
/* 441 */             if (!false) {
/* 442 */               agg_value15 = (long) 0;
/* 443 */             }
/* 444 */             if (!agg_isNull11) {
/* 445 */               agg_isNull9 = false;
/* 446 */               agg_value13 = agg_value15;
/* 447 */             }
/* 448 */           }
/* 449 */
/* 450 */           boolean agg_isNull13 = smj_isNull13;
/* 451 */           long agg_value17 = smj_value17;
/* 452 */           if (agg_isNull13) {
/* 453 */             if (!false) {
/* 454 */               agg_isNull13 = false;
/* 455 */               agg_value17 = 0L;
/* 456 */             }
/* 457 */           }
/* 458 */           long agg_value12 = -1L;
/* 459 */           agg_value12 = agg_value13 + agg_value17;
/* 460 */           boolean agg_isNull16 = false;
/* 461 */
/* 462 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 463 */           long agg_value22 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 464 */           boolean agg_isNull17 = agg_isNull18;
/* 465 */           long agg_value21 = agg_value22;
/* 466 */           if (agg_isNull17) {
/* 467 */             boolean agg_isNull19 = false;
/* 468 */             long agg_value23 = -1L;
/* 469 */             if (!false) {
/* 470 */               agg_value23 = (long) 0;
/* 471 */             }
/* 472 */             if (!agg_isNull19) {
/* 473 */               agg_isNull17 = false;
/* 474 */               agg_value21 = agg_value23;
/* 475 */             }
/* 476 */           }
/* 477 */
/* 478 */           boolean agg_isNull22 = smj_isNull8;
/* 479 */           int agg_value26 = smj_value12;
/* 480 */           if (agg_isNull22) {
/* 481 */             if (!false) {
/* 482 */               agg_isNull22 = false;
/* 483 */               agg_value26 = 0;
/* 484 */             }
/* 485 */           }
/* 486 */           boolean agg_isNull21 = agg_isNull22;
/* 487 */           long agg_value25 = -1L;
/* 488 */           if (!agg_isNull22) {
/* 489 */             agg_value25 = (long) agg_value26;
/* 490 */           }
/* 491 */           long agg_value20 = -1L;
/* 492 */           agg_value20 = agg_value21 + agg_value25;
/* 493 */           boolean agg_isNull25 = false;
/* 494 */
/* 495 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 496 */           double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 497 */           boolean agg_isNull26 = agg_isNull27;
/* 498 */           double agg_value30 = agg_value31;
/* 499 */           if (agg_isNull26) {
/* 500 */             boolean agg_isNull28 = false;
/* 501 */             double agg_value32 = -1.0;
/* 502 */             if (!false) {
/* 503 */               agg_value32 = (double) 0;
/* 504 */             }
/* 505 */             if (!agg_isNull28) {
/* 506 */               agg_isNull26 = false;
/* 507 */               agg_value30 = agg_value32;
/* 508 */             }
/* 509 */           }
/* 510 */
/* 511 */           boolean agg_isNull30 = smj_isNull14;
/* 512 */           double agg_value34 = smj_value18;
/* 513 */           if (agg_isNull30) {
/* 514 */             if (!false) {
/* 515 */               agg_isNull30 = false;
/* 516 */               agg_value34 = 0.0D;
/* 517 */             }
/* 518 */           }
/* 519 */           double agg_value29 = -1.0;
/* 520 */           agg_value29 = agg_value30 + agg_value34;
/* 521 */           boolean agg_isNull33 = false;
/* 522 */
/* 523 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 524 */           double agg_value39 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 525 */           boolean agg_isNull34 = agg_isNull35;
/* 526 */           double agg_value38 = agg_value39;
/* 527 */           if (agg_isNull34) {
/* 528 */             boolean agg_isNull36 = false;
/* 529 */             double agg_value40 = -1.0;
/* 530 */             if (!false) {
/* 531 */               agg_value40 = (double) 0;
/* 532 */             }
/* 533 */             if (!agg_isNull36) {
/* 534 */               agg_isNull34 = false;
/* 535 */               agg_value38 = agg_value40;
/* 536 */             }
/* 537 */           }
/* 538 */
/* 539 */           boolean agg_isNull38 = smj_isNull9;
/* 540 */           double agg_value42 = smj_value13;
/* 541 */           if (agg_isNull38) {
/* 542 */             if (!false) {
/* 543 */               agg_isNull38 = false;
/* 544 */               agg_value42 = 0.0D;
/* 545 */             }
/* 546 */           }
/* 547 */           double agg_value37 = -1.0;
/* 548 */           agg_value37 = agg_value38 + agg_value42;
/* 549 */           // update unsafe row buffer
/* 550 */           agg_unsafeRowAggBuffer.setLong(0, agg_value12);
/* 551 */           agg_unsafeRowAggBuffer.setLong(1, agg_value20);
/* 552 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value29);
/* 553 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value37);
/* 554 */
/* 555 */         }
/* 556 */
/* 557 */       }
/* 558 */       if (shouldStop()) return;
/* 559 */     }
/* 560 */
/* 561 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 562 */
/* 563 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 564 */   }
/* 565 */
/* 566 */   private boolean findNextInnerJoinRows(
/* 567 */     scala.collection.Iterator leftIter,
/* 568 */     scala.collection.Iterator rightIter) {
/* 569 */     smj_leftRow = null;
/* 570 */     int comp = 0;
/* 571 */     while (smj_leftRow == null) {
/* 572 */       if (!leftIter.hasNext()) return false;
/* 573 */       smj_leftRow = (InternalRow) leftIter.next();
/* 574 */
/* 575 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 576 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 577 */       boolean smj_isNull = smj_isNull1;
/* 578 */       long smj_value = -1L;
/* 579 */       if (!smj_isNull1) {
/* 580 */         smj_value = (long) smj_value1;
/* 581 */       }
/* 582 */
/* 583 */       boolean smj_isNull3 = smj_leftRow.isNullAt(0);
/* 584 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(0));
/* 585 */       boolean smj_isNull2 = smj_isNull3;
/* 586 */       long smj_value2 = -1L;
/* 587 */       if (!smj_isNull3) {
/* 588 */         smj_value2 = (long) smj_value3;
/* 589 */       }
/* 590 */       if (smj_isNull || smj_isNull2) {
/* 591 */         smj_leftRow = null;
/* 592 */         continue;
/* 593 */       }
/* 594 */       if (!smj_matches.isEmpty()) {
/* 595 */         comp = 0;
/* 596 */         if (comp == 0) {
/* 597 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 598 */         }
/* 599 */         if (comp == 0) {
/* 600 */           comp = (smj_value2 > smj_value9 ? 1 : smj_value2 < smj_value9 ? -1 : 0);
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
/* 612 */             smj_value8 = smj_value;
/* 613 */             smj_value9 = smj_value2;
/* 614 */             return !smj_matches.isEmpty();
/* 615 */           }
/* 616 */           smj_rightRow = (InternalRow) rightIter.next();
/* 617 */
/* 618 */           boolean smj_isNull4 = smj_rightRow.isNullAt(1);
/* 619 */           long smj_value4 = smj_isNull4 ? -1L : (smj_rightRow.getLong(1));
/* 620 */
/* 621 */           boolean smj_isNull5 = smj_rightRow.isNullAt(0);
/* 622 */           long smj_value5 = smj_isNull5 ? -1L : (smj_rightRow.getLong(0));
/* 623 */           if (smj_isNull4 || smj_isNull5) {
/* 624 */             smj_rightRow = null;
/* 625 */             continue;
/* 626 */           }
/* 627 */           smj_value6 = smj_value4;
/* 628 */           smj_value7 = smj_value5;
/* 629 */         }
/* 630 */
/* 631 */         comp = 0;
/* 632 */         if (comp == 0) {
/* 633 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 634 */         }
/* 635 */         if (comp == 0) {
/* 636 */           comp = (smj_value2 > smj_value7 ? 1 : smj_value2 < smj_value7 ? -1 : 0);
/* 637 */         }
/* 638 */
/* 639 */         if (comp > 0) {
/* 640 */           smj_rightRow = null;
/* 641 */         } else if (comp < 0) {
/* 642 */           if (!smj_matches.isEmpty()) {
/* 643 */             smj_value8 = smj_value;
/* 644 */             smj_value9 = smj_value2;
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
