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
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private double agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private double agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private double agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private double agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private double agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private double agg_bufValue14;
/* 039 */   private boolean agg_bufIsNull15;
/* 040 */   private double agg_bufValue15;
/* 041 */   private boolean agg_bufIsNull16;
/* 042 */   private double agg_bufValue16;
/* 043 */   private boolean agg_bufIsNull17;
/* 044 */   private double agg_bufValue17;
/* 045 */   private boolean agg_bufIsNull18;
/* 046 */   private double agg_bufValue18;
/* 047 */   private boolean agg_bufIsNull19;
/* 048 */   private double agg_bufValue19;
/* 049 */   private boolean agg_bufIsNull20;
/* 050 */   private double agg_bufValue20;
/* 051 */   private boolean agg_bufIsNull21;
/* 052 */   private double agg_bufValue21;
/* 053 */   private boolean agg_bufIsNull22;
/* 054 */   private double agg_bufValue22;
/* 055 */   private boolean agg_bufIsNull23;
/* 056 */   private double agg_bufValue23;
/* 057 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 058 */   private agg_FastHashMap agg_fastHashMap;
/* 059 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 060 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 061 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 062 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 064 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 065 */   private scala.collection.Iterator scan_input;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 067 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 068 */   private long scan_scanTime1;
/* 069 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 070 */   private int scan_batchIdx;
/* 071 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 072 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 073 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 074 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 075 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 076 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 077 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 078 */   private UnsafeRow scan_result;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 081 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 082 */   private UnsafeRow filter_result;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 085 */   private UnsafeRow project_result;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 088 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 089 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 090 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 091 */   private UnsafeRow bhj_result;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 093 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 094 */   private UnsafeRow project_result1;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 096 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 097 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 098 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 099 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 100 */   private UnsafeRow bhj_result1;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 102 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 103 */   private UnsafeRow project_result2;
/* 104 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 105 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 106 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 107 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 108 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 109 */   private UnsafeRow bhj_result2;
/* 110 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 111 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 112 */   private UnsafeRow project_result3;
/* 113 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 114 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 115 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 116 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 117 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 118 */   private UnsafeRow bhj_result3;
/* 119 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 120 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 121 */   private UnsafeRow project_result4;
/* 122 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 123 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 124 */   private UnsafeRow agg_result7;
/* 125 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 126 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 127 */   private int agg_value62;
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
/* 145 */
/* 146 */   }
/* 147 */
/* 148 */   private void wholestagecodegen_init_0() {
/* 149 */     agg_initAgg = false;
/* 150 */
/* 151 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 152 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 153 */
/* 154 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 155 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 156 */     scan_input = inputs[0];
/* 157 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[34];
/* 158 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[35];
/* 159 */     scan_scanTime1 = 0;
/* 160 */     scan_batch = null;
/* 161 */     scan_batchIdx = 0;
/* 162 */     scan_colInstance0 = null;
/* 163 */     scan_colInstance1 = null;
/* 164 */     scan_colInstance2 = null;
/* 165 */     scan_colInstance3 = null;
/* 166 */     scan_colInstance4 = null;
/* 167 */     scan_colInstance5 = null;
/* 168 */     scan_colInstance6 = null;
/* 169 */     scan_result = new UnsafeRow(7);
/* 170 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 171 */
/* 172 */   }
/* 173 */
/* 174 */   private void wholestagecodegen_init_3() {
/* 175 */     project_result2 = new UnsafeRow(13);
/* 176 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 160);
/* 177 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 13);
/* 178 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[41];
/* 179 */
/* 180 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 181 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 182 */
/* 183 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[42];
/* 184 */     bhj_result2 = new UnsafeRow(14);
/* 185 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 160);
/* 186 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 14);
/* 187 */     project_result3 = new UnsafeRow(12);
/* 188 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 160);
/* 189 */
/* 190 */   }
/* 191 */
/* 192 */   private void scan_nextBatch() throws java.io.IOException {
/* 193 */     long getBatchStart = System.nanoTime();
/* 194 */     if (scan_input.hasNext()) {
/* 195 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 196 */       scan_numOutputRows.add(scan_batch.numRows());
/* 197 */       scan_batchIdx = 0;
/* 198 */       scan_colInstance0 = scan_batch.column(0);
/* 199 */       scan_colInstance1 = scan_batch.column(1);
/* 200 */       scan_colInstance2 = scan_batch.column(2);
/* 201 */       scan_colInstance3 = scan_batch.column(3);
/* 202 */       scan_colInstance4 = scan_batch.column(4);
/* 203 */       scan_colInstance5 = scan_batch.column(5);
/* 204 */       scan_colInstance6 = scan_batch.column(6);
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
/* 218 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 219 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 220 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 221 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 222 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 223 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.StringType)
/* 224 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 225 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 226 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 227 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 228 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 229 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 230 */     .add("((java.lang.String) references[15])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 231 */     .add("((java.lang.String) references[16])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 232 */     .add("((java.lang.String) references[17])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 233 */     .add("((java.lang.String) references[18])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 234 */     .add("((java.lang.String) references[19])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 235 */     .add("((java.lang.String) references[20])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 236 */     .add("((java.lang.String) references[21])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 237 */     .add("((java.lang.String) references[22])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 238 */     .add("((java.lang.String) references[23])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 239 */     .add("((java.lang.String) references[24])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 240 */     .add("((java.lang.String) references[25])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 241 */     .add("((java.lang.String) references[26])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 242 */     .add("((java.lang.String) references[27])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 243 */     .add("((java.lang.String) references[28])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 244 */     .add("((java.lang.String) references[29])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 245 */     .add("((java.lang.String) references[30])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 246 */     .add("((java.lang.String) references[31])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 247 */     .add("((java.lang.String) references[32])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 248 */     .add("((java.lang.String) references[33])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 249 */     private Object emptyVBase;
/* 250 */     private long emptyVOff;
/* 251 */     private int emptyVLen;
/* 252 */     private boolean isBatchFull = false;
/* 253 */
/* 254 */     public agg_FastHashMap(
/* 255 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 256 */       InternalRow emptyAggregationBuffer) {
/* 257 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 258 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 259 */
/* 260 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 261 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 262 */
/* 263 */       emptyVBase = emptyBuffer;
/* 264 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 265 */       emptyVLen = emptyBuffer.length;
/* 266 */
/* 267 */       buckets = new int[numBuckets];
/* 268 */       java.util.Arrays.fill(buckets, -1);
/* 269 */     }
/* 270 */
/* 271 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, int agg_key6) {
/* 272 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6);
/* 273 */       int step = 0;
/* 274 */       int idx = (int) h & (numBuckets - 1);
/* 275 */       while (step < maxSteps) {
/* 276 */         // Return bucket index if it's either an empty slot or already contains the key
/* 277 */         if (buckets[idx] == -1) {
/* 278 */           if (numRows < capacity && !isBatchFull) {
/* 279 */             // creating the unsafe for new entry
/* 280 */             UnsafeRow agg_result = new UnsafeRow(7);
/* 281 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 282 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 283 */               160);
/* 284 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 285 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 286 */               agg_holder,
/* 287 */               7);
/* 288 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 289 */             agg_rowWriter.zeroOutNullBytes();
/* 290 */             agg_rowWriter.write(0, agg_key);
/* 291 */             agg_rowWriter.write(1, agg_key1);
/* 292 */             agg_rowWriter.write(2, agg_key2);
/* 293 */             agg_rowWriter.write(3, agg_key3);
/* 294 */             agg_rowWriter.write(4, agg_key4);
/* 295 */             agg_rowWriter.write(5, agg_key5);
/* 296 */             agg_rowWriter.write(6, agg_key6);
/* 297 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 298 */             Object kbase = agg_result.getBaseObject();
/* 299 */             long koff = agg_result.getBaseOffset();
/* 300 */             int klen = agg_result.getSizeInBytes();
/* 301 */
/* 302 */             UnsafeRow vRow
/* 303 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 304 */             if (vRow == null) {
/* 305 */               isBatchFull = true;
/* 306 */             } else {
/* 307 */               buckets[idx] = numRows++;
/* 308 */             }
/* 309 */             return vRow;
/* 310 */           } else {
/* 311 */             // No more space
/* 312 */             return null;
/* 313 */           }
/* 314 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6)) {
/* 315 */           return batch.getValueRow(buckets[idx]);
/* 316 */         }
/* 317 */         idx = (idx + 1) & (numBuckets - 1);
/* 318 */         step++;
/* 319 */       }
/* 320 */       // Didn't find it
/* 321 */       return null;
/* 322 */     }
/* 323 */
/* 324 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, int agg_key6) {
/* 325 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 326 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getInt(6) == agg_key6);
/* 327 */     }
/* 328 */
/* 329 */     private long hash(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, int agg_key6) {
/* 330 */       long agg_hash = 0;
/* 331 */
/* 332 */       int agg_result = 0;
/* 333 */       byte[] agg_bytes = agg_key.getBytes();
/* 334 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 335 */         int agg_hash1 = agg_bytes[i];
/* 336 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 337 */       }
/* 338 */
/* 339 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 340 */
/* 341 */       int agg_result1 = agg_key1;
/* 342 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 343 */
/* 344 */       int agg_result2 = 0;
/* 345 */       byte[] agg_bytes1 = agg_key2.getBytes();
/* 346 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 347 */         int agg_hash2 = agg_bytes1[i];
/* 348 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash2 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 349 */       }
/* 350 */
/* 351 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 352 */
/* 353 */       int agg_result3 = 0;
/* 354 */       byte[] agg_bytes2 = agg_key3.getBytes();
/* 355 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 356 */         int agg_hash3 = agg_bytes2[i];
/* 357 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash3 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 358 */       }
/* 359 */
/* 360 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 361 */
/* 362 */       int agg_result4 = 0;
/* 363 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 364 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 365 */         int agg_hash4 = agg_bytes3[i];
/* 366 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 367 */       }
/* 368 */
/* 369 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 370 */
/* 371 */       int agg_result5 = 0;
/* 372 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 373 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 374 */         int agg_hash5 = agg_bytes4[i];
/* 375 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 376 */       }
/* 377 */
/* 378 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 379 */
/* 380 */       int agg_result6 = agg_key6;
/* 381 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 382 */
/* 383 */       return agg_hash;
/* 384 */     }
/* 385 */
/* 386 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 387 */       return batch.rowIterator();
/* 388 */     }
/* 389 */
/* 390 */     public void close() {
/* 391 */       batch.close();
/* 392 */     }
/* 393 */
/* 394 */   }
/* 395 */
/* 396 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 397 */     agg_hashMap = agg_plan.createHashMap();
/* 398 */
/* 399 */     if (scan_batch == null) {
/* 400 */       scan_nextBatch();
/* 401 */     }
/* 402 */     while (scan_batch != null) {
/* 403 */       int scan_numRows = scan_batch.numRows();
/* 404 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 405 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 406 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 407 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 408 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 409 */
/* 410 */         if (!(!(scan_isNull2))) continue;
/* 411 */
/* 412 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 413 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 414 */
/* 415 */         if (!(!(scan_isNull))) continue;
/* 416 */
/* 417 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 418 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 419 */
/* 420 */         if (!(!(scan_isNull1))) continue;
/* 421 */
/* 422 */         filter_numOutputRows.add(1);
/* 423 */
/* 424 */         // generate join key for stream side
/* 425 */
/* 426 */         boolean bhj_isNull = false;
/* 427 */         long bhj_value = -1L;
/* 428 */         if (!false) {
/* 429 */           bhj_value = (long) scan_value2;
/* 430 */         }
/* 431 */         // find matches from HashedRelation
/* 432 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 433 */         if (bhj_matched == null) continue;
/* 434 */
/* 435 */         bhj_numOutputRows.add(1);
/* 436 */
/* 437 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 438 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 439 */
/* 440 */         // generate join key for stream side
/* 441 */
/* 442 */         boolean bhj_isNull23 = scan_isNull6;
/* 443 */         long bhj_value23 = -1L;
/* 444 */         if (!scan_isNull6) {
/* 445 */           bhj_value23 = (long) scan_value6;
/* 446 */         }
/* 447 */         // find matches from HashedRelation
/* 448 */         UnsafeRow bhj_matched1 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value23);
/* 449 */         if (bhj_matched1 == null) continue;
/* 450 */
/* 451 */         bhj_numOutputRows1.add(1);
/* 452 */
/* 453 */         // generate join key for stream side
/* 454 */
/* 455 */         boolean bhj_isNull43 = false;
/* 456 */         long bhj_value43 = -1L;
/* 457 */         if (!false) {
/* 458 */           bhj_value43 = (long) scan_value;
/* 459 */         }
/* 460 */         // find matches from HashedRelation
/* 461 */         UnsafeRow bhj_matched2 = bhj_isNull43 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value43);
/* 462 */         if (bhj_matched2 == null) continue;
/* 463 */
/* 464 */         bhj_numOutputRows2.add(1);
/* 465 */
/* 466 */         // generate join key for stream side
/* 467 */
/* 468 */         boolean bhj_isNull60 = false;
/* 469 */         long bhj_value60 = -1L;
/* 470 */         if (!false) {
/* 471 */           bhj_value60 = (long) scan_value1;
/* 472 */         }
/* 473 */         // find matches from HashedRelation
/* 474 */         UnsafeRow bhj_matched3 = bhj_isNull60 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value60);
/* 475 */         if (bhj_matched3 == null) continue;
/* 476 */
/* 477 */         bhj_numOutputRows3.add(1);
/* 478 */
/* 479 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 480 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 481 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 482 */         double scan_value4 = scan_isNull4 ? -1.0 : (scan_colInstance4.getDouble(scan_rowIdx));
/* 483 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 484 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 485 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 486 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 487 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 488 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 489 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 490 */         UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 491 */         boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 492 */         UTF8String bhj_value6 = bhj_isNull6 ? null : (bhj_matched.getUTF8String(4));
/* 493 */         boolean bhj_isNull7 = bhj_matched.isNullAt(5);
/* 494 */         UTF8String bhj_value7 = bhj_isNull7 ? null : (bhj_matched.getUTF8String(5));
/* 495 */         boolean bhj_isNull8 = bhj_matched.isNullAt(6);
/* 496 */         UTF8String bhj_value8 = bhj_isNull8 ? null : (bhj_matched.getUTF8String(6));
/* 497 */         boolean bhj_isNull26 = bhj_matched1.isNullAt(1);
/* 498 */         int bhj_value26 = bhj_isNull26 ? -1 : (bhj_matched1.getInt(1));
/* 499 */         boolean bhj_isNull27 = bhj_matched1.isNullAt(2);
/* 500 */         int bhj_value27 = bhj_isNull27 ? -1 : (bhj_matched1.getInt(2));
/* 501 */
/* 502 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 503 */
/* 504 */         UnsafeRow agg_fastAggBuffer = null;
/* 505 */
/* 506 */         if (true) {
/* 507 */           if (!bhj_isNull3 && !bhj_isNull4 && !bhj_isNull5 && !bhj_isNull6 && !bhj_isNull7 && !bhj_isNull8 && !bhj_isNull26) {
/* 508 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 509 */               bhj_value3, bhj_value4, bhj_value5, bhj_value6, bhj_value7, bhj_value8, bhj_value26);
/* 510 */           }
/* 511 */         }
/* 512 */
/* 513 */         if (agg_fastAggBuffer == null) {
/* 514 */           // generate grouping key
/* 515 */           agg_holder.reset();
/* 516 */
/* 517 */           agg_rowWriter.zeroOutNullBytes();
/* 518 */
/* 519 */           if (bhj_isNull3) {
/* 520 */             agg_rowWriter.setNullAt(0);
/* 521 */           } else {
/* 522 */             agg_rowWriter.write(0, bhj_value3);
/* 523 */           }
/* 524 */
/* 525 */           if (bhj_isNull4) {
/* 526 */             agg_rowWriter.setNullAt(1);
/* 527 */           } else {
/* 528 */             agg_rowWriter.write(1, bhj_value4);
/* 529 */           }
/* 530 */
/* 531 */           if (bhj_isNull5) {
/* 532 */             agg_rowWriter.setNullAt(2);
/* 533 */           } else {
/* 534 */             agg_rowWriter.write(2, bhj_value5);
/* 535 */           }
/* 536 */
/* 537 */           if (bhj_isNull6) {
/* 538 */             agg_rowWriter.setNullAt(3);
/* 539 */           } else {
/* 540 */             agg_rowWriter.write(3, bhj_value6);
/* 541 */           }
/* 542 */
/* 543 */           if (bhj_isNull7) {
/* 544 */             agg_rowWriter.setNullAt(4);
/* 545 */           } else {
/* 546 */             agg_rowWriter.write(4, bhj_value7);
/* 547 */           }
/* 548 */
/* 549 */           if (bhj_isNull8) {
/* 550 */             agg_rowWriter.setNullAt(5);
/* 551 */           } else {
/* 552 */             agg_rowWriter.write(5, bhj_value8);
/* 553 */           }
/* 554 */
/* 555 */           if (bhj_isNull26) {
/* 556 */             agg_rowWriter.setNullAt(6);
/* 557 */           } else {
/* 558 */             agg_rowWriter.write(6, bhj_value26);
/* 559 */           }
/* 560 */           agg_result7.setTotalSize(agg_holder.totalSize());
/* 561 */           agg_value62 = 42;
/* 562 */
/* 563 */           if (!bhj_isNull3) {
/* 564 */             agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value62);
/* 565 */           }
/* 566 */
/* 567 */           if (!bhj_isNull4) {
/* 568 */             agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value4, agg_value62);
/* 569 */           }
/* 570 */
/* 571 */           if (!bhj_isNull5) {
/* 572 */             agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value5.getBaseObject(), bhj_value5.getBaseOffset(), bhj_value5.numBytes(), agg_value62);
/* 573 */           }
/* 574 */
/* 575 */           if (!bhj_isNull6) {
/* 576 */             agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value6.getBaseObject(), bhj_value6.getBaseOffset(), bhj_value6.numBytes(), agg_value62);
/* 577 */           }
/* 578 */
/* 579 */           if (!bhj_isNull7) {
/* 580 */             agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value7.getBaseObject(), bhj_value7.getBaseOffset(), bhj_value7.numBytes(), agg_value62);
/* 581 */           }
/* 582 */
/* 583 */           if (!bhj_isNull8) {
/* 584 */             agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value8.getBaseObject(), bhj_value8.getBaseOffset(), bhj_value8.numBytes(), agg_value62);
/* 585 */           }
/* 586 */
/* 587 */           if (!bhj_isNull26) {
/* 588 */             agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value26, agg_value62);
/* 589 */           }
/* 590 */           if (true) {
/* 591 */             // try to get the buffer from hash map
/* 592 */             agg_unsafeRowAggBuffer =
/* 593 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result7, agg_value62);
/* 594 */           }
/* 595 */           if (agg_unsafeRowAggBuffer == null) {
/* 596 */             if (agg_sorter == null) {
/* 597 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 598 */             } else {
/* 599 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 600 */             }
/* 601 */
/* 602 */             // the hash map had be spilled, it should have enough memory now,
/* 603 */             // try  to allocate buffer again.
/* 604 */             agg_unsafeRowAggBuffer =
/* 605 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result7, agg_value62);
/* 606 */             if (agg_unsafeRowAggBuffer == null) {
/* 607 */               // failed to allocate the first page
/* 608 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 609 */             }
/* 610 */           }
/* 611 */         }
/* 612 */
/* 613 */         if (agg_fastAggBuffer != null) {
/* 614 */           // update fast row
/* 615 */
/* 616 */           // common sub-expressions
/* 617 */           boolean agg_isNull394 = true;
/* 618 */           boolean agg_value418 = false;
/* 619 */
/* 620 */           if (!bhj_isNull27) {
/* 621 */             agg_isNull394 = false; // resultCode could change nullability.
/* 622 */             agg_value418 = bhj_value27 == 8;
/* 623 */
/* 624 */           }
/* 625 */           boolean agg_isNull397 = true;
/* 626 */           boolean agg_value421 = false;
/* 627 */
/* 628 */           if (!bhj_isNull27) {
/* 629 */             agg_isNull397 = false; // resultCode could change nullability.
/* 630 */             agg_value421 = bhj_value27 == 5;
/* 631 */
/* 632 */           }
/* 633 */           boolean agg_isNull400 = true;
/* 634 */           boolean agg_value424 = false;
/* 635 */
/* 636 */           if (!bhj_isNull27) {
/* 637 */             agg_isNull400 = false; // resultCode could change nullability.
/* 638 */             agg_value424 = bhj_value27 == 2;
/* 639 */
/* 640 */           }
/* 641 */           boolean agg_isNull403 = true;
/* 642 */           boolean agg_value427 = false;
/* 643 */
/* 644 */           if (!bhj_isNull27) {
/* 645 */             agg_isNull403 = false; // resultCode could change nullability.
/* 646 */             agg_value427 = bhj_value27 == 9;
/* 647 */
/* 648 */           }
/* 649 */           boolean agg_isNull406 = true;
/* 650 */           boolean agg_value430 = false;
/* 651 */
/* 652 */           if (!bhj_isNull27) {
/* 653 */             agg_isNull406 = false; // resultCode could change nullability.
/* 654 */             agg_value430 = bhj_value27 == 6;
/* 655 */
/* 656 */           }
/* 657 */           boolean agg_isNull409 = true;
/* 658 */           boolean agg_value433 = false;
/* 659 */
/* 660 */           if (!bhj_isNull27) {
/* 661 */             agg_isNull409 = false; // resultCode could change nullability.
/* 662 */             agg_value433 = bhj_value27 == 1;
/* 663 */
/* 664 */           }
/* 665 */           boolean agg_isNull412 = true;
/* 666 */           boolean agg_value436 = false;
/* 667 */
/* 668 */           if (!bhj_isNull27) {
/* 669 */             agg_isNull412 = false; // resultCode could change nullability.
/* 670 */             agg_value436 = bhj_value27 == 7;
/* 671 */
/* 672 */           }
/* 673 */           boolean agg_isNull415 = true;
/* 674 */           boolean agg_value439 = false;
/* 675 */
/* 676 */           if (!bhj_isNull27) {
/* 677 */             agg_isNull415 = false; // resultCode could change nullability.
/* 678 */             agg_value439 = bhj_value27 == 12;
/* 679 */
/* 680 */           }
/* 681 */           boolean agg_isNull418 = true;
/* 682 */           boolean agg_value442 = false;
/* 683 */
/* 684 */           if (!bhj_isNull27) {
/* 685 */             agg_isNull418 = false; // resultCode could change nullability.
/* 686 */             agg_value442 = bhj_value27 == 3;
/* 687 */
/* 688 */           }
/* 689 */           boolean agg_isNull421 = true;
/* 690 */           boolean agg_value445 = false;
/* 691 */
/* 692 */           if (!bhj_isNull27) {
/* 693 */             agg_isNull421 = false; // resultCode could change nullability.
/* 694 */             agg_value445 = bhj_value27 == 11;
/* 695 */
/* 696 */           }
/* 697 */           boolean agg_isNull424 = true;
/* 698 */           boolean agg_value448 = false;
/* 699 */
/* 700 */           if (!bhj_isNull27) {
/* 701 */             agg_isNull424 = false; // resultCode could change nullability.
/* 702 */             agg_value448 = bhj_value27 == 4;
/* 703 */
/* 704 */           }
/* 705 */           boolean agg_isNull427 = true;
/* 706 */           boolean agg_value451 = false;
/* 707 */
/* 708 */           if (!bhj_isNull27) {
/* 709 */             agg_isNull427 = false; // resultCode could change nullability.
/* 710 */             agg_value451 = bhj_value27 == 10;
/* 711 */
/* 712 */           }
/* 713 */           // evaluate aggregate function
/* 714 */           boolean agg_isNull431 = true;
/* 715 */           double agg_value455 = -1.0;
/* 716 */
/* 717 */           boolean agg_isNull433 = agg_fastAggBuffer.isNullAt(0);
/* 718 */           double agg_value457 = agg_isNull433 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 719 */           boolean agg_isNull432 = agg_isNull433;
/* 720 */           double agg_value456 = agg_value457;
/* 721 */           if (agg_isNull432) {
/* 722 */             boolean agg_isNull434 = false;
/* 723 */             double agg_value458 = -1.0;
/* 724 */             if (!false) {
/* 725 */               agg_value458 = (double) 0;
/* 726 */             }
/* 727 */             if (!agg_isNull434) {
/* 728 */               agg_isNull432 = false;
/* 729 */               agg_value456 = agg_value458;
/* 730 */             }
/* 731 */           }
/* 732 */
/* 733 */           boolean agg_isNull436 = true;
/* 734 */           double agg_value460 = -1.0;
/* 735 */
/* 736 */           if (!agg_isNull409 && agg_value433) {
/* 737 */             boolean agg_isNull437 = true;
/* 738 */             double agg_value461 = -1.0;
/* 739 */
/* 740 */             if (!scan_isNull4) {
/* 741 */               boolean agg_isNull439 = scan_isNull3;
/* 742 */               double agg_value463 = -1.0;
/* 743 */               if (!scan_isNull3) {
/* 744 */                 agg_value463 = (double) scan_value3;
/* 745 */               }
/* 746 */               if (!agg_isNull439) {
/* 747 */                 agg_isNull437 = false; // resultCode could change nullability.
/* 748 */                 agg_value461 = scan_value4 * agg_value463;
/* 749 */
/* 750 */               }
/* 751 */
/* 752 */             }
/* 753 */             agg_isNull436 = agg_isNull437;
/* 754 */             agg_value460 = agg_value461;
/* 755 */           }
/* 756 */
/* 757 */           else {
/* 758 */             agg_isNull436 = false;
/* 759 */             agg_value460 = 0.0D;
/* 760 */           }
/* 761 */           if (!agg_isNull436) {
/* 762 */             agg_isNull431 = false; // resultCode could change nullability.
/* 763 */             agg_value455 = agg_value456 + agg_value460;
/* 764 */
/* 765 */           }
/* 766 */           boolean agg_isNull430 = agg_isNull431;
/* 767 */           double agg_value454 = agg_value455;
/* 768 */           if (agg_isNull430) {
/* 769 */             boolean agg_isNull442 = agg_fastAggBuffer.isNullAt(0);
/* 770 */             double agg_value466 = agg_isNull442 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 771 */             if (!agg_isNull442) {
/* 772 */               agg_isNull430 = false;
/* 773 */               agg_value454 = agg_value466;
/* 774 */             }
/* 775 */           }
/* 776 */           boolean agg_isNull444 = true;
/* 777 */           double agg_value468 = -1.0;
/* 778 */
/* 779 */           boolean agg_isNull446 = agg_fastAggBuffer.isNullAt(1);
/* 780 */           double agg_value470 = agg_isNull446 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 781 */           boolean agg_isNull445 = agg_isNull446;
/* 782 */           double agg_value469 = agg_value470;
/* 783 */           if (agg_isNull445) {
/* 784 */             boolean agg_isNull447 = false;
/* 785 */             double agg_value471 = -1.0;
/* 786 */             if (!false) {
/* 787 */               agg_value471 = (double) 0;
/* 788 */             }
/* 789 */             if (!agg_isNull447) {
/* 790 */               agg_isNull445 = false;
/* 791 */               agg_value469 = agg_value471;
/* 792 */             }
/* 793 */           }
/* 794 */
/* 795 */           boolean agg_isNull449 = true;
/* 796 */           double agg_value473 = -1.0;
/* 797 */
/* 798 */           if (!agg_isNull400 && agg_value424) {
/* 799 */             boolean agg_isNull450 = true;
/* 800 */             double agg_value474 = -1.0;
/* 801 */
/* 802 */             if (!scan_isNull4) {
/* 803 */               boolean agg_isNull452 = scan_isNull3;
/* 804 */               double agg_value476 = -1.0;
/* 805 */               if (!scan_isNull3) {
/* 806 */                 agg_value476 = (double) scan_value3;
/* 807 */               }
/* 808 */               if (!agg_isNull452) {
/* 809 */                 agg_isNull450 = false; // resultCode could change nullability.
/* 810 */                 agg_value474 = scan_value4 * agg_value476;
/* 811 */
/* 812 */               }
/* 813 */
/* 814 */             }
/* 815 */             agg_isNull449 = agg_isNull450;
/* 816 */             agg_value473 = agg_value474;
/* 817 */           }
/* 818 */
/* 819 */           else {
/* 820 */             agg_isNull449 = false;
/* 821 */             agg_value473 = 0.0D;
/* 822 */           }
/* 823 */           if (!agg_isNull449) {
/* 824 */             agg_isNull444 = false; // resultCode could change nullability.
/* 825 */             agg_value468 = agg_value469 + agg_value473;
/* 826 */
/* 827 */           }
/* 828 */           boolean agg_isNull443 = agg_isNull444;
/* 829 */           double agg_value467 = agg_value468;
/* 830 */           if (agg_isNull443) {
/* 831 */             boolean agg_isNull455 = agg_fastAggBuffer.isNullAt(1);
/* 832 */             double agg_value479 = agg_isNull455 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 833 */             if (!agg_isNull455) {
/* 834 */               agg_isNull443 = false;
/* 835 */               agg_value467 = agg_value479;
/* 836 */             }
/* 837 */           }
/* 838 */           boolean agg_isNull457 = true;
/* 839 */           double agg_value481 = -1.0;
/* 840 */
/* 841 */           boolean agg_isNull459 = agg_fastAggBuffer.isNullAt(2);
/* 842 */           double agg_value483 = agg_isNull459 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 843 */           boolean agg_isNull458 = agg_isNull459;
/* 844 */           double agg_value482 = agg_value483;
/* 845 */           if (agg_isNull458) {
/* 846 */             boolean agg_isNull460 = false;
/* 847 */             double agg_value484 = -1.0;
/* 848 */             if (!false) {
/* 849 */               agg_value484 = (double) 0;
/* 850 */             }
/* 851 */             if (!agg_isNull460) {
/* 852 */               agg_isNull458 = false;
/* 853 */               agg_value482 = agg_value484;
/* 854 */             }
/* 855 */           }
/* 856 */
/* 857 */           boolean agg_isNull462 = true;
/* 858 */           double agg_value486 = -1.0;
/* 859 */
/* 860 */           if (!agg_isNull418 && agg_value442) {
/* 861 */             boolean agg_isNull463 = true;
/* 862 */             double agg_value487 = -1.0;
/* 863 */
/* 864 */             if (!scan_isNull4) {
/* 865 */               boolean agg_isNull465 = scan_isNull3;
/* 866 */               double agg_value489 = -1.0;
/* 867 */               if (!scan_isNull3) {
/* 868 */                 agg_value489 = (double) scan_value3;
/* 869 */               }
/* 870 */               if (!agg_isNull465) {
/* 871 */                 agg_isNull463 = false; // resultCode could change nullability.
/* 872 */                 agg_value487 = scan_value4 * agg_value489;
/* 873 */
/* 874 */               }
/* 875 */
/* 876 */             }
/* 877 */             agg_isNull462 = agg_isNull463;
/* 878 */             agg_value486 = agg_value487;
/* 879 */           }
/* 880 */
/* 881 */           else {
/* 882 */             agg_isNull462 = false;
/* 883 */             agg_value486 = 0.0D;
/* 884 */           }
/* 885 */           if (!agg_isNull462) {
/* 886 */             agg_isNull457 = false; // resultCode could change nullability.
/* 887 */             agg_value481 = agg_value482 + agg_value486;
/* 888 */
/* 889 */           }
/* 890 */           boolean agg_isNull456 = agg_isNull457;
/* 891 */           double agg_value480 = agg_value481;
/* 892 */           if (agg_isNull456) {
/* 893 */             boolean agg_isNull468 = agg_fastAggBuffer.isNullAt(2);
/* 894 */             double agg_value492 = agg_isNull468 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 895 */             if (!agg_isNull468) {
/* 896 */               agg_isNull456 = false;
/* 897 */               agg_value480 = agg_value492;
/* 898 */             }
/* 899 */           }
/* 900 */           boolean agg_isNull470 = true;
/* 901 */           double agg_value494 = -1.0;
/* 902 */
/* 903 */           boolean agg_isNull472 = agg_fastAggBuffer.isNullAt(3);
/* 904 */           double agg_value496 = agg_isNull472 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 905 */           boolean agg_isNull471 = agg_isNull472;
/* 906 */           double agg_value495 = agg_value496;
/* 907 */           if (agg_isNull471) {
/* 908 */             boolean agg_isNull473 = false;
/* 909 */             double agg_value497 = -1.0;
/* 910 */             if (!false) {
/* 911 */               agg_value497 = (double) 0;
/* 912 */             }
/* 913 */             if (!agg_isNull473) {
/* 914 */               agg_isNull471 = false;
/* 915 */               agg_value495 = agg_value497;
/* 916 */             }
/* 917 */           }
/* 918 */
/* 919 */           boolean agg_isNull475 = true;
/* 920 */           double agg_value499 = -1.0;
/* 921 */
/* 922 */           if (!agg_isNull424 && agg_value448) {
/* 923 */             boolean agg_isNull476 = true;
/* 924 */             double agg_value500 = -1.0;
/* 925 */
/* 926 */             if (!scan_isNull4) {
/* 927 */               boolean agg_isNull478 = scan_isNull3;
/* 928 */               double agg_value502 = -1.0;
/* 929 */               if (!scan_isNull3) {
/* 930 */                 agg_value502 = (double) scan_value3;
/* 931 */               }
/* 932 */               if (!agg_isNull478) {
/* 933 */                 agg_isNull476 = false; // resultCode could change nullability.
/* 934 */                 agg_value500 = scan_value4 * agg_value502;
/* 935 */
/* 936 */               }
/* 937 */
/* 938 */             }
/* 939 */             agg_isNull475 = agg_isNull476;
/* 940 */             agg_value499 = agg_value500;
/* 941 */           }
/* 942 */
/* 943 */           else {
/* 944 */             agg_isNull475 = false;
/* 945 */             agg_value499 = 0.0D;
/* 946 */           }
/* 947 */           if (!agg_isNull475) {
/* 948 */             agg_isNull470 = false; // resultCode could change nullability.
/* 949 */             agg_value494 = agg_value495 + agg_value499;
/* 950 */
/* 951 */           }
/* 952 */           boolean agg_isNull469 = agg_isNull470;
/* 953 */           double agg_value493 = agg_value494;
/* 954 */           if (agg_isNull469) {
/* 955 */             boolean agg_isNull481 = agg_fastAggBuffer.isNullAt(3);
/* 956 */             double agg_value505 = agg_isNull481 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 957 */             if (!agg_isNull481) {
/* 958 */               agg_isNull469 = false;
/* 959 */               agg_value493 = agg_value505;
/* 960 */             }
/* 961 */           }
/* 962 */           boolean agg_isNull483 = true;
/* 963 */           double agg_value507 = -1.0;
/* 964 */
/* 965 */           boolean agg_isNull485 = agg_fastAggBuffer.isNullAt(4);
/* 966 */           double agg_value509 = agg_isNull485 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 967 */           boolean agg_isNull484 = agg_isNull485;
/* 968 */           double agg_value508 = agg_value509;
/* 969 */           if (agg_isNull484) {
/* 970 */             boolean agg_isNull486 = false;
/* 971 */             double agg_value510 = -1.0;
/* 972 */             if (!false) {
/* 973 */               agg_value510 = (double) 0;
/* 974 */             }
/* 975 */             if (!agg_isNull486) {
/* 976 */               agg_isNull484 = false;
/* 977 */               agg_value508 = agg_value510;
/* 978 */             }
/* 979 */           }
/* 980 */
/* 981 */           boolean agg_isNull488 = true;
/* 982 */           double agg_value512 = -1.0;
/* 983 */
/* 984 */           if (!agg_isNull397 && agg_value421) {
/* 985 */             boolean agg_isNull489 = true;
/* 986 */             double agg_value513 = -1.0;
/* 987 */
/* 988 */             if (!scan_isNull4) {
/* 989 */               boolean agg_isNull491 = scan_isNull3;
/* 990 */               double agg_value515 = -1.0;
/* 991 */               if (!scan_isNull3) {
/* 992 */                 agg_value515 = (double) scan_value3;
/* 993 */               }
/* 994 */               if (!agg_isNull491) {
/* 995 */                 agg_isNull489 = false; // resultCode could change nullability.
/* 996 */                 agg_value513 = scan_value4 * agg_value515;
/* 997 */
/* 998 */               }
/* 999 */
/* 1000 */             }
/* 1001 */             agg_isNull488 = agg_isNull489;
/* 1002 */             agg_value512 = agg_value513;
/* 1003 */           }
/* 1004 */
/* 1005 */           else {
/* 1006 */             agg_isNull488 = false;
/* 1007 */             agg_value512 = 0.0D;
/* 1008 */           }
/* 1009 */           if (!agg_isNull488) {
/* 1010 */             agg_isNull483 = false; // resultCode could change nullability.
/* 1011 */             agg_value507 = agg_value508 + agg_value512;
/* 1012 */
/* 1013 */           }
/* 1014 */           boolean agg_isNull482 = agg_isNull483;
/* 1015 */           double agg_value506 = agg_value507;
/* 1016 */           if (agg_isNull482) {
/* 1017 */             boolean agg_isNull494 = agg_fastAggBuffer.isNullAt(4);
/* 1018 */             double agg_value518 = agg_isNull494 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 1019 */             if (!agg_isNull494) {
/* 1020 */               agg_isNull482 = false;
/* 1021 */               agg_value506 = agg_value518;
/* 1022 */             }
/* 1023 */           }
/* 1024 */           boolean agg_isNull496 = true;
/* 1025 */           double agg_value520 = -1.0;
/* 1026 */
/* 1027 */           boolean agg_isNull498 = agg_fastAggBuffer.isNullAt(5);
/* 1028 */           double agg_value522 = agg_isNull498 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 1029 */           boolean agg_isNull497 = agg_isNull498;
/* 1030 */           double agg_value521 = agg_value522;
/* 1031 */           if (agg_isNull497) {
/* 1032 */             boolean agg_isNull499 = false;
/* 1033 */             double agg_value523 = -1.0;
/* 1034 */             if (!false) {
/* 1035 */               agg_value523 = (double) 0;
/* 1036 */             }
/* 1037 */             if (!agg_isNull499) {
/* 1038 */               agg_isNull497 = false;
/* 1039 */               agg_value521 = agg_value523;
/* 1040 */             }
/* 1041 */           }
/* 1042 */
/* 1043 */           boolean agg_isNull501 = true;
/* 1044 */           double agg_value525 = -1.0;
/* 1045 */
/* 1046 */           if (!agg_isNull406 && agg_value430) {
/* 1047 */             boolean agg_isNull502 = true;
/* 1048 */             double agg_value526 = -1.0;
/* 1049 */
/* 1050 */             if (!scan_isNull4) {
/* 1051 */               boolean agg_isNull504 = scan_isNull3;
/* 1052 */               double agg_value528 = -1.0;
/* 1053 */               if (!scan_isNull3) {
/* 1054 */                 agg_value528 = (double) scan_value3;
/* 1055 */               }
/* 1056 */               if (!agg_isNull504) {
/* 1057 */                 agg_isNull502 = false; // resultCode could change nullability.
/* 1058 */                 agg_value526 = scan_value4 * agg_value528;
/* 1059 */
/* 1060 */               }
/* 1061 */
/* 1062 */             }
/* 1063 */             agg_isNull501 = agg_isNull502;
/* 1064 */             agg_value525 = agg_value526;
/* 1065 */           }
/* 1066 */
/* 1067 */           else {
/* 1068 */             agg_isNull501 = false;
/* 1069 */             agg_value525 = 0.0D;
/* 1070 */           }
/* 1071 */           if (!agg_isNull501) {
/* 1072 */             agg_isNull496 = false; // resultCode could change nullability.
/* 1073 */             agg_value520 = agg_value521 + agg_value525;
/* 1074 */
/* 1075 */           }
/* 1076 */           boolean agg_isNull495 = agg_isNull496;
/* 1077 */           double agg_value519 = agg_value520;
/* 1078 */           if (agg_isNull495) {
/* 1079 */             boolean agg_isNull507 = agg_fastAggBuffer.isNullAt(5);
/* 1080 */             double agg_value531 = agg_isNull507 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 1081 */             if (!agg_isNull507) {
/* 1082 */               agg_isNull495 = false;
/* 1083 */               agg_value519 = agg_value531;
/* 1084 */             }
/* 1085 */           }
/* 1086 */           boolean agg_isNull509 = true;
/* 1087 */           double agg_value533 = -1.0;
/* 1088 */
/* 1089 */           boolean agg_isNull511 = agg_fastAggBuffer.isNullAt(6);
/* 1090 */           double agg_value535 = agg_isNull511 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 1091 */           boolean agg_isNull510 = agg_isNull511;
/* 1092 */           double agg_value534 = agg_value535;
/* 1093 */           if (agg_isNull510) {
/* 1094 */             boolean agg_isNull512 = false;
/* 1095 */             double agg_value536 = -1.0;
/* 1096 */             if (!false) {
/* 1097 */               agg_value536 = (double) 0;
/* 1098 */             }
/* 1099 */             if (!agg_isNull512) {
/* 1100 */               agg_isNull510 = false;
/* 1101 */               agg_value534 = agg_value536;
/* 1102 */             }
/* 1103 */           }
/* 1104 */
/* 1105 */           boolean agg_isNull514 = true;
/* 1106 */           double agg_value538 = -1.0;
/* 1107 */
/* 1108 */           if (!agg_isNull412 && agg_value436) {
/* 1109 */             boolean agg_isNull515 = true;
/* 1110 */             double agg_value539 = -1.0;
/* 1111 */
/* 1112 */             if (!scan_isNull4) {
/* 1113 */               boolean agg_isNull517 = scan_isNull3;
/* 1114 */               double agg_value541 = -1.0;
/* 1115 */               if (!scan_isNull3) {
/* 1116 */                 agg_value541 = (double) scan_value3;
/* 1117 */               }
/* 1118 */               if (!agg_isNull517) {
/* 1119 */                 agg_isNull515 = false; // resultCode could change nullability.
/* 1120 */                 agg_value539 = scan_value4 * agg_value541;
/* 1121 */
/* 1122 */               }
/* 1123 */
/* 1124 */             }
/* 1125 */             agg_isNull514 = agg_isNull515;
/* 1126 */             agg_value538 = agg_value539;
/* 1127 */           }
/* 1128 */
/* 1129 */           else {
/* 1130 */             agg_isNull514 = false;
/* 1131 */             agg_value538 = 0.0D;
/* 1132 */           }
/* 1133 */           if (!agg_isNull514) {
/* 1134 */             agg_isNull509 = false; // resultCode could change nullability.
/* 1135 */             agg_value533 = agg_value534 + agg_value538;
/* 1136 */
/* 1137 */           }
/* 1138 */           boolean agg_isNull508 = agg_isNull509;
/* 1139 */           double agg_value532 = agg_value533;
/* 1140 */           if (agg_isNull508) {
/* 1141 */             boolean agg_isNull520 = agg_fastAggBuffer.isNullAt(6);
/* 1142 */             double agg_value544 = agg_isNull520 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 1143 */             if (!agg_isNull520) {
/* 1144 */               agg_isNull508 = false;
/* 1145 */               agg_value532 = agg_value544;
/* 1146 */             }
/* 1147 */           }
/* 1148 */           boolean agg_isNull522 = true;
/* 1149 */           double agg_value546 = -1.0;
/* 1150 */
/* 1151 */           boolean agg_isNull524 = agg_fastAggBuffer.isNullAt(7);
/* 1152 */           double agg_value548 = agg_isNull524 ? -1.0 : (agg_fastAggBuffer.getDouble(7));
/* 1153 */           boolean agg_isNull523 = agg_isNull524;
/* 1154 */           double agg_value547 = agg_value548;
/* 1155 */           if (agg_isNull523) {
/* 1156 */             boolean agg_isNull525 = false;
/* 1157 */             double agg_value549 = -1.0;
/* 1158 */             if (!false) {
/* 1159 */               agg_value549 = (double) 0;
/* 1160 */             }
/* 1161 */             if (!agg_isNull525) {
/* 1162 */               agg_isNull523 = false;
/* 1163 */               agg_value547 = agg_value549;
/* 1164 */             }
/* 1165 */           }
/* 1166 */
/* 1167 */           boolean agg_isNull527 = true;
/* 1168 */           double agg_value551 = -1.0;
/* 1169 */
/* 1170 */           if (!agg_isNull394 && agg_value418) {
/* 1171 */             boolean agg_isNull528 = true;
/* 1172 */             double agg_value552 = -1.0;
/* 1173 */
/* 1174 */             if (!scan_isNull4) {
/* 1175 */               boolean agg_isNull530 = scan_isNull3;
/* 1176 */               double agg_value554 = -1.0;
/* 1177 */               if (!scan_isNull3) {
/* 1178 */                 agg_value554 = (double) scan_value3;
/* 1179 */               }
/* 1180 */               if (!agg_isNull530) {
/* 1181 */                 agg_isNull528 = false; // resultCode could change nullability.
/* 1182 */                 agg_value552 = scan_value4 * agg_value554;
/* 1183 */
/* 1184 */               }
/* 1185 */
/* 1186 */             }
/* 1187 */             agg_isNull527 = agg_isNull528;
/* 1188 */             agg_value551 = agg_value552;
/* 1189 */           }
/* 1190 */
/* 1191 */           else {
/* 1192 */             agg_isNull527 = false;
/* 1193 */             agg_value551 = 0.0D;
/* 1194 */           }
/* 1195 */           if (!agg_isNull527) {
/* 1196 */             agg_isNull522 = false; // resultCode could change nullability.
/* 1197 */             agg_value546 = agg_value547 + agg_value551;
/* 1198 */
/* 1199 */           }
/* 1200 */           boolean agg_isNull521 = agg_isNull522;
/* 1201 */           double agg_value545 = agg_value546;
/* 1202 */           if (agg_isNull521) {
/* 1203 */             boolean agg_isNull533 = agg_fastAggBuffer.isNullAt(7);
/* 1204 */             double agg_value557 = agg_isNull533 ? -1.0 : (agg_fastAggBuffer.getDouble(7));
/* 1205 */             if (!agg_isNull533) {
/* 1206 */               agg_isNull521 = false;
/* 1207 */               agg_value545 = agg_value557;
/* 1208 */             }
/* 1209 */           }
/* 1210 */           boolean agg_isNull535 = true;
/* 1211 */           double agg_value559 = -1.0;
/* 1212 */
/* 1213 */           boolean agg_isNull537 = agg_fastAggBuffer.isNullAt(8);
/* 1214 */           double agg_value561 = agg_isNull537 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 1215 */           boolean agg_isNull536 = agg_isNull537;
/* 1216 */           double agg_value560 = agg_value561;
/* 1217 */           if (agg_isNull536) {
/* 1218 */             boolean agg_isNull538 = false;
/* 1219 */             double agg_value562 = -1.0;
/* 1220 */             if (!false) {
/* 1221 */               agg_value562 = (double) 0;
/* 1222 */             }
/* 1223 */             if (!agg_isNull538) {
/* 1224 */               agg_isNull536 = false;
/* 1225 */               agg_value560 = agg_value562;
/* 1226 */             }
/* 1227 */           }
/* 1228 */
/* 1229 */           boolean agg_isNull540 = true;
/* 1230 */           double agg_value564 = -1.0;
/* 1231 */
/* 1232 */           if (!agg_isNull403 && agg_value427) {
/* 1233 */             boolean agg_isNull541 = true;
/* 1234 */             double agg_value565 = -1.0;
/* 1235 */
/* 1236 */             if (!scan_isNull4) {
/* 1237 */               boolean agg_isNull543 = scan_isNull3;
/* 1238 */               double agg_value567 = -1.0;
/* 1239 */               if (!scan_isNull3) {
/* 1240 */                 agg_value567 = (double) scan_value3;
/* 1241 */               }
/* 1242 */               if (!agg_isNull543) {
/* 1243 */                 agg_isNull541 = false; // resultCode could change nullability.
/* 1244 */                 agg_value565 = scan_value4 * agg_value567;
/* 1245 */
/* 1246 */               }
/* 1247 */
/* 1248 */             }
/* 1249 */             agg_isNull540 = agg_isNull541;
/* 1250 */             agg_value564 = agg_value565;
/* 1251 */           }
/* 1252 */
/* 1253 */           else {
/* 1254 */             agg_isNull540 = false;
/* 1255 */             agg_value564 = 0.0D;
/* 1256 */           }
/* 1257 */           if (!agg_isNull540) {
/* 1258 */             agg_isNull535 = false; // resultCode could change nullability.
/* 1259 */             agg_value559 = agg_value560 + agg_value564;
/* 1260 */
/* 1261 */           }
/* 1262 */           boolean agg_isNull534 = agg_isNull535;
/* 1263 */           double agg_value558 = agg_value559;
/* 1264 */           if (agg_isNull534) {
/* 1265 */             boolean agg_isNull546 = agg_fastAggBuffer.isNullAt(8);
/* 1266 */             double agg_value570 = agg_isNull546 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 1267 */             if (!agg_isNull546) {
/* 1268 */               agg_isNull534 = false;
/* 1269 */               agg_value558 = agg_value570;
/* 1270 */             }
/* 1271 */           }
/* 1272 */           boolean agg_isNull548 = true;
/* 1273 */           double agg_value572 = -1.0;
/* 1274 */
/* 1275 */           boolean agg_isNull550 = agg_fastAggBuffer.isNullAt(9);
/* 1276 */           double agg_value574 = agg_isNull550 ? -1.0 : (agg_fastAggBuffer.getDouble(9));
/* 1277 */           boolean agg_isNull549 = agg_isNull550;
/* 1278 */           double agg_value573 = agg_value574;
/* 1279 */           if (agg_isNull549) {
/* 1280 */             boolean agg_isNull551 = false;
/* 1281 */             double agg_value575 = -1.0;
/* 1282 */             if (!false) {
/* 1283 */               agg_value575 = (double) 0;
/* 1284 */             }
/* 1285 */             if (!agg_isNull551) {
/* 1286 */               agg_isNull549 = false;
/* 1287 */               agg_value573 = agg_value575;
/* 1288 */             }
/* 1289 */           }
/* 1290 */
/* 1291 */           boolean agg_isNull553 = true;
/* 1292 */           double agg_value577 = -1.0;
/* 1293 */
/* 1294 */           if (!agg_isNull427 && agg_value451) {
/* 1295 */             boolean agg_isNull554 = true;
/* 1296 */             double agg_value578 = -1.0;
/* 1297 */
/* 1298 */             if (!scan_isNull4) {
/* 1299 */               boolean agg_isNull556 = scan_isNull3;
/* 1300 */               double agg_value580 = -1.0;
/* 1301 */               if (!scan_isNull3) {
/* 1302 */                 agg_value580 = (double) scan_value3;
/* 1303 */               }
/* 1304 */               if (!agg_isNull556) {
/* 1305 */                 agg_isNull554 = false; // resultCode could change nullability.
/* 1306 */                 agg_value578 = scan_value4 * agg_value580;
/* 1307 */
/* 1308 */               }
/* 1309 */
/* 1310 */             }
/* 1311 */             agg_isNull553 = agg_isNull554;
/* 1312 */             agg_value577 = agg_value578;
/* 1313 */           }
/* 1314 */
/* 1315 */           else {
/* 1316 */             agg_isNull553 = false;
/* 1317 */             agg_value577 = 0.0D;
/* 1318 */           }
/* 1319 */           if (!agg_isNull553) {
/* 1320 */             agg_isNull548 = false; // resultCode could change nullability.
/* 1321 */             agg_value572 = agg_value573 + agg_value577;
/* 1322 */
/* 1323 */           }
/* 1324 */           boolean agg_isNull547 = agg_isNull548;
/* 1325 */           double agg_value571 = agg_value572;
/* 1326 */           if (agg_isNull547) {
/* 1327 */             boolean agg_isNull559 = agg_fastAggBuffer.isNullAt(9);
/* 1328 */             double agg_value583 = agg_isNull559 ? -1.0 : (agg_fastAggBuffer.getDouble(9));
/* 1329 */             if (!agg_isNull559) {
/* 1330 */               agg_isNull547 = false;
/* 1331 */               agg_value571 = agg_value583;
/* 1332 */             }
/* 1333 */           }
/* 1334 */           boolean agg_isNull561 = true;
/* 1335 */           double agg_value585 = -1.0;
/* 1336 */
/* 1337 */           boolean agg_isNull563 = agg_fastAggBuffer.isNullAt(10);
/* 1338 */           double agg_value587 = agg_isNull563 ? -1.0 : (agg_fastAggBuffer.getDouble(10));
/* 1339 */           boolean agg_isNull562 = agg_isNull563;
/* 1340 */           double agg_value586 = agg_value587;
/* 1341 */           if (agg_isNull562) {
/* 1342 */             boolean agg_isNull564 = false;
/* 1343 */             double agg_value588 = -1.0;
/* 1344 */             if (!false) {
/* 1345 */               agg_value588 = (double) 0;
/* 1346 */             }
/* 1347 */             if (!agg_isNull564) {
/* 1348 */               agg_isNull562 = false;
/* 1349 */               agg_value586 = agg_value588;
/* 1350 */             }
/* 1351 */           }
/* 1352 */
/* 1353 */           boolean agg_isNull566 = true;
/* 1354 */           double agg_value590 = -1.0;
/* 1355 */
/* 1356 */           if (!agg_isNull421 && agg_value445) {
/* 1357 */             boolean agg_isNull567 = true;
/* 1358 */             double agg_value591 = -1.0;
/* 1359 */
/* 1360 */             if (!scan_isNull4) {
/* 1361 */               boolean agg_isNull569 = scan_isNull3;
/* 1362 */               double agg_value593 = -1.0;
/* 1363 */               if (!scan_isNull3) {
/* 1364 */                 agg_value593 = (double) scan_value3;
/* 1365 */               }
/* 1366 */               if (!agg_isNull569) {
/* 1367 */                 agg_isNull567 = false; // resultCode could change nullability.
/* 1368 */                 agg_value591 = scan_value4 * agg_value593;
/* 1369 */
/* 1370 */               }
/* 1371 */
/* 1372 */             }
/* 1373 */             agg_isNull566 = agg_isNull567;
/* 1374 */             agg_value590 = agg_value591;
/* 1375 */           }
/* 1376 */
/* 1377 */           else {
/* 1378 */             agg_isNull566 = false;
/* 1379 */             agg_value590 = 0.0D;
/* 1380 */           }
/* 1381 */           if (!agg_isNull566) {
/* 1382 */             agg_isNull561 = false; // resultCode could change nullability.
/* 1383 */             agg_value585 = agg_value586 + agg_value590;
/* 1384 */
/* 1385 */           }
/* 1386 */           boolean agg_isNull560 = agg_isNull561;
/* 1387 */           double agg_value584 = agg_value585;
/* 1388 */           if (agg_isNull560) {
/* 1389 */             boolean agg_isNull572 = agg_fastAggBuffer.isNullAt(10);
/* 1390 */             double agg_value596 = agg_isNull572 ? -1.0 : (agg_fastAggBuffer.getDouble(10));
/* 1391 */             if (!agg_isNull572) {
/* 1392 */               agg_isNull560 = false;
/* 1393 */               agg_value584 = agg_value596;
/* 1394 */             }
/* 1395 */           }
/* 1396 */           boolean agg_isNull574 = true;
/* 1397 */           double agg_value598 = -1.0;
/* 1398 */
/* 1399 */           boolean agg_isNull576 = agg_fastAggBuffer.isNullAt(11);
/* 1400 */           double agg_value600 = agg_isNull576 ? -1.0 : (agg_fastAggBuffer.getDouble(11));
/* 1401 */           boolean agg_isNull575 = agg_isNull576;
/* 1402 */           double agg_value599 = agg_value600;
/* 1403 */           if (agg_isNull575) {
/* 1404 */             boolean agg_isNull577 = false;
/* 1405 */             double agg_value601 = -1.0;
/* 1406 */             if (!false) {
/* 1407 */               agg_value601 = (double) 0;
/* 1408 */             }
/* 1409 */             if (!agg_isNull577) {
/* 1410 */               agg_isNull575 = false;
/* 1411 */               agg_value599 = agg_value601;
/* 1412 */             }
/* 1413 */           }
/* 1414 */
/* 1415 */           boolean agg_isNull579 = true;
/* 1416 */           double agg_value603 = -1.0;
/* 1417 */
/* 1418 */           if (!agg_isNull415 && agg_value439) {
/* 1419 */             boolean agg_isNull580 = true;
/* 1420 */             double agg_value604 = -1.0;
/* 1421 */
/* 1422 */             if (!scan_isNull4) {
/* 1423 */               boolean agg_isNull582 = scan_isNull3;
/* 1424 */               double agg_value606 = -1.0;
/* 1425 */               if (!scan_isNull3) {
/* 1426 */                 agg_value606 = (double) scan_value3;
/* 1427 */               }
/* 1428 */               if (!agg_isNull582) {
/* 1429 */                 agg_isNull580 = false; // resultCode could change nullability.
/* 1430 */                 agg_value604 = scan_value4 * agg_value606;
/* 1431 */
/* 1432 */               }
/* 1433 */
/* 1434 */             }
/* 1435 */             agg_isNull579 = agg_isNull580;
/* 1436 */             agg_value603 = agg_value604;
/* 1437 */           }
/* 1438 */
/* 1439 */           else {
/* 1440 */             agg_isNull579 = false;
/* 1441 */             agg_value603 = 0.0D;
/* 1442 */           }
/* 1443 */           if (!agg_isNull579) {
/* 1444 */             agg_isNull574 = false; // resultCode could change nullability.
/* 1445 */             agg_value598 = agg_value599 + agg_value603;
/* 1446 */
/* 1447 */           }
/* 1448 */           boolean agg_isNull573 = agg_isNull574;
/* 1449 */           double agg_value597 = agg_value598;
/* 1450 */           if (agg_isNull573) {
/* 1451 */             boolean agg_isNull585 = agg_fastAggBuffer.isNullAt(11);
/* 1452 */             double agg_value609 = agg_isNull585 ? -1.0 : (agg_fastAggBuffer.getDouble(11));
/* 1453 */             if (!agg_isNull585) {
/* 1454 */               agg_isNull573 = false;
/* 1455 */               agg_value597 = agg_value609;
/* 1456 */             }
/* 1457 */           }
/* 1458 */           boolean agg_isNull587 = true;
/* 1459 */           double agg_value611 = -1.0;
/* 1460 */
/* 1461 */           boolean agg_isNull589 = agg_fastAggBuffer.isNullAt(12);
/* 1462 */           double agg_value613 = agg_isNull589 ? -1.0 : (agg_fastAggBuffer.getDouble(12));
/* 1463 */           boolean agg_isNull588 = agg_isNull589;
/* 1464 */           double agg_value612 = agg_value613;
/* 1465 */           if (agg_isNull588) {
/* 1466 */             boolean agg_isNull590 = false;
/* 1467 */             double agg_value614 = -1.0;
/* 1468 */             if (!false) {
/* 1469 */               agg_value614 = (double) 0;
/* 1470 */             }
/* 1471 */             if (!agg_isNull590) {
/* 1472 */               agg_isNull588 = false;
/* 1473 */               agg_value612 = agg_value614;
/* 1474 */             }
/* 1475 */           }
/* 1476 */
/* 1477 */           boolean agg_isNull592 = true;
/* 1478 */           double agg_value616 = -1.0;
/* 1479 */
/* 1480 */           if (!agg_isNull409 && agg_value433) {
/* 1481 */             boolean agg_isNull593 = true;
/* 1482 */             double agg_value617 = -1.0;
/* 1483 */
/* 1484 */             if (!scan_isNull5) {
/* 1485 */               boolean agg_isNull595 = scan_isNull3;
/* 1486 */               double agg_value619 = -1.0;
/* 1487 */               if (!scan_isNull3) {
/* 1488 */                 agg_value619 = (double) scan_value3;
/* 1489 */               }
/* 1490 */               if (!agg_isNull595) {
/* 1491 */                 agg_isNull593 = false; // resultCode could change nullability.
/* 1492 */                 agg_value617 = scan_value5 * agg_value619;
/* 1493 */
/* 1494 */               }
/* 1495 */
/* 1496 */             }
/* 1497 */             agg_isNull592 = agg_isNull593;
/* 1498 */             agg_value616 = agg_value617;
/* 1499 */           }
/* 1500 */
/* 1501 */           else {
/* 1502 */             agg_isNull592 = false;
/* 1503 */             agg_value616 = 0.0D;
/* 1504 */           }
/* 1505 */           if (!agg_isNull592) {
/* 1506 */             agg_isNull587 = false; // resultCode could change nullability.
/* 1507 */             agg_value611 = agg_value612 + agg_value616;
/* 1508 */
/* 1509 */           }
/* 1510 */           boolean agg_isNull586 = agg_isNull587;
/* 1511 */           double agg_value610 = agg_value611;
/* 1512 */           if (agg_isNull586) {
/* 1513 */             boolean agg_isNull598 = agg_fastAggBuffer.isNullAt(12);
/* 1514 */             double agg_value622 = agg_isNull598 ? -1.0 : (agg_fastAggBuffer.getDouble(12));
/* 1515 */             if (!agg_isNull598) {
/* 1516 */               agg_isNull586 = false;
/* 1517 */               agg_value610 = agg_value622;
/* 1518 */             }
/* 1519 */           }
/* 1520 */           boolean agg_isNull600 = true;
/* 1521 */           double agg_value624 = -1.0;
/* 1522 */
/* 1523 */           boolean agg_isNull602 = agg_fastAggBuffer.isNullAt(13);
/* 1524 */           double agg_value626 = agg_isNull602 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 1525 */           boolean agg_isNull601 = agg_isNull602;
/* 1526 */           double agg_value625 = agg_value626;
/* 1527 */           if (agg_isNull601) {
/* 1528 */             boolean agg_isNull603 = false;
/* 1529 */             double agg_value627 = -1.0;
/* 1530 */             if (!false) {
/* 1531 */               agg_value627 = (double) 0;
/* 1532 */             }
/* 1533 */             if (!agg_isNull603) {
/* 1534 */               agg_isNull601 = false;
/* 1535 */               agg_value625 = agg_value627;
/* 1536 */             }
/* 1537 */           }
/* 1538 */
/* 1539 */           boolean agg_isNull605 = true;
/* 1540 */           double agg_value629 = -1.0;
/* 1541 */
/* 1542 */           if (!agg_isNull400 && agg_value424) {
/* 1543 */             boolean agg_isNull606 = true;
/* 1544 */             double agg_value630 = -1.0;
/* 1545 */
/* 1546 */             if (!scan_isNull5) {
/* 1547 */               boolean agg_isNull608 = scan_isNull3;
/* 1548 */               double agg_value632 = -1.0;
/* 1549 */               if (!scan_isNull3) {
/* 1550 */                 agg_value632 = (double) scan_value3;
/* 1551 */               }
/* 1552 */               if (!agg_isNull608) {
/* 1553 */                 agg_isNull606 = false; // resultCode could change nullability.
/* 1554 */                 agg_value630 = scan_value5 * agg_value632;
/* 1555 */
/* 1556 */               }
/* 1557 */
/* 1558 */             }
/* 1559 */             agg_isNull605 = agg_isNull606;
/* 1560 */             agg_value629 = agg_value630;
/* 1561 */           }
/* 1562 */
/* 1563 */           else {
/* 1564 */             agg_isNull605 = false;
/* 1565 */             agg_value629 = 0.0D;
/* 1566 */           }
/* 1567 */           if (!agg_isNull605) {
/* 1568 */             agg_isNull600 = false; // resultCode could change nullability.
/* 1569 */             agg_value624 = agg_value625 + agg_value629;
/* 1570 */
/* 1571 */           }
/* 1572 */           boolean agg_isNull599 = agg_isNull600;
/* 1573 */           double agg_value623 = agg_value624;
/* 1574 */           if (agg_isNull599) {
/* 1575 */             boolean agg_isNull611 = agg_fastAggBuffer.isNullAt(13);
/* 1576 */             double agg_value635 = agg_isNull611 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 1577 */             if (!agg_isNull611) {
/* 1578 */               agg_isNull599 = false;
/* 1579 */               agg_value623 = agg_value635;
/* 1580 */             }
/* 1581 */           }
/* 1582 */           boolean agg_isNull613 = true;
/* 1583 */           double agg_value637 = -1.0;
/* 1584 */
/* 1585 */           boolean agg_isNull615 = agg_fastAggBuffer.isNullAt(14);
/* 1586 */           double agg_value639 = agg_isNull615 ? -1.0 : (agg_fastAggBuffer.getDouble(14));
/* 1587 */           boolean agg_isNull614 = agg_isNull615;
/* 1588 */           double agg_value638 = agg_value639;
/* 1589 */           if (agg_isNull614) {
/* 1590 */             boolean agg_isNull616 = false;
/* 1591 */             double agg_value640 = -1.0;
/* 1592 */             if (!false) {
/* 1593 */               agg_value640 = (double) 0;
/* 1594 */             }
/* 1595 */             if (!agg_isNull616) {
/* 1596 */               agg_isNull614 = false;
/* 1597 */               agg_value638 = agg_value640;
/* 1598 */             }
/* 1599 */           }
/* 1600 */
/* 1601 */           boolean agg_isNull618 = true;
/* 1602 */           double agg_value642 = -1.0;
/* 1603 */
/* 1604 */           if (!agg_isNull418 && agg_value442) {
/* 1605 */             boolean agg_isNull619 = true;
/* 1606 */             double agg_value643 = -1.0;
/* 1607 */
/* 1608 */             if (!scan_isNull5) {
/* 1609 */               boolean agg_isNull621 = scan_isNull3;
/* 1610 */               double agg_value645 = -1.0;
/* 1611 */               if (!scan_isNull3) {
/* 1612 */                 agg_value645 = (double) scan_value3;
/* 1613 */               }
/* 1614 */               if (!agg_isNull621) {
/* 1615 */                 agg_isNull619 = false; // resultCode could change nullability.
/* 1616 */                 agg_value643 = scan_value5 * agg_value645;
/* 1617 */
/* 1618 */               }
/* 1619 */
/* 1620 */             }
/* 1621 */             agg_isNull618 = agg_isNull619;
/* 1622 */             agg_value642 = agg_value643;
/* 1623 */           }
/* 1624 */
/* 1625 */           else {
/* 1626 */             agg_isNull618 = false;
/* 1627 */             agg_value642 = 0.0D;
/* 1628 */           }
/* 1629 */           if (!agg_isNull618) {
/* 1630 */             agg_isNull613 = false; // resultCode could change nullability.
/* 1631 */             agg_value637 = agg_value638 + agg_value642;
/* 1632 */
/* 1633 */           }
/* 1634 */           boolean agg_isNull612 = agg_isNull613;
/* 1635 */           double agg_value636 = agg_value637;
/* 1636 */           if (agg_isNull612) {
/* 1637 */             boolean agg_isNull624 = agg_fastAggBuffer.isNullAt(14);
/* 1638 */             double agg_value648 = agg_isNull624 ? -1.0 : (agg_fastAggBuffer.getDouble(14));
/* 1639 */             if (!agg_isNull624) {
/* 1640 */               agg_isNull612 = false;
/* 1641 */               agg_value636 = agg_value648;
/* 1642 */             }
/* 1643 */           }
/* 1644 */           boolean agg_isNull626 = true;
/* 1645 */           double agg_value650 = -1.0;
/* 1646 */
/* 1647 */           boolean agg_isNull628 = agg_fastAggBuffer.isNullAt(15);
/* 1648 */           double agg_value652 = agg_isNull628 ? -1.0 : (agg_fastAggBuffer.getDouble(15));
/* 1649 */           boolean agg_isNull627 = agg_isNull628;
/* 1650 */           double agg_value651 = agg_value652;
/* 1651 */           if (agg_isNull627) {
/* 1652 */             boolean agg_isNull629 = false;
/* 1653 */             double agg_value653 = -1.0;
/* 1654 */             if (!false) {
/* 1655 */               agg_value653 = (double) 0;
/* 1656 */             }
/* 1657 */             if (!agg_isNull629) {
/* 1658 */               agg_isNull627 = false;
/* 1659 */               agg_value651 = agg_value653;
/* 1660 */             }
/* 1661 */           }
/* 1662 */
/* 1663 */           boolean agg_isNull631 = true;
/* 1664 */           double agg_value655 = -1.0;
/* 1665 */
/* 1666 */           if (!agg_isNull424 && agg_value448) {
/* 1667 */             boolean agg_isNull632 = true;
/* 1668 */             double agg_value656 = -1.0;
/* 1669 */
/* 1670 */             if (!scan_isNull5) {
/* 1671 */               boolean agg_isNull634 = scan_isNull3;
/* 1672 */               double agg_value658 = -1.0;
/* 1673 */               if (!scan_isNull3) {
/* 1674 */                 agg_value658 = (double) scan_value3;
/* 1675 */               }
/* 1676 */               if (!agg_isNull634) {
/* 1677 */                 agg_isNull632 = false; // resultCode could change nullability.
/* 1678 */                 agg_value656 = scan_value5 * agg_value658;
/* 1679 */
/* 1680 */               }
/* 1681 */
/* 1682 */             }
/* 1683 */             agg_isNull631 = agg_isNull632;
/* 1684 */             agg_value655 = agg_value656;
/* 1685 */           }
/* 1686 */
/* 1687 */           else {
/* 1688 */             agg_isNull631 = false;
/* 1689 */             agg_value655 = 0.0D;
/* 1690 */           }
/* 1691 */           if (!agg_isNull631) {
/* 1692 */             agg_isNull626 = false; // resultCode could change nullability.
/* 1693 */             agg_value650 = agg_value651 + agg_value655;
/* 1694 */
/* 1695 */           }
/* 1696 */           boolean agg_isNull625 = agg_isNull626;
/* 1697 */           double agg_value649 = agg_value650;
/* 1698 */           if (agg_isNull625) {
/* 1699 */             boolean agg_isNull637 = agg_fastAggBuffer.isNullAt(15);
/* 1700 */             double agg_value661 = agg_isNull637 ? -1.0 : (agg_fastAggBuffer.getDouble(15));
/* 1701 */             if (!agg_isNull637) {
/* 1702 */               agg_isNull625 = false;
/* 1703 */               agg_value649 = agg_value661;
/* 1704 */             }
/* 1705 */           }
/* 1706 */           boolean agg_isNull639 = true;
/* 1707 */           double agg_value663 = -1.0;
/* 1708 */
/* 1709 */           boolean agg_isNull641 = agg_fastAggBuffer.isNullAt(16);
/* 1710 */           double agg_value665 = agg_isNull641 ? -1.0 : (agg_fastAggBuffer.getDouble(16));
/* 1711 */           boolean agg_isNull640 = agg_isNull641;
/* 1712 */           double agg_value664 = agg_value665;
/* 1713 */           if (agg_isNull640) {
/* 1714 */             boolean agg_isNull642 = false;
/* 1715 */             double agg_value666 = -1.0;
/* 1716 */             if (!false) {
/* 1717 */               agg_value666 = (double) 0;
/* 1718 */             }
/* 1719 */             if (!agg_isNull642) {
/* 1720 */               agg_isNull640 = false;
/* 1721 */               agg_value664 = agg_value666;
/* 1722 */             }
/* 1723 */           }
/* 1724 */
/* 1725 */           boolean agg_isNull644 = true;
/* 1726 */           double agg_value668 = -1.0;
/* 1727 */
/* 1728 */           if (!agg_isNull397 && agg_value421) {
/* 1729 */             boolean agg_isNull645 = true;
/* 1730 */             double agg_value669 = -1.0;
/* 1731 */
/* 1732 */             if (!scan_isNull5) {
/* 1733 */               boolean agg_isNull647 = scan_isNull3;
/* 1734 */               double agg_value671 = -1.0;
/* 1735 */               if (!scan_isNull3) {
/* 1736 */                 agg_value671 = (double) scan_value3;
/* 1737 */               }
/* 1738 */               if (!agg_isNull647) {
/* 1739 */                 agg_isNull645 = false; // resultCode could change nullability.
/* 1740 */                 agg_value669 = scan_value5 * agg_value671;
/* 1741 */
/* 1742 */               }
/* 1743 */
/* 1744 */             }
/* 1745 */             agg_isNull644 = agg_isNull645;
/* 1746 */             agg_value668 = agg_value669;
/* 1747 */           }
/* 1748 */
/* 1749 */           else {
/* 1750 */             agg_isNull644 = false;
/* 1751 */             agg_value668 = 0.0D;
/* 1752 */           }
/* 1753 */           if (!agg_isNull644) {
/* 1754 */             agg_isNull639 = false; // resultCode could change nullability.
/* 1755 */             agg_value663 = agg_value664 + agg_value668;
/* 1756 */
/* 1757 */           }
/* 1758 */           boolean agg_isNull638 = agg_isNull639;
/* 1759 */           double agg_value662 = agg_value663;
/* 1760 */           if (agg_isNull638) {
/* 1761 */             boolean agg_isNull650 = agg_fastAggBuffer.isNullAt(16);
/* 1762 */             double agg_value674 = agg_isNull650 ? -1.0 : (agg_fastAggBuffer.getDouble(16));
/* 1763 */             if (!agg_isNull650) {
/* 1764 */               agg_isNull638 = false;
/* 1765 */               agg_value662 = agg_value674;
/* 1766 */             }
/* 1767 */           }
/* 1768 */           boolean agg_isNull652 = true;
/* 1769 */           double agg_value676 = -1.0;
/* 1770 */
/* 1771 */           boolean agg_isNull654 = agg_fastAggBuffer.isNullAt(17);
/* 1772 */           double agg_value678 = agg_isNull654 ? -1.0 : (agg_fastAggBuffer.getDouble(17));
/* 1773 */           boolean agg_isNull653 = agg_isNull654;
/* 1774 */           double agg_value677 = agg_value678;
/* 1775 */           if (agg_isNull653) {
/* 1776 */             boolean agg_isNull655 = false;
/* 1777 */             double agg_value679 = -1.0;
/* 1778 */             if (!false) {
/* 1779 */               agg_value679 = (double) 0;
/* 1780 */             }
/* 1781 */             if (!agg_isNull655) {
/* 1782 */               agg_isNull653 = false;
/* 1783 */               agg_value677 = agg_value679;
/* 1784 */             }
/* 1785 */           }
/* 1786 */
/* 1787 */           boolean agg_isNull657 = true;
/* 1788 */           double agg_value681 = -1.0;
/* 1789 */
/* 1790 */           if (!agg_isNull406 && agg_value430) {
/* 1791 */             boolean agg_isNull658 = true;
/* 1792 */             double agg_value682 = -1.0;
/* 1793 */
/* 1794 */             if (!scan_isNull5) {
/* 1795 */               boolean agg_isNull660 = scan_isNull3;
/* 1796 */               double agg_value684 = -1.0;
/* 1797 */               if (!scan_isNull3) {
/* 1798 */                 agg_value684 = (double) scan_value3;
/* 1799 */               }
/* 1800 */               if (!agg_isNull660) {
/* 1801 */                 agg_isNull658 = false; // resultCode could change nullability.
/* 1802 */                 agg_value682 = scan_value5 * agg_value684;
/* 1803 */
/* 1804 */               }
/* 1805 */
/* 1806 */             }
/* 1807 */             agg_isNull657 = agg_isNull658;
/* 1808 */             agg_value681 = agg_value682;
/* 1809 */           }
/* 1810 */
/* 1811 */           else {
/* 1812 */             agg_isNull657 = false;
/* 1813 */             agg_value681 = 0.0D;
/* 1814 */           }
/* 1815 */           if (!agg_isNull657) {
/* 1816 */             agg_isNull652 = false; // resultCode could change nullability.
/* 1817 */             agg_value676 = agg_value677 + agg_value681;
/* 1818 */
/* 1819 */           }
/* 1820 */           boolean agg_isNull651 = agg_isNull652;
/* 1821 */           double agg_value675 = agg_value676;
/* 1822 */           if (agg_isNull651) {
/* 1823 */             boolean agg_isNull663 = agg_fastAggBuffer.isNullAt(17);
/* 1824 */             double agg_value687 = agg_isNull663 ? -1.0 : (agg_fastAggBuffer.getDouble(17));
/* 1825 */             if (!agg_isNull663) {
/* 1826 */               agg_isNull651 = false;
/* 1827 */               agg_value675 = agg_value687;
/* 1828 */             }
/* 1829 */           }
/* 1830 */           boolean agg_isNull665 = true;
/* 1831 */           double agg_value689 = -1.0;
/* 1832 */
/* 1833 */           boolean agg_isNull667 = agg_fastAggBuffer.isNullAt(18);
/* 1834 */           double agg_value691 = agg_isNull667 ? -1.0 : (agg_fastAggBuffer.getDouble(18));
/* 1835 */           boolean agg_isNull666 = agg_isNull667;
/* 1836 */           double agg_value690 = agg_value691;
/* 1837 */           if (agg_isNull666) {
/* 1838 */             boolean agg_isNull668 = false;
/* 1839 */             double agg_value692 = -1.0;
/* 1840 */             if (!false) {
/* 1841 */               agg_value692 = (double) 0;
/* 1842 */             }
/* 1843 */             if (!agg_isNull668) {
/* 1844 */               agg_isNull666 = false;
/* 1845 */               agg_value690 = agg_value692;
/* 1846 */             }
/* 1847 */           }
/* 1848 */
/* 1849 */           boolean agg_isNull670 = true;
/* 1850 */           double agg_value694 = -1.0;
/* 1851 */
/* 1852 */           if (!agg_isNull412 && agg_value436) {
/* 1853 */             boolean agg_isNull671 = true;
/* 1854 */             double agg_value695 = -1.0;
/* 1855 */
/* 1856 */             if (!scan_isNull5) {
/* 1857 */               boolean agg_isNull673 = scan_isNull3;
/* 1858 */               double agg_value697 = -1.0;
/* 1859 */               if (!scan_isNull3) {
/* 1860 */                 agg_value697 = (double) scan_value3;
/* 1861 */               }
/* 1862 */               if (!agg_isNull673) {
/* 1863 */                 agg_isNull671 = false; // resultCode could change nullability.
/* 1864 */                 agg_value695 = scan_value5 * agg_value697;
/* 1865 */
/* 1866 */               }
/* 1867 */
/* 1868 */             }
/* 1869 */             agg_isNull670 = agg_isNull671;
/* 1870 */             agg_value694 = agg_value695;
/* 1871 */           }
/* 1872 */
/* 1873 */           else {
/* 1874 */             agg_isNull670 = false;
/* 1875 */             agg_value694 = 0.0D;
/* 1876 */           }
/* 1877 */           if (!agg_isNull670) {
/* 1878 */             agg_isNull665 = false; // resultCode could change nullability.
/* 1879 */             agg_value689 = agg_value690 + agg_value694;
/* 1880 */
/* 1881 */           }
/* 1882 */           boolean agg_isNull664 = agg_isNull665;
/* 1883 */           double agg_value688 = agg_value689;
/* 1884 */           if (agg_isNull664) {
/* 1885 */             boolean agg_isNull676 = agg_fastAggBuffer.isNullAt(18);
/* 1886 */             double agg_value700 = agg_isNull676 ? -1.0 : (agg_fastAggBuffer.getDouble(18));
/* 1887 */             if (!agg_isNull676) {
/* 1888 */               agg_isNull664 = false;
/* 1889 */               agg_value688 = agg_value700;
/* 1890 */             }
/* 1891 */           }
/* 1892 */           boolean agg_isNull678 = true;
/* 1893 */           double agg_value702 = -1.0;
/* 1894 */
/* 1895 */           boolean agg_isNull680 = agg_fastAggBuffer.isNullAt(19);
/* 1896 */           double agg_value704 = agg_isNull680 ? -1.0 : (agg_fastAggBuffer.getDouble(19));
/* 1897 */           boolean agg_isNull679 = agg_isNull680;
/* 1898 */           double agg_value703 = agg_value704;
/* 1899 */           if (agg_isNull679) {
/* 1900 */             boolean agg_isNull681 = false;
/* 1901 */             double agg_value705 = -1.0;
/* 1902 */             if (!false) {
/* 1903 */               agg_value705 = (double) 0;
/* 1904 */             }
/* 1905 */             if (!agg_isNull681) {
/* 1906 */               agg_isNull679 = false;
/* 1907 */               agg_value703 = agg_value705;
/* 1908 */             }
/* 1909 */           }
/* 1910 */
/* 1911 */           boolean agg_isNull683 = true;
/* 1912 */           double agg_value707 = -1.0;
/* 1913 */
/* 1914 */           if (!agg_isNull394 && agg_value418) {
/* 1915 */             boolean agg_isNull684 = true;
/* 1916 */             double agg_value708 = -1.0;
/* 1917 */
/* 1918 */             if (!scan_isNull5) {
/* 1919 */               boolean agg_isNull686 = scan_isNull3;
/* 1920 */               double agg_value710 = -1.0;
/* 1921 */               if (!scan_isNull3) {
/* 1922 */                 agg_value710 = (double) scan_value3;
/* 1923 */               }
/* 1924 */               if (!agg_isNull686) {
/* 1925 */                 agg_isNull684 = false; // resultCode could change nullability.
/* 1926 */                 agg_value708 = scan_value5 * agg_value710;
/* 1927 */
/* 1928 */               }
/* 1929 */
/* 1930 */             }
/* 1931 */             agg_isNull683 = agg_isNull684;
/* 1932 */             agg_value707 = agg_value708;
/* 1933 */           }
/* 1934 */
/* 1935 */           else {
/* 1936 */             agg_isNull683 = false;
/* 1937 */             agg_value707 = 0.0D;
/* 1938 */           }
/* 1939 */           if (!agg_isNull683) {
/* 1940 */             agg_isNull678 = false; // resultCode could change nullability.
/* 1941 */             agg_value702 = agg_value703 + agg_value707;
/* 1942 */
/* 1943 */           }
/* 1944 */           boolean agg_isNull677 = agg_isNull678;
/* 1945 */           double agg_value701 = agg_value702;
/* 1946 */           if (agg_isNull677) {
/* 1947 */             boolean agg_isNull689 = agg_fastAggBuffer.isNullAt(19);
/* 1948 */             double agg_value713 = agg_isNull689 ? -1.0 : (agg_fastAggBuffer.getDouble(19));
/* 1949 */             if (!agg_isNull689) {
/* 1950 */               agg_isNull677 = false;
/* 1951 */               agg_value701 = agg_value713;
/* 1952 */             }
/* 1953 */           }
/* 1954 */           boolean agg_isNull691 = true;
/* 1955 */           double agg_value715 = -1.0;
/* 1956 */
/* 1957 */           boolean agg_isNull693 = agg_fastAggBuffer.isNullAt(20);
/* 1958 */           double agg_value717 = agg_isNull693 ? -1.0 : (agg_fastAggBuffer.getDouble(20));
/* 1959 */           boolean agg_isNull692 = agg_isNull693;
/* 1960 */           double agg_value716 = agg_value717;
/* 1961 */           if (agg_isNull692) {
/* 1962 */             boolean agg_isNull694 = false;
/* 1963 */             double agg_value718 = -1.0;
/* 1964 */             if (!false) {
/* 1965 */               agg_value718 = (double) 0;
/* 1966 */             }
/* 1967 */             if (!agg_isNull694) {
/* 1968 */               agg_isNull692 = false;
/* 1969 */               agg_value716 = agg_value718;
/* 1970 */             }
/* 1971 */           }
/* 1972 */
/* 1973 */           boolean agg_isNull696 = true;
/* 1974 */           double agg_value720 = -1.0;
/* 1975 */
/* 1976 */           if (!agg_isNull403 && agg_value427) {
/* 1977 */             boolean agg_isNull697 = true;
/* 1978 */             double agg_value721 = -1.0;
/* 1979 */
/* 1980 */             if (!scan_isNull5) {
/* 1981 */               boolean agg_isNull699 = scan_isNull3;
/* 1982 */               double agg_value723 = -1.0;
/* 1983 */               if (!scan_isNull3) {
/* 1984 */                 agg_value723 = (double) scan_value3;
/* 1985 */               }
/* 1986 */               if (!agg_isNull699) {
/* 1987 */                 agg_isNull697 = false; // resultCode could change nullability.
/* 1988 */                 agg_value721 = scan_value5 * agg_value723;
/* 1989 */
/* 1990 */               }
/* 1991 */
/* 1992 */             }
/* 1993 */             agg_isNull696 = agg_isNull697;
/* 1994 */             agg_value720 = agg_value721;
/* 1995 */           }
/* 1996 */
/* 1997 */           else {
/* 1998 */             agg_isNull696 = false;
/* 1999 */             agg_value720 = 0.0D;
/* 2000 */           }
/* 2001 */           if (!agg_isNull696) {
/* 2002 */             agg_isNull691 = false; // resultCode could change nullability.
/* 2003 */             agg_value715 = agg_value716 + agg_value720;
/* 2004 */
/* 2005 */           }
/* 2006 */           boolean agg_isNull690 = agg_isNull691;
/* 2007 */           double agg_value714 = agg_value715;
/* 2008 */           if (agg_isNull690) {
/* 2009 */             boolean agg_isNull702 = agg_fastAggBuffer.isNullAt(20);
/* 2010 */             double agg_value726 = agg_isNull702 ? -1.0 : (agg_fastAggBuffer.getDouble(20));
/* 2011 */             if (!agg_isNull702) {
/* 2012 */               agg_isNull690 = false;
/* 2013 */               agg_value714 = agg_value726;
/* 2014 */             }
/* 2015 */           }
/* 2016 */           boolean agg_isNull704 = true;
/* 2017 */           double agg_value728 = -1.0;
/* 2018 */
/* 2019 */           boolean agg_isNull706 = agg_fastAggBuffer.isNullAt(21);
/* 2020 */           double agg_value730 = agg_isNull706 ? -1.0 : (agg_fastAggBuffer.getDouble(21));
/* 2021 */           boolean agg_isNull705 = agg_isNull706;
/* 2022 */           double agg_value729 = agg_value730;
/* 2023 */           if (agg_isNull705) {
/* 2024 */             boolean agg_isNull707 = false;
/* 2025 */             double agg_value731 = -1.0;
/* 2026 */             if (!false) {
/* 2027 */               agg_value731 = (double) 0;
/* 2028 */             }
/* 2029 */             if (!agg_isNull707) {
/* 2030 */               agg_isNull705 = false;
/* 2031 */               agg_value729 = agg_value731;
/* 2032 */             }
/* 2033 */           }
/* 2034 */
/* 2035 */           boolean agg_isNull709 = true;
/* 2036 */           double agg_value733 = -1.0;
/* 2037 */
/* 2038 */           if (!agg_isNull427 && agg_value451) {
/* 2039 */             boolean agg_isNull710 = true;
/* 2040 */             double agg_value734 = -1.0;
/* 2041 */
/* 2042 */             if (!scan_isNull5) {
/* 2043 */               boolean agg_isNull712 = scan_isNull3;
/* 2044 */               double agg_value736 = -1.0;
/* 2045 */               if (!scan_isNull3) {
/* 2046 */                 agg_value736 = (double) scan_value3;
/* 2047 */               }
/* 2048 */               if (!agg_isNull712) {
/* 2049 */                 agg_isNull710 = false; // resultCode could change nullability.
/* 2050 */                 agg_value734 = scan_value5 * agg_value736;
/* 2051 */
/* 2052 */               }
/* 2053 */
/* 2054 */             }
/* 2055 */             agg_isNull709 = agg_isNull710;
/* 2056 */             agg_value733 = agg_value734;
/* 2057 */           }
/* 2058 */
/* 2059 */           else {
/* 2060 */             agg_isNull709 = false;
/* 2061 */             agg_value733 = 0.0D;
/* 2062 */           }
/* 2063 */           if (!agg_isNull709) {
/* 2064 */             agg_isNull704 = false; // resultCode could change nullability.
/* 2065 */             agg_value728 = agg_value729 + agg_value733;
/* 2066 */
/* 2067 */           }
/* 2068 */           boolean agg_isNull703 = agg_isNull704;
/* 2069 */           double agg_value727 = agg_value728;
/* 2070 */           if (agg_isNull703) {
/* 2071 */             boolean agg_isNull715 = agg_fastAggBuffer.isNullAt(21);
/* 2072 */             double agg_value739 = agg_isNull715 ? -1.0 : (agg_fastAggBuffer.getDouble(21));
/* 2073 */             if (!agg_isNull715) {
/* 2074 */               agg_isNull703 = false;
/* 2075 */               agg_value727 = agg_value739;
/* 2076 */             }
/* 2077 */           }
/* 2078 */           boolean agg_isNull717 = true;
/* 2079 */           double agg_value741 = -1.0;
/* 2080 */
/* 2081 */           boolean agg_isNull719 = agg_fastAggBuffer.isNullAt(22);
/* 2082 */           double agg_value743 = agg_isNull719 ? -1.0 : (agg_fastAggBuffer.getDouble(22));
/* 2083 */           boolean agg_isNull718 = agg_isNull719;
/* 2084 */           double agg_value742 = agg_value743;
/* 2085 */           if (agg_isNull718) {
/* 2086 */             boolean agg_isNull720 = false;
/* 2087 */             double agg_value744 = -1.0;
/* 2088 */             if (!false) {
/* 2089 */               agg_value744 = (double) 0;
/* 2090 */             }
/* 2091 */             if (!agg_isNull720) {
/* 2092 */               agg_isNull718 = false;
/* 2093 */               agg_value742 = agg_value744;
/* 2094 */             }
/* 2095 */           }
/* 2096 */
/* 2097 */           boolean agg_isNull722 = true;
/* 2098 */           double agg_value746 = -1.0;
/* 2099 */
/* 2100 */           if (!agg_isNull421 && agg_value445) {
/* 2101 */             boolean agg_isNull723 = true;
/* 2102 */             double agg_value747 = -1.0;
/* 2103 */
/* 2104 */             if (!scan_isNull5) {
/* 2105 */               boolean agg_isNull725 = scan_isNull3;
/* 2106 */               double agg_value749 = -1.0;
/* 2107 */               if (!scan_isNull3) {
/* 2108 */                 agg_value749 = (double) scan_value3;
/* 2109 */               }
/* 2110 */               if (!agg_isNull725) {
/* 2111 */                 agg_isNull723 = false; // resultCode could change nullability.
/* 2112 */                 agg_value747 = scan_value5 * agg_value749;
/* 2113 */
/* 2114 */               }
/* 2115 */
/* 2116 */             }
/* 2117 */             agg_isNull722 = agg_isNull723;
/* 2118 */             agg_value746 = agg_value747;
/* 2119 */           }
/* 2120 */
/* 2121 */           else {
/* 2122 */             agg_isNull722 = false;
/* 2123 */             agg_value746 = 0.0D;
/* 2124 */           }
/* 2125 */           if (!agg_isNull722) {
/* 2126 */             agg_isNull717 = false; // resultCode could change nullability.
/* 2127 */             agg_value741 = agg_value742 + agg_value746;
/* 2128 */
/* 2129 */           }
/* 2130 */           boolean agg_isNull716 = agg_isNull717;
/* 2131 */           double agg_value740 = agg_value741;
/* 2132 */           if (agg_isNull716) {
/* 2133 */             boolean agg_isNull728 = agg_fastAggBuffer.isNullAt(22);
/* 2134 */             double agg_value752 = agg_isNull728 ? -1.0 : (agg_fastAggBuffer.getDouble(22));
/* 2135 */             if (!agg_isNull728) {
/* 2136 */               agg_isNull716 = false;
/* 2137 */               agg_value740 = agg_value752;
/* 2138 */             }
/* 2139 */           }
/* 2140 */           boolean agg_isNull730 = true;
/* 2141 */           double agg_value754 = -1.0;
/* 2142 */
/* 2143 */           boolean agg_isNull732 = agg_fastAggBuffer.isNullAt(23);
/* 2144 */           double agg_value756 = agg_isNull732 ? -1.0 : (agg_fastAggBuffer.getDouble(23));
/* 2145 */           boolean agg_isNull731 = agg_isNull732;
/* 2146 */           double agg_value755 = agg_value756;
/* 2147 */           if (agg_isNull731) {
/* 2148 */             boolean agg_isNull733 = false;
/* 2149 */             double agg_value757 = -1.0;
/* 2150 */             if (!false) {
/* 2151 */               agg_value757 = (double) 0;
/* 2152 */             }
/* 2153 */             if (!agg_isNull733) {
/* 2154 */               agg_isNull731 = false;
/* 2155 */               agg_value755 = agg_value757;
/* 2156 */             }
/* 2157 */           }
/* 2158 */
/* 2159 */           boolean agg_isNull735 = true;
/* 2160 */           double agg_value759 = -1.0;
/* 2161 */
/* 2162 */           if (!agg_isNull415 && agg_value439) {
/* 2163 */             boolean agg_isNull736 = true;
/* 2164 */             double agg_value760 = -1.0;
/* 2165 */
/* 2166 */             if (!scan_isNull5) {
/* 2167 */               boolean agg_isNull738 = scan_isNull3;
/* 2168 */               double agg_value762 = -1.0;
/* 2169 */               if (!scan_isNull3) {
/* 2170 */                 agg_value762 = (double) scan_value3;
/* 2171 */               }
/* 2172 */               if (!agg_isNull738) {
/* 2173 */                 agg_isNull736 = false; // resultCode could change nullability.
/* 2174 */                 agg_value760 = scan_value5 * agg_value762;
/* 2175 */
/* 2176 */               }
/* 2177 */
/* 2178 */             }
/* 2179 */             agg_isNull735 = agg_isNull736;
/* 2180 */             agg_value759 = agg_value760;
/* 2181 */           }
/* 2182 */
/* 2183 */           else {
/* 2184 */             agg_isNull735 = false;
/* 2185 */             agg_value759 = 0.0D;
/* 2186 */           }
/* 2187 */           if (!agg_isNull735) {
/* 2188 */             agg_isNull730 = false; // resultCode could change nullability.
/* 2189 */             agg_value754 = agg_value755 + agg_value759;
/* 2190 */
/* 2191 */           }
/* 2192 */           boolean agg_isNull729 = agg_isNull730;
/* 2193 */           double agg_value753 = agg_value754;
/* 2194 */           if (agg_isNull729) {
/* 2195 */             boolean agg_isNull741 = agg_fastAggBuffer.isNullAt(23);
/* 2196 */             double agg_value765 = agg_isNull741 ? -1.0 : (agg_fastAggBuffer.getDouble(23));
/* 2197 */             if (!agg_isNull741) {
/* 2198 */               agg_isNull729 = false;
/* 2199 */               agg_value753 = agg_value765;
/* 2200 */             }
/* 2201 */           }
/* 2202 */           // update fast row
/* 2203 */           if (!agg_isNull430) {
/* 2204 */             agg_fastAggBuffer.setDouble(0, agg_value454);
/* 2205 */           } else {
/* 2206 */             agg_fastAggBuffer.setNullAt(0);
/* 2207 */           }
/* 2208 */
/* 2209 */           if (!agg_isNull443) {
/* 2210 */             agg_fastAggBuffer.setDouble(1, agg_value467);
/* 2211 */           } else {
/* 2212 */             agg_fastAggBuffer.setNullAt(1);
/* 2213 */           }
/* 2214 */
/* 2215 */           if (!agg_isNull456) {
/* 2216 */             agg_fastAggBuffer.setDouble(2, agg_value480);
/* 2217 */           } else {
/* 2218 */             agg_fastAggBuffer.setNullAt(2);
/* 2219 */           }
/* 2220 */
/* 2221 */           if (!agg_isNull469) {
/* 2222 */             agg_fastAggBuffer.setDouble(3, agg_value493);
/* 2223 */           } else {
/* 2224 */             agg_fastAggBuffer.setNullAt(3);
/* 2225 */           }
/* 2226 */
/* 2227 */           if (!agg_isNull482) {
/* 2228 */             agg_fastAggBuffer.setDouble(4, agg_value506);
/* 2229 */           } else {
/* 2230 */             agg_fastAggBuffer.setNullAt(4);
/* 2231 */           }
/* 2232 */
/* 2233 */           if (!agg_isNull495) {
/* 2234 */             agg_fastAggBuffer.setDouble(5, agg_value519);
/* 2235 */           } else {
/* 2236 */             agg_fastAggBuffer.setNullAt(5);
/* 2237 */           }
/* 2238 */
/* 2239 */           if (!agg_isNull508) {
/* 2240 */             agg_fastAggBuffer.setDouble(6, agg_value532);
/* 2241 */           } else {
/* 2242 */             agg_fastAggBuffer.setNullAt(6);
/* 2243 */           }
/* 2244 */
/* 2245 */           if (!agg_isNull521) {
/* 2246 */             agg_fastAggBuffer.setDouble(7, agg_value545);
/* 2247 */           } else {
/* 2248 */             agg_fastAggBuffer.setNullAt(7);
/* 2249 */           }
/* 2250 */
/* 2251 */           if (!agg_isNull534) {
/* 2252 */             agg_fastAggBuffer.setDouble(8, agg_value558);
/* 2253 */           } else {
/* 2254 */             agg_fastAggBuffer.setNullAt(8);
/* 2255 */           }
/* 2256 */
/* 2257 */           if (!agg_isNull547) {
/* 2258 */             agg_fastAggBuffer.setDouble(9, agg_value571);
/* 2259 */           } else {
/* 2260 */             agg_fastAggBuffer.setNullAt(9);
/* 2261 */           }
/* 2262 */
/* 2263 */           if (!agg_isNull560) {
/* 2264 */             agg_fastAggBuffer.setDouble(10, agg_value584);
/* 2265 */           } else {
/* 2266 */             agg_fastAggBuffer.setNullAt(10);
/* 2267 */           }
/* 2268 */
/* 2269 */           if (!agg_isNull573) {
/* 2270 */             agg_fastAggBuffer.setDouble(11, agg_value597);
/* 2271 */           } else {
/* 2272 */             agg_fastAggBuffer.setNullAt(11);
/* 2273 */           }
/* 2274 */
/* 2275 */           if (!agg_isNull586) {
/* 2276 */             agg_fastAggBuffer.setDouble(12, agg_value610);
/* 2277 */           } else {
/* 2278 */             agg_fastAggBuffer.setNullAt(12);
/* 2279 */           }
/* 2280 */
/* 2281 */           if (!agg_isNull599) {
/* 2282 */             agg_fastAggBuffer.setDouble(13, agg_value623);
/* 2283 */           } else {
/* 2284 */             agg_fastAggBuffer.setNullAt(13);
/* 2285 */           }
/* 2286 */
/* 2287 */           if (!agg_isNull612) {
/* 2288 */             agg_fastAggBuffer.setDouble(14, agg_value636);
/* 2289 */           } else {
/* 2290 */             agg_fastAggBuffer.setNullAt(14);
/* 2291 */           }
/* 2292 */
/* 2293 */           if (!agg_isNull625) {
/* 2294 */             agg_fastAggBuffer.setDouble(15, agg_value649);
/* 2295 */           } else {
/* 2296 */             agg_fastAggBuffer.setNullAt(15);
/* 2297 */           }
/* 2298 */
/* 2299 */           if (!agg_isNull638) {
/* 2300 */             agg_fastAggBuffer.setDouble(16, agg_value662);
/* 2301 */           } else {
/* 2302 */             agg_fastAggBuffer.setNullAt(16);
/* 2303 */           }
/* 2304 */
/* 2305 */           if (!agg_isNull651) {
/* 2306 */             agg_fastAggBuffer.setDouble(17, agg_value675);
/* 2307 */           } else {
/* 2308 */             agg_fastAggBuffer.setNullAt(17);
/* 2309 */           }
/* 2310 */
/* 2311 */           if (!agg_isNull664) {
/* 2312 */             agg_fastAggBuffer.setDouble(18, agg_value688);
/* 2313 */           } else {
/* 2314 */             agg_fastAggBuffer.setNullAt(18);
/* 2315 */           }
/* 2316 */
/* 2317 */           if (!agg_isNull677) {
/* 2318 */             agg_fastAggBuffer.setDouble(19, agg_value701);
/* 2319 */           } else {
/* 2320 */             agg_fastAggBuffer.setNullAt(19);
/* 2321 */           }
/* 2322 */
/* 2323 */           if (!agg_isNull690) {
/* 2324 */             agg_fastAggBuffer.setDouble(20, agg_value714);
/* 2325 */           } else {
/* 2326 */             agg_fastAggBuffer.setNullAt(20);
/* 2327 */           }
/* 2328 */
/* 2329 */           if (!agg_isNull703) {
/* 2330 */             agg_fastAggBuffer.setDouble(21, agg_value727);
/* 2331 */           } else {
/* 2332 */             agg_fastAggBuffer.setNullAt(21);
/* 2333 */           }
/* 2334 */
/* 2335 */           if (!agg_isNull716) {
/* 2336 */             agg_fastAggBuffer.setDouble(22, agg_value740);
/* 2337 */           } else {
/* 2338 */             agg_fastAggBuffer.setNullAt(22);
/* 2339 */           }
/* 2340 */
/* 2341 */           if (!agg_isNull729) {
/* 2342 */             agg_fastAggBuffer.setDouble(23, agg_value753);
/* 2343 */           } else {
/* 2344 */             agg_fastAggBuffer.setNullAt(23);
/* 2345 */           }
/* 2346 */
/* 2347 */         } else {
/* 2348 */           // update unsafe row
/* 2349 */
/* 2350 */           // common sub-expressions
/* 2351 */           boolean agg_isNull46 = true;
/* 2352 */           boolean agg_value70 = false;
/* 2353 */
/* 2354 */           if (!bhj_isNull27) {
/* 2355 */             agg_isNull46 = false; // resultCode could change nullability.
/* 2356 */             agg_value70 = bhj_value27 == 8;
/* 2357 */
/* 2358 */           }
/* 2359 */           boolean agg_isNull49 = true;
/* 2360 */           boolean agg_value73 = false;
/* 2361 */
/* 2362 */           if (!bhj_isNull27) {
/* 2363 */             agg_isNull49 = false; // resultCode could change nullability.
/* 2364 */             agg_value73 = bhj_value27 == 5;
/* 2365 */
/* 2366 */           }
/* 2367 */           boolean agg_isNull52 = true;
/* 2368 */           boolean agg_value76 = false;
/* 2369 */
/* 2370 */           if (!bhj_isNull27) {
/* 2371 */             agg_isNull52 = false; // resultCode could change nullability.
/* 2372 */             agg_value76 = bhj_value27 == 2;
/* 2373 */
/* 2374 */           }
/* 2375 */           boolean agg_isNull55 = true;
/* 2376 */           boolean agg_value79 = false;
/* 2377 */
/* 2378 */           if (!bhj_isNull27) {
/* 2379 */             agg_isNull55 = false; // resultCode could change nullability.
/* 2380 */             agg_value79 = bhj_value27 == 9;
/* 2381 */
/* 2382 */           }
/* 2383 */           boolean agg_isNull58 = true;
/* 2384 */           boolean agg_value82 = false;
/* 2385 */
/* 2386 */           if (!bhj_isNull27) {
/* 2387 */             agg_isNull58 = false; // resultCode could change nullability.
/* 2388 */             agg_value82 = bhj_value27 == 6;
/* 2389 */
/* 2390 */           }
/* 2391 */           boolean agg_isNull61 = true;
/* 2392 */           boolean agg_value85 = false;
/* 2393 */
/* 2394 */           if (!bhj_isNull27) {
/* 2395 */             agg_isNull61 = false; // resultCode could change nullability.
/* 2396 */             agg_value85 = bhj_value27 == 1;
/* 2397 */
/* 2398 */           }
/* 2399 */           boolean agg_isNull64 = true;
/* 2400 */           boolean agg_value88 = false;
/* 2401 */
/* 2402 */           if (!bhj_isNull27) {
/* 2403 */             agg_isNull64 = false; // resultCode could change nullability.
/* 2404 */             agg_value88 = bhj_value27 == 7;
/* 2405 */
/* 2406 */           }
/* 2407 */           boolean agg_isNull67 = true;
/* 2408 */           boolean agg_value91 = false;
/* 2409 */
/* 2410 */           if (!bhj_isNull27) {
/* 2411 */             agg_isNull67 = false; // resultCode could change nullability.
/* 2412 */             agg_value91 = bhj_value27 == 12;
/* 2413 */
/* 2414 */           }
/* 2415 */           boolean agg_isNull70 = true;
/* 2416 */           boolean agg_value94 = false;
/* 2417 */
/* 2418 */           if (!bhj_isNull27) {
/* 2419 */             agg_isNull70 = false; // resultCode could change nullability.
/* 2420 */             agg_value94 = bhj_value27 == 3;
/* 2421 */
/* 2422 */           }
/* 2423 */           boolean agg_isNull73 = true;
/* 2424 */           boolean agg_value97 = false;
/* 2425 */
/* 2426 */           if (!bhj_isNull27) {
/* 2427 */             agg_isNull73 = false; // resultCode could change nullability.
/* 2428 */             agg_value97 = bhj_value27 == 11;
/* 2429 */
/* 2430 */           }
/* 2431 */           boolean agg_isNull76 = true;
/* 2432 */           boolean agg_value100 = false;
/* 2433 */
/* 2434 */           if (!bhj_isNull27) {
/* 2435 */             agg_isNull76 = false; // resultCode could change nullability.
/* 2436 */             agg_value100 = bhj_value27 == 4;
/* 2437 */
/* 2438 */           }
/* 2439 */           boolean agg_isNull79 = true;
/* 2440 */           boolean agg_value103 = false;
/* 2441 */
/* 2442 */           if (!bhj_isNull27) {
/* 2443 */             agg_isNull79 = false; // resultCode could change nullability.
/* 2444 */             agg_value103 = bhj_value27 == 10;
/* 2445 */
/* 2446 */           }
/* 2447 */           // evaluate aggregate function
/* 2448 */           boolean agg_isNull83 = true;
/* 2449 */           double agg_value107 = -1.0;
/* 2450 */
/* 2451 */           boolean agg_isNull85 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 2452 */           double agg_value109 = agg_isNull85 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 2453 */           boolean agg_isNull84 = agg_isNull85;
/* 2454 */           double agg_value108 = agg_value109;
/* 2455 */           if (agg_isNull84) {
/* 2456 */             boolean agg_isNull86 = false;
/* 2457 */             double agg_value110 = -1.0;
/* 2458 */             if (!false) {
/* 2459 */               agg_value110 = (double) 0;
/* 2460 */             }
/* 2461 */             if (!agg_isNull86) {
/* 2462 */               agg_isNull84 = false;
/* 2463 */               agg_value108 = agg_value110;
/* 2464 */             }
/* 2465 */           }
/* 2466 */
/* 2467 */           boolean agg_isNull88 = true;
/* 2468 */           double agg_value112 = -1.0;
/* 2469 */
/* 2470 */           if (!agg_isNull61 && agg_value85) {
/* 2471 */             boolean agg_isNull89 = true;
/* 2472 */             double agg_value113 = -1.0;
/* 2473 */
/* 2474 */             if (!scan_isNull4) {
/* 2475 */               boolean agg_isNull91 = scan_isNull3;
/* 2476 */               double agg_value115 = -1.0;
/* 2477 */               if (!scan_isNull3) {
/* 2478 */                 agg_value115 = (double) scan_value3;
/* 2479 */               }
/* 2480 */               if (!agg_isNull91) {
/* 2481 */                 agg_isNull89 = false; // resultCode could change nullability.
/* 2482 */                 agg_value113 = scan_value4 * agg_value115;
/* 2483 */
/* 2484 */               }
/* 2485 */
/* 2486 */             }
/* 2487 */             agg_isNull88 = agg_isNull89;
/* 2488 */             agg_value112 = agg_value113;
/* 2489 */           }
/* 2490 */
/* 2491 */           else {
/* 2492 */             agg_isNull88 = false;
/* 2493 */             agg_value112 = 0.0D;
/* 2494 */           }
/* 2495 */           if (!agg_isNull88) {
/* 2496 */             agg_isNull83 = false; // resultCode could change nullability.
/* 2497 */             agg_value107 = agg_value108 + agg_value112;
/* 2498 */
/* 2499 */           }
/* 2500 */           boolean agg_isNull82 = agg_isNull83;
/* 2501 */           double agg_value106 = agg_value107;
/* 2502 */           if (agg_isNull82) {
/* 2503 */             boolean agg_isNull94 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 2504 */             double agg_value118 = agg_isNull94 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 2505 */             if (!agg_isNull94) {
/* 2506 */               agg_isNull82 = false;
/* 2507 */               agg_value106 = agg_value118;
/* 2508 */             }
/* 2509 */           }
/* 2510 */           boolean agg_isNull96 = true;
/* 2511 */           double agg_value120 = -1.0;
/* 2512 */
/* 2513 */           boolean agg_isNull98 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 2514 */           double agg_value122 = agg_isNull98 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 2515 */           boolean agg_isNull97 = agg_isNull98;
/* 2516 */           double agg_value121 = agg_value122;
/* 2517 */           if (agg_isNull97) {
/* 2518 */             boolean agg_isNull99 = false;
/* 2519 */             double agg_value123 = -1.0;
/* 2520 */             if (!false) {
/* 2521 */               agg_value123 = (double) 0;
/* 2522 */             }
/* 2523 */             if (!agg_isNull99) {
/* 2524 */               agg_isNull97 = false;
/* 2525 */               agg_value121 = agg_value123;
/* 2526 */             }
/* 2527 */           }
/* 2528 */
/* 2529 */           boolean agg_isNull101 = true;
/* 2530 */           double agg_value125 = -1.0;
/* 2531 */
/* 2532 */           if (!agg_isNull52 && agg_value76) {
/* 2533 */             boolean agg_isNull102 = true;
/* 2534 */             double agg_value126 = -1.0;
/* 2535 */
/* 2536 */             if (!scan_isNull4) {
/* 2537 */               boolean agg_isNull104 = scan_isNull3;
/* 2538 */               double agg_value128 = -1.0;
/* 2539 */               if (!scan_isNull3) {
/* 2540 */                 agg_value128 = (double) scan_value3;
/* 2541 */               }
/* 2542 */               if (!agg_isNull104) {
/* 2543 */                 agg_isNull102 = false; // resultCode could change nullability.
/* 2544 */                 agg_value126 = scan_value4 * agg_value128;
/* 2545 */
/* 2546 */               }
/* 2547 */
/* 2548 */             }
/* 2549 */             agg_isNull101 = agg_isNull102;
/* 2550 */             agg_value125 = agg_value126;
/* 2551 */           }
/* 2552 */
/* 2553 */           else {
/* 2554 */             agg_isNull101 = false;
/* 2555 */             agg_value125 = 0.0D;
/* 2556 */           }
/* 2557 */           if (!agg_isNull101) {
/* 2558 */             agg_isNull96 = false; // resultCode could change nullability.
/* 2559 */             agg_value120 = agg_value121 + agg_value125;
/* 2560 */
/* 2561 */           }
/* 2562 */           boolean agg_isNull95 = agg_isNull96;
/* 2563 */           double agg_value119 = agg_value120;
/* 2564 */           if (agg_isNull95) {
/* 2565 */             boolean agg_isNull107 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 2566 */             double agg_value131 = agg_isNull107 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 2567 */             if (!agg_isNull107) {
/* 2568 */               agg_isNull95 = false;
/* 2569 */               agg_value119 = agg_value131;
/* 2570 */             }
/* 2571 */           }
/* 2572 */           boolean agg_isNull109 = true;
/* 2573 */           double agg_value133 = -1.0;
/* 2574 */
/* 2575 */           boolean agg_isNull111 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2576 */           double agg_value135 = agg_isNull111 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 2577 */           boolean agg_isNull110 = agg_isNull111;
/* 2578 */           double agg_value134 = agg_value135;
/* 2579 */           if (agg_isNull110) {
/* 2580 */             boolean agg_isNull112 = false;
/* 2581 */             double agg_value136 = -1.0;
/* 2582 */             if (!false) {
/* 2583 */               agg_value136 = (double) 0;
/* 2584 */             }
/* 2585 */             if (!agg_isNull112) {
/* 2586 */               agg_isNull110 = false;
/* 2587 */               agg_value134 = agg_value136;
/* 2588 */             }
/* 2589 */           }
/* 2590 */
/* 2591 */           boolean agg_isNull114 = true;
/* 2592 */           double agg_value138 = -1.0;
/* 2593 */
/* 2594 */           if (!agg_isNull70 && agg_value94) {
/* 2595 */             boolean agg_isNull115 = true;
/* 2596 */             double agg_value139 = -1.0;
/* 2597 */
/* 2598 */             if (!scan_isNull4) {
/* 2599 */               boolean agg_isNull117 = scan_isNull3;
/* 2600 */               double agg_value141 = -1.0;
/* 2601 */               if (!scan_isNull3) {
/* 2602 */                 agg_value141 = (double) scan_value3;
/* 2603 */               }
/* 2604 */               if (!agg_isNull117) {
/* 2605 */                 agg_isNull115 = false; // resultCode could change nullability.
/* 2606 */                 agg_value139 = scan_value4 * agg_value141;
/* 2607 */
/* 2608 */               }
/* 2609 */
/* 2610 */             }
/* 2611 */             agg_isNull114 = agg_isNull115;
/* 2612 */             agg_value138 = agg_value139;
/* 2613 */           }
/* 2614 */
/* 2615 */           else {
/* 2616 */             agg_isNull114 = false;
/* 2617 */             agg_value138 = 0.0D;
/* 2618 */           }
/* 2619 */           if (!agg_isNull114) {
/* 2620 */             agg_isNull109 = false; // resultCode could change nullability.
/* 2621 */             agg_value133 = agg_value134 + agg_value138;
/* 2622 */
/* 2623 */           }
/* 2624 */           boolean agg_isNull108 = agg_isNull109;
/* 2625 */           double agg_value132 = agg_value133;
/* 2626 */           if (agg_isNull108) {
/* 2627 */             boolean agg_isNull120 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2628 */             double agg_value144 = agg_isNull120 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 2629 */             if (!agg_isNull120) {
/* 2630 */               agg_isNull108 = false;
/* 2631 */               agg_value132 = agg_value144;
/* 2632 */             }
/* 2633 */           }
/* 2634 */           boolean agg_isNull122 = true;
/* 2635 */           double agg_value146 = -1.0;
/* 2636 */
/* 2637 */           boolean agg_isNull124 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 2638 */           double agg_value148 = agg_isNull124 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 2639 */           boolean agg_isNull123 = agg_isNull124;
/* 2640 */           double agg_value147 = agg_value148;
/* 2641 */           if (agg_isNull123) {
/* 2642 */             boolean agg_isNull125 = false;
/* 2643 */             double agg_value149 = -1.0;
/* 2644 */             if (!false) {
/* 2645 */               agg_value149 = (double) 0;
/* 2646 */             }
/* 2647 */             if (!agg_isNull125) {
/* 2648 */               agg_isNull123 = false;
/* 2649 */               agg_value147 = agg_value149;
/* 2650 */             }
/* 2651 */           }
/* 2652 */
/* 2653 */           boolean agg_isNull127 = true;
/* 2654 */           double agg_value151 = -1.0;
/* 2655 */
/* 2656 */           if (!agg_isNull76 && agg_value100) {
/* 2657 */             boolean agg_isNull128 = true;
/* 2658 */             double agg_value152 = -1.0;
/* 2659 */
/* 2660 */             if (!scan_isNull4) {
/* 2661 */               boolean agg_isNull130 = scan_isNull3;
/* 2662 */               double agg_value154 = -1.0;
/* 2663 */               if (!scan_isNull3) {
/* 2664 */                 agg_value154 = (double) scan_value3;
/* 2665 */               }
/* 2666 */               if (!agg_isNull130) {
/* 2667 */                 agg_isNull128 = false; // resultCode could change nullability.
/* 2668 */                 agg_value152 = scan_value4 * agg_value154;
/* 2669 */
/* 2670 */               }
/* 2671 */
/* 2672 */             }
/* 2673 */             agg_isNull127 = agg_isNull128;
/* 2674 */             agg_value151 = agg_value152;
/* 2675 */           }
/* 2676 */
/* 2677 */           else {
/* 2678 */             agg_isNull127 = false;
/* 2679 */             agg_value151 = 0.0D;
/* 2680 */           }
/* 2681 */           if (!agg_isNull127) {
/* 2682 */             agg_isNull122 = false; // resultCode could change nullability.
/* 2683 */             agg_value146 = agg_value147 + agg_value151;
/* 2684 */
/* 2685 */           }
/* 2686 */           boolean agg_isNull121 = agg_isNull122;
/* 2687 */           double agg_value145 = agg_value146;
/* 2688 */           if (agg_isNull121) {
/* 2689 */             boolean agg_isNull133 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 2690 */             double agg_value157 = agg_isNull133 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 2691 */             if (!agg_isNull133) {
/* 2692 */               agg_isNull121 = false;
/* 2693 */               agg_value145 = agg_value157;
/* 2694 */             }
/* 2695 */           }
/* 2696 */           boolean agg_isNull135 = true;
/* 2697 */           double agg_value159 = -1.0;
/* 2698 */
/* 2699 */           boolean agg_isNull137 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 2700 */           double agg_value161 = agg_isNull137 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 2701 */           boolean agg_isNull136 = agg_isNull137;
/* 2702 */           double agg_value160 = agg_value161;
/* 2703 */           if (agg_isNull136) {
/* 2704 */             boolean agg_isNull138 = false;
/* 2705 */             double agg_value162 = -1.0;
/* 2706 */             if (!false) {
/* 2707 */               agg_value162 = (double) 0;
/* 2708 */             }
/* 2709 */             if (!agg_isNull138) {
/* 2710 */               agg_isNull136 = false;
/* 2711 */               agg_value160 = agg_value162;
/* 2712 */             }
/* 2713 */           }
/* 2714 */
/* 2715 */           boolean agg_isNull140 = true;
/* 2716 */           double agg_value164 = -1.0;
/* 2717 */
/* 2718 */           if (!agg_isNull49 && agg_value73) {
/* 2719 */             boolean agg_isNull141 = true;
/* 2720 */             double agg_value165 = -1.0;
/* 2721 */
/* 2722 */             if (!scan_isNull4) {
/* 2723 */               boolean agg_isNull143 = scan_isNull3;
/* 2724 */               double agg_value167 = -1.0;
/* 2725 */               if (!scan_isNull3) {
/* 2726 */                 agg_value167 = (double) scan_value3;
/* 2727 */               }
/* 2728 */               if (!agg_isNull143) {
/* 2729 */                 agg_isNull141 = false; // resultCode could change nullability.
/* 2730 */                 agg_value165 = scan_value4 * agg_value167;
/* 2731 */
/* 2732 */               }
/* 2733 */
/* 2734 */             }
/* 2735 */             agg_isNull140 = agg_isNull141;
/* 2736 */             agg_value164 = agg_value165;
/* 2737 */           }
/* 2738 */
/* 2739 */           else {
/* 2740 */             agg_isNull140 = false;
/* 2741 */             agg_value164 = 0.0D;
/* 2742 */           }
/* 2743 */           if (!agg_isNull140) {
/* 2744 */             agg_isNull135 = false; // resultCode could change nullability.
/* 2745 */             agg_value159 = agg_value160 + agg_value164;
/* 2746 */
/* 2747 */           }
/* 2748 */           boolean agg_isNull134 = agg_isNull135;
/* 2749 */           double agg_value158 = agg_value159;
/* 2750 */           if (agg_isNull134) {
/* 2751 */             boolean agg_isNull146 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 2752 */             double agg_value170 = agg_isNull146 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 2753 */             if (!agg_isNull146) {
/* 2754 */               agg_isNull134 = false;
/* 2755 */               agg_value158 = agg_value170;
/* 2756 */             }
/* 2757 */           }
/* 2758 */           boolean agg_isNull148 = true;
/* 2759 */           double agg_value172 = -1.0;
/* 2760 */
/* 2761 */           boolean agg_isNull150 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 2762 */           double agg_value174 = agg_isNull150 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 2763 */           boolean agg_isNull149 = agg_isNull150;
/* 2764 */           double agg_value173 = agg_value174;
/* 2765 */           if (agg_isNull149) {
/* 2766 */             boolean agg_isNull151 = false;
/* 2767 */             double agg_value175 = -1.0;
/* 2768 */             if (!false) {
/* 2769 */               agg_value175 = (double) 0;
/* 2770 */             }
/* 2771 */             if (!agg_isNull151) {
/* 2772 */               agg_isNull149 = false;
/* 2773 */               agg_value173 = agg_value175;
/* 2774 */             }
/* 2775 */           }
/* 2776 */
/* 2777 */           boolean agg_isNull153 = true;
/* 2778 */           double agg_value177 = -1.0;
/* 2779 */
/* 2780 */           if (!agg_isNull58 && agg_value82) {
/* 2781 */             boolean agg_isNull154 = true;
/* 2782 */             double agg_value178 = -1.0;
/* 2783 */
/* 2784 */             if (!scan_isNull4) {
/* 2785 */               boolean agg_isNull156 = scan_isNull3;
/* 2786 */               double agg_value180 = -1.0;
/* 2787 */               if (!scan_isNull3) {
/* 2788 */                 agg_value180 = (double) scan_value3;
/* 2789 */               }
/* 2790 */               if (!agg_isNull156) {
/* 2791 */                 agg_isNull154 = false; // resultCode could change nullability.
/* 2792 */                 agg_value178 = scan_value4 * agg_value180;
/* 2793 */
/* 2794 */               }
/* 2795 */
/* 2796 */             }
/* 2797 */             agg_isNull153 = agg_isNull154;
/* 2798 */             agg_value177 = agg_value178;
/* 2799 */           }
/* 2800 */
/* 2801 */           else {
/* 2802 */             agg_isNull153 = false;
/* 2803 */             agg_value177 = 0.0D;
/* 2804 */           }
/* 2805 */           if (!agg_isNull153) {
/* 2806 */             agg_isNull148 = false; // resultCode could change nullability.
/* 2807 */             agg_value172 = agg_value173 + agg_value177;
/* 2808 */
/* 2809 */           }
/* 2810 */           boolean agg_isNull147 = agg_isNull148;
/* 2811 */           double agg_value171 = agg_value172;
/* 2812 */           if (agg_isNull147) {
/* 2813 */             boolean agg_isNull159 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 2814 */             double agg_value183 = agg_isNull159 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 2815 */             if (!agg_isNull159) {
/* 2816 */               agg_isNull147 = false;
/* 2817 */               agg_value171 = agg_value183;
/* 2818 */             }
/* 2819 */           }
/* 2820 */           boolean agg_isNull161 = true;
/* 2821 */           double agg_value185 = -1.0;
/* 2822 */
/* 2823 */           boolean agg_isNull163 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 2824 */           double agg_value187 = agg_isNull163 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 2825 */           boolean agg_isNull162 = agg_isNull163;
/* 2826 */           double agg_value186 = agg_value187;
/* 2827 */           if (agg_isNull162) {
/* 2828 */             boolean agg_isNull164 = false;
/* 2829 */             double agg_value188 = -1.0;
/* 2830 */             if (!false) {
/* 2831 */               agg_value188 = (double) 0;
/* 2832 */             }
/* 2833 */             if (!agg_isNull164) {
/* 2834 */               agg_isNull162 = false;
/* 2835 */               agg_value186 = agg_value188;
/* 2836 */             }
/* 2837 */           }
/* 2838 */
/* 2839 */           boolean agg_isNull166 = true;
/* 2840 */           double agg_value190 = -1.0;
/* 2841 */
/* 2842 */           if (!agg_isNull64 && agg_value88) {
/* 2843 */             boolean agg_isNull167 = true;
/* 2844 */             double agg_value191 = -1.0;
/* 2845 */
/* 2846 */             if (!scan_isNull4) {
/* 2847 */               boolean agg_isNull169 = scan_isNull3;
/* 2848 */               double agg_value193 = -1.0;
/* 2849 */               if (!scan_isNull3) {
/* 2850 */                 agg_value193 = (double) scan_value3;
/* 2851 */               }
/* 2852 */               if (!agg_isNull169) {
/* 2853 */                 agg_isNull167 = false; // resultCode could change nullability.
/* 2854 */                 agg_value191 = scan_value4 * agg_value193;
/* 2855 */
/* 2856 */               }
/* 2857 */
/* 2858 */             }
/* 2859 */             agg_isNull166 = agg_isNull167;
/* 2860 */             agg_value190 = agg_value191;
/* 2861 */           }
/* 2862 */
/* 2863 */           else {
/* 2864 */             agg_isNull166 = false;
/* 2865 */             agg_value190 = 0.0D;
/* 2866 */           }
/* 2867 */           if (!agg_isNull166) {
/* 2868 */             agg_isNull161 = false; // resultCode could change nullability.
/* 2869 */             agg_value185 = agg_value186 + agg_value190;
/* 2870 */
/* 2871 */           }
/* 2872 */           boolean agg_isNull160 = agg_isNull161;
/* 2873 */           double agg_value184 = agg_value185;
/* 2874 */           if (agg_isNull160) {
/* 2875 */             boolean agg_isNull172 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 2876 */             double agg_value196 = agg_isNull172 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 2877 */             if (!agg_isNull172) {
/* 2878 */               agg_isNull160 = false;
/* 2879 */               agg_value184 = agg_value196;
/* 2880 */             }
/* 2881 */           }
/* 2882 */           boolean agg_isNull174 = true;
/* 2883 */           double agg_value198 = -1.0;
/* 2884 */
/* 2885 */           boolean agg_isNull176 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 2886 */           double agg_value200 = agg_isNull176 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 2887 */           boolean agg_isNull175 = agg_isNull176;
/* 2888 */           double agg_value199 = agg_value200;
/* 2889 */           if (agg_isNull175) {
/* 2890 */             boolean agg_isNull177 = false;
/* 2891 */             double agg_value201 = -1.0;
/* 2892 */             if (!false) {
/* 2893 */               agg_value201 = (double) 0;
/* 2894 */             }
/* 2895 */             if (!agg_isNull177) {
/* 2896 */               agg_isNull175 = false;
/* 2897 */               agg_value199 = agg_value201;
/* 2898 */             }
/* 2899 */           }
/* 2900 */
/* 2901 */           boolean agg_isNull179 = true;
/* 2902 */           double agg_value203 = -1.0;
/* 2903 */
/* 2904 */           if (!agg_isNull46 && agg_value70) {
/* 2905 */             boolean agg_isNull180 = true;
/* 2906 */             double agg_value204 = -1.0;
/* 2907 */
/* 2908 */             if (!scan_isNull4) {
/* 2909 */               boolean agg_isNull182 = scan_isNull3;
/* 2910 */               double agg_value206 = -1.0;
/* 2911 */               if (!scan_isNull3) {
/* 2912 */                 agg_value206 = (double) scan_value3;
/* 2913 */               }
/* 2914 */               if (!agg_isNull182) {
/* 2915 */                 agg_isNull180 = false; // resultCode could change nullability.
/* 2916 */                 agg_value204 = scan_value4 * agg_value206;
/* 2917 */
/* 2918 */               }
/* 2919 */
/* 2920 */             }
/* 2921 */             agg_isNull179 = agg_isNull180;
/* 2922 */             agg_value203 = agg_value204;
/* 2923 */           }
/* 2924 */
/* 2925 */           else {
/* 2926 */             agg_isNull179 = false;
/* 2927 */             agg_value203 = 0.0D;
/* 2928 */           }
/* 2929 */           if (!agg_isNull179) {
/* 2930 */             agg_isNull174 = false; // resultCode could change nullability.
/* 2931 */             agg_value198 = agg_value199 + agg_value203;
/* 2932 */
/* 2933 */           }
/* 2934 */           boolean agg_isNull173 = agg_isNull174;
/* 2935 */           double agg_value197 = agg_value198;
/* 2936 */           if (agg_isNull173) {
/* 2937 */             boolean agg_isNull185 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 2938 */             double agg_value209 = agg_isNull185 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 2939 */             if (!agg_isNull185) {
/* 2940 */               agg_isNull173 = false;
/* 2941 */               agg_value197 = agg_value209;
/* 2942 */             }
/* 2943 */           }
/* 2944 */           boolean agg_isNull187 = true;
/* 2945 */           double agg_value211 = -1.0;
/* 2946 */
/* 2947 */           boolean agg_isNull189 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 2948 */           double agg_value213 = agg_isNull189 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 2949 */           boolean agg_isNull188 = agg_isNull189;
/* 2950 */           double agg_value212 = agg_value213;
/* 2951 */           if (agg_isNull188) {
/* 2952 */             boolean agg_isNull190 = false;
/* 2953 */             double agg_value214 = -1.0;
/* 2954 */             if (!false) {
/* 2955 */               agg_value214 = (double) 0;
/* 2956 */             }
/* 2957 */             if (!agg_isNull190) {
/* 2958 */               agg_isNull188 = false;
/* 2959 */               agg_value212 = agg_value214;
/* 2960 */             }
/* 2961 */           }
/* 2962 */
/* 2963 */           boolean agg_isNull192 = true;
/* 2964 */           double agg_value216 = -1.0;
/* 2965 */
/* 2966 */           if (!agg_isNull55 && agg_value79) {
/* 2967 */             boolean agg_isNull193 = true;
/* 2968 */             double agg_value217 = -1.0;
/* 2969 */
/* 2970 */             if (!scan_isNull4) {
/* 2971 */               boolean agg_isNull195 = scan_isNull3;
/* 2972 */               double agg_value219 = -1.0;
/* 2973 */               if (!scan_isNull3) {
/* 2974 */                 agg_value219 = (double) scan_value3;
/* 2975 */               }
/* 2976 */               if (!agg_isNull195) {
/* 2977 */                 agg_isNull193 = false; // resultCode could change nullability.
/* 2978 */                 agg_value217 = scan_value4 * agg_value219;
/* 2979 */
/* 2980 */               }
/* 2981 */
/* 2982 */             }
/* 2983 */             agg_isNull192 = agg_isNull193;
/* 2984 */             agg_value216 = agg_value217;
/* 2985 */           }
/* 2986 */
/* 2987 */           else {
/* 2988 */             agg_isNull192 = false;
/* 2989 */             agg_value216 = 0.0D;
/* 2990 */           }
/* 2991 */           if (!agg_isNull192) {
/* 2992 */             agg_isNull187 = false; // resultCode could change nullability.
/* 2993 */             agg_value211 = agg_value212 + agg_value216;
/* 2994 */
/* 2995 */           }
/* 2996 */           boolean agg_isNull186 = agg_isNull187;
/* 2997 */           double agg_value210 = agg_value211;
/* 2998 */           if (agg_isNull186) {
/* 2999 */             boolean agg_isNull198 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 3000 */             double agg_value222 = agg_isNull198 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 3001 */             if (!agg_isNull198) {
/* 3002 */               agg_isNull186 = false;
/* 3003 */               agg_value210 = agg_value222;
/* 3004 */             }
/* 3005 */           }
/* 3006 */           boolean agg_isNull200 = true;
/* 3007 */           double agg_value224 = -1.0;
/* 3008 */
/* 3009 */           boolean agg_isNull202 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 3010 */           double agg_value226 = agg_isNull202 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 3011 */           boolean agg_isNull201 = agg_isNull202;
/* 3012 */           double agg_value225 = agg_value226;
/* 3013 */           if (agg_isNull201) {
/* 3014 */             boolean agg_isNull203 = false;
/* 3015 */             double agg_value227 = -1.0;
/* 3016 */             if (!false) {
/* 3017 */               agg_value227 = (double) 0;
/* 3018 */             }
/* 3019 */             if (!agg_isNull203) {
/* 3020 */               agg_isNull201 = false;
/* 3021 */               agg_value225 = agg_value227;
/* 3022 */             }
/* 3023 */           }
/* 3024 */
/* 3025 */           boolean agg_isNull205 = true;
/* 3026 */           double agg_value229 = -1.0;
/* 3027 */
/* 3028 */           if (!agg_isNull79 && agg_value103) {
/* 3029 */             boolean agg_isNull206 = true;
/* 3030 */             double agg_value230 = -1.0;
/* 3031 */
/* 3032 */             if (!scan_isNull4) {
/* 3033 */               boolean agg_isNull208 = scan_isNull3;
/* 3034 */               double agg_value232 = -1.0;
/* 3035 */               if (!scan_isNull3) {
/* 3036 */                 agg_value232 = (double) scan_value3;
/* 3037 */               }
/* 3038 */               if (!agg_isNull208) {
/* 3039 */                 agg_isNull206 = false; // resultCode could change nullability.
/* 3040 */                 agg_value230 = scan_value4 * agg_value232;
/* 3041 */
/* 3042 */               }
/* 3043 */
/* 3044 */             }
/* 3045 */             agg_isNull205 = agg_isNull206;
/* 3046 */             agg_value229 = agg_value230;
/* 3047 */           }
/* 3048 */
/* 3049 */           else {
/* 3050 */             agg_isNull205 = false;
/* 3051 */             agg_value229 = 0.0D;
/* 3052 */           }
/* 3053 */           if (!agg_isNull205) {
/* 3054 */             agg_isNull200 = false; // resultCode could change nullability.
/* 3055 */             agg_value224 = agg_value225 + agg_value229;
/* 3056 */
/* 3057 */           }
/* 3058 */           boolean agg_isNull199 = agg_isNull200;
/* 3059 */           double agg_value223 = agg_value224;
/* 3060 */           if (agg_isNull199) {
/* 3061 */             boolean agg_isNull211 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 3062 */             double agg_value235 = agg_isNull211 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 3063 */             if (!agg_isNull211) {
/* 3064 */               agg_isNull199 = false;
/* 3065 */               agg_value223 = agg_value235;
/* 3066 */             }
/* 3067 */           }
/* 3068 */           boolean agg_isNull213 = true;
/* 3069 */           double agg_value237 = -1.0;
/* 3070 */
/* 3071 */           boolean agg_isNull215 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 3072 */           double agg_value239 = agg_isNull215 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 3073 */           boolean agg_isNull214 = agg_isNull215;
/* 3074 */           double agg_value238 = agg_value239;
/* 3075 */           if (agg_isNull214) {
/* 3076 */             boolean agg_isNull216 = false;
/* 3077 */             double agg_value240 = -1.0;
/* 3078 */             if (!false) {
/* 3079 */               agg_value240 = (double) 0;
/* 3080 */             }
/* 3081 */             if (!agg_isNull216) {
/* 3082 */               agg_isNull214 = false;
/* 3083 */               agg_value238 = agg_value240;
/* 3084 */             }
/* 3085 */           }
/* 3086 */
/* 3087 */           boolean agg_isNull218 = true;
/* 3088 */           double agg_value242 = -1.0;
/* 3089 */
/* 3090 */           if (!agg_isNull73 && agg_value97) {
/* 3091 */             boolean agg_isNull219 = true;
/* 3092 */             double agg_value243 = -1.0;
/* 3093 */
/* 3094 */             if (!scan_isNull4) {
/* 3095 */               boolean agg_isNull221 = scan_isNull3;
/* 3096 */               double agg_value245 = -1.0;
/* 3097 */               if (!scan_isNull3) {
/* 3098 */                 agg_value245 = (double) scan_value3;
/* 3099 */               }
/* 3100 */               if (!agg_isNull221) {
/* 3101 */                 agg_isNull219 = false; // resultCode could change nullability.
/* 3102 */                 agg_value243 = scan_value4 * agg_value245;
/* 3103 */
/* 3104 */               }
/* 3105 */
/* 3106 */             }
/* 3107 */             agg_isNull218 = agg_isNull219;
/* 3108 */             agg_value242 = agg_value243;
/* 3109 */           }
/* 3110 */
/* 3111 */           else {
/* 3112 */             agg_isNull218 = false;
/* 3113 */             agg_value242 = 0.0D;
/* 3114 */           }
/* 3115 */           if (!agg_isNull218) {
/* 3116 */             agg_isNull213 = false; // resultCode could change nullability.
/* 3117 */             agg_value237 = agg_value238 + agg_value242;
/* 3118 */
/* 3119 */           }
/* 3120 */           boolean agg_isNull212 = agg_isNull213;
/* 3121 */           double agg_value236 = agg_value237;
/* 3122 */           if (agg_isNull212) {
/* 3123 */             boolean agg_isNull224 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 3124 */             double agg_value248 = agg_isNull224 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 3125 */             if (!agg_isNull224) {
/* 3126 */               agg_isNull212 = false;
/* 3127 */               agg_value236 = agg_value248;
/* 3128 */             }
/* 3129 */           }
/* 3130 */           boolean agg_isNull226 = true;
/* 3131 */           double agg_value250 = -1.0;
/* 3132 */
/* 3133 */           boolean agg_isNull228 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 3134 */           double agg_value252 = agg_isNull228 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 3135 */           boolean agg_isNull227 = agg_isNull228;
/* 3136 */           double agg_value251 = agg_value252;
/* 3137 */           if (agg_isNull227) {
/* 3138 */             boolean agg_isNull229 = false;
/* 3139 */             double agg_value253 = -1.0;
/* 3140 */             if (!false) {
/* 3141 */               agg_value253 = (double) 0;
/* 3142 */             }
/* 3143 */             if (!agg_isNull229) {
/* 3144 */               agg_isNull227 = false;
/* 3145 */               agg_value251 = agg_value253;
/* 3146 */             }
/* 3147 */           }
/* 3148 */
/* 3149 */           boolean agg_isNull231 = true;
/* 3150 */           double agg_value255 = -1.0;
/* 3151 */
/* 3152 */           if (!agg_isNull67 && agg_value91) {
/* 3153 */             boolean agg_isNull232 = true;
/* 3154 */             double agg_value256 = -1.0;
/* 3155 */
/* 3156 */             if (!scan_isNull4) {
/* 3157 */               boolean agg_isNull234 = scan_isNull3;
/* 3158 */               double agg_value258 = -1.0;
/* 3159 */               if (!scan_isNull3) {
/* 3160 */                 agg_value258 = (double) scan_value3;
/* 3161 */               }
/* 3162 */               if (!agg_isNull234) {
/* 3163 */                 agg_isNull232 = false; // resultCode could change nullability.
/* 3164 */                 agg_value256 = scan_value4 * agg_value258;
/* 3165 */
/* 3166 */               }
/* 3167 */
/* 3168 */             }
/* 3169 */             agg_isNull231 = agg_isNull232;
/* 3170 */             agg_value255 = agg_value256;
/* 3171 */           }
/* 3172 */
/* 3173 */           else {
/* 3174 */             agg_isNull231 = false;
/* 3175 */             agg_value255 = 0.0D;
/* 3176 */           }
/* 3177 */           if (!agg_isNull231) {
/* 3178 */             agg_isNull226 = false; // resultCode could change nullability.
/* 3179 */             agg_value250 = agg_value251 + agg_value255;
/* 3180 */
/* 3181 */           }
/* 3182 */           boolean agg_isNull225 = agg_isNull226;
/* 3183 */           double agg_value249 = agg_value250;
/* 3184 */           if (agg_isNull225) {
/* 3185 */             boolean agg_isNull237 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 3186 */             double agg_value261 = agg_isNull237 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 3187 */             if (!agg_isNull237) {
/* 3188 */               agg_isNull225 = false;
/* 3189 */               agg_value249 = agg_value261;
/* 3190 */             }
/* 3191 */           }
/* 3192 */           boolean agg_isNull239 = true;
/* 3193 */           double agg_value263 = -1.0;
/* 3194 */
/* 3195 */           boolean agg_isNull241 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 3196 */           double agg_value265 = agg_isNull241 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 3197 */           boolean agg_isNull240 = agg_isNull241;
/* 3198 */           double agg_value264 = agg_value265;
/* 3199 */           if (agg_isNull240) {
/* 3200 */             boolean agg_isNull242 = false;
/* 3201 */             double agg_value266 = -1.0;
/* 3202 */             if (!false) {
/* 3203 */               agg_value266 = (double) 0;
/* 3204 */             }
/* 3205 */             if (!agg_isNull242) {
/* 3206 */               agg_isNull240 = false;
/* 3207 */               agg_value264 = agg_value266;
/* 3208 */             }
/* 3209 */           }
/* 3210 */
/* 3211 */           boolean agg_isNull244 = true;
/* 3212 */           double agg_value268 = -1.0;
/* 3213 */
/* 3214 */           if (!agg_isNull61 && agg_value85) {
/* 3215 */             boolean agg_isNull245 = true;
/* 3216 */             double agg_value269 = -1.0;
/* 3217 */
/* 3218 */             if (!scan_isNull5) {
/* 3219 */               boolean agg_isNull247 = scan_isNull3;
/* 3220 */               double agg_value271 = -1.0;
/* 3221 */               if (!scan_isNull3) {
/* 3222 */                 agg_value271 = (double) scan_value3;
/* 3223 */               }
/* 3224 */               if (!agg_isNull247) {
/* 3225 */                 agg_isNull245 = false; // resultCode could change nullability.
/* 3226 */                 agg_value269 = scan_value5 * agg_value271;
/* 3227 */
/* 3228 */               }
/* 3229 */
/* 3230 */             }
/* 3231 */             agg_isNull244 = agg_isNull245;
/* 3232 */             agg_value268 = agg_value269;
/* 3233 */           }
/* 3234 */
/* 3235 */           else {
/* 3236 */             agg_isNull244 = false;
/* 3237 */             agg_value268 = 0.0D;
/* 3238 */           }
/* 3239 */           if (!agg_isNull244) {
/* 3240 */             agg_isNull239 = false; // resultCode could change nullability.
/* 3241 */             agg_value263 = agg_value264 + agg_value268;
/* 3242 */
/* 3243 */           }
/* 3244 */           boolean agg_isNull238 = agg_isNull239;
/* 3245 */           double agg_value262 = agg_value263;
/* 3246 */           if (agg_isNull238) {
/* 3247 */             boolean agg_isNull250 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 3248 */             double agg_value274 = agg_isNull250 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 3249 */             if (!agg_isNull250) {
/* 3250 */               agg_isNull238 = false;
/* 3251 */               agg_value262 = agg_value274;
/* 3252 */             }
/* 3253 */           }
/* 3254 */           boolean agg_isNull252 = true;
/* 3255 */           double agg_value276 = -1.0;
/* 3256 */
/* 3257 */           boolean agg_isNull254 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 3258 */           double agg_value278 = agg_isNull254 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 3259 */           boolean agg_isNull253 = agg_isNull254;
/* 3260 */           double agg_value277 = agg_value278;
/* 3261 */           if (agg_isNull253) {
/* 3262 */             boolean agg_isNull255 = false;
/* 3263 */             double agg_value279 = -1.0;
/* 3264 */             if (!false) {
/* 3265 */               agg_value279 = (double) 0;
/* 3266 */             }
/* 3267 */             if (!agg_isNull255) {
/* 3268 */               agg_isNull253 = false;
/* 3269 */               agg_value277 = agg_value279;
/* 3270 */             }
/* 3271 */           }
/* 3272 */
/* 3273 */           boolean agg_isNull257 = true;
/* 3274 */           double agg_value281 = -1.0;
/* 3275 */
/* 3276 */           if (!agg_isNull52 && agg_value76) {
/* 3277 */             boolean agg_isNull258 = true;
/* 3278 */             double agg_value282 = -1.0;
/* 3279 */
/* 3280 */             if (!scan_isNull5) {
/* 3281 */               boolean agg_isNull260 = scan_isNull3;
/* 3282 */               double agg_value284 = -1.0;
/* 3283 */               if (!scan_isNull3) {
/* 3284 */                 agg_value284 = (double) scan_value3;
/* 3285 */               }
/* 3286 */               if (!agg_isNull260) {
/* 3287 */                 agg_isNull258 = false; // resultCode could change nullability.
/* 3288 */                 agg_value282 = scan_value5 * agg_value284;
/* 3289 */
/* 3290 */               }
/* 3291 */
/* 3292 */             }
/* 3293 */             agg_isNull257 = agg_isNull258;
/* 3294 */             agg_value281 = agg_value282;
/* 3295 */           }
/* 3296 */
/* 3297 */           else {
/* 3298 */             agg_isNull257 = false;
/* 3299 */             agg_value281 = 0.0D;
/* 3300 */           }
/* 3301 */           if (!agg_isNull257) {
/* 3302 */             agg_isNull252 = false; // resultCode could change nullability.
/* 3303 */             agg_value276 = agg_value277 + agg_value281;
/* 3304 */
/* 3305 */           }
/* 3306 */           boolean agg_isNull251 = agg_isNull252;
/* 3307 */           double agg_value275 = agg_value276;
/* 3308 */           if (agg_isNull251) {
/* 3309 */             boolean agg_isNull263 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 3310 */             double agg_value287 = agg_isNull263 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 3311 */             if (!agg_isNull263) {
/* 3312 */               agg_isNull251 = false;
/* 3313 */               agg_value275 = agg_value287;
/* 3314 */             }
/* 3315 */           }
/* 3316 */           boolean agg_isNull265 = true;
/* 3317 */           double agg_value289 = -1.0;
/* 3318 */
/* 3319 */           boolean agg_isNull267 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 3320 */           double agg_value291 = agg_isNull267 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 3321 */           boolean agg_isNull266 = agg_isNull267;
/* 3322 */           double agg_value290 = agg_value291;
/* 3323 */           if (agg_isNull266) {
/* 3324 */             boolean agg_isNull268 = false;
/* 3325 */             double agg_value292 = -1.0;
/* 3326 */             if (!false) {
/* 3327 */               agg_value292 = (double) 0;
/* 3328 */             }
/* 3329 */             if (!agg_isNull268) {
/* 3330 */               agg_isNull266 = false;
/* 3331 */               agg_value290 = agg_value292;
/* 3332 */             }
/* 3333 */           }
/* 3334 */
/* 3335 */           boolean agg_isNull270 = true;
/* 3336 */           double agg_value294 = -1.0;
/* 3337 */
/* 3338 */           if (!agg_isNull70 && agg_value94) {
/* 3339 */             boolean agg_isNull271 = true;
/* 3340 */             double agg_value295 = -1.0;
/* 3341 */
/* 3342 */             if (!scan_isNull5) {
/* 3343 */               boolean agg_isNull273 = scan_isNull3;
/* 3344 */               double agg_value297 = -1.0;
/* 3345 */               if (!scan_isNull3) {
/* 3346 */                 agg_value297 = (double) scan_value3;
/* 3347 */               }
/* 3348 */               if (!agg_isNull273) {
/* 3349 */                 agg_isNull271 = false; // resultCode could change nullability.
/* 3350 */                 agg_value295 = scan_value5 * agg_value297;
/* 3351 */
/* 3352 */               }
/* 3353 */
/* 3354 */             }
/* 3355 */             agg_isNull270 = agg_isNull271;
/* 3356 */             agg_value294 = agg_value295;
/* 3357 */           }
/* 3358 */
/* 3359 */           else {
/* 3360 */             agg_isNull270 = false;
/* 3361 */             agg_value294 = 0.0D;
/* 3362 */           }
/* 3363 */           if (!agg_isNull270) {
/* 3364 */             agg_isNull265 = false; // resultCode could change nullability.
/* 3365 */             agg_value289 = agg_value290 + agg_value294;
/* 3366 */
/* 3367 */           }
/* 3368 */           boolean agg_isNull264 = agg_isNull265;
/* 3369 */           double agg_value288 = agg_value289;
/* 3370 */           if (agg_isNull264) {
/* 3371 */             boolean agg_isNull276 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 3372 */             double agg_value300 = agg_isNull276 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 3373 */             if (!agg_isNull276) {
/* 3374 */               agg_isNull264 = false;
/* 3375 */               agg_value288 = agg_value300;
/* 3376 */             }
/* 3377 */           }
/* 3378 */           boolean agg_isNull278 = true;
/* 3379 */           double agg_value302 = -1.0;
/* 3380 */
/* 3381 */           boolean agg_isNull280 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 3382 */           double agg_value304 = agg_isNull280 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 3383 */           boolean agg_isNull279 = agg_isNull280;
/* 3384 */           double agg_value303 = agg_value304;
/* 3385 */           if (agg_isNull279) {
/* 3386 */             boolean agg_isNull281 = false;
/* 3387 */             double agg_value305 = -1.0;
/* 3388 */             if (!false) {
/* 3389 */               agg_value305 = (double) 0;
/* 3390 */             }
/* 3391 */             if (!agg_isNull281) {
/* 3392 */               agg_isNull279 = false;
/* 3393 */               agg_value303 = agg_value305;
/* 3394 */             }
/* 3395 */           }
/* 3396 */
/* 3397 */           boolean agg_isNull283 = true;
/* 3398 */           double agg_value307 = -1.0;
/* 3399 */
/* 3400 */           if (!agg_isNull76 && agg_value100) {
/* 3401 */             boolean agg_isNull284 = true;
/* 3402 */             double agg_value308 = -1.0;
/* 3403 */
/* 3404 */             if (!scan_isNull5) {
/* 3405 */               boolean agg_isNull286 = scan_isNull3;
/* 3406 */               double agg_value310 = -1.0;
/* 3407 */               if (!scan_isNull3) {
/* 3408 */                 agg_value310 = (double) scan_value3;
/* 3409 */               }
/* 3410 */               if (!agg_isNull286) {
/* 3411 */                 agg_isNull284 = false; // resultCode could change nullability.
/* 3412 */                 agg_value308 = scan_value5 * agg_value310;
/* 3413 */
/* 3414 */               }
/* 3415 */
/* 3416 */             }
/* 3417 */             agg_isNull283 = agg_isNull284;
/* 3418 */             agg_value307 = agg_value308;
/* 3419 */           }
/* 3420 */
/* 3421 */           else {
/* 3422 */             agg_isNull283 = false;
/* 3423 */             agg_value307 = 0.0D;
/* 3424 */           }
/* 3425 */           if (!agg_isNull283) {
/* 3426 */             agg_isNull278 = false; // resultCode could change nullability.
/* 3427 */             agg_value302 = agg_value303 + agg_value307;
/* 3428 */
/* 3429 */           }
/* 3430 */           boolean agg_isNull277 = agg_isNull278;
/* 3431 */           double agg_value301 = agg_value302;
/* 3432 */           if (agg_isNull277) {
/* 3433 */             boolean agg_isNull289 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 3434 */             double agg_value313 = agg_isNull289 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 3435 */             if (!agg_isNull289) {
/* 3436 */               agg_isNull277 = false;
/* 3437 */               agg_value301 = agg_value313;
/* 3438 */             }
/* 3439 */           }
/* 3440 */           boolean agg_isNull291 = true;
/* 3441 */           double agg_value315 = -1.0;
/* 3442 */
/* 3443 */           boolean agg_isNull293 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 3444 */           double agg_value317 = agg_isNull293 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 3445 */           boolean agg_isNull292 = agg_isNull293;
/* 3446 */           double agg_value316 = agg_value317;
/* 3447 */           if (agg_isNull292) {
/* 3448 */             boolean agg_isNull294 = false;
/* 3449 */             double agg_value318 = -1.0;
/* 3450 */             if (!false) {
/* 3451 */               agg_value318 = (double) 0;
/* 3452 */             }
/* 3453 */             if (!agg_isNull294) {
/* 3454 */               agg_isNull292 = false;
/* 3455 */               agg_value316 = agg_value318;
/* 3456 */             }
/* 3457 */           }
/* 3458 */
/* 3459 */           boolean agg_isNull296 = true;
/* 3460 */           double agg_value320 = -1.0;
/* 3461 */
/* 3462 */           if (!agg_isNull49 && agg_value73) {
/* 3463 */             boolean agg_isNull297 = true;
/* 3464 */             double agg_value321 = -1.0;
/* 3465 */
/* 3466 */             if (!scan_isNull5) {
/* 3467 */               boolean agg_isNull299 = scan_isNull3;
/* 3468 */               double agg_value323 = -1.0;
/* 3469 */               if (!scan_isNull3) {
/* 3470 */                 agg_value323 = (double) scan_value3;
/* 3471 */               }
/* 3472 */               if (!agg_isNull299) {
/* 3473 */                 agg_isNull297 = false; // resultCode could change nullability.
/* 3474 */                 agg_value321 = scan_value5 * agg_value323;
/* 3475 */
/* 3476 */               }
/* 3477 */
/* 3478 */             }
/* 3479 */             agg_isNull296 = agg_isNull297;
/* 3480 */             agg_value320 = agg_value321;
/* 3481 */           }
/* 3482 */
/* 3483 */           else {
/* 3484 */             agg_isNull296 = false;
/* 3485 */             agg_value320 = 0.0D;
/* 3486 */           }
/* 3487 */           if (!agg_isNull296) {
/* 3488 */             agg_isNull291 = false; // resultCode could change nullability.
/* 3489 */             agg_value315 = agg_value316 + agg_value320;
/* 3490 */
/* 3491 */           }
/* 3492 */           boolean agg_isNull290 = agg_isNull291;
/* 3493 */           double agg_value314 = agg_value315;
/* 3494 */           if (agg_isNull290) {
/* 3495 */             boolean agg_isNull302 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 3496 */             double agg_value326 = agg_isNull302 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 3497 */             if (!agg_isNull302) {
/* 3498 */               agg_isNull290 = false;
/* 3499 */               agg_value314 = agg_value326;
/* 3500 */             }
/* 3501 */           }
/* 3502 */           boolean agg_isNull304 = true;
/* 3503 */           double agg_value328 = -1.0;
/* 3504 */
/* 3505 */           boolean agg_isNull306 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 3506 */           double agg_value330 = agg_isNull306 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 3507 */           boolean agg_isNull305 = agg_isNull306;
/* 3508 */           double agg_value329 = agg_value330;
/* 3509 */           if (agg_isNull305) {
/* 3510 */             boolean agg_isNull307 = false;
/* 3511 */             double agg_value331 = -1.0;
/* 3512 */             if (!false) {
/* 3513 */               agg_value331 = (double) 0;
/* 3514 */             }
/* 3515 */             if (!agg_isNull307) {
/* 3516 */               agg_isNull305 = false;
/* 3517 */               agg_value329 = agg_value331;
/* 3518 */             }
/* 3519 */           }
/* 3520 */
/* 3521 */           boolean agg_isNull309 = true;
/* 3522 */           double agg_value333 = -1.0;
/* 3523 */
/* 3524 */           if (!agg_isNull58 && agg_value82) {
/* 3525 */             boolean agg_isNull310 = true;
/* 3526 */             double agg_value334 = -1.0;
/* 3527 */
/* 3528 */             if (!scan_isNull5) {
/* 3529 */               boolean agg_isNull312 = scan_isNull3;
/* 3530 */               double agg_value336 = -1.0;
/* 3531 */               if (!scan_isNull3) {
/* 3532 */                 agg_value336 = (double) scan_value3;
/* 3533 */               }
/* 3534 */               if (!agg_isNull312) {
/* 3535 */                 agg_isNull310 = false; // resultCode could change nullability.
/* 3536 */                 agg_value334 = scan_value5 * agg_value336;
/* 3537 */
/* 3538 */               }
/* 3539 */
/* 3540 */             }
/* 3541 */             agg_isNull309 = agg_isNull310;
/* 3542 */             agg_value333 = agg_value334;
/* 3543 */           }
/* 3544 */
/* 3545 */           else {
/* 3546 */             agg_isNull309 = false;
/* 3547 */             agg_value333 = 0.0D;
/* 3548 */           }
/* 3549 */           if (!agg_isNull309) {
/* 3550 */             agg_isNull304 = false; // resultCode could change nullability.
/* 3551 */             agg_value328 = agg_value329 + agg_value333;
/* 3552 */
/* 3553 */           }
/* 3554 */           boolean agg_isNull303 = agg_isNull304;
/* 3555 */           double agg_value327 = agg_value328;
/* 3556 */           if (agg_isNull303) {
/* 3557 */             boolean agg_isNull315 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 3558 */             double agg_value339 = agg_isNull315 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 3559 */             if (!agg_isNull315) {
/* 3560 */               agg_isNull303 = false;
/* 3561 */               agg_value327 = agg_value339;
/* 3562 */             }
/* 3563 */           }
/* 3564 */           boolean agg_isNull317 = true;
/* 3565 */           double agg_value341 = -1.0;
/* 3566 */
/* 3567 */           boolean agg_isNull319 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 3568 */           double agg_value343 = agg_isNull319 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 3569 */           boolean agg_isNull318 = agg_isNull319;
/* 3570 */           double agg_value342 = agg_value343;
/* 3571 */           if (agg_isNull318) {
/* 3572 */             boolean agg_isNull320 = false;
/* 3573 */             double agg_value344 = -1.0;
/* 3574 */             if (!false) {
/* 3575 */               agg_value344 = (double) 0;
/* 3576 */             }
/* 3577 */             if (!agg_isNull320) {
/* 3578 */               agg_isNull318 = false;
/* 3579 */               agg_value342 = agg_value344;
/* 3580 */             }
/* 3581 */           }
/* 3582 */
/* 3583 */           boolean agg_isNull322 = true;
/* 3584 */           double agg_value346 = -1.0;
/* 3585 */
/* 3586 */           if (!agg_isNull64 && agg_value88) {
/* 3587 */             boolean agg_isNull323 = true;
/* 3588 */             double agg_value347 = -1.0;
/* 3589 */
/* 3590 */             if (!scan_isNull5) {
/* 3591 */               boolean agg_isNull325 = scan_isNull3;
/* 3592 */               double agg_value349 = -1.0;
/* 3593 */               if (!scan_isNull3) {
/* 3594 */                 agg_value349 = (double) scan_value3;
/* 3595 */               }
/* 3596 */               if (!agg_isNull325) {
/* 3597 */                 agg_isNull323 = false; // resultCode could change nullability.
/* 3598 */                 agg_value347 = scan_value5 * agg_value349;
/* 3599 */
/* 3600 */               }
/* 3601 */
/* 3602 */             }
/* 3603 */             agg_isNull322 = agg_isNull323;
/* 3604 */             agg_value346 = agg_value347;
/* 3605 */           }
/* 3606 */
/* 3607 */           else {
/* 3608 */             agg_isNull322 = false;
/* 3609 */             agg_value346 = 0.0D;
/* 3610 */           }
/* 3611 */           if (!agg_isNull322) {
/* 3612 */             agg_isNull317 = false; // resultCode could change nullability.
/* 3613 */             agg_value341 = agg_value342 + agg_value346;
/* 3614 */
/* 3615 */           }
/* 3616 */           boolean agg_isNull316 = agg_isNull317;
/* 3617 */           double agg_value340 = agg_value341;
/* 3618 */           if (agg_isNull316) {
/* 3619 */             boolean agg_isNull328 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 3620 */             double agg_value352 = agg_isNull328 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 3621 */             if (!agg_isNull328) {
/* 3622 */               agg_isNull316 = false;
/* 3623 */               agg_value340 = agg_value352;
/* 3624 */             }
/* 3625 */           }
/* 3626 */           boolean agg_isNull330 = true;
/* 3627 */           double agg_value354 = -1.0;
/* 3628 */
/* 3629 */           boolean agg_isNull332 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 3630 */           double agg_value356 = agg_isNull332 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 3631 */           boolean agg_isNull331 = agg_isNull332;
/* 3632 */           double agg_value355 = agg_value356;
/* 3633 */           if (agg_isNull331) {
/* 3634 */             boolean agg_isNull333 = false;
/* 3635 */             double agg_value357 = -1.0;
/* 3636 */             if (!false) {
/* 3637 */               agg_value357 = (double) 0;
/* 3638 */             }
/* 3639 */             if (!agg_isNull333) {
/* 3640 */               agg_isNull331 = false;
/* 3641 */               agg_value355 = agg_value357;
/* 3642 */             }
/* 3643 */           }
/* 3644 */
/* 3645 */           boolean agg_isNull335 = true;
/* 3646 */           double agg_value359 = -1.0;
/* 3647 */
/* 3648 */           if (!agg_isNull46 && agg_value70) {
/* 3649 */             boolean agg_isNull336 = true;
/* 3650 */             double agg_value360 = -1.0;
/* 3651 */
/* 3652 */             if (!scan_isNull5) {
/* 3653 */               boolean agg_isNull338 = scan_isNull3;
/* 3654 */               double agg_value362 = -1.0;
/* 3655 */               if (!scan_isNull3) {
/* 3656 */                 agg_value362 = (double) scan_value3;
/* 3657 */               }
/* 3658 */               if (!agg_isNull338) {
/* 3659 */                 agg_isNull336 = false; // resultCode could change nullability.
/* 3660 */                 agg_value360 = scan_value5 * agg_value362;
/* 3661 */
/* 3662 */               }
/* 3663 */
/* 3664 */             }
/* 3665 */             agg_isNull335 = agg_isNull336;
/* 3666 */             agg_value359 = agg_value360;
/* 3667 */           }
/* 3668 */
/* 3669 */           else {
/* 3670 */             agg_isNull335 = false;
/* 3671 */             agg_value359 = 0.0D;
/* 3672 */           }
/* 3673 */           if (!agg_isNull335) {
/* 3674 */             agg_isNull330 = false; // resultCode could change nullability.
/* 3675 */             agg_value354 = agg_value355 + agg_value359;
/* 3676 */
/* 3677 */           }
/* 3678 */           boolean agg_isNull329 = agg_isNull330;
/* 3679 */           double agg_value353 = agg_value354;
/* 3680 */           if (agg_isNull329) {
/* 3681 */             boolean agg_isNull341 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 3682 */             double agg_value365 = agg_isNull341 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 3683 */             if (!agg_isNull341) {
/* 3684 */               agg_isNull329 = false;
/* 3685 */               agg_value353 = agg_value365;
/* 3686 */             }
/* 3687 */           }
/* 3688 */           boolean agg_isNull343 = true;
/* 3689 */           double agg_value367 = -1.0;
/* 3690 */
/* 3691 */           boolean agg_isNull345 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 3692 */           double agg_value369 = agg_isNull345 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 3693 */           boolean agg_isNull344 = agg_isNull345;
/* 3694 */           double agg_value368 = agg_value369;
/* 3695 */           if (agg_isNull344) {
/* 3696 */             boolean agg_isNull346 = false;
/* 3697 */             double agg_value370 = -1.0;
/* 3698 */             if (!false) {
/* 3699 */               agg_value370 = (double) 0;
/* 3700 */             }
/* 3701 */             if (!agg_isNull346) {
/* 3702 */               agg_isNull344 = false;
/* 3703 */               agg_value368 = agg_value370;
/* 3704 */             }
/* 3705 */           }
/* 3706 */
/* 3707 */           boolean agg_isNull348 = true;
/* 3708 */           double agg_value372 = -1.0;
/* 3709 */
/* 3710 */           if (!agg_isNull55 && agg_value79) {
/* 3711 */             boolean agg_isNull349 = true;
/* 3712 */             double agg_value373 = -1.0;
/* 3713 */
/* 3714 */             if (!scan_isNull5) {
/* 3715 */               boolean agg_isNull351 = scan_isNull3;
/* 3716 */               double agg_value375 = -1.0;
/* 3717 */               if (!scan_isNull3) {
/* 3718 */                 agg_value375 = (double) scan_value3;
/* 3719 */               }
/* 3720 */               if (!agg_isNull351) {
/* 3721 */                 agg_isNull349 = false; // resultCode could change nullability.
/* 3722 */                 agg_value373 = scan_value5 * agg_value375;
/* 3723 */
/* 3724 */               }
/* 3725 */
/* 3726 */             }
/* 3727 */             agg_isNull348 = agg_isNull349;
/* 3728 */             agg_value372 = agg_value373;
/* 3729 */           }
/* 3730 */
/* 3731 */           else {
/* 3732 */             agg_isNull348 = false;
/* 3733 */             agg_value372 = 0.0D;
/* 3734 */           }
/* 3735 */           if (!agg_isNull348) {
/* 3736 */             agg_isNull343 = false; // resultCode could change nullability.
/* 3737 */             agg_value367 = agg_value368 + agg_value372;
/* 3738 */
/* 3739 */           }
/* 3740 */           boolean agg_isNull342 = agg_isNull343;
/* 3741 */           double agg_value366 = agg_value367;
/* 3742 */           if (agg_isNull342) {
/* 3743 */             boolean agg_isNull354 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 3744 */             double agg_value378 = agg_isNull354 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 3745 */             if (!agg_isNull354) {
/* 3746 */               agg_isNull342 = false;
/* 3747 */               agg_value366 = agg_value378;
/* 3748 */             }
/* 3749 */           }
/* 3750 */           boolean agg_isNull356 = true;
/* 3751 */           double agg_value380 = -1.0;
/* 3752 */
/* 3753 */           boolean agg_isNull358 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 3754 */           double agg_value382 = agg_isNull358 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 3755 */           boolean agg_isNull357 = agg_isNull358;
/* 3756 */           double agg_value381 = agg_value382;
/* 3757 */           if (agg_isNull357) {
/* 3758 */             boolean agg_isNull359 = false;
/* 3759 */             double agg_value383 = -1.0;
/* 3760 */             if (!false) {
/* 3761 */               agg_value383 = (double) 0;
/* 3762 */             }
/* 3763 */             if (!agg_isNull359) {
/* 3764 */               agg_isNull357 = false;
/* 3765 */               agg_value381 = agg_value383;
/* 3766 */             }
/* 3767 */           }
/* 3768 */
/* 3769 */           boolean agg_isNull361 = true;
/* 3770 */           double agg_value385 = -1.0;
/* 3771 */
/* 3772 */           if (!agg_isNull79 && agg_value103) {
/* 3773 */             boolean agg_isNull362 = true;
/* 3774 */             double agg_value386 = -1.0;
/* 3775 */
/* 3776 */             if (!scan_isNull5) {
/* 3777 */               boolean agg_isNull364 = scan_isNull3;
/* 3778 */               double agg_value388 = -1.0;
/* 3779 */               if (!scan_isNull3) {
/* 3780 */                 agg_value388 = (double) scan_value3;
/* 3781 */               }
/* 3782 */               if (!agg_isNull364) {
/* 3783 */                 agg_isNull362 = false; // resultCode could change nullability.
/* 3784 */                 agg_value386 = scan_value5 * agg_value388;
/* 3785 */
/* 3786 */               }
/* 3787 */
/* 3788 */             }
/* 3789 */             agg_isNull361 = agg_isNull362;
/* 3790 */             agg_value385 = agg_value386;
/* 3791 */           }
/* 3792 */
/* 3793 */           else {
/* 3794 */             agg_isNull361 = false;
/* 3795 */             agg_value385 = 0.0D;
/* 3796 */           }
/* 3797 */           if (!agg_isNull361) {
/* 3798 */             agg_isNull356 = false; // resultCode could change nullability.
/* 3799 */             agg_value380 = agg_value381 + agg_value385;
/* 3800 */
/* 3801 */           }
/* 3802 */           boolean agg_isNull355 = agg_isNull356;
/* 3803 */           double agg_value379 = agg_value380;
/* 3804 */           if (agg_isNull355) {
/* 3805 */             boolean agg_isNull367 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 3806 */             double agg_value391 = agg_isNull367 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 3807 */             if (!agg_isNull367) {
/* 3808 */               agg_isNull355 = false;
/* 3809 */               agg_value379 = agg_value391;
/* 3810 */             }
/* 3811 */           }
/* 3812 */           boolean agg_isNull369 = true;
/* 3813 */           double agg_value393 = -1.0;
/* 3814 */
/* 3815 */           boolean agg_isNull371 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 3816 */           double agg_value395 = agg_isNull371 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 3817 */           boolean agg_isNull370 = agg_isNull371;
/* 3818 */           double agg_value394 = agg_value395;
/* 3819 */           if (agg_isNull370) {
/* 3820 */             boolean agg_isNull372 = false;
/* 3821 */             double agg_value396 = -1.0;
/* 3822 */             if (!false) {
/* 3823 */               agg_value396 = (double) 0;
/* 3824 */             }
/* 3825 */             if (!agg_isNull372) {
/* 3826 */               agg_isNull370 = false;
/* 3827 */               agg_value394 = agg_value396;
/* 3828 */             }
/* 3829 */           }
/* 3830 */
/* 3831 */           boolean agg_isNull374 = true;
/* 3832 */           double agg_value398 = -1.0;
/* 3833 */
/* 3834 */           if (!agg_isNull73 && agg_value97) {
/* 3835 */             boolean agg_isNull375 = true;
/* 3836 */             double agg_value399 = -1.0;
/* 3837 */
/* 3838 */             if (!scan_isNull5) {
/* 3839 */               boolean agg_isNull377 = scan_isNull3;
/* 3840 */               double agg_value401 = -1.0;
/* 3841 */               if (!scan_isNull3) {
/* 3842 */                 agg_value401 = (double) scan_value3;
/* 3843 */               }
/* 3844 */               if (!agg_isNull377) {
/* 3845 */                 agg_isNull375 = false; // resultCode could change nullability.
/* 3846 */                 agg_value399 = scan_value5 * agg_value401;
/* 3847 */
/* 3848 */               }
/* 3849 */
/* 3850 */             }
/* 3851 */             agg_isNull374 = agg_isNull375;
/* 3852 */             agg_value398 = agg_value399;
/* 3853 */           }
/* 3854 */
/* 3855 */           else {
/* 3856 */             agg_isNull374 = false;
/* 3857 */             agg_value398 = 0.0D;
/* 3858 */           }
/* 3859 */           if (!agg_isNull374) {
/* 3860 */             agg_isNull369 = false; // resultCode could change nullability.
/* 3861 */             agg_value393 = agg_value394 + agg_value398;
/* 3862 */
/* 3863 */           }
/* 3864 */           boolean agg_isNull368 = agg_isNull369;
/* 3865 */           double agg_value392 = agg_value393;
/* 3866 */           if (agg_isNull368) {
/* 3867 */             boolean agg_isNull380 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 3868 */             double agg_value404 = agg_isNull380 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 3869 */             if (!agg_isNull380) {
/* 3870 */               agg_isNull368 = false;
/* 3871 */               agg_value392 = agg_value404;
/* 3872 */             }
/* 3873 */           }
/* 3874 */           boolean agg_isNull382 = true;
/* 3875 */           double agg_value406 = -1.0;
/* 3876 */
/* 3877 */           boolean agg_isNull384 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 3878 */           double agg_value408 = agg_isNull384 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 3879 */           boolean agg_isNull383 = agg_isNull384;
/* 3880 */           double agg_value407 = agg_value408;
/* 3881 */           if (agg_isNull383) {
/* 3882 */             boolean agg_isNull385 = false;
/* 3883 */             double agg_value409 = -1.0;
/* 3884 */             if (!false) {
/* 3885 */               agg_value409 = (double) 0;
/* 3886 */             }
/* 3887 */             if (!agg_isNull385) {
/* 3888 */               agg_isNull383 = false;
/* 3889 */               agg_value407 = agg_value409;
/* 3890 */             }
/* 3891 */           }
/* 3892 */
/* 3893 */           boolean agg_isNull387 = true;
/* 3894 */           double agg_value411 = -1.0;
/* 3895 */
/* 3896 */           if (!agg_isNull67 && agg_value91) {
/* 3897 */             boolean agg_isNull388 = true;
/* 3898 */             double agg_value412 = -1.0;
/* 3899 */
/* 3900 */             if (!scan_isNull5) {
/* 3901 */               boolean agg_isNull390 = scan_isNull3;
/* 3902 */               double agg_value414 = -1.0;
/* 3903 */               if (!scan_isNull3) {
/* 3904 */                 agg_value414 = (double) scan_value3;
/* 3905 */               }
/* 3906 */               if (!agg_isNull390) {
/* 3907 */                 agg_isNull388 = false; // resultCode could change nullability.
/* 3908 */                 agg_value412 = scan_value5 * agg_value414;
/* 3909 */
/* 3910 */               }
/* 3911 */
/* 3912 */             }
/* 3913 */             agg_isNull387 = agg_isNull388;
/* 3914 */             agg_value411 = agg_value412;
/* 3915 */           }
/* 3916 */
/* 3917 */           else {
/* 3918 */             agg_isNull387 = false;
/* 3919 */             agg_value411 = 0.0D;
/* 3920 */           }
/* 3921 */           if (!agg_isNull387) {
/* 3922 */             agg_isNull382 = false; // resultCode could change nullability.
/* 3923 */             agg_value406 = agg_value407 + agg_value411;
/* 3924 */
/* 3925 */           }
/* 3926 */           boolean agg_isNull381 = agg_isNull382;
/* 3927 */           double agg_value405 = agg_value406;
/* 3928 */           if (agg_isNull381) {
/* 3929 */             boolean agg_isNull393 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 3930 */             double agg_value417 = agg_isNull393 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 3931 */             if (!agg_isNull393) {
/* 3932 */               agg_isNull381 = false;
/* 3933 */               agg_value405 = agg_value417;
/* 3934 */             }
/* 3935 */           }
/* 3936 */           // update unsafe row buffer
/* 3937 */           if (!agg_isNull82) {
/* 3938 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value106);
/* 3939 */           } else {
/* 3940 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 3941 */           }
/* 3942 */
/* 3943 */           if (!agg_isNull95) {
/* 3944 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value119);
/* 3945 */           } else {
/* 3946 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 3947 */           }
/* 3948 */
/* 3949 */           if (!agg_isNull108) {
/* 3950 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value132);
/* 3951 */           } else {
/* 3952 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 3953 */           }
/* 3954 */
/* 3955 */           if (!agg_isNull121) {
/* 3956 */             agg_unsafeRowAggBuffer.setDouble(3, agg_value145);
/* 3957 */           } else {
/* 3958 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 3959 */           }
/* 3960 */
/* 3961 */           if (!agg_isNull134) {
/* 3962 */             agg_unsafeRowAggBuffer.setDouble(4, agg_value158);
/* 3963 */           } else {
/* 3964 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 3965 */           }
/* 3966 */
/* 3967 */           if (!agg_isNull147) {
/* 3968 */             agg_unsafeRowAggBuffer.setDouble(5, agg_value171);
/* 3969 */           } else {
/* 3970 */             agg_unsafeRowAggBuffer.setNullAt(5);
/* 3971 */           }
/* 3972 */
/* 3973 */           if (!agg_isNull160) {
/* 3974 */             agg_unsafeRowAggBuffer.setDouble(6, agg_value184);
/* 3975 */           } else {
/* 3976 */             agg_unsafeRowAggBuffer.setNullAt(6);
/* 3977 */           }
/* 3978 */
/* 3979 */           if (!agg_isNull173) {
/* 3980 */             agg_unsafeRowAggBuffer.setDouble(7, agg_value197);
/* 3981 */           } else {
/* 3982 */             agg_unsafeRowAggBuffer.setNullAt(7);
/* 3983 */           }
/* 3984 */
/* 3985 */           if (!agg_isNull186) {
/* 3986 */             agg_unsafeRowAggBuffer.setDouble(8, agg_value210);
/* 3987 */           } else {
/* 3988 */             agg_unsafeRowAggBuffer.setNullAt(8);
/* 3989 */           }
/* 3990 */
/* 3991 */           if (!agg_isNull199) {
/* 3992 */             agg_unsafeRowAggBuffer.setDouble(9, agg_value223);
/* 3993 */           } else {
/* 3994 */             agg_unsafeRowAggBuffer.setNullAt(9);
/* 3995 */           }
/* 3996 */
/* 3997 */           if (!agg_isNull212) {
/* 3998 */             agg_unsafeRowAggBuffer.setDouble(10, agg_value236);
/* 3999 */           } else {
/* 4000 */             agg_unsafeRowAggBuffer.setNullAt(10);
/* 4001 */           }
/* 4002 */
/* 4003 */           if (!agg_isNull225) {
/* 4004 */             agg_unsafeRowAggBuffer.setDouble(11, agg_value249);
/* 4005 */           } else {
/* 4006 */             agg_unsafeRowAggBuffer.setNullAt(11);
/* 4007 */           }
/* 4008 */
/* 4009 */           if (!agg_isNull238) {
/* 4010 */             agg_unsafeRowAggBuffer.setDouble(12, agg_value262);
/* 4011 */           } else {
/* 4012 */             agg_unsafeRowAggBuffer.setNullAt(12);
/* 4013 */           }
/* 4014 */
/* 4015 */           if (!agg_isNull251) {
/* 4016 */             agg_unsafeRowAggBuffer.setDouble(13, agg_value275);
/* 4017 */           } else {
/* 4018 */             agg_unsafeRowAggBuffer.setNullAt(13);
/* 4019 */           }
/* 4020 */
/* 4021 */           if (!agg_isNull264) {
/* 4022 */             agg_unsafeRowAggBuffer.setDouble(14, agg_value288);
/* 4023 */           } else {
/* 4024 */             agg_unsafeRowAggBuffer.setNullAt(14);
/* 4025 */           }
/* 4026 */
/* 4027 */           if (!agg_isNull277) {
/* 4028 */             agg_unsafeRowAggBuffer.setDouble(15, agg_value301);
/* 4029 */           } else {
/* 4030 */             agg_unsafeRowAggBuffer.setNullAt(15);
/* 4031 */           }
/* 4032 */
/* 4033 */           if (!agg_isNull290) {
/* 4034 */             agg_unsafeRowAggBuffer.setDouble(16, agg_value314);
/* 4035 */           } else {
/* 4036 */             agg_unsafeRowAggBuffer.setNullAt(16);
/* 4037 */           }
/* 4038 */
/* 4039 */           if (!agg_isNull303) {
/* 4040 */             agg_unsafeRowAggBuffer.setDouble(17, agg_value327);
/* 4041 */           } else {
/* 4042 */             agg_unsafeRowAggBuffer.setNullAt(17);
/* 4043 */           }
/* 4044 */
/* 4045 */           if (!agg_isNull316) {
/* 4046 */             agg_unsafeRowAggBuffer.setDouble(18, agg_value340);
/* 4047 */           } else {
/* 4048 */             agg_unsafeRowAggBuffer.setNullAt(18);
/* 4049 */           }
/* 4050 */
/* 4051 */           if (!agg_isNull329) {
/* 4052 */             agg_unsafeRowAggBuffer.setDouble(19, agg_value353);
/* 4053 */           } else {
/* 4054 */             agg_unsafeRowAggBuffer.setNullAt(19);
/* 4055 */           }
/* 4056 */
/* 4057 */           if (!agg_isNull342) {
/* 4058 */             agg_unsafeRowAggBuffer.setDouble(20, agg_value366);
/* 4059 */           } else {
/* 4060 */             agg_unsafeRowAggBuffer.setNullAt(20);
/* 4061 */           }
/* 4062 */
/* 4063 */           if (!agg_isNull355) {
/* 4064 */             agg_unsafeRowAggBuffer.setDouble(21, agg_value379);
/* 4065 */           } else {
/* 4066 */             agg_unsafeRowAggBuffer.setNullAt(21);
/* 4067 */           }
/* 4068 */
/* 4069 */           if (!agg_isNull368) {
/* 4070 */             agg_unsafeRowAggBuffer.setDouble(22, agg_value392);
/* 4071 */           } else {
/* 4072 */             agg_unsafeRowAggBuffer.setNullAt(22);
/* 4073 */           }
/* 4074 */
/* 4075 */           if (!agg_isNull381) {
/* 4076 */             agg_unsafeRowAggBuffer.setDouble(23, agg_value405);
/* 4077 */           } else {
/* 4078 */             agg_unsafeRowAggBuffer.setNullAt(23);
/* 4079 */           }
/* 4080 */
/* 4081 */         }
/* 4082 */         // shouldStop check is eliminated
/* 4083 */       }
/* 4084 */       scan_batchIdx = scan_numRows;
/* 4085 */       scan_batch = null;
/* 4086 */       scan_nextBatch();
/* 4087 */     }
/* 4088 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 4089 */     scan_scanTime1 = 0;
/* 4090 */
/* 4091 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 4092 */
/* 4093 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 4094 */   }
/* 4095 */
/* 4096 */   private void wholestagecodegen_init_5() {
/* 4097 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result7, 160);
/* 4098 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 7);
/* 4099 */
/* 4100 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 4101 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[45];
/* 4102 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[46];
/* 4103 */
/* 4104 */   }
/* 4105 */
/* 4106 */   private void wholestagecodegen_init_2() {
/* 4107 */     bhj_result = new UnsafeRow(14);
/* 4108 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 160);
/* 4109 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 14);
/* 4110 */     project_result1 = new UnsafeRow(12);
/* 4111 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 160);
/* 4112 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 12);
/* 4113 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[39];
/* 4114 */
/* 4115 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 4116 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 4117 */
/* 4118 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[40];
/* 4119 */     bhj_result1 = new UnsafeRow(15);
/* 4120 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 160);
/* 4121 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 15);
/* 4122 */
/* 4123 */   }
/* 4124 */
/* 4125 */   private void wholestagecodegen_init_1() {
/* 4126 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 7);
/* 4127 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[36];
/* 4128 */     filter_result = new UnsafeRow(7);
/* 4129 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 4130 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 4131 */     project_result = new UnsafeRow(7);
/* 4132 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 4133 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 4134 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[37];
/* 4135 */
/* 4136 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 4137 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 4138 */
/* 4139 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[38];
/* 4140 */
/* 4141 */   }
/* 4142 */
/* 4143 */   private void wholestagecodegen_init_4() {
/* 4144 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 12);
/* 4145 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[43];
/* 4146 */
/* 4147 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 4148 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 4149 */
/* 4150 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[44];
/* 4151 */     bhj_result3 = new UnsafeRow(13);
/* 4152 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 160);
/* 4153 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 13);
/* 4154 */     project_result4 = new UnsafeRow(11);
/* 4155 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 160);
/* 4156 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 11);
/* 4157 */     agg_result7 = new UnsafeRow(7);
/* 4158 */
/* 4159 */   }
/* 4160 */
/* 4161 */   protected void processNext() throws java.io.IOException {
/* 4162 */     if (!agg_initAgg) {
/* 4163 */       agg_initAgg = true;
/* 4164 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 4165 */       agg_doAggregateWithKeys();
/* 4166 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 4167 */     }
/* 4168 */
/* 4169 */     // output the result
/* 4170 */
/* 4171 */     while (agg_fastHashMapIter.next()) {
/* 4172 */       wholestagecodegen_numOutputRows.add(1);
/* 4173 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 4174 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 4175 */
/* 4176 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 4177 */
/* 4178 */       append(agg_resultRow);
/* 4179 */
/* 4180 */       if (shouldStop()) return;
/* 4181 */     }
/* 4182 */     agg_fastHashMap.close();
/* 4183 */
/* 4184 */     while (agg_mapIter.next()) {
/* 4185 */       wholestagecodegen_numOutputRows.add(1);
/* 4186 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 4187 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 4188 */
/* 4189 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 4190 */
/* 4191 */       append(agg_resultRow);
/* 4192 */
/* 4193 */       if (shouldStop()) return;
/* 4194 */     }
/* 4195 */
/* 4196 */     agg_mapIter.close();
/* 4197 */     if (agg_sorter == null) {
/* 4198 */       agg_hashMap.free();
/* 4199 */     }
/* 4200 */   }
/* 4201 */ }
