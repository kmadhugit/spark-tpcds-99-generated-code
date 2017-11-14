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
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 031 */   private UnsafeRow scan_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 035 */   private UnsafeRow filter_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 042 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 044 */   private UnsafeRow bhj_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 047 */   private UnsafeRow project_result1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 050 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 051 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 053 */   private UnsafeRow bhj_result1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 056 */   private UnsafeRow project_result2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 059 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 060 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 062 */   private UnsafeRow bhj_result2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 065 */   private UnsafeRow project_result3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 068 */   private UnsafeRow agg_result6;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 071 */   private int agg_value16;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 075 */
/* 076 */   public GeneratedIterator(Object[] references) {
/* 077 */     this.references = references;
/* 078 */   }
/* 079 */
/* 080 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 081 */     partitionIndex = index;
/* 082 */     this.inputs = inputs;
/* 083 */     wholestagecodegen_init_0();
/* 084 */     wholestagecodegen_init_1();
/* 085 */     wholestagecodegen_init_2();
/* 086 */     wholestagecodegen_init_3();
/* 087 */     wholestagecodegen_init_4();
/* 088 */
/* 089 */   }
/* 090 */
/* 091 */   private void wholestagecodegen_init_0() {
/* 092 */     agg_initAgg = false;
/* 093 */
/* 094 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 095 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 096 */
/* 097 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 098 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 099 */     scan_input = inputs[0];
/* 100 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 101 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 102 */     scan_scanTime1 = 0;
/* 103 */     scan_batch = null;
/* 104 */     scan_batchIdx = 0;
/* 105 */     scan_colInstance0 = null;
/* 106 */     scan_colInstance1 = null;
/* 107 */     scan_colInstance2 = null;
/* 108 */     scan_colInstance3 = null;
/* 109 */     scan_result = new UnsafeRow(4);
/* 110 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 111 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 112 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_3() {
/* 117 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 118 */
/* 119 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 123 */     bhj_result2 = new UnsafeRow(9);
/* 124 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 128);
/* 125 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 9);
/* 126 */     project_result3 = new UnsafeRow(7);
/* 127 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 128);
/* 128 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 7);
/* 129 */     agg_result6 = new UnsafeRow(6);
/* 130 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 128);
/* 131 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 132 */
/* 133 */   }
/* 134 */
/* 135 */   private void scan_nextBatch() throws java.io.IOException {
/* 136 */     long getBatchStart = System.nanoTime();
/* 137 */     if (scan_input.hasNext()) {
/* 138 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 139 */       scan_numOutputRows.add(scan_batch.numRows());
/* 140 */       scan_batchIdx = 0;
/* 141 */       scan_colInstance0 = scan_batch.column(0);
/* 142 */       scan_colInstance1 = scan_batch.column(1);
/* 143 */       scan_colInstance2 = scan_batch.column(2);
/* 144 */       scan_colInstance3 = scan_batch.column(3);
/* 145 */
/* 146 */     }
/* 147 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 148 */   }
/* 149 */
/* 150 */   public class agg_FastHashMap {
/* 151 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 152 */     private int[] buckets;
/* 153 */     private int capacity = 1 << 16;
/* 154 */     private double loadFactor = 0.5;
/* 155 */     private int numBuckets = (int) (capacity / loadFactor);
/* 156 */     private int maxSteps = 2;
/* 157 */     private int numRows = 0;
/* 158 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 159 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 160 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 161 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 162 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 163 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 164 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 165 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 166 */     private Object emptyVBase;
/* 167 */     private long emptyVOff;
/* 168 */     private int emptyVLen;
/* 169 */     private boolean isBatchFull = false;
/* 170 */
/* 171 */     public agg_FastHashMap(
/* 172 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 173 */       InternalRow emptyAggregationBuffer) {
/* 174 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 175 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 176 */
/* 177 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 178 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 179 */
/* 180 */       emptyVBase = emptyBuffer;
/* 181 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 182 */       emptyVLen = emptyBuffer.length;
/* 183 */
/* 184 */       buckets = new int[numBuckets];
/* 185 */       java.util.Arrays.fill(buckets, -1);
/* 186 */     }
/* 187 */
/* 188 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 189 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5);
/* 190 */       int step = 0;
/* 191 */       int idx = (int) h & (numBuckets - 1);
/* 192 */       while (step < maxSteps) {
/* 193 */         // Return bucket index if it's either an empty slot or already contains the key
/* 194 */         if (buckets[idx] == -1) {
/* 195 */           if (numRows < capacity && !isBatchFull) {
/* 196 */             // creating the unsafe for new entry
/* 197 */             UnsafeRow agg_result = new UnsafeRow(6);
/* 198 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 199 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 200 */               128);
/* 201 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 202 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 203 */               agg_holder,
/* 204 */               6);
/* 205 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 206 */             agg_rowWriter.zeroOutNullBytes();
/* 207 */             agg_rowWriter.write(0, agg_key);
/* 208 */             agg_rowWriter.write(1, agg_key1);
/* 209 */             agg_rowWriter.write(2, agg_key2);
/* 210 */             agg_rowWriter.write(3, agg_key3);
/* 211 */             agg_rowWriter.write(4, agg_key4);
/* 212 */             agg_rowWriter.write(5, agg_key5);
/* 213 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 214 */             Object kbase = agg_result.getBaseObject();
/* 215 */             long koff = agg_result.getBaseOffset();
/* 216 */             int klen = agg_result.getSizeInBytes();
/* 217 */
/* 218 */             UnsafeRow vRow
/* 219 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 220 */             if (vRow == null) {
/* 221 */               isBatchFull = true;
/* 222 */             } else {
/* 223 */               buckets[idx] = numRows++;
/* 224 */             }
/* 225 */             return vRow;
/* 226 */           } else {
/* 227 */             // No more space
/* 228 */             return null;
/* 229 */           }
/* 230 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5)) {
/* 231 */           return batch.getValueRow(buckets[idx]);
/* 232 */         }
/* 233 */         idx = (idx + 1) & (numBuckets - 1);
/* 234 */         step++;
/* 235 */       }
/* 236 */       // Didn't find it
/* 237 */       return null;
/* 238 */     }
/* 239 */
/* 240 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 241 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 242 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getInt(4) == agg_key4) && (row.getInt(5) == agg_key5);
/* 243 */     }
/* 244 */
/* 245 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5) {
/* 246 */       long agg_hash = 0;
/* 247 */
/* 248 */       int agg_result = 0;
/* 249 */       byte[] agg_bytes = agg_key.getBytes();
/* 250 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 251 */         int agg_hash1 = agg_bytes[i];
/* 252 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 253 */       }
/* 254 */
/* 255 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 256 */
/* 257 */       int agg_result1 = 0;
/* 258 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 259 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 260 */         int agg_hash2 = agg_bytes1[i];
/* 261 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 262 */       }
/* 263 */
/* 264 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 265 */
/* 266 */       int agg_result2 = 0;
/* 267 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 268 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 269 */         int agg_hash3 = agg_bytes2[i];
/* 270 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 271 */       }
/* 272 */
/* 273 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 274 */
/* 275 */       int agg_result3 = 0;
/* 276 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 277 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 278 */         int agg_hash4 = agg_bytes3[i];
/* 279 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 280 */       }
/* 281 */
/* 282 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 283 */
/* 284 */       int agg_result4 = agg_key4;
/* 285 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 286 */
/* 287 */       int agg_result5 = agg_key5;
/* 288 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 289 */
/* 290 */       return agg_hash;
/* 291 */     }
/* 292 */
/* 293 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 294 */       return batch.rowIterator();
/* 295 */     }
/* 296 */
/* 297 */     public void close() {
/* 298 */       batch.close();
/* 299 */     }
/* 300 */
/* 301 */   }
/* 302 */
/* 303 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 304 */     agg_hashMap = agg_plan.createHashMap();
/* 305 */
/* 306 */     if (scan_batch == null) {
/* 307 */       scan_nextBatch();
/* 308 */     }
/* 309 */     while (scan_batch != null) {
/* 310 */       int scan_numRows = scan_batch.numRows();
/* 311 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 312 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 313 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 314 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 315 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 316 */
/* 317 */         if (!(!(scan_isNull))) continue;
/* 318 */
/* 319 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 320 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 321 */
/* 322 */         if (!(!(scan_isNull1))) continue;
/* 323 */
/* 324 */         filter_numOutputRows.add(1);
/* 325 */
/* 326 */         // generate join key for stream side
/* 327 */
/* 328 */         boolean bhj_isNull = false;
/* 329 */         long bhj_value = -1L;
/* 330 */         if (!false) {
/* 331 */           bhj_value = (long) scan_value;
/* 332 */         }
/* 333 */         // find matches from HashedRelation
/* 334 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 335 */         if (bhj_matched == null) continue;
/* 336 */
/* 337 */         bhj_numOutputRows.add(1);
/* 338 */
/* 339 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 340 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 341 */
/* 342 */         // generate join key for stream side
/* 343 */
/* 344 */         boolean bhj_isNull12 = scan_isNull3;
/* 345 */         long bhj_value12 = -1L;
/* 346 */         if (!scan_isNull3) {
/* 347 */           bhj_value12 = (long) scan_value3;
/* 348 */         }
/* 349 */         // find matches from HashedRelation
/* 350 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 351 */         if (bhj_matched1 == null) continue;
/* 352 */
/* 353 */         bhj_numOutputRows1.add(1);
/* 354 */
/* 355 */         // generate join key for stream side
/* 356 */
/* 357 */         boolean bhj_isNull25 = false;
/* 358 */         long bhj_value25 = -1L;
/* 359 */         if (!false) {
/* 360 */           bhj_value25 = (long) scan_value1;
/* 361 */         }
/* 362 */         // find matches from HashedRelation
/* 363 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 364 */         if (bhj_matched2 == null) continue;
/* 365 */
/* 366 */         bhj_numOutputRows2.add(1);
/* 367 */
/* 368 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 369 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 370 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 371 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 372 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 373 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 374 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(1);
/* 375 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(1));
/* 376 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(2);
/* 377 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(2));
/* 378 */         boolean bhj_isNull28 = bhj_matched2.isNullAt(1);
/* 379 */         UTF8String bhj_value28 = bhj_isNull28 ? null : (bhj_matched2.getUTF8String(1));
/* 380 */         boolean bhj_isNull29 = bhj_matched2.isNullAt(2);
/* 381 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched2.getUTF8String(2));
/* 382 */
/* 383 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 384 */
/* 385 */         UnsafeRow agg_fastAggBuffer = null;
/* 386 */
/* 387 */         if (true) {
/* 388 */           if (!bhj_isNull4 && !bhj_isNull3 && !bhj_isNull28 && !bhj_isNull29 && !bhj_isNull15 && !bhj_isNull16) {
/* 389 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 390 */               bhj_value4, bhj_value3, bhj_value28, bhj_value29, bhj_value15, bhj_value16);
/* 391 */           }
/* 392 */         }
/* 393 */
/* 394 */         if (agg_fastAggBuffer == null) {
/* 395 */           // generate grouping key
/* 396 */           agg_holder.reset();
/* 397 */
/* 398 */           agg_rowWriter.zeroOutNullBytes();
/* 399 */
/* 400 */           if (bhj_isNull4) {
/* 401 */             agg_rowWriter.setNullAt(0);
/* 402 */           } else {
/* 403 */             agg_rowWriter.write(0, bhj_value4);
/* 404 */           }
/* 405 */
/* 406 */           if (bhj_isNull3) {
/* 407 */             agg_rowWriter.setNullAt(1);
/* 408 */           } else {
/* 409 */             agg_rowWriter.write(1, bhj_value3);
/* 410 */           }
/* 411 */
/* 412 */           if (bhj_isNull28) {
/* 413 */             agg_rowWriter.setNullAt(2);
/* 414 */           } else {
/* 415 */             agg_rowWriter.write(2, bhj_value28);
/* 416 */           }
/* 417 */
/* 418 */           if (bhj_isNull29) {
/* 419 */             agg_rowWriter.setNullAt(3);
/* 420 */           } else {
/* 421 */             agg_rowWriter.write(3, bhj_value29);
/* 422 */           }
/* 423 */
/* 424 */           if (bhj_isNull15) {
/* 425 */             agg_rowWriter.setNullAt(4);
/* 426 */           } else {
/* 427 */             agg_rowWriter.write(4, bhj_value15);
/* 428 */           }
/* 429 */
/* 430 */           if (bhj_isNull16) {
/* 431 */             agg_rowWriter.setNullAt(5);
/* 432 */           } else {
/* 433 */             agg_rowWriter.write(5, bhj_value16);
/* 434 */           }
/* 435 */           agg_result6.setTotalSize(agg_holder.totalSize());
/* 436 */           agg_value16 = 42;
/* 437 */
/* 438 */           if (!bhj_isNull4) {
/* 439 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value16);
/* 440 */           }
/* 441 */
/* 442 */           if (!bhj_isNull3) {
/* 443 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value16);
/* 444 */           }
/* 445 */
/* 446 */           if (!bhj_isNull28) {
/* 447 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value28.getBaseObject(), bhj_value28.getBaseOffset(), bhj_value28.numBytes(), agg_value16);
/* 448 */           }
/* 449 */
/* 450 */           if (!bhj_isNull29) {
/* 451 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value29.getBaseObject(), bhj_value29.getBaseOffset(), bhj_value29.numBytes(), agg_value16);
/* 452 */           }
/* 453 */
/* 454 */           if (!bhj_isNull15) {
/* 455 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value16);
/* 456 */           }
/* 457 */
/* 458 */           if (!bhj_isNull16) {
/* 459 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value16);
/* 460 */           }
/* 461 */           if (true) {
/* 462 */             // try to get the buffer from hash map
/* 463 */             agg_unsafeRowAggBuffer =
/* 464 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 465 */           }
/* 466 */           if (agg_unsafeRowAggBuffer == null) {
/* 467 */             if (agg_sorter == null) {
/* 468 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 469 */             } else {
/* 470 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 471 */             }
/* 472 */
/* 473 */             // the hash map had be spilled, it should have enough memory now,
/* 474 */             // try  to allocate buffer again.
/* 475 */             agg_unsafeRowAggBuffer =
/* 476 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value16);
/* 477 */             if (agg_unsafeRowAggBuffer == null) {
/* 478 */               // failed to allocate the first page
/* 479 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 480 */             }
/* 481 */           }
/* 482 */         }
/* 483 */
/* 484 */         if (agg_fastAggBuffer != null) {
/* 485 */           // update fast row
/* 486 */
/* 487 */           // common sub-expressions
/* 488 */
/* 489 */           // evaluate aggregate function
/* 490 */           boolean agg_isNull40 = true;
/* 491 */           double agg_value42 = -1.0;
/* 492 */
/* 493 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 494 */           double agg_value44 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 495 */           boolean agg_isNull41 = agg_isNull42;
/* 496 */           double agg_value43 = agg_value44;
/* 497 */           if (agg_isNull41) {
/* 498 */             boolean agg_isNull43 = false;
/* 499 */             double agg_value45 = -1.0;
/* 500 */             if (!false) {
/* 501 */               agg_value45 = (double) 0;
/* 502 */             }
/* 503 */             if (!agg_isNull43) {
/* 504 */               agg_isNull41 = false;
/* 505 */               agg_value43 = agg_value45;
/* 506 */             }
/* 507 */           }
/* 508 */
/* 509 */           if (!scan_isNull2) {
/* 510 */             agg_isNull40 = false; // resultCode could change nullability.
/* 511 */             agg_value42 = agg_value43 + scan_value2;
/* 512 */
/* 513 */           }
/* 514 */           boolean agg_isNull39 = agg_isNull40;
/* 515 */           double agg_value41 = agg_value42;
/* 516 */           if (agg_isNull39) {
/* 517 */             boolean agg_isNull46 = agg_fastAggBuffer.isNullAt(0);
/* 518 */             double agg_value48 = agg_isNull46 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 519 */             if (!agg_isNull46) {
/* 520 */               agg_isNull39 = false;
/* 521 */               agg_value41 = agg_value48;
/* 522 */             }
/* 523 */           }
/* 524 */           boolean agg_isNull48 = true;
/* 525 */           double agg_value50 = -1.0;
/* 526 */
/* 527 */           boolean agg_isNull50 = agg_fastAggBuffer.isNullAt(1);
/* 528 */           double agg_value52 = agg_isNull50 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 529 */           boolean agg_isNull49 = agg_isNull50;
/* 530 */           double agg_value51 = agg_value52;
/* 531 */           if (agg_isNull49) {
/* 532 */             boolean agg_isNull51 = false;
/* 533 */             double agg_value53 = -1.0;
/* 534 */             if (!false) {
/* 535 */               agg_value53 = (double) 0;
/* 536 */             }
/* 537 */             if (!agg_isNull51) {
/* 538 */               agg_isNull49 = false;
/* 539 */               agg_value51 = agg_value53;
/* 540 */             }
/* 541 */           }
/* 542 */
/* 543 */           if (!scan_isNull2) {
/* 544 */             agg_isNull48 = false; // resultCode could change nullability.
/* 545 */             agg_value50 = agg_value51 + scan_value2;
/* 546 */
/* 547 */           }
/* 548 */           boolean agg_isNull47 = agg_isNull48;
/* 549 */           double agg_value49 = agg_value50;
/* 550 */           if (agg_isNull47) {
/* 551 */             boolean agg_isNull54 = agg_fastAggBuffer.isNullAt(1);
/* 552 */             double agg_value56 = agg_isNull54 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 553 */             if (!agg_isNull54) {
/* 554 */               agg_isNull47 = false;
/* 555 */               agg_value49 = agg_value56;
/* 556 */             }
/* 557 */           }
/* 558 */           // update fast row
/* 559 */           if (!agg_isNull39) {
/* 560 */             agg_fastAggBuffer.setDouble(0, agg_value41);
/* 561 */           } else {
/* 562 */             agg_fastAggBuffer.setNullAt(0);
/* 563 */           }
/* 564 */
/* 565 */           if (!agg_isNull47) {
/* 566 */             agg_fastAggBuffer.setDouble(1, agg_value49);
/* 567 */           } else {
/* 568 */             agg_fastAggBuffer.setNullAt(1);
/* 569 */           }
/* 570 */
/* 571 */         } else {
/* 572 */           // update unsafe row
/* 573 */
/* 574 */           // common sub-expressions
/* 575 */
/* 576 */           // evaluate aggregate function
/* 577 */           boolean agg_isNull23 = true;
/* 578 */           double agg_value25 = -1.0;
/* 579 */
/* 580 */           boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 581 */           double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 582 */           boolean agg_isNull24 = agg_isNull25;
/* 583 */           double agg_value26 = agg_value27;
/* 584 */           if (agg_isNull24) {
/* 585 */             boolean agg_isNull26 = false;
/* 586 */             double agg_value28 = -1.0;
/* 587 */             if (!false) {
/* 588 */               agg_value28 = (double) 0;
/* 589 */             }
/* 590 */             if (!agg_isNull26) {
/* 591 */               agg_isNull24 = false;
/* 592 */               agg_value26 = agg_value28;
/* 593 */             }
/* 594 */           }
/* 595 */
/* 596 */           if (!scan_isNull2) {
/* 597 */             agg_isNull23 = false; // resultCode could change nullability.
/* 598 */             agg_value25 = agg_value26 + scan_value2;
/* 599 */
/* 600 */           }
/* 601 */           boolean agg_isNull22 = agg_isNull23;
/* 602 */           double agg_value24 = agg_value25;
/* 603 */           if (agg_isNull22) {
/* 604 */             boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 605 */             double agg_value31 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 606 */             if (!agg_isNull29) {
/* 607 */               agg_isNull22 = false;
/* 608 */               agg_value24 = agg_value31;
/* 609 */             }
/* 610 */           }
/* 611 */           boolean agg_isNull31 = true;
/* 612 */           double agg_value33 = -1.0;
/* 613 */
/* 614 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 615 */           double agg_value35 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 616 */           boolean agg_isNull32 = agg_isNull33;
/* 617 */           double agg_value34 = agg_value35;
/* 618 */           if (agg_isNull32) {
/* 619 */             boolean agg_isNull34 = false;
/* 620 */             double agg_value36 = -1.0;
/* 621 */             if (!false) {
/* 622 */               agg_value36 = (double) 0;
/* 623 */             }
/* 624 */             if (!agg_isNull34) {
/* 625 */               agg_isNull32 = false;
/* 626 */               agg_value34 = agg_value36;
/* 627 */             }
/* 628 */           }
/* 629 */
/* 630 */           if (!scan_isNull2) {
/* 631 */             agg_isNull31 = false; // resultCode could change nullability.
/* 632 */             agg_value33 = agg_value34 + scan_value2;
/* 633 */
/* 634 */           }
/* 635 */           boolean agg_isNull30 = agg_isNull31;
/* 636 */           double agg_value32 = agg_value33;
/* 637 */           if (agg_isNull30) {
/* 638 */             boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 639 */             double agg_value39 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 640 */             if (!agg_isNull37) {
/* 641 */               agg_isNull30 = false;
/* 642 */               agg_value32 = agg_value39;
/* 643 */             }
/* 644 */           }
/* 645 */           // update unsafe row buffer
/* 646 */           if (!agg_isNull22) {
/* 647 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value24);
/* 648 */           } else {
/* 649 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 650 */           }
/* 651 */
/* 652 */           if (!agg_isNull30) {
/* 653 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value32);
/* 654 */           } else {
/* 655 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 656 */           }
/* 657 */
/* 658 */         }
/* 659 */         // shouldStop check is eliminated
/* 660 */       }
/* 661 */       scan_batchIdx = scan_numRows;
/* 662 */       scan_batch = null;
/* 663 */       scan_nextBatch();
/* 664 */     }
/* 665 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 666 */     scan_scanTime1 = 0;
/* 667 */
/* 668 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 669 */
/* 670 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 671 */   }
/* 672 */
/* 673 */   private void wholestagecodegen_init_2() {
/* 674 */     project_result1 = new UnsafeRow(5);
/* 675 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 676 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 677 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 678 */
/* 679 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 680 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 681 */
/* 682 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 683 */     bhj_result1 = new UnsafeRow(8);
/* 684 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 685 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 686 */     project_result2 = new UnsafeRow(6);
/* 687 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 688 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 689 */
/* 690 */   }
/* 691 */
/* 692 */   private void wholestagecodegen_init_1() {
/* 693 */     filter_result = new UnsafeRow(4);
/* 694 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 695 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 696 */     project_result = new UnsafeRow(4);
/* 697 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 698 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 699 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 700 */
/* 701 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 702 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 703 */
/* 704 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 705 */     bhj_result = new UnsafeRow(7);
/* 706 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 707 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 708 */
/* 709 */   }
/* 710 */
/* 711 */   private void wholestagecodegen_init_4() {
/* 712 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 713 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 714 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 715 */
/* 716 */   }
/* 717 */
/* 718 */   protected void processNext() throws java.io.IOException {
/* 719 */     if (!agg_initAgg) {
/* 720 */       agg_initAgg = true;
/* 721 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 722 */       agg_doAggregateWithKeys();
/* 723 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 724 */     }
/* 725 */
/* 726 */     // output the result
/* 727 */
/* 728 */     while (agg_fastHashMapIter.next()) {
/* 729 */       wholestagecodegen_numOutputRows.add(1);
/* 730 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 731 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 732 */
/* 733 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 734 */
/* 735 */       append(agg_resultRow);
/* 736 */
/* 737 */       if (shouldStop()) return;
/* 738 */     }
/* 739 */     agg_fastHashMap.close();
/* 740 */
/* 741 */     while (agg_mapIter.next()) {
/* 742 */       wholestagecodegen_numOutputRows.add(1);
/* 743 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 744 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 745 */
/* 746 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 747 */
/* 748 */       append(agg_resultRow);
/* 749 */
/* 750 */       if (shouldStop()) return;
/* 751 */     }
/* 752 */
/* 753 */     agg_mapIter.close();
/* 754 */     if (agg_sorter == null) {
/* 755 */       agg_hashMap.free();
/* 756 */     }
/* 757 */   }
/* 758 */ }
