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
/* 220 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 221 */
/* 222 */       // generate join key for stream side
/* 223 */
/* 224 */       boolean bhj_isNull10 = inputadapter_isNull;
/* 225 */       long bhj_value10 = -1L;
/* 226 */       if (!inputadapter_isNull) {
/* 227 */         bhj_value10 = (long) inputadapter_value;
/* 228 */       }
/* 229 */       // find matches from HashedRelation
/* 230 */       UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 231 */       if (bhj_matched1 == null) continue;
/* 232 */
/* 233 */       bhj_numOutputRows1.add(1);
/* 234 */
/* 235 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 236 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 237 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 238 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 239 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 240 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 241 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 242 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 243 */       boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 244 */       UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(1));
/* 245 */
/* 246 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 247 */
/* 248 */       UnsafeRow agg_fastAggBuffer = null;
/* 249 */
/* 250 */       if (true) {
/* 251 */         if (!bhj_isNull13) {
/* 252 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 253 */             bhj_value13);
/* 254 */         }
/* 255 */       }
/* 256 */
/* 257 */       if (agg_fastAggBuffer == null) {
/* 258 */         // generate grouping key
/* 259 */         agg_holder.reset();
/* 260 */
/* 261 */         agg_rowWriter.zeroOutNullBytes();
/* 262 */
/* 263 */         if (bhj_isNull13) {
/* 264 */           agg_rowWriter.setNullAt(0);
/* 265 */         } else {
/* 266 */           agg_rowWriter.write(0, bhj_value13);
/* 267 */         }
/* 268 */         agg_result1.setTotalSize(agg_holder.totalSize());
/* 269 */         agg_value10 = 42;
/* 270 */
/* 271 */         if (!bhj_isNull13) {
/* 272 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value10);
/* 273 */         }
/* 274 */         if (true) {
/* 275 */           // try to get the buffer from hash map
/* 276 */           agg_unsafeRowAggBuffer =
/* 277 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value10);
/* 278 */         }
/* 279 */         if (agg_unsafeRowAggBuffer == null) {
/* 280 */           if (agg_sorter == null) {
/* 281 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 282 */           } else {
/* 283 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 284 */           }
/* 285 */
/* 286 */           // the hash map had be spilled, it should have enough memory now,
/* 287 */           // try  to allocate buffer again.
/* 288 */           agg_unsafeRowAggBuffer =
/* 289 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value10);
/* 290 */           if (agg_unsafeRowAggBuffer == null) {
/* 291 */             // failed to allocate the first page
/* 292 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 293 */           }
/* 294 */         }
/* 295 */       }
/* 296 */
/* 297 */       if (agg_fastAggBuffer != null) {
/* 298 */         // update fast row
/* 299 */
/* 300 */         // common sub-expressions
/* 301 */
/* 302 */         // evaluate aggregate function
/* 303 */         boolean agg_isNull41 = true;
/* 304 */         double agg_value45 = -1.0;
/* 305 */
/* 306 */         boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 307 */         double agg_value47 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 308 */         boolean agg_isNull42 = agg_isNull43;
/* 309 */         double agg_value46 = agg_value47;
/* 310 */         if (agg_isNull42) {
/* 311 */           boolean agg_isNull44 = false;
/* 312 */           double agg_value48 = -1.0;
/* 313 */           if (!false) {
/* 314 */             agg_value48 = (double) 0;
/* 315 */           }
/* 316 */           if (!agg_isNull44) {
/* 317 */             agg_isNull42 = false;
/* 318 */             agg_value46 = agg_value48;
/* 319 */           }
/* 320 */         }
/* 321 */
/* 322 */         if (!inputadapter_isNull2) {
/* 323 */           agg_isNull41 = false; // resultCode could change nullability.
/* 324 */           agg_value45 = agg_value46 + inputadapter_value2;
/* 325 */
/* 326 */         }
/* 327 */         boolean agg_isNull40 = agg_isNull41;
/* 328 */         double agg_value44 = agg_value45;
/* 329 */         if (agg_isNull40) {
/* 330 */           boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(0);
/* 331 */           double agg_value51 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 332 */           if (!agg_isNull47) {
/* 333 */             agg_isNull40 = false;
/* 334 */             agg_value44 = agg_value51;
/* 335 */           }
/* 336 */         }
/* 337 */         boolean agg_isNull49 = true;
/* 338 */         double agg_value53 = -1.0;
/* 339 */
/* 340 */         boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(1);
/* 341 */         double agg_value55 = agg_isNull51 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 342 */         boolean agg_isNull50 = agg_isNull51;
/* 343 */         double agg_value54 = agg_value55;
/* 344 */         if (agg_isNull50) {
/* 345 */           boolean agg_isNull52 = false;
/* 346 */           double agg_value56 = -1.0;
/* 347 */           if (!false) {
/* 348 */             agg_value56 = (double) 0;
/* 349 */           }
/* 350 */           if (!agg_isNull52) {
/* 351 */             agg_isNull50 = false;
/* 352 */             agg_value54 = agg_value56;
/* 353 */           }
/* 354 */         }
/* 355 */
/* 356 */         if (!inputadapter_isNull4) {
/* 357 */           agg_isNull49 = false; // resultCode could change nullability.
/* 358 */           agg_value53 = agg_value54 + inputadapter_value4;
/* 359 */
/* 360 */         }
/* 361 */         boolean agg_isNull48 = agg_isNull49;
/* 362 */         double agg_value52 = agg_value53;
/* 363 */         if (agg_isNull48) {
/* 364 */           boolean agg_isNull55 = agg_fastAggBuffer.isNullAt(1);
/* 365 */           double agg_value59 = agg_isNull55 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 366 */           if (!agg_isNull55) {
/* 367 */             agg_isNull48 = false;
/* 368 */             agg_value52 = agg_value59;
/* 369 */           }
/* 370 */         }
/* 371 */         boolean agg_isNull57 = true;
/* 372 */         double agg_value61 = -1.0;
/* 373 */
/* 374 */         boolean agg_isNull59 = agg_fastAggBuffer.isNullAt(2);
/* 375 */         double agg_value63 = agg_isNull59 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 376 */         boolean agg_isNull58 = agg_isNull59;
/* 377 */         double agg_value62 = agg_value63;
/* 378 */         if (agg_isNull58) {
/* 379 */           boolean agg_isNull60 = false;
/* 380 */           double agg_value64 = -1.0;
/* 381 */           if (!false) {
/* 382 */             agg_value64 = (double) 0;
/* 383 */           }
/* 384 */           if (!agg_isNull60) {
/* 385 */             agg_isNull58 = false;
/* 386 */             agg_value62 = agg_value64;
/* 387 */           }
/* 388 */         }
/* 389 */
/* 390 */         if (!inputadapter_isNull3) {
/* 391 */           agg_isNull57 = false; // resultCode could change nullability.
/* 392 */           agg_value61 = agg_value62 + inputadapter_value3;
/* 393 */
/* 394 */         }
/* 395 */         boolean agg_isNull56 = agg_isNull57;
/* 396 */         double agg_value60 = agg_value61;
/* 397 */         if (agg_isNull56) {
/* 398 */           boolean agg_isNull63 = agg_fastAggBuffer.isNullAt(2);
/* 399 */           double agg_value67 = agg_isNull63 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 400 */           if (!agg_isNull63) {
/* 401 */             agg_isNull56 = false;
/* 402 */             agg_value60 = agg_value67;
/* 403 */           }
/* 404 */         }
/* 405 */         boolean agg_isNull65 = true;
/* 406 */         double agg_value69 = -1.0;
/* 407 */
/* 408 */         boolean agg_isNull67 = agg_fastAggBuffer.isNullAt(3);
/* 409 */         double agg_value71 = agg_isNull67 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 410 */         boolean agg_isNull66 = agg_isNull67;
/* 411 */         double agg_value70 = agg_value71;
/* 412 */         if (agg_isNull66) {
/* 413 */           boolean agg_isNull68 = false;
/* 414 */           double agg_value72 = -1.0;
/* 415 */           if (!false) {
/* 416 */             agg_value72 = (double) 0;
/* 417 */           }
/* 418 */           if (!agg_isNull68) {
/* 419 */             agg_isNull66 = false;
/* 420 */             agg_value70 = agg_value72;
/* 421 */           }
/* 422 */         }
/* 423 */
/* 424 */         if (!inputadapter_isNull5) {
/* 425 */           agg_isNull65 = false; // resultCode could change nullability.
/* 426 */           agg_value69 = agg_value70 + inputadapter_value5;
/* 427 */
/* 428 */         }
/* 429 */         boolean agg_isNull64 = agg_isNull65;
/* 430 */         double agg_value68 = agg_value69;
/* 431 */         if (agg_isNull64) {
/* 432 */           boolean agg_isNull71 = agg_fastAggBuffer.isNullAt(3);
/* 433 */           double agg_value75 = agg_isNull71 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 434 */           if (!agg_isNull71) {
/* 435 */             agg_isNull64 = false;
/* 436 */             agg_value68 = agg_value75;
/* 437 */           }
/* 438 */         }
/* 439 */         // update fast row
/* 440 */         if (!agg_isNull40) {
/* 441 */           agg_fastAggBuffer.setDouble(0, agg_value44);
/* 442 */         } else {
/* 443 */           agg_fastAggBuffer.setNullAt(0);
/* 444 */         }
/* 445 */
/* 446 */         if (!agg_isNull48) {
/* 447 */           agg_fastAggBuffer.setDouble(1, agg_value52);
/* 448 */         } else {
/* 449 */           agg_fastAggBuffer.setNullAt(1);
/* 450 */         }
/* 451 */
/* 452 */         if (!agg_isNull56) {
/* 453 */           agg_fastAggBuffer.setDouble(2, agg_value60);
/* 454 */         } else {
/* 455 */           agg_fastAggBuffer.setNullAt(2);
/* 456 */         }
/* 457 */
/* 458 */         if (!agg_isNull64) {
/* 459 */           agg_fastAggBuffer.setDouble(3, agg_value68);
/* 460 */         } else {
/* 461 */           agg_fastAggBuffer.setNullAt(3);
/* 462 */         }
/* 463 */
/* 464 */       } else {
/* 465 */         // update unsafe row
/* 466 */
/* 467 */         // common sub-expressions
/* 468 */
/* 469 */         // evaluate aggregate function
/* 470 */         boolean agg_isNull9 = true;
/* 471 */         double agg_value13 = -1.0;
/* 472 */
/* 473 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 474 */         double agg_value15 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 475 */         boolean agg_isNull10 = agg_isNull11;
/* 476 */         double agg_value14 = agg_value15;
/* 477 */         if (agg_isNull10) {
/* 478 */           boolean agg_isNull12 = false;
/* 479 */           double agg_value16 = -1.0;
/* 480 */           if (!false) {
/* 481 */             agg_value16 = (double) 0;
/* 482 */           }
/* 483 */           if (!agg_isNull12) {
/* 484 */             agg_isNull10 = false;
/* 485 */             agg_value14 = agg_value16;
/* 486 */           }
/* 487 */         }
/* 488 */
/* 489 */         if (!inputadapter_isNull2) {
/* 490 */           agg_isNull9 = false; // resultCode could change nullability.
/* 491 */           agg_value13 = agg_value14 + inputadapter_value2;
/* 492 */
/* 493 */         }
/* 494 */         boolean agg_isNull8 = agg_isNull9;
/* 495 */         double agg_value12 = agg_value13;
/* 496 */         if (agg_isNull8) {
/* 497 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 498 */           double agg_value19 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 499 */           if (!agg_isNull15) {
/* 500 */             agg_isNull8 = false;
/* 501 */             agg_value12 = agg_value19;
/* 502 */           }
/* 503 */         }
/* 504 */         boolean agg_isNull17 = true;
/* 505 */         double agg_value21 = -1.0;
/* 506 */
/* 507 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 508 */         double agg_value23 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 509 */         boolean agg_isNull18 = agg_isNull19;
/* 510 */         double agg_value22 = agg_value23;
/* 511 */         if (agg_isNull18) {
/* 512 */           boolean agg_isNull20 = false;
/* 513 */           double agg_value24 = -1.0;
/* 514 */           if (!false) {
/* 515 */             agg_value24 = (double) 0;
/* 516 */           }
/* 517 */           if (!agg_isNull20) {
/* 518 */             agg_isNull18 = false;
/* 519 */             agg_value22 = agg_value24;
/* 520 */           }
/* 521 */         }
/* 522 */
/* 523 */         if (!inputadapter_isNull4) {
/* 524 */           agg_isNull17 = false; // resultCode could change nullability.
/* 525 */           agg_value21 = agg_value22 + inputadapter_value4;
/* 526 */
/* 527 */         }
/* 528 */         boolean agg_isNull16 = agg_isNull17;
/* 529 */         double agg_value20 = agg_value21;
/* 530 */         if (agg_isNull16) {
/* 531 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 532 */           double agg_value27 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 533 */           if (!agg_isNull23) {
/* 534 */             agg_isNull16 = false;
/* 535 */             agg_value20 = agg_value27;
/* 536 */           }
/* 537 */         }
/* 538 */         boolean agg_isNull25 = true;
/* 539 */         double agg_value29 = -1.0;
/* 540 */
/* 541 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 542 */         double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 543 */         boolean agg_isNull26 = agg_isNull27;
/* 544 */         double agg_value30 = agg_value31;
/* 545 */         if (agg_isNull26) {
/* 546 */           boolean agg_isNull28 = false;
/* 547 */           double agg_value32 = -1.0;
/* 548 */           if (!false) {
/* 549 */             agg_value32 = (double) 0;
/* 550 */           }
/* 551 */           if (!agg_isNull28) {
/* 552 */             agg_isNull26 = false;
/* 553 */             agg_value30 = agg_value32;
/* 554 */           }
/* 555 */         }
/* 556 */
/* 557 */         if (!inputadapter_isNull3) {
/* 558 */           agg_isNull25 = false; // resultCode could change nullability.
/* 559 */           agg_value29 = agg_value30 + inputadapter_value3;
/* 560 */
/* 561 */         }
/* 562 */         boolean agg_isNull24 = agg_isNull25;
/* 563 */         double agg_value28 = agg_value29;
/* 564 */         if (agg_isNull24) {
/* 565 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 566 */           double agg_value35 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 567 */           if (!agg_isNull31) {
/* 568 */             agg_isNull24 = false;
/* 569 */             agg_value28 = agg_value35;
/* 570 */           }
/* 571 */         }
/* 572 */         boolean agg_isNull33 = true;
/* 573 */         double agg_value37 = -1.0;
/* 574 */
/* 575 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 576 */         double agg_value39 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 577 */         boolean agg_isNull34 = agg_isNull35;
/* 578 */         double agg_value38 = agg_value39;
/* 579 */         if (agg_isNull34) {
/* 580 */           boolean agg_isNull36 = false;
/* 581 */           double agg_value40 = -1.0;
/* 582 */           if (!false) {
/* 583 */             agg_value40 = (double) 0;
/* 584 */           }
/* 585 */           if (!agg_isNull36) {
/* 586 */             agg_isNull34 = false;
/* 587 */             agg_value38 = agg_value40;
/* 588 */           }
/* 589 */         }
/* 590 */
/* 591 */         if (!inputadapter_isNull5) {
/* 592 */           agg_isNull33 = false; // resultCode could change nullability.
/* 593 */           agg_value37 = agg_value38 + inputadapter_value5;
/* 594 */
/* 595 */         }
/* 596 */         boolean agg_isNull32 = agg_isNull33;
/* 597 */         double agg_value36 = agg_value37;
/* 598 */         if (agg_isNull32) {
/* 599 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 600 */           double agg_value43 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 601 */           if (!agg_isNull39) {
/* 602 */             agg_isNull32 = false;
/* 603 */             agg_value36 = agg_value43;
/* 604 */           }
/* 605 */         }
/* 606 */         // update unsafe row buffer
/* 607 */         if (!agg_isNull8) {
/* 608 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 609 */         } else {
/* 610 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 611 */         }
/* 612 */
/* 613 */         if (!agg_isNull16) {
/* 614 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value20);
/* 615 */         } else {
/* 616 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 617 */         }
/* 618 */
/* 619 */         if (!agg_isNull24) {
/* 620 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value28);
/* 621 */         } else {
/* 622 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 623 */         }
/* 624 */
/* 625 */         if (!agg_isNull32) {
/* 626 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value36);
/* 627 */         } else {
/* 628 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 629 */         }
/* 630 */
/* 631 */       }
/* 632 */       if (shouldStop()) return;
/* 633 */     }
/* 634 */
/* 635 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 636 */
/* 637 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 638 */   }
/* 639 */
/* 640 */   private void wholestagecodegen_init_2() {
/* 641 */     agg_result1 = new UnsafeRow(1);
/* 642 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 643 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 644 */
/* 645 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 646 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 647 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 648 */
/* 649 */   }
/* 650 */
/* 651 */   private void wholestagecodegen_init_1() {
/* 652 */     project_result = new UnsafeRow(5);
/* 653 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 654 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 655 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 656 */
/* 657 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 658 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 659 */
/* 660 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 661 */     bhj_result1 = new UnsafeRow(7);
/* 662 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 663 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 664 */     project_result1 = new UnsafeRow(5);
/* 665 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 666 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 667 */
/* 668 */   }
/* 669 */
/* 670 */   protected void processNext() throws java.io.IOException {
/* 671 */     if (!agg_initAgg) {
/* 672 */       agg_initAgg = true;
/* 673 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 674 */       agg_doAggregateWithKeys();
/* 675 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 676 */     }
/* 677 */
/* 678 */     // output the result
/* 679 */
/* 680 */     while (agg_fastHashMapIter.next()) {
/* 681 */       wholestagecodegen_numOutputRows.add(1);
/* 682 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 683 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 684 */
/* 685 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 686 */
/* 687 */       append(agg_resultRow);
/* 688 */
/* 689 */       if (shouldStop()) return;
/* 690 */     }
/* 691 */     agg_fastHashMap.close();
/* 692 */
/* 693 */     while (agg_mapIter.next()) {
/* 694 */       wholestagecodegen_numOutputRows.add(1);
/* 695 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 696 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 697 */
/* 698 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 699 */
/* 700 */       append(agg_resultRow);
/* 701 */
/* 702 */       if (shouldStop()) return;
/* 703 */     }
/* 704 */
/* 705 */     agg_mapIter.close();
/* 706 */     if (agg_sorter == null) {
/* 707 */       agg_hashMap.free();
/* 708 */     }
/* 709 */   }
/* 710 */ }
