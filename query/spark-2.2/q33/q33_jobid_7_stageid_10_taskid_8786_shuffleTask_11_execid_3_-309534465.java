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
/* 061 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
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
/* 159 */     while (inputadapter_input.hasNext() && !stopEarly()) {
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
/* 220 */         boolean agg_isNull14 = true;
/* 221 */         double agg_value15 = -1.0;
/* 222 */
/* 223 */         boolean agg_isNull16 = agg_fastAggBuffer.isNullAt(0);
/* 224 */         double agg_value17 = agg_isNull16 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 225 */         boolean agg_isNull15 = agg_isNull16;
/* 226 */         double agg_value16 = agg_value17;
/* 227 */         if (agg_isNull15) {
/* 228 */           boolean agg_isNull17 = false;
/* 229 */           double agg_value18 = -1.0;
/* 230 */           if (!false) {
/* 231 */             agg_value18 = (double) 0;
/* 232 */           }
/* 233 */           if (!agg_isNull17) {
/* 234 */             agg_isNull15 = false;
/* 235 */             agg_value16 = agg_value18;
/* 236 */           }
/* 237 */         }
/* 238 */
/* 239 */         if (!inputadapter_isNull1) {
/* 240 */           agg_isNull14 = false; // resultCode could change nullability.
/* 241 */           agg_value15 = agg_value16 + inputadapter_value1;
/* 242 */
/* 243 */         }
/* 244 */         boolean agg_isNull13 = agg_isNull14;
/* 245 */         double agg_value14 = agg_value15;
/* 246 */         if (agg_isNull13) {
/* 247 */           boolean agg_isNull20 = agg_fastAggBuffer.isNullAt(0);
/* 248 */           double agg_value21 = agg_isNull20 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 249 */           if (!agg_isNull20) {
/* 250 */             agg_isNull13 = false;
/* 251 */             agg_value14 = agg_value21;
/* 252 */           }
/* 253 */         }
/* 254 */         // update fast row
/* 255 */         if (!agg_isNull13) {
/* 256 */           agg_fastAggBuffer.setDouble(0, agg_value14);
/* 257 */         } else {
/* 258 */           agg_fastAggBuffer.setNullAt(0);
/* 259 */         }
/* 260 */
/* 261 */       } else {
/* 262 */         // update unsafe row
/* 263 */
/* 264 */         // common sub-expressions
/* 265 */
/* 266 */         // evaluate aggregate function
/* 267 */         boolean agg_isNull6 = true;
/* 268 */         double agg_value7 = -1.0;
/* 269 */
/* 270 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 271 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 272 */         boolean agg_isNull7 = agg_isNull8;
/* 273 */         double agg_value8 = agg_value9;
/* 274 */         if (agg_isNull7) {
/* 275 */           boolean agg_isNull9 = false;
/* 276 */           double agg_value10 = -1.0;
/* 277 */           if (!false) {
/* 278 */             agg_value10 = (double) 0;
/* 279 */           }
/* 280 */           if (!agg_isNull9) {
/* 281 */             agg_isNull7 = false;
/* 282 */             agg_value8 = agg_value10;
/* 283 */           }
/* 284 */         }
/* 285 */
/* 286 */         if (!inputadapter_isNull1) {
/* 287 */           agg_isNull6 = false; // resultCode could change nullability.
/* 288 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 289 */
/* 290 */         }
/* 291 */         boolean agg_isNull5 = agg_isNull6;
/* 292 */         double agg_value6 = agg_value7;
/* 293 */         if (agg_isNull5) {
/* 294 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 295 */           double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 296 */           if (!agg_isNull12) {
/* 297 */             agg_isNull5 = false;
/* 298 */             agg_value6 = agg_value13;
/* 299 */           }
/* 300 */         }
/* 301 */         // update unsafe row buffer
/* 302 */         if (!agg_isNull5) {
/* 303 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 304 */         } else {
/* 305 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 306 */         }
/* 307 */
/* 308 */       }
/* 309 */       if (shouldStop()) return;
/* 310 */     }
/* 311 */
/* 312 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 313 */
/* 314 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 315 */   }
/* 316 */
/* 317 */   protected void processNext() throws java.io.IOException {
/* 318 */     if (!agg_initAgg) {
/* 319 */       agg_initAgg = true;
/* 320 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 321 */       agg_doAggregateWithKeys();
/* 322 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 323 */     }
/* 324 */
/* 325 */     // output the result
/* 326 */
/* 327 */     while (agg_fastHashMapIter.next()) {
/* 328 */       wholestagecodegen_numOutputRows.add(1);
/* 329 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 330 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 331 */
/* 332 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 333 */
/* 334 */       append(agg_resultRow);
/* 335 */
/* 336 */       if (shouldStop()) return;
/* 337 */     }
/* 338 */     agg_fastHashMap.close();
/* 339 */
/* 340 */     while (agg_mapIter.next()) {
/* 341 */       wholestagecodegen_numOutputRows.add(1);
/* 342 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 343 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 344 */
/* 345 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 346 */
/* 347 */       append(agg_resultRow);
/* 348 */
/* 349 */       if (shouldStop()) return;
/* 350 */     }
/* 351 */
/* 352 */     agg_mapIter.close();
/* 353 */     if (agg_sorter == null) {
/* 354 */       agg_hashMap.free();
/* 355 */     }
/* 356 */   }
/* 357 */ }
