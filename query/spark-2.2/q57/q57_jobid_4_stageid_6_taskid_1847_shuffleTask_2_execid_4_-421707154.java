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
/* 068 */   private UnsafeRow agg_result5;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 071 */   private int agg_value14;
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
/* 100 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 101 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
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
/* 112 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_3() {
/* 117 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 118 */
/* 119 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 123 */     bhj_result2 = new UnsafeRow(8);
/* 124 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 125 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 126 */     project_result3 = new UnsafeRow(6);
/* 127 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 128 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 129 */     agg_result5 = new UnsafeRow(5);
/* 130 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 96);
/* 131 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
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
/* 161 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 162 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 163 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 164 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 165 */     private Object emptyVBase;
/* 166 */     private long emptyVOff;
/* 167 */     private int emptyVLen;
/* 168 */     private boolean isBatchFull = false;
/* 169 */
/* 170 */     public agg_FastHashMap(
/* 171 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 172 */       InternalRow emptyAggregationBuffer) {
/* 173 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 174 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 175 */
/* 176 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 177 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 178 */
/* 179 */       emptyVBase = emptyBuffer;
/* 180 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 181 */       emptyVLen = emptyBuffer.length;
/* 182 */
/* 183 */       buckets = new int[numBuckets];
/* 184 */       java.util.Arrays.fill(buckets, -1);
/* 185 */     }
/* 186 */
/* 187 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 188 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 189 */       int step = 0;
/* 190 */       int idx = (int) h & (numBuckets - 1);
/* 191 */       while (step < maxSteps) {
/* 192 */         // Return bucket index if it's either an empty slot or already contains the key
/* 193 */         if (buckets[idx] == -1) {
/* 194 */           if (numRows < capacity && !isBatchFull) {
/* 195 */             // creating the unsafe for new entry
/* 196 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 197 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 198 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 199 */               96);
/* 200 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 201 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 202 */               agg_holder,
/* 203 */               5);
/* 204 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 205 */             agg_rowWriter.zeroOutNullBytes();
/* 206 */             agg_rowWriter.write(0, agg_key);
/* 207 */             agg_rowWriter.write(1, agg_key1);
/* 208 */             agg_rowWriter.write(2, agg_key2);
/* 209 */             agg_rowWriter.write(3, agg_key3);
/* 210 */             agg_rowWriter.write(4, agg_key4);
/* 211 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 212 */             Object kbase = agg_result.getBaseObject();
/* 213 */             long koff = agg_result.getBaseOffset();
/* 214 */             int klen = agg_result.getSizeInBytes();
/* 215 */
/* 216 */             UnsafeRow vRow
/* 217 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 218 */             if (vRow == null) {
/* 219 */               isBatchFull = true;
/* 220 */             } else {
/* 221 */               buckets[idx] = numRows++;
/* 222 */             }
/* 223 */             return vRow;
/* 224 */           } else {
/* 225 */             // No more space
/* 226 */             return null;
/* 227 */           }
/* 228 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 229 */           return batch.getValueRow(buckets[idx]);
/* 230 */         }
/* 231 */         idx = (idx + 1) & (numBuckets - 1);
/* 232 */         step++;
/* 233 */       }
/* 234 */       // Didn't find it
/* 235 */       return null;
/* 236 */     }
/* 237 */
/* 238 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 239 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 240 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getInt(4) == agg_key4);
/* 241 */     }
/* 242 */
/* 243 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4) {
/* 244 */       long agg_hash = 0;
/* 245 */
/* 246 */       int agg_result = 0;
/* 247 */       byte[] agg_bytes = agg_key.getBytes();
/* 248 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 249 */         int agg_hash1 = agg_bytes[i];
/* 250 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 251 */       }
/* 252 */
/* 253 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 254 */
/* 255 */       int agg_result1 = 0;
/* 256 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 257 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 258 */         int agg_hash2 = agg_bytes1[i];
/* 259 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 260 */       }
/* 261 */
/* 262 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 263 */
/* 264 */       int agg_result2 = 0;
/* 265 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 266 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 267 */         int agg_hash3 = agg_bytes2[i];
/* 268 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 269 */       }
/* 270 */
/* 271 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 272 */
/* 273 */       int agg_result3 = agg_key3;
/* 274 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 275 */
/* 276 */       int agg_result4 = agg_key4;
/* 277 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 278 */
/* 279 */       return agg_hash;
/* 280 */     }
/* 281 */
/* 282 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 283 */       return batch.rowIterator();
/* 284 */     }
/* 285 */
/* 286 */     public void close() {
/* 287 */       batch.close();
/* 288 */     }
/* 289 */
/* 290 */   }
/* 291 */
/* 292 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 293 */     agg_hashMap = agg_plan.createHashMap();
/* 294 */
/* 295 */     if (scan_batch == null) {
/* 296 */       scan_nextBatch();
/* 297 */     }
/* 298 */     while (scan_batch != null) {
/* 299 */       int scan_numRows = scan_batch.numRows();
/* 300 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 301 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 302 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 303 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 304 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 305 */
/* 306 */         if (!(!(scan_isNull1))) continue;
/* 307 */
/* 308 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 309 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 310 */
/* 311 */         if (!(!(scan_isNull))) continue;
/* 312 */
/* 313 */         filter_numOutputRows.add(1);
/* 314 */
/* 315 */         // generate join key for stream side
/* 316 */
/* 317 */         boolean bhj_isNull = false;
/* 318 */         long bhj_value = -1L;
/* 319 */         if (!false) {
/* 320 */           bhj_value = (long) scan_value1;
/* 321 */         }
/* 322 */         // find matches from HashedRelation
/* 323 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 324 */         if (bhj_matched == null) continue;
/* 325 */
/* 326 */         bhj_numOutputRows.add(1);
/* 327 */
/* 328 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 329 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 330 */
/* 331 */         // generate join key for stream side
/* 332 */
/* 333 */         boolean bhj_isNull12 = scan_isNull3;
/* 334 */         long bhj_value12 = -1L;
/* 335 */         if (!scan_isNull3) {
/* 336 */           bhj_value12 = (long) scan_value3;
/* 337 */         }
/* 338 */         // find matches from HashedRelation
/* 339 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 340 */         if (bhj_matched1 == null) continue;
/* 341 */
/* 342 */         bhj_numOutputRows1.add(1);
/* 343 */
/* 344 */         // generate join key for stream side
/* 345 */
/* 346 */         boolean bhj_isNull25 = false;
/* 347 */         long bhj_value25 = -1L;
/* 348 */         if (!false) {
/* 349 */           bhj_value25 = (long) scan_value;
/* 350 */         }
/* 351 */         // find matches from HashedRelation
/* 352 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 353 */         if (bhj_matched2 == null) continue;
/* 354 */
/* 355 */         bhj_numOutputRows2.add(1);
/* 356 */
/* 357 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 358 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 359 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 360 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 361 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 362 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 363 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(1);
/* 364 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(1));
/* 365 */         boolean bhj_isNull16 = bhj_matched1.isNullAt(2);
/* 366 */         int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(2));
/* 367 */         boolean bhj_isNull28 = bhj_matched2.isNullAt(1);
/* 368 */         UTF8String bhj_value28 = bhj_isNull28 ? null : (bhj_matched2.getUTF8String(1));
/* 369 */
/* 370 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 371 */
/* 372 */         UnsafeRow agg_fastAggBuffer = null;
/* 373 */
/* 374 */         if (true) {
/* 375 */           if (!bhj_isNull4 && !bhj_isNull3 && !bhj_isNull28 && !bhj_isNull15 && !bhj_isNull16) {
/* 376 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 377 */               bhj_value4, bhj_value3, bhj_value28, bhj_value15, bhj_value16);
/* 378 */           }
/* 379 */         }
/* 380 */
/* 381 */         if (agg_fastAggBuffer == null) {
/* 382 */           // generate grouping key
/* 383 */           agg_holder.reset();
/* 384 */
/* 385 */           agg_rowWriter.zeroOutNullBytes();
/* 386 */
/* 387 */           if (bhj_isNull4) {
/* 388 */             agg_rowWriter.setNullAt(0);
/* 389 */           } else {
/* 390 */             agg_rowWriter.write(0, bhj_value4);
/* 391 */           }
/* 392 */
/* 393 */           if (bhj_isNull3) {
/* 394 */             agg_rowWriter.setNullAt(1);
/* 395 */           } else {
/* 396 */             agg_rowWriter.write(1, bhj_value3);
/* 397 */           }
/* 398 */
/* 399 */           if (bhj_isNull28) {
/* 400 */             agg_rowWriter.setNullAt(2);
/* 401 */           } else {
/* 402 */             agg_rowWriter.write(2, bhj_value28);
/* 403 */           }
/* 404 */
/* 405 */           if (bhj_isNull15) {
/* 406 */             agg_rowWriter.setNullAt(3);
/* 407 */           } else {
/* 408 */             agg_rowWriter.write(3, bhj_value15);
/* 409 */           }
/* 410 */
/* 411 */           if (bhj_isNull16) {
/* 412 */             agg_rowWriter.setNullAt(4);
/* 413 */           } else {
/* 414 */             agg_rowWriter.write(4, bhj_value16);
/* 415 */           }
/* 416 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 417 */           agg_value14 = 42;
/* 418 */
/* 419 */           if (!bhj_isNull4) {
/* 420 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value14);
/* 421 */           }
/* 422 */
/* 423 */           if (!bhj_isNull3) {
/* 424 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value14);
/* 425 */           }
/* 426 */
/* 427 */           if (!bhj_isNull28) {
/* 428 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value28.getBaseObject(), bhj_value28.getBaseOffset(), bhj_value28.numBytes(), agg_value14);
/* 429 */           }
/* 430 */
/* 431 */           if (!bhj_isNull15) {
/* 432 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value14);
/* 433 */           }
/* 434 */
/* 435 */           if (!bhj_isNull16) {
/* 436 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value14);
/* 437 */           }
/* 438 */           if (true) {
/* 439 */             // try to get the buffer from hash map
/* 440 */             agg_unsafeRowAggBuffer =
/* 441 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 442 */           }
/* 443 */           if (agg_unsafeRowAggBuffer == null) {
/* 444 */             if (agg_sorter == null) {
/* 445 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 446 */             } else {
/* 447 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 448 */             }
/* 449 */
/* 450 */             // the hash map had be spilled, it should have enough memory now,
/* 451 */             // try  to allocate buffer again.
/* 452 */             agg_unsafeRowAggBuffer =
/* 453 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value14);
/* 454 */             if (agg_unsafeRowAggBuffer == null) {
/* 455 */               // failed to allocate the first page
/* 456 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 457 */             }
/* 458 */           }
/* 459 */         }
/* 460 */
/* 461 */         if (agg_fastAggBuffer != null) {
/* 462 */           // update fast row
/* 463 */
/* 464 */           // common sub-expressions
/* 465 */
/* 466 */           // evaluate aggregate function
/* 467 */           boolean agg_isNull37 = true;
/* 468 */           double agg_value39 = -1.0;
/* 469 */
/* 470 */           boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(0);
/* 471 */           double agg_value41 = agg_isNull39 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 472 */           boolean agg_isNull38 = agg_isNull39;
/* 473 */           double agg_value40 = agg_value41;
/* 474 */           if (agg_isNull38) {
/* 475 */             boolean agg_isNull40 = false;
/* 476 */             double agg_value42 = -1.0;
/* 477 */             if (!false) {
/* 478 */               agg_value42 = (double) 0;
/* 479 */             }
/* 480 */             if (!agg_isNull40) {
/* 481 */               agg_isNull38 = false;
/* 482 */               agg_value40 = agg_value42;
/* 483 */             }
/* 484 */           }
/* 485 */
/* 486 */           if (!scan_isNull2) {
/* 487 */             agg_isNull37 = false; // resultCode could change nullability.
/* 488 */             agg_value39 = agg_value40 + scan_value2;
/* 489 */
/* 490 */           }
/* 491 */           boolean agg_isNull36 = agg_isNull37;
/* 492 */           double agg_value38 = agg_value39;
/* 493 */           if (agg_isNull36) {
/* 494 */             boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 495 */             double agg_value45 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 496 */             if (!agg_isNull43) {
/* 497 */               agg_isNull36 = false;
/* 498 */               agg_value38 = agg_value45;
/* 499 */             }
/* 500 */           }
/* 501 */           boolean agg_isNull45 = true;
/* 502 */           double agg_value47 = -1.0;
/* 503 */
/* 504 */           boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(1);
/* 505 */           double agg_value49 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 506 */           boolean agg_isNull46 = agg_isNull47;
/* 507 */           double agg_value48 = agg_value49;
/* 508 */           if (agg_isNull46) {
/* 509 */             boolean agg_isNull48 = false;
/* 510 */             double agg_value50 = -1.0;
/* 511 */             if (!false) {
/* 512 */               agg_value50 = (double) 0;
/* 513 */             }
/* 514 */             if (!agg_isNull48) {
/* 515 */               agg_isNull46 = false;
/* 516 */               agg_value48 = agg_value50;
/* 517 */             }
/* 518 */           }
/* 519 */
/* 520 */           if (!scan_isNull2) {
/* 521 */             agg_isNull45 = false; // resultCode could change nullability.
/* 522 */             agg_value47 = agg_value48 + scan_value2;
/* 523 */
/* 524 */           }
/* 525 */           boolean agg_isNull44 = agg_isNull45;
/* 526 */           double agg_value46 = agg_value47;
/* 527 */           if (agg_isNull44) {
/* 528 */             boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(1);
/* 529 */             double agg_value53 = agg_isNull51 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 530 */             if (!agg_isNull51) {
/* 531 */               agg_isNull44 = false;
/* 532 */               agg_value46 = agg_value53;
/* 533 */             }
/* 534 */           }
/* 535 */           // update fast row
/* 536 */           if (!agg_isNull36) {
/* 537 */             agg_fastAggBuffer.setDouble(0, agg_value38);
/* 538 */           } else {
/* 539 */             agg_fastAggBuffer.setNullAt(0);
/* 540 */           }
/* 541 */
/* 542 */           if (!agg_isNull44) {
/* 543 */             agg_fastAggBuffer.setDouble(1, agg_value46);
/* 544 */           } else {
/* 545 */             agg_fastAggBuffer.setNullAt(1);
/* 546 */           }
/* 547 */
/* 548 */         } else {
/* 549 */           // update unsafe row
/* 550 */
/* 551 */           // common sub-expressions
/* 552 */
/* 553 */           // evaluate aggregate function
/* 554 */           boolean agg_isNull20 = true;
/* 555 */           double agg_value22 = -1.0;
/* 556 */
/* 557 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 558 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 559 */           boolean agg_isNull21 = agg_isNull22;
/* 560 */           double agg_value23 = agg_value24;
/* 561 */           if (agg_isNull21) {
/* 562 */             boolean agg_isNull23 = false;
/* 563 */             double agg_value25 = -1.0;
/* 564 */             if (!false) {
/* 565 */               agg_value25 = (double) 0;
/* 566 */             }
/* 567 */             if (!agg_isNull23) {
/* 568 */               agg_isNull21 = false;
/* 569 */               agg_value23 = agg_value25;
/* 570 */             }
/* 571 */           }
/* 572 */
/* 573 */           if (!scan_isNull2) {
/* 574 */             agg_isNull20 = false; // resultCode could change nullability.
/* 575 */             agg_value22 = agg_value23 + scan_value2;
/* 576 */
/* 577 */           }
/* 578 */           boolean agg_isNull19 = agg_isNull20;
/* 579 */           double agg_value21 = agg_value22;
/* 580 */           if (agg_isNull19) {
/* 581 */             boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 582 */             double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 583 */             if (!agg_isNull26) {
/* 584 */               agg_isNull19 = false;
/* 585 */               agg_value21 = agg_value28;
/* 586 */             }
/* 587 */           }
/* 588 */           boolean agg_isNull28 = true;
/* 589 */           double agg_value30 = -1.0;
/* 590 */
/* 591 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 592 */           double agg_value32 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 593 */           boolean agg_isNull29 = agg_isNull30;
/* 594 */           double agg_value31 = agg_value32;
/* 595 */           if (agg_isNull29) {
/* 596 */             boolean agg_isNull31 = false;
/* 597 */             double agg_value33 = -1.0;
/* 598 */             if (!false) {
/* 599 */               agg_value33 = (double) 0;
/* 600 */             }
/* 601 */             if (!agg_isNull31) {
/* 602 */               agg_isNull29 = false;
/* 603 */               agg_value31 = agg_value33;
/* 604 */             }
/* 605 */           }
/* 606 */
/* 607 */           if (!scan_isNull2) {
/* 608 */             agg_isNull28 = false; // resultCode could change nullability.
/* 609 */             agg_value30 = agg_value31 + scan_value2;
/* 610 */
/* 611 */           }
/* 612 */           boolean agg_isNull27 = agg_isNull28;
/* 613 */           double agg_value29 = agg_value30;
/* 614 */           if (agg_isNull27) {
/* 615 */             boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 616 */             double agg_value36 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 617 */             if (!agg_isNull34) {
/* 618 */               agg_isNull27 = false;
/* 619 */               agg_value29 = agg_value36;
/* 620 */             }
/* 621 */           }
/* 622 */           // update unsafe row buffer
/* 623 */           if (!agg_isNull19) {
/* 624 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 625 */           } else {
/* 626 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 627 */           }
/* 628 */
/* 629 */           if (!agg_isNull27) {
/* 630 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value29);
/* 631 */           } else {
/* 632 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 633 */           }
/* 634 */
/* 635 */         }
/* 636 */         // shouldStop check is eliminated
/* 637 */       }
/* 638 */       scan_batchIdx = scan_numRows;
/* 639 */       scan_batch = null;
/* 640 */       scan_nextBatch();
/* 641 */     }
/* 642 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 643 */     scan_scanTime1 = 0;
/* 644 */
/* 645 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 646 */
/* 647 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 648 */   }
/* 649 */
/* 650 */   private void wholestagecodegen_init_2() {
/* 651 */     project_result1 = new UnsafeRow(5);
/* 652 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 64);
/* 653 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 654 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 655 */
/* 656 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 657 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 658 */
/* 659 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 660 */     bhj_result1 = new UnsafeRow(8);
/* 661 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 662 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 663 */     project_result2 = new UnsafeRow(6);
/* 664 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 665 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 666 */
/* 667 */   }
/* 668 */
/* 669 */   private void wholestagecodegen_init_1() {
/* 670 */     filter_result = new UnsafeRow(4);
/* 671 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 672 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 673 */     project_result = new UnsafeRow(4);
/* 674 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 675 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 676 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 677 */
/* 678 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 679 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 680 */
/* 681 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 682 */     bhj_result = new UnsafeRow(7);
/* 683 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 64);
/* 684 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 685 */
/* 686 */   }
/* 687 */
/* 688 */   private void wholestagecodegen_init_4() {
/* 689 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 690 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 691 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 692 */
/* 693 */   }
/* 694 */
/* 695 */   protected void processNext() throws java.io.IOException {
/* 696 */     if (!agg_initAgg) {
/* 697 */       agg_initAgg = true;
/* 698 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 699 */       agg_doAggregateWithKeys();
/* 700 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 701 */     }
/* 702 */
/* 703 */     // output the result
/* 704 */
/* 705 */     while (agg_fastHashMapIter.next()) {
/* 706 */       wholestagecodegen_numOutputRows.add(1);
/* 707 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 708 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 709 */
/* 710 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 711 */
/* 712 */       append(agg_resultRow);
/* 713 */
/* 714 */       if (shouldStop()) return;
/* 715 */     }
/* 716 */     agg_fastHashMap.close();
/* 717 */
/* 718 */     while (agg_mapIter.next()) {
/* 719 */       wholestagecodegen_numOutputRows.add(1);
/* 720 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 721 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 722 */
/* 723 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 724 */
/* 725 */       append(agg_resultRow);
/* 726 */
/* 727 */       if (shouldStop()) return;
/* 728 */     }
/* 729 */
/* 730 */     agg_mapIter.close();
/* 731 */     if (agg_sorter == null) {
/* 732 */       agg_hashMap.free();
/* 733 */     }
/* 734 */   }
/* 735 */ }
