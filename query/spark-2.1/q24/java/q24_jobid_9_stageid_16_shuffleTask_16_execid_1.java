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
/* 021 */   private boolean agg_initAgg1;
/* 022 */   private boolean agg_bufIsNull2;
/* 023 */   private double agg_bufValue2;
/* 024 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 025 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 026 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 027 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 030 */   private scala.collection.Iterator inputadapter_input;
/* 031 */   private UnsafeRow agg_result3;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 034 */   private int agg_value26;
/* 035 */   private UnsafeRow agg_result4;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 038 */   private UnsafeRow agg_result5;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 041 */   private int agg_value71;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
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
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void wholestagecodegen_init_0() {
/* 061 */     agg_initAgg = false;
/* 062 */
/* 063 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 064 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 065 */
/* 066 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 067 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 068 */     agg_initAgg1 = false;
/* 069 */
/* 070 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[3];
/* 071 */
/* 072 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 073 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 074 */     inputadapter_input = inputs[0];
/* 075 */     agg_result3 = new UnsafeRow(10);
/* 076 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 256);
/* 077 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 10);
/* 078 */
/* 079 */     agg_result4 = new UnsafeRow(4);
/* 080 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 96);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   public class agg_FastHashMap {
/* 085 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 086 */     private int[] buckets;
/* 087 */     private int capacity = 1 << 16;
/* 088 */     private double loadFactor = 0.5;
/* 089 */     private int numBuckets = (int) (capacity / loadFactor);
/* 090 */     private int maxSteps = 2;
/* 091 */     private int numRows = 0;
/* 092 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("c_last_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 093 */     .add("c_first_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 094 */     .add("s_store_name", org.apache.spark.sql.types.DataTypes.StringType);
/* 095 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 096 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 097 */     private Object emptyVBase;
/* 098 */     private long emptyVOff;
/* 099 */     private int emptyVLen;
/* 100 */     private boolean isBatchFull = false;
/* 101 */
/* 102 */     public agg_FastHashMap(
/* 103 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 104 */       InternalRow emptyAggregationBuffer) {
/* 105 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 106 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 107 */
/* 108 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 109 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 110 */
/* 111 */       emptyVBase = emptyBuffer;
/* 112 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 113 */       emptyVLen = emptyBuffer.length;
/* 114 */
/* 115 */       buckets = new int[numBuckets];
/* 116 */       java.util.Arrays.fill(buckets, -1);
/* 117 */     }
/* 118 */
/* 119 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 120 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 121 */       int step = 0;
/* 122 */       int idx = (int) h & (numBuckets - 1);
/* 123 */       while (step < maxSteps) {
/* 124 */         // Return bucket index if it's either an empty slot or already contains the key
/* 125 */         if (buckets[idx] == -1) {
/* 126 */           if (numRows < capacity && !isBatchFull) {
/* 127 */             // creating the unsafe for new entry
/* 128 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 129 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 130 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 131 */               96);
/* 132 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 133 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 134 */               agg_holder,
/* 135 */               3);
/* 136 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 137 */             agg_rowWriter.zeroOutNullBytes();
/* 138 */             agg_rowWriter.write(0, agg_key);
/* 139 */             agg_rowWriter.write(1, agg_key1);
/* 140 */             agg_rowWriter.write(2, agg_key2);
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
/* 158 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 159 */           return batch.getValueRow(buckets[idx]);
/* 160 */         }
/* 161 */         idx = (idx + 1) & (numBuckets - 1);
/* 162 */         step++;
/* 163 */       }
/* 164 */       // Didn't find it
/* 165 */       return null;
/* 166 */     }
/* 167 */
/* 168 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 169 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 170 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2));
/* 171 */     }
/* 172 */
/* 173 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
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
/* 185 */       int agg_result1 = 0;
/* 186 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 187 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 188 */         int agg_hash2 = agg_bytes1[i];
/* 189 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 190 */       }
/* 191 */
/* 192 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 193 */
/* 194 */       int agg_result2 = 0;
/* 195 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 196 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 197 */         int agg_hash3 = agg_bytes2[i];
/* 198 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 199 */       }
/* 200 */
/* 201 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 202 */
/* 203 */       return agg_hash;
/* 204 */     }
/* 205 */
/* 206 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 207 */       return batch.rowIterator();
/* 208 */     }
/* 209 */
/* 210 */     public void close() {
/* 211 */       batch.close();
/* 212 */     }
/* 213 */
/* 214 */   }
/* 215 */
/* 216 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 217 */     agg_hashMap = agg_plan.createHashMap();
/* 218 */
/* 219 */     if (!agg_initAgg1) {
/* 220 */       agg_initAgg1 = true;
/* 221 */       long agg_beforeAgg = System.nanoTime();
/* 222 */       agg_doAggregateWithKeys1();
/* 223 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 224 */     }
/* 225 */
/* 226 */     // output the result
/* 227 */
/* 228 */     while (agg_mapIter1.next()) {
/* 229 */       agg_numOutputRows.add(1);
/* 230 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 231 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 232 */
/* 233 */       boolean agg_isNull42 = agg_aggKey.isNullAt(0);
/* 234 */       UTF8String agg_value45 = agg_isNull42 ? null : (agg_aggKey.getUTF8String(0));
/* 235 */       boolean agg_isNull43 = agg_aggKey.isNullAt(1);
/* 236 */       UTF8String agg_value46 = agg_isNull43 ? null : (agg_aggKey.getUTF8String(1));
/* 237 */       boolean agg_isNull44 = agg_aggKey.isNullAt(2);
/* 238 */       UTF8String agg_value47 = agg_isNull44 ? null : (agg_aggKey.getUTF8String(2));
/* 239 */       boolean agg_isNull45 = agg_aggKey.isNullAt(3);
/* 240 */       UTF8String agg_value48 = agg_isNull45 ? null : (agg_aggKey.getUTF8String(3));
/* 241 */       boolean agg_isNull46 = agg_aggKey.isNullAt(4);
/* 242 */       UTF8String agg_value49 = agg_isNull46 ? null : (agg_aggKey.getUTF8String(4));
/* 243 */       boolean agg_isNull47 = agg_aggKey.isNullAt(5);
/* 244 */       UTF8String agg_value50 = agg_isNull47 ? null : (agg_aggKey.getUTF8String(5));
/* 245 */       boolean agg_isNull48 = agg_aggKey.isNullAt(6);
/* 246 */       double agg_value51 = agg_isNull48 ? -1.0 : (agg_aggKey.getDouble(6));
/* 247 */       boolean agg_isNull49 = agg_aggKey.isNullAt(7);
/* 248 */       int agg_value52 = agg_isNull49 ? -1 : (agg_aggKey.getInt(7));
/* 249 */       boolean agg_isNull50 = agg_aggKey.isNullAt(8);
/* 250 */       UTF8String agg_value53 = agg_isNull50 ? null : (agg_aggKey.getUTF8String(8));
/* 251 */       boolean agg_isNull51 = agg_aggKey.isNullAt(9);
/* 252 */       UTF8String agg_value54 = agg_isNull51 ? null : (agg_aggKey.getUTF8String(9));
/* 253 */       boolean agg_isNull52 = agg_aggBuffer.isNullAt(0);
/* 254 */       double agg_value55 = agg_isNull52 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 255 */
/* 256 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 257 */
/* 258 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 259 */
/* 260 */       if (true) {
/* 261 */         if (!agg_isNull42 && !agg_isNull43 && !agg_isNull44) {
/* 262 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 263 */             agg_value45, agg_value46, agg_value47);
/* 264 */         }
/* 265 */       }
/* 266 */
/* 267 */       if (agg_fastAggBuffer1 == null) {
/* 268 */         // generate grouping key
/* 269 */         agg_holder2.reset();
/* 270 */
/* 271 */         agg_rowWriter2.zeroOutNullBytes();
/* 272 */
/* 273 */         if (agg_isNull42) {
/* 274 */           agg_rowWriter2.setNullAt(0);
/* 275 */         } else {
/* 276 */           agg_rowWriter2.write(0, agg_value45);
/* 277 */         }
/* 278 */
/* 279 */         if (agg_isNull43) {
/* 280 */           agg_rowWriter2.setNullAt(1);
/* 281 */         } else {
/* 282 */           agg_rowWriter2.write(1, agg_value46);
/* 283 */         }
/* 284 */
/* 285 */         if (agg_isNull44) {
/* 286 */           agg_rowWriter2.setNullAt(2);
/* 287 */         } else {
/* 288 */           agg_rowWriter2.write(2, agg_value47);
/* 289 */         }
/* 290 */         agg_result5.setTotalSize(agg_holder2.totalSize());
/* 291 */         agg_value71 = 42;
/* 292 */
/* 293 */         if (!agg_isNull42) {
/* 294 */           agg_value71 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(agg_value45.getBaseObject(), agg_value45.getBaseOffset(), agg_value45.numBytes(), agg_value71);
/* 295 */         }
/* 296 */
/* 297 */         if (!agg_isNull43) {
/* 298 */           agg_value71 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(agg_value46.getBaseObject(), agg_value46.getBaseOffset(), agg_value46.numBytes(), agg_value71);
/* 299 */         }
/* 300 */
/* 301 */         if (!agg_isNull44) {
/* 302 */           agg_value71 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(agg_value47.getBaseObject(), agg_value47.getBaseOffset(), agg_value47.numBytes(), agg_value71);
/* 303 */         }
/* 304 */         if (true) {
/* 305 */           // try to get the buffer from hash map
/* 306 */           agg_unsafeRowAggBuffer1 =
/* 307 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value71);
/* 308 */         }
/* 309 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 310 */           if (agg_sorter == null) {
/* 311 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 312 */           } else {
/* 313 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 314 */           }
/* 315 */
/* 316 */           // the hash map had be spilled, it should have enough memory now,
/* 317 */           // try  to allocate buffer again.
/* 318 */           agg_unsafeRowAggBuffer1 =
/* 319 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value71);
/* 320 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 321 */             // failed to allocate the first page
/* 322 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 323 */           }
/* 324 */         }
/* 325 */       }
/* 326 */
/* 327 */       if (agg_fastAggBuffer1 != null) {
/* 328 */         // update fast row
/* 329 */
/* 330 */         // common sub-expressions
/* 331 */         boolean agg_isNull86 = agg_isNull52;
/* 332 */         double agg_value89 = -1.0;
/* 333 */         if (!agg_isNull52) {
/* 334 */           agg_value89 = agg_value55;
/* 335 */         }
/* 336 */         boolean agg_isNull88 = false;
/* 337 */         double agg_value91 = -1.0;
/* 338 */         if (!false) {
/* 339 */           agg_value91 = (double) 0;
/* 340 */         }
/* 341 */         // evaluate aggregate function
/* 342 */         boolean agg_isNull91 = true;
/* 343 */         double agg_value94 = -1.0;
/* 344 */
/* 345 */         boolean agg_isNull93 = agg_fastAggBuffer1.isNullAt(0);
/* 346 */         double agg_value96 = agg_isNull93 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 347 */         boolean agg_isNull92 = agg_isNull93;
/* 348 */         double agg_value95 = agg_value96;
/* 349 */         if (agg_isNull92) {
/* 350 */           if (!agg_isNull88) {
/* 351 */             agg_isNull92 = false;
/* 352 */             agg_value95 = agg_value91;
/* 353 */           }
/* 354 */         }
/* 355 */
/* 356 */         if (!agg_isNull86) {
/* 357 */           agg_isNull91 = false; // resultCode could change nullability.
/* 358 */           agg_value94 = agg_value95 + agg_value89;
/* 359 */
/* 360 */         }
/* 361 */         boolean agg_isNull90 = agg_isNull91;
/* 362 */         double agg_value93 = agg_value94;
/* 363 */         if (agg_isNull90) {
/* 364 */           boolean agg_isNull94 = agg_fastAggBuffer1.isNullAt(0);
/* 365 */           double agg_value97 = agg_isNull94 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 366 */           if (!agg_isNull94) {
/* 367 */             agg_isNull90 = false;
/* 368 */             agg_value93 = agg_value97;
/* 369 */           }
/* 370 */         }
/* 371 */         boolean agg_isNull96 = true;
/* 372 */         double agg_value99 = -1.0;
/* 373 */
/* 374 */         boolean agg_isNull98 = agg_fastAggBuffer1.isNullAt(1);
/* 375 */         double agg_value101 = agg_isNull98 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 376 */         boolean agg_isNull97 = agg_isNull98;
/* 377 */         double agg_value100 = agg_value101;
/* 378 */         if (agg_isNull97) {
/* 379 */           if (!agg_isNull88) {
/* 380 */             agg_isNull97 = false;
/* 381 */             agg_value100 = agg_value91;
/* 382 */           }
/* 383 */         }
/* 384 */
/* 385 */         if (!agg_isNull86) {
/* 386 */           agg_isNull96 = false; // resultCode could change nullability.
/* 387 */           agg_value99 = agg_value100 + agg_value89;
/* 388 */
/* 389 */         }
/* 390 */         boolean agg_isNull95 = agg_isNull96;
/* 391 */         double agg_value98 = agg_value99;
/* 392 */         if (agg_isNull95) {
/* 393 */           boolean agg_isNull99 = agg_fastAggBuffer1.isNullAt(1);
/* 394 */           double agg_value102 = agg_isNull99 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 395 */           if (!agg_isNull99) {
/* 396 */             agg_isNull95 = false;
/* 397 */             agg_value98 = agg_value102;
/* 398 */           }
/* 399 */         }
/* 400 */         // update fast row
/* 401 */         if (!agg_isNull90) {
/* 402 */           agg_fastAggBuffer1.setDouble(0, agg_value93);
/* 403 */         } else {
/* 404 */           agg_fastAggBuffer1.setNullAt(0);
/* 405 */         }
/* 406 */
/* 407 */         if (!agg_isNull95) {
/* 408 */           agg_fastAggBuffer1.setDouble(1, agg_value98);
/* 409 */         } else {
/* 410 */           agg_fastAggBuffer1.setNullAt(1);
/* 411 */         }
/* 412 */
/* 413 */       } else {
/* 414 */         // update unsafe row
/* 415 */
/* 416 */         // common sub-expressions
/* 417 */         boolean agg_isNull72 = agg_isNull52;
/* 418 */         double agg_value75 = -1.0;
/* 419 */         if (!agg_isNull52) {
/* 420 */           agg_value75 = agg_value55;
/* 421 */         }
/* 422 */         boolean agg_isNull74 = false;
/* 423 */         double agg_value77 = -1.0;
/* 424 */         if (!false) {
/* 425 */           agg_value77 = (double) 0;
/* 426 */         }
/* 427 */         // evaluate aggregate function
/* 428 */         boolean agg_isNull77 = true;
/* 429 */         double agg_value80 = -1.0;
/* 430 */
/* 431 */         boolean agg_isNull79 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 432 */         double agg_value82 = agg_isNull79 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 433 */         boolean agg_isNull78 = agg_isNull79;
/* 434 */         double agg_value81 = agg_value82;
/* 435 */         if (agg_isNull78) {
/* 436 */           if (!agg_isNull74) {
/* 437 */             agg_isNull78 = false;
/* 438 */             agg_value81 = agg_value77;
/* 439 */           }
/* 440 */         }
/* 441 */
/* 442 */         if (!agg_isNull72) {
/* 443 */           agg_isNull77 = false; // resultCode could change nullability.
/* 444 */           agg_value80 = agg_value81 + agg_value75;
/* 445 */
/* 446 */         }
/* 447 */         boolean agg_isNull76 = agg_isNull77;
/* 448 */         double agg_value79 = agg_value80;
/* 449 */         if (agg_isNull76) {
/* 450 */           boolean agg_isNull80 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 451 */           double agg_value83 = agg_isNull80 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 452 */           if (!agg_isNull80) {
/* 453 */             agg_isNull76 = false;
/* 454 */             agg_value79 = agg_value83;
/* 455 */           }
/* 456 */         }
/* 457 */         boolean agg_isNull82 = true;
/* 458 */         double agg_value85 = -1.0;
/* 459 */
/* 460 */         boolean agg_isNull84 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 461 */         double agg_value87 = agg_isNull84 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 462 */         boolean agg_isNull83 = agg_isNull84;
/* 463 */         double agg_value86 = agg_value87;
/* 464 */         if (agg_isNull83) {
/* 465 */           if (!agg_isNull74) {
/* 466 */             agg_isNull83 = false;
/* 467 */             agg_value86 = agg_value77;
/* 468 */           }
/* 469 */         }
/* 470 */
/* 471 */         if (!agg_isNull72) {
/* 472 */           agg_isNull82 = false; // resultCode could change nullability.
/* 473 */           agg_value85 = agg_value86 + agg_value75;
/* 474 */
/* 475 */         }
/* 476 */         boolean agg_isNull81 = agg_isNull82;
/* 477 */         double agg_value84 = agg_value85;
/* 478 */         if (agg_isNull81) {
/* 479 */           boolean agg_isNull85 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 480 */           double agg_value88 = agg_isNull85 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 481 */           if (!agg_isNull85) {
/* 482 */             agg_isNull81 = false;
/* 483 */             agg_value84 = agg_value88;
/* 484 */           }
/* 485 */         }
/* 486 */         // update unsafe row buffer
/* 487 */         if (!agg_isNull76) {
/* 488 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value79);
/* 489 */         } else {
/* 490 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 491 */         }
/* 492 */
/* 493 */         if (!agg_isNull81) {
/* 494 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value84);
/* 495 */         } else {
/* 496 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 497 */         }
/* 498 */
/* 499 */       }
/* 500 */
/* 501 */       if (shouldStop()) return;
/* 502 */     }
/* 503 */
/* 504 */     agg_mapIter1.close();
/* 505 */     if (agg_sorter1 == null) {
/* 506 */       agg_hashMap1.free();
/* 507 */     }
/* 508 */
/* 509 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 510 */
/* 511 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 512 */   }
/* 513 */
/* 514 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 515 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 516 */
/* 517 */     while (inputadapter_input.hasNext()) {
/* 518 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 519 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 520 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 521 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 522 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 523 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 524 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 525 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 526 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 527 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 528 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 529 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 530 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 531 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 532 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 533 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 534 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 535 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 536 */       UTF8String inputadapter_value8 = inputadapter_isNull8 ? null : (inputadapter_row.getUTF8String(8));
/* 537 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 538 */       UTF8String inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getUTF8String(9));
/* 539 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 540 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 541 */
/* 542 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 543 */
/* 544 */       UnsafeRow agg_fastAggBuffer = null;
/* 545 */
/* 546 */       if (agg_fastAggBuffer == null) {
/* 547 */         // generate grouping key
/* 548 */         agg_holder.reset();
/* 549 */
/* 550 */         agg_rowWriter.zeroOutNullBytes();
/* 551 */
/* 552 */         if (inputadapter_isNull) {
/* 553 */           agg_rowWriter.setNullAt(0);
/* 554 */         } else {
/* 555 */           agg_rowWriter.write(0, inputadapter_value);
/* 556 */         }
/* 557 */
/* 558 */         if (inputadapter_isNull1) {
/* 559 */           agg_rowWriter.setNullAt(1);
/* 560 */         } else {
/* 561 */           agg_rowWriter.write(1, inputadapter_value1);
/* 562 */         }
/* 563 */
/* 564 */         if (inputadapter_isNull2) {
/* 565 */           agg_rowWriter.setNullAt(2);
/* 566 */         } else {
/* 567 */           agg_rowWriter.write(2, inputadapter_value2);
/* 568 */         }
/* 569 */
/* 570 */         if (inputadapter_isNull3) {
/* 571 */           agg_rowWriter.setNullAt(3);
/* 572 */         } else {
/* 573 */           agg_rowWriter.write(3, inputadapter_value3);
/* 574 */         }
/* 575 */
/* 576 */         if (inputadapter_isNull4) {
/* 577 */           agg_rowWriter.setNullAt(4);
/* 578 */         } else {
/* 579 */           agg_rowWriter.write(4, inputadapter_value4);
/* 580 */         }
/* 581 */
/* 582 */         if (inputadapter_isNull5) {
/* 583 */           agg_rowWriter.setNullAt(5);
/* 584 */         } else {
/* 585 */           agg_rowWriter.write(5, inputadapter_value5);
/* 586 */         }
/* 587 */
/* 588 */         if (inputadapter_isNull6) {
/* 589 */           agg_rowWriter.setNullAt(6);
/* 590 */         } else {
/* 591 */           agg_rowWriter.write(6, inputadapter_value6);
/* 592 */         }
/* 593 */
/* 594 */         if (inputadapter_isNull7) {
/* 595 */           agg_rowWriter.setNullAt(7);
/* 596 */         } else {
/* 597 */           agg_rowWriter.write(7, inputadapter_value7);
/* 598 */         }
/* 599 */
/* 600 */         if (inputadapter_isNull8) {
/* 601 */           agg_rowWriter.setNullAt(8);
/* 602 */         } else {
/* 603 */           agg_rowWriter.write(8, inputadapter_value8);
/* 604 */         }
/* 605 */
/* 606 */         if (inputadapter_isNull9) {
/* 607 */           agg_rowWriter.setNullAt(9);
/* 608 */         } else {
/* 609 */           agg_rowWriter.write(9, inputadapter_value9);
/* 610 */         }
/* 611 */         agg_result3.setTotalSize(agg_holder.totalSize());
/* 612 */         agg_value26 = 42;
/* 613 */
/* 614 */         if (!inputadapter_isNull) {
/* 615 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value26);
/* 616 */         }
/* 617 */
/* 618 */         if (!inputadapter_isNull1) {
/* 619 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value26);
/* 620 */         }
/* 621 */
/* 622 */         if (!inputadapter_isNull2) {
/* 623 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value26);
/* 624 */         }
/* 625 */
/* 626 */         if (!inputadapter_isNull3) {
/* 627 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value26);
/* 628 */         }
/* 629 */
/* 630 */         if (!inputadapter_isNull4) {
/* 631 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value26);
/* 632 */         }
/* 633 */
/* 634 */         if (!inputadapter_isNull5) {
/* 635 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value26);
/* 636 */         }
/* 637 */
/* 638 */         if (!inputadapter_isNull6) {
/* 639 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value6), agg_value26);
/* 640 */         }
/* 641 */
/* 642 */         if (!inputadapter_isNull7) {
/* 643 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value26);
/* 644 */         }
/* 645 */
/* 646 */         if (!inputadapter_isNull8) {
/* 647 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value8.getBaseObject(), inputadapter_value8.getBaseOffset(), inputadapter_value8.numBytes(), agg_value26);
/* 648 */         }
/* 649 */
/* 650 */         if (!inputadapter_isNull9) {
/* 651 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value9.getBaseObject(), inputadapter_value9.getBaseOffset(), inputadapter_value9.numBytes(), agg_value26);
/* 652 */         }
/* 653 */         if (true) {
/* 654 */           // try to get the buffer from hash map
/* 655 */           agg_unsafeRowAggBuffer =
/* 656 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 657 */         }
/* 658 */         if (agg_unsafeRowAggBuffer == null) {
/* 659 */           if (agg_sorter1 == null) {
/* 660 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 661 */           } else {
/* 662 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 663 */           }
/* 664 */
/* 665 */           // the hash map had be spilled, it should have enough memory now,
/* 666 */           // try  to allocate buffer again.
/* 667 */           agg_unsafeRowAggBuffer =
/* 668 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 669 */           if (agg_unsafeRowAggBuffer == null) {
/* 670 */             // failed to allocate the first page
/* 671 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 672 */           }
/* 673 */         }
/* 674 */       }
/* 675 */
/* 676 */       if (agg_fastAggBuffer != null) {
/* 677 */         // update fast row
/* 678 */
/* 679 */       } else {
/* 680 */         // update unsafe row
/* 681 */
/* 682 */         // common sub-expressions
/* 683 */
/* 684 */         // evaluate aggregate function
/* 685 */         boolean agg_isNull35 = true;
/* 686 */         double agg_value38 = -1.0;
/* 687 */
/* 688 */         boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 689 */         double agg_value40 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 690 */         boolean agg_isNull36 = agg_isNull37;
/* 691 */         double agg_value39 = agg_value40;
/* 692 */         if (agg_isNull36) {
/* 693 */           boolean agg_isNull38 = false;
/* 694 */           double agg_value41 = -1.0;
/* 695 */           if (!false) {
/* 696 */             agg_value41 = (double) 0;
/* 697 */           }
/* 698 */           if (!agg_isNull38) {
/* 699 */             agg_isNull36 = false;
/* 700 */             agg_value39 = agg_value41;
/* 701 */           }
/* 702 */         }
/* 703 */
/* 704 */         if (!inputadapter_isNull10) {
/* 705 */           agg_isNull35 = false; // resultCode could change nullability.
/* 706 */           agg_value38 = agg_value39 + inputadapter_value10;
/* 707 */
/* 708 */         }
/* 709 */         boolean agg_isNull34 = agg_isNull35;
/* 710 */         double agg_value37 = agg_value38;
/* 711 */         if (agg_isNull34) {
/* 712 */           boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 713 */           double agg_value44 = agg_isNull41 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 714 */           if (!agg_isNull41) {
/* 715 */             agg_isNull34 = false;
/* 716 */             agg_value37 = agg_value44;
/* 717 */           }
/* 718 */         }
/* 719 */         // update unsafe row buffer
/* 720 */         if (!agg_isNull34) {
/* 721 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value37);
/* 722 */         } else {
/* 723 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 724 */         }
/* 725 */
/* 726 */       }
/* 727 */       if (shouldStop()) return;
/* 728 */     }
/* 729 */
/* 730 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 731 */   }
/* 732 */
/* 733 */   private void wholestagecodegen_init_1() {
/* 734 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 4);
/* 735 */     agg_result5 = new UnsafeRow(3);
/* 736 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 96);
/* 737 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 3);
/* 738 */
/* 739 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 740 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 741 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 742 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 743 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 744 */
/* 745 */   }
/* 746 */
/* 747 */   protected void processNext() throws java.io.IOException {
/* 748 */     if (!agg_initAgg) {
/* 749 */       agg_initAgg = true;
/* 750 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 751 */       agg_doAggregateWithKeys();
/* 752 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 753 */     }
/* 754 */
/* 755 */     // output the result
/* 756 */
/* 757 */     while (agg_fastHashMapIter.next()) {
/* 758 */       wholestagecodegen_numOutputRows.add(1);
/* 759 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 760 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 761 */
/* 762 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 763 */
/* 764 */       append(agg_resultRow);
/* 765 */
/* 766 */       if (shouldStop()) return;
/* 767 */     }
/* 768 */     agg_fastHashMap.close();
/* 769 */
/* 770 */     while (agg_mapIter.next()) {
/* 771 */       wholestagecodegen_numOutputRows.add(1);
/* 772 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 773 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 774 */
/* 775 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 776 */
/* 777 */       append(agg_resultRow);
/* 778 */
/* 779 */       if (shouldStop()) return;
/* 780 */     }
/* 781 */
/* 782 */     agg_mapIter.close();
/* 783 */     if (agg_sorter == null) {
/* 784 */       agg_hashMap.free();
/* 785 */     }
/* 786 */   }
/* 787 */ }
