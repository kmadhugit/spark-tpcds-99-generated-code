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
/* 021 */   private scala.collection.Iterator scan_input;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 024 */   private long scan_scanTime1;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 026 */   private int scan_batchIdx;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 030 */   private UnsafeRow scan_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 034 */   private UnsafeRow filter_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 037 */   private UnsafeRow project_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 040 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 041 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 043 */   private UnsafeRow bhj_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 046 */   private UnsafeRow project_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 052 */   private UnsafeRow bhj_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 055 */   private UnsafeRow project_result2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 058 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 059 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 060 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 061 */   private UnsafeRow bhj_result2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 064 */   private UnsafeRow project_result3;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 067 */   private UnsafeRow agg_result6;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 070 */   private int agg_value16;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 074 */
/* 075 */   public GeneratedIterator(Object[] references) {
/* 076 */     this.references = references;
/* 077 */   }
/* 078 */
/* 079 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 080 */     partitionIndex = index;
/* 081 */     this.inputs = inputs;
/* 082 */     wholestagecodegen_init_0();
/* 083 */     wholestagecodegen_init_1();
/* 084 */     wholestagecodegen_init_2();
/* 085 */     wholestagecodegen_init_3();
/* 086 */     wholestagecodegen_init_4();
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   private void wholestagecodegen_init_0() {
/* 091 */     agg_initAgg = false;
/* 092 */
/* 093 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 094 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 095 */
/* 096 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 097 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 098 */     scan_input = inputs[0];
/* 099 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 100 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 101 */     scan_scanTime1 = 0;
/* 102 */     scan_batch = null;
/* 103 */     scan_batchIdx = 0;
/* 104 */     scan_colInstance0 = null;
/* 105 */     scan_colInstance1 = null;
/* 106 */     scan_colInstance2 = null;
/* 107 */     scan_result = new UnsafeRow(3);
/* 108 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 109 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 110 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */   private void wholestagecodegen_init_3() {
/* 115 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 116 */
/* 117 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 118 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 119 */
/* 120 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 121 */     bhj_result2 = new UnsafeRow(9);
/* 122 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 128);
/* 123 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 124 */     project_result3 = new UnsafeRow(7);
/* 125 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 128);
/* 126 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 127 */     agg_result6 = new UnsafeRow(6);
/* 128 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 128);
/* 129 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */   private void scan_nextBatch() throws java.io.IOException {
/* 134 */     long getBatchStart = System.nanoTime();
/* 135 */     if (scan_input.hasNext()) {
/* 136 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 137 */       scan_numOutputRows.add(scan_batch.numRows());
/* 138 */       scan_batchIdx = 0;
/* 139 */       scan_colInstance0 = scan_batch.column(0);
/* 140 */       scan_colInstance1 = scan_batch.column(1);
/* 141 */       scan_colInstance2 = scan_batch.column(2);
/* 142 */
/* 143 */     }
/* 144 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 145 */   }
/* 146 */
/* 147 */   public class agg_FastHashMap {
/* 148 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 149 */     private int[] buckets;
/* 150 */     private int capacity = 1 << 16;
/* 151 */     private double loadFactor = 0.5;
/* 152 */     private int numBuckets = (int) (capacity / loadFactor);
/* 153 */     private int maxSteps = 2;
/* 154 */     private int numRows = 0;
/* 155 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_category", org.apache.spark.sql.types.DataTypes.StringType)
/* 156 */     .add("i_brand", org.apache.spark.sql.types.DataTypes.StringType)
/* 157 */     .add("s_store_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 158 */     .add("s_company_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 159 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 160 */     .add("d_moy", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 161 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 162 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 163 */     private Object emptyVBase;
/* 164 */     private long emptyVOff;
/* 165 */     private int emptyVLen;
/* 166 */     private boolean isBatchFull = false;
/* 167 */
/* 168 */     public agg_FastHashMap(
/* 169 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 170 */       InternalRow emptyAggregationBuffer) {
/* 171 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 172 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 173 */
/* 174 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 175 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 176 */
/* 177 */       emptyVBase = emptyBuffer;
/* 178 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 179 */       emptyVLen = emptyBuffer.length;
/* 180 */
/* 181 */       buckets = new int[numBuckets];
/* 182 */       java.util.Arrays.fill(buckets, -1);
/* 183 */     }
/* 184 */
/* 185 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 186 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5);
/* 187 */       int step = 0;
/* 188 */       int idx = (int) h & (numBuckets - 1);
/* 189 */       while (step < maxSteps) {
/* 190 */         // Return bucket index if it's either an empty slot or already contains the key
/* 191 */         if (buckets[idx] == -1) {
/* 192 */           if (numRows < capacity && !isBatchFull) {
/* 193 */             // creating the unsafe for new entry
/* 194 */             UnsafeRow agg_result = new UnsafeRow(6);
/* 195 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 196 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 197 */               128);
/* 198 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 199 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 200 */               agg_holder,
/* 201 */               6);
/* 202 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 203 */             agg_rowWriter.zeroOutNullBytes();
/* 204 */             agg_rowWriter.write(0, agg_key);
/* 205 */             agg_rowWriter.write(1, agg_key1);
/* 206 */             agg_rowWriter.write(2, agg_key2);
/* 207 */             agg_rowWriter.write(3, agg_key3);
/* 208 */             agg_rowWriter.write(4, agg_key4);
/* 209 */             agg_rowWriter.write(5, agg_key5);
/* 210 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 211 */             Object kbase = agg_result.getBaseObject();
/* 212 */             long koff = agg_result.getBaseOffset();
/* 213 */             int klen = agg_result.getSizeInBytes();
/* 214 */
/* 215 */             UnsafeRow vRow
/* 216 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 217 */             if (vRow == null) {
/* 218 */               isBatchFull = true;
/* 219 */             } else {
/* 220 */               buckets[idx] = numRows++;
/* 221 */             }
/* 222 */             return vRow;
/* 223 */           } else {
/* 224 */             // No more space
/* 225 */             return null;
/* 226 */           }
/* 227 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5)) {
/* 228 */           return batch.getValueRow(buckets[idx]);
/* 229 */         }
/* 230 */         idx = (idx + 1) & (numBuckets - 1);
/* 231 */         step++;
/* 232 */       }
/* 233 */       // Didn't find it
/* 234 */       return null;
/* 235 */     }
/* 236 */
/* 237 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 238 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 239 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getInt(4) == agg_key4) && (row.getInt(5) == agg_key5);
/* 240 */     }
/* 241 */
/* 242 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 243 */       long agg_hash = 0;
/* 244 */
/* 245 */       int agg_result = 0;
/* 246 */       byte[] agg_bytes = agg_key.getBytes();
/* 247 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 248 */         int agg_hash1 = agg_bytes[i];
/* 249 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 250 */       }
/* 251 */
/* 252 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 253 */
/* 254 */       int agg_result1 = 0;
/* 255 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 256 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 257 */         int agg_hash2 = agg_bytes1[i];
/* 258 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 259 */       }
/* 260 */
/* 261 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 262 */
/* 263 */       int agg_result2 = 0;
/* 264 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 265 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 266 */         int agg_hash3 = agg_bytes2[i];
/* 267 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 268 */       }
/* 269 */
/* 270 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 271 */
/* 272 */       int agg_result3 = 0;
/* 273 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 274 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 275 */         int agg_hash4 = agg_bytes3[i];
/* 276 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 277 */       }
/* 278 */
/* 279 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 280 */
/* 281 */       int agg_result4 = agg_key4;
/* 282 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 283 */
/* 284 */       int agg_result5 = agg_key5;
/* 285 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 286 */
/* 287 */       return agg_hash;
/* 288 */     }
/* 289 */
/* 290 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 291 */       return batch.rowIterator();
/* 292 */     }
/* 293 */
/* 294 */     public void close() {
/* 295 */       batch.close();
/* 296 */     }
/* 297 */
/* 298 */   }
/* 299 */
/* 300 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 301 */     agg_hashMap = agg_plan.createHashMap();
/* 302 */
/* 303 */     if (scan_batch == null) {
/* 304 */       scan_nextBatch();
/* 305 */     }
/* 306 */     while (scan_batch != null) {
/* 307 */       int numRows = scan_batch.numRows();
/* 308 */       while (scan_batchIdx < numRows) {
/* 309 */         int scan_rowIdx = scan_batchIdx++;
/* 310 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 311 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 312 */
/* 313 */         if (!(!(scan_isNull))) continue;
/* 314 */
/* 315 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 316 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 317 */
/* 318 */         if (!(!(scan_isNull2))) continue;
/* 319 */
/* 320 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 321 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 322 */
/* 323 */         if (!(!(scan_isNull1))) continue;
/* 324 */
/* 325 */         filter_numOutputRows.add(1);
/* 326 */
/* 327 */         // generate join key for stream side
/* 328 */
/* 329 */         boolean bhj_isNull = false;
/* 330 */         long bhj_value = -1L;
/* 331 */         if (!false) {
/* 332 */           bhj_value = (long) scan_value;
/* 333 */         }
/* 334 */         // find matches from HashedRelation
/* 335 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 336 */         if (bhj_matched == null) continue;
/* 337 */
/* 338 */         bhj_numOutputRows.add(1);
/* 339 */
/* 340 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 341 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 342 */
/* 343 */         // generate join key for stream side
/* 344 */
/* 345 */         boolean bhj_isNull13 = bhj_isNull5;
/* 346 */         long bhj_value13 = -1L;
/* 347 */         if (!bhj_isNull5) {
/* 348 */           bhj_value13 = (long) bhj_value5;
/* 349 */         }
/* 350 */         // find matches from HashedRelation
/* 351 */         UnsafeRow bhj_matched1 = bhj_isNull13 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value13);
/* 352 */         if (bhj_matched1 == null) continue;
/* 353 */
/* 354 */         bhj_numOutputRows1.add(1);
/* 355 */
/* 356 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 357 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 358 */
/* 359 */         // generate join key for stream side
/* 360 */
/* 361 */         boolean bhj_isNull26 = bhj_isNull3;
/* 362 */         long bhj_value26 = -1L;
/* 363 */         if (!bhj_isNull3) {
/* 364 */           bhj_value26 = (long) bhj_value3;
/* 365 */         }
/* 366 */         // find matches from HashedRelation
/* 367 */         UnsafeRow bhj_matched2 = bhj_isNull26 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value26);
/* 368 */         if (bhj_matched2 == null) continue;
/* 369 */
/* 370 */         bhj_numOutputRows2.add(1);
/* 371 */
/* 372 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 373 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 374 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(1);
/* 375 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(1));
/* 376 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(2);
/* 377 */         int bhj_value17 = bhj_isNull17 ? -1 : (bhj_matched1.getInt(2));
/* 378 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(1);
/* 379 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(1));
/* 380 */         boolean bhj_isNull30 = bhj_matched2.isNullAt(2);
/* 381 */         UTF8String bhj_value30 = bhj_isNull30 ? null : (bhj_matched2.getUTF8String(2));
/* 382 */
/* 383 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 384 */
/* 385 */         UnsafeRow agg_fastAggBuffer = null;
/* 386 */
/* 387 */         if (true) {
/* 388 */           if (!false && !false && !bhj_isNull29 && !bhj_isNull30 && !bhj_isNull16 && !bhj_isNull17) {
/* 389 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 390 */               scan_value2, scan_value1, bhj_value29, bhj_value30, bhj_value16, bhj_value17);
/* 391 */           }
/* 392 */         }
/* 393 */
/* 394 */         if (agg_fastAggBuffer == null) {
/* 395 */           // generate grouping key
/* 396 */           agg_holder.reset();
/* 397 */
/* 398 */           agg_rowWriter.zeroOutNullBytes();
/* 399 */
/* 400 */           agg_rowWriter.write(0, scan_value2);
/* 401 */
/* 402 */           agg_rowWriter.write(1, scan_value1);
/* 403 */
/* 404 */           if (bhj_isNull29) {
/* 405 */             agg_rowWriter.setNullAt(2);
/* 406 */           } else {
/* 407 */             agg_rowWriter.write(2, bhj_value29);
/* 408 */           }
/* 409 */
/* 410 */           if (bhj_isNull30) {
/* 411 */             agg_rowWriter.setNullAt(3);
/* 412 */           } else {
/* 413 */             agg_rowWriter.write(3, bhj_value30);
/* 414 */           }
/* 415 */
/* 416 */           if (bhj_isNull16) {
/* 417 */             agg_rowWriter.setNullAt(4);
/* 418 */           } else {
/* 419 */             agg_rowWriter.write(4, bhj_value16);
/* 420 */           }
/* 421 */
/* 422 */           if (bhj_isNull17) {
/* 423 */             agg_rowWriter.setNullAt(5);
/* 424 */           } else {
/* 425 */             agg_rowWriter.write(5, bhj_value17);
/* 426 */           }
/* 427 */           agg_result6.setTotalSize(agg_holder.totalSize());
/* 428 */           agg_value16 = 42;
/* 429 */
/* 430 */           if (!false) {
/* 431 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value16);
/* 432 */           }
/* 433 */
/* 434 */           if (!false) {
/* 435 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value16);
/* 436 */           }
/* 437 */
/* 438 */           if (!bhj_isNull29) {
/* 439 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value16);
/* 440 */           }
/* 441 */
/* 442 */           if (!bhj_isNull30) {
/* 443 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value30.getBaseObject(), bhj_value30.getBaseOffset(), bhj_value30.numBytes(), agg_value16);
/* 444 */           }
/* 445 */
/* 446 */           if (!bhj_isNull16) {
/* 447 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value16);
/* 448 */           }
/* 449 */
/* 450 */           if (!bhj_isNull17) {
/* 451 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value17, agg_value16);
/* 452 */           }
/* 453 */           if (true) {
/* 454 */             // try to get the buffer from hash map
/* 455 */             agg_unsafeRowAggBuffer =
/* 456 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 457 */           }
/* 458 */           if (agg_unsafeRowAggBuffer == null) {
/* 459 */             if (agg_sorter == null) {
/* 460 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 461 */             } else {
/* 462 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 463 */             }
/* 464 */
/* 465 */             // the hash map had be spilled, it should have enough memory now,
/* 466 */             // try  to allocate buffer again.
/* 467 */             agg_unsafeRowAggBuffer =
/* 468 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 469 */             if (agg_unsafeRowAggBuffer == null) {
/* 470 */               // failed to allocate the first page
/* 471 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 472 */             }
/* 473 */           }
/* 474 */         }
/* 475 */
/* 476 */         if (agg_fastAggBuffer != null) {
/* 477 */           // update fast row
/* 478 */
/* 479 */           // common sub-expressions
/* 480 */           boolean agg_isNull35 = bhj_isNull4;
/* 481 */           double agg_value37 = -1.0;
/* 482 */           if (!bhj_isNull4) {
/* 483 */             agg_value37 = bhj_value4;
/* 484 */           }
/* 485 */           boolean agg_isNull37 = false;
/* 486 */           double agg_value39 = -1.0;
/* 487 */           if (!false) {
/* 488 */             agg_value39 = (double) 0;
/* 489 */           }
/* 490 */           // evaluate aggregate function
/* 491 */           boolean agg_isNull40 = true;
/* 492 */           double agg_value42 = -1.0;
/* 493 */
/* 494 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 495 */           double agg_value44 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 496 */           boolean agg_isNull41 = agg_isNull42;
/* 497 */           double agg_value43 = agg_value44;
/* 498 */           if (agg_isNull41) {
/* 499 */             if (!agg_isNull37) {
/* 500 */               agg_isNull41 = false;
/* 501 */               agg_value43 = agg_value39;
/* 502 */             }
/* 503 */           }
/* 504 */
/* 505 */           if (!agg_isNull35) {
/* 506 */             agg_isNull40 = false; // resultCode could change nullability.
/* 507 */             agg_value42 = agg_value43 + agg_value37;
/* 508 */
/* 509 */           }
/* 510 */           boolean agg_isNull39 = agg_isNull40;
/* 511 */           double agg_value41 = agg_value42;
/* 512 */           if (agg_isNull39) {
/* 513 */             boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 514 */             double agg_value45 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 515 */             if (!agg_isNull43) {
/* 516 */               agg_isNull39 = false;
/* 517 */               agg_value41 = agg_value45;
/* 518 */             }
/* 519 */           }
/* 520 */           boolean agg_isNull45 = true;
/* 521 */           double agg_value47 = -1.0;
/* 522 */
/* 523 */           boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(1);
/* 524 */           double agg_value49 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 525 */           boolean agg_isNull46 = agg_isNull47;
/* 526 */           double agg_value48 = agg_value49;
/* 527 */           if (agg_isNull46) {
/* 528 */             if (!agg_isNull37) {
/* 529 */               agg_isNull46 = false;
/* 530 */               agg_value48 = agg_value39;
/* 531 */             }
/* 532 */           }
/* 533 */
/* 534 */           if (!agg_isNull35) {
/* 535 */             agg_isNull45 = false; // resultCode could change nullability.
/* 536 */             agg_value47 = agg_value48 + agg_value37;
/* 537 */
/* 538 */           }
/* 539 */           boolean agg_isNull44 = agg_isNull45;
/* 540 */           double agg_value46 = agg_value47;
/* 541 */           if (agg_isNull44) {
/* 542 */             boolean agg_isNull48 = agg_fastAggBuffer.isNullAt(1);
/* 543 */             double agg_value50 = agg_isNull48 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 544 */             if (!agg_isNull48) {
/* 545 */               agg_isNull44 = false;
/* 546 */               agg_value46 = agg_value50;
/* 547 */             }
/* 548 */           }
/* 549 */           // update fast row
/* 550 */           if (!agg_isNull39) {
/* 551 */             agg_fastAggBuffer.setDouble(0, agg_value41);
/* 552 */           } else {
/* 553 */             agg_fastAggBuffer.setNullAt(0);
/* 554 */           }
/* 555 */
/* 556 */           if (!agg_isNull44) {
/* 557 */             agg_fastAggBuffer.setDouble(1, agg_value46);
/* 558 */           } else {
/* 559 */             agg_fastAggBuffer.setNullAt(1);
/* 560 */           }
/* 561 */
/* 562 */         } else {
/* 563 */           // update unsafe row
/* 564 */
/* 565 */           // common sub-expressions
/* 566 */           boolean agg_isNull21 = bhj_isNull4;
/* 567 */           double agg_value23 = -1.0;
/* 568 */           if (!bhj_isNull4) {
/* 569 */             agg_value23 = bhj_value4;
/* 570 */           }
/* 571 */           boolean agg_isNull23 = false;
/* 572 */           double agg_value25 = -1.0;
/* 573 */           if (!false) {
/* 574 */             agg_value25 = (double) 0;
/* 575 */           }
/* 576 */           // evaluate aggregate function
/* 577 */           boolean agg_isNull26 = true;
/* 578 */           double agg_value28 = -1.0;
/* 579 */
/* 580 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 581 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 582 */           boolean agg_isNull27 = agg_isNull28;
/* 583 */           double agg_value29 = agg_value30;
/* 584 */           if (agg_isNull27) {
/* 585 */             if (!agg_isNull23) {
/* 586 */               agg_isNull27 = false;
/* 587 */               agg_value29 = agg_value25;
/* 588 */             }
/* 589 */           }
/* 590 */
/* 591 */           if (!agg_isNull21) {
/* 592 */             agg_isNull26 = false; // resultCode could change nullability.
/* 593 */             agg_value28 = agg_value29 + agg_value23;
/* 594 */
/* 595 */           }
/* 596 */           boolean agg_isNull25 = agg_isNull26;
/* 597 */           double agg_value27 = agg_value28;
/* 598 */           if (agg_isNull25) {
/* 599 */             boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 600 */             double agg_value31 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 601 */             if (!agg_isNull29) {
/* 602 */               agg_isNull25 = false;
/* 603 */               agg_value27 = agg_value31;
/* 604 */             }
/* 605 */           }
/* 606 */           boolean agg_isNull31 = true;
/* 607 */           double agg_value33 = -1.0;
/* 608 */
/* 609 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 610 */           double agg_value35 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 611 */           boolean agg_isNull32 = agg_isNull33;
/* 612 */           double agg_value34 = agg_value35;
/* 613 */           if (agg_isNull32) {
/* 614 */             if (!agg_isNull23) {
/* 615 */               agg_isNull32 = false;
/* 616 */               agg_value34 = agg_value25;
/* 617 */             }
/* 618 */           }
/* 619 */
/* 620 */           if (!agg_isNull21) {
/* 621 */             agg_isNull31 = false; // resultCode could change nullability.
/* 622 */             agg_value33 = agg_value34 + agg_value23;
/* 623 */
/* 624 */           }
/* 625 */           boolean agg_isNull30 = agg_isNull31;
/* 626 */           double agg_value32 = agg_value33;
/* 627 */           if (agg_isNull30) {
/* 628 */             boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 629 */             double agg_value36 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 630 */             if (!agg_isNull34) {
/* 631 */               agg_isNull30 = false;
/* 632 */               agg_value32 = agg_value36;
/* 633 */             }
/* 634 */           }
/* 635 */           // update unsafe row buffer
/* 636 */           if (!agg_isNull25) {
/* 637 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 638 */           } else {
/* 639 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 640 */           }
/* 641 */
/* 642 */           if (!agg_isNull30) {
/* 643 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value32);
/* 644 */           } else {
/* 645 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 646 */           }
/* 647 */
/* 648 */         }
/* 649 */         if (shouldStop()) return;
/* 650 */       }
/* 651 */       scan_batch = null;
/* 652 */       scan_nextBatch();
/* 653 */     }
/* 654 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 655 */     scan_scanTime1 = 0;
/* 656 */
/* 657 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 658 */
/* 659 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 660 */   }
/* 661 */
/* 662 */   private void wholestagecodegen_init_2() {
/* 663 */     project_result1 = new UnsafeRow(5);
/* 664 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 665 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 666 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 667 */
/* 668 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 669 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 670 */
/* 671 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 672 */     bhj_result1 = new UnsafeRow(8);
/* 673 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 674 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 675 */     project_result2 = new UnsafeRow(6);
/* 676 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 677 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 678 */
/* 679 */   }
/* 680 */
/* 681 */   private void wholestagecodegen_init_1() {
/* 682 */     filter_result = new UnsafeRow(3);
/* 683 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 684 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 685 */     project_result = new UnsafeRow(3);
/* 686 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 687 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 688 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 689 */
/* 690 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 691 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 692 */
/* 693 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 694 */     bhj_result = new UnsafeRow(7);
/* 695 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 696 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 697 */
/* 698 */   }
/* 699 */
/* 700 */   private void wholestagecodegen_init_4() {
/* 701 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 702 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 703 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 704 */
/* 705 */   }
/* 706 */
/* 707 */   protected void processNext() throws java.io.IOException {
/* 708 */     if (!agg_initAgg) {
/* 709 */       agg_initAgg = true;
/* 710 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 711 */       agg_doAggregateWithKeys();
/* 712 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 713 */     }
/* 714 */
/* 715 */     // output the result
/* 716 */
/* 717 */     while (agg_fastHashMapIter.next()) {
/* 718 */       wholestagecodegen_numOutputRows.add(1);
/* 719 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 720 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 721 */
/* 722 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 723 */
/* 724 */       append(agg_resultRow);
/* 725 */
/* 726 */       if (shouldStop()) return;
/* 727 */     }
/* 728 */     agg_fastHashMap.close();
/* 729 */
/* 730 */     while (agg_mapIter.next()) {
/* 731 */       wholestagecodegen_numOutputRows.add(1);
/* 732 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 733 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 734 */
/* 735 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 736 */
/* 737 */       append(agg_resultRow);
/* 738 */
/* 739 */       if (shouldStop()) return;
/* 740 */     }
/* 741 */
/* 742 */     agg_mapIter.close();
/* 743 */     if (agg_sorter == null) {
/* 744 */       agg_hashMap.free();
/* 745 */     }
/* 746 */   }
/* 747 */ }
