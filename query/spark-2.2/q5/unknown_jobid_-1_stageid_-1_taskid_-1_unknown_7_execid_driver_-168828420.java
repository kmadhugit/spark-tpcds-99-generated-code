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
/* 025 */   private scala.collection.Iterator inputadapter_input;
/* 026 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 027 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 029 */   private UnsafeRow bhj_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 032 */   private UnsafeRow project_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 035 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 036 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 038 */   private UnsafeRow bhj_result1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 041 */   private UnsafeRow project_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 044 */   private UnsafeRow agg_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 047 */   private int agg_value10;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 051 */
/* 052 */   public GeneratedIterator(Object[] references) {
/* 053 */     this.references = references;
/* 054 */   }
/* 055 */
/* 056 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 057 */     partitionIndex = index;
/* 058 */     this.inputs = inputs;
/* 059 */     wholestagecodegen_init_0();
/* 060 */     wholestagecodegen_init_1();
/* 061 */     wholestagecodegen_init_2();
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void wholestagecodegen_init_0() {
/* 066 */     agg_initAgg = false;
/* 067 */
/* 068 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 069 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 070 */
/* 071 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 072 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 073 */     inputadapter_input = inputs[0];
/* 074 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 075 */
/* 076 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 077 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 078 */
/* 079 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 080 */     bhj_result = new UnsafeRow(7);
/* 081 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 082 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 083 */
/* 084 */   }
/* 085 */
/* 086 */   public class agg_FastHashMap {
/* 087 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 088 */     private int[] buckets;
/* 089 */     private int capacity = 1 << 16;
/* 090 */     private double loadFactor = 0.5;
/* 091 */     private int numBuckets = (int) (capacity / loadFactor);
/* 092 */     private int maxSteps = 2;
/* 093 */     private int numRows = 0;
/* 094 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 095 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 096 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 097 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 098 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 121 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
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
/* 133 */               32);
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
/* 168 */     private boolean equals(int idx, UTF8String agg_key) {
/* 169 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 170 */       return (row.getUTF8String(0).equals(agg_key));
/* 171 */     }
/* 172 */
/* 173 */     private long hash(UTF8String agg_key) {
/* 174 */       long agg_hash = 0;
/* 175 */
/* 176 */       int agg_result = 0;
/* 177 */       byte[] agg_bytes = agg_key.getBytes();
/* 178 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 179 */         int agg_hash1 = agg_bytes[i];
/* 180 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 181 */       }
/* 182 */
/* 183 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 184 */
/* 185 */       return agg_hash;
/* 186 */     }
/* 187 */
/* 188 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 189 */       return batch.rowIterator();
/* 190 */     }
/* 191 */
/* 192 */     public void close() {
/* 193 */       batch.close();
/* 194 */     }
/* 195 */
/* 196 */   }
/* 197 */
/* 198 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 199 */     agg_hashMap = agg_plan.createHashMap();
/* 200 */
/* 201 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 202 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 203 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 204 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 205 */
/* 206 */       // generate join key for stream side
/* 207 */
/* 208 */       boolean bhj_isNull = inputadapter_isNull1;
/* 209 */       long bhj_value = -1L;
/* 210 */       if (!inputadapter_isNull1) {
/* 211 */         bhj_value = (long) inputadapter_value1;
/* 212 */       }
/* 213 */       // find matches from HashedRelation
/* 214 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 215 */       if (bhj_matched == null) continue;
/* 216 */
/* 217 */       bhj_numOutputRows.add(1);
/* 218 */
/* 219 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 220 */       long inputadapter_value = inputadapter_isNull ? -1L : (inputadapter_row.getLong(0));
/* 221 */
/* 222 */       // generate join key for stream side
/* 223 */
/* 224 */       // find matches from HashedRelation
/* 225 */       UnsafeRow bhj_matched1 = inputadapter_isNull ? null: (UnsafeRow)bhj_relation1.getValue(inputadapter_value);
/* 226 */       if (bhj_matched1 == null) continue;
/* 227 */
/* 228 */       bhj_numOutputRows1.add(1);
/* 229 */
/* 230 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 231 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 232 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 233 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 234 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 235 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 236 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 237 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 238 */       boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 239 */       UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(1));
/* 240 */
/* 241 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 242 */
/* 243 */       UnsafeRow agg_fastAggBuffer = null;
/* 244 */
/* 245 */       if (true) {
/* 246 */         if (!bhj_isNull12) {
/* 247 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 248 */             bhj_value12);
/* 249 */         }
/* 250 */       }
/* 251 */
/* 252 */       if (agg_fastAggBuffer == null) {
/* 253 */         // generate grouping key
/* 254 */         agg_holder.reset();
/* 255 */
/* 256 */         agg_rowWriter.zeroOutNullBytes();
/* 257 */
/* 258 */         if (bhj_isNull12) {
/* 259 */           agg_rowWriter.setNullAt(0);
/* 260 */         } else {
/* 261 */           agg_rowWriter.write(0, bhj_value12);
/* 262 */         }
/* 263 */         agg_result1.setTotalSize(agg_holder.totalSize());
/* 264 */         agg_value10 = 42;
/* 265 */
/* 266 */         if (!bhj_isNull12) {
/* 267 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value12.getBaseObject(), bhj_value12.getBaseOffset(), bhj_value12.numBytes(), agg_value10);
/* 268 */         }
/* 269 */         if (true) {
/* 270 */           // try to get the buffer from hash map
/* 271 */           agg_unsafeRowAggBuffer =
/* 272 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value10);
/* 273 */         }
/* 274 */         if (agg_unsafeRowAggBuffer == null) {
/* 275 */           if (agg_sorter == null) {
/* 276 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 277 */           } else {
/* 278 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 279 */           }
/* 280 */
/* 281 */           // the hash map had be spilled, it should have enough memory now,
/* 282 */           // try  to allocate buffer again.
/* 283 */           agg_unsafeRowAggBuffer =
/* 284 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value10);
/* 285 */           if (agg_unsafeRowAggBuffer == null) {
/* 286 */             // failed to allocate the first page
/* 287 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 288 */           }
/* 289 */         }
/* 290 */       }
/* 291 */
/* 292 */       if (agg_fastAggBuffer != null) {
/* 293 */         // update fast row
/* 294 */
/* 295 */         // common sub-expressions
/* 296 */
/* 297 */         // evaluate aggregate function
/* 298 */         boolean agg_isNull41 = true;
/* 299 */         double agg_value45 = -1.0;
/* 300 */
/* 301 */         boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 302 */         double agg_value47 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 303 */         boolean agg_isNull42 = agg_isNull43;
/* 304 */         double agg_value46 = agg_value47;
/* 305 */         if (agg_isNull42) {
/* 306 */           boolean agg_isNull44 = false;
/* 307 */           double agg_value48 = -1.0;
/* 308 */           if (!false) {
/* 309 */             agg_value48 = (double) 0;
/* 310 */           }
/* 311 */           if (!agg_isNull44) {
/* 312 */             agg_isNull42 = false;
/* 313 */             agg_value46 = agg_value48;
/* 314 */           }
/* 315 */         }
/* 316 */
/* 317 */         if (!inputadapter_isNull2) {
/* 318 */           agg_isNull41 = false; // resultCode could change nullability.
/* 319 */           agg_value45 = agg_value46 + inputadapter_value2;
/* 320 */
/* 321 */         }
/* 322 */         boolean agg_isNull40 = agg_isNull41;
/* 323 */         double agg_value44 = agg_value45;
/* 324 */         if (agg_isNull40) {
/* 325 */           boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(0);
/* 326 */           double agg_value51 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 327 */           if (!agg_isNull47) {
/* 328 */             agg_isNull40 = false;
/* 329 */             agg_value44 = agg_value51;
/* 330 */           }
/* 331 */         }
/* 332 */         boolean agg_isNull49 = true;
/* 333 */         double agg_value53 = -1.0;
/* 334 */
/* 335 */         boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(1);
/* 336 */         double agg_value55 = agg_isNull51 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 337 */         boolean agg_isNull50 = agg_isNull51;
/* 338 */         double agg_value54 = agg_value55;
/* 339 */         if (agg_isNull50) {
/* 340 */           boolean agg_isNull52 = false;
/* 341 */           double agg_value56 = -1.0;
/* 342 */           if (!false) {
/* 343 */             agg_value56 = (double) 0;
/* 344 */           }
/* 345 */           if (!agg_isNull52) {
/* 346 */             agg_isNull50 = false;
/* 347 */             agg_value54 = agg_value56;
/* 348 */           }
/* 349 */         }
/* 350 */
/* 351 */         if (!inputadapter_isNull4) {
/* 352 */           agg_isNull49 = false; // resultCode could change nullability.
/* 353 */           agg_value53 = agg_value54 + inputadapter_value4;
/* 354 */
/* 355 */         }
/* 356 */         boolean agg_isNull48 = agg_isNull49;
/* 357 */         double agg_value52 = agg_value53;
/* 358 */         if (agg_isNull48) {
/* 359 */           boolean agg_isNull55 = agg_fastAggBuffer.isNullAt(1);
/* 360 */           double agg_value59 = agg_isNull55 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 361 */           if (!agg_isNull55) {
/* 362 */             agg_isNull48 = false;
/* 363 */             agg_value52 = agg_value59;
/* 364 */           }
/* 365 */         }
/* 366 */         boolean agg_isNull57 = true;
/* 367 */         double agg_value61 = -1.0;
/* 368 */
/* 369 */         boolean agg_isNull59 = agg_fastAggBuffer.isNullAt(2);
/* 370 */         double agg_value63 = agg_isNull59 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 371 */         boolean agg_isNull58 = agg_isNull59;
/* 372 */         double agg_value62 = agg_value63;
/* 373 */         if (agg_isNull58) {
/* 374 */           boolean agg_isNull60 = false;
/* 375 */           double agg_value64 = -1.0;
/* 376 */           if (!false) {
/* 377 */             agg_value64 = (double) 0;
/* 378 */           }
/* 379 */           if (!agg_isNull60) {
/* 380 */             agg_isNull58 = false;
/* 381 */             agg_value62 = agg_value64;
/* 382 */           }
/* 383 */         }
/* 384 */
/* 385 */         if (!inputadapter_isNull3) {
/* 386 */           agg_isNull57 = false; // resultCode could change nullability.
/* 387 */           agg_value61 = agg_value62 + inputadapter_value3;
/* 388 */
/* 389 */         }
/* 390 */         boolean agg_isNull56 = agg_isNull57;
/* 391 */         double agg_value60 = agg_value61;
/* 392 */         if (agg_isNull56) {
/* 393 */           boolean agg_isNull63 = agg_fastAggBuffer.isNullAt(2);
/* 394 */           double agg_value67 = agg_isNull63 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 395 */           if (!agg_isNull63) {
/* 396 */             agg_isNull56 = false;
/* 397 */             agg_value60 = agg_value67;
/* 398 */           }
/* 399 */         }
/* 400 */         boolean agg_isNull65 = true;
/* 401 */         double agg_value69 = -1.0;
/* 402 */
/* 403 */         boolean agg_isNull67 = agg_fastAggBuffer.isNullAt(3);
/* 404 */         double agg_value71 = agg_isNull67 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 405 */         boolean agg_isNull66 = agg_isNull67;
/* 406 */         double agg_value70 = agg_value71;
/* 407 */         if (agg_isNull66) {
/* 408 */           boolean agg_isNull68 = false;
/* 409 */           double agg_value72 = -1.0;
/* 410 */           if (!false) {
/* 411 */             agg_value72 = (double) 0;
/* 412 */           }
/* 413 */           if (!agg_isNull68) {
/* 414 */             agg_isNull66 = false;
/* 415 */             agg_value70 = agg_value72;
/* 416 */           }
/* 417 */         }
/* 418 */
/* 419 */         if (!inputadapter_isNull5) {
/* 420 */           agg_isNull65 = false; // resultCode could change nullability.
/* 421 */           agg_value69 = agg_value70 + inputadapter_value5;
/* 422 */
/* 423 */         }
/* 424 */         boolean agg_isNull64 = agg_isNull65;
/* 425 */         double agg_value68 = agg_value69;
/* 426 */         if (agg_isNull64) {
/* 427 */           boolean agg_isNull71 = agg_fastAggBuffer.isNullAt(3);
/* 428 */           double agg_value75 = agg_isNull71 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 429 */           if (!agg_isNull71) {
/* 430 */             agg_isNull64 = false;
/* 431 */             agg_value68 = agg_value75;
/* 432 */           }
/* 433 */         }
/* 434 */         // update fast row
/* 435 */         if (!agg_isNull40) {
/* 436 */           agg_fastAggBuffer.setDouble(0, agg_value44);
/* 437 */         } else {
/* 438 */           agg_fastAggBuffer.setNullAt(0);
/* 439 */         }
/* 440 */
/* 441 */         if (!agg_isNull48) {
/* 442 */           agg_fastAggBuffer.setDouble(1, agg_value52);
/* 443 */         } else {
/* 444 */           agg_fastAggBuffer.setNullAt(1);
/* 445 */         }
/* 446 */
/* 447 */         if (!agg_isNull56) {
/* 448 */           agg_fastAggBuffer.setDouble(2, agg_value60);
/* 449 */         } else {
/* 450 */           agg_fastAggBuffer.setNullAt(2);
/* 451 */         }
/* 452 */
/* 453 */         if (!agg_isNull64) {
/* 454 */           agg_fastAggBuffer.setDouble(3, agg_value68);
/* 455 */         } else {
/* 456 */           agg_fastAggBuffer.setNullAt(3);
/* 457 */         }
/* 458 */
/* 459 */       } else {
/* 460 */         // update unsafe row
/* 461 */
/* 462 */         // common sub-expressions
/* 463 */
/* 464 */         // evaluate aggregate function
/* 465 */         boolean agg_isNull9 = true;
/* 466 */         double agg_value13 = -1.0;
/* 467 */
/* 468 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 469 */         double agg_value15 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 470 */         boolean agg_isNull10 = agg_isNull11;
/* 471 */         double agg_value14 = agg_value15;
/* 472 */         if (agg_isNull10) {
/* 473 */           boolean agg_isNull12 = false;
/* 474 */           double agg_value16 = -1.0;
/* 475 */           if (!false) {
/* 476 */             agg_value16 = (double) 0;
/* 477 */           }
/* 478 */           if (!agg_isNull12) {
/* 479 */             agg_isNull10 = false;
/* 480 */             agg_value14 = agg_value16;
/* 481 */           }
/* 482 */         }
/* 483 */
/* 484 */         if (!inputadapter_isNull2) {
/* 485 */           agg_isNull9 = false; // resultCode could change nullability.
/* 486 */           agg_value13 = agg_value14 + inputadapter_value2;
/* 487 */
/* 488 */         }
/* 489 */         boolean agg_isNull8 = agg_isNull9;
/* 490 */         double agg_value12 = agg_value13;
/* 491 */         if (agg_isNull8) {
/* 492 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 493 */           double agg_value19 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 494 */           if (!agg_isNull15) {
/* 495 */             agg_isNull8 = false;
/* 496 */             agg_value12 = agg_value19;
/* 497 */           }
/* 498 */         }
/* 499 */         boolean agg_isNull17 = true;
/* 500 */         double agg_value21 = -1.0;
/* 501 */
/* 502 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 503 */         double agg_value23 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 504 */         boolean agg_isNull18 = agg_isNull19;
/* 505 */         double agg_value22 = agg_value23;
/* 506 */         if (agg_isNull18) {
/* 507 */           boolean agg_isNull20 = false;
/* 508 */           double agg_value24 = -1.0;
/* 509 */           if (!false) {
/* 510 */             agg_value24 = (double) 0;
/* 511 */           }
/* 512 */           if (!agg_isNull20) {
/* 513 */             agg_isNull18 = false;
/* 514 */             agg_value22 = agg_value24;
/* 515 */           }
/* 516 */         }
/* 517 */
/* 518 */         if (!inputadapter_isNull4) {
/* 519 */           agg_isNull17 = false; // resultCode could change nullability.
/* 520 */           agg_value21 = agg_value22 + inputadapter_value4;
/* 521 */
/* 522 */         }
/* 523 */         boolean agg_isNull16 = agg_isNull17;
/* 524 */         double agg_value20 = agg_value21;
/* 525 */         if (agg_isNull16) {
/* 526 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 527 */           double agg_value27 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 528 */           if (!agg_isNull23) {
/* 529 */             agg_isNull16 = false;
/* 530 */             agg_value20 = agg_value27;
/* 531 */           }
/* 532 */         }
/* 533 */         boolean agg_isNull25 = true;
/* 534 */         double agg_value29 = -1.0;
/* 535 */
/* 536 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 537 */         double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 538 */         boolean agg_isNull26 = agg_isNull27;
/* 539 */         double agg_value30 = agg_value31;
/* 540 */         if (agg_isNull26) {
/* 541 */           boolean agg_isNull28 = false;
/* 542 */           double agg_value32 = -1.0;
/* 543 */           if (!false) {
/* 544 */             agg_value32 = (double) 0;
/* 545 */           }
/* 546 */           if (!agg_isNull28) {
/* 547 */             agg_isNull26 = false;
/* 548 */             agg_value30 = agg_value32;
/* 549 */           }
/* 550 */         }
/* 551 */
/* 552 */         if (!inputadapter_isNull3) {
/* 553 */           agg_isNull25 = false; // resultCode could change nullability.
/* 554 */           agg_value29 = agg_value30 + inputadapter_value3;
/* 555 */
/* 556 */         }
/* 557 */         boolean agg_isNull24 = agg_isNull25;
/* 558 */         double agg_value28 = agg_value29;
/* 559 */         if (agg_isNull24) {
/* 560 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 561 */           double agg_value35 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 562 */           if (!agg_isNull31) {
/* 563 */             agg_isNull24 = false;
/* 564 */             agg_value28 = agg_value35;
/* 565 */           }
/* 566 */         }
/* 567 */         boolean agg_isNull33 = true;
/* 568 */         double agg_value37 = -1.0;
/* 569 */
/* 570 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 571 */         double agg_value39 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 572 */         boolean agg_isNull34 = agg_isNull35;
/* 573 */         double agg_value38 = agg_value39;
/* 574 */         if (agg_isNull34) {
/* 575 */           boolean agg_isNull36 = false;
/* 576 */           double agg_value40 = -1.0;
/* 577 */           if (!false) {
/* 578 */             agg_value40 = (double) 0;
/* 579 */           }
/* 580 */           if (!agg_isNull36) {
/* 581 */             agg_isNull34 = false;
/* 582 */             agg_value38 = agg_value40;
/* 583 */           }
/* 584 */         }
/* 585 */
/* 586 */         if (!inputadapter_isNull5) {
/* 587 */           agg_isNull33 = false; // resultCode could change nullability.
/* 588 */           agg_value37 = agg_value38 + inputadapter_value5;
/* 589 */
/* 590 */         }
/* 591 */         boolean agg_isNull32 = agg_isNull33;
/* 592 */         double agg_value36 = agg_value37;
/* 593 */         if (agg_isNull32) {
/* 594 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 595 */           double agg_value43 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 596 */           if (!agg_isNull39) {
/* 597 */             agg_isNull32 = false;
/* 598 */             agg_value36 = agg_value43;
/* 599 */           }
/* 600 */         }
/* 601 */         // update unsafe row buffer
/* 602 */         if (!agg_isNull8) {
/* 603 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 604 */         } else {
/* 605 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 606 */         }
/* 607 */
/* 608 */         if (!agg_isNull16) {
/* 609 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value20);
/* 610 */         } else {
/* 611 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 612 */         }
/* 613 */
/* 614 */         if (!agg_isNull24) {
/* 615 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value28);
/* 616 */         } else {
/* 617 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 618 */         }
/* 619 */
/* 620 */         if (!agg_isNull32) {
/* 621 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value36);
/* 622 */         } else {
/* 623 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 624 */         }
/* 625 */
/* 626 */       }
/* 627 */       if (shouldStop()) return;
/* 628 */     }
/* 629 */
/* 630 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 631 */
/* 632 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 633 */   }
/* 634 */
/* 635 */   private void wholestagecodegen_init_2() {
/* 636 */     agg_result1 = new UnsafeRow(1);
/* 637 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 638 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 639 */
/* 640 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 641 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 642 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 643 */
/* 644 */   }
/* 645 */
/* 646 */   private void wholestagecodegen_init_1() {
/* 647 */     project_result = new UnsafeRow(5);
/* 648 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 649 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 650 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 651 */
/* 652 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 653 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 654 */
/* 655 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 656 */     bhj_result1 = new UnsafeRow(7);
/* 657 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 658 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 659 */     project_result1 = new UnsafeRow(5);
/* 660 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 661 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 662 */
/* 663 */   }
/* 664 */
/* 665 */   protected void processNext() throws java.io.IOException {
/* 666 */     if (!agg_initAgg) {
/* 667 */       agg_initAgg = true;
/* 668 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 669 */       agg_doAggregateWithKeys();
/* 670 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 671 */     }
/* 672 */
/* 673 */     // output the result
/* 674 */
/* 675 */     while (agg_fastHashMapIter.next()) {
/* 676 */       wholestagecodegen_numOutputRows.add(1);
/* 677 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 678 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 679 */
/* 680 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 681 */
/* 682 */       append(agg_resultRow);
/* 683 */
/* 684 */       if (shouldStop()) return;
/* 685 */     }
/* 686 */     agg_fastHashMap.close();
/* 687 */
/* 688 */     while (agg_mapIter.next()) {
/* 689 */       wholestagecodegen_numOutputRows.add(1);
/* 690 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 691 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 692 */
/* 693 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 694 */
/* 695 */       append(agg_resultRow);
/* 696 */
/* 697 */       if (shouldStop()) return;
/* 698 */     }
/* 699 */
/* 700 */     agg_mapIter.close();
/* 701 */     if (agg_sorter == null) {
/* 702 */       agg_hashMap.free();
/* 703 */     }
/* 704 */   }
/* 705 */ }
