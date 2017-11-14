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
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow project_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 025 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 026 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 028 */   private UnsafeRow bhj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 031 */   private UnsafeRow project_result1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 035 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 037 */   private UnsafeRow bhj_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 040 */   private UnsafeRow project_result2;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 043 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 044 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 046 */   private UnsafeRow bhj_result2;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 049 */   private UnsafeRow project_result3;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 052 */   private UnsafeRow agg_result2;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 055 */   private int agg_value8;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 059 */
/* 060 */   public GeneratedIterator(Object[] references) {
/* 061 */     this.references = references;
/* 062 */   }
/* 063 */
/* 064 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 065 */     partitionIndex = index;
/* 066 */     this.inputs = inputs;
/* 067 */     wholestagecodegen_init_0();
/* 068 */     wholestagecodegen_init_1();
/* 069 */     wholestagecodegen_init_2();
/* 070 */     wholestagecodegen_init_3();
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */   private void wholestagecodegen_init_0() {
/* 075 */     agg_initAgg = false;
/* 076 */
/* 077 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 078 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 079 */
/* 080 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 081 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 082 */     inputadapter_input = inputs[0];
/* 083 */     project_result = new UnsafeRow(5);
/* 084 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 085 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 086 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 087 */
/* 088 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 089 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 090 */
/* 091 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   private void wholestagecodegen_init_3() {
/* 096 */     agg_result2 = new UnsafeRow(2);
/* 097 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 64);
/* 098 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 099 */
/* 100 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 101 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 102 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */   public class agg_FastHashMap {
/* 107 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 108 */     private int[] buckets;
/* 109 */     private int capacity = 1 << 16;
/* 110 */     private double loadFactor = 0.5;
/* 111 */     private int numBuckets = (int) (capacity / loadFactor);
/* 112 */     private int maxSteps = 2;
/* 113 */     private int numRows = 0;
/* 114 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 115 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType);
/* 116 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 117 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 140 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1) {
/* 141 */       long h = hash(agg_key, agg_key1);
/* 142 */       int step = 0;
/* 143 */       int idx = (int) h & (numBuckets - 1);
/* 144 */       while (step < maxSteps) {
/* 145 */         // Return bucket index if it's either an empty slot or already contains the key
/* 146 */         if (buckets[idx] == -1) {
/* 147 */           if (numRows < capacity && !isBatchFull) {
/* 148 */             // creating the unsafe for new entry
/* 149 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 150 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 151 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 152 */               64);
/* 153 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 154 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 155 */               agg_holder,
/* 156 */               2);
/* 157 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 158 */             agg_rowWriter.zeroOutNullBytes();
/* 159 */             agg_rowWriter.write(0, agg_key);
/* 160 */             agg_rowWriter.write(1, agg_key1);
/* 161 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 162 */             Object kbase = agg_result.getBaseObject();
/* 163 */             long koff = agg_result.getBaseOffset();
/* 164 */             int klen = agg_result.getSizeInBytes();
/* 165 */
/* 166 */             UnsafeRow vRow
/* 167 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 168 */             if (vRow == null) {
/* 169 */               isBatchFull = true;
/* 170 */             } else {
/* 171 */               buckets[idx] = numRows++;
/* 172 */             }
/* 173 */             return vRow;
/* 174 */           } else {
/* 175 */             // No more space
/* 176 */             return null;
/* 177 */           }
/* 178 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 179 */           return batch.getValueRow(buckets[idx]);
/* 180 */         }
/* 181 */         idx = (idx + 1) & (numBuckets - 1);
/* 182 */         step++;
/* 183 */       }
/* 184 */       // Didn't find it
/* 185 */       return null;
/* 186 */     }
/* 187 */
/* 188 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1) {
/* 189 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 190 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1));
/* 191 */     }
/* 192 */
/* 193 */     private long hash(UTF8String agg_key, UTF8String agg_key1) {
/* 194 */       long agg_hash = 0;
/* 195 */
/* 196 */       int agg_result = 0;
/* 197 */       byte[] agg_bytes = agg_key.getBytes();
/* 198 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 199 */         int agg_hash1 = agg_bytes[i];
/* 200 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 201 */       }
/* 202 */
/* 203 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 204 */
/* 205 */       int agg_result1 = 0;
/* 206 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 207 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 208 */         int agg_hash2 = agg_bytes1[i];
/* 209 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 210 */       }
/* 211 */
/* 212 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 213 */
/* 214 */       return agg_hash;
/* 215 */     }
/* 216 */
/* 217 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 218 */       return batch.rowIterator();
/* 219 */     }
/* 220 */
/* 221 */     public void close() {
/* 222 */       batch.close();
/* 223 */     }
/* 224 */
/* 225 */   }
/* 226 */
/* 227 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 228 */     agg_hashMap = agg_plan.createHashMap();
/* 229 */
/* 230 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 231 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 232 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 233 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 234 */
/* 235 */       // generate join key for stream side
/* 236 */
/* 237 */       boolean bhj_isNull = inputadapter_isNull;
/* 238 */       long bhj_value = -1L;
/* 239 */       if (!inputadapter_isNull) {
/* 240 */         bhj_value = (long) inputadapter_value;
/* 241 */       }
/* 242 */       // find matches from HashedRelation
/* 243 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 244 */       if (bhj_matched == null) continue;
/* 245 */
/* 246 */       bhj_numOutputRows.add(1);
/* 247 */
/* 248 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 249 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 250 */
/* 251 */       // generate join key for stream side
/* 252 */
/* 253 */       boolean bhj_isNull11 = inputadapter_isNull1;
/* 254 */       long bhj_value11 = -1L;
/* 255 */       if (!inputadapter_isNull1) {
/* 256 */         bhj_value11 = (long) inputadapter_value1;
/* 257 */       }
/* 258 */       // find matches from HashedRelation
/* 259 */       UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 260 */       if (bhj_matched1 == null) continue;
/* 261 */
/* 262 */       bhj_numOutputRows1.add(1);
/* 263 */
/* 264 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 265 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 266 */
/* 267 */       // generate join key for stream side
/* 268 */
/* 269 */       boolean bhj_isNull22 = inputadapter_isNull4;
/* 270 */       long bhj_value22 = -1L;
/* 271 */       if (!inputadapter_isNull4) {
/* 272 */         bhj_value22 = (long) inputadapter_value4;
/* 273 */       }
/* 274 */       // find matches from HashedRelation
/* 275 */       UnsafeRow bhj_matched2 = bhj_isNull22 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value22);
/* 276 */       if (bhj_matched2 == null) continue;
/* 277 */
/* 278 */       bhj_numOutputRows2.add(1);
/* 279 */
/* 280 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 281 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 282 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 283 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 284 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 285 */       UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 286 */       boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 287 */       UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(1));
/* 288 */       boolean bhj_isNull25 = bhj_matched2.isNullAt(1);
/* 289 */       UTF8String bhj_value25 = bhj_isNull25 ? null : (bhj_matched2.getUTF8String(1));
/* 290 */
/* 291 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 292 */
/* 293 */       UnsafeRow agg_fastAggBuffer = null;
/* 294 */
/* 295 */       if (true) {
/* 296 */         if (!bhj_isNull3 && !bhj_isNull14) {
/* 297 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 298 */             bhj_value3, bhj_value14);
/* 299 */         }
/* 300 */       }
/* 301 */
/* 302 */       if (agg_fastAggBuffer == null) {
/* 303 */         // generate grouping key
/* 304 */         agg_holder.reset();
/* 305 */
/* 306 */         agg_rowWriter.zeroOutNullBytes();
/* 307 */
/* 308 */         if (bhj_isNull3) {
/* 309 */           agg_rowWriter.setNullAt(0);
/* 310 */         } else {
/* 311 */           agg_rowWriter.write(0, bhj_value3);
/* 312 */         }
/* 313 */
/* 314 */         if (bhj_isNull14) {
/* 315 */           agg_rowWriter.setNullAt(1);
/* 316 */         } else {
/* 317 */           agg_rowWriter.write(1, bhj_value14);
/* 318 */         }
/* 319 */         agg_result2.setTotalSize(agg_holder.totalSize());
/* 320 */         agg_value8 = 42;
/* 321 */
/* 322 */         if (!bhj_isNull3) {
/* 323 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value8);
/* 324 */         }
/* 325 */
/* 326 */         if (!bhj_isNull14) {
/* 327 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value14.getBaseObject(), bhj_value14.getBaseOffset(), bhj_value14.numBytes(), agg_value8);
/* 328 */         }
/* 329 */         if (true) {
/* 330 */           // try to get the buffer from hash map
/* 331 */           agg_unsafeRowAggBuffer =
/* 332 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 333 */         }
/* 334 */         if (agg_unsafeRowAggBuffer == null) {
/* 335 */           if (agg_sorter == null) {
/* 336 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 337 */           } else {
/* 338 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 339 */           }
/* 340 */
/* 341 */           // the hash map had be spilled, it should have enough memory now,
/* 342 */           // try  to allocate buffer again.
/* 343 */           agg_unsafeRowAggBuffer =
/* 344 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 345 */           if (agg_unsafeRowAggBuffer == null) {
/* 346 */             // failed to allocate the first page
/* 347 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 348 */           }
/* 349 */         }
/* 350 */       }
/* 351 */
/* 352 */       if (agg_fastAggBuffer != null) {
/* 353 */         // update fast row
/* 354 */
/* 355 */         // common sub-expressions
/* 356 */         boolean agg_isNull43 = bhj_isNull25;
/* 357 */         int agg_value45 = -1;
/* 358 */         if (!bhj_isNull25) {
/* 359 */           scala.Option<Integer> agg_intOpt1 =
/* 360 */           org.apache.spark.sql.catalyst.util.DateTimeUtils.stringToDate(bhj_value25);
/* 361 */           if (agg_intOpt1.isDefined()) {
/* 362 */             agg_value45 = ((Integer) agg_intOpt1.get()).intValue();
/* 363 */           } else {
/* 364 */             agg_isNull43 = true;
/* 365 */           }
/* 366 */
/* 367 */         }
/* 368 */         // evaluate aggregate function
/* 369 */         boolean agg_isNull46 = true;
/* 370 */         double agg_value48 = -1.0;
/* 371 */
/* 372 */         boolean agg_isNull48 = agg_fastAggBuffer.isNullAt(0);
/* 373 */         double agg_value50 = agg_isNull48 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 374 */         boolean agg_isNull47 = agg_isNull48;
/* 375 */         double agg_value49 = agg_value50;
/* 376 */         if (agg_isNull47) {
/* 377 */           boolean agg_isNull49 = false;
/* 378 */           double agg_value51 = -1.0;
/* 379 */           if (!false) {
/* 380 */             agg_value51 = (double) 0;
/* 381 */           }
/* 382 */           if (!agg_isNull49) {
/* 383 */             agg_isNull47 = false;
/* 384 */             agg_value49 = agg_value51;
/* 385 */           }
/* 386 */         }
/* 387 */
/* 388 */         boolean agg_isNull51 = true;
/* 389 */         double agg_value53 = -1.0;
/* 390 */
/* 391 */         boolean agg_isNull52 = true;
/* 392 */         boolean agg_value54 = false;
/* 393 */
/* 394 */         if (!agg_isNull43) {
/* 395 */           agg_isNull52 = false; // resultCode could change nullability.
/* 396 */           agg_value54 = agg_value45 < 11027;
/* 397 */
/* 398 */         }
/* 399 */         if (!agg_isNull52 && agg_value54) {
/* 400 */           boolean agg_isNull54 = true;
/* 401 */           double agg_value56 = -1.0;
/* 402 */
/* 403 */           if (!inputadapter_isNull3) {
/* 404 */             boolean agg_isNull56 = inputadapter_isNull7;
/* 405 */             double agg_value58 = inputadapter_value7;
/* 406 */             if (agg_isNull56) {
/* 407 */               if (!false) {
/* 408 */                 agg_isNull56 = false;
/* 409 */                 agg_value58 = 0.0D;
/* 410 */               }
/* 411 */             }
/* 412 */
/* 413 */             agg_isNull54 = false; // resultCode could change nullability.
/* 414 */             agg_value56 = inputadapter_value3 - agg_value58;
/* 415 */
/* 416 */           }
/* 417 */           agg_isNull51 = agg_isNull54;
/* 418 */           agg_value53 = agg_value56;
/* 419 */         }
/* 420 */
/* 421 */         else {
/* 422 */           agg_isNull51 = false;
/* 423 */           agg_value53 = 0.0D;
/* 424 */         }
/* 425 */         if (!agg_isNull51) {
/* 426 */           agg_isNull46 = false; // resultCode could change nullability.
/* 427 */           agg_value48 = agg_value49 + agg_value53;
/* 428 */
/* 429 */         }
/* 430 */         boolean agg_isNull45 = agg_isNull46;
/* 431 */         double agg_value47 = agg_value48;
/* 432 */         if (agg_isNull45) {
/* 433 */           boolean agg_isNull60 = agg_fastAggBuffer.isNullAt(0);
/* 434 */           double agg_value62 = agg_isNull60 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 435 */           if (!agg_isNull60) {
/* 436 */             agg_isNull45 = false;
/* 437 */             agg_value47 = agg_value62;
/* 438 */           }
/* 439 */         }
/* 440 */         boolean agg_isNull62 = true;
/* 441 */         double agg_value64 = -1.0;
/* 442 */
/* 443 */         boolean agg_isNull64 = agg_fastAggBuffer.isNullAt(1);
/* 444 */         double agg_value66 = agg_isNull64 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 445 */         boolean agg_isNull63 = agg_isNull64;
/* 446 */         double agg_value65 = agg_value66;
/* 447 */         if (agg_isNull63) {
/* 448 */           boolean agg_isNull65 = false;
/* 449 */           double agg_value67 = -1.0;
/* 450 */           if (!false) {
/* 451 */             agg_value67 = (double) 0;
/* 452 */           }
/* 453 */           if (!agg_isNull65) {
/* 454 */             agg_isNull63 = false;
/* 455 */             agg_value65 = agg_value67;
/* 456 */           }
/* 457 */         }
/* 458 */
/* 459 */         boolean agg_isNull67 = true;
/* 460 */         double agg_value69 = -1.0;
/* 461 */
/* 462 */         boolean agg_isNull68 = true;
/* 463 */         boolean agg_value70 = false;
/* 464 */
/* 465 */         if (!agg_isNull43) {
/* 466 */           agg_isNull68 = false; // resultCode could change nullability.
/* 467 */           agg_value70 = agg_value45 >= 11027;
/* 468 */
/* 469 */         }
/* 470 */         if (!agg_isNull68 && agg_value70) {
/* 471 */           boolean agg_isNull70 = true;
/* 472 */           double agg_value72 = -1.0;
/* 473 */
/* 474 */           if (!inputadapter_isNull3) {
/* 475 */             boolean agg_isNull72 = inputadapter_isNull7;
/* 476 */             double agg_value74 = inputadapter_value7;
/* 477 */             if (agg_isNull72) {
/* 478 */               if (!false) {
/* 479 */                 agg_isNull72 = false;
/* 480 */                 agg_value74 = 0.0D;
/* 481 */               }
/* 482 */             }
/* 483 */
/* 484 */             agg_isNull70 = false; // resultCode could change nullability.
/* 485 */             agg_value72 = inputadapter_value3 - agg_value74;
/* 486 */
/* 487 */           }
/* 488 */           agg_isNull67 = agg_isNull70;
/* 489 */           agg_value69 = agg_value72;
/* 490 */         }
/* 491 */
/* 492 */         else {
/* 493 */           agg_isNull67 = false;
/* 494 */           agg_value69 = 0.0D;
/* 495 */         }
/* 496 */         if (!agg_isNull67) {
/* 497 */           agg_isNull62 = false; // resultCode could change nullability.
/* 498 */           agg_value64 = agg_value65 + agg_value69;
/* 499 */
/* 500 */         }
/* 501 */         boolean agg_isNull61 = agg_isNull62;
/* 502 */         double agg_value63 = agg_value64;
/* 503 */         if (agg_isNull61) {
/* 504 */           boolean agg_isNull76 = agg_fastAggBuffer.isNullAt(1);
/* 505 */           double agg_value78 = agg_isNull76 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 506 */           if (!agg_isNull76) {
/* 507 */             agg_isNull61 = false;
/* 508 */             agg_value63 = agg_value78;
/* 509 */           }
/* 510 */         }
/* 511 */         // update fast row
/* 512 */         if (!agg_isNull45) {
/* 513 */           agg_fastAggBuffer.setDouble(0, agg_value47);
/* 514 */         } else {
/* 515 */           agg_fastAggBuffer.setNullAt(0);
/* 516 */         }
/* 517 */
/* 518 */         if (!agg_isNull61) {
/* 519 */           agg_fastAggBuffer.setDouble(1, agg_value63);
/* 520 */         } else {
/* 521 */           agg_fastAggBuffer.setNullAt(1);
/* 522 */         }
/* 523 */
/* 524 */       } else {
/* 525 */         // update unsafe row
/* 526 */
/* 527 */         // common sub-expressions
/* 528 */         boolean agg_isNull9 = bhj_isNull25;
/* 529 */         int agg_value11 = -1;
/* 530 */         if (!bhj_isNull25) {
/* 531 */           scala.Option<Integer> agg_intOpt =
/* 532 */           org.apache.spark.sql.catalyst.util.DateTimeUtils.stringToDate(bhj_value25);
/* 533 */           if (agg_intOpt.isDefined()) {
/* 534 */             agg_value11 = ((Integer) agg_intOpt.get()).intValue();
/* 535 */           } else {
/* 536 */             agg_isNull9 = true;
/* 537 */           }
/* 538 */
/* 539 */         }
/* 540 */         // evaluate aggregate function
/* 541 */         boolean agg_isNull12 = true;
/* 542 */         double agg_value14 = -1.0;
/* 543 */
/* 544 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 545 */         double agg_value16 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 546 */         boolean agg_isNull13 = agg_isNull14;
/* 547 */         double agg_value15 = agg_value16;
/* 548 */         if (agg_isNull13) {
/* 549 */           boolean agg_isNull15 = false;
/* 550 */           double agg_value17 = -1.0;
/* 551 */           if (!false) {
/* 552 */             agg_value17 = (double) 0;
/* 553 */           }
/* 554 */           if (!agg_isNull15) {
/* 555 */             agg_isNull13 = false;
/* 556 */             agg_value15 = agg_value17;
/* 557 */           }
/* 558 */         }
/* 559 */
/* 560 */         boolean agg_isNull17 = true;
/* 561 */         double agg_value19 = -1.0;
/* 562 */
/* 563 */         boolean agg_isNull18 = true;
/* 564 */         boolean agg_value20 = false;
/* 565 */
/* 566 */         if (!agg_isNull9) {
/* 567 */           agg_isNull18 = false; // resultCode could change nullability.
/* 568 */           agg_value20 = agg_value11 < 11027;
/* 569 */
/* 570 */         }
/* 571 */         if (!agg_isNull18 && agg_value20) {
/* 572 */           boolean agg_isNull20 = true;
/* 573 */           double agg_value22 = -1.0;
/* 574 */
/* 575 */           if (!inputadapter_isNull3) {
/* 576 */             boolean agg_isNull22 = inputadapter_isNull7;
/* 577 */             double agg_value24 = inputadapter_value7;
/* 578 */             if (agg_isNull22) {
/* 579 */               if (!false) {
/* 580 */                 agg_isNull22 = false;
/* 581 */                 agg_value24 = 0.0D;
/* 582 */               }
/* 583 */             }
/* 584 */
/* 585 */             agg_isNull20 = false; // resultCode could change nullability.
/* 586 */             agg_value22 = inputadapter_value3 - agg_value24;
/* 587 */
/* 588 */           }
/* 589 */           agg_isNull17 = agg_isNull20;
/* 590 */           agg_value19 = agg_value22;
/* 591 */         }
/* 592 */
/* 593 */         else {
/* 594 */           agg_isNull17 = false;
/* 595 */           agg_value19 = 0.0D;
/* 596 */         }
/* 597 */         if (!agg_isNull17) {
/* 598 */           agg_isNull12 = false; // resultCode could change nullability.
/* 599 */           agg_value14 = agg_value15 + agg_value19;
/* 600 */
/* 601 */         }
/* 602 */         boolean agg_isNull11 = agg_isNull12;
/* 603 */         double agg_value13 = agg_value14;
/* 604 */         if (agg_isNull11) {
/* 605 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 606 */           double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 607 */           if (!agg_isNull26) {
/* 608 */             agg_isNull11 = false;
/* 609 */             agg_value13 = agg_value28;
/* 610 */           }
/* 611 */         }
/* 612 */         boolean agg_isNull28 = true;
/* 613 */         double agg_value30 = -1.0;
/* 614 */
/* 615 */         boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 616 */         double agg_value32 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 617 */         boolean agg_isNull29 = agg_isNull30;
/* 618 */         double agg_value31 = agg_value32;
/* 619 */         if (agg_isNull29) {
/* 620 */           boolean agg_isNull31 = false;
/* 621 */           double agg_value33 = -1.0;
/* 622 */           if (!false) {
/* 623 */             agg_value33 = (double) 0;
/* 624 */           }
/* 625 */           if (!agg_isNull31) {
/* 626 */             agg_isNull29 = false;
/* 627 */             agg_value31 = agg_value33;
/* 628 */           }
/* 629 */         }
/* 630 */
/* 631 */         boolean agg_isNull33 = true;
/* 632 */         double agg_value35 = -1.0;
/* 633 */
/* 634 */         boolean agg_isNull34 = true;
/* 635 */         boolean agg_value36 = false;
/* 636 */
/* 637 */         if (!agg_isNull9) {
/* 638 */           agg_isNull34 = false; // resultCode could change nullability.
/* 639 */           agg_value36 = agg_value11 >= 11027;
/* 640 */
/* 641 */         }
/* 642 */         if (!agg_isNull34 && agg_value36) {
/* 643 */           boolean agg_isNull36 = true;
/* 644 */           double agg_value38 = -1.0;
/* 645 */
/* 646 */           if (!inputadapter_isNull3) {
/* 647 */             boolean agg_isNull38 = inputadapter_isNull7;
/* 648 */             double agg_value40 = inputadapter_value7;
/* 649 */             if (agg_isNull38) {
/* 650 */               if (!false) {
/* 651 */                 agg_isNull38 = false;
/* 652 */                 agg_value40 = 0.0D;
/* 653 */               }
/* 654 */             }
/* 655 */
/* 656 */             agg_isNull36 = false; // resultCode could change nullability.
/* 657 */             agg_value38 = inputadapter_value3 - agg_value40;
/* 658 */
/* 659 */           }
/* 660 */           agg_isNull33 = agg_isNull36;
/* 661 */           agg_value35 = agg_value38;
/* 662 */         }
/* 663 */
/* 664 */         else {
/* 665 */           agg_isNull33 = false;
/* 666 */           agg_value35 = 0.0D;
/* 667 */         }
/* 668 */         if (!agg_isNull33) {
/* 669 */           agg_isNull28 = false; // resultCode could change nullability.
/* 670 */           agg_value30 = agg_value31 + agg_value35;
/* 671 */
/* 672 */         }
/* 673 */         boolean agg_isNull27 = agg_isNull28;
/* 674 */         double agg_value29 = agg_value30;
/* 675 */         if (agg_isNull27) {
/* 676 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 677 */           double agg_value44 = agg_isNull42 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 678 */           if (!agg_isNull42) {
/* 679 */             agg_isNull27 = false;
/* 680 */             agg_value29 = agg_value44;
/* 681 */           }
/* 682 */         }
/* 683 */         // update unsafe row buffer
/* 684 */         if (!agg_isNull11) {
/* 685 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value13);
/* 686 */         } else {
/* 687 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 688 */         }
/* 689 */
/* 690 */         if (!agg_isNull27) {
/* 691 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value29);
/* 692 */         } else {
/* 693 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 694 */         }
/* 695 */
/* 696 */       }
/* 697 */       if (shouldStop()) return;
/* 698 */     }
/* 699 */
/* 700 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 701 */
/* 702 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 703 */   }
/* 704 */
/* 705 */   private void wholestagecodegen_init_2() {
/* 706 */     project_result2 = new UnsafeRow(5);
/* 707 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 708 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 709 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 710 */
/* 711 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 712 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 713 */
/* 714 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 715 */     bhj_result2 = new UnsafeRow(7);
/* 716 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 717 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 718 */     project_result3 = new UnsafeRow(5);
/* 719 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 720 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 721 */
/* 722 */   }
/* 723 */
/* 724 */   private void wholestagecodegen_init_1() {
/* 725 */     bhj_result = new UnsafeRow(7);
/* 726 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 727 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 728 */     project_result1 = new UnsafeRow(5);
/* 729 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 730 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 731 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 732 */
/* 733 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 734 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 735 */
/* 736 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 737 */     bhj_result1 = new UnsafeRow(7);
/* 738 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 739 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 740 */
/* 741 */   }
/* 742 */
/* 743 */   protected void processNext() throws java.io.IOException {
/* 744 */     if (!agg_initAgg) {
/* 745 */       agg_initAgg = true;
/* 746 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 747 */       agg_doAggregateWithKeys();
/* 748 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 749 */     }
/* 750 */
/* 751 */     // output the result
/* 752 */
/* 753 */     while (agg_fastHashMapIter.next()) {
/* 754 */       wholestagecodegen_numOutputRows.add(1);
/* 755 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 756 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 757 */
/* 758 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 759 */
/* 760 */       append(agg_resultRow);
/* 761 */
/* 762 */       if (shouldStop()) return;
/* 763 */     }
/* 764 */     agg_fastHashMap.close();
/* 765 */
/* 766 */     while (agg_mapIter.next()) {
/* 767 */       wholestagecodegen_numOutputRows.add(1);
/* 768 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 769 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 770 */
/* 771 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 772 */
/* 773 */       append(agg_resultRow);
/* 774 */
/* 775 */       if (shouldStop()) return;
/* 776 */     }
/* 777 */
/* 778 */     agg_mapIter.close();
/* 779 */     if (agg_sorter == null) {
/* 780 */       agg_hashMap.free();
/* 781 */     }
/* 782 */   }
/* 783 */ }
