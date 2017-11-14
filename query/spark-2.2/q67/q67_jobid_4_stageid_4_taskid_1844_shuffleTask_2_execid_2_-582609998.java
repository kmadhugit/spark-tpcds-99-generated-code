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
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
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
/* 067 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 068 */   private UnsafeRow expand_result;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 071 */   private UnsafeRow agg_result9;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 074 */   private int agg_value20;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 076 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 078 */
/* 079 */   public GeneratedIterator(Object[] references) {
/* 080 */     this.references = references;
/* 081 */   }
/* 082 */
/* 083 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 084 */     partitionIndex = index;
/* 085 */     this.inputs = inputs;
/* 086 */     wholestagecodegen_init_0();
/* 087 */     wholestagecodegen_init_1();
/* 088 */     wholestagecodegen_init_2();
/* 089 */     wholestagecodegen_init_3();
/* 090 */     wholestagecodegen_init_4();
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   private void wholestagecodegen_init_0() {
/* 095 */     agg_initAgg = false;
/* 096 */
/* 097 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 098 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 099 */
/* 100 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 101 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 102 */     scan_input = inputs[0];
/* 103 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 104 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 105 */     scan_scanTime1 = 0;
/* 106 */     scan_batch = null;
/* 107 */     scan_batchIdx = 0;
/* 108 */     scan_colInstance0 = null;
/* 109 */     scan_colInstance1 = null;
/* 110 */     scan_colInstance2 = null;
/* 111 */     scan_colInstance3 = null;
/* 112 */     scan_colInstance4 = null;
/* 113 */     scan_result = new UnsafeRow(5);
/* 114 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 115 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 116 */
/* 117 */   }
/* 118 */
/* 119 */   private void wholestagecodegen_init_3() {
/* 120 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 121 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[20];
/* 122 */
/* 123 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 124 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 125 */
/* 126 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 127 */     bhj_result2 = new UnsafeRow(12);
/* 128 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 160);
/* 129 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 12);
/* 130 */     project_result3 = new UnsafeRow(18);
/* 131 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 320);
/* 132 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 18);
/* 133 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 134 */
/* 135 */   }
/* 136 */
/* 137 */   private void scan_nextBatch() throws java.io.IOException {
/* 138 */     long getBatchStart = System.nanoTime();
/* 139 */     if (scan_input.hasNext()) {
/* 140 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 141 */       scan_numOutputRows.add(scan_batch.numRows());
/* 142 */       scan_batchIdx = 0;
/* 143 */       scan_colInstance0 = scan_batch.column(0);
/* 144 */       scan_colInstance1 = scan_batch.column(1);
/* 145 */       scan_colInstance2 = scan_batch.column(2);
/* 146 */       scan_colInstance3 = scan_batch.column(3);
/* 147 */       scan_colInstance4 = scan_batch.column(4);
/* 148 */
/* 149 */     }
/* 150 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 151 */   }
/* 152 */
/* 153 */   public class agg_FastHashMap {
/* 154 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 155 */     private int[] buckets;
/* 156 */     private int capacity = 1 << 16;
/* 157 */     private double loadFactor = 0.5;
/* 158 */     private int numBuckets = (int) (capacity / loadFactor);
/* 159 */     private int maxSteps = 2;
/* 160 */     private int numRows = 0;
/* 161 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 162 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 163 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 164 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 165 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 166 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 167 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 168 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.StringType)
/* 169 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 170 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 171 */     private Object emptyVBase;
/* 172 */     private long emptyVOff;
/* 173 */     private int emptyVLen;
/* 174 */     private boolean isBatchFull = false;
/* 175 */
/* 176 */     public agg_FastHashMap(
/* 177 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 178 */       InternalRow emptyAggregationBuffer) {
/* 179 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 180 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 181 */
/* 182 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 183 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 184 */
/* 185 */       emptyVBase = emptyBuffer;
/* 186 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 187 */       emptyVLen = emptyBuffer.length;
/* 188 */
/* 189 */       buckets = new int[numBuckets];
/* 190 */       java.util.Arrays.fill(buckets, -1);
/* 191 */     }
/* 192 */
/* 193 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5, int agg_key6, UTF8String agg_key7, int agg_key8) {
/* 194 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8);
/* 195 */       int step = 0;
/* 196 */       int idx = (int) h & (numBuckets - 1);
/* 197 */       while (step < maxSteps) {
/* 198 */         // Return bucket index if it's either an empty slot or already contains the key
/* 199 */         if (buckets[idx] == -1) {
/* 200 */           if (numRows < capacity && !isBatchFull) {
/* 201 */             // creating the unsafe for new entry
/* 202 */             UnsafeRow agg_result = new UnsafeRow(9);
/* 203 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 204 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 205 */               160);
/* 206 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 207 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 208 */               agg_holder,
/* 209 */               9);
/* 210 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 211 */             agg_rowWriter.zeroOutNullBytes();
/* 212 */             agg_rowWriter.write(0, agg_key);
/* 213 */             agg_rowWriter.write(1, agg_key1);
/* 214 */             agg_rowWriter.write(2, agg_key2);
/* 215 */             agg_rowWriter.write(3, agg_key3);
/* 216 */             agg_rowWriter.write(4, agg_key4);
/* 217 */             agg_rowWriter.write(5, agg_key5);
/* 218 */             agg_rowWriter.write(6, agg_key6);
/* 219 */             agg_rowWriter.write(7, agg_key7);
/* 220 */             agg_rowWriter.write(8, agg_key8);
/* 221 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 222 */             Object kbase = agg_result.getBaseObject();
/* 223 */             long koff = agg_result.getBaseOffset();
/* 224 */             int klen = agg_result.getSizeInBytes();
/* 225 */
/* 226 */             UnsafeRow vRow
/* 227 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 228 */             if (vRow == null) {
/* 229 */               isBatchFull = true;
/* 230 */             } else {
/* 231 */               buckets[idx] = numRows++;
/* 232 */             }
/* 233 */             return vRow;
/* 234 */           } else {
/* 235 */             // No more space
/* 236 */             return null;
/* 237 */           }
/* 238 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8)) {
/* 239 */           return batch.getValueRow(buckets[idx]);
/* 240 */         }
/* 241 */         idx = (idx + 1) & (numBuckets - 1);
/* 242 */         step++;
/* 243 */       }
/* 244 */       // Didn't find it
/* 245 */       return null;
/* 246 */     }
/* 247 */
/* 248 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5, int agg_key6, UTF8String agg_key7, int agg_key8) {
/* 249 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 250 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getInt(4) == agg_key4) && (row.getInt(5) == agg_key5) && (row.getInt(6) == agg_key6) && (row.getUTF8String(7).equals(agg_key7)) && (row.getInt(8) == agg_key8);
/* 251 */     }
/* 252 */
/* 253 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, int agg_key4, int agg_key5, int agg_key6, UTF8String agg_key7, int agg_key8) {
/* 254 */       long agg_hash = 0;
/* 255 */
/* 256 */       int agg_result = 0;
/* 257 */       byte[] agg_bytes = agg_key.getBytes();
/* 258 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 259 */         int agg_hash1 = agg_bytes[i];
/* 260 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 261 */       }
/* 262 */
/* 263 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 264 */
/* 265 */       int agg_result1 = 0;
/* 266 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 267 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 268 */         int agg_hash2 = agg_bytes1[i];
/* 269 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 270 */       }
/* 271 */
/* 272 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 273 */
/* 274 */       int agg_result2 = 0;
/* 275 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 276 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 277 */         int agg_hash3 = agg_bytes2[i];
/* 278 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 279 */       }
/* 280 */
/* 281 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 282 */
/* 283 */       int agg_result3 = 0;
/* 284 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 285 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 286 */         int agg_hash4 = agg_bytes3[i];
/* 287 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 288 */       }
/* 289 */
/* 290 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 291 */
/* 292 */       int agg_result4 = agg_key4;
/* 293 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 294 */
/* 295 */       int agg_result5 = agg_key5;
/* 296 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 297 */
/* 298 */       int agg_result6 = agg_key6;
/* 299 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 300 */
/* 301 */       int agg_result7 = 0;
/* 302 */       byte[] agg_bytes4 = agg_key7.getBytes();
/* 303 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 304 */         int agg_hash5 = agg_bytes4[i];
/* 305 */         agg_result7 = (agg_result7 ^ (0x9e3779b9)) + agg_hash5 + (agg_result7 << 6) + (agg_result7 >>> 2);
/* 306 */       }
/* 307 */
/* 308 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 309 */
/* 310 */       int agg_result8 = agg_key8;
/* 311 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result8 + (agg_hash << 6) + (agg_hash >>> 2);
/* 312 */
/* 313 */       return agg_hash;
/* 314 */     }
/* 315 */
/* 316 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 317 */       return batch.rowIterator();
/* 318 */     }
/* 319 */
/* 320 */     public void close() {
/* 321 */       batch.close();
/* 322 */     }
/* 323 */
/* 324 */   }
/* 325 */
/* 326 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 327 */     agg_hashMap = agg_plan.createHashMap();
/* 328 */
/* 329 */     if (scan_batch == null) {
/* 330 */       scan_nextBatch();
/* 331 */     }
/* 332 */     while (scan_batch != null) {
/* 333 */       int scan_numRows = scan_batch.numRows();
/* 334 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 335 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 336 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 337 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 338 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 339 */
/* 340 */         if (!(!(scan_isNull1))) continue;
/* 341 */
/* 342 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 343 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 344 */
/* 345 */         if (!(!(scan_isNull))) continue;
/* 346 */
/* 347 */         filter_numOutputRows.add(1);
/* 348 */
/* 349 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 350 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 351 */
/* 352 */         // generate join key for stream side
/* 353 */
/* 354 */         boolean bhj_isNull = scan_isNull4;
/* 355 */         long bhj_value = -1L;
/* 356 */         if (!scan_isNull4) {
/* 357 */           bhj_value = (long) scan_value4;
/* 358 */         }
/* 359 */         // find matches from HashedRelation
/* 360 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 361 */         if (bhj_matched == null) continue;
/* 362 */
/* 363 */         bhj_numOutputRows.add(1);
/* 364 */
/* 365 */         // generate join key for stream side
/* 366 */
/* 367 */         boolean bhj_isNull15 = false;
/* 368 */         long bhj_value15 = -1L;
/* 369 */         if (!false) {
/* 370 */           bhj_value15 = (long) scan_value1;
/* 371 */         }
/* 372 */         // find matches from HashedRelation
/* 373 */         UnsafeRow bhj_matched1 = bhj_isNull15 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value15);
/* 374 */         if (bhj_matched1 == null) continue;
/* 375 */
/* 376 */         bhj_numOutputRows1.add(1);
/* 377 */
/* 378 */         // generate join key for stream side
/* 379 */
/* 380 */         boolean bhj_isNull28 = false;
/* 381 */         long bhj_value28 = -1L;
/* 382 */         if (!false) {
/* 383 */           bhj_value28 = (long) scan_value;
/* 384 */         }
/* 385 */         // find matches from HashedRelation
/* 386 */         UnsafeRow bhj_matched2 = bhj_isNull28 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value28);
/* 387 */         if (bhj_matched2 == null) continue;
/* 388 */
/* 389 */         bhj_numOutputRows2.add(1);
/* 390 */
/* 391 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 392 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 393 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 394 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 395 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 396 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 397 */         boolean bhj_isNull18 = bhj_matched1.isNullAt(1);
/* 398 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched1.getUTF8String(1));
/* 399 */         boolean bhj_isNull31 = bhj_matched2.isNullAt(1);
/* 400 */         UTF8String bhj_value31 = bhj_isNull31 ? null : (bhj_matched2.getUTF8String(1));
/* 401 */         boolean bhj_isNull32 = bhj_matched2.isNullAt(2);
/* 402 */         UTF8String bhj_value32 = bhj_isNull32 ? null : (bhj_matched2.getUTF8String(2));
/* 403 */         boolean bhj_isNull33 = bhj_matched2.isNullAt(3);
/* 404 */         UTF8String bhj_value33 = bhj_isNull33 ? null : (bhj_matched2.getUTF8String(3));
/* 405 */         boolean bhj_isNull34 = bhj_matched2.isNullAt(4);
/* 406 */         UTF8String bhj_value34 = bhj_isNull34 ? null : (bhj_matched2.getUTF8String(4));
/* 407 */
/* 408 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 409 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 410 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 411 */         double scan_value3 = scan_isNull3 ? -1.0 : (scan_colInstance3.getDouble(scan_rowIdx));
/* 412 */
/* 413 */         boolean expand_isNull2 = true;
/* 414 */         UTF8String expand_value2 = null;
/* 415 */         boolean expand_isNull3 = true;
/* 416 */         UTF8String expand_value3 = null;
/* 417 */         boolean expand_isNull4 = true;
/* 418 */         UTF8String expand_value4 = null;
/* 419 */         boolean expand_isNull5 = true;
/* 420 */         UTF8String expand_value5 = null;
/* 421 */         boolean expand_isNull6 = true;
/* 422 */         int expand_value6 = -1;
/* 423 */         boolean expand_isNull7 = true;
/* 424 */         int expand_value7 = -1;
/* 425 */         boolean expand_isNull8 = true;
/* 426 */         int expand_value8 = -1;
/* 427 */         boolean expand_isNull9 = true;
/* 428 */         UTF8String expand_value9 = null;
/* 429 */         boolean expand_isNull10 = true;
/* 430 */         int expand_value10 = -1;
/* 431 */         for (int expand_i = 0; expand_i < 9; expand_i ++) {
/* 432 */           switch (expand_i) {
/* 433 */           case 0:
/* 434 */             expand_isNull2 = bhj_isNull33;
/* 435 */             expand_value2 = bhj_value33;
/* 436 */
/* 437 */             expand_isNull3 = bhj_isNull32;
/* 438 */             expand_value3 = bhj_value32;
/* 439 */
/* 440 */             expand_isNull4 = bhj_isNull31;
/* 441 */             expand_value4 = bhj_value31;
/* 442 */
/* 443 */             expand_isNull5 = bhj_isNull34;
/* 444 */             expand_value5 = bhj_value34;
/* 445 */
/* 446 */             expand_isNull6 = bhj_isNull3;
/* 447 */             expand_value6 = bhj_value3;
/* 448 */
/* 449 */             expand_isNull7 = bhj_isNull5;
/* 450 */             expand_value7 = bhj_value5;
/* 451 */
/* 452 */             expand_isNull8 = bhj_isNull4;
/* 453 */             expand_value8 = bhj_value4;
/* 454 */
/* 455 */             expand_isNull9 = bhj_isNull18;
/* 456 */             expand_value9 = bhj_value18;
/* 457 */
/* 458 */             expand_isNull10 = false;
/* 459 */             expand_value10 = 0;
/* 460 */             break;
/* 461 */
/* 462 */           case 1:
/* 463 */             expand_isNull2 = bhj_isNull33;
/* 464 */             expand_value2 = bhj_value33;
/* 465 */
/* 466 */             expand_isNull3 = bhj_isNull32;
/* 467 */             expand_value3 = bhj_value32;
/* 468 */
/* 469 */             expand_isNull4 = bhj_isNull31;
/* 470 */             expand_value4 = bhj_value31;
/* 471 */
/* 472 */             expand_isNull5 = bhj_isNull34;
/* 473 */             expand_value5 = bhj_value34;
/* 474 */
/* 475 */             expand_isNull6 = bhj_isNull3;
/* 476 */             expand_value6 = bhj_value3;
/* 477 */
/* 478 */             expand_isNull7 = bhj_isNull5;
/* 479 */             expand_value7 = bhj_value5;
/* 480 */
/* 481 */             expand_isNull8 = bhj_isNull4;
/* 482 */             expand_value8 = bhj_value4;
/* 483 */
/* 484 */             final UTF8String expand_value27 = null;
/* 485 */             expand_isNull9 = true;
/* 486 */             expand_value9 = expand_value27;
/* 487 */
/* 488 */             expand_isNull10 = false;
/* 489 */             expand_value10 = 1;
/* 490 */             break;
/* 491 */
/* 492 */           case 2:
/* 493 */             expand_isNull2 = bhj_isNull33;
/* 494 */             expand_value2 = bhj_value33;
/* 495 */
/* 496 */             expand_isNull3 = bhj_isNull32;
/* 497 */             expand_value3 = bhj_value32;
/* 498 */
/* 499 */             expand_isNull4 = bhj_isNull31;
/* 500 */             expand_value4 = bhj_value31;
/* 501 */
/* 502 */             expand_isNull5 = bhj_isNull34;
/* 503 */             expand_value5 = bhj_value34;
/* 504 */
/* 505 */             expand_isNull6 = bhj_isNull3;
/* 506 */             expand_value6 = bhj_value3;
/* 507 */
/* 508 */             expand_isNull7 = bhj_isNull5;
/* 509 */             expand_value7 = bhj_value5;
/* 510 */
/* 511 */             final int expand_value35 = -1;
/* 512 */             expand_isNull8 = true;
/* 513 */             expand_value8 = expand_value35;
/* 514 */
/* 515 */             final UTF8String expand_value36 = null;
/* 516 */             expand_isNull9 = true;
/* 517 */             expand_value9 = expand_value36;
/* 518 */
/* 519 */             expand_isNull10 = false;
/* 520 */             expand_value10 = 3;
/* 521 */             break;
/* 522 */
/* 523 */           case 3:
/* 524 */             expand_isNull2 = bhj_isNull33;
/* 525 */             expand_value2 = bhj_value33;
/* 526 */
/* 527 */             expand_isNull3 = bhj_isNull32;
/* 528 */             expand_value3 = bhj_value32;
/* 529 */
/* 530 */             expand_isNull4 = bhj_isNull31;
/* 531 */             expand_value4 = bhj_value31;
/* 532 */
/* 533 */             expand_isNull5 = bhj_isNull34;
/* 534 */             expand_value5 = bhj_value34;
/* 535 */
/* 536 */             expand_isNull6 = bhj_isNull3;
/* 537 */             expand_value6 = bhj_value3;
/* 538 */
/* 539 */             final int expand_value43 = -1;
/* 540 */             expand_isNull7 = true;
/* 541 */             expand_value7 = expand_value43;
/* 542 */
/* 543 */             final int expand_value44 = -1;
/* 544 */             expand_isNull8 = true;
/* 545 */             expand_value8 = expand_value44;
/* 546 */
/* 547 */             final UTF8String expand_value45 = null;
/* 548 */             expand_isNull9 = true;
/* 549 */             expand_value9 = expand_value45;
/* 550 */
/* 551 */             expand_isNull10 = false;
/* 552 */             expand_value10 = 7;
/* 553 */             break;
/* 554 */
/* 555 */           case 4:
/* 556 */             expand_isNull2 = bhj_isNull33;
/* 557 */             expand_value2 = bhj_value33;
/* 558 */
/* 559 */             expand_isNull3 = bhj_isNull32;
/* 560 */             expand_value3 = bhj_value32;
/* 561 */
/* 562 */             expand_isNull4 = bhj_isNull31;
/* 563 */             expand_value4 = bhj_value31;
/* 564 */
/* 565 */             expand_isNull5 = bhj_isNull34;
/* 566 */             expand_value5 = bhj_value34;
/* 567 */
/* 568 */             final int expand_value51 = -1;
/* 569 */             expand_isNull6 = true;
/* 570 */             expand_value6 = expand_value51;
/* 571 */
/* 572 */             final int expand_value52 = -1;
/* 573 */             expand_isNull7 = true;
/* 574 */             expand_value7 = expand_value52;
/* 575 */
/* 576 */             final int expand_value53 = -1;
/* 577 */             expand_isNull8 = true;
/* 578 */             expand_value8 = expand_value53;
/* 579 */
/* 580 */             final UTF8String expand_value54 = null;
/* 581 */             expand_isNull9 = true;
/* 582 */             expand_value9 = expand_value54;
/* 583 */
/* 584 */             expand_isNull10 = false;
/* 585 */             expand_value10 = 15;
/* 586 */             break;
/* 587 */
/* 588 */           case 5:
/* 589 */             expand_isNull2 = bhj_isNull33;
/* 590 */             expand_value2 = bhj_value33;
/* 591 */
/* 592 */             expand_isNull3 = bhj_isNull32;
/* 593 */             expand_value3 = bhj_value32;
/* 594 */
/* 595 */             expand_isNull4 = bhj_isNull31;
/* 596 */             expand_value4 = bhj_value31;
/* 597 */
/* 598 */             final UTF8String expand_value59 = null;
/* 599 */             expand_isNull5 = true;
/* 600 */             expand_value5 = expand_value59;
/* 601 */
/* 602 */             final int expand_value60 = -1;
/* 603 */             expand_isNull6 = true;
/* 604 */             expand_value6 = expand_value60;
/* 605 */
/* 606 */             final int expand_value61 = -1;
/* 607 */             expand_isNull7 = true;
/* 608 */             expand_value7 = expand_value61;
/* 609 */
/* 610 */             final int expand_value62 = -1;
/* 611 */             expand_isNull8 = true;
/* 612 */             expand_value8 = expand_value62;
/* 613 */
/* 614 */             final UTF8String expand_value63 = null;
/* 615 */             expand_isNull9 = true;
/* 616 */             expand_value9 = expand_value63;
/* 617 */
/* 618 */             expand_isNull10 = false;
/* 619 */             expand_value10 = 31;
/* 620 */             break;
/* 621 */
/* 622 */           case 6:
/* 623 */             expand_isNull2 = bhj_isNull33;
/* 624 */             expand_value2 = bhj_value33;
/* 625 */
/* 626 */             expand_isNull3 = bhj_isNull32;
/* 627 */             expand_value3 = bhj_value32;
/* 628 */
/* 629 */             final UTF8String expand_value67 = null;
/* 630 */             expand_isNull4 = true;
/* 631 */             expand_value4 = expand_value67;
/* 632 */
/* 633 */             final UTF8String expand_value68 = null;
/* 634 */             expand_isNull5 = true;
/* 635 */             expand_value5 = expand_value68;
/* 636 */
/* 637 */             final int expand_value69 = -1;
/* 638 */             expand_isNull6 = true;
/* 639 */             expand_value6 = expand_value69;
/* 640 */
/* 641 */             final int expand_value70 = -1;
/* 642 */             expand_isNull7 = true;
/* 643 */             expand_value7 = expand_value70;
/* 644 */
/* 645 */             final int expand_value71 = -1;
/* 646 */             expand_isNull8 = true;
/* 647 */             expand_value8 = expand_value71;
/* 648 */
/* 649 */             final UTF8String expand_value72 = null;
/* 650 */             expand_isNull9 = true;
/* 651 */             expand_value9 = expand_value72;
/* 652 */
/* 653 */             expand_isNull10 = false;
/* 654 */             expand_value10 = 63;
/* 655 */             break;
/* 656 */
/* 657 */           case 7:
/* 658 */             expand_isNull2 = bhj_isNull33;
/* 659 */             expand_value2 = bhj_value33;
/* 660 */
/* 661 */             final UTF8String expand_value75 = null;
/* 662 */             expand_isNull3 = true;
/* 663 */             expand_value3 = expand_value75;
/* 664 */
/* 665 */             final UTF8String expand_value76 = null;
/* 666 */             expand_isNull4 = true;
/* 667 */             expand_value4 = expand_value76;
/* 668 */
/* 669 */             final UTF8String expand_value77 = null;
/* 670 */             expand_isNull5 = true;
/* 671 */             expand_value5 = expand_value77;
/* 672 */
/* 673 */             final int expand_value78 = -1;
/* 674 */             expand_isNull6 = true;
/* 675 */             expand_value6 = expand_value78;
/* 676 */
/* 677 */             final int expand_value79 = -1;
/* 678 */             expand_isNull7 = true;
/* 679 */             expand_value7 = expand_value79;
/* 680 */
/* 681 */             final int expand_value80 = -1;
/* 682 */             expand_isNull8 = true;
/* 683 */             expand_value8 = expand_value80;
/* 684 */
/* 685 */             final UTF8String expand_value81 = null;
/* 686 */             expand_isNull9 = true;
/* 687 */             expand_value9 = expand_value81;
/* 688 */
/* 689 */             expand_isNull10 = false;
/* 690 */             expand_value10 = 127;
/* 691 */             break;
/* 692 */
/* 693 */           case 8:
/* 694 */             final UTF8String expand_value83 = null;
/* 695 */             expand_isNull2 = true;
/* 696 */             expand_value2 = expand_value83;
/* 697 */
/* 698 */             final UTF8String expand_value84 = null;
/* 699 */             expand_isNull3 = true;
/* 700 */             expand_value3 = expand_value84;
/* 701 */
/* 702 */             final UTF8String expand_value85 = null;
/* 703 */             expand_isNull4 = true;
/* 704 */             expand_value4 = expand_value85;
/* 705 */
/* 706 */             final UTF8String expand_value86 = null;
/* 707 */             expand_isNull5 = true;
/* 708 */             expand_value5 = expand_value86;
/* 709 */
/* 710 */             final int expand_value87 = -1;
/* 711 */             expand_isNull6 = true;
/* 712 */             expand_value6 = expand_value87;
/* 713 */
/* 714 */             final int expand_value88 = -1;
/* 715 */             expand_isNull7 = true;
/* 716 */             expand_value7 = expand_value88;
/* 717 */
/* 718 */             final int expand_value89 = -1;
/* 719 */             expand_isNull8 = true;
/* 720 */             expand_value8 = expand_value89;
/* 721 */
/* 722 */             final UTF8String expand_value90 = null;
/* 723 */             expand_isNull9 = true;
/* 724 */             expand_value9 = expand_value90;
/* 725 */
/* 726 */             expand_isNull10 = false;
/* 727 */             expand_value10 = 255;
/* 728 */             break;
/* 729 */           }
/* 730 */           expand_numOutputRows.add(1);
/* 731 */
/* 732 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 733 */
/* 734 */           UnsafeRow agg_fastAggBuffer = null;
/* 735 */
/* 736 */           if (true) {
/* 737 */             if (!expand_isNull2 && !expand_isNull3 && !expand_isNull4 && !expand_isNull5 && !expand_isNull6 && !expand_isNull7 && !expand_isNull8 && !expand_isNull9 && !expand_isNull10) {
/* 738 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 739 */                 expand_value2, expand_value3, expand_value4, expand_value5, expand_value6, expand_value7, expand_value8, expand_value9, expand_value10);
/* 740 */             }
/* 741 */           }
/* 742 */
/* 743 */           if (agg_fastAggBuffer == null) {
/* 744 */             // generate grouping key
/* 745 */             agg_holder.reset();
/* 746 */
/* 747 */             agg_rowWriter.zeroOutNullBytes();
/* 748 */
/* 749 */             if (expand_isNull2) {
/* 750 */               agg_rowWriter.setNullAt(0);
/* 751 */             } else {
/* 752 */               agg_rowWriter.write(0, expand_value2);
/* 753 */             }
/* 754 */
/* 755 */             if (expand_isNull3) {
/* 756 */               agg_rowWriter.setNullAt(1);
/* 757 */             } else {
/* 758 */               agg_rowWriter.write(1, expand_value3);
/* 759 */             }
/* 760 */
/* 761 */             if (expand_isNull4) {
/* 762 */               agg_rowWriter.setNullAt(2);
/* 763 */             } else {
/* 764 */               agg_rowWriter.write(2, expand_value4);
/* 765 */             }
/* 766 */
/* 767 */             if (expand_isNull5) {
/* 768 */               agg_rowWriter.setNullAt(3);
/* 769 */             } else {
/* 770 */               agg_rowWriter.write(3, expand_value5);
/* 771 */             }
/* 772 */
/* 773 */             if (expand_isNull6) {
/* 774 */               agg_rowWriter.setNullAt(4);
/* 775 */             } else {
/* 776 */               agg_rowWriter.write(4, expand_value6);
/* 777 */             }
/* 778 */
/* 779 */             if (expand_isNull7) {
/* 780 */               agg_rowWriter.setNullAt(5);
/* 781 */             } else {
/* 782 */               agg_rowWriter.write(5, expand_value7);
/* 783 */             }
/* 784 */
/* 785 */             if (expand_isNull8) {
/* 786 */               agg_rowWriter.setNullAt(6);
/* 787 */             } else {
/* 788 */               agg_rowWriter.write(6, expand_value8);
/* 789 */             }
/* 790 */
/* 791 */             if (expand_isNull9) {
/* 792 */               agg_rowWriter.setNullAt(7);
/* 793 */             } else {
/* 794 */               agg_rowWriter.write(7, expand_value9);
/* 795 */             }
/* 796 */
/* 797 */             if (expand_isNull10) {
/* 798 */               agg_rowWriter.setNullAt(8);
/* 799 */             } else {
/* 800 */               agg_rowWriter.write(8, expand_value10);
/* 801 */             }
/* 802 */             agg_result9.setTotalSize(agg_holder.totalSize());
/* 803 */             agg_value20 = 42;
/* 804 */
/* 805 */             if (!expand_isNull2) {
/* 806 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value2.getBaseObject(), expand_value2.getBaseOffset(), expand_value2.numBytes(), agg_value20);
/* 807 */             }
/* 808 */
/* 809 */             if (!expand_isNull3) {
/* 810 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value3.getBaseObject(), expand_value3.getBaseOffset(), expand_value3.numBytes(), agg_value20);
/* 811 */             }
/* 812 */
/* 813 */             if (!expand_isNull4) {
/* 814 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value4.getBaseObject(), expand_value4.getBaseOffset(), expand_value4.numBytes(), agg_value20);
/* 815 */             }
/* 816 */
/* 817 */             if (!expand_isNull5) {
/* 818 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value5.getBaseObject(), expand_value5.getBaseOffset(), expand_value5.numBytes(), agg_value20);
/* 819 */             }
/* 820 */
/* 821 */             if (!expand_isNull6) {
/* 822 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value6, agg_value20);
/* 823 */             }
/* 824 */
/* 825 */             if (!expand_isNull7) {
/* 826 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value7, agg_value20);
/* 827 */             }
/* 828 */
/* 829 */             if (!expand_isNull8) {
/* 830 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value8, agg_value20);
/* 831 */             }
/* 832 */
/* 833 */             if (!expand_isNull9) {
/* 834 */               agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value9.getBaseObject(), expand_value9.getBaseOffset(), expand_value9.numBytes(), agg_value20);
/* 835 */             }
/* 836 */
/* 837 */             agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value10, agg_value20);
/* 838 */             if (true) {
/* 839 */               // try to get the buffer from hash map
/* 840 */               agg_unsafeRowAggBuffer =
/* 841 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result9, agg_value20);
/* 842 */             }
/* 843 */             if (agg_unsafeRowAggBuffer == null) {
/* 844 */               if (agg_sorter == null) {
/* 845 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 846 */               } else {
/* 847 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 848 */               }
/* 849 */
/* 850 */               // the hash map had be spilled, it should have enough memory now,
/* 851 */               // try  to allocate buffer again.
/* 852 */               agg_unsafeRowAggBuffer =
/* 853 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result9, agg_value20);
/* 854 */               if (agg_unsafeRowAggBuffer == null) {
/* 855 */                 // failed to allocate the first page
/* 856 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 857 */               }
/* 858 */             }
/* 859 */           }
/* 860 */
/* 861 */           if (agg_fastAggBuffer != null) {
/* 862 */             // update fast row
/* 863 */
/* 864 */             // common sub-expressions
/* 865 */
/* 866 */             // evaluate aggregate function
/* 867 */             boolean agg_isNull40 = false;
/* 868 */
/* 869 */             boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 870 */             double agg_value43 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 871 */             boolean agg_isNull41 = agg_isNull42;
/* 872 */             double agg_value42 = agg_value43;
/* 873 */             if (agg_isNull41) {
/* 874 */               boolean agg_isNull43 = false;
/* 875 */               double agg_value44 = -1.0;
/* 876 */               if (!false) {
/* 877 */                 agg_value44 = (double) 0;
/* 878 */               }
/* 879 */               if (!agg_isNull43) {
/* 880 */                 agg_isNull41 = false;
/* 881 */                 agg_value42 = agg_value44;
/* 882 */               }
/* 883 */             }
/* 884 */
/* 885 */             boolean agg_isNull46 = true;
/* 886 */             double agg_value47 = -1.0;
/* 887 */
/* 888 */             if (!scan_isNull3) {
/* 889 */               boolean agg_isNull48 = scan_isNull2;
/* 890 */               double agg_value49 = -1.0;
/* 891 */               if (!scan_isNull2) {
/* 892 */                 agg_value49 = (double) scan_value2;
/* 893 */               }
/* 894 */               if (!agg_isNull48) {
/* 895 */                 agg_isNull46 = false; // resultCode could change nullability.
/* 896 */                 agg_value47 = scan_value3 * agg_value49;
/* 897 */
/* 898 */               }
/* 899 */
/* 900 */             }
/* 901 */             boolean agg_isNull45 = agg_isNull46;
/* 902 */             double agg_value46 = agg_value47;
/* 903 */             if (agg_isNull45) {
/* 904 */               if (!false) {
/* 905 */                 agg_isNull45 = false;
/* 906 */                 agg_value46 = 0.0D;
/* 907 */               }
/* 908 */             }
/* 909 */             double agg_value41 = -1.0;
/* 910 */             agg_value41 = agg_value42 + agg_value46;
/* 911 */             // update fast row
/* 912 */             agg_fastAggBuffer.setDouble(0, agg_value41);
/* 913 */
/* 914 */           } else {
/* 915 */             // update unsafe row
/* 916 */
/* 917 */             // common sub-expressions
/* 918 */
/* 919 */             // evaluate aggregate function
/* 920 */             boolean agg_isNull29 = false;
/* 921 */
/* 922 */             boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 923 */             double agg_value32 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 924 */             boolean agg_isNull30 = agg_isNull31;
/* 925 */             double agg_value31 = agg_value32;
/* 926 */             if (agg_isNull30) {
/* 927 */               boolean agg_isNull32 = false;
/* 928 */               double agg_value33 = -1.0;
/* 929 */               if (!false) {
/* 930 */                 agg_value33 = (double) 0;
/* 931 */               }
/* 932 */               if (!agg_isNull32) {
/* 933 */                 agg_isNull30 = false;
/* 934 */                 agg_value31 = agg_value33;
/* 935 */               }
/* 936 */             }
/* 937 */
/* 938 */             boolean agg_isNull35 = true;
/* 939 */             double agg_value36 = -1.0;
/* 940 */
/* 941 */             if (!scan_isNull3) {
/* 942 */               boolean agg_isNull37 = scan_isNull2;
/* 943 */               double agg_value38 = -1.0;
/* 944 */               if (!scan_isNull2) {
/* 945 */                 agg_value38 = (double) scan_value2;
/* 946 */               }
/* 947 */               if (!agg_isNull37) {
/* 948 */                 agg_isNull35 = false; // resultCode could change nullability.
/* 949 */                 agg_value36 = scan_value3 * agg_value38;
/* 950 */
/* 951 */               }
/* 952 */
/* 953 */             }
/* 954 */             boolean agg_isNull34 = agg_isNull35;
/* 955 */             double agg_value35 = agg_value36;
/* 956 */             if (agg_isNull34) {
/* 957 */               if (!false) {
/* 958 */                 agg_isNull34 = false;
/* 959 */                 agg_value35 = 0.0D;
/* 960 */               }
/* 961 */             }
/* 962 */             double agg_value30 = -1.0;
/* 963 */             agg_value30 = agg_value31 + agg_value35;
/* 964 */             // update unsafe row buffer
/* 965 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value30);
/* 966 */
/* 967 */           }
/* 968 */
/* 969 */         }
/* 970 */         // shouldStop check is eliminated
/* 971 */       }
/* 972 */       scan_batchIdx = scan_numRows;
/* 973 */       scan_batch = null;
/* 974 */       scan_nextBatch();
/* 975 */     }
/* 976 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 977 */     scan_scanTime1 = 0;
/* 978 */
/* 979 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 980 */
/* 981 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 982 */   }
/* 983 */
/* 984 */   private void wholestagecodegen_init_2() {
/* 985 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 986 */     project_result1 = new UnsafeRow(7);
/* 987 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 988 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 989 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 990 */
/* 991 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 992 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 993 */
/* 994 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 995 */     bhj_result1 = new UnsafeRow(9);
/* 996 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 997 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 998 */     project_result2 = new UnsafeRow(7);
/* 999 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 1000 */
/* 1001 */   }
/* 1002 */
/* 1003 */   private void wholestagecodegen_init_1() {
/* 1004 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 1005 */     filter_result = new UnsafeRow(5);
/* 1006 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 1007 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 1008 */     project_result = new UnsafeRow(5);
/* 1009 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 1010 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 1011 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 1012 */
/* 1013 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1014 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1015 */
/* 1016 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 1017 */     bhj_result = new UnsafeRow(9);
/* 1018 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1019 */
/* 1020 */   }
/* 1021 */
/* 1022 */   private void wholestagecodegen_init_4() {
/* 1023 */     expand_result = new UnsafeRow(11);
/* 1024 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 160);
/* 1025 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 11);
/* 1026 */     agg_result9 = new UnsafeRow(9);
/* 1027 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result9, 160);
/* 1028 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 9);
/* 1029 */
/* 1030 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1031 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 1032 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 1033 */
/* 1034 */   }
/* 1035 */
/* 1036 */   protected void processNext() throws java.io.IOException {
/* 1037 */     if (!agg_initAgg) {
/* 1038 */       agg_initAgg = true;
/* 1039 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1040 */       agg_doAggregateWithKeys();
/* 1041 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1042 */     }
/* 1043 */
/* 1044 */     // output the result
/* 1045 */
/* 1046 */     while (agg_fastHashMapIter.next()) {
/* 1047 */       wholestagecodegen_numOutputRows.add(1);
/* 1048 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1049 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1050 */
/* 1051 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1052 */
/* 1053 */       append(agg_resultRow.copy());
/* 1054 */
/* 1055 */       if (shouldStop()) return;
/* 1056 */     }
/* 1057 */     agg_fastHashMap.close();
/* 1058 */
/* 1059 */     while (agg_mapIter.next()) {
/* 1060 */       wholestagecodegen_numOutputRows.add(1);
/* 1061 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1062 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1063 */
/* 1064 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1065 */
/* 1066 */       append(agg_resultRow.copy());
/* 1067 */
/* 1068 */       if (shouldStop()) return;
/* 1069 */     }
/* 1070 */
/* 1071 */     agg_mapIter.close();
/* 1072 */     if (agg_sorter == null) {
/* 1073 */       agg_hashMap.free();
/* 1074 */     }
/* 1075 */   }
/* 1076 */ }
