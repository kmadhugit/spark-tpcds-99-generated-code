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
/* 019 */   private scala.collection.Iterator scan_input;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 022 */   private long scan_scanTime1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 024 */   private int scan_batchIdx;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 028 */   private UnsafeRow scan_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 032 */   private UnsafeRow filter_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 041 */   private UnsafeRow bhj_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 048 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 050 */   private UnsafeRow bhj_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 053 */   private UnsafeRow project_result2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 056 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 057 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 059 */   private UnsafeRow bhj_result2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 062 */   private UnsafeRow project_result3;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 065 */   private UnsafeRow agg_result6;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 068 */   private int agg_value14;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 070 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 072 */
/* 073 */   public GeneratedIterator(Object[] references) {
/* 074 */     this.references = references;
/* 075 */   }
/* 076 */
/* 077 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 078 */     partitionIndex = index;
/* 079 */     this.inputs = inputs;
/* 080 */     wholestagecodegen_init_0();
/* 081 */     wholestagecodegen_init_1();
/* 082 */     wholestagecodegen_init_2();
/* 083 */     wholestagecodegen_init_3();
/* 084 */     wholestagecodegen_init_4();
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */   private void wholestagecodegen_init_0() {
/* 089 */     agg_initAgg = false;
/* 090 */
/* 091 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 092 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 093 */
/* 094 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 095 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 096 */     scan_input = inputs[0];
/* 097 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 098 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 099 */     scan_scanTime1 = 0;
/* 100 */     scan_batch = null;
/* 101 */     scan_batchIdx = 0;
/* 102 */     scan_colInstance0 = null;
/* 103 */     scan_colInstance1 = null;
/* 104 */     scan_colInstance2 = null;
/* 105 */     scan_result = new UnsafeRow(3);
/* 106 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 107 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 108 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 109 */
/* 110 */   }
/* 111 */
/* 112 */   private void wholestagecodegen_init_3() {
/* 113 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 114 */
/* 115 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 116 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 117 */
/* 118 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 119 */     bhj_result2 = new UnsafeRow(9);
/* 120 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 128);
/* 121 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 122 */     project_result3 = new UnsafeRow(7);
/* 123 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 128);
/* 124 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 125 */     agg_result6 = new UnsafeRow(6);
/* 126 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 128);
/* 127 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void scan_nextBatch() throws java.io.IOException {
/* 132 */     long getBatchStart = System.nanoTime();
/* 133 */     if (scan_input.hasNext()) {
/* 134 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 135 */       scan_numOutputRows.add(scan_batch.numRows());
/* 136 */       scan_batchIdx = 0;
/* 137 */       scan_colInstance0 = scan_batch.column(0);
/* 138 */       scan_colInstance1 = scan_batch.column(1);
/* 139 */       scan_colInstance2 = scan_batch.column(2);
/* 140 */
/* 141 */     }
/* 142 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 143 */   }
/* 144 */
/* 145 */   public class agg_FastHashMap {
/* 146 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 147 */     private int[] buckets;
/* 148 */     private int capacity = 1 << 16;
/* 149 */     private double loadFactor = 0.5;
/* 150 */     private int numBuckets = (int) (capacity / loadFactor);
/* 151 */     private int maxSteps = 2;
/* 152 */     private int numRows = 0;
/* 153 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_category", org.apache.spark.sql.types.DataTypes.StringType)
/* 154 */     .add("i_brand", org.apache.spark.sql.types.DataTypes.StringType)
/* 155 */     .add("s_store_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 156 */     .add("s_company_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 157 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 158 */     .add("d_moy", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 159 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 160 */     private Object emptyVBase;
/* 161 */     private long emptyVOff;
/* 162 */     private int emptyVLen;
/* 163 */     private boolean isBatchFull = false;
/* 164 */
/* 165 */     public agg_FastHashMap(
/* 166 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 167 */       InternalRow emptyAggregationBuffer) {
/* 168 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 169 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 170 */
/* 171 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 172 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 173 */
/* 174 */       emptyVBase = emptyBuffer;
/* 175 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 176 */       emptyVLen = emptyBuffer.length;
/* 177 */
/* 178 */       buckets = new int[numBuckets];
/* 179 */       java.util.Arrays.fill(buckets, -1);
/* 180 */     }
/* 181 */
/* 182 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 183 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5);
/* 184 */       int step = 0;
/* 185 */       int idx = (int) h & (numBuckets - 1);
/* 186 */       while (step < maxSteps) {
/* 187 */         // Return bucket index if it's either an empty slot or already contains the key
/* 188 */         if (buckets[idx] == -1) {
/* 189 */           if (numRows < capacity && !isBatchFull) {
/* 190 */             // creating the unsafe for new entry
/* 191 */             UnsafeRow agg_result = new UnsafeRow(6);
/* 192 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 193 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 194 */               128);
/* 195 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 196 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 197 */               agg_holder,
/* 198 */               6);
/* 199 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 200 */             agg_rowWriter.zeroOutNullBytes();
/* 201 */             agg_rowWriter.write(0, agg_key);
/* 202 */             agg_rowWriter.write(1, agg_key1);
/* 203 */             agg_rowWriter.write(2, agg_key2);
/* 204 */             agg_rowWriter.write(3, agg_key3);
/* 205 */             agg_rowWriter.write(4, agg_key4);
/* 206 */             agg_rowWriter.write(5, agg_key5);
/* 207 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 208 */             Object kbase = agg_result.getBaseObject();
/* 209 */             long koff = agg_result.getBaseOffset();
/* 210 */             int klen = agg_result.getSizeInBytes();
/* 211 */
/* 212 */             UnsafeRow vRow
/* 213 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 214 */             if (vRow == null) {
/* 215 */               isBatchFull = true;
/* 216 */             } else {
/* 217 */               buckets[idx] = numRows++;
/* 218 */             }
/* 219 */             return vRow;
/* 220 */           } else {
/* 221 */             // No more space
/* 222 */             return null;
/* 223 */           }
/* 224 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5)) {
/* 225 */           return batch.getValueRow(buckets[idx]);
/* 226 */         }
/* 227 */         idx = (idx + 1) & (numBuckets - 1);
/* 228 */         step++;
/* 229 */       }
/* 230 */       // Didn't find it
/* 231 */       return null;
/* 232 */     }
/* 233 */
/* 234 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 235 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 236 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getInt(4) == agg_key4) && (row.getInt(5) == agg_key5);
/* 237 */     }
/* 238 */
/* 239 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 240 */       long agg_hash = 0;
/* 241 */
/* 242 */       int agg_result = 0;
/* 243 */       byte[] agg_bytes = agg_key.getBytes();
/* 244 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 245 */         int agg_hash1 = agg_bytes[i];
/* 246 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 247 */       }
/* 248 */
/* 249 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 250 */
/* 251 */       int agg_result1 = 0;
/* 252 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 253 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 254 */         int agg_hash2 = agg_bytes1[i];
/* 255 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 256 */       }
/* 257 */
/* 258 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 259 */
/* 260 */       int agg_result2 = 0;
/* 261 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 262 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 263 */         int agg_hash3 = agg_bytes2[i];
/* 264 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 265 */       }
/* 266 */
/* 267 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 268 */
/* 269 */       int agg_result3 = 0;
/* 270 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 271 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 272 */         int agg_hash4 = agg_bytes3[i];
/* 273 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 274 */       }
/* 275 */
/* 276 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 277 */
/* 278 */       int agg_result4 = agg_key4;
/* 279 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 280 */
/* 281 */       int agg_result5 = agg_key5;
/* 282 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 283 */
/* 284 */       return agg_hash;
/* 285 */     }
/* 286 */
/* 287 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 288 */       return batch.rowIterator();
/* 289 */     }
/* 290 */
/* 291 */     public void close() {
/* 292 */       batch.close();
/* 293 */     }
/* 294 */
/* 295 */   }
/* 296 */
/* 297 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 298 */     agg_hashMap = agg_plan.createHashMap();
/* 299 */
/* 300 */     if (scan_batch == null) {
/* 301 */       scan_nextBatch();
/* 302 */     }
/* 303 */     while (scan_batch != null) {
/* 304 */       int numRows = scan_batch.numRows();
/* 305 */       while (scan_batchIdx < numRows) {
/* 306 */         int scan_rowIdx = scan_batchIdx++;
/* 307 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 308 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 309 */
/* 310 */         if (!(!(scan_isNull))) continue;
/* 311 */
/* 312 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 313 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 314 */
/* 315 */         if (!(!(scan_isNull2))) continue;
/* 316 */
/* 317 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 318 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 319 */
/* 320 */         if (!(!(scan_isNull1))) continue;
/* 321 */
/* 322 */         filter_numOutputRows.add(1);
/* 323 */
/* 324 */         // generate join key for stream side
/* 325 */
/* 326 */         boolean bhj_isNull = false;
/* 327 */         long bhj_value = -1L;
/* 328 */         if (!false) {
/* 329 */           bhj_value = (long) scan_value;
/* 330 */         }
/* 331 */         // find matches from HashedRelation
/* 332 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 333 */         if (bhj_matched == null) continue;
/* 334 */
/* 335 */         bhj_numOutputRows.add(1);
/* 336 */
/* 337 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 338 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 339 */
/* 340 */         // generate join key for stream side
/* 341 */
/* 342 */         boolean bhj_isNull13 = bhj_isNull5;
/* 343 */         long bhj_value13 = -1L;
/* 344 */         if (!bhj_isNull5) {
/* 345 */           bhj_value13 = (long) bhj_value5;
/* 346 */         }
/* 347 */         // find matches from HashedRelation
/* 348 */         UnsafeRow bhj_matched1 = bhj_isNull13 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value13);
/* 349 */         if (bhj_matched1 == null) continue;
/* 350 */
/* 351 */         bhj_numOutputRows1.add(1);
/* 352 */
/* 353 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 354 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 355 */
/* 356 */         // generate join key for stream side
/* 357 */
/* 358 */         boolean bhj_isNull26 = bhj_isNull3;
/* 359 */         long bhj_value26 = -1L;
/* 360 */         if (!bhj_isNull3) {
/* 361 */           bhj_value26 = (long) bhj_value3;
/* 362 */         }
/* 363 */         // find matches from HashedRelation
/* 364 */         UnsafeRow bhj_matched2 = bhj_isNull26 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value26);
/* 365 */         if (bhj_matched2 == null) continue;
/* 366 */
/* 367 */         bhj_numOutputRows2.add(1);
/* 368 */
/* 369 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 370 */         double bhj_value4 = bhj_isNull4 ? -1.0 : (bhj_matched.getDouble(2));
/* 371 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(1);
/* 372 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(1));
/* 373 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(2);
/* 374 */         int bhj_value17 = bhj_isNull17 ? -1 : (bhj_matched1.getInt(2));
/* 375 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(1);
/* 376 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(1));
/* 377 */         boolean bhj_isNull30 = bhj_matched2.isNullAt(2);
/* 378 */         UTF8String bhj_value30 = bhj_isNull30 ? null : (bhj_matched2.getUTF8String(2));
/* 379 */
/* 380 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 381 */
/* 382 */         UnsafeRow agg_fastAggBuffer = null;
/* 383 */
/* 384 */         if (true) {
/* 385 */           if (!false && !false && !bhj_isNull29 && !bhj_isNull30 && !bhj_isNull16 && !bhj_isNull17) {
/* 386 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 387 */               scan_value2, scan_value1, bhj_value29, bhj_value30, bhj_value16, bhj_value17);
/* 388 */           }
/* 389 */         }
/* 390 */
/* 391 */         if (agg_fastAggBuffer == null) {
/* 392 */           // generate grouping key
/* 393 */           agg_holder.reset();
/* 394 */
/* 395 */           agg_rowWriter.zeroOutNullBytes();
/* 396 */
/* 397 */           agg_rowWriter.write(0, scan_value2);
/* 398 */
/* 399 */           agg_rowWriter.write(1, scan_value1);
/* 400 */
/* 401 */           if (bhj_isNull29) {
/* 402 */             agg_rowWriter.setNullAt(2);
/* 403 */           } else {
/* 404 */             agg_rowWriter.write(2, bhj_value29);
/* 405 */           }
/* 406 */
/* 407 */           if (bhj_isNull30) {
/* 408 */             agg_rowWriter.setNullAt(3);
/* 409 */           } else {
/* 410 */             agg_rowWriter.write(3, bhj_value30);
/* 411 */           }
/* 412 */
/* 413 */           if (bhj_isNull16) {
/* 414 */             agg_rowWriter.setNullAt(4);
/* 415 */           } else {
/* 416 */             agg_rowWriter.write(4, bhj_value16);
/* 417 */           }
/* 418 */
/* 419 */           if (bhj_isNull17) {
/* 420 */             agg_rowWriter.setNullAt(5);
/* 421 */           } else {
/* 422 */             agg_rowWriter.write(5, bhj_value17);
/* 423 */           }
/* 424 */           agg_result6.setTotalSize(agg_holder.totalSize());
/* 425 */           agg_value14 = 42;
/* 426 */
/* 427 */           if (!false) {
/* 428 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value14);
/* 429 */           }
/* 430 */
/* 431 */           if (!false) {
/* 432 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value14);
/* 433 */           }
/* 434 */
/* 435 */           if (!bhj_isNull29) {
/* 436 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value14);
/* 437 */           }
/* 438 */
/* 439 */           if (!bhj_isNull30) {
/* 440 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value30.getBaseObject(), bhj_value30.getBaseOffset(), bhj_value30.numBytes(), agg_value14);
/* 441 */           }
/* 442 */
/* 443 */           if (!bhj_isNull16) {
/* 444 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value14);
/* 445 */           }
/* 446 */
/* 447 */           if (!bhj_isNull17) {
/* 448 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value17, agg_value14);
/* 449 */           }
/* 450 */           if (true) {
/* 451 */             // try to get the buffer from hash map
/* 452 */             agg_unsafeRowAggBuffer =
/* 453 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value14);
/* 454 */           }
/* 455 */           if (agg_unsafeRowAggBuffer == null) {
/* 456 */             if (agg_sorter == null) {
/* 457 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 458 */             } else {
/* 459 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 460 */             }
/* 461 */
/* 462 */             // the hash map had be spilled, it should have enough memory now,
/* 463 */             // try  to allocate buffer again.
/* 464 */             agg_unsafeRowAggBuffer =
/* 465 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value14);
/* 466 */             if (agg_unsafeRowAggBuffer == null) {
/* 467 */               // failed to allocate the first page
/* 468 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 469 */             }
/* 470 */           }
/* 471 */         }
/* 472 */
/* 473 */         if (agg_fastAggBuffer != null) {
/* 474 */           // update fast row
/* 475 */
/* 476 */           // common sub-expressions
/* 477 */
/* 478 */           // evaluate aggregate function
/* 479 */           boolean agg_isNull30 = true;
/* 480 */           double agg_value31 = -1.0;
/* 481 */
/* 482 */           boolean agg_isNull32 = agg_fastAggBuffer.isNullAt(0);
/* 483 */           double agg_value33 = agg_isNull32 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 484 */           boolean agg_isNull31 = agg_isNull32;
/* 485 */           double agg_value32 = agg_value33;
/* 486 */           if (agg_isNull31) {
/* 487 */             boolean agg_isNull33 = false;
/* 488 */             double agg_value34 = -1.0;
/* 489 */             if (!false) {
/* 490 */               agg_value34 = (double) 0;
/* 491 */             }
/* 492 */             if (!agg_isNull33) {
/* 493 */               agg_isNull31 = false;
/* 494 */               agg_value32 = agg_value34;
/* 495 */             }
/* 496 */           }
/* 497 */
/* 498 */           boolean agg_isNull35 = bhj_isNull4;
/* 499 */           double agg_value36 = -1.0;
/* 500 */           if (!bhj_isNull4) {
/* 501 */             agg_value36 = bhj_value4;
/* 502 */           }
/* 503 */           if (!agg_isNull35) {
/* 504 */             agg_isNull30 = false; // resultCode could change nullability.
/* 505 */             agg_value31 = agg_value32 + agg_value36;
/* 506 */
/* 507 */           }
/* 508 */           boolean agg_isNull29 = agg_isNull30;
/* 509 */           double agg_value30 = agg_value31;
/* 510 */           if (agg_isNull29) {
/* 511 */             boolean agg_isNull37 = agg_fastAggBuffer.isNullAt(0);
/* 512 */             double agg_value38 = agg_isNull37 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 513 */             if (!agg_isNull37) {
/* 514 */               agg_isNull29 = false;
/* 515 */               agg_value30 = agg_value38;
/* 516 */             }
/* 517 */           }
/* 518 */           // update fast row
/* 519 */           if (!agg_isNull29) {
/* 520 */             agg_fastAggBuffer.setDouble(0, agg_value30);
/* 521 */           } else {
/* 522 */             agg_fastAggBuffer.setNullAt(0);
/* 523 */           }
/* 524 */
/* 525 */         } else {
/* 526 */           // update unsafe row
/* 527 */
/* 528 */           // common sub-expressions
/* 529 */
/* 530 */           // evaluate aggregate function
/* 531 */           boolean agg_isNull21 = true;
/* 532 */           double agg_value22 = -1.0;
/* 533 */
/* 534 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 535 */           double agg_value24 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 536 */           boolean agg_isNull22 = agg_isNull23;
/* 537 */           double agg_value23 = agg_value24;
/* 538 */           if (agg_isNull22) {
/* 539 */             boolean agg_isNull24 = false;
/* 540 */             double agg_value25 = -1.0;
/* 541 */             if (!false) {
/* 542 */               agg_value25 = (double) 0;
/* 543 */             }
/* 544 */             if (!agg_isNull24) {
/* 545 */               agg_isNull22 = false;
/* 546 */               agg_value23 = agg_value25;
/* 547 */             }
/* 548 */           }
/* 549 */
/* 550 */           boolean agg_isNull26 = bhj_isNull4;
/* 551 */           double agg_value27 = -1.0;
/* 552 */           if (!bhj_isNull4) {
/* 553 */             agg_value27 = bhj_value4;
/* 554 */           }
/* 555 */           if (!agg_isNull26) {
/* 556 */             agg_isNull21 = false; // resultCode could change nullability.
/* 557 */             agg_value22 = agg_value23 + agg_value27;
/* 558 */
/* 559 */           }
/* 560 */           boolean agg_isNull20 = agg_isNull21;
/* 561 */           double agg_value21 = agg_value22;
/* 562 */           if (agg_isNull20) {
/* 563 */             boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 564 */             double agg_value29 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 565 */             if (!agg_isNull28) {
/* 566 */               agg_isNull20 = false;
/* 567 */               agg_value21 = agg_value29;
/* 568 */             }
/* 569 */           }
/* 570 */           // update unsafe row buffer
/* 571 */           if (!agg_isNull20) {
/* 572 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 573 */           } else {
/* 574 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 575 */           }
/* 576 */
/* 577 */         }
/* 578 */         if (shouldStop()) return;
/* 579 */       }
/* 580 */       scan_batch = null;
/* 581 */       scan_nextBatch();
/* 582 */     }
/* 583 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 584 */     scan_scanTime1 = 0;
/* 585 */
/* 586 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 587 */
/* 588 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 589 */   }
/* 590 */
/* 591 */   private void wholestagecodegen_init_2() {
/* 592 */     project_result1 = new UnsafeRow(5);
/* 593 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 594 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 595 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 596 */
/* 597 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 598 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 599 */
/* 600 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 601 */     bhj_result1 = new UnsafeRow(8);
/* 602 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 603 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 604 */     project_result2 = new UnsafeRow(6);
/* 605 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 606 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 607 */
/* 608 */   }
/* 609 */
/* 610 */   private void wholestagecodegen_init_1() {
/* 611 */     filter_result = new UnsafeRow(3);
/* 612 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 613 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 614 */     project_result = new UnsafeRow(3);
/* 615 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 616 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 617 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 618 */
/* 619 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 620 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 621 */
/* 622 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 623 */     bhj_result = new UnsafeRow(7);
/* 624 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 625 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 626 */
/* 627 */   }
/* 628 */
/* 629 */   private void wholestagecodegen_init_4() {
/* 630 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 631 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 632 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 633 */
/* 634 */   }
/* 635 */
/* 636 */   protected void processNext() throws java.io.IOException {
/* 637 */     if (!agg_initAgg) {
/* 638 */       agg_initAgg = true;
/* 639 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 640 */       agg_doAggregateWithKeys();
/* 641 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 642 */     }
/* 643 */
/* 644 */     // output the result
/* 645 */
/* 646 */     while (agg_fastHashMapIter.next()) {
/* 647 */       wholestagecodegen_numOutputRows.add(1);
/* 648 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 649 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 650 */
/* 651 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 652 */
/* 653 */       append(agg_resultRow);
/* 654 */
/* 655 */       if (shouldStop()) return;
/* 656 */     }
/* 657 */     agg_fastHashMap.close();
/* 658 */
/* 659 */     while (agg_mapIter.next()) {
/* 660 */       wholestagecodegen_numOutputRows.add(1);
/* 661 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 662 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 663 */
/* 664 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 665 */
/* 666 */       append(agg_resultRow);
/* 667 */
/* 668 */       if (shouldStop()) return;
/* 669 */     }
/* 670 */
/* 671 */     agg_mapIter.close();
/* 672 */     if (agg_sorter == null) {
/* 673 */       agg_hashMap.free();
/* 674 */     }
/* 675 */   }
/* 676 */ }
