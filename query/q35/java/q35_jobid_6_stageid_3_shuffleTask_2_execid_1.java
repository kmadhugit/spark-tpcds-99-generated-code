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
/* 012 */   private int agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private int agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private int agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private int agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private long agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private long agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private int agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private int agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private long agg_bufValue14;
/* 039 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 040 */   private agg_FastHashMap agg_fastHashMap;
/* 041 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 042 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 043 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 044 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 047 */   private scala.collection.Iterator scan_input;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 050 */   private long scan_scanTime1;
/* 051 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 052 */   private int scan_batchIdx;
/* 053 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 054 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 055 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 056 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 057 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 058 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 059 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 060 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 061 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 062 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 063 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 064 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 065 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 066 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 067 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 068 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 069 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 070 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 071 */   private UnsafeRow scan_result;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 075 */   private UnsafeRow filter_result;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 078 */   private UnsafeRow project_result;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 081 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 082 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 083 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 084 */   private UnsafeRow bhj_result;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 087 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 088 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 089 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 090 */   private UnsafeRow bhj_result1;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 093 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 094 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 095 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 096 */   private UnsafeRow bhj_result2;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 099 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows1;
/* 100 */   private UnsafeRow filter_result1;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder1;
/* 102 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter1;
/* 103 */   private UnsafeRow project_result1;
/* 104 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 105 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 106 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 107 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 108 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 109 */   private UnsafeRow bhj_result3;
/* 110 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 111 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 112 */   private UnsafeRow project_result2;
/* 113 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 114 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 115 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 116 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 117 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 118 */   private UnsafeRow bhj_result4;
/* 119 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 120 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 121 */   private UnsafeRow project_result3;
/* 122 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 123 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 124 */   private UnsafeRow agg_result6;
/* 125 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 126 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 127 */   private int agg_value45;
/* 128 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 129 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 130 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 131 */
/* 132 */   public GeneratedIterator(Object[] references) {
/* 133 */     this.references = references;
/* 134 */   }
/* 135 */
/* 136 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 137 */     partitionIndex = index;
/* 138 */     this.inputs = inputs;
/* 139 */     wholestagecodegen_init_0();
/* 140 */     wholestagecodegen_init_1();
/* 141 */     wholestagecodegen_init_2();
/* 142 */     wholestagecodegen_init_3();
/* 143 */     wholestagecodegen_init_4();
/* 144 */     wholestagecodegen_init_5();
/* 145 */     wholestagecodegen_init_6();
/* 146 */
/* 147 */   }
/* 148 */
/* 149 */   private void wholestagecodegen_init_0() {
/* 150 */     agg_initAgg = false;
/* 151 */
/* 152 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 153 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 154 */
/* 155 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 156 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 157 */     scan_input = inputs[0];
/* 158 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 159 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 160 */     scan_scanTime1 = 0;
/* 161 */     scan_batch = null;
/* 162 */     scan_batchIdx = 0;
/* 163 */     scan_colInstance0 = null;
/* 164 */     scan_colInstance1 = null;
/* 165 */     scan_colInstance2 = null;
/* 166 */     scan_colInstance3 = null;
/* 167 */     scan_colInstance4 = null;
/* 168 */     scan_colInstance5 = null;
/* 169 */     scan_colInstance6 = null;
/* 170 */     scan_colInstance7 = null;
/* 171 */     scan_colInstance8 = null;
/* 172 */     scan_colInstance9 = null;
/* 173 */     scan_colInstance10 = null;
/* 174 */     scan_colInstance11 = null;
/* 175 */     scan_colInstance12 = null;
/* 176 */
/* 177 */   }
/* 178 */
/* 179 */   private void wholestagecodegen_init_3() {
/* 180 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 181 */
/* 182 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 183 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 184 */
/* 185 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 186 */     bhj_result2 = new UnsafeRow(20);
/* 187 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 288);
/* 188 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 20);
/* 189 */     this.filter_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 190 */     filter_result1 = new UnsafeRow(20);
/* 191 */     this.filter_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result1, 288);
/* 192 */     this.filter_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder1, 20);
/* 193 */     project_result1 = new UnsafeRow(2);
/* 194 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 195 */
/* 196 */   }
/* 197 */
/* 198 */   private void scan_nextBatch() throws java.io.IOException {
/* 199 */     long getBatchStart = System.nanoTime();
/* 200 */     if (scan_input.hasNext()) {
/* 201 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 202 */       scan_numOutputRows.add(scan_batch.numRows());
/* 203 */       scan_batchIdx = 0;
/* 204 */       scan_colInstance0 = scan_batch.column(0);
/* 205 */       scan_colInstance1 = scan_batch.column(1);
/* 206 */       scan_colInstance2 = scan_batch.column(2);
/* 207 */       scan_colInstance3 = scan_batch.column(3);
/* 208 */       scan_colInstance4 = scan_batch.column(4);
/* 209 */       scan_colInstance5 = scan_batch.column(5);
/* 210 */       scan_colInstance6 = scan_batch.column(6);
/* 211 */       scan_colInstance7 = scan_batch.column(7);
/* 212 */       scan_colInstance8 = scan_batch.column(8);
/* 213 */       scan_colInstance9 = scan_batch.column(9);
/* 214 */       scan_colInstance10 = scan_batch.column(10);
/* 215 */       scan_colInstance11 = scan_batch.column(11);
/* 216 */       scan_colInstance12 = scan_batch.column(12);
/* 217 */       scan_colInstance13 = scan_batch.column(13);
/* 218 */       scan_colInstance14 = scan_batch.column(14);
/* 219 */       scan_colInstance15 = scan_batch.column(15);
/* 220 */       scan_colInstance16 = scan_batch.column(16);
/* 221 */       scan_colInstance17 = scan_batch.column(17);
/* 222 */
/* 223 */     }
/* 224 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 225 */   }
/* 226 */
/* 227 */   public class agg_FastHashMap {
/* 228 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 229 */     private int[] buckets;
/* 230 */     private int capacity = 1 << 16;
/* 231 */     private double loadFactor = 0.5;
/* 232 */     private int numBuckets = (int) (capacity / loadFactor);
/* 233 */     private int maxSteps = 2;
/* 234 */     private int numRows = 0;
/* 235 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("ca_state", org.apache.spark.sql.types.DataTypes.StringType)
/* 236 */     .add("cd_gender", org.apache.spark.sql.types.DataTypes.StringType)
/* 237 */     .add("cd_marital_status", org.apache.spark.sql.types.DataTypes.StringType)
/* 238 */     .add("cd_dep_count", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 239 */     .add("cd_dep_employed_count", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 240 */     .add("cd_dep_college_count", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 241 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 242 */     .add("min", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 243 */     .add("max", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 244 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 245 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 246 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 247 */     .add("min", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 248 */     .add("max", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 249 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 250 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 251 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType)
/* 252 */     .add("min", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 253 */     .add("max", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 254 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 255 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType);
/* 256 */     private Object emptyVBase;
/* 257 */     private long emptyVOff;
/* 258 */     private int emptyVLen;
/* 259 */     private boolean isBatchFull = false;
/* 260 */
/* 261 */     public agg_FastHashMap(
/* 262 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 263 */       InternalRow emptyAggregationBuffer) {
/* 264 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 265 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 266 */
/* 267 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 268 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 269 */
/* 270 */       emptyVBase = emptyBuffer;
/* 271 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 272 */       emptyVLen = emptyBuffer.length;
/* 273 */
/* 274 */       buckets = new int[numBuckets];
/* 275 */       java.util.Arrays.fill(buckets, -1);
/* 276 */     }
/* 277 */
/* 278 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4, int agg_key5) {
/* 279 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5);
/* 280 */       int step = 0;
/* 281 */       int idx = (int) h & (numBuckets - 1);
/* 282 */       while (step < maxSteps) {
/* 283 */         // Return bucket index if it's either an empty slot or already contains the key
/* 284 */         if (buckets[idx] == -1) {
/* 285 */           if (numRows < capacity && !isBatchFull) {
/* 286 */             // creating the unsafe for new entry
/* 287 */             UnsafeRow agg_result = new UnsafeRow(6);
/* 288 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 289 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 290 */               96);
/* 291 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 292 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 293 */               agg_holder,
/* 294 */               6);
/* 295 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 296 */             agg_rowWriter.zeroOutNullBytes();
/* 297 */             agg_rowWriter.write(0, agg_key);
/* 298 */             agg_rowWriter.write(1, agg_key1);
/* 299 */             agg_rowWriter.write(2, agg_key2);
/* 300 */             agg_rowWriter.write(3, agg_key3);
/* 301 */             agg_rowWriter.write(4, agg_key4);
/* 302 */             agg_rowWriter.write(5, agg_key5);
/* 303 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 304 */             Object kbase = agg_result.getBaseObject();
/* 305 */             long koff = agg_result.getBaseOffset();
/* 306 */             int klen = agg_result.getSizeInBytes();
/* 307 */
/* 308 */             UnsafeRow vRow
/* 309 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 310 */             if (vRow == null) {
/* 311 */               isBatchFull = true;
/* 312 */             } else {
/* 313 */               buckets[idx] = numRows++;
/* 314 */             }
/* 315 */             return vRow;
/* 316 */           } else {
/* 317 */             // No more space
/* 318 */             return null;
/* 319 */           }
/* 320 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5)) {
/* 321 */           return batch.getValueRow(buckets[idx]);
/* 322 */         }
/* 323 */         idx = (idx + 1) & (numBuckets - 1);
/* 324 */         step++;
/* 325 */       }
/* 326 */       // Didn't find it
/* 327 */       return null;
/* 328 */     }
/* 329 */
/* 330 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4, int agg_key5) {
/* 331 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 332 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getInt(4) == agg_key4) && (row.getInt(5) == agg_key5);
/* 333 */     }
/* 334 */
/* 335 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4, int agg_key5) {
/* 336 */       long agg_hash = 0;
/* 337 */
/* 338 */       int agg_result = 0;
/* 339 */       byte[] agg_bytes = agg_key.getBytes();
/* 340 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 341 */         int agg_hash1 = agg_bytes[i];
/* 342 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 343 */       }
/* 344 */
/* 345 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 346 */
/* 347 */       int agg_result1 = 0;
/* 348 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 349 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 350 */         int agg_hash2 = agg_bytes1[i];
/* 351 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 352 */       }
/* 353 */
/* 354 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 355 */
/* 356 */       int agg_result2 = 0;
/* 357 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 358 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 359 */         int agg_hash3 = agg_bytes2[i];
/* 360 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 361 */       }
/* 362 */
/* 363 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 364 */
/* 365 */       int agg_result3 = agg_key3;
/* 366 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 367 */
/* 368 */       int agg_result4 = agg_key4;
/* 369 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 370 */
/* 371 */       int agg_result5 = agg_key5;
/* 372 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 373 */
/* 374 */       return agg_hash;
/* 375 */     }
/* 376 */
/* 377 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 378 */       return batch.rowIterator();
/* 379 */     }
/* 380 */
/* 381 */     public void close() {
/* 382 */       batch.close();
/* 383 */     }
/* 384 */
/* 385 */   }
/* 386 */
/* 387 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 388 */     agg_hashMap = agg_plan.createHashMap();
/* 389 */
/* 390 */     if (scan_batch == null) {
/* 391 */       scan_nextBatch();
/* 392 */     }
/* 393 */     while (scan_batch != null) {
/* 394 */       int numRows = scan_batch.numRows();
/* 395 */       while (scan_batchIdx < numRows) {
/* 396 */         int scan_rowIdx = scan_batchIdx++;
/* 397 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 398 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 399 */
/* 400 */         if (!(!(scan_isNull4))) continue;
/* 401 */
/* 402 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 403 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 404 */
/* 405 */         if (!(!(scan_isNull2))) continue;
/* 406 */
/* 407 */         filter_numOutputRows.add(1);
/* 408 */
/* 409 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 410 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 411 */
/* 412 */         // generate join key for stream side
/* 413 */
/* 414 */         boolean bhj_isNull = scan_isNull;
/* 415 */         long bhj_value = -1L;
/* 416 */         if (!scan_isNull) {
/* 417 */           bhj_value = (long) scan_value;
/* 418 */         }
/* 419 */         // find matches from HashedRelation
/* 420 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 421 */         if (bhj_matched == null) continue;
/* 422 */
/* 423 */         bhj_numOutputRows.add(1);
/* 424 */
/* 425 */         // generate join key for stream side
/* 426 */
/* 427 */         boolean bhj_isNull122 = scan_isNull;
/* 428 */         long bhj_value122 = -1L;
/* 429 */         if (!scan_isNull) {
/* 430 */           bhj_value122 = (long) scan_value;
/* 431 */         }
/* 432 */         // find matches from HashedRelation
/* 433 */         UnsafeRow bhj_matched1 = bhj_isNull122 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value122);
/* 434 */         boolean bhj_exists = false;
/* 435 */         if (bhj_matched1 != null) {
/* 436 */           bhj_exists = true;
/* 437 */         }
/* 438 */         bhj_numOutputRows1.add(1);
/* 439 */
/* 440 */         // generate join key for stream side
/* 441 */
/* 442 */         boolean bhj_isNull267 = scan_isNull;
/* 443 */         long bhj_value267 = -1L;
/* 444 */         if (!scan_isNull) {
/* 445 */           bhj_value267 = (long) scan_value;
/* 446 */         }
/* 447 */         // find matches from HashedRelation
/* 448 */         UnsafeRow bhj_matched2 = bhj_isNull267 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value267);
/* 449 */         boolean bhj_exists1 = false;
/* 450 */         if (bhj_matched2 != null) {
/* 451 */           bhj_exists1 = true;
/* 452 */         }
/* 453 */         bhj_numOutputRows2.add(1);
/* 454 */
/* 455 */         boolean filter_value22 = true;
/* 456 */
/* 457 */         if (!bhj_exists) {
/* 458 */           filter_value22 = bhj_exists1;
/* 459 */         }
/* 460 */         if (!filter_value22) continue;
/* 461 */
/* 462 */         filter_numOutputRows1.add(1);
/* 463 */
/* 464 */         // generate join key for stream side
/* 465 */
/* 466 */         boolean bhj_isNull413 = false;
/* 467 */         long bhj_value413 = -1L;
/* 468 */         if (!false) {
/* 469 */           bhj_value413 = (long) scan_value4;
/* 470 */         }
/* 471 */         // find matches from HashedRelation
/* 472 */         UnsafeRow bhj_matched3 = bhj_isNull413 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value413);
/* 473 */         if (bhj_matched3 == null) continue;
/* 474 */
/* 475 */         bhj_numOutputRows3.add(1);
/* 476 */
/* 477 */         // generate join key for stream side
/* 478 */
/* 479 */         boolean bhj_isNull421 = false;
/* 480 */         long bhj_value421 = -1L;
/* 481 */         if (!false) {
/* 482 */           bhj_value421 = (long) scan_value2;
/* 483 */         }
/* 484 */         // find matches from HashedRelation
/* 485 */         UnsafeRow bhj_matched4 = bhj_isNull421 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value421);
/* 486 */         if (bhj_matched4 == null) continue;
/* 487 */
/* 488 */         bhj_numOutputRows4.add(1);
/* 489 */
/* 490 */         boolean bhj_isNull416 = bhj_matched3.isNullAt(1);
/* 491 */         UTF8String bhj_value416 = bhj_isNull416 ? null : (bhj_matched3.getUTF8String(1));
/* 492 */         boolean bhj_isNull424 = bhj_matched4.isNullAt(1);
/* 493 */         UTF8String bhj_value424 = bhj_isNull424 ? null : (bhj_matched4.getUTF8String(1));
/* 494 */         boolean bhj_isNull425 = bhj_matched4.isNullAt(2);
/* 495 */         UTF8String bhj_value425 = bhj_isNull425 ? null : (bhj_matched4.getUTF8String(2));
/* 496 */         boolean bhj_isNull426 = bhj_matched4.isNullAt(3);
/* 497 */         int bhj_value426 = bhj_isNull426 ? -1 : (bhj_matched4.getInt(3));
/* 498 */         boolean bhj_isNull427 = bhj_matched4.isNullAt(4);
/* 499 */         int bhj_value427 = bhj_isNull427 ? -1 : (bhj_matched4.getInt(4));
/* 500 */         boolean bhj_isNull428 = bhj_matched4.isNullAt(5);
/* 501 */         int bhj_value428 = bhj_isNull428 ? -1 : (bhj_matched4.getInt(5));
/* 502 */
/* 503 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 504 */
/* 505 */         UnsafeRow agg_fastAggBuffer = null;
/* 506 */
/* 507 */         if (true) {
/* 508 */           if (!bhj_isNull416 && !bhj_isNull424 && !bhj_isNull425 && !bhj_isNull426 && !bhj_isNull427 && !bhj_isNull428) {
/* 509 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 510 */               bhj_value416, bhj_value424, bhj_value425, bhj_value426, bhj_value427, bhj_value428);
/* 511 */           }
/* 512 */         }
/* 513 */
/* 514 */         if (agg_fastAggBuffer == null) {
/* 515 */           // generate grouping key
/* 516 */           agg_holder.reset();
/* 517 */
/* 518 */           agg_rowWriter.zeroOutNullBytes();
/* 519 */
/* 520 */           if (bhj_isNull416) {
/* 521 */             agg_rowWriter.setNullAt(0);
/* 522 */           } else {
/* 523 */             agg_rowWriter.write(0, bhj_value416);
/* 524 */           }
/* 525 */
/* 526 */           if (bhj_isNull424) {
/* 527 */             agg_rowWriter.setNullAt(1);
/* 528 */           } else {
/* 529 */             agg_rowWriter.write(1, bhj_value424);
/* 530 */           }
/* 531 */
/* 532 */           if (bhj_isNull425) {
/* 533 */             agg_rowWriter.setNullAt(2);
/* 534 */           } else {
/* 535 */             agg_rowWriter.write(2, bhj_value425);
/* 536 */           }
/* 537 */
/* 538 */           if (bhj_isNull426) {
/* 539 */             agg_rowWriter.setNullAt(3);
/* 540 */           } else {
/* 541 */             agg_rowWriter.write(3, bhj_value426);
/* 542 */           }
/* 543 */
/* 544 */           if (bhj_isNull427) {
/* 545 */             agg_rowWriter.setNullAt(4);
/* 546 */           } else {
/* 547 */             agg_rowWriter.write(4, bhj_value427);
/* 548 */           }
/* 549 */
/* 550 */           if (bhj_isNull428) {
/* 551 */             agg_rowWriter.setNullAt(5);
/* 552 */           } else {
/* 553 */             agg_rowWriter.write(5, bhj_value428);
/* 554 */           }
/* 555 */           agg_result6.setTotalSize(agg_holder.totalSize());
/* 556 */           agg_value45 = 42;
/* 557 */
/* 558 */           if (!bhj_isNull416) {
/* 559 */             agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value416.getBaseObject(), bhj_value416.getBaseOffset(), bhj_value416.numBytes(), agg_value45);
/* 560 */           }
/* 561 */
/* 562 */           if (!bhj_isNull424) {
/* 563 */             agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value424.getBaseObject(), bhj_value424.getBaseOffset(), bhj_value424.numBytes(), agg_value45);
/* 564 */           }
/* 565 */
/* 566 */           if (!bhj_isNull425) {
/* 567 */             agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value425.getBaseObject(), bhj_value425.getBaseOffset(), bhj_value425.numBytes(), agg_value45);
/* 568 */           }
/* 569 */
/* 570 */           if (!bhj_isNull426) {
/* 571 */             agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value426, agg_value45);
/* 572 */           }
/* 573 */
/* 574 */           if (!bhj_isNull427) {
/* 575 */             agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value427, agg_value45);
/* 576 */           }
/* 577 */
/* 578 */           if (!bhj_isNull428) {
/* 579 */             agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value428, agg_value45);
/* 580 */           }
/* 581 */           if (true) {
/* 582 */             // try to get the buffer from hash map
/* 583 */             agg_unsafeRowAggBuffer =
/* 584 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value45);
/* 585 */           }
/* 586 */           if (agg_unsafeRowAggBuffer == null) {
/* 587 */             if (agg_sorter == null) {
/* 588 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 589 */             } else {
/* 590 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 591 */             }
/* 592 */
/* 593 */             // the hash map had be spilled, it should have enough memory now,
/* 594 */             // try  to allocate buffer again.
/* 595 */             agg_unsafeRowAggBuffer =
/* 596 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value45);
/* 597 */             if (agg_unsafeRowAggBuffer == null) {
/* 598 */               // failed to allocate the first page
/* 599 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 600 */             }
/* 601 */           }
/* 602 */         }
/* 603 */
/* 604 */         if (agg_fastAggBuffer != null) {
/* 605 */           // update fast row
/* 606 */
/* 607 */           // common sub-expressions
/* 608 */           boolean agg_isNull102 = bhj_isNull426;
/* 609 */           long agg_value117 = -1L;
/* 610 */           if (!bhj_isNull426) {
/* 611 */             agg_value117 = (long) bhj_value426;
/* 612 */           }
/* 613 */           boolean agg_isNull104 = bhj_isNull427;
/* 614 */           long agg_value119 = -1L;
/* 615 */           if (!bhj_isNull427) {
/* 616 */             agg_value119 = (long) bhj_value427;
/* 617 */           }
/* 618 */           boolean agg_isNull106 = bhj_isNull428;
/* 619 */           long agg_value121 = -1L;
/* 620 */           if (!bhj_isNull428) {
/* 621 */             agg_value121 = (long) bhj_value428;
/* 622 */           }
/* 623 */           boolean agg_isNull108 = false;
/* 624 */           double agg_value123 = -1.0;
/* 625 */           if (!false) {
/* 626 */             agg_value123 = (double) 0;
/* 627 */           }
/* 628 */           // evaluate aggregate function
/* 629 */           boolean agg_isNull110 = false;
/* 630 */
/* 631 */           long agg_value126 = agg_fastAggBuffer.getLong(0);
/* 632 */
/* 633 */           long agg_value125 = -1L;
/* 634 */           agg_value125 = agg_value126 + 1L;
/* 635 */           boolean agg_isNull114 = agg_fastAggBuffer.isNullAt(1);
/* 636 */           int agg_value129 = agg_isNull114 ? -1 : (agg_fastAggBuffer.getInt(1));
/* 637 */           boolean agg_isNull113 = agg_isNull114;
/* 638 */           int agg_value128 = agg_value129;
/* 639 */
/* 640 */           if (!bhj_isNull426 && (agg_isNull113 ||
/* 641 */               agg_value128 > bhj_value426)) {
/* 642 */             agg_isNull113 = false;
/* 643 */             agg_value128 = bhj_value426;
/* 644 */           }
/* 645 */           boolean agg_isNull117 = agg_fastAggBuffer.isNullAt(2);
/* 646 */           int agg_value132 = agg_isNull117 ? -1 : (agg_fastAggBuffer.getInt(2));
/* 647 */           boolean agg_isNull116 = agg_isNull117;
/* 648 */           int agg_value131 = agg_value132;
/* 649 */
/* 650 */           if (!bhj_isNull426 && (agg_isNull116 ||
/* 651 */               bhj_value426 > agg_value131)) {
/* 652 */             agg_isNull116 = false;
/* 653 */             agg_value131 = bhj_value426;
/* 654 */           }
/* 655 */           boolean agg_isNull119 = true;
/* 656 */           double agg_value134 = -1.0;
/* 657 */
/* 658 */           boolean agg_isNull120 = agg_fastAggBuffer.isNullAt(3);
/* 659 */           double agg_value135 = agg_isNull120 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 660 */           if (!agg_isNull120) {
/* 661 */             boolean agg_isNull122 = agg_isNull102;
/* 662 */             double agg_value137 = -1.0;
/* 663 */             if (!agg_isNull102) {
/* 664 */               agg_value137 = (double) agg_value117;
/* 665 */             }
/* 666 */             boolean agg_isNull121 = agg_isNull122;
/* 667 */             double agg_value136 = agg_value137;
/* 668 */             if (agg_isNull121) {
/* 669 */               if (!agg_isNull108) {
/* 670 */                 agg_isNull121 = false;
/* 671 */                 agg_value136 = agg_value123;
/* 672 */               }
/* 673 */             }
/* 674 */
/* 675 */             agg_isNull119 = false; // resultCode could change nullability.
/* 676 */             agg_value134 = agg_value135 + agg_value136;
/* 677 */
/* 678 */           }
/* 679 */           boolean agg_isNull123 = false;
/* 680 */           long agg_value138 = -1L;
/* 681 */           if (!false && agg_isNull102) {
/* 682 */             boolean agg_isNull125 = agg_fastAggBuffer.isNullAt(4);
/* 683 */             long agg_value140 = agg_isNull125 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 684 */             agg_isNull123 = agg_isNull125;
/* 685 */             agg_value138 = agg_value140;
/* 686 */           } else {
/* 687 */             boolean agg_isNull126 = true;
/* 688 */             long agg_value141 = -1L;
/* 689 */
/* 690 */             boolean agg_isNull127 = agg_fastAggBuffer.isNullAt(4);
/* 691 */             long agg_value142 = agg_isNull127 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 692 */             if (!agg_isNull127) {
/* 693 */               agg_isNull126 = false; // resultCode could change nullability.
/* 694 */               agg_value141 = agg_value142 + 1L;
/* 695 */
/* 696 */             }
/* 697 */             agg_isNull123 = agg_isNull126;
/* 698 */             agg_value138 = agg_value141;
/* 699 */           }
/* 700 */           boolean agg_isNull129 = false;
/* 701 */
/* 702 */           long agg_value145 = agg_fastAggBuffer.getLong(5);
/* 703 */
/* 704 */           long agg_value144 = -1L;
/* 705 */           agg_value144 = agg_value145 + 1L;
/* 706 */           boolean agg_isNull133 = agg_fastAggBuffer.isNullAt(6);
/* 707 */           int agg_value148 = agg_isNull133 ? -1 : (agg_fastAggBuffer.getInt(6));
/* 708 */           boolean agg_isNull132 = agg_isNull133;
/* 709 */           int agg_value147 = agg_value148;
/* 710 */
/* 711 */           if (!bhj_isNull427 && (agg_isNull132 ||
/* 712 */               agg_value147 > bhj_value427)) {
/* 713 */             agg_isNull132 = false;
/* 714 */             agg_value147 = bhj_value427;
/* 715 */           }
/* 716 */           boolean agg_isNull136 = agg_fastAggBuffer.isNullAt(7);
/* 717 */           int agg_value151 = agg_isNull136 ? -1 : (agg_fastAggBuffer.getInt(7));
/* 718 */           boolean agg_isNull135 = agg_isNull136;
/* 719 */           int agg_value150 = agg_value151;
/* 720 */
/* 721 */           if (!bhj_isNull427 && (agg_isNull135 ||
/* 722 */               bhj_value427 > agg_value150)) {
/* 723 */             agg_isNull135 = false;
/* 724 */             agg_value150 = bhj_value427;
/* 725 */           }
/* 726 */           boolean agg_isNull138 = true;
/* 727 */           double agg_value153 = -1.0;
/* 728 */
/* 729 */           boolean agg_isNull139 = agg_fastAggBuffer.isNullAt(8);
/* 730 */           double agg_value154 = agg_isNull139 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 731 */           if (!agg_isNull139) {
/* 732 */             boolean agg_isNull141 = agg_isNull104;
/* 733 */             double agg_value156 = -1.0;
/* 734 */             if (!agg_isNull104) {
/* 735 */               agg_value156 = (double) agg_value119;
/* 736 */             }
/* 737 */             boolean agg_isNull140 = agg_isNull141;
/* 738 */             double agg_value155 = agg_value156;
/* 739 */             if (agg_isNull140) {
/* 740 */               if (!agg_isNull108) {
/* 741 */                 agg_isNull140 = false;
/* 742 */                 agg_value155 = agg_value123;
/* 743 */               }
/* 744 */             }
/* 745 */
/* 746 */             agg_isNull138 = false; // resultCode could change nullability.
/* 747 */             agg_value153 = agg_value154 + agg_value155;
/* 748 */
/* 749 */           }
/* 750 */           boolean agg_isNull142 = false;
/* 751 */           long agg_value157 = -1L;
/* 752 */           if (!false && agg_isNull104) {
/* 753 */             boolean agg_isNull144 = agg_fastAggBuffer.isNullAt(9);
/* 754 */             long agg_value159 = agg_isNull144 ? -1L : (agg_fastAggBuffer.getLong(9));
/* 755 */             agg_isNull142 = agg_isNull144;
/* 756 */             agg_value157 = agg_value159;
/* 757 */           } else {
/* 758 */             boolean agg_isNull145 = true;
/* 759 */             long agg_value160 = -1L;
/* 760 */
/* 761 */             boolean agg_isNull146 = agg_fastAggBuffer.isNullAt(9);
/* 762 */             long agg_value161 = agg_isNull146 ? -1L : (agg_fastAggBuffer.getLong(9));
/* 763 */             if (!agg_isNull146) {
/* 764 */               agg_isNull145 = false; // resultCode could change nullability.
/* 765 */               agg_value160 = agg_value161 + 1L;
/* 766 */
/* 767 */             }
/* 768 */             agg_isNull142 = agg_isNull145;
/* 769 */             agg_value157 = agg_value160;
/* 770 */           }
/* 771 */           boolean agg_isNull148 = false;
/* 772 */
/* 773 */           long agg_value164 = agg_fastAggBuffer.getLong(10);
/* 774 */
/* 775 */           long agg_value163 = -1L;
/* 776 */           agg_value163 = agg_value164 + 1L;
/* 777 */           boolean agg_isNull152 = agg_fastAggBuffer.isNullAt(11);
/* 778 */           int agg_value167 = agg_isNull152 ? -1 : (agg_fastAggBuffer.getInt(11));
/* 779 */           boolean agg_isNull151 = agg_isNull152;
/* 780 */           int agg_value166 = agg_value167;
/* 781 */
/* 782 */           if (!bhj_isNull428 && (agg_isNull151 ||
/* 783 */               agg_value166 > bhj_value428)) {
/* 784 */             agg_isNull151 = false;
/* 785 */             agg_value166 = bhj_value428;
/* 786 */           }
/* 787 */           boolean agg_isNull155 = agg_fastAggBuffer.isNullAt(12);
/* 788 */           int agg_value170 = agg_isNull155 ? -1 : (agg_fastAggBuffer.getInt(12));
/* 789 */           boolean agg_isNull154 = agg_isNull155;
/* 790 */           int agg_value169 = agg_value170;
/* 791 */
/* 792 */           if (!bhj_isNull428 && (agg_isNull154 ||
/* 793 */               bhj_value428 > agg_value169)) {
/* 794 */             agg_isNull154 = false;
/* 795 */             agg_value169 = bhj_value428;
/* 796 */           }
/* 797 */           boolean agg_isNull157 = true;
/* 798 */           double agg_value172 = -1.0;
/* 799 */
/* 800 */           boolean agg_isNull158 = agg_fastAggBuffer.isNullAt(13);
/* 801 */           double agg_value173 = agg_isNull158 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 802 */           if (!agg_isNull158) {
/* 803 */             boolean agg_isNull160 = agg_isNull106;
/* 804 */             double agg_value175 = -1.0;
/* 805 */             if (!agg_isNull106) {
/* 806 */               agg_value175 = (double) agg_value121;
/* 807 */             }
/* 808 */             boolean agg_isNull159 = agg_isNull160;
/* 809 */             double agg_value174 = agg_value175;
/* 810 */             if (agg_isNull159) {
/* 811 */               if (!agg_isNull108) {
/* 812 */                 agg_isNull159 = false;
/* 813 */                 agg_value174 = agg_value123;
/* 814 */               }
/* 815 */             }
/* 816 */
/* 817 */             agg_isNull157 = false; // resultCode could change nullability.
/* 818 */             agg_value172 = agg_value173 + agg_value174;
/* 819 */
/* 820 */           }
/* 821 */           boolean agg_isNull161 = false;
/* 822 */           long agg_value176 = -1L;
/* 823 */           if (!false && agg_isNull106) {
/* 824 */             boolean agg_isNull163 = agg_fastAggBuffer.isNullAt(14);
/* 825 */             long agg_value178 = agg_isNull163 ? -1L : (agg_fastAggBuffer.getLong(14));
/* 826 */             agg_isNull161 = agg_isNull163;
/* 827 */             agg_value176 = agg_value178;
/* 828 */           } else {
/* 829 */             boolean agg_isNull164 = true;
/* 830 */             long agg_value179 = -1L;
/* 831 */
/* 832 */             boolean agg_isNull165 = agg_fastAggBuffer.isNullAt(14);
/* 833 */             long agg_value180 = agg_isNull165 ? -1L : (agg_fastAggBuffer.getLong(14));
/* 834 */             if (!agg_isNull165) {
/* 835 */               agg_isNull164 = false; // resultCode could change nullability.
/* 836 */               agg_value179 = agg_value180 + 1L;
/* 837 */
/* 838 */             }
/* 839 */             agg_isNull161 = agg_isNull164;
/* 840 */             agg_value176 = agg_value179;
/* 841 */           }
/* 842 */           // update fast row
/* 843 */           agg_fastAggBuffer.setLong(0, agg_value125);
/* 844 */
/* 845 */           if (!agg_isNull113) {
/* 846 */             agg_fastAggBuffer.setInt(1, agg_value128);
/* 847 */           } else {
/* 848 */             agg_fastAggBuffer.setNullAt(1);
/* 849 */           }
/* 850 */
/* 851 */           if (!agg_isNull116) {
/* 852 */             agg_fastAggBuffer.setInt(2, agg_value131);
/* 853 */           } else {
/* 854 */             agg_fastAggBuffer.setNullAt(2);
/* 855 */           }
/* 856 */
/* 857 */           if (!agg_isNull119) {
/* 858 */             agg_fastAggBuffer.setDouble(3, agg_value134);
/* 859 */           } else {
/* 860 */             agg_fastAggBuffer.setNullAt(3);
/* 861 */           }
/* 862 */
/* 863 */           if (!agg_isNull123) {
/* 864 */             agg_fastAggBuffer.setLong(4, agg_value138);
/* 865 */           } else {
/* 866 */             agg_fastAggBuffer.setNullAt(4);
/* 867 */           }
/* 868 */
/* 869 */           agg_fastAggBuffer.setLong(5, agg_value144);
/* 870 */
/* 871 */           if (!agg_isNull132) {
/* 872 */             agg_fastAggBuffer.setInt(6, agg_value147);
/* 873 */           } else {
/* 874 */             agg_fastAggBuffer.setNullAt(6);
/* 875 */           }
/* 876 */
/* 877 */           if (!agg_isNull135) {
/* 878 */             agg_fastAggBuffer.setInt(7, agg_value150);
/* 879 */           } else {
/* 880 */             agg_fastAggBuffer.setNullAt(7);
/* 881 */           }
/* 882 */
/* 883 */           if (!agg_isNull138) {
/* 884 */             agg_fastAggBuffer.setDouble(8, agg_value153);
/* 885 */           } else {
/* 886 */             agg_fastAggBuffer.setNullAt(8);
/* 887 */           }
/* 888 */
/* 889 */           if (!agg_isNull142) {
/* 890 */             agg_fastAggBuffer.setLong(9, agg_value157);
/* 891 */           } else {
/* 892 */             agg_fastAggBuffer.setNullAt(9);
/* 893 */           }
/* 894 */
/* 895 */           agg_fastAggBuffer.setLong(10, agg_value163);
/* 896 */
/* 897 */           if (!agg_isNull151) {
/* 898 */             agg_fastAggBuffer.setInt(11, agg_value166);
/* 899 */           } else {
/* 900 */             agg_fastAggBuffer.setNullAt(11);
/* 901 */           }
/* 902 */
/* 903 */           if (!agg_isNull154) {
/* 904 */             agg_fastAggBuffer.setInt(12, agg_value169);
/* 905 */           } else {
/* 906 */             agg_fastAggBuffer.setNullAt(12);
/* 907 */           }
/* 908 */
/* 909 */           if (!agg_isNull157) {
/* 910 */             agg_fastAggBuffer.setDouble(13, agg_value172);
/* 911 */           } else {
/* 912 */             agg_fastAggBuffer.setNullAt(13);
/* 913 */           }
/* 914 */
/* 915 */           if (!agg_isNull161) {
/* 916 */             agg_fastAggBuffer.setLong(14, agg_value176);
/* 917 */           } else {
/* 918 */             agg_fastAggBuffer.setNullAt(14);
/* 919 */           }
/* 920 */
/* 921 */         } else {
/* 922 */           // update unsafe row
/* 923 */
/* 924 */           // common sub-expressions
/* 925 */           boolean agg_isNull37 = bhj_isNull426;
/* 926 */           long agg_value52 = -1L;
/* 927 */           if (!bhj_isNull426) {
/* 928 */             agg_value52 = (long) bhj_value426;
/* 929 */           }
/* 930 */           boolean agg_isNull39 = bhj_isNull427;
/* 931 */           long agg_value54 = -1L;
/* 932 */           if (!bhj_isNull427) {
/* 933 */             agg_value54 = (long) bhj_value427;
/* 934 */           }
/* 935 */           boolean agg_isNull41 = bhj_isNull428;
/* 936 */           long agg_value56 = -1L;
/* 937 */           if (!bhj_isNull428) {
/* 938 */             agg_value56 = (long) bhj_value428;
/* 939 */           }
/* 940 */           boolean agg_isNull43 = false;
/* 941 */           double agg_value58 = -1.0;
/* 942 */           if (!false) {
/* 943 */             agg_value58 = (double) 0;
/* 944 */           }
/* 945 */           // evaluate aggregate function
/* 946 */           boolean agg_isNull45 = false;
/* 947 */
/* 948 */           long agg_value61 = agg_unsafeRowAggBuffer.getLong(0);
/* 949 */
/* 950 */           long agg_value60 = -1L;
/* 951 */           agg_value60 = agg_value61 + 1L;
/* 952 */           boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 953 */           int agg_value64 = agg_isNull49 ? -1 : (agg_unsafeRowAggBuffer.getInt(1));
/* 954 */           boolean agg_isNull48 = agg_isNull49;
/* 955 */           int agg_value63 = agg_value64;
/* 956 */
/* 957 */           if (!bhj_isNull426 && (agg_isNull48 ||
/* 958 */               agg_value63 > bhj_value426)) {
/* 959 */             agg_isNull48 = false;
/* 960 */             agg_value63 = bhj_value426;
/* 961 */           }
/* 962 */           boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 963 */           int agg_value67 = agg_isNull52 ? -1 : (agg_unsafeRowAggBuffer.getInt(2));
/* 964 */           boolean agg_isNull51 = agg_isNull52;
/* 965 */           int agg_value66 = agg_value67;
/* 966 */
/* 967 */           if (!bhj_isNull426 && (agg_isNull51 ||
/* 968 */               bhj_value426 > agg_value66)) {
/* 969 */             agg_isNull51 = false;
/* 970 */             agg_value66 = bhj_value426;
/* 971 */           }
/* 972 */           boolean agg_isNull54 = true;
/* 973 */           double agg_value69 = -1.0;
/* 974 */
/* 975 */           boolean agg_isNull55 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 976 */           double agg_value70 = agg_isNull55 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 977 */           if (!agg_isNull55) {
/* 978 */             boolean agg_isNull57 = agg_isNull37;
/* 979 */             double agg_value72 = -1.0;
/* 980 */             if (!agg_isNull37) {
/* 981 */               agg_value72 = (double) agg_value52;
/* 982 */             }
/* 983 */             boolean agg_isNull56 = agg_isNull57;
/* 984 */             double agg_value71 = agg_value72;
/* 985 */             if (agg_isNull56) {
/* 986 */               if (!agg_isNull43) {
/* 987 */                 agg_isNull56 = false;
/* 988 */                 agg_value71 = agg_value58;
/* 989 */               }
/* 990 */             }
/* 991 */
/* 992 */             agg_isNull54 = false; // resultCode could change nullability.
/* 993 */             agg_value69 = agg_value70 + agg_value71;
/* 994 */
/* 995 */           }
/* 996 */           boolean agg_isNull58 = false;
/* 997 */           long agg_value73 = -1L;
/* 998 */           if (!false && agg_isNull37) {
/* 999 */             boolean agg_isNull60 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1000 */             long agg_value75 = agg_isNull60 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 1001 */             agg_isNull58 = agg_isNull60;
/* 1002 */             agg_value73 = agg_value75;
/* 1003 */           } else {
/* 1004 */             boolean agg_isNull61 = true;
/* 1005 */             long agg_value76 = -1L;
/* 1006 */
/* 1007 */             boolean agg_isNull62 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1008 */             long agg_value77 = agg_isNull62 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 1009 */             if (!agg_isNull62) {
/* 1010 */               agg_isNull61 = false; // resultCode could change nullability.
/* 1011 */               agg_value76 = agg_value77 + 1L;
/* 1012 */
/* 1013 */             }
/* 1014 */             agg_isNull58 = agg_isNull61;
/* 1015 */             agg_value73 = agg_value76;
/* 1016 */           }
/* 1017 */           boolean agg_isNull64 = false;
/* 1018 */
/* 1019 */           long agg_value80 = agg_unsafeRowAggBuffer.getLong(5);
/* 1020 */
/* 1021 */           long agg_value79 = -1L;
/* 1022 */           agg_value79 = agg_value80 + 1L;
/* 1023 */           boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1024 */           int agg_value83 = agg_isNull68 ? -1 : (agg_unsafeRowAggBuffer.getInt(6));
/* 1025 */           boolean agg_isNull67 = agg_isNull68;
/* 1026 */           int agg_value82 = agg_value83;
/* 1027 */
/* 1028 */           if (!bhj_isNull427 && (agg_isNull67 ||
/* 1029 */               agg_value82 > bhj_value427)) {
/* 1030 */             agg_isNull67 = false;
/* 1031 */             agg_value82 = bhj_value427;
/* 1032 */           }
/* 1033 */           boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 1034 */           int agg_value86 = agg_isNull71 ? -1 : (agg_unsafeRowAggBuffer.getInt(7));
/* 1035 */           boolean agg_isNull70 = agg_isNull71;
/* 1036 */           int agg_value85 = agg_value86;
/* 1037 */
/* 1038 */           if (!bhj_isNull427 && (agg_isNull70 ||
/* 1039 */               bhj_value427 > agg_value85)) {
/* 1040 */             agg_isNull70 = false;
/* 1041 */             agg_value85 = bhj_value427;
/* 1042 */           }
/* 1043 */           boolean agg_isNull73 = true;
/* 1044 */           double agg_value88 = -1.0;
/* 1045 */
/* 1046 */           boolean agg_isNull74 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 1047 */           double agg_value89 = agg_isNull74 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 1048 */           if (!agg_isNull74) {
/* 1049 */             boolean agg_isNull76 = agg_isNull39;
/* 1050 */             double agg_value91 = -1.0;
/* 1051 */             if (!agg_isNull39) {
/* 1052 */               agg_value91 = (double) agg_value54;
/* 1053 */             }
/* 1054 */             boolean agg_isNull75 = agg_isNull76;
/* 1055 */             double agg_value90 = agg_value91;
/* 1056 */             if (agg_isNull75) {
/* 1057 */               if (!agg_isNull43) {
/* 1058 */                 agg_isNull75 = false;
/* 1059 */                 agg_value90 = agg_value58;
/* 1060 */               }
/* 1061 */             }
/* 1062 */
/* 1063 */             agg_isNull73 = false; // resultCode could change nullability.
/* 1064 */             agg_value88 = agg_value89 + agg_value90;
/* 1065 */
/* 1066 */           }
/* 1067 */           boolean agg_isNull77 = false;
/* 1068 */           long agg_value92 = -1L;
/* 1069 */           if (!false && agg_isNull39) {
/* 1070 */             boolean agg_isNull79 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 1071 */             long agg_value94 = agg_isNull79 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 1072 */             agg_isNull77 = agg_isNull79;
/* 1073 */             agg_value92 = agg_value94;
/* 1074 */           } else {
/* 1075 */             boolean agg_isNull80 = true;
/* 1076 */             long agg_value95 = -1L;
/* 1077 */
/* 1078 */             boolean agg_isNull81 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 1079 */             long agg_value96 = agg_isNull81 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 1080 */             if (!agg_isNull81) {
/* 1081 */               agg_isNull80 = false; // resultCode could change nullability.
/* 1082 */               agg_value95 = agg_value96 + 1L;
/* 1083 */
/* 1084 */             }
/* 1085 */             agg_isNull77 = agg_isNull80;
/* 1086 */             agg_value92 = agg_value95;
/* 1087 */           }
/* 1088 */           boolean agg_isNull83 = false;
/* 1089 */
/* 1090 */           long agg_value99 = agg_unsafeRowAggBuffer.getLong(10);
/* 1091 */
/* 1092 */           long agg_value98 = -1L;
/* 1093 */           agg_value98 = agg_value99 + 1L;
/* 1094 */           boolean agg_isNull87 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 1095 */           int agg_value102 = agg_isNull87 ? -1 : (agg_unsafeRowAggBuffer.getInt(11));
/* 1096 */           boolean agg_isNull86 = agg_isNull87;
/* 1097 */           int agg_value101 = agg_value102;
/* 1098 */
/* 1099 */           if (!bhj_isNull428 && (agg_isNull86 ||
/* 1100 */               agg_value101 > bhj_value428)) {
/* 1101 */             agg_isNull86 = false;
/* 1102 */             agg_value101 = bhj_value428;
/* 1103 */           }
/* 1104 */           boolean agg_isNull90 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 1105 */           int agg_value105 = agg_isNull90 ? -1 : (agg_unsafeRowAggBuffer.getInt(12));
/* 1106 */           boolean agg_isNull89 = agg_isNull90;
/* 1107 */           int agg_value104 = agg_value105;
/* 1108 */
/* 1109 */           if (!bhj_isNull428 && (agg_isNull89 ||
/* 1110 */               bhj_value428 > agg_value104)) {
/* 1111 */             agg_isNull89 = false;
/* 1112 */             agg_value104 = bhj_value428;
/* 1113 */           }
/* 1114 */           boolean agg_isNull92 = true;
/* 1115 */           double agg_value107 = -1.0;
/* 1116 */
/* 1117 */           boolean agg_isNull93 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 1118 */           double agg_value108 = agg_isNull93 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 1119 */           if (!agg_isNull93) {
/* 1120 */             boolean agg_isNull95 = agg_isNull41;
/* 1121 */             double agg_value110 = -1.0;
/* 1122 */             if (!agg_isNull41) {
/* 1123 */               agg_value110 = (double) agg_value56;
/* 1124 */             }
/* 1125 */             boolean agg_isNull94 = agg_isNull95;
/* 1126 */             double agg_value109 = agg_value110;
/* 1127 */             if (agg_isNull94) {
/* 1128 */               if (!agg_isNull43) {
/* 1129 */                 agg_isNull94 = false;
/* 1130 */                 agg_value109 = agg_value58;
/* 1131 */               }
/* 1132 */             }
/* 1133 */
/* 1134 */             agg_isNull92 = false; // resultCode could change nullability.
/* 1135 */             agg_value107 = agg_value108 + agg_value109;
/* 1136 */
/* 1137 */           }
/* 1138 */           boolean agg_isNull96 = false;
/* 1139 */           long agg_value111 = -1L;
/* 1140 */           if (!false && agg_isNull41) {
/* 1141 */             boolean agg_isNull98 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 1142 */             long agg_value113 = agg_isNull98 ? -1L : (agg_unsafeRowAggBuffer.getLong(14));
/* 1143 */             agg_isNull96 = agg_isNull98;
/* 1144 */             agg_value111 = agg_value113;
/* 1145 */           } else {
/* 1146 */             boolean agg_isNull99 = true;
/* 1147 */             long agg_value114 = -1L;
/* 1148 */
/* 1149 */             boolean agg_isNull100 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 1150 */             long agg_value115 = agg_isNull100 ? -1L : (agg_unsafeRowAggBuffer.getLong(14));
/* 1151 */             if (!agg_isNull100) {
/* 1152 */               agg_isNull99 = false; // resultCode could change nullability.
/* 1153 */               agg_value114 = agg_value115 + 1L;
/* 1154 */
/* 1155 */             }
/* 1156 */             agg_isNull96 = agg_isNull99;
/* 1157 */             agg_value111 = agg_value114;
/* 1158 */           }
/* 1159 */           // update unsafe row buffer
/* 1160 */           agg_unsafeRowAggBuffer.setLong(0, agg_value60);
/* 1161 */
/* 1162 */           if (!agg_isNull48) {
/* 1163 */             agg_unsafeRowAggBuffer.setInt(1, agg_value63);
/* 1164 */           } else {
/* 1165 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 1166 */           }
/* 1167 */
/* 1168 */           if (!agg_isNull51) {
/* 1169 */             agg_unsafeRowAggBuffer.setInt(2, agg_value66);
/* 1170 */           } else {
/* 1171 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 1172 */           }
/* 1173 */
/* 1174 */           if (!agg_isNull54) {
/* 1175 */             agg_unsafeRowAggBuffer.setDouble(3, agg_value69);
/* 1176 */           } else {
/* 1177 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 1178 */           }
/* 1179 */
/* 1180 */           if (!agg_isNull58) {
/* 1181 */             agg_unsafeRowAggBuffer.setLong(4, agg_value73);
/* 1182 */           } else {
/* 1183 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 1184 */           }
/* 1185 */
/* 1186 */           agg_unsafeRowAggBuffer.setLong(5, agg_value79);
/* 1187 */
/* 1188 */           if (!agg_isNull67) {
/* 1189 */             agg_unsafeRowAggBuffer.setInt(6, agg_value82);
/* 1190 */           } else {
/* 1191 */             agg_unsafeRowAggBuffer.setNullAt(6);
/* 1192 */           }
/* 1193 */
/* 1194 */           if (!agg_isNull70) {
/* 1195 */             agg_unsafeRowAggBuffer.setInt(7, agg_value85);
/* 1196 */           } else {
/* 1197 */             agg_unsafeRowAggBuffer.setNullAt(7);
/* 1198 */           }
/* 1199 */
/* 1200 */           if (!agg_isNull73) {
/* 1201 */             agg_unsafeRowAggBuffer.setDouble(8, agg_value88);
/* 1202 */           } else {
/* 1203 */             agg_unsafeRowAggBuffer.setNullAt(8);
/* 1204 */           }
/* 1205 */
/* 1206 */           if (!agg_isNull77) {
/* 1207 */             agg_unsafeRowAggBuffer.setLong(9, agg_value92);
/* 1208 */           } else {
/* 1209 */             agg_unsafeRowAggBuffer.setNullAt(9);
/* 1210 */           }
/* 1211 */
/* 1212 */           agg_unsafeRowAggBuffer.setLong(10, agg_value98);
/* 1213 */
/* 1214 */           if (!agg_isNull86) {
/* 1215 */             agg_unsafeRowAggBuffer.setInt(11, agg_value101);
/* 1216 */           } else {
/* 1217 */             agg_unsafeRowAggBuffer.setNullAt(11);
/* 1218 */           }
/* 1219 */
/* 1220 */           if (!agg_isNull89) {
/* 1221 */             agg_unsafeRowAggBuffer.setInt(12, agg_value104);
/* 1222 */           } else {
/* 1223 */             agg_unsafeRowAggBuffer.setNullAt(12);
/* 1224 */           }
/* 1225 */
/* 1226 */           if (!agg_isNull92) {
/* 1227 */             agg_unsafeRowAggBuffer.setDouble(13, agg_value107);
/* 1228 */           } else {
/* 1229 */             agg_unsafeRowAggBuffer.setNullAt(13);
/* 1230 */           }
/* 1231 */
/* 1232 */           if (!agg_isNull96) {
/* 1233 */             agg_unsafeRowAggBuffer.setLong(14, agg_value111);
/* 1234 */           } else {
/* 1235 */             agg_unsafeRowAggBuffer.setNullAt(14);
/* 1236 */           }
/* 1237 */
/* 1238 */         }
/* 1239 */         if (shouldStop()) return;
/* 1240 */       }
/* 1241 */       scan_batch = null;
/* 1242 */       scan_nextBatch();
/* 1243 */     }
/* 1244 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1245 */     scan_scanTime1 = 0;
/* 1246 */
/* 1247 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1248 */
/* 1249 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1250 */   }
/* 1251 */
/* 1252 */   private void wholestagecodegen_init_5() {
/* 1253 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 1254 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 1255 */
/* 1256 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 1257 */     bhj_result4 = new UnsafeRow(8);
/* 1258 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 96);
/* 1259 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 8);
/* 1260 */     project_result3 = new UnsafeRow(6);
/* 1261 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 1262 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 1263 */     agg_result6 = new UnsafeRow(6);
/* 1264 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 96);
/* 1265 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 1266 */
/* 1267 */   }
/* 1268 */
/* 1269 */   private void wholestagecodegen_init_2() {
/* 1270 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1271 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1272 */
/* 1273 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 1274 */     bhj_result = new UnsafeRow(18);
/* 1275 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 288);
/* 1276 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 18);
/* 1277 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 1278 */
/* 1279 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1280 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1281 */
/* 1282 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 1283 */     bhj_result1 = new UnsafeRow(19);
/* 1284 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 288);
/* 1285 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 19);
/* 1286 */
/* 1287 */   }
/* 1288 */
/* 1289 */   private void wholestagecodegen_init_1() {
/* 1290 */     scan_colInstance13 = null;
/* 1291 */     scan_colInstance14 = null;
/* 1292 */     scan_colInstance15 = null;
/* 1293 */     scan_colInstance16 = null;
/* 1294 */     scan_colInstance17 = null;
/* 1295 */     scan_result = new UnsafeRow(18);
/* 1296 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 288);
/* 1297 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 18);
/* 1298 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 1299 */     filter_result = new UnsafeRow(18);
/* 1300 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 1301 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 18);
/* 1302 */     project_result = new UnsafeRow(18);
/* 1303 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 1304 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 18);
/* 1305 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 1306 */
/* 1307 */   }
/* 1308 */
/* 1309 */   private void wholestagecodegen_init_4() {
/* 1310 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 1311 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 1312 */
/* 1313 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 1314 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 1315 */
/* 1316 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 1317 */     bhj_result3 = new UnsafeRow(4);
/* 1318 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 32);
/* 1319 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 4);
/* 1320 */     project_result2 = new UnsafeRow(2);
/* 1321 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 1322 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 2);
/* 1323 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 1324 */
/* 1325 */   }
/* 1326 */
/* 1327 */   private void wholestagecodegen_init_6() {
/* 1328 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1329 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 1330 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 1331 */
/* 1332 */   }
/* 1333 */
/* 1334 */   protected void processNext() throws java.io.IOException {
/* 1335 */     if (!agg_initAgg) {
/* 1336 */       agg_initAgg = true;
/* 1337 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1338 */       agg_doAggregateWithKeys();
/* 1339 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1340 */     }
/* 1341 */
/* 1342 */     // output the result
/* 1343 */
/* 1344 */     while (agg_fastHashMapIter.next()) {
/* 1345 */       wholestagecodegen_numOutputRows.add(1);
/* 1346 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1347 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1348 */
/* 1349 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1350 */
/* 1351 */       append(agg_resultRow);
/* 1352 */
/* 1353 */       if (shouldStop()) return;
/* 1354 */     }
/* 1355 */     agg_fastHashMap.close();
/* 1356 */
/* 1357 */     while (agg_mapIter.next()) {
/* 1358 */       wholestagecodegen_numOutputRows.add(1);
/* 1359 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1360 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1361 */
/* 1362 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1363 */
/* 1364 */       append(agg_resultRow);
/* 1365 */
/* 1366 */       if (shouldStop()) return;
/* 1367 */     }
/* 1368 */
/* 1369 */     agg_mapIter.close();
/* 1370 */     if (agg_sorter == null) {
/* 1371 */       agg_hashMap.free();
/* 1372 */     }
/* 1373 */   }
/* 1374 */ }
