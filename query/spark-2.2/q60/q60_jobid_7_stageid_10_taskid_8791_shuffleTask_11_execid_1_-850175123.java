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
/* 020 */   private UnsafeRow agg_result1;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value4;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 039 */
/* 040 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 041 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 042 */     inputadapter_input = inputs[0];
/* 043 */     agg_result1 = new UnsafeRow(1);
/* 044 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 045 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 046 */
/* 047 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 048 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 049 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   public class agg_FastHashMap {
/* 054 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 055 */     private int[] buckets;
/* 056 */     private int capacity = 1 << 16;
/* 057 */     private double loadFactor = 0.5;
/* 058 */     private int numBuckets = (int) (capacity / loadFactor);
/* 059 */     private int maxSteps = 2;
/* 060 */     private int numRows = 0;
/* 061 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 062 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 063 */     private Object emptyVBase;
/* 064 */     private long emptyVOff;
/* 065 */     private int emptyVLen;
/* 066 */     private boolean isBatchFull = false;
/* 067 */
/* 068 */     public agg_FastHashMap(
/* 069 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 070 */       InternalRow emptyAggregationBuffer) {
/* 071 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 072 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 073 */
/* 074 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 075 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 076 */
/* 077 */       emptyVBase = emptyBuffer;
/* 078 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 079 */       emptyVLen = emptyBuffer.length;
/* 080 */
/* 081 */       buckets = new int[numBuckets];
/* 082 */       java.util.Arrays.fill(buckets, -1);
/* 083 */     }
/* 084 */
/* 085 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 086 */       long h = hash(agg_key);
/* 087 */       int step = 0;
/* 088 */       int idx = (int) h & (numBuckets - 1);
/* 089 */       while (step < maxSteps) {
/* 090 */         // Return bucket index if it's either an empty slot or already contains the key
/* 091 */         if (buckets[idx] == -1) {
/* 092 */           if (numRows < capacity && !isBatchFull) {
/* 093 */             // creating the unsafe for new entry
/* 094 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 095 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 096 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 097 */               32);
/* 098 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 099 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 100 */               agg_holder,
/* 101 */               1);
/* 102 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 103 */             agg_rowWriter.zeroOutNullBytes();
/* 104 */             agg_rowWriter.write(0, agg_key);
/* 105 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 106 */             Object kbase = agg_result.getBaseObject();
/* 107 */             long koff = agg_result.getBaseOffset();
/* 108 */             int klen = agg_result.getSizeInBytes();
/* 109 */
/* 110 */             UnsafeRow vRow
/* 111 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 112 */             if (vRow == null) {
/* 113 */               isBatchFull = true;
/* 114 */             } else {
/* 115 */               buckets[idx] = numRows++;
/* 116 */             }
/* 117 */             return vRow;
/* 118 */           } else {
/* 119 */             // No more space
/* 120 */             return null;
/* 121 */           }
/* 122 */         } else if (equals(idx, agg_key)) {
/* 123 */           return batch.getValueRow(buckets[idx]);
/* 124 */         }
/* 125 */         idx = (idx + 1) & (numBuckets - 1);
/* 126 */         step++;
/* 127 */       }
/* 128 */       // Didn't find it
/* 129 */       return null;
/* 130 */     }
/* 131 */
/* 132 */     private boolean equals(int idx, UTF8String agg_key) {
/* 133 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 134 */       return (row.getUTF8String(0).equals(agg_key));
/* 135 */     }
/* 136 */
/* 137 */     private long hash(UTF8String agg_key) {
/* 138 */       long agg_hash = 0;
/* 139 */
/* 140 */       int agg_result = 0;
/* 141 */       byte[] agg_bytes = agg_key.getBytes();
/* 142 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 143 */         int agg_hash1 = agg_bytes[i];
/* 144 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 145 */       }
/* 146 */
/* 147 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 148 */
/* 149 */       return agg_hash;
/* 150 */     }
/* 151 */
/* 152 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 153 */       return batch.rowIterator();
/* 154 */     }
/* 155 */
/* 156 */     public void close() {
/* 157 */       batch.close();
/* 158 */     }
/* 159 */
/* 160 */   }
/* 161 */
/* 162 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 163 */     agg_hashMap = agg_plan.createHashMap();
/* 164 */
/* 165 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 166 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 167 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 168 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 169 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 170 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 171 */
/* 172 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 173 */
/* 174 */       UnsafeRow agg_fastAggBuffer = null;
/* 175 */
/* 176 */       if (true) {
/* 177 */         if (!inputadapter_isNull) {
/* 178 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 179 */             inputadapter_value);
/* 180 */         }
/* 181 */       }
/* 182 */
/* 183 */       if (agg_fastAggBuffer == null) {
/* 184 */         // generate grouping key
/* 185 */         agg_holder.reset();
/* 186 */
/* 187 */         agg_rowWriter.zeroOutNullBytes();
/* 188 */
/* 189 */         if (inputadapter_isNull) {
/* 190 */           agg_rowWriter.setNullAt(0);
/* 191 */         } else {
/* 192 */           agg_rowWriter.write(0, inputadapter_value);
/* 193 */         }
/* 194 */         agg_result1.setTotalSize(agg_holder.totalSize());
/* 195 */         agg_value4 = 42;
/* 196 */
/* 197 */         if (!inputadapter_isNull) {
/* 198 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value4);
/* 199 */         }
/* 200 */         if (true) {
/* 201 */           // try to get the buffer from hash map
/* 202 */           agg_unsafeRowAggBuffer =
/* 203 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 204 */         }
/* 205 */         if (agg_unsafeRowAggBuffer == null) {
/* 206 */           if (agg_sorter == null) {
/* 207 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 208 */           } else {
/* 209 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 210 */           }
/* 211 */
/* 212 */           // the hash map had be spilled, it should have enough memory now,
/* 213 */           // try  to allocate buffer again.
/* 214 */           agg_unsafeRowAggBuffer =
/* 215 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 216 */           if (agg_unsafeRowAggBuffer == null) {
/* 217 */             // failed to allocate the first page
/* 218 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 219 */           }
/* 220 */         }
/* 221 */       }
/* 222 */
/* 223 */       if (agg_fastAggBuffer != null) {
/* 224 */         // update fast row
/* 225 */
/* 226 */         // common sub-expressions
/* 227 */
/* 228 */         // evaluate aggregate function
/* 229 */         boolean agg_isNull14 = true;
/* 230 */         double agg_value15 = -1.0;
/* 231 */
/* 232 */         boolean agg_isNull16 = agg_fastAggBuffer.isNullAt(0);
/* 233 */         double agg_value17 = agg_isNull16 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 234 */         boolean agg_isNull15 = agg_isNull16;
/* 235 */         double agg_value16 = agg_value17;
/* 236 */         if (agg_isNull15) {
/* 237 */           boolean agg_isNull17 = false;
/* 238 */           double agg_value18 = -1.0;
/* 239 */           if (!false) {
/* 240 */             agg_value18 = (double) 0;
/* 241 */           }
/* 242 */           if (!agg_isNull17) {
/* 243 */             agg_isNull15 = false;
/* 244 */             agg_value16 = agg_value18;
/* 245 */           }
/* 246 */         }
/* 247 */
/* 248 */         if (!inputadapter_isNull1) {
/* 249 */           agg_isNull14 = false; // resultCode could change nullability.
/* 250 */           agg_value15 = agg_value16 + inputadapter_value1;
/* 251 */
/* 252 */         }
/* 253 */         boolean agg_isNull13 = agg_isNull14;
/* 254 */         double agg_value14 = agg_value15;
/* 255 */         if (agg_isNull13) {
/* 256 */           boolean agg_isNull20 = agg_fastAggBuffer.isNullAt(0);
/* 257 */           double agg_value21 = agg_isNull20 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 258 */           if (!agg_isNull20) {
/* 259 */             agg_isNull13 = false;
/* 260 */             agg_value14 = agg_value21;
/* 261 */           }
/* 262 */         }
/* 263 */         // update fast row
/* 264 */         if (!agg_isNull13) {
/* 265 */           agg_fastAggBuffer.setDouble(0, agg_value14);
/* 266 */         } else {
/* 267 */           agg_fastAggBuffer.setNullAt(0);
/* 268 */         }
/* 269 */
/* 270 */       } else {
/* 271 */         // update unsafe row
/* 272 */
/* 273 */         // common sub-expressions
/* 274 */
/* 275 */         // evaluate aggregate function
/* 276 */         boolean agg_isNull6 = true;
/* 277 */         double agg_value7 = -1.0;
/* 278 */
/* 279 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 280 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 281 */         boolean agg_isNull7 = agg_isNull8;
/* 282 */         double agg_value8 = agg_value9;
/* 283 */         if (agg_isNull7) {
/* 284 */           boolean agg_isNull9 = false;
/* 285 */           double agg_value10 = -1.0;
/* 286 */           if (!false) {
/* 287 */             agg_value10 = (double) 0;
/* 288 */           }
/* 289 */           if (!agg_isNull9) {
/* 290 */             agg_isNull7 = false;
/* 291 */             agg_value8 = agg_value10;
/* 292 */           }
/* 293 */         }
/* 294 */
/* 295 */         if (!inputadapter_isNull1) {
/* 296 */           agg_isNull6 = false; // resultCode could change nullability.
/* 297 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 298 */
/* 299 */         }
/* 300 */         boolean agg_isNull5 = agg_isNull6;
/* 301 */         double agg_value6 = agg_value7;
/* 302 */         if (agg_isNull5) {
/* 303 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 304 */           double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 305 */           if (!agg_isNull12) {
/* 306 */             agg_isNull5 = false;
/* 307 */             agg_value6 = agg_value13;
/* 308 */           }
/* 309 */         }
/* 310 */         // update unsafe row buffer
/* 311 */         if (!agg_isNull5) {
/* 312 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 313 */         } else {
/* 314 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 315 */         }
/* 316 */
/* 317 */       }
/* 318 */       if (shouldStop()) return;
/* 319 */     }
/* 320 */
/* 321 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 322 */
/* 323 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 324 */   }
/* 325 */
/* 326 */   protected void processNext() throws java.io.IOException {
/* 327 */     if (!agg_initAgg) {
/* 328 */       agg_initAgg = true;
/* 329 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 330 */       agg_doAggregateWithKeys();
/* 331 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 332 */     }
/* 333 */
/* 334 */     // output the result
/* 335 */
/* 336 */     while (agg_fastHashMapIter.next()) {
/* 337 */       wholestagecodegen_numOutputRows.add(1);
/* 338 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 339 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 340 */
/* 341 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 342 */
/* 343 */       append(agg_resultRow);
/* 344 */
/* 345 */       if (shouldStop()) return;
/* 346 */     }
/* 347 */     agg_fastHashMap.close();
/* 348 */
/* 349 */     while (agg_mapIter.next()) {
/* 350 */       wholestagecodegen_numOutputRows.add(1);
/* 351 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 352 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 353 */
/* 354 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 355 */
/* 356 */       append(agg_resultRow);
/* 357 */
/* 358 */       if (shouldStop()) return;
/* 359 */     }
/* 360 */
/* 361 */     agg_mapIter.close();
/* 362 */     if (agg_sorter == null) {
/* 363 */       agg_hashMap.free();
/* 364 */     }
/* 365 */   }
/* 366 */ }
