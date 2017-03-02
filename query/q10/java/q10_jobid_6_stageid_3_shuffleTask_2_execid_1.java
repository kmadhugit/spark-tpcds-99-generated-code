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
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 022 */   private agg_FastHashMap agg_fastHashMap;
/* 023 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 024 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 025 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 026 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 029 */   private scala.collection.Iterator scan_input;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 032 */   private long scan_scanTime1;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 034 */   private int scan_batchIdx;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 044 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 047 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 048 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 049 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 050 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 051 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 052 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 053 */   private UnsafeRow scan_result;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 057 */   private UnsafeRow filter_result;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 060 */   private UnsafeRow project_result;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 066 */   private UnsafeRow bhj_result;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 069 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 070 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 072 */   private UnsafeRow bhj_result1;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 075 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 076 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 078 */   private UnsafeRow bhj_result2;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 081 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows1;
/* 082 */   private UnsafeRow filter_result1;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder1;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter1;
/* 085 */   private UnsafeRow project_result1;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 088 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 089 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 090 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 091 */   private UnsafeRow bhj_result3;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 093 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 094 */   private UnsafeRow project_result2;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 096 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 097 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 098 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 099 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 100 */   private UnsafeRow bhj_result4;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 102 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 103 */   private UnsafeRow project_result3;
/* 104 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 105 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 106 */   private UnsafeRow agg_result8;
/* 107 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 108 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 109 */   private int agg_value28;
/* 110 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 111 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 112 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 113 */
/* 114 */   public GeneratedIterator(Object[] references) {
/* 115 */     this.references = references;
/* 116 */   }
/* 117 */
/* 118 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 119 */     partitionIndex = index;
/* 120 */     this.inputs = inputs;
/* 121 */     wholestagecodegen_init_0();
/* 122 */     wholestagecodegen_init_1();
/* 123 */     wholestagecodegen_init_2();
/* 124 */     wholestagecodegen_init_3();
/* 125 */     wholestagecodegen_init_4();
/* 126 */     wholestagecodegen_init_5();
/* 127 */     wholestagecodegen_init_6();
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void wholestagecodegen_init_0() {
/* 132 */     agg_initAgg = false;
/* 133 */
/* 134 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 135 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 136 */
/* 137 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 138 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 139 */     scan_input = inputs[0];
/* 140 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 141 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 142 */     scan_scanTime1 = 0;
/* 143 */     scan_batch = null;
/* 144 */     scan_batchIdx = 0;
/* 145 */     scan_colInstance0 = null;
/* 146 */     scan_colInstance1 = null;
/* 147 */     scan_colInstance2 = null;
/* 148 */     scan_colInstance3 = null;
/* 149 */     scan_colInstance4 = null;
/* 150 */     scan_colInstance5 = null;
/* 151 */     scan_colInstance6 = null;
/* 152 */     scan_colInstance7 = null;
/* 153 */     scan_colInstance8 = null;
/* 154 */     scan_colInstance9 = null;
/* 155 */     scan_colInstance10 = null;
/* 156 */     scan_colInstance11 = null;
/* 157 */     scan_colInstance12 = null;
/* 158 */     scan_colInstance13 = null;
/* 159 */
/* 160 */   }
/* 161 */
/* 162 */   private void wholestagecodegen_init_3() {
/* 163 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 164 */
/* 165 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 166 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 167 */
/* 168 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 169 */     bhj_result2 = new UnsafeRow(20);
/* 170 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 288);
/* 171 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 20);
/* 172 */     this.filter_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 173 */     filter_result1 = new UnsafeRow(20);
/* 174 */     this.filter_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result1, 288);
/* 175 */     this.filter_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder1, 20);
/* 176 */     project_result1 = new UnsafeRow(2);
/* 177 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 178 */
/* 179 */   }
/* 180 */
/* 181 */   private void scan_nextBatch() throws java.io.IOException {
/* 182 */     long getBatchStart = System.nanoTime();
/* 183 */     if (scan_input.hasNext()) {
/* 184 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 185 */       scan_numOutputRows.add(scan_batch.numRows());
/* 186 */       scan_batchIdx = 0;
/* 187 */       scan_colInstance0 = scan_batch.column(0);
/* 188 */       scan_colInstance1 = scan_batch.column(1);
/* 189 */       scan_colInstance2 = scan_batch.column(2);
/* 190 */       scan_colInstance3 = scan_batch.column(3);
/* 191 */       scan_colInstance4 = scan_batch.column(4);
/* 192 */       scan_colInstance5 = scan_batch.column(5);
/* 193 */       scan_colInstance6 = scan_batch.column(6);
/* 194 */       scan_colInstance7 = scan_batch.column(7);
/* 195 */       scan_colInstance8 = scan_batch.column(8);
/* 196 */       scan_colInstance9 = scan_batch.column(9);
/* 197 */       scan_colInstance10 = scan_batch.column(10);
/* 198 */       scan_colInstance11 = scan_batch.column(11);
/* 199 */       scan_colInstance12 = scan_batch.column(12);
/* 200 */       scan_colInstance13 = scan_batch.column(13);
/* 201 */       scan_colInstance14 = scan_batch.column(14);
/* 202 */       scan_colInstance15 = scan_batch.column(15);
/* 203 */       scan_colInstance16 = scan_batch.column(16);
/* 204 */       scan_colInstance17 = scan_batch.column(17);
/* 205 */
/* 206 */     }
/* 207 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 208 */   }
/* 209 */
/* 210 */   public class agg_FastHashMap {
/* 211 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 212 */     private int[] buckets;
/* 213 */     private int capacity = 1 << 16;
/* 214 */     private double loadFactor = 0.5;
/* 215 */     private int numBuckets = (int) (capacity / loadFactor);
/* 216 */     private int maxSteps = 2;
/* 217 */     private int numRows = 0;
/* 218 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("cd_gender", org.apache.spark.sql.types.DataTypes.StringType)
/* 219 */     .add("cd_marital_status", org.apache.spark.sql.types.DataTypes.StringType)
/* 220 */     .add("cd_education_status", org.apache.spark.sql.types.DataTypes.StringType)
/* 221 */     .add("cd_purchase_estimate", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 222 */     .add("cd_credit_rating", org.apache.spark.sql.types.DataTypes.StringType)
/* 223 */     .add("cd_dep_count", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 224 */     .add("cd_dep_employed_count", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 225 */     .add("cd_dep_college_count", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 226 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 227 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 228 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 229 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 230 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 231 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType);
/* 232 */     private Object emptyVBase;
/* 233 */     private long emptyVOff;
/* 234 */     private int emptyVLen;
/* 235 */     private boolean isBatchFull = false;
/* 236 */
/* 237 */     public agg_FastHashMap(
/* 238 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 239 */       InternalRow emptyAggregationBuffer) {
/* 240 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 241 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 242 */
/* 243 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 244 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 245 */
/* 246 */       emptyVBase = emptyBuffer;
/* 247 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 248 */       emptyVLen = emptyBuffer.length;
/* 249 */
/* 250 */       buckets = new int[numBuckets];
/* 251 */       java.util.Arrays.fill(buckets, -1);
/* 252 */     }
/* 253 */
/* 254 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, int agg_key5, int agg_key6, int agg_key7) {
/* 255 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 256 */       int step = 0;
/* 257 */       int idx = (int) h & (numBuckets - 1);
/* 258 */       while (step < maxSteps) {
/* 259 */         // Return bucket index if it's either an empty slot or already contains the key
/* 260 */         if (buckets[idx] == -1) {
/* 261 */           if (numRows < capacity && !isBatchFull) {
/* 262 */             // creating the unsafe for new entry
/* 263 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 264 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 265 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 266 */               128);
/* 267 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 268 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 269 */               agg_holder,
/* 270 */               8);
/* 271 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 272 */             agg_rowWriter.zeroOutNullBytes();
/* 273 */             agg_rowWriter.write(0, agg_key);
/* 274 */             agg_rowWriter.write(1, agg_key1);
/* 275 */             agg_rowWriter.write(2, agg_key2);
/* 276 */             agg_rowWriter.write(3, agg_key3);
/* 277 */             agg_rowWriter.write(4, agg_key4);
/* 278 */             agg_rowWriter.write(5, agg_key5);
/* 279 */             agg_rowWriter.write(6, agg_key6);
/* 280 */             agg_rowWriter.write(7, agg_key7);
/* 281 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 282 */             Object kbase = agg_result.getBaseObject();
/* 283 */             long koff = agg_result.getBaseOffset();
/* 284 */             int klen = agg_result.getSizeInBytes();
/* 285 */
/* 286 */             UnsafeRow vRow
/* 287 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 288 */             if (vRow == null) {
/* 289 */               isBatchFull = true;
/* 290 */             } else {
/* 291 */               buckets[idx] = numRows++;
/* 292 */             }
/* 293 */             return vRow;
/* 294 */           } else {
/* 295 */             // No more space
/* 296 */             return null;
/* 297 */           }
/* 298 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 299 */           return batch.getValueRow(buckets[idx]);
/* 300 */         }
/* 301 */         idx = (idx + 1) & (numBuckets - 1);
/* 302 */         step++;
/* 303 */       }
/* 304 */       // Didn't find it
/* 305 */       return null;
/* 306 */     }
/* 307 */
/* 308 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, int agg_key5, int agg_key6, int agg_key7) {
/* 309 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 310 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getUTF8String(4).equals(agg_key4)) && (row.getInt(5) == agg_key5) && (row.getInt(6) == agg_key6) && (row.getInt(7) == agg_key7);
/* 311 */     }
/* 312 */
/* 313 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, int agg_key5, int agg_key6, int agg_key7) {
/* 314 */       long agg_hash = 0;
/* 315 */
/* 316 */       int agg_result = 0;
/* 317 */       byte[] agg_bytes = agg_key.getBytes();
/* 318 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 319 */         int agg_hash1 = agg_bytes[i];
/* 320 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 321 */       }
/* 322 */
/* 323 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 324 */
/* 325 */       int agg_result1 = 0;
/* 326 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 327 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 328 */         int agg_hash2 = agg_bytes1[i];
/* 329 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 330 */       }
/* 331 */
/* 332 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 333 */
/* 334 */       int agg_result2 = 0;
/* 335 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 336 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 337 */         int agg_hash3 = agg_bytes2[i];
/* 338 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 339 */       }
/* 340 */
/* 341 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 342 */
/* 343 */       int agg_result3 = agg_key3;
/* 344 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 345 */
/* 346 */       int agg_result4 = 0;
/* 347 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 348 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 349 */         int agg_hash4 = agg_bytes3[i];
/* 350 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 351 */       }
/* 352 */
/* 353 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 354 */
/* 355 */       int agg_result5 = agg_key5;
/* 356 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 357 */
/* 358 */       int agg_result6 = agg_key6;
/* 359 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 360 */
/* 361 */       int agg_result7 = agg_key7;
/* 362 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 363 */
/* 364 */       return agg_hash;
/* 365 */     }
/* 366 */
/* 367 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 368 */       return batch.rowIterator();
/* 369 */     }
/* 370 */
/* 371 */     public void close() {
/* 372 */       batch.close();
/* 373 */     }
/* 374 */
/* 375 */   }
/* 376 */
/* 377 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 378 */     agg_hashMap = agg_plan.createHashMap();
/* 379 */
/* 380 */     if (scan_batch == null) {
/* 381 */       scan_nextBatch();
/* 382 */     }
/* 383 */     while (scan_batch != null) {
/* 384 */       int numRows = scan_batch.numRows();
/* 385 */       while (scan_batchIdx < numRows) {
/* 386 */         int scan_rowIdx = scan_batchIdx++;
/* 387 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 388 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 389 */
/* 390 */         if (!(!(scan_isNull4))) continue;
/* 391 */
/* 392 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 393 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 394 */
/* 395 */         if (!(!(scan_isNull2))) continue;
/* 396 */
/* 397 */         filter_numOutputRows.add(1);
/* 398 */
/* 399 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 400 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 401 */
/* 402 */         // generate join key for stream side
/* 403 */
/* 404 */         boolean bhj_isNull = scan_isNull;
/* 405 */         long bhj_value = -1L;
/* 406 */         if (!scan_isNull) {
/* 407 */           bhj_value = (long) scan_value;
/* 408 */         }
/* 409 */         // find matches from HashedRelation
/* 410 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 411 */         if (bhj_matched == null) continue;
/* 412 */
/* 413 */         bhj_numOutputRows.add(1);
/* 414 */
/* 415 */         // generate join key for stream side
/* 416 */
/* 417 */         boolean bhj_isNull122 = scan_isNull;
/* 418 */         long bhj_value122 = -1L;
/* 419 */         if (!scan_isNull) {
/* 420 */           bhj_value122 = (long) scan_value;
/* 421 */         }
/* 422 */         // find matches from HashedRelation
/* 423 */         UnsafeRow bhj_matched1 = bhj_isNull122 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value122);
/* 424 */         boolean bhj_exists = false;
/* 425 */         if (bhj_matched1 != null) {
/* 426 */           bhj_exists = true;
/* 427 */         }
/* 428 */         bhj_numOutputRows1.add(1);
/* 429 */
/* 430 */         // generate join key for stream side
/* 431 */
/* 432 */         boolean bhj_isNull267 = scan_isNull;
/* 433 */         long bhj_value267 = -1L;
/* 434 */         if (!scan_isNull) {
/* 435 */           bhj_value267 = (long) scan_value;
/* 436 */         }
/* 437 */         // find matches from HashedRelation
/* 438 */         UnsafeRow bhj_matched2 = bhj_isNull267 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value267);
/* 439 */         boolean bhj_exists1 = false;
/* 440 */         if (bhj_matched2 != null) {
/* 441 */           bhj_exists1 = true;
/* 442 */         }
/* 443 */         bhj_numOutputRows2.add(1);
/* 444 */
/* 445 */         boolean filter_value22 = true;
/* 446 */
/* 447 */         if (!bhj_exists) {
/* 448 */           filter_value22 = bhj_exists1;
/* 449 */         }
/* 450 */         if (!filter_value22) continue;
/* 451 */
/* 452 */         filter_numOutputRows1.add(1);
/* 453 */
/* 454 */         // generate join key for stream side
/* 455 */
/* 456 */         boolean bhj_isNull413 = false;
/* 457 */         long bhj_value413 = -1L;
/* 458 */         if (!false) {
/* 459 */           bhj_value413 = (long) scan_value4;
/* 460 */         }
/* 461 */         // find matches from HashedRelation
/* 462 */         UnsafeRow bhj_matched3 = bhj_isNull413 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value413);
/* 463 */         if (bhj_matched3 == null) continue;
/* 464 */
/* 465 */         bhj_numOutputRows3.add(1);
/* 466 */
/* 467 */         // generate join key for stream side
/* 468 */
/* 469 */         boolean bhj_isNull419 = false;
/* 470 */         long bhj_value419 = -1L;
/* 471 */         if (!false) {
/* 472 */           bhj_value419 = (long) scan_value2;
/* 473 */         }
/* 474 */         // find matches from HashedRelation
/* 475 */         UnsafeRow bhj_matched4 = bhj_isNull419 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value419);
/* 476 */         if (bhj_matched4 == null) continue;
/* 477 */
/* 478 */         bhj_numOutputRows4.add(1);
/* 479 */
/* 480 */         boolean bhj_isNull422 = bhj_matched4.isNullAt(1);
/* 481 */         UTF8String bhj_value422 = bhj_isNull422 ? null : (bhj_matched4.getUTF8String(1));
/* 482 */         boolean bhj_isNull423 = bhj_matched4.isNullAt(2);
/* 483 */         UTF8String bhj_value423 = bhj_isNull423 ? null : (bhj_matched4.getUTF8String(2));
/* 484 */         boolean bhj_isNull424 = bhj_matched4.isNullAt(3);
/* 485 */         UTF8String bhj_value424 = bhj_isNull424 ? null : (bhj_matched4.getUTF8String(3));
/* 486 */         boolean bhj_isNull425 = bhj_matched4.isNullAt(4);
/* 487 */         int bhj_value425 = bhj_isNull425 ? -1 : (bhj_matched4.getInt(4));
/* 488 */         boolean bhj_isNull426 = bhj_matched4.isNullAt(5);
/* 489 */         UTF8String bhj_value426 = bhj_isNull426 ? null : (bhj_matched4.getUTF8String(5));
/* 490 */         boolean bhj_isNull427 = bhj_matched4.isNullAt(6);
/* 491 */         int bhj_value427 = bhj_isNull427 ? -1 : (bhj_matched4.getInt(6));
/* 492 */         boolean bhj_isNull428 = bhj_matched4.isNullAt(7);
/* 493 */         int bhj_value428 = bhj_isNull428 ? -1 : (bhj_matched4.getInt(7));
/* 494 */         boolean bhj_isNull429 = bhj_matched4.isNullAt(8);
/* 495 */         int bhj_value429 = bhj_isNull429 ? -1 : (bhj_matched4.getInt(8));
/* 496 */
/* 497 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 498 */
/* 499 */         UnsafeRow agg_fastAggBuffer = null;
/* 500 */
/* 501 */         if (true) {
/* 502 */           if (!bhj_isNull422 && !bhj_isNull423 && !bhj_isNull424 && !bhj_isNull425 && !bhj_isNull426 && !bhj_isNull427 && !bhj_isNull428 && !bhj_isNull429) {
/* 503 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 504 */               bhj_value422, bhj_value423, bhj_value424, bhj_value425, bhj_value426, bhj_value427, bhj_value428, bhj_value429);
/* 505 */           }
/* 506 */         }
/* 507 */
/* 508 */         if (agg_fastAggBuffer == null) {
/* 509 */           // generate grouping key
/* 510 */           agg_holder.reset();
/* 511 */
/* 512 */           agg_rowWriter.zeroOutNullBytes();
/* 513 */
/* 514 */           if (bhj_isNull422) {
/* 515 */             agg_rowWriter.setNullAt(0);
/* 516 */           } else {
/* 517 */             agg_rowWriter.write(0, bhj_value422);
/* 518 */           }
/* 519 */
/* 520 */           if (bhj_isNull423) {
/* 521 */             agg_rowWriter.setNullAt(1);
/* 522 */           } else {
/* 523 */             agg_rowWriter.write(1, bhj_value423);
/* 524 */           }
/* 525 */
/* 526 */           if (bhj_isNull424) {
/* 527 */             agg_rowWriter.setNullAt(2);
/* 528 */           } else {
/* 529 */             agg_rowWriter.write(2, bhj_value424);
/* 530 */           }
/* 531 */
/* 532 */           if (bhj_isNull425) {
/* 533 */             agg_rowWriter.setNullAt(3);
/* 534 */           } else {
/* 535 */             agg_rowWriter.write(3, bhj_value425);
/* 536 */           }
/* 537 */
/* 538 */           if (bhj_isNull426) {
/* 539 */             agg_rowWriter.setNullAt(4);
/* 540 */           } else {
/* 541 */             agg_rowWriter.write(4, bhj_value426);
/* 542 */           }
/* 543 */
/* 544 */           if (bhj_isNull427) {
/* 545 */             agg_rowWriter.setNullAt(5);
/* 546 */           } else {
/* 547 */             agg_rowWriter.write(5, bhj_value427);
/* 548 */           }
/* 549 */
/* 550 */           if (bhj_isNull428) {
/* 551 */             agg_rowWriter.setNullAt(6);
/* 552 */           } else {
/* 553 */             agg_rowWriter.write(6, bhj_value428);
/* 554 */           }
/* 555 */
/* 556 */           if (bhj_isNull429) {
/* 557 */             agg_rowWriter.setNullAt(7);
/* 558 */           } else {
/* 559 */             agg_rowWriter.write(7, bhj_value429);
/* 560 */           }
/* 561 */           agg_result8.setTotalSize(agg_holder.totalSize());
/* 562 */           agg_value28 = 42;
/* 563 */
/* 564 */           if (!bhj_isNull422) {
/* 565 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value422.getBaseObject(), bhj_value422.getBaseOffset(), bhj_value422.numBytes(), agg_value28);
/* 566 */           }
/* 567 */
/* 568 */           if (!bhj_isNull423) {
/* 569 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value423.getBaseObject(), bhj_value423.getBaseOffset(), bhj_value423.numBytes(), agg_value28);
/* 570 */           }
/* 571 */
/* 572 */           if (!bhj_isNull424) {
/* 573 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value424.getBaseObject(), bhj_value424.getBaseOffset(), bhj_value424.numBytes(), agg_value28);
/* 574 */           }
/* 575 */
/* 576 */           if (!bhj_isNull425) {
/* 577 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value425, agg_value28);
/* 578 */           }
/* 579 */
/* 580 */           if (!bhj_isNull426) {
/* 581 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value426.getBaseObject(), bhj_value426.getBaseOffset(), bhj_value426.numBytes(), agg_value28);
/* 582 */           }
/* 583 */
/* 584 */           if (!bhj_isNull427) {
/* 585 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value427, agg_value28);
/* 586 */           }
/* 587 */
/* 588 */           if (!bhj_isNull428) {
/* 589 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value428, agg_value28);
/* 590 */           }
/* 591 */
/* 592 */           if (!bhj_isNull429) {
/* 593 */             agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value429, agg_value28);
/* 594 */           }
/* 595 */           if (true) {
/* 596 */             // try to get the buffer from hash map
/* 597 */             agg_unsafeRowAggBuffer =
/* 598 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value28);
/* 599 */           }
/* 600 */           if (agg_unsafeRowAggBuffer == null) {
/* 601 */             if (agg_sorter == null) {
/* 602 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 603 */             } else {
/* 604 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 605 */             }
/* 606 */
/* 607 */             // the hash map had be spilled, it should have enough memory now,
/* 608 */             // try  to allocate buffer again.
/* 609 */             agg_unsafeRowAggBuffer =
/* 610 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value28);
/* 611 */             if (agg_unsafeRowAggBuffer == null) {
/* 612 */               // failed to allocate the first page
/* 613 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 614 */             }
/* 615 */           }
/* 616 */         }
/* 617 */
/* 618 */         if (agg_fastAggBuffer != null) {
/* 619 */           // update fast row
/* 620 */
/* 621 */           // common sub-expressions
/* 622 */
/* 623 */           // evaluate aggregate function
/* 624 */           boolean agg_isNull49 = false;
/* 625 */
/* 626 */           long agg_value56 = agg_fastAggBuffer.getLong(0);
/* 627 */
/* 628 */           long agg_value55 = -1L;
/* 629 */           agg_value55 = agg_value56 + 1L;
/* 630 */           boolean agg_isNull52 = false;
/* 631 */
/* 632 */           long agg_value59 = agg_fastAggBuffer.getLong(1);
/* 633 */
/* 634 */           long agg_value58 = -1L;
/* 635 */           agg_value58 = agg_value59 + 1L;
/* 636 */           boolean agg_isNull55 = false;
/* 637 */
/* 638 */           long agg_value62 = agg_fastAggBuffer.getLong(2);
/* 639 */
/* 640 */           long agg_value61 = -1L;
/* 641 */           agg_value61 = agg_value62 + 1L;
/* 642 */           boolean agg_isNull58 = false;
/* 643 */
/* 644 */           long agg_value65 = agg_fastAggBuffer.getLong(3);
/* 645 */
/* 646 */           long agg_value64 = -1L;
/* 647 */           agg_value64 = agg_value65 + 1L;
/* 648 */           boolean agg_isNull61 = false;
/* 649 */
/* 650 */           long agg_value68 = agg_fastAggBuffer.getLong(4);
/* 651 */
/* 652 */           long agg_value67 = -1L;
/* 653 */           agg_value67 = agg_value68 + 1L;
/* 654 */           boolean agg_isNull64 = false;
/* 655 */
/* 656 */           long agg_value71 = agg_fastAggBuffer.getLong(5);
/* 657 */
/* 658 */           long agg_value70 = -1L;
/* 659 */           agg_value70 = agg_value71 + 1L;
/* 660 */           // update fast row
/* 661 */           agg_fastAggBuffer.setLong(0, agg_value55);
/* 662 */           agg_fastAggBuffer.setLong(1, agg_value58);
/* 663 */           agg_fastAggBuffer.setLong(2, agg_value61);
/* 664 */           agg_fastAggBuffer.setLong(3, agg_value64);
/* 665 */           agg_fastAggBuffer.setLong(4, agg_value67);
/* 666 */           agg_fastAggBuffer.setLong(5, agg_value70);
/* 667 */
/* 668 */         } else {
/* 669 */           // update unsafe row
/* 670 */
/* 671 */           // common sub-expressions
/* 672 */
/* 673 */           // evaluate aggregate function
/* 674 */           boolean agg_isNull31 = false;
/* 675 */
/* 676 */           long agg_value38 = agg_unsafeRowAggBuffer.getLong(0);
/* 677 */
/* 678 */           long agg_value37 = -1L;
/* 679 */           agg_value37 = agg_value38 + 1L;
/* 680 */           boolean agg_isNull34 = false;
/* 681 */
/* 682 */           long agg_value41 = agg_unsafeRowAggBuffer.getLong(1);
/* 683 */
/* 684 */           long agg_value40 = -1L;
/* 685 */           agg_value40 = agg_value41 + 1L;
/* 686 */           boolean agg_isNull37 = false;
/* 687 */
/* 688 */           long agg_value44 = agg_unsafeRowAggBuffer.getLong(2);
/* 689 */
/* 690 */           long agg_value43 = -1L;
/* 691 */           agg_value43 = agg_value44 + 1L;
/* 692 */           boolean agg_isNull40 = false;
/* 693 */
/* 694 */           long agg_value47 = agg_unsafeRowAggBuffer.getLong(3);
/* 695 */
/* 696 */           long agg_value46 = -1L;
/* 697 */           agg_value46 = agg_value47 + 1L;
/* 698 */           boolean agg_isNull43 = false;
/* 699 */
/* 700 */           long agg_value50 = agg_unsafeRowAggBuffer.getLong(4);
/* 701 */
/* 702 */           long agg_value49 = -1L;
/* 703 */           agg_value49 = agg_value50 + 1L;
/* 704 */           boolean agg_isNull46 = false;
/* 705 */
/* 706 */           long agg_value53 = agg_unsafeRowAggBuffer.getLong(5);
/* 707 */
/* 708 */           long agg_value52 = -1L;
/* 709 */           agg_value52 = agg_value53 + 1L;
/* 710 */           // update unsafe row buffer
/* 711 */           agg_unsafeRowAggBuffer.setLong(0, agg_value37);
/* 712 */           agg_unsafeRowAggBuffer.setLong(1, agg_value40);
/* 713 */           agg_unsafeRowAggBuffer.setLong(2, agg_value43);
/* 714 */           agg_unsafeRowAggBuffer.setLong(3, agg_value46);
/* 715 */           agg_unsafeRowAggBuffer.setLong(4, agg_value49);
/* 716 */           agg_unsafeRowAggBuffer.setLong(5, agg_value52);
/* 717 */
/* 718 */         }
/* 719 */         if (shouldStop()) return;
/* 720 */       }
/* 721 */       scan_batch = null;
/* 722 */       scan_nextBatch();
/* 723 */     }
/* 724 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 725 */     scan_scanTime1 = 0;
/* 726 */
/* 727 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 728 */
/* 729 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 730 */   }
/* 731 */
/* 732 */   private void wholestagecodegen_init_5() {
/* 733 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 734 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 735 */
/* 736 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 737 */     bhj_result4 = new UnsafeRow(10);
/* 738 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 128);
/* 739 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 10);
/* 740 */     project_result3 = new UnsafeRow(8);
/* 741 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 128);
/* 742 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 8);
/* 743 */     agg_result8 = new UnsafeRow(8);
/* 744 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 128);
/* 745 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 746 */
/* 747 */   }
/* 748 */
/* 749 */   private void wholestagecodegen_init_2() {
/* 750 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 751 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 752 */
/* 753 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 754 */     bhj_result = new UnsafeRow(18);
/* 755 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 288);
/* 756 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 18);
/* 757 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 758 */
/* 759 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 760 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 761 */
/* 762 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 763 */     bhj_result1 = new UnsafeRow(19);
/* 764 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 288);
/* 765 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 19);
/* 766 */
/* 767 */   }
/* 768 */
/* 769 */   private void wholestagecodegen_init_1() {
/* 770 */     scan_colInstance14 = null;
/* 771 */     scan_colInstance15 = null;
/* 772 */     scan_colInstance16 = null;
/* 773 */     scan_colInstance17 = null;
/* 774 */     scan_result = new UnsafeRow(18);
/* 775 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 288);
/* 776 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 18);
/* 777 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 778 */     filter_result = new UnsafeRow(18);
/* 779 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 780 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 18);
/* 781 */     project_result = new UnsafeRow(18);
/* 782 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 783 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 18);
/* 784 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 785 */
/* 786 */   }
/* 787 */
/* 788 */   private void wholestagecodegen_init_4() {
/* 789 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 790 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 791 */
/* 792 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 793 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 794 */
/* 795 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 796 */     bhj_result3 = new UnsafeRow(3);
/* 797 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 0);
/* 798 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 3);
/* 799 */     project_result2 = new UnsafeRow(1);
/* 800 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 801 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 1);
/* 802 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 803 */
/* 804 */   }
/* 805 */
/* 806 */   private void wholestagecodegen_init_6() {
/* 807 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 808 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 809 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 810 */
/* 811 */   }
/* 812 */
/* 813 */   protected void processNext() throws java.io.IOException {
/* 814 */     if (!agg_initAgg) {
/* 815 */       agg_initAgg = true;
/* 816 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 817 */       agg_doAggregateWithKeys();
/* 818 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 819 */     }
/* 820 */
/* 821 */     // output the result
/* 822 */
/* 823 */     while (agg_fastHashMapIter.next()) {
/* 824 */       wholestagecodegen_numOutputRows.add(1);
/* 825 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 826 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 827 */
/* 828 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 829 */
/* 830 */       append(agg_resultRow);
/* 831 */
/* 832 */       if (shouldStop()) return;
/* 833 */     }
/* 834 */     agg_fastHashMap.close();
/* 835 */
/* 836 */     while (agg_mapIter.next()) {
/* 837 */       wholestagecodegen_numOutputRows.add(1);
/* 838 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 839 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 840 */
/* 841 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 842 */
/* 843 */       append(agg_resultRow);
/* 844 */
/* 845 */       if (shouldStop()) return;
/* 846 */     }
/* 847 */
/* 848 */     agg_mapIter.close();
/* 849 */     if (agg_sorter == null) {
/* 850 */       agg_hashMap.free();
/* 851 */     }
/* 852 */   }
/* 853 */ }
