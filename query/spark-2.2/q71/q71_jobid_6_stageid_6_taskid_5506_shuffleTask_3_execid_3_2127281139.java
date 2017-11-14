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
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 021 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 023 */   private UnsafeRow bhj_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 030 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 032 */   private UnsafeRow bhj_result1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 035 */   private UnsafeRow project_result1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 038 */   private UnsafeRow agg_result4;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 041 */   private int agg_value10;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     wholestagecodegen_init_0();
/* 054 */     wholestagecodegen_init_1();
/* 055 */     wholestagecodegen_init_2();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     agg_initAgg = false;
/* 061 */
/* 062 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 063 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 064 */
/* 065 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 066 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 067 */     inputadapter_input = inputs[0];
/* 068 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 069 */
/* 070 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 071 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 072 */
/* 073 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 074 */     bhj_result = new UnsafeRow(6);
/* 075 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 076 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */   public class agg_FastHashMap {
/* 081 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 082 */     private int[] buckets;
/* 083 */     private int capacity = 1 << 16;
/* 084 */     private double loadFactor = 0.5;
/* 085 */     private int numBuckets = (int) (capacity / loadFactor);
/* 086 */     private int maxSteps = 2;
/* 087 */     private int numRows = 0;
/* 088 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 089 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 090 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 091 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 092 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 093 */     private Object emptyVBase;
/* 094 */     private long emptyVOff;
/* 095 */     private int emptyVLen;
/* 096 */     private boolean isBatchFull = false;
/* 097 */
/* 098 */     public agg_FastHashMap(
/* 099 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 100 */       InternalRow emptyAggregationBuffer) {
/* 101 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 102 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 103 */
/* 104 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 105 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 106 */
/* 107 */       emptyVBase = emptyBuffer;
/* 108 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 109 */       emptyVLen = emptyBuffer.length;
/* 110 */
/* 111 */       buckets = new int[numBuckets];
/* 112 */       java.util.Arrays.fill(buckets, -1);
/* 113 */     }
/* 114 */
/* 115 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 116 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 117 */       int step = 0;
/* 118 */       int idx = (int) h & (numBuckets - 1);
/* 119 */       while (step < maxSteps) {
/* 120 */         // Return bucket index if it's either an empty slot or already contains the key
/* 121 */         if (buckets[idx] == -1) {
/* 122 */           if (numRows < capacity && !isBatchFull) {
/* 123 */             // creating the unsafe for new entry
/* 124 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 125 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 126 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 127 */               32);
/* 128 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 129 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 130 */               agg_holder,
/* 131 */               4);
/* 132 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 133 */             agg_rowWriter.zeroOutNullBytes();
/* 134 */             agg_rowWriter.write(0, agg_key);
/* 135 */             agg_rowWriter.write(1, agg_key1);
/* 136 */             agg_rowWriter.write(2, agg_key2);
/* 137 */             agg_rowWriter.write(3, agg_key3);
/* 138 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 139 */             Object kbase = agg_result.getBaseObject();
/* 140 */             long koff = agg_result.getBaseOffset();
/* 141 */             int klen = agg_result.getSizeInBytes();
/* 142 */
/* 143 */             UnsafeRow vRow
/* 144 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 145 */             if (vRow == null) {
/* 146 */               isBatchFull = true;
/* 147 */             } else {
/* 148 */               buckets[idx] = numRows++;
/* 149 */             }
/* 150 */             return vRow;
/* 151 */           } else {
/* 152 */             // No more space
/* 153 */             return null;
/* 154 */           }
/* 155 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 156 */           return batch.getValueRow(buckets[idx]);
/* 157 */         }
/* 158 */         idx = (idx + 1) & (numBuckets - 1);
/* 159 */         step++;
/* 160 */       }
/* 161 */       // Didn't find it
/* 162 */       return null;
/* 163 */     }
/* 164 */
/* 165 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 166 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 167 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getInt(3) == agg_key3);
/* 168 */     }
/* 169 */
/* 170 */     private long hash(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 171 */       long agg_hash = 0;
/* 172 */
/* 173 */       int agg_result = 0;
/* 174 */       byte[] agg_bytes = agg_key.getBytes();
/* 175 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 176 */         int agg_hash1 = agg_bytes[i];
/* 177 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 178 */       }
/* 179 */
/* 180 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 181 */
/* 182 */       int agg_result1 = agg_key1;
/* 183 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 184 */
/* 185 */       int agg_result2 = agg_key2;
/* 186 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 187 */
/* 188 */       int agg_result3 = agg_key3;
/* 189 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 190 */
/* 191 */       return agg_hash;
/* 192 */     }
/* 193 */
/* 194 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 195 */       return batch.rowIterator();
/* 196 */     }
/* 197 */
/* 198 */     public void close() {
/* 199 */       batch.close();
/* 200 */     }
/* 201 */
/* 202 */   }
/* 203 */
/* 204 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 205 */     agg_hashMap = agg_plan.createHashMap();
/* 206 */
/* 207 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 208 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 209 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 210 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 211 */
/* 212 */       // generate join key for stream side
/* 213 */
/* 214 */       boolean bhj_isNull = inputadapter_isNull1;
/* 215 */       long bhj_value = -1L;
/* 216 */       if (!inputadapter_isNull1) {
/* 217 */         bhj_value = (long) inputadapter_value1;
/* 218 */       }
/* 219 */       // find matches from HashedRelation
/* 220 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 221 */       if (bhj_matched == null) continue;
/* 222 */
/* 223 */       bhj_numOutputRows.add(1);
/* 224 */
/* 225 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 226 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 227 */
/* 228 */       // generate join key for stream side
/* 229 */
/* 230 */       boolean bhj_isNull11 = inputadapter_isNull2;
/* 231 */       long bhj_value11 = -1L;
/* 232 */       if (!inputadapter_isNull2) {
/* 233 */         bhj_value11 = (long) inputadapter_value2;
/* 234 */       }
/* 235 */       // find matches from HashedRelation
/* 236 */       UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 237 */       if (bhj_matched1 == null) continue;
/* 238 */
/* 239 */       bhj_numOutputRows1.add(1);
/* 240 */
/* 241 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 242 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 243 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 244 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 245 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 246 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 247 */       boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 248 */       int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched1.getInt(1));
/* 249 */       boolean bhj_isNull15 = bhj_matched1.isNullAt(2);
/* 250 */       int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(2));
/* 251 */
/* 252 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 253 */
/* 254 */       UnsafeRow agg_fastAggBuffer = null;
/* 255 */
/* 256 */       if (true) {
/* 257 */         if (!bhj_isNull4 && !bhj_isNull3 && !bhj_isNull14 && !bhj_isNull15) {
/* 258 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 259 */             bhj_value4, bhj_value3, bhj_value14, bhj_value15);
/* 260 */         }
/* 261 */       }
/* 262 */
/* 263 */       if (agg_fastAggBuffer == null) {
/* 264 */         // generate grouping key
/* 265 */         agg_holder.reset();
/* 266 */
/* 267 */         agg_rowWriter.zeroOutNullBytes();
/* 268 */
/* 269 */         if (bhj_isNull4) {
/* 270 */           agg_rowWriter.setNullAt(0);
/* 271 */         } else {
/* 272 */           agg_rowWriter.write(0, bhj_value4);
/* 273 */         }
/* 274 */
/* 275 */         if (bhj_isNull3) {
/* 276 */           agg_rowWriter.setNullAt(1);
/* 277 */         } else {
/* 278 */           agg_rowWriter.write(1, bhj_value3);
/* 279 */         }
/* 280 */
/* 281 */         if (bhj_isNull14) {
/* 282 */           agg_rowWriter.setNullAt(2);
/* 283 */         } else {
/* 284 */           agg_rowWriter.write(2, bhj_value14);
/* 285 */         }
/* 286 */
/* 287 */         if (bhj_isNull15) {
/* 288 */           agg_rowWriter.setNullAt(3);
/* 289 */         } else {
/* 290 */           agg_rowWriter.write(3, bhj_value15);
/* 291 */         }
/* 292 */         agg_result4.setTotalSize(agg_holder.totalSize());
/* 293 */         agg_value10 = 42;
/* 294 */
/* 295 */         if (!bhj_isNull4) {
/* 296 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value10);
/* 297 */         }
/* 298 */
/* 299 */         if (!bhj_isNull3) {
/* 300 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value10);
/* 301 */         }
/* 302 */
/* 303 */         if (!bhj_isNull14) {
/* 304 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value14, agg_value10);
/* 305 */         }
/* 306 */
/* 307 */         if (!bhj_isNull15) {
/* 308 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value10);
/* 309 */         }
/* 310 */         if (true) {
/* 311 */           // try to get the buffer from hash map
/* 312 */           agg_unsafeRowAggBuffer =
/* 313 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 314 */         }
/* 315 */         if (agg_unsafeRowAggBuffer == null) {
/* 316 */           if (agg_sorter == null) {
/* 317 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 318 */           } else {
/* 319 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 320 */           }
/* 321 */
/* 322 */           // the hash map had be spilled, it should have enough memory now,
/* 323 */           // try  to allocate buffer again.
/* 324 */           agg_unsafeRowAggBuffer =
/* 325 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 326 */           if (agg_unsafeRowAggBuffer == null) {
/* 327 */             // failed to allocate the first page
/* 328 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 329 */           }
/* 330 */         }
/* 331 */       }
/* 332 */
/* 333 */       if (agg_fastAggBuffer != null) {
/* 334 */         // update fast row
/* 335 */
/* 336 */         // common sub-expressions
/* 337 */
/* 338 */         // evaluate aggregate function
/* 339 */         boolean agg_isNull23 = true;
/* 340 */         double agg_value24 = -1.0;
/* 341 */
/* 342 */         boolean agg_isNull25 = agg_fastAggBuffer.isNullAt(0);
/* 343 */         double agg_value26 = agg_isNull25 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 344 */         boolean agg_isNull24 = agg_isNull25;
/* 345 */         double agg_value25 = agg_value26;
/* 346 */         if (agg_isNull24) {
/* 347 */           boolean agg_isNull26 = false;
/* 348 */           double agg_value27 = -1.0;
/* 349 */           if (!false) {
/* 350 */             agg_value27 = (double) 0;
/* 351 */           }
/* 352 */           if (!agg_isNull26) {
/* 353 */             agg_isNull24 = false;
/* 354 */             agg_value25 = agg_value27;
/* 355 */           }
/* 356 */         }
/* 357 */
/* 358 */         if (!inputadapter_isNull) {
/* 359 */           agg_isNull23 = false; // resultCode could change nullability.
/* 360 */           agg_value24 = agg_value25 + inputadapter_value;
/* 361 */
/* 362 */         }
/* 363 */         boolean agg_isNull22 = agg_isNull23;
/* 364 */         double agg_value23 = agg_value24;
/* 365 */         if (agg_isNull22) {
/* 366 */           boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(0);
/* 367 */           double agg_value30 = agg_isNull29 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 368 */           if (!agg_isNull29) {
/* 369 */             agg_isNull22 = false;
/* 370 */             agg_value23 = agg_value30;
/* 371 */           }
/* 372 */         }
/* 373 */         // update fast row
/* 374 */         if (!agg_isNull22) {
/* 375 */           agg_fastAggBuffer.setDouble(0, agg_value23);
/* 376 */         } else {
/* 377 */           agg_fastAggBuffer.setNullAt(0);
/* 378 */         }
/* 379 */
/* 380 */       } else {
/* 381 */         // update unsafe row
/* 382 */
/* 383 */         // common sub-expressions
/* 384 */
/* 385 */         // evaluate aggregate function
/* 386 */         boolean agg_isNull15 = true;
/* 387 */         double agg_value16 = -1.0;
/* 388 */
/* 389 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 390 */         double agg_value18 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 391 */         boolean agg_isNull16 = agg_isNull17;
/* 392 */         double agg_value17 = agg_value18;
/* 393 */         if (agg_isNull16) {
/* 394 */           boolean agg_isNull18 = false;
/* 395 */           double agg_value19 = -1.0;
/* 396 */           if (!false) {
/* 397 */             agg_value19 = (double) 0;
/* 398 */           }
/* 399 */           if (!agg_isNull18) {
/* 400 */             agg_isNull16 = false;
/* 401 */             agg_value17 = agg_value19;
/* 402 */           }
/* 403 */         }
/* 404 */
/* 405 */         if (!inputadapter_isNull) {
/* 406 */           agg_isNull15 = false; // resultCode could change nullability.
/* 407 */           agg_value16 = agg_value17 + inputadapter_value;
/* 408 */
/* 409 */         }
/* 410 */         boolean agg_isNull14 = agg_isNull15;
/* 411 */         double agg_value15 = agg_value16;
/* 412 */         if (agg_isNull14) {
/* 413 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 414 */           double agg_value22 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 415 */           if (!agg_isNull21) {
/* 416 */             agg_isNull14 = false;
/* 417 */             agg_value15 = agg_value22;
/* 418 */           }
/* 419 */         }
/* 420 */         // update unsafe row buffer
/* 421 */         if (!agg_isNull14) {
/* 422 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 423 */         } else {
/* 424 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 425 */         }
/* 426 */
/* 427 */       }
/* 428 */       if (shouldStop()) return;
/* 429 */     }
/* 430 */
/* 431 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 432 */
/* 433 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 434 */   }
/* 435 */
/* 436 */   private void wholestagecodegen_init_2() {
/* 437 */     agg_result4 = new UnsafeRow(4);
/* 438 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 32);
/* 439 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 440 */
/* 441 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 442 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 443 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 444 */
/* 445 */   }
/* 446 */
/* 447 */   private void wholestagecodegen_init_1() {
/* 448 */     project_result = new UnsafeRow(4);
/* 449 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 450 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 451 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 452 */
/* 453 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 454 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 455 */
/* 456 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 457 */     bhj_result1 = new UnsafeRow(7);
/* 458 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 459 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 460 */     project_result1 = new UnsafeRow(5);
/* 461 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 462 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 463 */
/* 464 */   }
/* 465 */
/* 466 */   protected void processNext() throws java.io.IOException {
/* 467 */     if (!agg_initAgg) {
/* 468 */       agg_initAgg = true;
/* 469 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 470 */       agg_doAggregateWithKeys();
/* 471 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 472 */     }
/* 473 */
/* 474 */     // output the result
/* 475 */
/* 476 */     while (agg_fastHashMapIter.next()) {
/* 477 */       wholestagecodegen_numOutputRows.add(1);
/* 478 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 479 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 480 */
/* 481 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 482 */
/* 483 */       append(agg_resultRow);
/* 484 */
/* 485 */       if (shouldStop()) return;
/* 486 */     }
/* 487 */     agg_fastHashMap.close();
/* 488 */
/* 489 */     while (agg_mapIter.next()) {
/* 490 */       wholestagecodegen_numOutputRows.add(1);
/* 491 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 492 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 493 */
/* 494 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 495 */
/* 496 */       append(agg_resultRow);
/* 497 */
/* 498 */       if (shouldStop()) return;
/* 499 */     }
/* 500 */
/* 501 */     agg_mapIter.close();
/* 502 */     if (agg_sorter == null) {
/* 503 */       agg_hashMap.free();
/* 504 */     }
/* 505 */   }
/* 506 */ }
