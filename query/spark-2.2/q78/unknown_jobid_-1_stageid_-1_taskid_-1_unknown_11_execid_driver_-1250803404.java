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
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private agg_FastHashMap agg_fastHashMap;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 025 */   private UnsafeRow filter_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 028 */   private UnsafeRow project_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 031 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 032 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 034 */   private UnsafeRow bhj_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 037 */   private UnsafeRow project_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 040 */   private UnsafeRow agg_result3;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 043 */   private int agg_value12;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 047 */
/* 048 */   public GeneratedIterator(Object[] references) {
/* 049 */     this.references = references;
/* 050 */   }
/* 051 */
/* 052 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 053 */     partitionIndex = index;
/* 054 */     this.inputs = inputs;
/* 055 */     wholestagecodegen_init_0();
/* 056 */     wholestagecodegen_init_1();
/* 057 */     wholestagecodegen_init_2();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     agg_initAgg = false;
/* 063 */
/* 064 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 065 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 066 */
/* 067 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 068 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 069 */     inputadapter_input = inputs[0];
/* 070 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 071 */     filter_result = new UnsafeRow(9);
/* 072 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 073 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 074 */     project_result = new UnsafeRow(6);
/* 075 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 076 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
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
/* 088 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 089 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 090 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 091 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.LongType)
/* 092 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 093 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 116 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1, int agg_key2) {
/* 117 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 118 */       int step = 0;
/* 119 */       int idx = (int) h & (numBuckets - 1);
/* 120 */       while (step < maxSteps) {
/* 121 */         // Return bucket index if it's either an empty slot or already contains the key
/* 122 */         if (buckets[idx] == -1) {
/* 123 */           if (numRows < capacity && !isBatchFull) {
/* 124 */             // creating the unsafe for new entry
/* 125 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 126 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 127 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 128 */               0);
/* 129 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 130 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 131 */               agg_holder,
/* 132 */               3);
/* 133 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 134 */             agg_rowWriter.zeroOutNullBytes();
/* 135 */             agg_rowWriter.write(0, agg_key);
/* 136 */             agg_rowWriter.write(1, agg_key1);
/* 137 */             agg_rowWriter.write(2, agg_key2);
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
/* 155 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 156 */           return batch.getValueRow(buckets[idx]);
/* 157 */         }
/* 158 */         idx = (idx + 1) & (numBuckets - 1);
/* 159 */         step++;
/* 160 */       }
/* 161 */       // Didn't find it
/* 162 */       return null;
/* 163 */     }
/* 164 */
/* 165 */     private boolean equals(int idx, int agg_key, int agg_key1, int agg_key2) {
/* 166 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 167 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2);
/* 168 */     }
/* 169 */
/* 170 */     private long hash(int agg_key, int agg_key1, int agg_key2) {
/* 171 */       long agg_hash = 0;
/* 172 */
/* 173 */       int agg_result = agg_key;
/* 174 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 175 */
/* 176 */       int agg_result1 = agg_key1;
/* 177 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 178 */
/* 179 */       int agg_result2 = agg_key2;
/* 180 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 181 */
/* 182 */       return agg_hash;
/* 183 */     }
/* 184 */
/* 185 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 186 */       return batch.rowIterator();
/* 187 */     }
/* 188 */
/* 189 */     public void close() {
/* 190 */       batch.close();
/* 191 */     }
/* 192 */
/* 193 */   }
/* 194 */
/* 195 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 196 */     agg_hashMap = agg_plan.createHashMap();
/* 197 */
/* 198 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 199 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 200 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 201 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 202 */
/* 203 */       if (!inputadapter_isNull8) continue;
/* 204 */
/* 205 */       filter_numOutputRows.add(1);
/* 206 */
/* 207 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 208 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 209 */
/* 210 */       // generate join key for stream side
/* 211 */
/* 212 */       boolean bhj_isNull = inputadapter_isNull6;
/* 213 */       long bhj_value = -1L;
/* 214 */       if (!inputadapter_isNull6) {
/* 215 */         bhj_value = (long) inputadapter_value6;
/* 216 */       }
/* 217 */       // find matches from HashedRelation
/* 218 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 219 */       if (bhj_matched == null) continue;
/* 220 */
/* 221 */       bhj_numOutputRows.add(1);
/* 222 */
/* 223 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 224 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 225 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 226 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 227 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 228 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 229 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 230 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 231 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 232 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 233 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 234 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 235 */
/* 236 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 237 */
/* 238 */       UnsafeRow agg_fastAggBuffer = null;
/* 239 */
/* 240 */       if (true) {
/* 241 */         if (!bhj_isNull3 && !inputadapter_isNull1 && !inputadapter_isNull) {
/* 242 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 243 */             bhj_value3, inputadapter_value1, inputadapter_value);
/* 244 */         }
/* 245 */       }
/* 246 */
/* 247 */       if (agg_fastAggBuffer == null) {
/* 248 */         // generate grouping key
/* 249 */         agg_rowWriter.zeroOutNullBytes();
/* 250 */
/* 251 */         if (bhj_isNull3) {
/* 252 */           agg_rowWriter.setNullAt(0);
/* 253 */         } else {
/* 254 */           agg_rowWriter.write(0, bhj_value3);
/* 255 */         }
/* 256 */
/* 257 */         if (inputadapter_isNull1) {
/* 258 */           agg_rowWriter.setNullAt(1);
/* 259 */         } else {
/* 260 */           agg_rowWriter.write(1, inputadapter_value1);
/* 261 */         }
/* 262 */
/* 263 */         if (inputadapter_isNull) {
/* 264 */           agg_rowWriter.setNullAt(2);
/* 265 */         } else {
/* 266 */           agg_rowWriter.write(2, inputadapter_value);
/* 267 */         }
/* 268 */         agg_value12 = 42;
/* 269 */
/* 270 */         if (!bhj_isNull3) {
/* 271 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value12);
/* 272 */         }
/* 273 */
/* 274 */         if (!inputadapter_isNull1) {
/* 275 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 276 */         }
/* 277 */
/* 278 */         if (!inputadapter_isNull) {
/* 279 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 280 */         }
/* 281 */         if (true) {
/* 282 */           // try to get the buffer from hash map
/* 283 */           agg_unsafeRowAggBuffer =
/* 284 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 285 */         }
/* 286 */         if (agg_unsafeRowAggBuffer == null) {
/* 287 */           if (agg_sorter == null) {
/* 288 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 289 */           } else {
/* 290 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 291 */           }
/* 292 */
/* 293 */           // the hash map had be spilled, it should have enough memory now,
/* 294 */           // try  to allocate buffer again.
/* 295 */           agg_unsafeRowAggBuffer =
/* 296 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 297 */           if (agg_unsafeRowAggBuffer == null) {
/* 298 */             // failed to allocate the first page
/* 299 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 300 */           }
/* 301 */         }
/* 302 */       }
/* 303 */
/* 304 */       if (agg_fastAggBuffer != null) {
/* 305 */         // update fast row
/* 306 */
/* 307 */         // common sub-expressions
/* 308 */
/* 309 */         // evaluate aggregate function
/* 310 */         boolean agg_isNull39 = true;
/* 311 */         long agg_value42 = -1L;
/* 312 */
/* 313 */         boolean agg_isNull41 = agg_fastAggBuffer.isNullAt(0);
/* 314 */         long agg_value44 = agg_isNull41 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 315 */         boolean agg_isNull40 = agg_isNull41;
/* 316 */         long agg_value43 = agg_value44;
/* 317 */         if (agg_isNull40) {
/* 318 */           boolean agg_isNull42 = false;
/* 319 */           long agg_value45 = -1L;
/* 320 */           if (!false) {
/* 321 */             agg_value45 = (long) 0;
/* 322 */           }
/* 323 */           if (!agg_isNull42) {
/* 324 */             agg_isNull40 = false;
/* 325 */             agg_value43 = agg_value45;
/* 326 */           }
/* 327 */         }
/* 328 */
/* 329 */         boolean agg_isNull44 = inputadapter_isNull3;
/* 330 */         long agg_value47 = -1L;
/* 331 */         if (!inputadapter_isNull3) {
/* 332 */           agg_value47 = (long) inputadapter_value3;
/* 333 */         }
/* 334 */         if (!agg_isNull44) {
/* 335 */           agg_isNull39 = false; // resultCode could change nullability.
/* 336 */           agg_value42 = agg_value43 + agg_value47;
/* 337 */
/* 338 */         }
/* 339 */         boolean agg_isNull38 = agg_isNull39;
/* 340 */         long agg_value41 = agg_value42;
/* 341 */         if (agg_isNull38) {
/* 342 */           boolean agg_isNull46 = agg_fastAggBuffer.isNullAt(0);
/* 343 */           long agg_value49 = agg_isNull46 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 344 */           if (!agg_isNull46) {
/* 345 */             agg_isNull38 = false;
/* 346 */             agg_value41 = agg_value49;
/* 347 */           }
/* 348 */         }
/* 349 */         boolean agg_isNull48 = true;
/* 350 */         double agg_value51 = -1.0;
/* 351 */
/* 352 */         boolean agg_isNull50 = agg_fastAggBuffer.isNullAt(1);
/* 353 */         double agg_value53 = agg_isNull50 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 354 */         boolean agg_isNull49 = agg_isNull50;
/* 355 */         double agg_value52 = agg_value53;
/* 356 */         if (agg_isNull49) {
/* 357 */           boolean agg_isNull51 = false;
/* 358 */           double agg_value54 = -1.0;
/* 359 */           if (!false) {
/* 360 */             agg_value54 = (double) 0;
/* 361 */           }
/* 362 */           if (!agg_isNull51) {
/* 363 */             agg_isNull49 = false;
/* 364 */             agg_value52 = agg_value54;
/* 365 */           }
/* 366 */         }
/* 367 */
/* 368 */         if (!inputadapter_isNull4) {
/* 369 */           agg_isNull48 = false; // resultCode could change nullability.
/* 370 */           agg_value51 = agg_value52 + inputadapter_value4;
/* 371 */
/* 372 */         }
/* 373 */         boolean agg_isNull47 = agg_isNull48;
/* 374 */         double agg_value50 = agg_value51;
/* 375 */         if (agg_isNull47) {
/* 376 */           boolean agg_isNull54 = agg_fastAggBuffer.isNullAt(1);
/* 377 */           double agg_value57 = agg_isNull54 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 378 */           if (!agg_isNull54) {
/* 379 */             agg_isNull47 = false;
/* 380 */             agg_value50 = agg_value57;
/* 381 */           }
/* 382 */         }
/* 383 */         boolean agg_isNull56 = true;
/* 384 */         double agg_value59 = -1.0;
/* 385 */
/* 386 */         boolean agg_isNull58 = agg_fastAggBuffer.isNullAt(2);
/* 387 */         double agg_value61 = agg_isNull58 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 388 */         boolean agg_isNull57 = agg_isNull58;
/* 389 */         double agg_value60 = agg_value61;
/* 390 */         if (agg_isNull57) {
/* 391 */           boolean agg_isNull59 = false;
/* 392 */           double agg_value62 = -1.0;
/* 393 */           if (!false) {
/* 394 */             agg_value62 = (double) 0;
/* 395 */           }
/* 396 */           if (!agg_isNull59) {
/* 397 */             agg_isNull57 = false;
/* 398 */             agg_value60 = agg_value62;
/* 399 */           }
/* 400 */         }
/* 401 */
/* 402 */         if (!inputadapter_isNull5) {
/* 403 */           agg_isNull56 = false; // resultCode could change nullability.
/* 404 */           agg_value59 = agg_value60 + inputadapter_value5;
/* 405 */
/* 406 */         }
/* 407 */         boolean agg_isNull55 = agg_isNull56;
/* 408 */         double agg_value58 = agg_value59;
/* 409 */         if (agg_isNull55) {
/* 410 */           boolean agg_isNull62 = agg_fastAggBuffer.isNullAt(2);
/* 411 */           double agg_value65 = agg_isNull62 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 412 */           if (!agg_isNull62) {
/* 413 */             agg_isNull55 = false;
/* 414 */             agg_value58 = agg_value65;
/* 415 */           }
/* 416 */         }
/* 417 */         // update fast row
/* 418 */         if (!agg_isNull38) {
/* 419 */           agg_fastAggBuffer.setLong(0, agg_value41);
/* 420 */         } else {
/* 421 */           agg_fastAggBuffer.setNullAt(0);
/* 422 */         }
/* 423 */
/* 424 */         if (!agg_isNull47) {
/* 425 */           agg_fastAggBuffer.setDouble(1, agg_value50);
/* 426 */         } else {
/* 427 */           agg_fastAggBuffer.setNullAt(1);
/* 428 */         }
/* 429 */
/* 430 */         if (!agg_isNull55) {
/* 431 */           agg_fastAggBuffer.setDouble(2, agg_value58);
/* 432 */         } else {
/* 433 */           agg_fastAggBuffer.setNullAt(2);
/* 434 */         }
/* 435 */
/* 436 */       } else {
/* 437 */         // update unsafe row
/* 438 */
/* 439 */         // common sub-expressions
/* 440 */
/* 441 */         // evaluate aggregate function
/* 442 */         boolean agg_isNull14 = true;
/* 443 */         long agg_value17 = -1L;
/* 444 */
/* 445 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 446 */         long agg_value19 = agg_isNull16 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 447 */         boolean agg_isNull15 = agg_isNull16;
/* 448 */         long agg_value18 = agg_value19;
/* 449 */         if (agg_isNull15) {
/* 450 */           boolean agg_isNull17 = false;
/* 451 */           long agg_value20 = -1L;
/* 452 */           if (!false) {
/* 453 */             agg_value20 = (long) 0;
/* 454 */           }
/* 455 */           if (!agg_isNull17) {
/* 456 */             agg_isNull15 = false;
/* 457 */             agg_value18 = agg_value20;
/* 458 */           }
/* 459 */         }
/* 460 */
/* 461 */         boolean agg_isNull19 = inputadapter_isNull3;
/* 462 */         long agg_value22 = -1L;
/* 463 */         if (!inputadapter_isNull3) {
/* 464 */           agg_value22 = (long) inputadapter_value3;
/* 465 */         }
/* 466 */         if (!agg_isNull19) {
/* 467 */           agg_isNull14 = false; // resultCode could change nullability.
/* 468 */           agg_value17 = agg_value18 + agg_value22;
/* 469 */
/* 470 */         }
/* 471 */         boolean agg_isNull13 = agg_isNull14;
/* 472 */         long agg_value16 = agg_value17;
/* 473 */         if (agg_isNull13) {
/* 474 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 475 */           long agg_value24 = agg_isNull21 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 476 */           if (!agg_isNull21) {
/* 477 */             agg_isNull13 = false;
/* 478 */             agg_value16 = agg_value24;
/* 479 */           }
/* 480 */         }
/* 481 */         boolean agg_isNull23 = true;
/* 482 */         double agg_value26 = -1.0;
/* 483 */
/* 484 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 485 */         double agg_value28 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 486 */         boolean agg_isNull24 = agg_isNull25;
/* 487 */         double agg_value27 = agg_value28;
/* 488 */         if (agg_isNull24) {
/* 489 */           boolean agg_isNull26 = false;
/* 490 */           double agg_value29 = -1.0;
/* 491 */           if (!false) {
/* 492 */             agg_value29 = (double) 0;
/* 493 */           }
/* 494 */           if (!agg_isNull26) {
/* 495 */             agg_isNull24 = false;
/* 496 */             agg_value27 = agg_value29;
/* 497 */           }
/* 498 */         }
/* 499 */
/* 500 */         if (!inputadapter_isNull4) {
/* 501 */           agg_isNull23 = false; // resultCode could change nullability.
/* 502 */           agg_value26 = agg_value27 + inputadapter_value4;
/* 503 */
/* 504 */         }
/* 505 */         boolean agg_isNull22 = agg_isNull23;
/* 506 */         double agg_value25 = agg_value26;
/* 507 */         if (agg_isNull22) {
/* 508 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 509 */           double agg_value32 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 510 */           if (!agg_isNull29) {
/* 511 */             agg_isNull22 = false;
/* 512 */             agg_value25 = agg_value32;
/* 513 */           }
/* 514 */         }
/* 515 */         boolean agg_isNull31 = true;
/* 516 */         double agg_value34 = -1.0;
/* 517 */
/* 518 */         boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 519 */         double agg_value36 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 520 */         boolean agg_isNull32 = agg_isNull33;
/* 521 */         double agg_value35 = agg_value36;
/* 522 */         if (agg_isNull32) {
/* 523 */           boolean agg_isNull34 = false;
/* 524 */           double agg_value37 = -1.0;
/* 525 */           if (!false) {
/* 526 */             agg_value37 = (double) 0;
/* 527 */           }
/* 528 */           if (!agg_isNull34) {
/* 529 */             agg_isNull32 = false;
/* 530 */             agg_value35 = agg_value37;
/* 531 */           }
/* 532 */         }
/* 533 */
/* 534 */         if (!inputadapter_isNull5) {
/* 535 */           agg_isNull31 = false; // resultCode could change nullability.
/* 536 */           agg_value34 = agg_value35 + inputadapter_value5;
/* 537 */
/* 538 */         }
/* 539 */         boolean agg_isNull30 = agg_isNull31;
/* 540 */         double agg_value33 = agg_value34;
/* 541 */         if (agg_isNull30) {
/* 542 */           boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 543 */           double agg_value40 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 544 */           if (!agg_isNull37) {
/* 545 */             agg_isNull30 = false;
/* 546 */             agg_value33 = agg_value40;
/* 547 */           }
/* 548 */         }
/* 549 */         // update unsafe row buffer
/* 550 */         if (!agg_isNull13) {
/* 551 */           agg_unsafeRowAggBuffer.setLong(0, agg_value16);
/* 552 */         } else {
/* 553 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 554 */         }
/* 555 */
/* 556 */         if (!agg_isNull22) {
/* 557 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value25);
/* 558 */         } else {
/* 559 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 560 */         }
/* 561 */
/* 562 */         if (!agg_isNull30) {
/* 563 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value33);
/* 564 */         } else {
/* 565 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 566 */         }
/* 567 */
/* 568 */       }
/* 569 */       if (shouldStop()) return;
/* 570 */     }
/* 571 */
/* 572 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 573 */
/* 574 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 575 */   }
/* 576 */
/* 577 */   private void wholestagecodegen_init_2() {
/* 578 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 579 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 580 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 581 */
/* 582 */   }
/* 583 */
/* 584 */   private void wholestagecodegen_init_1() {
/* 585 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 586 */
/* 587 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 588 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 589 */
/* 590 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 591 */     bhj_result = new UnsafeRow(8);
/* 592 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 593 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 594 */     project_result1 = new UnsafeRow(6);
/* 595 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 596 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 597 */     agg_result3 = new UnsafeRow(3);
/* 598 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 599 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 600 */
/* 601 */   }
/* 602 */
/* 603 */   protected void processNext() throws java.io.IOException {
/* 604 */     if (!agg_initAgg) {
/* 605 */       agg_initAgg = true;
/* 606 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 607 */       agg_doAggregateWithKeys();
/* 608 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 609 */     }
/* 610 */
/* 611 */     // output the result
/* 612 */
/* 613 */     while (agg_fastHashMapIter.next()) {
/* 614 */       wholestagecodegen_numOutputRows.add(1);
/* 615 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 616 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 617 */
/* 618 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 619 */
/* 620 */       append(agg_resultRow);
/* 621 */
/* 622 */       if (shouldStop()) return;
/* 623 */     }
/* 624 */     agg_fastHashMap.close();
/* 625 */
/* 626 */     while (agg_mapIter.next()) {
/* 627 */       wholestagecodegen_numOutputRows.add(1);
/* 628 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 629 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 630 */
/* 631 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 632 */
/* 633 */       append(agg_resultRow);
/* 634 */
/* 635 */       if (shouldStop()) return;
/* 636 */     }
/* 637 */
/* 638 */     agg_mapIter.close();
/* 639 */     if (agg_sorter == null) {
/* 640 */       agg_hashMap.free();
/* 641 */     }
/* 642 */   }
/* 643 */ }
