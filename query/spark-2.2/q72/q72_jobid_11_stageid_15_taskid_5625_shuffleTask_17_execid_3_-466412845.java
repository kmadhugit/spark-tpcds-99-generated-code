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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private agg_FastHashMap agg_fastHashMap;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */   private UnsafeRow agg_result3;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 030 */   private int agg_value12;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 034 */
/* 035 */   public GeneratedIterator(Object[] references) {
/* 036 */     this.references = references;
/* 037 */   }
/* 038 */
/* 039 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 040 */     partitionIndex = index;
/* 041 */     this.inputs = inputs;
/* 042 */     wholestagecodegen_init_0();
/* 043 */     wholestagecodegen_init_1();
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */   private void wholestagecodegen_init_0() {
/* 048 */     agg_initAgg = false;
/* 049 */
/* 050 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 051 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 052 */
/* 053 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 054 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 055 */     inputadapter_input = inputs[0];
/* 056 */     project_result = new UnsafeRow(3);
/* 057 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 058 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 059 */     agg_result3 = new UnsafeRow(3);
/* 060 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 64);
/* 061 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 062 */
/* 063 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 064 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   public class agg_FastHashMap {
/* 069 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 070 */     private int[] buckets;
/* 071 */     private int capacity = 1 << 16;
/* 072 */     private double loadFactor = 0.5;
/* 073 */     private int numBuckets = (int) (capacity / loadFactor);
/* 074 */     private int maxSteps = 2;
/* 075 */     private int numRows = 0;
/* 076 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 077 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 078 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 079 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.LongType)
/* 080 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType)
/* 081 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.LongType);
/* 082 */     private Object emptyVBase;
/* 083 */     private long emptyVOff;
/* 084 */     private int emptyVLen;
/* 085 */     private boolean isBatchFull = false;
/* 086 */
/* 087 */     public agg_FastHashMap(
/* 088 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 089 */       InternalRow emptyAggregationBuffer) {
/* 090 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 091 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 092 */
/* 093 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 094 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 095 */
/* 096 */       emptyVBase = emptyBuffer;
/* 097 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 098 */       emptyVLen = emptyBuffer.length;
/* 099 */
/* 100 */       buckets = new int[numBuckets];
/* 101 */       java.util.Arrays.fill(buckets, -1);
/* 102 */     }
/* 103 */
/* 104 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 105 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 106 */       int step = 0;
/* 107 */       int idx = (int) h & (numBuckets - 1);
/* 108 */       while (step < maxSteps) {
/* 109 */         // Return bucket index if it's either an empty slot or already contains the key
/* 110 */         if (buckets[idx] == -1) {
/* 111 */           if (numRows < capacity && !isBatchFull) {
/* 112 */             // creating the unsafe for new entry
/* 113 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 114 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 115 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 116 */               64);
/* 117 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 118 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 119 */               agg_holder,
/* 120 */               3);
/* 121 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 122 */             agg_rowWriter.zeroOutNullBytes();
/* 123 */             agg_rowWriter.write(0, agg_key);
/* 124 */             agg_rowWriter.write(1, agg_key1);
/* 125 */             agg_rowWriter.write(2, agg_key2);
/* 126 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 127 */             Object kbase = agg_result.getBaseObject();
/* 128 */             long koff = agg_result.getBaseOffset();
/* 129 */             int klen = agg_result.getSizeInBytes();
/* 130 */
/* 131 */             UnsafeRow vRow
/* 132 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 133 */             if (vRow == null) {
/* 134 */               isBatchFull = true;
/* 135 */             } else {
/* 136 */               buckets[idx] = numRows++;
/* 137 */             }
/* 138 */             return vRow;
/* 139 */           } else {
/* 140 */             // No more space
/* 141 */             return null;
/* 142 */           }
/* 143 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 144 */           return batch.getValueRow(buckets[idx]);
/* 145 */         }
/* 146 */         idx = (idx + 1) & (numBuckets - 1);
/* 147 */         step++;
/* 148 */       }
/* 149 */       // Didn't find it
/* 150 */       return null;
/* 151 */     }
/* 152 */
/* 153 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 154 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 155 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getInt(2) == agg_key2);
/* 156 */     }
/* 157 */
/* 158 */     private long hash(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 159 */       long agg_hash = 0;
/* 160 */
/* 161 */       int agg_result = 0;
/* 162 */       byte[] agg_bytes = agg_key.getBytes();
/* 163 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 164 */         int agg_hash1 = agg_bytes[i];
/* 165 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 166 */       }
/* 167 */
/* 168 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 169 */
/* 170 */       int agg_result1 = 0;
/* 171 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 172 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 173 */         int agg_hash2 = agg_bytes1[i];
/* 174 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 175 */       }
/* 176 */
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
/* 200 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 201 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 202 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 203 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 204 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 205 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 206 */
/* 207 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 208 */
/* 209 */       UnsafeRow agg_fastAggBuffer = null;
/* 210 */
/* 211 */       if (true) {
/* 212 */         if (!inputadapter_isNull3 && !inputadapter_isNull2 && !inputadapter_isNull4) {
/* 213 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 214 */             inputadapter_value3, inputadapter_value2, inputadapter_value4);
/* 215 */         }
/* 216 */       }
/* 217 */
/* 218 */       if (agg_fastAggBuffer == null) {
/* 219 */         // generate grouping key
/* 220 */         agg_holder.reset();
/* 221 */
/* 222 */         agg_rowWriter.zeroOutNullBytes();
/* 223 */
/* 224 */         if (inputadapter_isNull3) {
/* 225 */           agg_rowWriter.setNullAt(0);
/* 226 */         } else {
/* 227 */           agg_rowWriter.write(0, inputadapter_value3);
/* 228 */         }
/* 229 */
/* 230 */         if (inputadapter_isNull2) {
/* 231 */           agg_rowWriter.setNullAt(1);
/* 232 */         } else {
/* 233 */           agg_rowWriter.write(1, inputadapter_value2);
/* 234 */         }
/* 235 */
/* 236 */         if (inputadapter_isNull4) {
/* 237 */           agg_rowWriter.setNullAt(2);
/* 238 */         } else {
/* 239 */           agg_rowWriter.write(2, inputadapter_value4);
/* 240 */         }
/* 241 */         agg_result3.setTotalSize(agg_holder.totalSize());
/* 242 */         agg_value12 = 42;
/* 243 */
/* 244 */         if (!inputadapter_isNull3) {
/* 245 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value12);
/* 246 */         }
/* 247 */
/* 248 */         if (!inputadapter_isNull2) {
/* 249 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value12);
/* 250 */         }
/* 251 */
/* 252 */         if (!inputadapter_isNull4) {
/* 253 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value12);
/* 254 */         }
/* 255 */         if (true) {
/* 256 */           // try to get the buffer from hash map
/* 257 */           agg_unsafeRowAggBuffer =
/* 258 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 259 */         }
/* 260 */         if (agg_unsafeRowAggBuffer == null) {
/* 261 */           if (agg_sorter == null) {
/* 262 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 263 */           } else {
/* 264 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 265 */           }
/* 266 */
/* 267 */           // the hash map had be spilled, it should have enough memory now,
/* 268 */           // try  to allocate buffer again.
/* 269 */           agg_unsafeRowAggBuffer =
/* 270 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value12);
/* 271 */           if (agg_unsafeRowAggBuffer == null) {
/* 272 */             // failed to allocate the first page
/* 273 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 274 */           }
/* 275 */         }
/* 276 */       }
/* 277 */
/* 278 */       if (agg_fastAggBuffer != null) {
/* 279 */         // update fast row
/* 280 */
/* 281 */         // common sub-expressions
/* 282 */
/* 283 */         // evaluate aggregate function
/* 284 */         boolean agg_isNull22 = false;
/* 285 */
/* 286 */         long agg_value26 = agg_fastAggBuffer.getLong(0);
/* 287 */
/* 288 */         long agg_value25 = -1L;
/* 289 */         agg_value25 = agg_value26 + 1L;
/* 290 */         boolean agg_isNull25 = false;
/* 291 */
/* 292 */         long agg_value29 = agg_fastAggBuffer.getLong(1);
/* 293 */
/* 294 */         long agg_value28 = -1L;
/* 295 */         agg_value28 = agg_value29 + 1L;
/* 296 */         boolean agg_isNull28 = false;
/* 297 */
/* 298 */         long agg_value32 = agg_fastAggBuffer.getLong(2);
/* 299 */
/* 300 */         long agg_value31 = -1L;
/* 301 */         agg_value31 = agg_value32 + 1L;
/* 302 */         // update fast row
/* 303 */         agg_fastAggBuffer.setLong(0, agg_value25);
/* 304 */         agg_fastAggBuffer.setLong(1, agg_value28);
/* 305 */         agg_fastAggBuffer.setLong(2, agg_value31);
/* 306 */
/* 307 */       } else {
/* 308 */         // update unsafe row
/* 309 */
/* 310 */         // common sub-expressions
/* 311 */
/* 312 */         // evaluate aggregate function
/* 313 */         boolean agg_isNull13 = false;
/* 314 */
/* 315 */         long agg_value17 = agg_unsafeRowAggBuffer.getLong(0);
/* 316 */
/* 317 */         long agg_value16 = -1L;
/* 318 */         agg_value16 = agg_value17 + 1L;
/* 319 */         boolean agg_isNull16 = false;
/* 320 */
/* 321 */         long agg_value20 = agg_unsafeRowAggBuffer.getLong(1);
/* 322 */
/* 323 */         long agg_value19 = -1L;
/* 324 */         agg_value19 = agg_value20 + 1L;
/* 325 */         boolean agg_isNull19 = false;
/* 326 */
/* 327 */         long agg_value23 = agg_unsafeRowAggBuffer.getLong(2);
/* 328 */
/* 329 */         long agg_value22 = -1L;
/* 330 */         agg_value22 = agg_value23 + 1L;
/* 331 */         // update unsafe row buffer
/* 332 */         agg_unsafeRowAggBuffer.setLong(0, agg_value16);
/* 333 */         agg_unsafeRowAggBuffer.setLong(1, agg_value19);
/* 334 */         agg_unsafeRowAggBuffer.setLong(2, agg_value22);
/* 335 */
/* 336 */       }
/* 337 */       if (shouldStop()) return;
/* 338 */     }
/* 339 */
/* 340 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 341 */
/* 342 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 343 */   }
/* 344 */
/* 345 */   private void wholestagecodegen_init_1() {
/* 346 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 347 */
/* 348 */   }
/* 349 */
/* 350 */   protected void processNext() throws java.io.IOException {
/* 351 */     if (!agg_initAgg) {
/* 352 */       agg_initAgg = true;
/* 353 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 354 */       agg_doAggregateWithKeys();
/* 355 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 356 */     }
/* 357 */
/* 358 */     // output the result
/* 359 */
/* 360 */     while (agg_fastHashMapIter.next()) {
/* 361 */       wholestagecodegen_numOutputRows.add(1);
/* 362 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 363 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 364 */
/* 365 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 366 */
/* 367 */       append(agg_resultRow);
/* 368 */
/* 369 */       if (shouldStop()) return;
/* 370 */     }
/* 371 */     agg_fastHashMap.close();
/* 372 */
/* 373 */     while (agg_mapIter.next()) {
/* 374 */       wholestagecodegen_numOutputRows.add(1);
/* 375 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 376 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 377 */
/* 378 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 379 */
/* 380 */       append(agg_resultRow);
/* 381 */
/* 382 */       if (shouldStop()) return;
/* 383 */     }
/* 384 */
/* 385 */     agg_mapIter.close();
/* 386 */     if (agg_sorter == null) {
/* 387 */       agg_hashMap.free();
/* 388 */     }
/* 389 */   }
/* 390 */ }
