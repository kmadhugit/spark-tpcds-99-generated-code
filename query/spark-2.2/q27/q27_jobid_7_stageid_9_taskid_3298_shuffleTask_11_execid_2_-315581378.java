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
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private long agg_bufValue7;
/* 025 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 026 */   private agg_FastHashMap agg_fastHashMap;
/* 027 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 028 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 029 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 030 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 033 */   private scala.collection.Iterator inputadapter_input;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private UnsafeRow agg_result1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 040 */   private int agg_value19;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 044 */
/* 045 */   public GeneratedIterator(Object[] references) {
/* 046 */     this.references = references;
/* 047 */   }
/* 048 */
/* 049 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 050 */     partitionIndex = index;
/* 051 */     this.inputs = inputs;
/* 052 */     wholestagecodegen_init_0();
/* 053 */     wholestagecodegen_init_1();
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */   private void wholestagecodegen_init_0() {
/* 058 */     agg_initAgg = false;
/* 059 */
/* 060 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 061 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 062 */
/* 063 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 064 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 065 */     inputadapter_input = inputs[0];
/* 066 */     project_result = new UnsafeRow(2);
/* 067 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 068 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 069 */     agg_result1 = new UnsafeRow(1);
/* 070 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 071 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 072 */
/* 073 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 074 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   public class agg_FastHashMap {
/* 079 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 080 */     private int[] buckets;
/* 081 */     private int capacity = 1 << 16;
/* 082 */     private double loadFactor = 0.5;
/* 083 */     private int numBuckets = (int) (capacity / loadFactor);
/* 084 */     private int maxSteps = 2;
/* 085 */     private int numRows = 0;
/* 086 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 087 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 088 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 089 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 090 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType)
/* 091 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 092 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 093 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 094 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.LongType);
/* 095 */     private Object emptyVBase;
/* 096 */     private long emptyVOff;
/* 097 */     private int emptyVLen;
/* 098 */     private boolean isBatchFull = false;
/* 099 */
/* 100 */     public agg_FastHashMap(
/* 101 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 102 */       InternalRow emptyAggregationBuffer) {
/* 103 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 104 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 105 */
/* 106 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 107 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 108 */
/* 109 */       emptyVBase = emptyBuffer;
/* 110 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 111 */       emptyVLen = emptyBuffer.length;
/* 112 */
/* 113 */       buckets = new int[numBuckets];
/* 114 */       java.util.Arrays.fill(buckets, -1);
/* 115 */     }
/* 116 */
/* 117 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 118 */       long h = hash(agg_key);
/* 119 */       int step = 0;
/* 120 */       int idx = (int) h & (numBuckets - 1);
/* 121 */       while (step < maxSteps) {
/* 122 */         // Return bucket index if it's either an empty slot or already contains the key
/* 123 */         if (buckets[idx] == -1) {
/* 124 */           if (numRows < capacity && !isBatchFull) {
/* 125 */             // creating the unsafe for new entry
/* 126 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 127 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 128 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 129 */               32);
/* 130 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 131 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 132 */               agg_holder,
/* 133 */               1);
/* 134 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 135 */             agg_rowWriter.zeroOutNullBytes();
/* 136 */             agg_rowWriter.write(0, agg_key);
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
/* 154 */         } else if (equals(idx, agg_key)) {
/* 155 */           return batch.getValueRow(buckets[idx]);
/* 156 */         }
/* 157 */         idx = (idx + 1) & (numBuckets - 1);
/* 158 */         step++;
/* 159 */       }
/* 160 */       // Didn't find it
/* 161 */       return null;
/* 162 */     }
/* 163 */
/* 164 */     private boolean equals(int idx, UTF8String agg_key) {
/* 165 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 166 */       return (row.getUTF8String(0).equals(agg_key));
/* 167 */     }
/* 168 */
/* 169 */     private long hash(UTF8String agg_key) {
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
/* 200 */       InternalRow inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getStruct(0, 16));
/* 201 */
/* 202 */       boolean project_isNull = inputadapter_isNull;
/* 203 */       UTF8String project_value = null;
/* 204 */
/* 205 */       if (!inputadapter_isNull) {
/* 206 */         if (inputadapter_value.isNullAt(0)) {
/* 207 */           project_isNull = true;
/* 208 */         } else {
/* 209 */           project_value = inputadapter_value.getUTF8String(0);
/* 210 */         }
/* 211 */
/* 212 */       }
/* 213 */       boolean project_isNull2 = inputadapter_isNull;
/* 214 */       double project_value2 = -1.0;
/* 215 */
/* 216 */       if (!inputadapter_isNull) {
/* 217 */         if (inputadapter_value.isNullAt(9)) {
/* 218 */           project_isNull2 = true;
/* 219 */         } else {
/* 220 */           project_value2 = inputadapter_value.getDouble(9);
/* 221 */         }
/* 222 */
/* 223 */       }
/* 224 */
/* 225 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 226 */
/* 227 */       UnsafeRow agg_fastAggBuffer = null;
/* 228 */
/* 229 */       if (true) {
/* 230 */         if (!project_isNull) {
/* 231 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 232 */             project_value);
/* 233 */         }
/* 234 */       }
/* 235 */
/* 236 */       if (agg_fastAggBuffer == null) {
/* 237 */         // generate grouping key
/* 238 */         agg_holder.reset();
/* 239 */
/* 240 */         agg_rowWriter.zeroOutNullBytes();
/* 241 */
/* 242 */         if (project_isNull) {
/* 243 */           agg_rowWriter.setNullAt(0);
/* 244 */         } else {
/* 245 */           agg_rowWriter.write(0, project_value);
/* 246 */         }
/* 247 */         agg_result1.setTotalSize(agg_holder.totalSize());
/* 248 */         agg_value19 = 42;
/* 249 */
/* 250 */         if (!project_isNull) {
/* 251 */           agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(project_value.getBaseObject(), project_value.getBaseOffset(), project_value.numBytes(), agg_value19);
/* 252 */         }
/* 253 */         if (true) {
/* 254 */           // try to get the buffer from hash map
/* 255 */           agg_unsafeRowAggBuffer =
/* 256 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value19);
/* 257 */         }
/* 258 */         if (agg_unsafeRowAggBuffer == null) {
/* 259 */           if (agg_sorter == null) {
/* 260 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 261 */           } else {
/* 262 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 263 */           }
/* 264 */
/* 265 */           // the hash map had be spilled, it should have enough memory now,
/* 266 */           // try  to allocate buffer again.
/* 267 */           agg_unsafeRowAggBuffer =
/* 268 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value19);
/* 269 */           if (agg_unsafeRowAggBuffer == null) {
/* 270 */             // failed to allocate the first page
/* 271 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 272 */           }
/* 273 */         }
/* 274 */       }
/* 275 */
/* 276 */       if (agg_fastAggBuffer != null) {
/* 277 */         // update fast row
/* 278 */
/* 279 */         // common sub-expressions
/* 280 */
/* 281 */         // evaluate aggregate function
/* 282 */         boolean agg_isNull75 = agg_fastAggBuffer.isNullAt(0);
/* 283 */         double agg_value83 = agg_isNull75 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 284 */         boolean agg_isNull74 = agg_isNull75;
/* 285 */         double agg_value82 = agg_value83;
/* 286 */
/* 287 */         if (!project_isNull2 && (agg_isNull74 ||
/* 288 */             (org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value82, project_value2)) > 0)) {
/* 289 */           agg_isNull74 = false;
/* 290 */           agg_value82 = project_value2;
/* 291 */         }
/* 292 */         boolean agg_isNull78 = agg_fastAggBuffer.isNullAt(1);
/* 293 */         double agg_value86 = agg_isNull78 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 294 */         boolean agg_isNull77 = agg_isNull78;
/* 295 */         double agg_value85 = agg_value86;
/* 296 */
/* 297 */         if (!project_isNull2 && (agg_isNull77 ||
/* 298 */             (org.apache.spark.util.Utils.nanSafeCompareDoubles(project_value2, agg_value85)) > 0)) {
/* 299 */           agg_isNull77 = false;
/* 300 */           agg_value85 = project_value2;
/* 301 */         }
/* 302 */         boolean agg_isNull80 = true;
/* 303 */         double agg_value88 = -1.0;
/* 304 */
/* 305 */         boolean agg_isNull81 = agg_fastAggBuffer.isNullAt(2);
/* 306 */         double agg_value89 = agg_isNull81 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 307 */         if (!agg_isNull81) {
/* 308 */           boolean agg_isNull82 = project_isNull2;
/* 309 */           double agg_value90 = project_value2;
/* 310 */           if (agg_isNull82) {
/* 311 */             boolean agg_isNull84 = false;
/* 312 */             double agg_value92 = -1.0;
/* 313 */             if (!false) {
/* 314 */               agg_value92 = (double) 0;
/* 315 */             }
/* 316 */             if (!agg_isNull84) {
/* 317 */               agg_isNull82 = false;
/* 318 */               agg_value90 = agg_value92;
/* 319 */             }
/* 320 */           }
/* 321 */
/* 322 */           agg_isNull80 = false; // resultCode could change nullability.
/* 323 */           agg_value88 = agg_value89 + agg_value90;
/* 324 */
/* 325 */         }
/* 326 */         boolean agg_isNull86 = false;
/* 327 */         long agg_value94 = -1L;
/* 328 */         if (!false && project_isNull2) {
/* 329 */           boolean agg_isNull87 = agg_fastAggBuffer.isNullAt(3);
/* 330 */           long agg_value95 = agg_isNull87 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 331 */           agg_isNull86 = agg_isNull87;
/* 332 */           agg_value94 = agg_value95;
/* 333 */         } else {
/* 334 */           boolean agg_isNull88 = true;
/* 335 */           long agg_value96 = -1L;
/* 336 */
/* 337 */           boolean agg_isNull89 = agg_fastAggBuffer.isNullAt(3);
/* 338 */           long agg_value97 = agg_isNull89 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 339 */           if (!agg_isNull89) {
/* 340 */             agg_isNull88 = false; // resultCode could change nullability.
/* 341 */             agg_value96 = agg_value97 + 1L;
/* 342 */
/* 343 */           }
/* 344 */           agg_isNull86 = agg_isNull88;
/* 345 */           agg_value94 = agg_value96;
/* 346 */         }
/* 347 */         boolean agg_isNull91 = false;
/* 348 */         double agg_value99 = -1.0;
/* 349 */         if (!false && project_isNull2) {
/* 350 */           double agg_value100 = agg_fastAggBuffer.getDouble(4);
/* 351 */           agg_isNull91 = false;
/* 352 */           agg_value99 = agg_value100;
/* 353 */         } else {
/* 354 */           boolean agg_isNull93 = false;
/* 355 */
/* 356 */           double agg_value102 = agg_fastAggBuffer.getDouble(4);
/* 357 */
/* 358 */           double agg_value101 = -1.0;
/* 359 */           agg_value101 = agg_value102 + 1.0D;
/* 360 */           agg_isNull91 = false;
/* 361 */           agg_value99 = agg_value101;
/* 362 */         }
/* 363 */         boolean agg_isNull96 = false;
/* 364 */         double agg_value104 = -1.0;
/* 365 */         if (!false && project_isNull2) {
/* 366 */           double agg_value105 = agg_fastAggBuffer.getDouble(5);
/* 367 */           agg_isNull96 = false;
/* 368 */           agg_value104 = agg_value105;
/* 369 */         } else {
/* 370 */           boolean agg_isNull98 = true;
/* 371 */           double agg_value106 = -1.0;
/* 372 */
/* 373 */           double agg_value107 = agg_fastAggBuffer.getDouble(5);
/* 374 */
/* 375 */           boolean agg_isNull104 = false;
/* 376 */
/* 377 */           double agg_value113 = agg_fastAggBuffer.getDouble(4);
/* 378 */
/* 379 */           double agg_value112 = -1.0;
/* 380 */           agg_value112 = agg_value113 + 1.0D;
/* 381 */           boolean agg_isNull100 = false;
/* 382 */           double agg_value108 = -1.0;
/* 383 */           if (false || agg_value112 == 0) {
/* 384 */             agg_isNull100 = true;
/* 385 */           } else {
/* 386 */             boolean agg_isNull101 = true;
/* 387 */             double agg_value109 = -1.0;
/* 388 */
/* 389 */             if (!project_isNull2) {
/* 390 */               double agg_value111 = agg_fastAggBuffer.getDouble(5);
/* 391 */
/* 392 */               agg_isNull101 = false; // resultCode could change nullability.
/* 393 */               agg_value109 = project_value2 - agg_value111;
/* 394 */
/* 395 */             }
/* 396 */             if (agg_isNull101) {
/* 397 */               agg_isNull100 = true;
/* 398 */             } else {
/* 399 */               agg_value108 = (double)(agg_value109 / agg_value112);
/* 400 */             }
/* 401 */           }
/* 402 */           if (!agg_isNull100) {
/* 403 */             agg_isNull98 = false; // resultCode could change nullability.
/* 404 */             agg_value106 = agg_value107 + agg_value108;
/* 405 */
/* 406 */           }
/* 407 */           agg_isNull96 = agg_isNull98;
/* 408 */           agg_value104 = agg_value106;
/* 409 */         }
/* 410 */         boolean agg_isNull107 = false;
/* 411 */         double agg_value115 = -1.0;
/* 412 */         if (!false && project_isNull2) {
/* 413 */           double agg_value116 = agg_fastAggBuffer.getDouble(6);
/* 414 */           agg_isNull107 = false;
/* 415 */           agg_value115 = agg_value116;
/* 416 */         } else {
/* 417 */           boolean agg_isNull109 = true;
/* 418 */           double agg_value117 = -1.0;
/* 419 */
/* 420 */           double agg_value118 = agg_fastAggBuffer.getDouble(6);
/* 421 */
/* 422 */           boolean agg_isNull111 = true;
/* 423 */           double agg_value119 = -1.0;
/* 424 */
/* 425 */           boolean agg_isNull112 = true;
/* 426 */           double agg_value120 = -1.0;
/* 427 */
/* 428 */           if (!project_isNull2) {
/* 429 */             double agg_value122 = agg_fastAggBuffer.getDouble(5);
/* 430 */
/* 431 */             agg_isNull112 = false; // resultCode could change nullability.
/* 432 */             agg_value120 = project_value2 - agg_value122;
/* 433 */
/* 434 */           }
/* 435 */           if (!agg_isNull112) {
/* 436 */             boolean agg_isNull115 = true;
/* 437 */             double agg_value123 = -1.0;
/* 438 */
/* 439 */             boolean agg_isNull116 = true;
/* 440 */             double agg_value124 = -1.0;
/* 441 */
/* 442 */             if (!project_isNull2) {
/* 443 */               double agg_value126 = agg_fastAggBuffer.getDouble(5);
/* 444 */
/* 445 */               agg_isNull116 = false; // resultCode could change nullability.
/* 446 */               agg_value124 = project_value2 - agg_value126;
/* 447 */
/* 448 */             }
/* 449 */             if (!agg_isNull116) {
/* 450 */               boolean agg_isNull123 = false;
/* 451 */
/* 452 */               double agg_value132 = agg_fastAggBuffer.getDouble(4);
/* 453 */
/* 454 */               double agg_value131 = -1.0;
/* 455 */               agg_value131 = agg_value132 + 1.0D;
/* 456 */               boolean agg_isNull119 = false;
/* 457 */               double agg_value127 = -1.0;
/* 458 */               if (false || agg_value131 == 0) {
/* 459 */                 agg_isNull119 = true;
/* 460 */               } else {
/* 461 */                 boolean agg_isNull120 = true;
/* 462 */                 double agg_value128 = -1.0;
/* 463 */
/* 464 */                 if (!project_isNull2) {
/* 465 */                   double agg_value130 = agg_fastAggBuffer.getDouble(5);
/* 466 */
/* 467 */                   agg_isNull120 = false; // resultCode could change nullability.
/* 468 */                   agg_value128 = project_value2 - agg_value130;
/* 469 */
/* 470 */                 }
/* 471 */                 if (agg_isNull120) {
/* 472 */                   agg_isNull119 = true;
/* 473 */                 } else {
/* 474 */                   agg_value127 = (double)(agg_value128 / agg_value131);
/* 475 */                 }
/* 476 */               }
/* 477 */               if (!agg_isNull119) {
/* 478 */                 agg_isNull115 = false; // resultCode could change nullability.
/* 479 */                 agg_value123 = agg_value124 - agg_value127;
/* 480 */
/* 481 */               }
/* 482 */
/* 483 */             }
/* 484 */             if (!agg_isNull115) {
/* 485 */               agg_isNull111 = false; // resultCode could change nullability.
/* 486 */               agg_value119 = agg_value120 * agg_value123;
/* 487 */
/* 488 */             }
/* 489 */
/* 490 */           }
/* 491 */           if (!agg_isNull111) {
/* 492 */             agg_isNull109 = false; // resultCode could change nullability.
/* 493 */             agg_value117 = agg_value118 + agg_value119;
/* 494 */
/* 495 */           }
/* 496 */           agg_isNull107 = agg_isNull109;
/* 497 */           agg_value115 = agg_value117;
/* 498 */         }
/* 499 */         boolean agg_isNull126 = false;
/* 500 */         long agg_value134 = -1L;
/* 501 */         if (!false && project_isNull2) {
/* 502 */           long agg_value135 = agg_fastAggBuffer.getLong(7);
/* 503 */           agg_isNull126 = false;
/* 504 */           agg_value134 = agg_value135;
/* 505 */         } else {
/* 506 */           boolean agg_isNull128 = false;
/* 507 */
/* 508 */           long agg_value137 = agg_fastAggBuffer.getLong(7);
/* 509 */
/* 510 */           long agg_value136 = -1L;
/* 511 */           agg_value136 = agg_value137 + 1L;
/* 512 */           agg_isNull126 = false;
/* 513 */           agg_value134 = agg_value136;
/* 514 */         }
/* 515 */         // update fast row
/* 516 */         if (!agg_isNull74) {
/* 517 */           agg_fastAggBuffer.setDouble(0, agg_value82);
/* 518 */         } else {
/* 519 */           agg_fastAggBuffer.setNullAt(0);
/* 520 */         }
/* 521 */
/* 522 */         if (!agg_isNull77) {
/* 523 */           agg_fastAggBuffer.setDouble(1, agg_value85);
/* 524 */         } else {
/* 525 */           agg_fastAggBuffer.setNullAt(1);
/* 526 */         }
/* 527 */
/* 528 */         if (!agg_isNull80) {
/* 529 */           agg_fastAggBuffer.setDouble(2, agg_value88);
/* 530 */         } else {
/* 531 */           agg_fastAggBuffer.setNullAt(2);
/* 532 */         }
/* 533 */
/* 534 */         if (!agg_isNull86) {
/* 535 */           agg_fastAggBuffer.setLong(3, agg_value94);
/* 536 */         } else {
/* 537 */           agg_fastAggBuffer.setNullAt(3);
/* 538 */         }
/* 539 */
/* 540 */         agg_fastAggBuffer.setDouble(4, agg_value99);
/* 541 */
/* 542 */         if (!agg_isNull96) {
/* 543 */           agg_fastAggBuffer.setDouble(5, agg_value104);
/* 544 */         } else {
/* 545 */           agg_fastAggBuffer.setNullAt(5);
/* 546 */         }
/* 547 */
/* 548 */         if (!agg_isNull107) {
/* 549 */           agg_fastAggBuffer.setDouble(6, agg_value115);
/* 550 */         } else {
/* 551 */           agg_fastAggBuffer.setNullAt(6);
/* 552 */         }
/* 553 */
/* 554 */         agg_fastAggBuffer.setLong(7, agg_value134);
/* 555 */
/* 556 */       } else {
/* 557 */         // update unsafe row
/* 558 */
/* 559 */         // common sub-expressions
/* 560 */
/* 561 */         // evaluate aggregate function
/* 562 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 563 */         double agg_value24 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 564 */         boolean agg_isNull15 = agg_isNull16;
/* 565 */         double agg_value23 = agg_value24;
/* 566 */
/* 567 */         if (!project_isNull2 && (agg_isNull15 ||
/* 568 */             (org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value23, project_value2)) > 0)) {
/* 569 */           agg_isNull15 = false;
/* 570 */           agg_value23 = project_value2;
/* 571 */         }
/* 572 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 573 */         double agg_value27 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 574 */         boolean agg_isNull18 = agg_isNull19;
/* 575 */         double agg_value26 = agg_value27;
/* 576 */
/* 577 */         if (!project_isNull2 && (agg_isNull18 ||
/* 578 */             (org.apache.spark.util.Utils.nanSafeCompareDoubles(project_value2, agg_value26)) > 0)) {
/* 579 */           agg_isNull18 = false;
/* 580 */           agg_value26 = project_value2;
/* 581 */         }
/* 582 */         boolean agg_isNull21 = true;
/* 583 */         double agg_value29 = -1.0;
/* 584 */
/* 585 */         boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 586 */         double agg_value30 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 587 */         if (!agg_isNull22) {
/* 588 */           boolean agg_isNull23 = project_isNull2;
/* 589 */           double agg_value31 = project_value2;
/* 590 */           if (agg_isNull23) {
/* 591 */             boolean agg_isNull25 = false;
/* 592 */             double agg_value33 = -1.0;
/* 593 */             if (!false) {
/* 594 */               agg_value33 = (double) 0;
/* 595 */             }
/* 596 */             if (!agg_isNull25) {
/* 597 */               agg_isNull23 = false;
/* 598 */               agg_value31 = agg_value33;
/* 599 */             }
/* 600 */           }
/* 601 */
/* 602 */           agg_isNull21 = false; // resultCode could change nullability.
/* 603 */           agg_value29 = agg_value30 + agg_value31;
/* 604 */
/* 605 */         }
/* 606 */         boolean agg_isNull27 = false;
/* 607 */         long agg_value35 = -1L;
/* 608 */         if (!false && project_isNull2) {
/* 609 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 610 */           long agg_value36 = agg_isNull28 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 611 */           agg_isNull27 = agg_isNull28;
/* 612 */           agg_value35 = agg_value36;
/* 613 */         } else {
/* 614 */           boolean agg_isNull29 = true;
/* 615 */           long agg_value37 = -1L;
/* 616 */
/* 617 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 618 */           long agg_value38 = agg_isNull30 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 619 */           if (!agg_isNull30) {
/* 620 */             agg_isNull29 = false; // resultCode could change nullability.
/* 621 */             agg_value37 = agg_value38 + 1L;
/* 622 */
/* 623 */           }
/* 624 */           agg_isNull27 = agg_isNull29;
/* 625 */           agg_value35 = agg_value37;
/* 626 */         }
/* 627 */         boolean agg_isNull32 = false;
/* 628 */         double agg_value40 = -1.0;
/* 629 */         if (!false && project_isNull2) {
/* 630 */           double agg_value41 = agg_unsafeRowAggBuffer.getDouble(4);
/* 631 */           agg_isNull32 = false;
/* 632 */           agg_value40 = agg_value41;
/* 633 */         } else {
/* 634 */           boolean agg_isNull34 = false;
/* 635 */
/* 636 */           double agg_value43 = agg_unsafeRowAggBuffer.getDouble(4);
/* 637 */
/* 638 */           double agg_value42 = -1.0;
/* 639 */           agg_value42 = agg_value43 + 1.0D;
/* 640 */           agg_isNull32 = false;
/* 641 */           agg_value40 = agg_value42;
/* 642 */         }
/* 643 */         boolean agg_isNull37 = false;
/* 644 */         double agg_value45 = -1.0;
/* 645 */         if (!false && project_isNull2) {
/* 646 */           double agg_value46 = agg_unsafeRowAggBuffer.getDouble(5);
/* 647 */           agg_isNull37 = false;
/* 648 */           agg_value45 = agg_value46;
/* 649 */         } else {
/* 650 */           boolean agg_isNull39 = true;
/* 651 */           double agg_value47 = -1.0;
/* 652 */
/* 653 */           double agg_value48 = agg_unsafeRowAggBuffer.getDouble(5);
/* 654 */
/* 655 */           boolean agg_isNull45 = false;
/* 656 */
/* 657 */           double agg_value54 = agg_unsafeRowAggBuffer.getDouble(4);
/* 658 */
/* 659 */           double agg_value53 = -1.0;
/* 660 */           agg_value53 = agg_value54 + 1.0D;
/* 661 */           boolean agg_isNull41 = false;
/* 662 */           double agg_value49 = -1.0;
/* 663 */           if (false || agg_value53 == 0) {
/* 664 */             agg_isNull41 = true;
/* 665 */           } else {
/* 666 */             boolean agg_isNull42 = true;
/* 667 */             double agg_value50 = -1.0;
/* 668 */
/* 669 */             if (!project_isNull2) {
/* 670 */               double agg_value52 = agg_unsafeRowAggBuffer.getDouble(5);
/* 671 */
/* 672 */               agg_isNull42 = false; // resultCode could change nullability.
/* 673 */               agg_value50 = project_value2 - agg_value52;
/* 674 */
/* 675 */             }
/* 676 */             if (agg_isNull42) {
/* 677 */               agg_isNull41 = true;
/* 678 */             } else {
/* 679 */               agg_value49 = (double)(agg_value50 / agg_value53);
/* 680 */             }
/* 681 */           }
/* 682 */           if (!agg_isNull41) {
/* 683 */             agg_isNull39 = false; // resultCode could change nullability.
/* 684 */             agg_value47 = agg_value48 + agg_value49;
/* 685 */
/* 686 */           }
/* 687 */           agg_isNull37 = agg_isNull39;
/* 688 */           agg_value45 = agg_value47;
/* 689 */         }
/* 690 */         boolean agg_isNull48 = false;
/* 691 */         double agg_value56 = -1.0;
/* 692 */         if (!false && project_isNull2) {
/* 693 */           double agg_value57 = agg_unsafeRowAggBuffer.getDouble(6);
/* 694 */           agg_isNull48 = false;
/* 695 */           agg_value56 = agg_value57;
/* 696 */         } else {
/* 697 */           boolean agg_isNull50 = true;
/* 698 */           double agg_value58 = -1.0;
/* 699 */
/* 700 */           double agg_value59 = agg_unsafeRowAggBuffer.getDouble(6);
/* 701 */
/* 702 */           boolean agg_isNull52 = true;
/* 703 */           double agg_value60 = -1.0;
/* 704 */
/* 705 */           boolean agg_isNull53 = true;
/* 706 */           double agg_value61 = -1.0;
/* 707 */
/* 708 */           if (!project_isNull2) {
/* 709 */             double agg_value63 = agg_unsafeRowAggBuffer.getDouble(5);
/* 710 */
/* 711 */             agg_isNull53 = false; // resultCode could change nullability.
/* 712 */             agg_value61 = project_value2 - agg_value63;
/* 713 */
/* 714 */           }
/* 715 */           if (!agg_isNull53) {
/* 716 */             boolean agg_isNull56 = true;
/* 717 */             double agg_value64 = -1.0;
/* 718 */
/* 719 */             boolean agg_isNull57 = true;
/* 720 */             double agg_value65 = -1.0;
/* 721 */
/* 722 */             if (!project_isNull2) {
/* 723 */               double agg_value67 = agg_unsafeRowAggBuffer.getDouble(5);
/* 724 */
/* 725 */               agg_isNull57 = false; // resultCode could change nullability.
/* 726 */               agg_value65 = project_value2 - agg_value67;
/* 727 */
/* 728 */             }
/* 729 */             if (!agg_isNull57) {
/* 730 */               boolean agg_isNull64 = false;
/* 731 */
/* 732 */               double agg_value73 = agg_unsafeRowAggBuffer.getDouble(4);
/* 733 */
/* 734 */               double agg_value72 = -1.0;
/* 735 */               agg_value72 = agg_value73 + 1.0D;
/* 736 */               boolean agg_isNull60 = false;
/* 737 */               double agg_value68 = -1.0;
/* 738 */               if (false || agg_value72 == 0) {
/* 739 */                 agg_isNull60 = true;
/* 740 */               } else {
/* 741 */                 boolean agg_isNull61 = true;
/* 742 */                 double agg_value69 = -1.0;
/* 743 */
/* 744 */                 if (!project_isNull2) {
/* 745 */                   double agg_value71 = agg_unsafeRowAggBuffer.getDouble(5);
/* 746 */
/* 747 */                   agg_isNull61 = false; // resultCode could change nullability.
/* 748 */                   agg_value69 = project_value2 - agg_value71;
/* 749 */
/* 750 */                 }
/* 751 */                 if (agg_isNull61) {
/* 752 */                   agg_isNull60 = true;
/* 753 */                 } else {
/* 754 */                   agg_value68 = (double)(agg_value69 / agg_value72);
/* 755 */                 }
/* 756 */               }
/* 757 */               if (!agg_isNull60) {
/* 758 */                 agg_isNull56 = false; // resultCode could change nullability.
/* 759 */                 agg_value64 = agg_value65 - agg_value68;
/* 760 */
/* 761 */               }
/* 762 */
/* 763 */             }
/* 764 */             if (!agg_isNull56) {
/* 765 */               agg_isNull52 = false; // resultCode could change nullability.
/* 766 */               agg_value60 = agg_value61 * agg_value64;
/* 767 */
/* 768 */             }
/* 769 */
/* 770 */           }
/* 771 */           if (!agg_isNull52) {
/* 772 */             agg_isNull50 = false; // resultCode could change nullability.
/* 773 */             agg_value58 = agg_value59 + agg_value60;
/* 774 */
/* 775 */           }
/* 776 */           agg_isNull48 = agg_isNull50;
/* 777 */           agg_value56 = agg_value58;
/* 778 */         }
/* 779 */         boolean agg_isNull67 = false;
/* 780 */         long agg_value75 = -1L;
/* 781 */         if (!false && project_isNull2) {
/* 782 */           long agg_value76 = agg_unsafeRowAggBuffer.getLong(7);
/* 783 */           agg_isNull67 = false;
/* 784 */           agg_value75 = agg_value76;
/* 785 */         } else {
/* 786 */           boolean agg_isNull69 = false;
/* 787 */
/* 788 */           long agg_value78 = agg_unsafeRowAggBuffer.getLong(7);
/* 789 */
/* 790 */           long agg_value77 = -1L;
/* 791 */           agg_value77 = agg_value78 + 1L;
/* 792 */           agg_isNull67 = false;
/* 793 */           agg_value75 = agg_value77;
/* 794 */         }
/* 795 */         // update unsafe row buffer
/* 796 */         if (!agg_isNull15) {
/* 797 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value23);
/* 798 */         } else {
/* 799 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 800 */         }
/* 801 */
/* 802 */         if (!agg_isNull18) {
/* 803 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value26);
/* 804 */         } else {
/* 805 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 806 */         }
/* 807 */
/* 808 */         if (!agg_isNull21) {
/* 809 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value29);
/* 810 */         } else {
/* 811 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 812 */         }
/* 813 */
/* 814 */         if (!agg_isNull27) {
/* 815 */           agg_unsafeRowAggBuffer.setLong(3, agg_value35);
/* 816 */         } else {
/* 817 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 818 */         }
/* 819 */
/* 820 */         agg_unsafeRowAggBuffer.setDouble(4, agg_value40);
/* 821 */
/* 822 */         if (!agg_isNull37) {
/* 823 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value45);
/* 824 */         } else {
/* 825 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 826 */         }
/* 827 */
/* 828 */         if (!agg_isNull48) {
/* 829 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value56);
/* 830 */         } else {
/* 831 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 832 */         }
/* 833 */
/* 834 */         agg_unsafeRowAggBuffer.setLong(7, agg_value75);
/* 835 */
/* 836 */       }
/* 837 */       if (shouldStop()) return;
/* 838 */     }
/* 839 */
/* 840 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 841 */
/* 842 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 843 */   }
/* 844 */
/* 845 */   private void wholestagecodegen_init_1() {
/* 846 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 847 */
/* 848 */   }
/* 849 */
/* 850 */   protected void processNext() throws java.io.IOException {
/* 851 */     if (!agg_initAgg) {
/* 852 */       agg_initAgg = true;
/* 853 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 854 */       agg_doAggregateWithKeys();
/* 855 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 856 */     }
/* 857 */
/* 858 */     // output the result
/* 859 */
/* 860 */     while (agg_fastHashMapIter.next()) {
/* 861 */       wholestagecodegen_numOutputRows.add(1);
/* 862 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 863 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 864 */
/* 865 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 866 */
/* 867 */       append(agg_resultRow);
/* 868 */
/* 869 */       if (shouldStop()) return;
/* 870 */     }
/* 871 */     agg_fastHashMap.close();
/* 872 */
/* 873 */     while (agg_mapIter.next()) {
/* 874 */       wholestagecodegen_numOutputRows.add(1);
/* 875 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 876 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 877 */
/* 878 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 879 */
/* 880 */       append(agg_resultRow);
/* 881 */
/* 882 */       if (shouldStop()) return;
/* 883 */     }
/* 884 */
/* 885 */     agg_mapIter.close();
/* 886 */     if (agg_sorter == null) {
/* 887 */       agg_hashMap.free();
/* 888 */     }
/* 889 */   }
/* 890 */ }
