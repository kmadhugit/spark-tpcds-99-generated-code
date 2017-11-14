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
/* 023 */   private int smj_value2;
/* 024 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 025 */   private int smj_value3;
/* 026 */   private int smj_value4;
/* 027 */   private boolean smj_isNull2;
/* 028 */   private int smj_value5;
/* 029 */   private boolean smj_isNull3;
/* 030 */   private double smj_value6;
/* 031 */   private boolean smj_isNull4;
/* 032 */   private int smj_value7;
/* 033 */   private boolean smj_isNull5;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 035 */   private UnsafeRow smj_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 042 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 044 */   private UnsafeRow bhj_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 047 */   private UnsafeRow project_result1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 050 */   private UnsafeRow agg_result2;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 053 */   private int agg_value6;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 055 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 057 */
/* 058 */   public GeneratedIterator(Object[] references) {
/* 059 */     this.references = references;
/* 060 */   }
/* 061 */
/* 062 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 063 */     partitionIndex = index;
/* 064 */     this.inputs = inputs;
/* 065 */     wholestagecodegen_init_0();
/* 066 */     wholestagecodegen_init_1();
/* 067 */     wholestagecodegen_init_2();
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private void wholestagecodegen_init_0() {
/* 072 */     agg_initAgg = false;
/* 073 */
/* 074 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 075 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 076 */
/* 077 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 078 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 079 */     smj_leftInput = inputs[0];
/* 080 */     smj_rightInput = inputs[1];
/* 081 */
/* 082 */     smj_rightRow = null;
/* 083 */
/* 084 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 085 */
/* 086 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 087 */     smj_result = new UnsafeRow(7);
/* 088 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 089 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
/* 090 */     project_result = new UnsafeRow(5);
/* 091 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   public class agg_FastHashMap {
/* 096 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 097 */     private int[] buckets;
/* 098 */     private int capacity = 1 << 16;
/* 099 */     private double loadFactor = 0.5;
/* 100 */     private int numBuckets = (int) (capacity / loadFactor);
/* 101 */     private int maxSteps = 2;
/* 102 */     private int numRows = 0;
/* 103 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 104 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType);
/* 105 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 106 */     private Object emptyVBase;
/* 107 */     private long emptyVOff;
/* 108 */     private int emptyVLen;
/* 109 */     private boolean isBatchFull = false;
/* 110 */
/* 111 */     public agg_FastHashMap(
/* 112 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 113 */       InternalRow emptyAggregationBuffer) {
/* 114 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 115 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 116 */
/* 117 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 118 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 119 */
/* 120 */       emptyVBase = emptyBuffer;
/* 121 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 122 */       emptyVLen = emptyBuffer.length;
/* 123 */
/* 124 */       buckets = new int[numBuckets];
/* 125 */       java.util.Arrays.fill(buckets, -1);
/* 126 */     }
/* 127 */
/* 128 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1) {
/* 129 */       long h = hash(agg_key, agg_key1);
/* 130 */       int step = 0;
/* 131 */       int idx = (int) h & (numBuckets - 1);
/* 132 */       while (step < maxSteps) {
/* 133 */         // Return bucket index if it's either an empty slot or already contains the key
/* 134 */         if (buckets[idx] == -1) {
/* 135 */           if (numRows < capacity && !isBatchFull) {
/* 136 */             // creating the unsafe for new entry
/* 137 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 138 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 139 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 140 */               64);
/* 141 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 142 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 143 */               agg_holder,
/* 144 */               2);
/* 145 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 146 */             agg_rowWriter.zeroOutNullBytes();
/* 147 */             agg_rowWriter.write(0, agg_key);
/* 148 */             agg_rowWriter.write(1, agg_key1);
/* 149 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 150 */             Object kbase = agg_result.getBaseObject();
/* 151 */             long koff = agg_result.getBaseOffset();
/* 152 */             int klen = agg_result.getSizeInBytes();
/* 153 */
/* 154 */             UnsafeRow vRow
/* 155 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 156 */             if (vRow == null) {
/* 157 */               isBatchFull = true;
/* 158 */             } else {
/* 159 */               buckets[idx] = numRows++;
/* 160 */             }
/* 161 */             return vRow;
/* 162 */           } else {
/* 163 */             // No more space
/* 164 */             return null;
/* 165 */           }
/* 166 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 167 */           return batch.getValueRow(buckets[idx]);
/* 168 */         }
/* 169 */         idx = (idx + 1) & (numBuckets - 1);
/* 170 */         step++;
/* 171 */       }
/* 172 */       // Didn't find it
/* 173 */       return null;
/* 174 */     }
/* 175 */
/* 176 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1) {
/* 177 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 178 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1));
/* 179 */     }
/* 180 */
/* 181 */     private long hash(UTF8String agg_key, UTF8String agg_key1) {
/* 182 */       long agg_hash = 0;
/* 183 */
/* 184 */       int agg_result = 0;
/* 185 */       byte[] agg_bytes = agg_key.getBytes();
/* 186 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 187 */         int agg_hash1 = agg_bytes[i];
/* 188 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 189 */       }
/* 190 */
/* 191 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 192 */
/* 193 */       int agg_result1 = 0;
/* 194 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 195 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 196 */         int agg_hash2 = agg_bytes1[i];
/* 197 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 198 */       }
/* 199 */
/* 200 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 201 */
/* 202 */       return agg_hash;
/* 203 */     }
/* 204 */
/* 205 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 206 */       return batch.rowIterator();
/* 207 */     }
/* 208 */
/* 209 */     public void close() {
/* 210 */       batch.close();
/* 211 */     }
/* 212 */
/* 213 */   }
/* 214 */
/* 215 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 216 */     agg_hashMap = agg_plan.createHashMap();
/* 217 */
/* 218 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 219 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 220 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 221 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 222 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 223 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 224 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 225 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 226 */       smj_value7 = smj_isNull5 ? -1 : (smj_leftRow.getInt(3));
/* 227 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 228 */       while (smj_iterator.hasNext()) {
/* 229 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 230 */
/* 231 */         smj_numOutputRows.add(1);
/* 232 */
/* 233 */         // generate join key for stream side
/* 234 */
/* 235 */         boolean bhj_isNull = smj_isNull5;
/* 236 */         long bhj_value = -1L;
/* 237 */         if (!smj_isNull5) {
/* 238 */           bhj_value = (long) smj_value7;
/* 239 */         }
/* 240 */         // find matches from HashedRelation
/* 241 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 242 */         if (bhj_matched == null) continue;
/* 243 */
/* 244 */         bhj_numOutputRows.add(1);
/* 245 */
/* 246 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(1);
/* 247 */         UTF8String smj_value9 = smj_isNull7 ? null : (smj_rightRow1.getUTF8String(1));
/* 248 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(2);
/* 249 */         UTF8String smj_value10 = smj_isNull8 ? null : (smj_rightRow1.getUTF8String(2));
/* 250 */
/* 251 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 252 */
/* 253 */         UnsafeRow agg_fastAggBuffer = null;
/* 254 */
/* 255 */         if (true) {
/* 256 */           if (!smj_isNull8 && !smj_isNull7) {
/* 257 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 258 */               smj_value10, smj_value9);
/* 259 */           }
/* 260 */         }
/* 261 */
/* 262 */         if (agg_fastAggBuffer == null) {
/* 263 */           // generate grouping key
/* 264 */           agg_holder.reset();
/* 265 */
/* 266 */           agg_rowWriter.zeroOutNullBytes();
/* 267 */
/* 268 */           if (smj_isNull8) {
/* 269 */             agg_rowWriter.setNullAt(0);
/* 270 */           } else {
/* 271 */             agg_rowWriter.write(0, smj_value10);
/* 272 */           }
/* 273 */
/* 274 */           if (smj_isNull7) {
/* 275 */             agg_rowWriter.setNullAt(1);
/* 276 */           } else {
/* 277 */             agg_rowWriter.write(1, smj_value9);
/* 278 */           }
/* 279 */           agg_result2.setTotalSize(agg_holder.totalSize());
/* 280 */           agg_value6 = 42;
/* 281 */
/* 282 */           if (!smj_isNull8) {
/* 283 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value10.getBaseObject(), smj_value10.getBaseOffset(), smj_value10.numBytes(), agg_value6);
/* 284 */           }
/* 285 */
/* 286 */           if (!smj_isNull7) {
/* 287 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value9.getBaseObject(), smj_value9.getBaseOffset(), smj_value9.numBytes(), agg_value6);
/* 288 */           }
/* 289 */           if (true) {
/* 290 */             // try to get the buffer from hash map
/* 291 */             agg_unsafeRowAggBuffer =
/* 292 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 293 */           }
/* 294 */           if (agg_unsafeRowAggBuffer == null) {
/* 295 */             if (agg_sorter == null) {
/* 296 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 297 */             } else {
/* 298 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 299 */             }
/* 300 */
/* 301 */             // the hash map had be spilled, it should have enough memory now,
/* 302 */             // try  to allocate buffer again.
/* 303 */             agg_unsafeRowAggBuffer =
/* 304 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 305 */             if (agg_unsafeRowAggBuffer == null) {
/* 306 */               // failed to allocate the first page
/* 307 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 308 */             }
/* 309 */           }
/* 310 */         }
/* 311 */
/* 312 */         if (agg_fastAggBuffer != null) {
/* 313 */           // update fast row
/* 314 */
/* 315 */           // common sub-expressions
/* 316 */
/* 317 */           // evaluate aggregate function
/* 318 */           boolean agg_isNull20 = true;
/* 319 */           double agg_value21 = -1.0;
/* 320 */
/* 321 */           boolean agg_isNull22 = agg_fastAggBuffer.isNullAt(0);
/* 322 */           double agg_value23 = agg_isNull22 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 323 */           boolean agg_isNull21 = agg_isNull22;
/* 324 */           double agg_value22 = agg_value23;
/* 325 */           if (agg_isNull21) {
/* 326 */             boolean agg_isNull23 = false;
/* 327 */             double agg_value24 = -1.0;
/* 328 */             if (!false) {
/* 329 */               agg_value24 = (double) 0;
/* 330 */             }
/* 331 */             if (!agg_isNull23) {
/* 332 */               agg_isNull21 = false;
/* 333 */               agg_value22 = agg_value24;
/* 334 */             }
/* 335 */           }
/* 336 */
/* 337 */           boolean agg_isNull25 = true;
/* 338 */           double agg_value26 = -1.0;
/* 339 */
/* 340 */           boolean agg_isNull26 = smj_isNull3;
/* 341 */           double agg_value27 = -1.0;
/* 342 */           if (!smj_isNull3) {
/* 343 */             agg_value27 = (double) smj_value5;
/* 344 */           }
/* 345 */           if (!agg_isNull26) {
/* 346 */             if (!smj_isNull4) {
/* 347 */               agg_isNull25 = false; // resultCode could change nullability.
/* 348 */               agg_value26 = agg_value27 * smj_value6;
/* 349 */
/* 350 */             }
/* 351 */
/* 352 */           }
/* 353 */           if (!agg_isNull25) {
/* 354 */             agg_isNull20 = false; // resultCode could change nullability.
/* 355 */             agg_value21 = agg_value22 + agg_value26;
/* 356 */
/* 357 */           }
/* 358 */           boolean agg_isNull19 = agg_isNull20;
/* 359 */           double agg_value20 = agg_value21;
/* 360 */           if (agg_isNull19) {
/* 361 */             boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 362 */             double agg_value30 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 363 */             if (!agg_isNull29) {
/* 364 */               agg_isNull19 = false;
/* 365 */               agg_value20 = agg_value30;
/* 366 */             }
/* 367 */           }
/* 368 */           // update fast row
/* 369 */           if (!agg_isNull19) {
/* 370 */             agg_fastAggBuffer.setDouble(0, agg_value20);
/* 371 */           } else {
/* 372 */             agg_fastAggBuffer.setNullAt(0);
/* 373 */           }
/* 374 */
/* 375 */         } else {
/* 376 */           // update unsafe row
/* 377 */
/* 378 */           // common sub-expressions
/* 379 */
/* 380 */           // evaluate aggregate function
/* 381 */           boolean agg_isNull9 = true;
/* 382 */           double agg_value10 = -1.0;
/* 383 */
/* 384 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 385 */           double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 386 */           boolean agg_isNull10 = agg_isNull11;
/* 387 */           double agg_value11 = agg_value12;
/* 388 */           if (agg_isNull10) {
/* 389 */             boolean agg_isNull12 = false;
/* 390 */             double agg_value13 = -1.0;
/* 391 */             if (!false) {
/* 392 */               agg_value13 = (double) 0;
/* 393 */             }
/* 394 */             if (!agg_isNull12) {
/* 395 */               agg_isNull10 = false;
/* 396 */               agg_value11 = agg_value13;
/* 397 */             }
/* 398 */           }
/* 399 */
/* 400 */           boolean agg_isNull14 = true;
/* 401 */           double agg_value15 = -1.0;
/* 402 */
/* 403 */           boolean agg_isNull15 = smj_isNull3;
/* 404 */           double agg_value16 = -1.0;
/* 405 */           if (!smj_isNull3) {
/* 406 */             agg_value16 = (double) smj_value5;
/* 407 */           }
/* 408 */           if (!agg_isNull15) {
/* 409 */             if (!smj_isNull4) {
/* 410 */               agg_isNull14 = false; // resultCode could change nullability.
/* 411 */               agg_value15 = agg_value16 * smj_value6;
/* 412 */
/* 413 */             }
/* 414 */
/* 415 */           }
/* 416 */           if (!agg_isNull14) {
/* 417 */             agg_isNull9 = false; // resultCode could change nullability.
/* 418 */             agg_value10 = agg_value11 + agg_value15;
/* 419 */
/* 420 */           }
/* 421 */           boolean agg_isNull8 = agg_isNull9;
/* 422 */           double agg_value9 = agg_value10;
/* 423 */           if (agg_isNull8) {
/* 424 */             boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 425 */             double agg_value19 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 426 */             if (!agg_isNull18) {
/* 427 */               agg_isNull8 = false;
/* 428 */               agg_value9 = agg_value19;
/* 429 */             }
/* 430 */           }
/* 431 */           // update unsafe row buffer
/* 432 */           if (!agg_isNull8) {
/* 433 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 434 */           } else {
/* 435 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 436 */           }
/* 437 */
/* 438 */         }
/* 439 */
/* 440 */       }
/* 441 */       if (shouldStop()) return;
/* 442 */     }
/* 443 */
/* 444 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 445 */
/* 446 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 447 */   }
/* 448 */
/* 449 */   private boolean findNextInnerJoinRows(
/* 450 */     scala.collection.Iterator leftIter,
/* 451 */     scala.collection.Iterator rightIter) {
/* 452 */     smj_leftRow = null;
/* 453 */     int comp = 0;
/* 454 */     while (smj_leftRow == null) {
/* 455 */       if (!leftIter.hasNext()) return false;
/* 456 */       smj_leftRow = (InternalRow) leftIter.next();
/* 457 */
/* 458 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 459 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 460 */       if (smj_isNull) {
/* 461 */         smj_leftRow = null;
/* 462 */         continue;
/* 463 */       }
/* 464 */       if (!smj_matches.isEmpty()) {
/* 465 */         comp = 0;
/* 466 */         if (comp == 0) {
/* 467 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 468 */         }
/* 469 */
/* 470 */         if (comp == 0) {
/* 471 */           return true;
/* 472 */         }
/* 473 */         smj_matches.clear();
/* 474 */       }
/* 475 */
/* 476 */       do {
/* 477 */         if (smj_rightRow == null) {
/* 478 */           if (!rightIter.hasNext()) {
/* 479 */             smj_value3 = smj_value;
/* 480 */             return !smj_matches.isEmpty();
/* 481 */           }
/* 482 */           smj_rightRow = (InternalRow) rightIter.next();
/* 483 */
/* 484 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 485 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 486 */           if (smj_isNull1) {
/* 487 */             smj_rightRow = null;
/* 488 */             continue;
/* 489 */           }
/* 490 */           smj_value2 = smj_value1;
/* 491 */         }
/* 492 */
/* 493 */         comp = 0;
/* 494 */         if (comp == 0) {
/* 495 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 496 */         }
/* 497 */
/* 498 */         if (comp > 0) {
/* 499 */           smj_rightRow = null;
/* 500 */         } else if (comp < 0) {
/* 501 */           if (!smj_matches.isEmpty()) {
/* 502 */             smj_value3 = smj_value;
/* 503 */             return true;
/* 504 */           }
/* 505 */           smj_leftRow = null;
/* 506 */         } else {
/* 507 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 508 */           smj_rightRow = null;;
/* 509 */         }
/* 510 */       } while (smj_leftRow != null);
/* 511 */     }
/* 512 */     return false; // unreachable
/* 513 */   }
/* 514 */
/* 515 */   private void wholestagecodegen_init_2() {
/* 516 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 517 */
/* 518 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 519 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 520 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 521 */
/* 522 */   }
/* 523 */
/* 524 */   private void wholestagecodegen_init_1() {
/* 525 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 526 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 527 */
/* 528 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 529 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 530 */
/* 531 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 532 */     bhj_result = new UnsafeRow(6);
/* 533 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 534 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 535 */     project_result1 = new UnsafeRow(4);
/* 536 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 537 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 538 */     agg_result2 = new UnsafeRow(2);
/* 539 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 64);
/* 540 */
/* 541 */   }
/* 542 */
/* 543 */   protected void processNext() throws java.io.IOException {
/* 544 */     if (!agg_initAgg) {
/* 545 */       agg_initAgg = true;
/* 546 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 547 */       agg_doAggregateWithKeys();
/* 548 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 549 */     }
/* 550 */
/* 551 */     // output the result
/* 552 */
/* 553 */     while (agg_fastHashMapIter.next()) {
/* 554 */       wholestagecodegen_numOutputRows.add(1);
/* 555 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 556 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 557 */
/* 558 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 559 */
/* 560 */       append(agg_resultRow.copy());
/* 561 */
/* 562 */       if (shouldStop()) return;
/* 563 */     }
/* 564 */     agg_fastHashMap.close();
/* 565 */
/* 566 */     while (agg_mapIter.next()) {
/* 567 */       wholestagecodegen_numOutputRows.add(1);
/* 568 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 569 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 570 */
/* 571 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 572 */
/* 573 */       append(agg_resultRow.copy());
/* 574 */
/* 575 */       if (shouldStop()) return;
/* 576 */     }
/* 577 */
/* 578 */     agg_mapIter.close();
/* 579 */     if (agg_sorter == null) {
/* 580 */       agg_hashMap.free();
/* 581 */     }
/* 582 */   }
/* 583 */ }
