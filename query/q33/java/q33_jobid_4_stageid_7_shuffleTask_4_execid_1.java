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
/* 044 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 045 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 046 */
/* 047 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 048 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 049 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
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
/* 061 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_manufact_id", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 062 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 085 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
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
/* 097 */               0);
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
/* 132 */     private boolean equals(int idx, int agg_key) {
/* 133 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 134 */       return (row.getInt(0) == agg_key);
/* 135 */     }
/* 136 */
/* 137 */     private long hash(int agg_key) {
/* 138 */       long agg_hash = 0;
/* 139 */
/* 140 */       int agg_result = agg_key;
/* 141 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 142 */
/* 143 */       return agg_hash;
/* 144 */     }
/* 145 */
/* 146 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 147 */       return batch.rowIterator();
/* 148 */     }
/* 149 */
/* 150 */     public void close() {
/* 151 */       batch.close();
/* 152 */     }
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 157 */     agg_hashMap = agg_plan.createHashMap();
/* 158 */
/* 159 */     while (inputadapter_input.hasNext()) {
/* 160 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 161 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 162 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 163 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 164 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 165 */
/* 166 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 167 */
/* 168 */       UnsafeRow agg_fastAggBuffer = null;
/* 169 */
/* 170 */       if (true) {
/* 171 */         if (!inputadapter_isNull) {
/* 172 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 173 */             inputadapter_value);
/* 174 */         }
/* 175 */       }
/* 176 */
/* 177 */       if (agg_fastAggBuffer == null) {
/* 178 */         // generate grouping key
/* 179 */         agg_rowWriter.zeroOutNullBytes();
/* 180 */
/* 181 */         if (inputadapter_isNull) {
/* 182 */           agg_rowWriter.setNullAt(0);
/* 183 */         } else {
/* 184 */           agg_rowWriter.write(0, inputadapter_value);
/* 185 */         }
/* 186 */         agg_value4 = 42;
/* 187 */
/* 188 */         if (!inputadapter_isNull) {
/* 189 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value4);
/* 190 */         }
/* 191 */         if (true) {
/* 192 */           // try to get the buffer from hash map
/* 193 */           agg_unsafeRowAggBuffer =
/* 194 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 195 */         }
/* 196 */         if (agg_unsafeRowAggBuffer == null) {
/* 197 */           if (agg_sorter == null) {
/* 198 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 199 */           } else {
/* 200 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 201 */           }
/* 202 */
/* 203 */           // the hash map had be spilled, it should have enough memory now,
/* 204 */           // try  to allocate buffer again.
/* 205 */           agg_unsafeRowAggBuffer =
/* 206 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 207 */           if (agg_unsafeRowAggBuffer == null) {
/* 208 */             // failed to allocate the first page
/* 209 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 210 */           }
/* 211 */         }
/* 212 */       }
/* 213 */
/* 214 */       if (agg_fastAggBuffer != null) {
/* 215 */         // update fast row
/* 216 */
/* 217 */         // common sub-expressions
/* 218 */
/* 219 */         // evaluate aggregate function
/* 220 */         boolean agg_isNull15 = true;
/* 221 */         double agg_value16 = -1.0;
/* 222 */
/* 223 */         boolean agg_isNull17 = agg_fastAggBuffer.isNullAt(0);
/* 224 */         double agg_value18 = agg_isNull17 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 225 */         boolean agg_isNull16 = agg_isNull17;
/* 226 */         double agg_value17 = agg_value18;
/* 227 */         if (agg_isNull16) {
/* 228 */           boolean agg_isNull18 = false;
/* 229 */           double agg_value19 = -1.0;
/* 230 */           if (!false) {
/* 231 */             agg_value19 = (double) 0;
/* 232 */           }
/* 233 */           if (!agg_isNull18) {
/* 234 */             agg_isNull16 = false;
/* 235 */             agg_value17 = agg_value19;
/* 236 */           }
/* 237 */         }
/* 238 */
/* 239 */         boolean agg_isNull20 = inputadapter_isNull1;
/* 240 */         double agg_value21 = -1.0;
/* 241 */         if (!inputadapter_isNull1) {
/* 242 */           agg_value21 = inputadapter_value1;
/* 243 */         }
/* 244 */         if (!agg_isNull20) {
/* 245 */           agg_isNull15 = false; // resultCode could change nullability.
/* 246 */           agg_value16 = agg_value17 + agg_value21;
/* 247 */
/* 248 */         }
/* 249 */         boolean agg_isNull14 = agg_isNull15;
/* 250 */         double agg_value15 = agg_value16;
/* 251 */         if (agg_isNull14) {
/* 252 */           boolean agg_isNull22 = agg_fastAggBuffer.isNullAt(0);
/* 253 */           double agg_value23 = agg_isNull22 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 254 */           if (!agg_isNull22) {
/* 255 */             agg_isNull14 = false;
/* 256 */             agg_value15 = agg_value23;
/* 257 */           }
/* 258 */         }
/* 259 */         // update fast row
/* 260 */         if (!agg_isNull14) {
/* 261 */           agg_fastAggBuffer.setDouble(0, agg_value15);
/* 262 */         } else {
/* 263 */           agg_fastAggBuffer.setNullAt(0);
/* 264 */         }
/* 265 */
/* 266 */       } else {
/* 267 */         // update unsafe row
/* 268 */
/* 269 */         // common sub-expressions
/* 270 */
/* 271 */         // evaluate aggregate function
/* 272 */         boolean agg_isNull6 = true;
/* 273 */         double agg_value7 = -1.0;
/* 274 */
/* 275 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 276 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 277 */         boolean agg_isNull7 = agg_isNull8;
/* 278 */         double agg_value8 = agg_value9;
/* 279 */         if (agg_isNull7) {
/* 280 */           boolean agg_isNull9 = false;
/* 281 */           double agg_value10 = -1.0;
/* 282 */           if (!false) {
/* 283 */             agg_value10 = (double) 0;
/* 284 */           }
/* 285 */           if (!agg_isNull9) {
/* 286 */             agg_isNull7 = false;
/* 287 */             agg_value8 = agg_value10;
/* 288 */           }
/* 289 */         }
/* 290 */
/* 291 */         boolean agg_isNull11 = inputadapter_isNull1;
/* 292 */         double agg_value12 = -1.0;
/* 293 */         if (!inputadapter_isNull1) {
/* 294 */           agg_value12 = inputadapter_value1;
/* 295 */         }
/* 296 */         if (!agg_isNull11) {
/* 297 */           agg_isNull6 = false; // resultCode could change nullability.
/* 298 */           agg_value7 = agg_value8 + agg_value12;
/* 299 */
/* 300 */         }
/* 301 */         boolean agg_isNull5 = agg_isNull6;
/* 302 */         double agg_value6 = agg_value7;
/* 303 */         if (agg_isNull5) {
/* 304 */           boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 305 */           double agg_value14 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 306 */           if (!agg_isNull13) {
/* 307 */             agg_isNull5 = false;
/* 308 */             agg_value6 = agg_value14;
/* 309 */           }
/* 310 */         }
/* 311 */         // update unsafe row buffer
/* 312 */         if (!agg_isNull5) {
/* 313 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 314 */         } else {
/* 315 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 316 */         }
/* 317 */
/* 318 */       }
/* 319 */       if (shouldStop()) return;
/* 320 */     }
/* 321 */
/* 322 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 323 */
/* 324 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 325 */   }
/* 326 */
/* 327 */   protected void processNext() throws java.io.IOException {
/* 328 */     if (!agg_initAgg) {
/* 329 */       agg_initAgg = true;
/* 330 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 331 */       agg_doAggregateWithKeys();
/* 332 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 333 */     }
/* 334 */
/* 335 */     // output the result
/* 336 */
/* 337 */     while (agg_fastHashMapIter.next()) {
/* 338 */       wholestagecodegen_numOutputRows.add(1);
/* 339 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 340 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 341 */
/* 342 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 343 */
/* 344 */       append(agg_resultRow);
/* 345 */
/* 346 */       if (shouldStop()) return;
/* 347 */     }
/* 348 */     agg_fastHashMap.close();
/* 349 */
/* 350 */     while (agg_mapIter.next()) {
/* 351 */       wholestagecodegen_numOutputRows.add(1);
/* 352 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 353 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 354 */
/* 355 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 356 */
/* 357 */       append(agg_resultRow);
/* 358 */
/* 359 */       if (shouldStop()) return;
/* 360 */     }
/* 361 */
/* 362 */     agg_mapIter.close();
/* 363 */     if (agg_sorter == null) {
/* 364 */       agg_hashMap.free();
/* 365 */     }
/* 366 */   }
/* 367 */ }
