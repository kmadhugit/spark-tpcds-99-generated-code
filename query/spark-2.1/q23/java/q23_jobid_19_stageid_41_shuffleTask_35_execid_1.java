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
/* 020 */   private UnsafeRow project_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 023 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 024 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 026 */   private UnsafeRow bhj_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 029 */   private UnsafeRow project_result1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 032 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 033 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 035 */   private UnsafeRow bhj_result1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 038 */   private UnsafeRow project_result2;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 041 */   private UnsafeRow agg_result2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 044 */   private int agg_value6;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 048 */
/* 049 */   public GeneratedIterator(Object[] references) {
/* 050 */     this.references = references;
/* 051 */   }
/* 052 */
/* 053 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 054 */     partitionIndex = index;
/* 055 */     this.inputs = inputs;
/* 056 */     wholestagecodegen_init_0();
/* 057 */     wholestagecodegen_init_1();
/* 058 */     wholestagecodegen_init_2();
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void wholestagecodegen_init_0() {
/* 063 */     agg_initAgg = false;
/* 064 */
/* 065 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 066 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 067 */
/* 068 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 069 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 070 */     inputadapter_input = inputs[0];
/* 071 */     project_result = new UnsafeRow(4);
/* 072 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 073 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 074 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 075 */
/* 076 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 077 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 078 */
/* 079 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   public class agg_FastHashMap {
/* 084 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 085 */     private int[] buckets;
/* 086 */     private int capacity = 1 << 16;
/* 087 */     private double loadFactor = 0.5;
/* 088 */     private int numBuckets = (int) (capacity / loadFactor);
/* 089 */     private int maxSteps = 2;
/* 090 */     private int numRows = 0;
/* 091 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("c_last_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 092 */     .add("c_first_name", org.apache.spark.sql.types.DataTypes.StringType);
/* 093 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 094 */     private Object emptyVBase;
/* 095 */     private long emptyVOff;
/* 096 */     private int emptyVLen;
/* 097 */     private boolean isBatchFull = false;
/* 098 */
/* 099 */     public agg_FastHashMap(
/* 100 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 101 */       InternalRow emptyAggregationBuffer) {
/* 102 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 103 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 104 */
/* 105 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 106 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 107 */
/* 108 */       emptyVBase = emptyBuffer;
/* 109 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 110 */       emptyVLen = emptyBuffer.length;
/* 111 */
/* 112 */       buckets = new int[numBuckets];
/* 113 */       java.util.Arrays.fill(buckets, -1);
/* 114 */     }
/* 115 */
/* 116 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1) {
/* 117 */       long h = hash(agg_key, agg_key1);
/* 118 */       int step = 0;
/* 119 */       int idx = (int) h & (numBuckets - 1);
/* 120 */       while (step < maxSteps) {
/* 121 */         // Return bucket index if it's either an empty slot or already contains the key
/* 122 */         if (buckets[idx] == -1) {
/* 123 */           if (numRows < capacity && !isBatchFull) {
/* 124 */             // creating the unsafe for new entry
/* 125 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 126 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 127 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 128 */               64);
/* 129 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 130 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 131 */               agg_holder,
/* 132 */               2);
/* 133 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 134 */             agg_rowWriter.zeroOutNullBytes();
/* 135 */             agg_rowWriter.write(0, agg_key);
/* 136 */             agg_rowWriter.write(1, agg_key1);
/* 137 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 138 */             Object kbase = agg_result.getBaseObject();
/* 139 */             long koff = agg_result.getBaseOffset();
/* 140 */             int klen = agg_result.getSizeInBytes();
/* 141 */
/* 142 */             UnsafeRow vRow
/* 143 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 144 */             if (vRow == null) {
/* 145 */               isBatchFull = true;
/* 146 */             } else {
/* 147 */               buckets[idx] = numRows++;
/* 148 */             }
/* 149 */             return vRow;
/* 150 */           } else {
/* 151 */             // No more space
/* 152 */             return null;
/* 153 */           }
/* 154 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 155 */           return batch.getValueRow(buckets[idx]);
/* 156 */         }
/* 157 */         idx = (idx + 1) & (numBuckets - 1);
/* 158 */         step++;
/* 159 */       }
/* 160 */       // Didn't find it
/* 161 */       return null;
/* 162 */     }
/* 163 */
/* 164 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1) {
/* 165 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 166 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1));
/* 167 */     }
/* 168 */
/* 169 */     private long hash(UTF8String agg_key, UTF8String agg_key1) {
/* 170 */       long agg_hash = 0;
/* 171 */
/* 172 */       int agg_result = 0;
/* 173 */       byte[] agg_bytes = agg_key.getBytes();
/* 174 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 175 */         int agg_hash1 = agg_bytes[i];
/* 176 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 177 */       }
/* 178 */
/* 179 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 180 */
/* 181 */       int agg_result1 = 0;
/* 182 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 183 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 184 */         int agg_hash2 = agg_bytes1[i];
/* 185 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 186 */       }
/* 187 */
/* 188 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
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
/* 206 */     while (inputadapter_input.hasNext()) {
/* 207 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 208 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 209 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 210 */
/* 211 */       // generate join key for stream side
/* 212 */
/* 213 */       boolean bhj_isNull = inputadapter_isNull3;
/* 214 */       long bhj_value = -1L;
/* 215 */       if (!inputadapter_isNull3) {
/* 216 */         bhj_value = (long) inputadapter_value3;
/* 217 */       }
/* 218 */       // find matches from HashedRelation
/* 219 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 220 */       if (bhj_matched == null) continue;
/* 221 */
/* 222 */       bhj_numOutputRows.add(1);
/* 223 */
/* 224 */       boolean inputadapter_isNull33 = inputadapter_row.isNullAt(33);
/* 225 */       int inputadapter_value33 = inputadapter_isNull33 ? -1 : (inputadapter_row.getInt(33));
/* 226 */
/* 227 */       // generate join key for stream side
/* 228 */
/* 229 */       boolean bhj_isNull12 = inputadapter_isNull33;
/* 230 */       long bhj_value12 = -1L;
/* 231 */       if (!inputadapter_isNull33) {
/* 232 */         bhj_value12 = (long) inputadapter_value33;
/* 233 */       }
/* 234 */       // find matches from HashedRelation
/* 235 */       UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 236 */       if (bhj_matched1 == null) continue;
/* 237 */
/* 238 */       bhj_numOutputRows1.add(1);
/* 239 */
/* 240 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 241 */       int inputadapter_value17 = inputadapter_isNull17 ? -1 : (inputadapter_row.getInt(17));
/* 242 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 243 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 244 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 245 */       UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 246 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 247 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 248 */
/* 249 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 250 */
/* 251 */       UnsafeRow agg_fastAggBuffer = null;
/* 252 */
/* 253 */       if (true) {
/* 254 */         if (!bhj_isNull4 && !bhj_isNull3) {
/* 255 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 256 */             bhj_value4, bhj_value3);
/* 257 */         }
/* 258 */       }
/* 259 */
/* 260 */       if (agg_fastAggBuffer == null) {
/* 261 */         // generate grouping key
/* 262 */         agg_holder.reset();
/* 263 */
/* 264 */         agg_rowWriter.zeroOutNullBytes();
/* 265 */
/* 266 */         if (bhj_isNull4) {
/* 267 */           agg_rowWriter.setNullAt(0);
/* 268 */         } else {
/* 269 */           agg_rowWriter.write(0, bhj_value4);
/* 270 */         }
/* 271 */
/* 272 */         if (bhj_isNull3) {
/* 273 */           agg_rowWriter.setNullAt(1);
/* 274 */         } else {
/* 275 */           agg_rowWriter.write(1, bhj_value3);
/* 276 */         }
/* 277 */         agg_result2.setTotalSize(agg_holder.totalSize());
/* 278 */         agg_value6 = 42;
/* 279 */
/* 280 */         if (!bhj_isNull4) {
/* 281 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value6);
/* 282 */         }
/* 283 */
/* 284 */         if (!bhj_isNull3) {
/* 285 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value6);
/* 286 */         }
/* 287 */         if (true) {
/* 288 */           // try to get the buffer from hash map
/* 289 */           agg_unsafeRowAggBuffer =
/* 290 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 291 */         }
/* 292 */         if (agg_unsafeRowAggBuffer == null) {
/* 293 */           if (agg_sorter == null) {
/* 294 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 295 */           } else {
/* 296 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 297 */           }
/* 298 */
/* 299 */           // the hash map had be spilled, it should have enough memory now,
/* 300 */           // try  to allocate buffer again.
/* 301 */           agg_unsafeRowAggBuffer =
/* 302 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 303 */           if (agg_unsafeRowAggBuffer == null) {
/* 304 */             // failed to allocate the first page
/* 305 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 306 */           }
/* 307 */         }
/* 308 */       }
/* 309 */
/* 310 */       if (agg_fastAggBuffer != null) {
/* 311 */         // update fast row
/* 312 */
/* 313 */         // common sub-expressions
/* 314 */
/* 315 */         // evaluate aggregate function
/* 316 */         boolean agg_isNull21 = true;
/* 317 */         double agg_value22 = -1.0;
/* 318 */
/* 319 */         boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 320 */         double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 321 */         boolean agg_isNull22 = agg_isNull23;
/* 322 */         double agg_value23 = agg_value24;
/* 323 */         if (agg_isNull22) {
/* 324 */           boolean agg_isNull24 = false;
/* 325 */           double agg_value25 = -1.0;
/* 326 */           if (!false) {
/* 327 */             agg_value25 = (double) 0;
/* 328 */           }
/* 329 */           if (!agg_isNull24) {
/* 330 */             agg_isNull22 = false;
/* 331 */             agg_value23 = agg_value25;
/* 332 */           }
/* 333 */         }
/* 334 */
/* 335 */         boolean agg_isNull27 = true;
/* 336 */         double agg_value28 = -1.0;
/* 337 */
/* 338 */         boolean agg_isNull28 = inputadapter_isNull17;
/* 339 */         double agg_value29 = -1.0;
/* 340 */         if (!inputadapter_isNull17) {
/* 341 */           agg_value29 = (double) inputadapter_value17;
/* 342 */         }
/* 343 */         if (!agg_isNull28) {
/* 344 */           if (!inputadapter_isNull19) {
/* 345 */             agg_isNull27 = false; // resultCode could change nullability.
/* 346 */             agg_value28 = agg_value29 * inputadapter_value19;
/* 347 */
/* 348 */           }
/* 349 */
/* 350 */         }
/* 351 */         boolean agg_isNull26 = agg_isNull27;
/* 352 */         double agg_value27 = -1.0;
/* 353 */         if (!agg_isNull27) {
/* 354 */           agg_value27 = agg_value28;
/* 355 */         }
/* 356 */         if (!agg_isNull26) {
/* 357 */           agg_isNull21 = false; // resultCode could change nullability.
/* 358 */           agg_value22 = agg_value23 + agg_value27;
/* 359 */
/* 360 */         }
/* 361 */         boolean agg_isNull20 = agg_isNull21;
/* 362 */         double agg_value21 = agg_value22;
/* 363 */         if (agg_isNull20) {
/* 364 */           boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(0);
/* 365 */           double agg_value32 = agg_isNull31 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 366 */           if (!agg_isNull31) {
/* 367 */             agg_isNull20 = false;
/* 368 */             agg_value21 = agg_value32;
/* 369 */           }
/* 370 */         }
/* 371 */         // update fast row
/* 372 */         if (!agg_isNull20) {
/* 373 */           agg_fastAggBuffer.setDouble(0, agg_value21);
/* 374 */         } else {
/* 375 */           agg_fastAggBuffer.setNullAt(0);
/* 376 */         }
/* 377 */
/* 378 */       } else {
/* 379 */         // update unsafe row
/* 380 */
/* 381 */         // common sub-expressions
/* 382 */
/* 383 */         // evaluate aggregate function
/* 384 */         boolean agg_isNull9 = true;
/* 385 */         double agg_value10 = -1.0;
/* 386 */
/* 387 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 388 */         double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 389 */         boolean agg_isNull10 = agg_isNull11;
/* 390 */         double agg_value11 = agg_value12;
/* 391 */         if (agg_isNull10) {
/* 392 */           boolean agg_isNull12 = false;
/* 393 */           double agg_value13 = -1.0;
/* 394 */           if (!false) {
/* 395 */             agg_value13 = (double) 0;
/* 396 */           }
/* 397 */           if (!agg_isNull12) {
/* 398 */             agg_isNull10 = false;
/* 399 */             agg_value11 = agg_value13;
/* 400 */           }
/* 401 */         }
/* 402 */
/* 403 */         boolean agg_isNull15 = true;
/* 404 */         double agg_value16 = -1.0;
/* 405 */
/* 406 */         boolean agg_isNull16 = inputadapter_isNull17;
/* 407 */         double agg_value17 = -1.0;
/* 408 */         if (!inputadapter_isNull17) {
/* 409 */           agg_value17 = (double) inputadapter_value17;
/* 410 */         }
/* 411 */         if (!agg_isNull16) {
/* 412 */           if (!inputadapter_isNull19) {
/* 413 */             agg_isNull15 = false; // resultCode could change nullability.
/* 414 */             agg_value16 = agg_value17 * inputadapter_value19;
/* 415 */
/* 416 */           }
/* 417 */
/* 418 */         }
/* 419 */         boolean agg_isNull14 = agg_isNull15;
/* 420 */         double agg_value15 = -1.0;
/* 421 */         if (!agg_isNull15) {
/* 422 */           agg_value15 = agg_value16;
/* 423 */         }
/* 424 */         if (!agg_isNull14) {
/* 425 */           agg_isNull9 = false; // resultCode could change nullability.
/* 426 */           agg_value10 = agg_value11 + agg_value15;
/* 427 */
/* 428 */         }
/* 429 */         boolean agg_isNull8 = agg_isNull9;
/* 430 */         double agg_value9 = agg_value10;
/* 431 */         if (agg_isNull8) {
/* 432 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 433 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 434 */           if (!agg_isNull19) {
/* 435 */             agg_isNull8 = false;
/* 436 */             agg_value9 = agg_value20;
/* 437 */           }
/* 438 */         }
/* 439 */         // update unsafe row buffer
/* 440 */         if (!agg_isNull8) {
/* 441 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 442 */         } else {
/* 443 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 444 */         }
/* 445 */
/* 446 */       }
/* 447 */       if (shouldStop()) return;
/* 448 */     }
/* 449 */
/* 450 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 451 */
/* 452 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 453 */   }
/* 454 */
/* 455 */   private void wholestagecodegen_init_2() {
/* 456 */     project_result2 = new UnsafeRow(4);
/* 457 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 458 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 459 */     agg_result2 = new UnsafeRow(2);
/* 460 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 64);
/* 461 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 462 */
/* 463 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 464 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 465 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 466 */
/* 467 */   }
/* 468 */
/* 469 */   private void wholestagecodegen_init_1() {
/* 470 */     bhj_result = new UnsafeRow(7);
/* 471 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 472 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 473 */     project_result1 = new UnsafeRow(5);
/* 474 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 475 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 476 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 477 */
/* 478 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 479 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 480 */
/* 481 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 482 */     bhj_result1 = new UnsafeRow(6);
/* 483 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 484 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 485 */
/* 486 */   }
/* 487 */
/* 488 */   protected void processNext() throws java.io.IOException {
/* 489 */     if (!agg_initAgg) {
/* 490 */       agg_initAgg = true;
/* 491 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 492 */       agg_doAggregateWithKeys();
/* 493 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 494 */     }
/* 495 */
/* 496 */     // output the result
/* 497 */
/* 498 */     while (agg_fastHashMapIter.next()) {
/* 499 */       wholestagecodegen_numOutputRows.add(1);
/* 500 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 501 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 502 */
/* 503 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 504 */
/* 505 */       append(agg_resultRow);
/* 506 */
/* 507 */       if (shouldStop()) return;
/* 508 */     }
/* 509 */     agg_fastHashMap.close();
/* 510 */
/* 511 */     while (agg_mapIter.next()) {
/* 512 */       wholestagecodegen_numOutputRows.add(1);
/* 513 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 514 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 515 */
/* 516 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 517 */
/* 518 */       append(agg_resultRow);
/* 519 */
/* 520 */       if (shouldStop()) return;
/* 521 */     }
/* 522 */
/* 523 */     agg_mapIter.close();
/* 524 */     if (agg_sorter == null) {
/* 525 */       agg_hashMap.free();
/* 526 */     }
/* 527 */   }
/* 528 */ }
