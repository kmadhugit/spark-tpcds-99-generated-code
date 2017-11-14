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
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private agg_FastHashMap agg_fastHashMap;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 025 */   private UnsafeRow expand_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 028 */   private UnsafeRow agg_result3;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 031 */   private int agg_value12;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     agg_initAgg = false;
/* 050 */
/* 051 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 052 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 053 */
/* 054 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 055 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     inputadapter_input = inputs[0];
/* 057 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 058 */     expand_result = new UnsafeRow(6);
/* 059 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 64);
/* 060 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 6);
/* 061 */     agg_result3 = new UnsafeRow(3);
/* 062 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 64);
/* 063 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   public class agg_FastHashMap {
/* 068 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 069 */     private int[] buckets;
/* 070 */     private int capacity = 1 << 16;
/* 071 */     private double loadFactor = 0.5;
/* 072 */     private int numBuckets = (int) (capacity / loadFactor);
/* 073 */     private int maxSteps = 2;
/* 074 */     private int numRows = 0;
/* 075 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 076 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 077 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 078 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 079 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 080 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 081 */     private Object emptyVBase;
/* 082 */     private long emptyVOff;
/* 083 */     private int emptyVLen;
/* 084 */     private boolean isBatchFull = false;
/* 085 */
/* 086 */     public agg_FastHashMap(
/* 087 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 088 */       InternalRow emptyAggregationBuffer) {
/* 089 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 090 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 091 */
/* 092 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 093 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 094 */
/* 095 */       emptyVBase = emptyBuffer;
/* 096 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 097 */       emptyVLen = emptyBuffer.length;
/* 098 */
/* 099 */       buckets = new int[numBuckets];
/* 100 */       java.util.Arrays.fill(buckets, -1);
/* 101 */     }
/* 102 */
/* 103 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 104 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 105 */       int step = 0;
/* 106 */       int idx = (int) h & (numBuckets - 1);
/* 107 */       while (step < maxSteps) {
/* 108 */         // Return bucket index if it's either an empty slot or already contains the key
/* 109 */         if (buckets[idx] == -1) {
/* 110 */           if (numRows < capacity && !isBatchFull) {
/* 111 */             // creating the unsafe for new entry
/* 112 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 113 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 114 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 115 */               64);
/* 116 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 117 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 118 */               agg_holder,
/* 119 */               3);
/* 120 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 121 */             agg_rowWriter.zeroOutNullBytes();
/* 122 */             agg_rowWriter.write(0, agg_key);
/* 123 */             agg_rowWriter.write(1, agg_key1);
/* 124 */             agg_rowWriter.write(2, agg_key2);
/* 125 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 126 */             Object kbase = agg_result.getBaseObject();
/* 127 */             long koff = agg_result.getBaseOffset();
/* 128 */             int klen = agg_result.getSizeInBytes();
/* 129 */
/* 130 */             UnsafeRow vRow
/* 131 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 132 */             if (vRow == null) {
/* 133 */               isBatchFull = true;
/* 134 */             } else {
/* 135 */               buckets[idx] = numRows++;
/* 136 */             }
/* 137 */             return vRow;
/* 138 */           } else {
/* 139 */             // No more space
/* 140 */             return null;
/* 141 */           }
/* 142 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 143 */           return batch.getValueRow(buckets[idx]);
/* 144 */         }
/* 145 */         idx = (idx + 1) & (numBuckets - 1);
/* 146 */         step++;
/* 147 */       }
/* 148 */       // Didn't find it
/* 149 */       return null;
/* 150 */     }
/* 151 */
/* 152 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 153 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 154 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getInt(2) == agg_key2);
/* 155 */     }
/* 156 */
/* 157 */     private long hash(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 158 */       long agg_hash = 0;
/* 159 */
/* 160 */       int agg_result = 0;
/* 161 */       byte[] agg_bytes = agg_key.getBytes();
/* 162 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 163 */         int agg_hash1 = agg_bytes[i];
/* 164 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 165 */       }
/* 166 */
/* 167 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 168 */
/* 169 */       int agg_result1 = 0;
/* 170 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 171 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 172 */         int agg_hash2 = agg_bytes1[i];
/* 173 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 174 */       }
/* 175 */
/* 176 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 177 */
/* 178 */       int agg_result2 = agg_key2;
/* 179 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 180 */
/* 181 */       return agg_hash;
/* 182 */     }
/* 183 */
/* 184 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 185 */       return batch.rowIterator();
/* 186 */     }
/* 187 */
/* 188 */     public void close() {
/* 189 */       batch.close();
/* 190 */     }
/* 191 */
/* 192 */   }
/* 193 */
/* 194 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 195 */     agg_hashMap = agg_plan.createHashMap();
/* 196 */
/* 197 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 198 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 199 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 200 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 201 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 202 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 203 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 204 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 205 */       UTF8String inputadapter_value3 = inputadapter_row.getUTF8String(3);
/* 206 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 207 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 208 */
/* 209 */       boolean expand_isNull3 = true;
/* 210 */       UTF8String expand_value3 = null;
/* 211 */       boolean expand_isNull4 = true;
/* 212 */       UTF8String expand_value4 = null;
/* 213 */       boolean expand_isNull5 = true;
/* 214 */       int expand_value5 = -1;
/* 215 */       for (int expand_i = 0; expand_i < 3; expand_i ++) {
/* 216 */         switch (expand_i) {
/* 217 */         case 0:
/* 218 */           expand_isNull3 = false;
/* 219 */           expand_value3 = inputadapter_value3;
/* 220 */
/* 221 */           expand_isNull4 = inputadapter_isNull4;
/* 222 */           expand_value4 = inputadapter_value4;
/* 223 */
/* 224 */           expand_isNull5 = false;
/* 225 */           expand_value5 = 0;
/* 226 */           break;
/* 227 */
/* 228 */         case 1:
/* 229 */           expand_isNull3 = false;
/* 230 */           expand_value3 = inputadapter_value3;
/* 231 */
/* 232 */           final UTF8String expand_value10 = null;
/* 233 */           expand_isNull4 = true;
/* 234 */           expand_value4 = expand_value10;
/* 235 */
/* 236 */           expand_isNull5 = false;
/* 237 */           expand_value5 = 1;
/* 238 */           break;
/* 239 */
/* 240 */         case 2:
/* 241 */           final UTF8String expand_value12 = null;
/* 242 */           expand_isNull3 = true;
/* 243 */           expand_value3 = expand_value12;
/* 244 */
/* 245 */           final UTF8String expand_value13 = null;
/* 246 */           expand_isNull4 = true;
/* 247 */           expand_value4 = expand_value13;
/* 248 */
/* 249 */           expand_isNull5 = false;
/* 250 */           expand_value5 = 3;
/* 251 */           break;
/* 252 */         }
/* 253 */         expand_numOutputRows.add(1);
/* 254 */
/* 255 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 256 */
/* 257 */         UnsafeRow agg_fastAggBuffer = null;
/* 258 */
/* 259 */         if (true) {
/* 260 */           if (!expand_isNull3 && !expand_isNull4 && !expand_isNull5) {
/* 261 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 262 */               expand_value3, expand_value4, expand_value5);
/* 263 */           }
/* 264 */         }
/* 265 */
/* 266 */         if (agg_fastAggBuffer == null) {
/* 267 */           // generate grouping key
/* 268 */           agg_holder.reset();
/* 269 */
/* 270 */           agg_rowWriter.zeroOutNullBytes();
/* 271 */
/* 272 */           if (expand_isNull3) {
/* 273 */             agg_rowWriter.setNullAt(0);
/* 274 */           } else {
/* 275 */             agg_rowWriter.write(0, expand_value3);
/* 276 */           }
/* 277 */
/* 278 */           if (expand_isNull4) {
/* 279 */             agg_rowWriter.setNullAt(1);
/* 280 */           } else {
/* 281 */             agg_rowWriter.write(1, expand_value4);
/* 282 */           }
/* 283 */
/* 284 */           if (expand_isNull5) {
/* 285 */             agg_rowWriter.setNullAt(2);
/* 286 */           } else {
/* 287 */             agg_rowWriter.write(2, expand_value5);
/* 288 */           }
/* 289 */           agg_result3.setTotalSize(agg_holder.totalSize());
/* 290 */           agg_value12 = 42;
/* 291 */
/* 292 */           if (!expand_isNull3) {
/* 293 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value3.getBaseObject(), expand_value3.getBaseOffset(), expand_value3.numBytes(), agg_value12);
/* 294 */           }
/* 295 */
/* 296 */           if (!expand_isNull4) {
/* 297 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value4.getBaseObject(), expand_value4.getBaseOffset(), expand_value4.numBytes(), agg_value12);
/* 298 */           }
/* 299 */
/* 300 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value5, agg_value12);
/* 301 */           if (true) {
/* 302 */             // try to get the buffer from hash map
/* 303 */             agg_unsafeRowAggBuffer =
/* 304 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 305 */           }
/* 306 */           if (agg_unsafeRowAggBuffer == null) {
/* 307 */             if (agg_sorter == null) {
/* 308 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 309 */             } else {
/* 310 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 311 */             }
/* 312 */
/* 313 */             // the hash map had be spilled, it should have enough memory now,
/* 314 */             // try  to allocate buffer again.
/* 315 */             agg_unsafeRowAggBuffer =
/* 316 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 317 */             if (agg_unsafeRowAggBuffer == null) {
/* 318 */               // failed to allocate the first page
/* 319 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 320 */             }
/* 321 */           }
/* 322 */         }
/* 323 */
/* 324 */         if (agg_fastAggBuffer != null) {
/* 325 */           // update fast row
/* 326 */
/* 327 */           // common sub-expressions
/* 328 */
/* 329 */           // evaluate aggregate function
/* 330 */           boolean agg_isNull38 = true;
/* 331 */           double agg_value41 = -1.0;
/* 332 */
/* 333 */           boolean agg_isNull40 = agg_fastAggBuffer.isNullAt(0);
/* 334 */           double agg_value43 = agg_isNull40 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 335 */           boolean agg_isNull39 = agg_isNull40;
/* 336 */           double agg_value42 = agg_value43;
/* 337 */           if (agg_isNull39) {
/* 338 */             boolean agg_isNull41 = false;
/* 339 */             double agg_value44 = -1.0;
/* 340 */             if (!false) {
/* 341 */               agg_value44 = (double) 0;
/* 342 */             }
/* 343 */             if (!agg_isNull41) {
/* 344 */               agg_isNull39 = false;
/* 345 */               agg_value42 = agg_value44;
/* 346 */             }
/* 347 */           }
/* 348 */
/* 349 */           if (!inputadapter_isNull) {
/* 350 */             agg_isNull38 = false; // resultCode could change nullability.
/* 351 */             agg_value41 = agg_value42 + inputadapter_value;
/* 352 */
/* 353 */           }
/* 354 */           boolean agg_isNull37 = agg_isNull38;
/* 355 */           double agg_value40 = agg_value41;
/* 356 */           if (agg_isNull37) {
/* 357 */             boolean agg_isNull44 = agg_fastAggBuffer.isNullAt(0);
/* 358 */             double agg_value47 = agg_isNull44 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 359 */             if (!agg_isNull44) {
/* 360 */               agg_isNull37 = false;
/* 361 */               agg_value40 = agg_value47;
/* 362 */             }
/* 363 */           }
/* 364 */           boolean agg_isNull46 = true;
/* 365 */           double agg_value49 = -1.0;
/* 366 */
/* 367 */           boolean agg_isNull48 = agg_fastAggBuffer.isNullAt(1);
/* 368 */           double agg_value51 = agg_isNull48 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 369 */           boolean agg_isNull47 = agg_isNull48;
/* 370 */           double agg_value50 = agg_value51;
/* 371 */           if (agg_isNull47) {
/* 372 */             boolean agg_isNull49 = false;
/* 373 */             double agg_value52 = -1.0;
/* 374 */             if (!false) {
/* 375 */               agg_value52 = (double) 0;
/* 376 */             }
/* 377 */             if (!agg_isNull49) {
/* 378 */               agg_isNull47 = false;
/* 379 */               agg_value50 = agg_value52;
/* 380 */             }
/* 381 */           }
/* 382 */
/* 383 */           if (!inputadapter_isNull1) {
/* 384 */             agg_isNull46 = false; // resultCode could change nullability.
/* 385 */             agg_value49 = agg_value50 + inputadapter_value1;
/* 386 */
/* 387 */           }
/* 388 */           boolean agg_isNull45 = agg_isNull46;
/* 389 */           double agg_value48 = agg_value49;
/* 390 */           if (agg_isNull45) {
/* 391 */             boolean agg_isNull52 = agg_fastAggBuffer.isNullAt(1);
/* 392 */             double agg_value55 = agg_isNull52 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 393 */             if (!agg_isNull52) {
/* 394 */               agg_isNull45 = false;
/* 395 */               agg_value48 = agg_value55;
/* 396 */             }
/* 397 */           }
/* 398 */           boolean agg_isNull54 = true;
/* 399 */           double agg_value57 = -1.0;
/* 400 */
/* 401 */           boolean agg_isNull56 = agg_fastAggBuffer.isNullAt(2);
/* 402 */           double agg_value59 = agg_isNull56 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 403 */           boolean agg_isNull55 = agg_isNull56;
/* 404 */           double agg_value58 = agg_value59;
/* 405 */           if (agg_isNull55) {
/* 406 */             boolean agg_isNull57 = false;
/* 407 */             double agg_value60 = -1.0;
/* 408 */             if (!false) {
/* 409 */               agg_value60 = (double) 0;
/* 410 */             }
/* 411 */             if (!agg_isNull57) {
/* 412 */               agg_isNull55 = false;
/* 413 */               agg_value58 = agg_value60;
/* 414 */             }
/* 415 */           }
/* 416 */
/* 417 */           if (!inputadapter_isNull2) {
/* 418 */             agg_isNull54 = false; // resultCode could change nullability.
/* 419 */             agg_value57 = agg_value58 + inputadapter_value2;
/* 420 */
/* 421 */           }
/* 422 */           boolean agg_isNull53 = agg_isNull54;
/* 423 */           double agg_value56 = agg_value57;
/* 424 */           if (agg_isNull53) {
/* 425 */             boolean agg_isNull60 = agg_fastAggBuffer.isNullAt(2);
/* 426 */             double agg_value63 = agg_isNull60 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 427 */             if (!agg_isNull60) {
/* 428 */               agg_isNull53 = false;
/* 429 */               agg_value56 = agg_value63;
/* 430 */             }
/* 431 */           }
/* 432 */           // update fast row
/* 433 */           if (!agg_isNull37) {
/* 434 */             agg_fastAggBuffer.setDouble(0, agg_value40);
/* 435 */           } else {
/* 436 */             agg_fastAggBuffer.setNullAt(0);
/* 437 */           }
/* 438 */
/* 439 */           if (!agg_isNull45) {
/* 440 */             agg_fastAggBuffer.setDouble(1, agg_value48);
/* 441 */           } else {
/* 442 */             agg_fastAggBuffer.setNullAt(1);
/* 443 */           }
/* 444 */
/* 445 */           if (!agg_isNull53) {
/* 446 */             agg_fastAggBuffer.setDouble(2, agg_value56);
/* 447 */           } else {
/* 448 */             agg_fastAggBuffer.setNullAt(2);
/* 449 */           }
/* 450 */
/* 451 */         } else {
/* 452 */           // update unsafe row
/* 453 */
/* 454 */           // common sub-expressions
/* 455 */
/* 456 */           // evaluate aggregate function
/* 457 */           boolean agg_isNull14 = true;
/* 458 */           double agg_value17 = -1.0;
/* 459 */
/* 460 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 461 */           double agg_value19 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 462 */           boolean agg_isNull15 = agg_isNull16;
/* 463 */           double agg_value18 = agg_value19;
/* 464 */           if (agg_isNull15) {
/* 465 */             boolean agg_isNull17 = false;
/* 466 */             double agg_value20 = -1.0;
/* 467 */             if (!false) {
/* 468 */               agg_value20 = (double) 0;
/* 469 */             }
/* 470 */             if (!agg_isNull17) {
/* 471 */               agg_isNull15 = false;
/* 472 */               agg_value18 = agg_value20;
/* 473 */             }
/* 474 */           }
/* 475 */
/* 476 */           if (!inputadapter_isNull) {
/* 477 */             agg_isNull14 = false; // resultCode could change nullability.
/* 478 */             agg_value17 = agg_value18 + inputadapter_value;
/* 479 */
/* 480 */           }
/* 481 */           boolean agg_isNull13 = agg_isNull14;
/* 482 */           double agg_value16 = agg_value17;
/* 483 */           if (agg_isNull13) {
/* 484 */             boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 485 */             double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 486 */             if (!agg_isNull20) {
/* 487 */               agg_isNull13 = false;
/* 488 */               agg_value16 = agg_value23;
/* 489 */             }
/* 490 */           }
/* 491 */           boolean agg_isNull22 = true;
/* 492 */           double agg_value25 = -1.0;
/* 493 */
/* 494 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 495 */           double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 496 */           boolean agg_isNull23 = agg_isNull24;
/* 497 */           double agg_value26 = agg_value27;
/* 498 */           if (agg_isNull23) {
/* 499 */             boolean agg_isNull25 = false;
/* 500 */             double agg_value28 = -1.0;
/* 501 */             if (!false) {
/* 502 */               agg_value28 = (double) 0;
/* 503 */             }
/* 504 */             if (!agg_isNull25) {
/* 505 */               agg_isNull23 = false;
/* 506 */               agg_value26 = agg_value28;
/* 507 */             }
/* 508 */           }
/* 509 */
/* 510 */           if (!inputadapter_isNull1) {
/* 511 */             agg_isNull22 = false; // resultCode could change nullability.
/* 512 */             agg_value25 = agg_value26 + inputadapter_value1;
/* 513 */
/* 514 */           }
/* 515 */           boolean agg_isNull21 = agg_isNull22;
/* 516 */           double agg_value24 = agg_value25;
/* 517 */           if (agg_isNull21) {
/* 518 */             boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 519 */             double agg_value31 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 520 */             if (!agg_isNull28) {
/* 521 */               agg_isNull21 = false;
/* 522 */               agg_value24 = agg_value31;
/* 523 */             }
/* 524 */           }
/* 525 */           boolean agg_isNull30 = true;
/* 526 */           double agg_value33 = -1.0;
/* 527 */
/* 528 */           boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 529 */           double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 530 */           boolean agg_isNull31 = agg_isNull32;
/* 531 */           double agg_value34 = agg_value35;
/* 532 */           if (agg_isNull31) {
/* 533 */             boolean agg_isNull33 = false;
/* 534 */             double agg_value36 = -1.0;
/* 535 */             if (!false) {
/* 536 */               agg_value36 = (double) 0;
/* 537 */             }
/* 538 */             if (!agg_isNull33) {
/* 539 */               agg_isNull31 = false;
/* 540 */               agg_value34 = agg_value36;
/* 541 */             }
/* 542 */           }
/* 543 */
/* 544 */           if (!inputadapter_isNull2) {
/* 545 */             agg_isNull30 = false; // resultCode could change nullability.
/* 546 */             agg_value33 = agg_value34 + inputadapter_value2;
/* 547 */
/* 548 */           }
/* 549 */           boolean agg_isNull29 = agg_isNull30;
/* 550 */           double agg_value32 = agg_value33;
/* 551 */           if (agg_isNull29) {
/* 552 */             boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 553 */             double agg_value39 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 554 */             if (!agg_isNull36) {
/* 555 */               agg_isNull29 = false;
/* 556 */               agg_value32 = agg_value39;
/* 557 */             }
/* 558 */           }
/* 559 */           // update unsafe row buffer
/* 560 */           if (!agg_isNull13) {
/* 561 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value16);
/* 562 */           } else {
/* 563 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 564 */           }
/* 565 */
/* 566 */           if (!agg_isNull21) {
/* 567 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value24);
/* 568 */           } else {
/* 569 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 570 */           }
/* 571 */
/* 572 */           if (!agg_isNull29) {
/* 573 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value32);
/* 574 */           } else {
/* 575 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 576 */           }
/* 577 */
/* 578 */         }
/* 579 */
/* 580 */       }
/* 581 */       if (shouldStop()) return;
/* 582 */     }
/* 583 */
/* 584 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 585 */
/* 586 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 587 */   }
/* 588 */
/* 589 */   private void wholestagecodegen_init_1() {
/* 590 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 591 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 592 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 593 */
/* 594 */   }
/* 595 */
/* 596 */   protected void processNext() throws java.io.IOException {
/* 597 */     if (!agg_initAgg) {
/* 598 */       agg_initAgg = true;
/* 599 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 600 */       agg_doAggregateWithKeys();
/* 601 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 602 */     }
/* 603 */
/* 604 */     // output the result
/* 605 */
/* 606 */     while (agg_fastHashMapIter.next()) {
/* 607 */       wholestagecodegen_numOutputRows.add(1);
/* 608 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 609 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 610 */
/* 611 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 612 */
/* 613 */       append(agg_resultRow.copy());
/* 614 */
/* 615 */       if (shouldStop()) return;
/* 616 */     }
/* 617 */     agg_fastHashMap.close();
/* 618 */
/* 619 */     while (agg_mapIter.next()) {
/* 620 */       wholestagecodegen_numOutputRows.add(1);
/* 621 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 622 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 623 */
/* 624 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 625 */
/* 626 */       append(agg_resultRow.copy());
/* 627 */
/* 628 */       if (shouldStop()) return;
/* 629 */     }
/* 630 */
/* 631 */     agg_mapIter.close();
/* 632 */     if (agg_sorter == null) {
/* 633 */       agg_hashMap.free();
/* 634 */     }
/* 635 */   }
/* 636 */ }
