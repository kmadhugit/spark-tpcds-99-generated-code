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
/* 028 */   private UTF8String smj_value5;
/* 029 */   private boolean smj_isNull3;
/* 030 */   private UTF8String smj_value6;
/* 031 */   private boolean smj_isNull4;
/* 032 */   private UTF8String smj_value7;
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
/* 050 */   private UnsafeRow agg_result4;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 053 */   private int agg_value10;
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
/* 086 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 087 */     smj_result = new UnsafeRow(7);
/* 088 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 089 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
/* 090 */     project_result = new UnsafeRow(5);
/* 091 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
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
/* 104 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 105 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 106 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 107 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 108 */     private Object emptyVBase;
/* 109 */     private long emptyVOff;
/* 110 */     private int emptyVLen;
/* 111 */     private boolean isBatchFull = false;
/* 112 */
/* 113 */     public agg_FastHashMap(
/* 114 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 115 */       InternalRow emptyAggregationBuffer) {
/* 116 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 117 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 118 */
/* 119 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 120 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 121 */
/* 122 */       emptyVBase = emptyBuffer;
/* 123 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 124 */       emptyVLen = emptyBuffer.length;
/* 125 */
/* 126 */       buckets = new int[numBuckets];
/* 127 */       java.util.Arrays.fill(buckets, -1);
/* 128 */     }
/* 129 */
/* 130 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3) {
/* 131 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 132 */       int step = 0;
/* 133 */       int idx = (int) h & (numBuckets - 1);
/* 134 */       while (step < maxSteps) {
/* 135 */         // Return bucket index if it's either an empty slot or already contains the key
/* 136 */         if (buckets[idx] == -1) {
/* 137 */           if (numRows < capacity && !isBatchFull) {
/* 138 */             // creating the unsafe for new entry
/* 139 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 140 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 141 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 142 */               96);
/* 143 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 144 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 145 */               agg_holder,
/* 146 */               4);
/* 147 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 148 */             agg_rowWriter.zeroOutNullBytes();
/* 149 */             agg_rowWriter.write(0, agg_key);
/* 150 */             agg_rowWriter.write(1, agg_key1);
/* 151 */             agg_rowWriter.write(2, agg_key2);
/* 152 */             agg_rowWriter.write(3, agg_key3);
/* 153 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 154 */             Object kbase = agg_result.getBaseObject();
/* 155 */             long koff = agg_result.getBaseOffset();
/* 156 */             int klen = agg_result.getSizeInBytes();
/* 157 */
/* 158 */             UnsafeRow vRow
/* 159 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 160 */             if (vRow == null) {
/* 161 */               isBatchFull = true;
/* 162 */             } else {
/* 163 */               buckets[idx] = numRows++;
/* 164 */             }
/* 165 */             return vRow;
/* 166 */           } else {
/* 167 */             // No more space
/* 168 */             return null;
/* 169 */           }
/* 170 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 171 */           return batch.getValueRow(buckets[idx]);
/* 172 */         }
/* 173 */         idx = (idx + 1) & (numBuckets - 1);
/* 174 */         step++;
/* 175 */       }
/* 176 */       // Didn't find it
/* 177 */       return null;
/* 178 */     }
/* 179 */
/* 180 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3) {
/* 181 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 182 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3);
/* 183 */     }
/* 184 */
/* 185 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3) {
/* 186 */       long agg_hash = 0;
/* 187 */
/* 188 */       int agg_result = 0;
/* 189 */       byte[] agg_bytes = agg_key.getBytes();
/* 190 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 191 */         int agg_hash1 = agg_bytes[i];
/* 192 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 193 */       }
/* 194 */
/* 195 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 196 */
/* 197 */       int agg_result1 = 0;
/* 198 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 199 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 200 */         int agg_hash2 = agg_bytes1[i];
/* 201 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 202 */       }
/* 203 */
/* 204 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 205 */
/* 206 */       int agg_result2 = 0;
/* 207 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 208 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 209 */         int agg_hash3 = agg_bytes2[i];
/* 210 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 211 */       }
/* 212 */
/* 213 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 214 */
/* 215 */       int agg_result3 = agg_key3;
/* 216 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 217 */
/* 218 */       return agg_hash;
/* 219 */     }
/* 220 */
/* 221 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 222 */       return batch.rowIterator();
/* 223 */     }
/* 224 */
/* 225 */     public void close() {
/* 226 */       batch.close();
/* 227 */     }
/* 228 */
/* 229 */   }
/* 230 */
/* 231 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 232 */     agg_hashMap = agg_plan.createHashMap();
/* 233 */
/* 234 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 235 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 236 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 237 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 238 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 239 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 240 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 241 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 242 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 243 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 244 */       while (smj_iterator.hasNext()) {
/* 245 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 246 */
/* 247 */         smj_numOutputRows.add(1);
/* 248 */
/* 249 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(2);
/* 250 */         int smj_value10 = smj_isNull8 ? -1 : (smj_rightRow1.getInt(2));
/* 251 */
/* 252 */         // generate join key for stream side
/* 253 */
/* 254 */         boolean bhj_isNull = smj_isNull8;
/* 255 */         long bhj_value = -1L;
/* 256 */         if (!smj_isNull8) {
/* 257 */           bhj_value = (long) smj_value10;
/* 258 */         }
/* 259 */         // find matches from HashedRelation
/* 260 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 261 */         if (bhj_matched == null) continue;
/* 262 */
/* 263 */         bhj_numOutputRows.add(1);
/* 264 */
/* 265 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(1);
/* 266 */         double smj_value9 = smj_isNull7 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 267 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 268 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 269 */
/* 270 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 271 */
/* 272 */         UnsafeRow agg_fastAggBuffer = null;
/* 273 */
/* 274 */         if (true) {
/* 275 */           if (!smj_isNull3 && !smj_isNull4 && !smj_isNull5 && !bhj_isNull3) {
/* 276 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 277 */               smj_value5, smj_value6, smj_value7, bhj_value3);
/* 278 */           }
/* 279 */         }
/* 280 */
/* 281 */         if (agg_fastAggBuffer == null) {
/* 282 */           // generate grouping key
/* 283 */           agg_holder.reset();
/* 284 */
/* 285 */           agg_rowWriter.zeroOutNullBytes();
/* 286 */
/* 287 */           if (smj_isNull3) {
/* 288 */             agg_rowWriter.setNullAt(0);
/* 289 */           } else {
/* 290 */             agg_rowWriter.write(0, smj_value5);
/* 291 */           }
/* 292 */
/* 293 */           if (smj_isNull4) {
/* 294 */             agg_rowWriter.setNullAt(1);
/* 295 */           } else {
/* 296 */             agg_rowWriter.write(1, smj_value6);
/* 297 */           }
/* 298 */
/* 299 */           if (smj_isNull5) {
/* 300 */             agg_rowWriter.setNullAt(2);
/* 301 */           } else {
/* 302 */             agg_rowWriter.write(2, smj_value7);
/* 303 */           }
/* 304 */
/* 305 */           if (bhj_isNull3) {
/* 306 */             agg_rowWriter.setNullAt(3);
/* 307 */           } else {
/* 308 */             agg_rowWriter.write(3, bhj_value3);
/* 309 */           }
/* 310 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 311 */           agg_value10 = 42;
/* 312 */
/* 313 */           if (!smj_isNull3) {
/* 314 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value5.getBaseObject(), smj_value5.getBaseOffset(), smj_value5.numBytes(), agg_value10);
/* 315 */           }
/* 316 */
/* 317 */           if (!smj_isNull4) {
/* 318 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value6.getBaseObject(), smj_value6.getBaseOffset(), smj_value6.numBytes(), agg_value10);
/* 319 */           }
/* 320 */
/* 321 */           if (!smj_isNull5) {
/* 322 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value7.getBaseObject(), smj_value7.getBaseOffset(), smj_value7.numBytes(), agg_value10);
/* 323 */           }
/* 324 */
/* 325 */           if (!bhj_isNull3) {
/* 326 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value10);
/* 327 */           }
/* 328 */           if (true) {
/* 329 */             // try to get the buffer from hash map
/* 330 */             agg_unsafeRowAggBuffer =
/* 331 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 332 */           }
/* 333 */           if (agg_unsafeRowAggBuffer == null) {
/* 334 */             if (agg_sorter == null) {
/* 335 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 336 */             } else {
/* 337 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 338 */             }
/* 339 */
/* 340 */             // the hash map had be spilled, it should have enough memory now,
/* 341 */             // try  to allocate buffer again.
/* 342 */             agg_unsafeRowAggBuffer =
/* 343 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 344 */             if (agg_unsafeRowAggBuffer == null) {
/* 345 */               // failed to allocate the first page
/* 346 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 347 */             }
/* 348 */           }
/* 349 */         }
/* 350 */
/* 351 */         if (agg_fastAggBuffer != null) {
/* 352 */           // update fast row
/* 353 */
/* 354 */           // common sub-expressions
/* 355 */
/* 356 */           // evaluate aggregate function
/* 357 */           boolean agg_isNull23 = true;
/* 358 */           double agg_value24 = -1.0;
/* 359 */
/* 360 */           boolean agg_isNull25 = agg_fastAggBuffer.isNullAt(0);
/* 361 */           double agg_value26 = agg_isNull25 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 362 */           boolean agg_isNull24 = agg_isNull25;
/* 363 */           double agg_value25 = agg_value26;
/* 364 */           if (agg_isNull24) {
/* 365 */             boolean agg_isNull26 = false;
/* 366 */             double agg_value27 = -1.0;
/* 367 */             if (!false) {
/* 368 */               agg_value27 = (double) 0;
/* 369 */             }
/* 370 */             if (!agg_isNull26) {
/* 371 */               agg_isNull24 = false;
/* 372 */               agg_value25 = agg_value27;
/* 373 */             }
/* 374 */           }
/* 375 */
/* 376 */           if (!smj_isNull7) {
/* 377 */             agg_isNull23 = false; // resultCode could change nullability.
/* 378 */             agg_value24 = agg_value25 + smj_value9;
/* 379 */
/* 380 */           }
/* 381 */           boolean agg_isNull22 = agg_isNull23;
/* 382 */           double agg_value23 = agg_value24;
/* 383 */           if (agg_isNull22) {
/* 384 */             boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 385 */             double agg_value30 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 386 */             if (!agg_isNull29) {
/* 387 */               agg_isNull22 = false;
/* 388 */               agg_value23 = agg_value30;
/* 389 */             }
/* 390 */           }
/* 391 */           // update fast row
/* 392 */           if (!agg_isNull22) {
/* 393 */             agg_fastAggBuffer.setDouble(0, agg_value23);
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
/* 404 */           boolean agg_isNull15 = true;
/* 405 */           double agg_value16 = -1.0;
/* 406 */
/* 407 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 408 */           double agg_value18 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 409 */           boolean agg_isNull16 = agg_isNull17;
/* 410 */           double agg_value17 = agg_value18;
/* 411 */           if (agg_isNull16) {
/* 412 */             boolean agg_isNull18 = false;
/* 413 */             double agg_value19 = -1.0;
/* 414 */             if (!false) {
/* 415 */               agg_value19 = (double) 0;
/* 416 */             }
/* 417 */             if (!agg_isNull18) {
/* 418 */               agg_isNull16 = false;
/* 419 */               agg_value17 = agg_value19;
/* 420 */             }
/* 421 */           }
/* 422 */
/* 423 */           if (!smj_isNull7) {
/* 424 */             agg_isNull15 = false; // resultCode could change nullability.
/* 425 */             agg_value16 = agg_value17 + smj_value9;
/* 426 */
/* 427 */           }
/* 428 */           boolean agg_isNull14 = agg_isNull15;
/* 429 */           double agg_value15 = agg_value16;
/* 430 */           if (agg_isNull14) {
/* 431 */             boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 432 */             double agg_value22 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 433 */             if (!agg_isNull21) {
/* 434 */               agg_isNull14 = false;
/* 435 */               agg_value15 = agg_value22;
/* 436 */             }
/* 437 */           }
/* 438 */           // update unsafe row buffer
/* 439 */           if (!agg_isNull14) {
/* 440 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 441 */           } else {
/* 442 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 443 */           }
/* 444 */
/* 445 */         }
/* 446 */
/* 447 */       }
/* 448 */       if (shouldStop()) return;
/* 449 */     }
/* 450 */
/* 451 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 452 */
/* 453 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 454 */   }
/* 455 */
/* 456 */   private boolean findNextInnerJoinRows(
/* 457 */     scala.collection.Iterator leftIter,
/* 458 */     scala.collection.Iterator rightIter) {
/* 459 */     smj_leftRow = null;
/* 460 */     int comp = 0;
/* 461 */     while (smj_leftRow == null) {
/* 462 */       if (!leftIter.hasNext()) return false;
/* 463 */       smj_leftRow = (InternalRow) leftIter.next();
/* 464 */
/* 465 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 466 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 467 */       if (smj_isNull) {
/* 468 */         smj_leftRow = null;
/* 469 */         continue;
/* 470 */       }
/* 471 */       if (!smj_matches.isEmpty()) {
/* 472 */         comp = 0;
/* 473 */         if (comp == 0) {
/* 474 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 475 */         }
/* 476 */
/* 477 */         if (comp == 0) {
/* 478 */           return true;
/* 479 */         }
/* 480 */         smj_matches.clear();
/* 481 */       }
/* 482 */
/* 483 */       do {
/* 484 */         if (smj_rightRow == null) {
/* 485 */           if (!rightIter.hasNext()) {
/* 486 */             smj_value3 = smj_value;
/* 487 */             return !smj_matches.isEmpty();
/* 488 */           }
/* 489 */           smj_rightRow = (InternalRow) rightIter.next();
/* 490 */
/* 491 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 492 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 493 */           if (smj_isNull1) {
/* 494 */             smj_rightRow = null;
/* 495 */             continue;
/* 496 */           }
/* 497 */           smj_value2 = smj_value1;
/* 498 */         }
/* 499 */
/* 500 */         comp = 0;
/* 501 */         if (comp == 0) {
/* 502 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 503 */         }
/* 504 */
/* 505 */         if (comp > 0) {
/* 506 */           smj_rightRow = null;
/* 507 */         } else if (comp < 0) {
/* 508 */           if (!smj_matches.isEmpty()) {
/* 509 */             smj_value3 = smj_value;
/* 510 */             return true;
/* 511 */           }
/* 512 */           smj_leftRow = null;
/* 513 */         } else {
/* 514 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 515 */           smj_rightRow = null;;
/* 516 */         }
/* 517 */       } while (smj_leftRow != null);
/* 518 */     }
/* 519 */     return false; // unreachable
/* 520 */   }
/* 521 */
/* 522 */   private void wholestagecodegen_init_2() {
/* 523 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 524 */
/* 525 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 526 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 527 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 528 */
/* 529 */   }
/* 530 */
/* 531 */   private void wholestagecodegen_init_1() {
/* 532 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 533 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 534 */
/* 535 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 536 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 537 */
/* 538 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 539 */     bhj_result = new UnsafeRow(7);
/* 540 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 541 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 542 */     project_result1 = new UnsafeRow(5);
/* 543 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 544 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 545 */     agg_result4 = new UnsafeRow(4);
/* 546 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 96);
/* 547 */
/* 548 */   }
/* 549 */
/* 550 */   protected void processNext() throws java.io.IOException {
/* 551 */     if (!agg_initAgg) {
/* 552 */       agg_initAgg = true;
/* 553 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 554 */       agg_doAggregateWithKeys();
/* 555 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 556 */     }
/* 557 */
/* 558 */     // output the result
/* 559 */
/* 560 */     while (agg_fastHashMapIter.next()) {
/* 561 */       wholestagecodegen_numOutputRows.add(1);
/* 562 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 563 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 564 */
/* 565 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 566 */
/* 567 */       append(agg_resultRow.copy());
/* 568 */
/* 569 */       if (shouldStop()) return;
/* 570 */     }
/* 571 */     agg_fastHashMap.close();
/* 572 */
/* 573 */     while (agg_mapIter.next()) {
/* 574 */       wholestagecodegen_numOutputRows.add(1);
/* 575 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 576 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 577 */
/* 578 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 579 */
/* 580 */       append(agg_resultRow.copy());
/* 581 */
/* 582 */       if (shouldStop()) return;
/* 583 */     }
/* 584 */
/* 585 */     agg_mapIter.close();
/* 586 */     if (agg_sorter == null) {
/* 587 */       agg_hashMap.free();
/* 588 */     }
/* 589 */   }
/* 590 */ }
