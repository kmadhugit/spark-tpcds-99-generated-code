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
/* 070 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[8];
/* 071 */
/* 072 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 073 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
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
/* 092 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 093 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 094 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType);
/* 095 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 096 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 331 */
/* 332 */         // evaluate aggregate function
/* 333 */         boolean agg_isNull91 = true;
/* 334 */         double agg_value94 = -1.0;
/* 335 */
/* 336 */         boolean agg_isNull93 = agg_fastAggBuffer1.isNullAt(0);
/* 337 */         double agg_value96 = agg_isNull93 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 338 */         boolean agg_isNull92 = agg_isNull93;
/* 339 */         double agg_value95 = agg_value96;
/* 340 */         if (agg_isNull92) {
/* 341 */           boolean agg_isNull94 = false;
/* 342 */           double agg_value97 = -1.0;
/* 343 */           if (!false) {
/* 344 */             agg_value97 = (double) 0;
/* 345 */           }
/* 346 */           if (!agg_isNull94) {
/* 347 */             agg_isNull92 = false;
/* 348 */             agg_value95 = agg_value97;
/* 349 */           }
/* 350 */         }
/* 351 */
/* 352 */         if (!agg_isNull52) {
/* 353 */           agg_isNull91 = false; // resultCode could change nullability.
/* 354 */           agg_value94 = agg_value95 + agg_value55;
/* 355 */
/* 356 */         }
/* 357 */         boolean agg_isNull90 = agg_isNull91;
/* 358 */         double agg_value93 = agg_value94;
/* 359 */         if (agg_isNull90) {
/* 360 */           boolean agg_isNull97 = agg_fastAggBuffer1.isNullAt(0);
/* 361 */           double agg_value100 = agg_isNull97 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 362 */           if (!agg_isNull97) {
/* 363 */             agg_isNull90 = false;
/* 364 */             agg_value93 = agg_value100;
/* 365 */           }
/* 366 */         }
/* 367 */         boolean agg_isNull99 = true;
/* 368 */         double agg_value102 = -1.0;
/* 369 */
/* 370 */         boolean agg_isNull101 = agg_fastAggBuffer1.isNullAt(1);
/* 371 */         double agg_value104 = agg_isNull101 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 372 */         boolean agg_isNull100 = agg_isNull101;
/* 373 */         double agg_value103 = agg_value104;
/* 374 */         if (agg_isNull100) {
/* 375 */           boolean agg_isNull102 = false;
/* 376 */           double agg_value105 = -1.0;
/* 377 */           if (!false) {
/* 378 */             agg_value105 = (double) 0;
/* 379 */           }
/* 380 */           if (!agg_isNull102) {
/* 381 */             agg_isNull100 = false;
/* 382 */             agg_value103 = agg_value105;
/* 383 */           }
/* 384 */         }
/* 385 */
/* 386 */         if (!agg_isNull52) {
/* 387 */           agg_isNull99 = false; // resultCode could change nullability.
/* 388 */           agg_value102 = agg_value103 + agg_value55;
/* 389 */
/* 390 */         }
/* 391 */         boolean agg_isNull98 = agg_isNull99;
/* 392 */         double agg_value101 = agg_value102;
/* 393 */         if (agg_isNull98) {
/* 394 */           boolean agg_isNull105 = agg_fastAggBuffer1.isNullAt(1);
/* 395 */           double agg_value108 = agg_isNull105 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 396 */           if (!agg_isNull105) {
/* 397 */             agg_isNull98 = false;
/* 398 */             agg_value101 = agg_value108;
/* 399 */           }
/* 400 */         }
/* 401 */         // update fast row
/* 402 */         if (!agg_isNull90) {
/* 403 */           agg_fastAggBuffer1.setDouble(0, agg_value93);
/* 404 */         } else {
/* 405 */           agg_fastAggBuffer1.setNullAt(0);
/* 406 */         }
/* 407 */
/* 408 */         if (!agg_isNull98) {
/* 409 */           agg_fastAggBuffer1.setDouble(1, agg_value101);
/* 410 */         } else {
/* 411 */           agg_fastAggBuffer1.setNullAt(1);
/* 412 */         }
/* 413 */
/* 414 */       } else {
/* 415 */         // update unsafe row
/* 416 */
/* 417 */         // common sub-expressions
/* 418 */
/* 419 */         // evaluate aggregate function
/* 420 */         boolean agg_isNull74 = true;
/* 421 */         double agg_value77 = -1.0;
/* 422 */
/* 423 */         boolean agg_isNull76 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 424 */         double agg_value79 = agg_isNull76 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 425 */         boolean agg_isNull75 = agg_isNull76;
/* 426 */         double agg_value78 = agg_value79;
/* 427 */         if (agg_isNull75) {
/* 428 */           boolean agg_isNull77 = false;
/* 429 */           double agg_value80 = -1.0;
/* 430 */           if (!false) {
/* 431 */             agg_value80 = (double) 0;
/* 432 */           }
/* 433 */           if (!agg_isNull77) {
/* 434 */             agg_isNull75 = false;
/* 435 */             agg_value78 = agg_value80;
/* 436 */           }
/* 437 */         }
/* 438 */
/* 439 */         if (!agg_isNull52) {
/* 440 */           agg_isNull74 = false; // resultCode could change nullability.
/* 441 */           agg_value77 = agg_value78 + agg_value55;
/* 442 */
/* 443 */         }
/* 444 */         boolean agg_isNull73 = agg_isNull74;
/* 445 */         double agg_value76 = agg_value77;
/* 446 */         if (agg_isNull73) {
/* 447 */           boolean agg_isNull80 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 448 */           double agg_value83 = agg_isNull80 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 449 */           if (!agg_isNull80) {
/* 450 */             agg_isNull73 = false;
/* 451 */             agg_value76 = agg_value83;
/* 452 */           }
/* 453 */         }
/* 454 */         boolean agg_isNull82 = true;
/* 455 */         double agg_value85 = -1.0;
/* 456 */
/* 457 */         boolean agg_isNull84 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 458 */         double agg_value87 = agg_isNull84 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 459 */         boolean agg_isNull83 = agg_isNull84;
/* 460 */         double agg_value86 = agg_value87;
/* 461 */         if (agg_isNull83) {
/* 462 */           boolean agg_isNull85 = false;
/* 463 */           double agg_value88 = -1.0;
/* 464 */           if (!false) {
/* 465 */             agg_value88 = (double) 0;
/* 466 */           }
/* 467 */           if (!agg_isNull85) {
/* 468 */             agg_isNull83 = false;
/* 469 */             agg_value86 = agg_value88;
/* 470 */           }
/* 471 */         }
/* 472 */
/* 473 */         if (!agg_isNull52) {
/* 474 */           agg_isNull82 = false; // resultCode could change nullability.
/* 475 */           agg_value85 = agg_value86 + agg_value55;
/* 476 */
/* 477 */         }
/* 478 */         boolean agg_isNull81 = agg_isNull82;
/* 479 */         double agg_value84 = agg_value85;
/* 480 */         if (agg_isNull81) {
/* 481 */           boolean agg_isNull88 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 482 */           double agg_value91 = agg_isNull88 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 483 */           if (!agg_isNull88) {
/* 484 */             agg_isNull81 = false;
/* 485 */             agg_value84 = agg_value91;
/* 486 */           }
/* 487 */         }
/* 488 */         // update unsafe row buffer
/* 489 */         if (!agg_isNull73) {
/* 490 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value76);
/* 491 */         } else {
/* 492 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 493 */         }
/* 494 */
/* 495 */         if (!agg_isNull81) {
/* 496 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value84);
/* 497 */         } else {
/* 498 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 499 */         }
/* 500 */
/* 501 */       }
/* 502 */
/* 503 */       if (shouldStop()) return;
/* 504 */     }
/* 505 */
/* 506 */     agg_mapIter1.close();
/* 507 */     if (agg_sorter1 == null) {
/* 508 */       agg_hashMap1.free();
/* 509 */     }
/* 510 */
/* 511 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 512 */
/* 513 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 514 */   }
/* 515 */
/* 516 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 517 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 518 */
/* 519 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 520 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 521 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 522 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 523 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 524 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 525 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 526 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 527 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 528 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 529 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 530 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 531 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 532 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 533 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 534 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 535 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 536 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 537 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 538 */       UTF8String inputadapter_value8 = inputadapter_isNull8 ? null : (inputadapter_row.getUTF8String(8));
/* 539 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 540 */       UTF8String inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getUTF8String(9));
/* 541 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 542 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 543 */
/* 544 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 545 */
/* 546 */       UnsafeRow agg_fastAggBuffer = null;
/* 547 */
/* 548 */       if (agg_fastAggBuffer == null) {
/* 549 */         // generate grouping key
/* 550 */         agg_holder.reset();
/* 551 */
/* 552 */         agg_rowWriter.zeroOutNullBytes();
/* 553 */
/* 554 */         if (inputadapter_isNull) {
/* 555 */           agg_rowWriter.setNullAt(0);
/* 556 */         } else {
/* 557 */           agg_rowWriter.write(0, inputadapter_value);
/* 558 */         }
/* 559 */
/* 560 */         if (inputadapter_isNull1) {
/* 561 */           agg_rowWriter.setNullAt(1);
/* 562 */         } else {
/* 563 */           agg_rowWriter.write(1, inputadapter_value1);
/* 564 */         }
/* 565 */
/* 566 */         if (inputadapter_isNull2) {
/* 567 */           agg_rowWriter.setNullAt(2);
/* 568 */         } else {
/* 569 */           agg_rowWriter.write(2, inputadapter_value2);
/* 570 */         }
/* 571 */
/* 572 */         if (inputadapter_isNull3) {
/* 573 */           agg_rowWriter.setNullAt(3);
/* 574 */         } else {
/* 575 */           agg_rowWriter.write(3, inputadapter_value3);
/* 576 */         }
/* 577 */
/* 578 */         if (inputadapter_isNull4) {
/* 579 */           agg_rowWriter.setNullAt(4);
/* 580 */         } else {
/* 581 */           agg_rowWriter.write(4, inputadapter_value4);
/* 582 */         }
/* 583 */
/* 584 */         if (inputadapter_isNull5) {
/* 585 */           agg_rowWriter.setNullAt(5);
/* 586 */         } else {
/* 587 */           agg_rowWriter.write(5, inputadapter_value5);
/* 588 */         }
/* 589 */
/* 590 */         if (inputadapter_isNull6) {
/* 591 */           agg_rowWriter.setNullAt(6);
/* 592 */         } else {
/* 593 */           agg_rowWriter.write(6, inputadapter_value6);
/* 594 */         }
/* 595 */
/* 596 */         if (inputadapter_isNull7) {
/* 597 */           agg_rowWriter.setNullAt(7);
/* 598 */         } else {
/* 599 */           agg_rowWriter.write(7, inputadapter_value7);
/* 600 */         }
/* 601 */
/* 602 */         if (inputadapter_isNull8) {
/* 603 */           agg_rowWriter.setNullAt(8);
/* 604 */         } else {
/* 605 */           agg_rowWriter.write(8, inputadapter_value8);
/* 606 */         }
/* 607 */
/* 608 */         if (inputadapter_isNull9) {
/* 609 */           agg_rowWriter.setNullAt(9);
/* 610 */         } else {
/* 611 */           agg_rowWriter.write(9, inputadapter_value9);
/* 612 */         }
/* 613 */         agg_result3.setTotalSize(agg_holder.totalSize());
/* 614 */         agg_value26 = 42;
/* 615 */
/* 616 */         if (!inputadapter_isNull) {
/* 617 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value26);
/* 618 */         }
/* 619 */
/* 620 */         if (!inputadapter_isNull1) {
/* 621 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value26);
/* 622 */         }
/* 623 */
/* 624 */         if (!inputadapter_isNull2) {
/* 625 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value26);
/* 626 */         }
/* 627 */
/* 628 */         if (!inputadapter_isNull3) {
/* 629 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value26);
/* 630 */         }
/* 631 */
/* 632 */         if (!inputadapter_isNull4) {
/* 633 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value26);
/* 634 */         }
/* 635 */
/* 636 */         if (!inputadapter_isNull5) {
/* 637 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value26);
/* 638 */         }
/* 639 */
/* 640 */         if (!inputadapter_isNull6) {
/* 641 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value6), agg_value26);
/* 642 */         }
/* 643 */
/* 644 */         if (!inputadapter_isNull7) {
/* 645 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value26);
/* 646 */         }
/* 647 */
/* 648 */         if (!inputadapter_isNull8) {
/* 649 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value8.getBaseObject(), inputadapter_value8.getBaseOffset(), inputadapter_value8.numBytes(), agg_value26);
/* 650 */         }
/* 651 */
/* 652 */         if (!inputadapter_isNull9) {
/* 653 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value9.getBaseObject(), inputadapter_value9.getBaseOffset(), inputadapter_value9.numBytes(), agg_value26);
/* 654 */         }
/* 655 */         if (true) {
/* 656 */           // try to get the buffer from hash map
/* 657 */           agg_unsafeRowAggBuffer =
/* 658 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 659 */         }
/* 660 */         if (agg_unsafeRowAggBuffer == null) {
/* 661 */           if (agg_sorter1 == null) {
/* 662 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 663 */           } else {
/* 664 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 665 */           }
/* 666 */
/* 667 */           // the hash map had be spilled, it should have enough memory now,
/* 668 */           // try  to allocate buffer again.
/* 669 */           agg_unsafeRowAggBuffer =
/* 670 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 671 */           if (agg_unsafeRowAggBuffer == null) {
/* 672 */             // failed to allocate the first page
/* 673 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 674 */           }
/* 675 */         }
/* 676 */       }
/* 677 */
/* 678 */       if (agg_fastAggBuffer != null) {
/* 679 */         // update fast row
/* 680 */
/* 681 */       } else {
/* 682 */         // update unsafe row
/* 683 */
/* 684 */         // common sub-expressions
/* 685 */
/* 686 */         // evaluate aggregate function
/* 687 */         boolean agg_isNull35 = true;
/* 688 */         double agg_value38 = -1.0;
/* 689 */
/* 690 */         boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 691 */         double agg_value40 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 692 */         boolean agg_isNull36 = agg_isNull37;
/* 693 */         double agg_value39 = agg_value40;
/* 694 */         if (agg_isNull36) {
/* 695 */           boolean agg_isNull38 = false;
/* 696 */           double agg_value41 = -1.0;
/* 697 */           if (!false) {
/* 698 */             agg_value41 = (double) 0;
/* 699 */           }
/* 700 */           if (!agg_isNull38) {
/* 701 */             agg_isNull36 = false;
/* 702 */             agg_value39 = agg_value41;
/* 703 */           }
/* 704 */         }
/* 705 */
/* 706 */         if (!inputadapter_isNull10) {
/* 707 */           agg_isNull35 = false; // resultCode could change nullability.
/* 708 */           agg_value38 = agg_value39 + inputadapter_value10;
/* 709 */
/* 710 */         }
/* 711 */         boolean agg_isNull34 = agg_isNull35;
/* 712 */         double agg_value37 = agg_value38;
/* 713 */         if (agg_isNull34) {
/* 714 */           boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 715 */           double agg_value44 = agg_isNull41 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 716 */           if (!agg_isNull41) {
/* 717 */             agg_isNull34 = false;
/* 718 */             agg_value37 = agg_value44;
/* 719 */           }
/* 720 */         }
/* 721 */         // update unsafe row buffer
/* 722 */         if (!agg_isNull34) {
/* 723 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value37);
/* 724 */         } else {
/* 725 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 726 */         }
/* 727 */
/* 728 */       }
/* 729 */       if (shouldStop()) return;
/* 730 */     }
/* 731 */
/* 732 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 733 */   }
/* 734 */
/* 735 */   private void wholestagecodegen_init_1() {
/* 736 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 4);
/* 737 */     agg_result5 = new UnsafeRow(3);
/* 738 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 96);
/* 739 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 3);
/* 740 */
/* 741 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 742 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 743 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 744 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 745 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 746 */
/* 747 */   }
/* 748 */
/* 749 */   protected void processNext() throws java.io.IOException {
/* 750 */     if (!agg_initAgg) {
/* 751 */       agg_initAgg = true;
/* 752 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 753 */       agg_doAggregateWithKeys();
/* 754 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 755 */     }
/* 756 */
/* 757 */     // output the result
/* 758 */
/* 759 */     while (agg_fastHashMapIter.next()) {
/* 760 */       wholestagecodegen_numOutputRows.add(1);
/* 761 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 762 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 763 */
/* 764 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 765 */
/* 766 */       append(agg_resultRow);
/* 767 */
/* 768 */       if (shouldStop()) return;
/* 769 */     }
/* 770 */     agg_fastHashMap.close();
/* 771 */
/* 772 */     while (agg_mapIter.next()) {
/* 773 */       wholestagecodegen_numOutputRows.add(1);
/* 774 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 775 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 776 */
/* 777 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 778 */
/* 779 */       append(agg_resultRow);
/* 780 */
/* 781 */       if (shouldStop()) return;
/* 782 */     }
/* 783 */
/* 784 */     agg_mapIter.close();
/* 785 */     if (agg_sorter == null) {
/* 786 */       agg_hashMap.free();
/* 787 */     }
/* 788 */   }
/* 789 */ }
