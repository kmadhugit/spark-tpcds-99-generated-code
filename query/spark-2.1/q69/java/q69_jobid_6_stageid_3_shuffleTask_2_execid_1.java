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
/* 023 */   private scala.collection.Iterator scan_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 026 */   private long scan_scanTime1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 028 */   private int scan_batchIdx;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 044 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 047 */   private UnsafeRow scan_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 051 */   private UnsafeRow filter_result;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 054 */   private UnsafeRow project_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 060 */   private UnsafeRow bhj_result;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 066 */   private UnsafeRow bhj_result1;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 069 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 070 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 072 */   private UnsafeRow bhj_result2;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 075 */   private UnsafeRow project_result1;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 078 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 079 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 080 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 081 */   private UnsafeRow bhj_result3;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 084 */   private UnsafeRow project_result2;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 087 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 088 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 089 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 090 */   private UnsafeRow bhj_result4;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 093 */   private UnsafeRow project_result3;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 096 */   private UnsafeRow agg_result5;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 099 */   private int agg_value16;
/* 100 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 101 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 102 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 103 */
/* 104 */   public GeneratedIterator(Object[] references) {
/* 105 */     this.references = references;
/* 106 */   }
/* 107 */
/* 108 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 109 */     partitionIndex = index;
/* 110 */     this.inputs = inputs;
/* 111 */     wholestagecodegen_init_0();
/* 112 */     wholestagecodegen_init_1();
/* 113 */     wholestagecodegen_init_2();
/* 114 */     wholestagecodegen_init_3();
/* 115 */     wholestagecodegen_init_4();
/* 116 */     wholestagecodegen_init_5();
/* 117 */
/* 118 */   }
/* 119 */
/* 120 */   private void wholestagecodegen_init_0() {
/* 121 */     agg_initAgg = false;
/* 122 */
/* 123 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 124 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 125 */
/* 126 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 127 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 128 */     scan_input = inputs[0];
/* 129 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 130 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 131 */     scan_scanTime1 = 0;
/* 132 */     scan_batch = null;
/* 133 */     scan_batchIdx = 0;
/* 134 */     scan_colInstance0 = null;
/* 135 */     scan_colInstance1 = null;
/* 136 */     scan_colInstance2 = null;
/* 137 */     scan_colInstance3 = null;
/* 138 */     scan_colInstance4 = null;
/* 139 */     scan_colInstance5 = null;
/* 140 */     scan_colInstance6 = null;
/* 141 */     scan_colInstance7 = null;
/* 142 */     scan_colInstance8 = null;
/* 143 */     scan_colInstance9 = null;
/* 144 */     scan_colInstance10 = null;
/* 145 */     scan_colInstance11 = null;
/* 146 */     scan_colInstance12 = null;
/* 147 */     scan_colInstance13 = null;
/* 148 */
/* 149 */   }
/* 150 */
/* 151 */   private void wholestagecodegen_init_3() {
/* 152 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 153 */
/* 154 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 155 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 156 */
/* 157 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 158 */     bhj_result2 = new UnsafeRow(18);
/* 159 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 288);
/* 160 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 18);
/* 161 */     project_result1 = new UnsafeRow(2);
/* 162 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 163 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 164 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 165 */
/* 166 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 167 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 168 */
/* 169 */   }
/* 170 */
/* 171 */   private void scan_nextBatch() throws java.io.IOException {
/* 172 */     long getBatchStart = System.nanoTime();
/* 173 */     if (scan_input.hasNext()) {
/* 174 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 175 */       scan_numOutputRows.add(scan_batch.numRows());
/* 176 */       scan_batchIdx = 0;
/* 177 */       scan_colInstance0 = scan_batch.column(0);
/* 178 */       scan_colInstance1 = scan_batch.column(1);
/* 179 */       scan_colInstance2 = scan_batch.column(2);
/* 180 */       scan_colInstance3 = scan_batch.column(3);
/* 181 */       scan_colInstance4 = scan_batch.column(4);
/* 182 */       scan_colInstance5 = scan_batch.column(5);
/* 183 */       scan_colInstance6 = scan_batch.column(6);
/* 184 */       scan_colInstance7 = scan_batch.column(7);
/* 185 */       scan_colInstance8 = scan_batch.column(8);
/* 186 */       scan_colInstance9 = scan_batch.column(9);
/* 187 */       scan_colInstance10 = scan_batch.column(10);
/* 188 */       scan_colInstance11 = scan_batch.column(11);
/* 189 */       scan_colInstance12 = scan_batch.column(12);
/* 190 */       scan_colInstance13 = scan_batch.column(13);
/* 191 */       scan_colInstance14 = scan_batch.column(14);
/* 192 */       scan_colInstance15 = scan_batch.column(15);
/* 193 */       scan_colInstance16 = scan_batch.column(16);
/* 194 */       scan_colInstance17 = scan_batch.column(17);
/* 195 */
/* 196 */     }
/* 197 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 198 */   }
/* 199 */
/* 200 */   public class agg_FastHashMap {
/* 201 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 202 */     private int[] buckets;
/* 203 */     private int capacity = 1 << 16;
/* 204 */     private double loadFactor = 0.5;
/* 205 */     private int numBuckets = (int) (capacity / loadFactor);
/* 206 */     private int maxSteps = 2;
/* 207 */     private int numRows = 0;
/* 208 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("cd_gender", org.apache.spark.sql.types.DataTypes.StringType)
/* 209 */     .add("cd_marital_status", org.apache.spark.sql.types.DataTypes.StringType)
/* 210 */     .add("cd_education_status", org.apache.spark.sql.types.DataTypes.StringType)
/* 211 */     .add("cd_purchase_estimate", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 212 */     .add("cd_credit_rating", org.apache.spark.sql.types.DataTypes.StringType);
/* 213 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 214 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 215 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType);
/* 216 */     private Object emptyVBase;
/* 217 */     private long emptyVOff;
/* 218 */     private int emptyVLen;
/* 219 */     private boolean isBatchFull = false;
/* 220 */
/* 221 */     public agg_FastHashMap(
/* 222 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 223 */       InternalRow emptyAggregationBuffer) {
/* 224 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 225 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 226 */
/* 227 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 228 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 229 */
/* 230 */       emptyVBase = emptyBuffer;
/* 231 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 232 */       emptyVLen = emptyBuffer.length;
/* 233 */
/* 234 */       buckets = new int[numBuckets];
/* 235 */       java.util.Arrays.fill(buckets, -1);
/* 236 */     }
/* 237 */
/* 238 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4) {
/* 239 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 240 */       int step = 0;
/* 241 */       int idx = (int) h & (numBuckets - 1);
/* 242 */       while (step < maxSteps) {
/* 243 */         // Return bucket index if it's either an empty slot or already contains the key
/* 244 */         if (buckets[idx] == -1) {
/* 245 */           if (numRows < capacity && !isBatchFull) {
/* 246 */             // creating the unsafe for new entry
/* 247 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 248 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 249 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 250 */               128);
/* 251 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 252 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 253 */               agg_holder,
/* 254 */               5);
/* 255 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 256 */             agg_rowWriter.zeroOutNullBytes();
/* 257 */             agg_rowWriter.write(0, agg_key);
/* 258 */             agg_rowWriter.write(1, agg_key1);
/* 259 */             agg_rowWriter.write(2, agg_key2);
/* 260 */             agg_rowWriter.write(3, agg_key3);
/* 261 */             agg_rowWriter.write(4, agg_key4);
/* 262 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 263 */             Object kbase = agg_result.getBaseObject();
/* 264 */             long koff = agg_result.getBaseOffset();
/* 265 */             int klen = agg_result.getSizeInBytes();
/* 266 */
/* 267 */             UnsafeRow vRow
/* 268 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 269 */             if (vRow == null) {
/* 270 */               isBatchFull = true;
/* 271 */             } else {
/* 272 */               buckets[idx] = numRows++;
/* 273 */             }
/* 274 */             return vRow;
/* 275 */           } else {
/* 276 */             // No more space
/* 277 */             return null;
/* 278 */           }
/* 279 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 280 */           return batch.getValueRow(buckets[idx]);
/* 281 */         }
/* 282 */         idx = (idx + 1) & (numBuckets - 1);
/* 283 */         step++;
/* 284 */       }
/* 285 */       // Didn't find it
/* 286 */       return null;
/* 287 */     }
/* 288 */
/* 289 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4) {
/* 290 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 291 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getUTF8String(4).equals(agg_key4));
/* 292 */     }
/* 293 */
/* 294 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4) {
/* 295 */       long agg_hash = 0;
/* 296 */
/* 297 */       int agg_result = 0;
/* 298 */       byte[] agg_bytes = agg_key.getBytes();
/* 299 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 300 */         int agg_hash1 = agg_bytes[i];
/* 301 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 302 */       }
/* 303 */
/* 304 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 305 */
/* 306 */       int agg_result1 = 0;
/* 307 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 308 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 309 */         int agg_hash2 = agg_bytes1[i];
/* 310 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 311 */       }
/* 312 */
/* 313 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 314 */
/* 315 */       int agg_result2 = 0;
/* 316 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 317 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 318 */         int agg_hash3 = agg_bytes2[i];
/* 319 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 320 */       }
/* 321 */
/* 322 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 323 */
/* 324 */       int agg_result3 = agg_key3;
/* 325 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 326 */
/* 327 */       int agg_result4 = 0;
/* 328 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 329 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 330 */         int agg_hash4 = agg_bytes3[i];
/* 331 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 332 */       }
/* 333 */
/* 334 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 335 */
/* 336 */       return agg_hash;
/* 337 */     }
/* 338 */
/* 339 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 340 */       return batch.rowIterator();
/* 341 */     }
/* 342 */
/* 343 */     public void close() {
/* 344 */       batch.close();
/* 345 */     }
/* 346 */
/* 347 */   }
/* 348 */
/* 349 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 350 */     agg_hashMap = agg_plan.createHashMap();
/* 351 */
/* 352 */     if (scan_batch == null) {
/* 353 */       scan_nextBatch();
/* 354 */     }
/* 355 */     while (scan_batch != null) {
/* 356 */       int numRows = scan_batch.numRows();
/* 357 */       while (scan_batchIdx < numRows) {
/* 358 */         int scan_rowIdx = scan_batchIdx++;
/* 359 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 360 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 361 */
/* 362 */         if (!(!(scan_isNull4))) continue;
/* 363 */
/* 364 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 365 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 366 */
/* 367 */         if (!(!(scan_isNull2))) continue;
/* 368 */
/* 369 */         filter_numOutputRows.add(1);
/* 370 */
/* 371 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 372 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 373 */
/* 374 */         // generate join key for stream side
/* 375 */
/* 376 */         boolean bhj_isNull = scan_isNull;
/* 377 */         long bhj_value = -1L;
/* 378 */         if (!scan_isNull) {
/* 379 */           bhj_value = (long) scan_value;
/* 380 */         }
/* 381 */         // find matches from HashedRelation
/* 382 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 383 */         if (bhj_matched == null) continue;
/* 384 */
/* 385 */         bhj_numOutputRows.add(1);
/* 386 */
/* 387 */         // generate join key for stream side
/* 388 */
/* 389 */         boolean bhj_isNull122 = scan_isNull;
/* 390 */         long bhj_value122 = -1L;
/* 391 */         if (!scan_isNull) {
/* 392 */           bhj_value122 = (long) scan_value;
/* 393 */         }
/* 394 */         // Check if the key has nulls.
/* 395 */         if (!(bhj_isNull122)) {
/* 396 */           // Check if the HashedRelation exists.
/* 397 */           UnsafeRow bhj_matched1 = (UnsafeRow)bhj_relation1.getValue(bhj_value122);
/* 398 */           if (bhj_matched1 != null) {
/* 399 */             // Evaluate the condition.
/* 400 */             continue;
/* 401 */           }
/* 402 */         }
/* 403 */         bhj_numOutputRows1.add(1);
/* 404 */
/* 405 */         // generate join key for stream side
/* 406 */
/* 407 */         boolean bhj_isNull266 = scan_isNull;
/* 408 */         long bhj_value266 = -1L;
/* 409 */         if (!scan_isNull) {
/* 410 */           bhj_value266 = (long) scan_value;
/* 411 */         }
/* 412 */         // Check if the key has nulls.
/* 413 */         if (!(bhj_isNull266)) {
/* 414 */           // Check if the HashedRelation exists.
/* 415 */           UnsafeRow bhj_matched2 = (UnsafeRow)bhj_relation2.getValue(bhj_value266);
/* 416 */           if (bhj_matched2 != null) {
/* 417 */             // Evaluate the condition.
/* 418 */             continue;
/* 419 */           }
/* 420 */         }
/* 421 */         bhj_numOutputRows2.add(1);
/* 422 */
/* 423 */         // generate join key for stream side
/* 424 */
/* 425 */         boolean bhj_isNull410 = false;
/* 426 */         long bhj_value410 = -1L;
/* 427 */         if (!false) {
/* 428 */           bhj_value410 = (long) scan_value4;
/* 429 */         }
/* 430 */         // find matches from HashedRelation
/* 431 */         UnsafeRow bhj_matched3 = bhj_isNull410 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value410);
/* 432 */         if (bhj_matched3 == null) continue;
/* 433 */
/* 434 */         bhj_numOutputRows3.add(1);
/* 435 */
/* 436 */         // generate join key for stream side
/* 437 */
/* 438 */         boolean bhj_isNull416 = false;
/* 439 */         long bhj_value416 = -1L;
/* 440 */         if (!false) {
/* 441 */           bhj_value416 = (long) scan_value2;
/* 442 */         }
/* 443 */         // find matches from HashedRelation
/* 444 */         UnsafeRow bhj_matched4 = bhj_isNull416 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value416);
/* 445 */         if (bhj_matched4 == null) continue;
/* 446 */
/* 447 */         bhj_numOutputRows4.add(1);
/* 448 */
/* 449 */         boolean bhj_isNull419 = bhj_matched4.isNullAt(1);
/* 450 */         UTF8String bhj_value419 = bhj_isNull419 ? null : (bhj_matched4.getUTF8String(1));
/* 451 */         boolean bhj_isNull420 = bhj_matched4.isNullAt(2);
/* 452 */         UTF8String bhj_value420 = bhj_isNull420 ? null : (bhj_matched4.getUTF8String(2));
/* 453 */         boolean bhj_isNull421 = bhj_matched4.isNullAt(3);
/* 454 */         UTF8String bhj_value421 = bhj_isNull421 ? null : (bhj_matched4.getUTF8String(3));
/* 455 */         boolean bhj_isNull422 = bhj_matched4.isNullAt(4);
/* 456 */         int bhj_value422 = bhj_isNull422 ? -1 : (bhj_matched4.getInt(4));
/* 457 */         boolean bhj_isNull423 = bhj_matched4.isNullAt(5);
/* 458 */         UTF8String bhj_value423 = bhj_isNull423 ? null : (bhj_matched4.getUTF8String(5));
/* 459 */
/* 460 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 461 */
/* 462 */         UnsafeRow agg_fastAggBuffer = null;
/* 463 */
/* 464 */         if (true) {
/* 465 */           if (!bhj_isNull419 && !bhj_isNull420 && !bhj_isNull421 && !bhj_isNull422 && !bhj_isNull423) {
/* 466 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 467 */               bhj_value419, bhj_value420, bhj_value421, bhj_value422, bhj_value423);
/* 468 */           }
/* 469 */         }
/* 470 */
/* 471 */         if (agg_fastAggBuffer == null) {
/* 472 */           // generate grouping key
/* 473 */           agg_holder.reset();
/* 474 */
/* 475 */           agg_rowWriter.zeroOutNullBytes();
/* 476 */
/* 477 */           if (bhj_isNull419) {
/* 478 */             agg_rowWriter.setNullAt(0);
/* 479 */           } else {
/* 480 */             agg_rowWriter.write(0, bhj_value419);
/* 481 */           }
/* 482 */
/* 483 */           if (bhj_isNull420) {
/* 484 */             agg_rowWriter.setNullAt(1);
/* 485 */           } else {
/* 486 */             agg_rowWriter.write(1, bhj_value420);
/* 487 */           }
/* 488 */
/* 489 */           if (bhj_isNull421) {
/* 490 */             agg_rowWriter.setNullAt(2);
/* 491 */           } else {
/* 492 */             agg_rowWriter.write(2, bhj_value421);
/* 493 */           }
/* 494 */
/* 495 */           if (bhj_isNull422) {
/* 496 */             agg_rowWriter.setNullAt(3);
/* 497 */           } else {
/* 498 */             agg_rowWriter.write(3, bhj_value422);
/* 499 */           }
/* 500 */
/* 501 */           if (bhj_isNull423) {
/* 502 */             agg_rowWriter.setNullAt(4);
/* 503 */           } else {
/* 504 */             agg_rowWriter.write(4, bhj_value423);
/* 505 */           }
/* 506 */           agg_result5.setTotalSize(agg_holder.totalSize());
/* 507 */           agg_value16 = 42;
/* 508 */
/* 509 */           if (!bhj_isNull419) {
/* 510 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value419.getBaseObject(), bhj_value419.getBaseOffset(), bhj_value419.numBytes(), agg_value16);
/* 511 */           }
/* 512 */
/* 513 */           if (!bhj_isNull420) {
/* 514 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value420.getBaseObject(), bhj_value420.getBaseOffset(), bhj_value420.numBytes(), agg_value16);
/* 515 */           }
/* 516 */
/* 517 */           if (!bhj_isNull421) {
/* 518 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value421.getBaseObject(), bhj_value421.getBaseOffset(), bhj_value421.numBytes(), agg_value16);
/* 519 */           }
/* 520 */
/* 521 */           if (!bhj_isNull422) {
/* 522 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value422, agg_value16);
/* 523 */           }
/* 524 */
/* 525 */           if (!bhj_isNull423) {
/* 526 */             agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value423.getBaseObject(), bhj_value423.getBaseOffset(), bhj_value423.numBytes(), agg_value16);
/* 527 */           }
/* 528 */           if (true) {
/* 529 */             // try to get the buffer from hash map
/* 530 */             agg_unsafeRowAggBuffer =
/* 531 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value16);
/* 532 */           }
/* 533 */           if (agg_unsafeRowAggBuffer == null) {
/* 534 */             if (agg_sorter == null) {
/* 535 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 536 */             } else {
/* 537 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 538 */             }
/* 539 */
/* 540 */             // the hash map had be spilled, it should have enough memory now,
/* 541 */             // try  to allocate buffer again.
/* 542 */             agg_unsafeRowAggBuffer =
/* 543 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value16);
/* 544 */             if (agg_unsafeRowAggBuffer == null) {
/* 545 */               // failed to allocate the first page
/* 546 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 547 */             }
/* 548 */           }
/* 549 */         }
/* 550 */
/* 551 */         if (agg_fastAggBuffer != null) {
/* 552 */           // update fast row
/* 553 */
/* 554 */           // common sub-expressions
/* 555 */
/* 556 */           // evaluate aggregate function
/* 557 */           boolean agg_isNull28 = false;
/* 558 */
/* 559 */           long agg_value32 = agg_fastAggBuffer.getLong(0);
/* 560 */
/* 561 */           long agg_value31 = -1L;
/* 562 */           agg_value31 = agg_value32 + 1L;
/* 563 */           boolean agg_isNull31 = false;
/* 564 */
/* 565 */           long agg_value35 = agg_fastAggBuffer.getLong(1);
/* 566 */
/* 567 */           long agg_value34 = -1L;
/* 568 */           agg_value34 = agg_value35 + 1L;
/* 569 */           boolean agg_isNull34 = false;
/* 570 */
/* 571 */           long agg_value38 = agg_fastAggBuffer.getLong(2);
/* 572 */
/* 573 */           long agg_value37 = -1L;
/* 574 */           agg_value37 = agg_value38 + 1L;
/* 575 */           // update fast row
/* 576 */           agg_fastAggBuffer.setLong(0, agg_value31);
/* 577 */           agg_fastAggBuffer.setLong(1, agg_value34);
/* 578 */           agg_fastAggBuffer.setLong(2, agg_value37);
/* 579 */
/* 580 */         } else {
/* 581 */           // update unsafe row
/* 582 */
/* 583 */           // common sub-expressions
/* 584 */
/* 585 */           // evaluate aggregate function
/* 586 */           boolean agg_isNull19 = false;
/* 587 */
/* 588 */           long agg_value23 = agg_unsafeRowAggBuffer.getLong(0);
/* 589 */
/* 590 */           long agg_value22 = -1L;
/* 591 */           agg_value22 = agg_value23 + 1L;
/* 592 */           boolean agg_isNull22 = false;
/* 593 */
/* 594 */           long agg_value26 = agg_unsafeRowAggBuffer.getLong(1);
/* 595 */
/* 596 */           long agg_value25 = -1L;
/* 597 */           agg_value25 = agg_value26 + 1L;
/* 598 */           boolean agg_isNull25 = false;
/* 599 */
/* 600 */           long agg_value29 = agg_unsafeRowAggBuffer.getLong(2);
/* 601 */
/* 602 */           long agg_value28 = -1L;
/* 603 */           agg_value28 = agg_value29 + 1L;
/* 604 */           // update unsafe row buffer
/* 605 */           agg_unsafeRowAggBuffer.setLong(0, agg_value22);
/* 606 */           agg_unsafeRowAggBuffer.setLong(1, agg_value25);
/* 607 */           agg_unsafeRowAggBuffer.setLong(2, agg_value28);
/* 608 */
/* 609 */         }
/* 610 */         if (shouldStop()) return;
/* 611 */       }
/* 612 */       scan_batch = null;
/* 613 */       scan_nextBatch();
/* 614 */     }
/* 615 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 616 */     scan_scanTime1 = 0;
/* 617 */
/* 618 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 619 */
/* 620 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 621 */   }
/* 622 */
/* 623 */   private void wholestagecodegen_init_5() {
/* 624 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 7);
/* 625 */     project_result3 = new UnsafeRow(5);
/* 626 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 128);
/* 627 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 628 */     agg_result5 = new UnsafeRow(5);
/* 629 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 128);
/* 630 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 631 */
/* 632 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 633 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 634 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 635 */
/* 636 */   }
/* 637 */
/* 638 */   private void wholestagecodegen_init_2() {
/* 639 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 640 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 641 */
/* 642 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 643 */     bhj_result = new UnsafeRow(18);
/* 644 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 288);
/* 645 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 18);
/* 646 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 647 */
/* 648 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 649 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 650 */
/* 651 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 652 */     bhj_result1 = new UnsafeRow(18);
/* 653 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 288);
/* 654 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 18);
/* 655 */
/* 656 */   }
/* 657 */
/* 658 */   private void wholestagecodegen_init_1() {
/* 659 */     scan_colInstance14 = null;
/* 660 */     scan_colInstance15 = null;
/* 661 */     scan_colInstance16 = null;
/* 662 */     scan_colInstance17 = null;
/* 663 */     scan_result = new UnsafeRow(18);
/* 664 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 288);
/* 665 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 18);
/* 666 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 667 */     filter_result = new UnsafeRow(18);
/* 668 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 669 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 18);
/* 670 */     project_result = new UnsafeRow(18);
/* 671 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 672 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 18);
/* 673 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 674 */
/* 675 */   }
/* 676 */
/* 677 */   private void wholestagecodegen_init_4() {
/* 678 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 679 */     bhj_result3 = new UnsafeRow(3);
/* 680 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 0);
/* 681 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 3);
/* 682 */     project_result2 = new UnsafeRow(1);
/* 683 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 684 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 1);
/* 685 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 686 */
/* 687 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 688 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 689 */
/* 690 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 691 */     bhj_result4 = new UnsafeRow(7);
/* 692 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 128);
/* 693 */
/* 694 */   }
/* 695 */
/* 696 */   protected void processNext() throws java.io.IOException {
/* 697 */     if (!agg_initAgg) {
/* 698 */       agg_initAgg = true;
/* 699 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 700 */       agg_doAggregateWithKeys();
/* 701 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 702 */     }
/* 703 */
/* 704 */     // output the result
/* 705 */
/* 706 */     while (agg_fastHashMapIter.next()) {
/* 707 */       wholestagecodegen_numOutputRows.add(1);
/* 708 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 709 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 710 */
/* 711 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 712 */
/* 713 */       append(agg_resultRow);
/* 714 */
/* 715 */       if (shouldStop()) return;
/* 716 */     }
/* 717 */     agg_fastHashMap.close();
/* 718 */
/* 719 */     while (agg_mapIter.next()) {
/* 720 */       wholestagecodegen_numOutputRows.add(1);
/* 721 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 722 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 723 */
/* 724 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 725 */
/* 726 */       append(agg_resultRow);
/* 727 */
/* 728 */       if (shouldStop()) return;
/* 729 */     }
/* 730 */
/* 731 */     agg_mapIter.close();
/* 732 */     if (agg_sorter == null) {
/* 733 */       agg_hashMap.free();
/* 734 */     }
/* 735 */   }
/* 736 */ }
