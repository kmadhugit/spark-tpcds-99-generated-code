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
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
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
/* 030 */   private long agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private long agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private double agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private long agg_bufValue13;
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
/* 052 */   private long agg_bufValue21;
/* 053 */   private boolean agg_bufIsNull22;
/* 054 */   private long agg_bufValue22;
/* 055 */   private boolean agg_bufIsNull23;
/* 056 */   private double agg_bufValue23;
/* 057 */   private boolean agg_bufIsNull24;
/* 058 */   private long agg_bufValue24;
/* 059 */   private boolean agg_bufIsNull25;
/* 060 */   private double agg_bufValue25;
/* 061 */   private boolean agg_bufIsNull26;
/* 062 */   private double agg_bufValue26;
/* 063 */   private boolean agg_bufIsNull27;
/* 064 */   private double agg_bufValue27;
/* 065 */   private boolean agg_bufIsNull28;
/* 066 */   private double agg_bufValue28;
/* 067 */   private boolean agg_bufIsNull29;
/* 068 */   private long agg_bufValue29;
/* 069 */   private boolean agg_bufIsNull30;
/* 070 */   private double agg_bufValue30;
/* 071 */   private boolean agg_bufIsNull31;
/* 072 */   private double agg_bufValue31;
/* 073 */   private boolean agg_bufIsNull32;
/* 074 */   private double agg_bufValue32;
/* 075 */   private boolean agg_bufIsNull33;
/* 076 */   private double agg_bufValue33;
/* 077 */   private boolean agg_bufIsNull34;
/* 078 */   private long agg_bufValue34;
/* 079 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 080 */   private agg_FastHashMap agg_fastHashMap;
/* 081 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 082 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 083 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 084 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 085 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 087 */   private scala.collection.Iterator smj_leftInput;
/* 088 */   private scala.collection.Iterator smj_rightInput;
/* 089 */   private InternalRow smj_leftRow;
/* 090 */   private InternalRow smj_rightRow;
/* 091 */   private long smj_value6;
/* 092 */   private long smj_value7;
/* 093 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 094 */   private long smj_value8;
/* 095 */   private long smj_value9;
/* 096 */   private int smj_value10;
/* 097 */   private boolean smj_isNull6;
/* 098 */   private int smj_value11;
/* 099 */   private boolean smj_isNull7;
/* 100 */   private int smj_value12;
/* 101 */   private boolean smj_isNull8;
/* 102 */   private int smj_value13;
/* 103 */   private boolean smj_isNull9;
/* 104 */   private long smj_value14;
/* 105 */   private boolean smj_isNull10;
/* 106 */   private long smj_value15;
/* 107 */   private boolean smj_isNull11;
/* 108 */   private long smj_value16;
/* 109 */   private boolean smj_isNull12;
/* 110 */   private int smj_value17;
/* 111 */   private boolean smj_isNull13;
/* 112 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 113 */   private UnsafeRow smj_result;
/* 114 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 115 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 116 */   private UnsafeRow project_result;
/* 117 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 118 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 119 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 120 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 121 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 122 */   private UnsafeRow bhj_result;
/* 123 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 124 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 125 */   private UnsafeRow project_result1;
/* 126 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 127 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 128 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 129 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 130 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 131 */   private UnsafeRow bhj_result1;
/* 132 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 133 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 134 */   private UnsafeRow project_result2;
/* 135 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 136 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 137 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 138 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 139 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 140 */   private UnsafeRow bhj_result2;
/* 141 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 142 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 143 */   private UnsafeRow project_result3;
/* 144 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 145 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 146 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 147 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 148 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 149 */   private UnsafeRow bhj_result3;
/* 150 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 151 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 152 */   private UnsafeRow project_result4;
/* 153 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 154 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 155 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 156 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 157 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 158 */   private UnsafeRow bhj_result4;
/* 159 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 160 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 161 */   private UnsafeRow project_result5;
/* 162 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 163 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 164 */   private UnsafeRow agg_result3;
/* 165 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 166 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 167 */   private int agg_value83;
/* 168 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 169 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 170 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 171 */
/* 172 */   public GeneratedIterator(Object[] references) {
/* 173 */     this.references = references;
/* 174 */   }
/* 175 */
/* 176 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 177 */     partitionIndex = index;
/* 178 */     this.inputs = inputs;
/* 179 */     wholestagecodegen_init_0();
/* 180 */     wholestagecodegen_init_1();
/* 181 */     wholestagecodegen_init_2();
/* 182 */     wholestagecodegen_init_3();
/* 183 */     wholestagecodegen_init_4();
/* 184 */     wholestagecodegen_init_5();
/* 185 */
/* 186 */   }
/* 187 */
/* 188 */   private void wholestagecodegen_init_0() {
/* 189 */     agg_initAgg = false;
/* 190 */
/* 191 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 192 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 193 */
/* 194 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 195 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 196 */     smj_leftInput = inputs[0];
/* 197 */     smj_rightInput = inputs[1];
/* 198 */
/* 199 */     smj_rightRow = null;
/* 200 */
/* 201 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 202 */
/* 203 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[41];
/* 204 */     smj_result = new UnsafeRow(12);
/* 205 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 206 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 207 */     project_result = new UnsafeRow(8);
/* 208 */
/* 209 */   }
/* 210 */
/* 211 */   private void wholestagecodegen_init_3() {
/* 212 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[47];
/* 213 */     bhj_result2 = new UnsafeRow(7);
/* 214 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 215 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 216 */     project_result3 = new UnsafeRow(5);
/* 217 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 218 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 219 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[48];
/* 220 */
/* 221 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 222 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 223 */
/* 224 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[49];
/* 225 */     bhj_result3 = new UnsafeRow(7);
/* 226 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 32);
/* 227 */
/* 228 */   }
/* 229 */
/* 230 */   public class agg_FastHashMap {
/* 231 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 232 */     private int[] buckets;
/* 233 */     private int capacity = 1 << 16;
/* 234 */     private double loadFactor = 0.5;
/* 235 */     private int numBuckets = (int) (capacity / loadFactor);
/* 236 */     private int maxSteps = 2;
/* 237 */     private int numRows = 0;
/* 238 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 239 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 240 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType);
/* 241 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.LongType)
/* 242 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 243 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.LongType)
/* 244 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 245 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 246 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 247 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 248 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 249 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 250 */     .add("((java.lang.String) references[15])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 251 */     .add("((java.lang.String) references[16])", org.apache.spark.sql.types.DataTypes.LongType)
/* 252 */     .add("((java.lang.String) references[17])", org.apache.spark.sql.types.DataTypes.LongType)
/* 253 */     .add("((java.lang.String) references[18])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 254 */     .add("((java.lang.String) references[19])", org.apache.spark.sql.types.DataTypes.LongType)
/* 255 */     .add("((java.lang.String) references[20])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 256 */     .add("((java.lang.String) references[21])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 257 */     .add("((java.lang.String) references[22])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 258 */     .add("((java.lang.String) references[23])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 259 */     .add("((java.lang.String) references[24])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 260 */     .add("((java.lang.String) references[25])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 261 */     .add("((java.lang.String) references[26])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 262 */     .add("((java.lang.String) references[27])", org.apache.spark.sql.types.DataTypes.LongType)
/* 263 */     .add("((java.lang.String) references[28])", org.apache.spark.sql.types.DataTypes.LongType)
/* 264 */     .add("((java.lang.String) references[29])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 265 */     .add("((java.lang.String) references[30])", org.apache.spark.sql.types.DataTypes.LongType)
/* 266 */     .add("((java.lang.String) references[31])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 267 */     .add("((java.lang.String) references[32])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 268 */     .add("((java.lang.String) references[33])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 269 */     .add("((java.lang.String) references[34])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 270 */     .add("((java.lang.String) references[35])", org.apache.spark.sql.types.DataTypes.LongType)
/* 271 */     .add("((java.lang.String) references[36])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 272 */     .add("((java.lang.String) references[37])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 273 */     .add("((java.lang.String) references[38])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 274 */     .add("((java.lang.String) references[39])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 275 */     .add("((java.lang.String) references[40])", org.apache.spark.sql.types.DataTypes.LongType);
/* 276 */     private Object emptyVBase;
/* 277 */     private long emptyVOff;
/* 278 */     private int emptyVLen;
/* 279 */     private boolean isBatchFull = false;
/* 280 */
/* 281 */     public agg_FastHashMap(
/* 282 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 283 */       InternalRow emptyAggregationBuffer) {
/* 284 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 285 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 286 */
/* 287 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 288 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 289 */
/* 290 */       emptyVBase = emptyBuffer;
/* 291 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 292 */       emptyVLen = emptyBuffer.length;
/* 293 */
/* 294 */       buckets = new int[numBuckets];
/* 295 */       java.util.Arrays.fill(buckets, -1);
/* 296 */     }
/* 297 */
/* 298 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 299 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 300 */       int step = 0;
/* 301 */       int idx = (int) h & (numBuckets - 1);
/* 302 */       while (step < maxSteps) {
/* 303 */         // Return bucket index if it's either an empty slot or already contains the key
/* 304 */         if (buckets[idx] == -1) {
/* 305 */           if (numRows < capacity && !isBatchFull) {
/* 306 */             // creating the unsafe for new entry
/* 307 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 308 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 309 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 310 */               96);
/* 311 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 312 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 313 */               agg_holder,
/* 314 */               3);
/* 315 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 316 */             agg_rowWriter.zeroOutNullBytes();
/* 317 */             agg_rowWriter.write(0, agg_key);
/* 318 */             agg_rowWriter.write(1, agg_key1);
/* 319 */             agg_rowWriter.write(2, agg_key2);
/* 320 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 321 */             Object kbase = agg_result.getBaseObject();
/* 322 */             long koff = agg_result.getBaseOffset();
/* 323 */             int klen = agg_result.getSizeInBytes();
/* 324 */
/* 325 */             UnsafeRow vRow
/* 326 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 327 */             if (vRow == null) {
/* 328 */               isBatchFull = true;
/* 329 */             } else {
/* 330 */               buckets[idx] = numRows++;
/* 331 */             }
/* 332 */             return vRow;
/* 333 */           } else {
/* 334 */             // No more space
/* 335 */             return null;
/* 336 */           }
/* 337 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 338 */           return batch.getValueRow(buckets[idx]);
/* 339 */         }
/* 340 */         idx = (idx + 1) & (numBuckets - 1);
/* 341 */         step++;
/* 342 */       }
/* 343 */       // Didn't find it
/* 344 */       return null;
/* 345 */     }
/* 346 */
/* 347 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 348 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 349 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2));
/* 350 */     }
/* 351 */
/* 352 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2) {
/* 353 */       long agg_hash = 0;
/* 354 */
/* 355 */       int agg_result = 0;
/* 356 */       byte[] agg_bytes = agg_key.getBytes();
/* 357 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 358 */         int agg_hash1 = agg_bytes[i];
/* 359 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 360 */       }
/* 361 */
/* 362 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 363 */
/* 364 */       int agg_result1 = 0;
/* 365 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 366 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 367 */         int agg_hash2 = agg_bytes1[i];
/* 368 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 369 */       }
/* 370 */
/* 371 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 372 */
/* 373 */       int agg_result2 = 0;
/* 374 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 375 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 376 */         int agg_hash3 = agg_bytes2[i];
/* 377 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 378 */       }
/* 379 */
/* 380 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 381 */
/* 382 */       return agg_hash;
/* 383 */     }
/* 384 */
/* 385 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 386 */       return batch.rowIterator();
/* 387 */     }
/* 388 */
/* 389 */     public void close() {
/* 390 */       batch.close();
/* 391 */     }
/* 392 */
/* 393 */   }
/* 394 */
/* 395 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 396 */     agg_hashMap = agg_plan.createHashMap();
/* 397 */
/* 398 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 399 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 400 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 401 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 402 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 403 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 404 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 405 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 406 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 407 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 408 */       smj_value14 = smj_isNull10 ? -1L : (smj_leftRow.getLong(4));
/* 409 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 410 */       smj_value15 = smj_isNull11 ? -1L : (smj_leftRow.getLong(5));
/* 411 */       smj_isNull12 = smj_leftRow.isNullAt(6);
/* 412 */       smj_value16 = smj_isNull12 ? -1L : (smj_leftRow.getLong(6));
/* 413 */       smj_isNull13 = smj_leftRow.isNullAt(7);
/* 414 */       smj_value17 = smj_isNull13 ? -1 : (smj_leftRow.getInt(7));
/* 415 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 416 */       while (smj_iterator.hasNext()) {
/* 417 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 418 */
/* 419 */         smj_numOutputRows.add(1);
/* 420 */
/* 421 */         // generate join key for stream side
/* 422 */
/* 423 */         boolean bhj_isNull = smj_isNull9;
/* 424 */         long bhj_value = -1L;
/* 425 */         if (!smj_isNull9) {
/* 426 */           bhj_value = (long) smj_value13;
/* 427 */         }
/* 428 */         // find matches from HashedRelation
/* 429 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 430 */         if (bhj_matched == null) continue;
/* 431 */
/* 432 */         bhj_numOutputRows.add(1);
/* 433 */
/* 434 */         // generate join key for stream side
/* 435 */
/* 436 */         boolean bhj_isNull12 = smj_isNull13;
/* 437 */         long bhj_value12 = -1L;
/* 438 */         if (!smj_isNull13) {
/* 439 */           bhj_value12 = (long) smj_value17;
/* 440 */         }
/* 441 */         // find matches from HashedRelation
/* 442 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 443 */         if (bhj_matched1 == null) continue;
/* 444 */
/* 445 */         bhj_numOutputRows1.add(1);
/* 446 */
/* 447 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(3);
/* 448 */         int smj_value21 = smj_isNull17 ? -1 : (smj_rightRow1.getInt(3));
/* 449 */
/* 450 */         // generate join key for stream side
/* 451 */
/* 452 */         boolean bhj_isNull23 = smj_isNull17;
/* 453 */         long bhj_value23 = -1L;
/* 454 */         if (!smj_isNull17) {
/* 455 */           bhj_value23 = (long) smj_value21;
/* 456 */         }
/* 457 */         // find matches from HashedRelation
/* 458 */         UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 459 */         if (bhj_matched2 == null) continue;
/* 460 */
/* 461 */         bhj_numOutputRows2.add(1);
/* 462 */
/* 463 */         // generate join key for stream side
/* 464 */
/* 465 */         boolean bhj_isNull33 = smj_isNull7;
/* 466 */         long bhj_value33 = -1L;
/* 467 */         if (!smj_isNull7) {
/* 468 */           bhj_value33 = (long) smj_value11;
/* 469 */         }
/* 470 */         // find matches from HashedRelation
/* 471 */         UnsafeRow bhj_matched3 = bhj_isNull33 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value33);
/* 472 */         if (bhj_matched3 == null) continue;
/* 473 */
/* 474 */         bhj_numOutputRows3.add(1);
/* 475 */
/* 476 */         // generate join key for stream side
/* 477 */
/* 478 */         boolean bhj_isNull44 = smj_isNull6;
/* 479 */         long bhj_value44 = -1L;
/* 480 */         if (!smj_isNull6) {
/* 481 */           bhj_value44 = (long) smj_value10;
/* 482 */         }
/* 483 */         // find matches from HashedRelation
/* 484 */         UnsafeRow bhj_matched4 = bhj_isNull44 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value44);
/* 485 */         if (bhj_matched4 == null) continue;
/* 486 */
/* 487 */         bhj_numOutputRows4.add(1);
/* 488 */
/* 489 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(2);
/* 490 */         int smj_value20 = smj_isNull16 ? -1 : (smj_rightRow1.getInt(2));
/* 491 */         boolean bhj_isNull36 = bhj_matched3.isNullAt(1);
/* 492 */         UTF8String bhj_value36 = bhj_isNull36 ? null : (bhj_matched3.getUTF8String(1));
/* 493 */         boolean bhj_isNull47 = bhj_matched4.isNullAt(1);
/* 494 */         UTF8String bhj_value47 = bhj_isNull47 ? null : (bhj_matched4.getUTF8String(1));
/* 495 */         boolean bhj_isNull48 = bhj_matched4.isNullAt(2);
/* 496 */         UTF8String bhj_value48 = bhj_isNull48 ? null : (bhj_matched4.getUTF8String(2));
/* 497 */
/* 498 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 499 */
/* 500 */         UnsafeRow agg_fastAggBuffer = null;
/* 501 */
/* 502 */         if (true) {
/* 503 */           if (!bhj_isNull47 && !bhj_isNull48 && !bhj_isNull36) {
/* 504 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 505 */               bhj_value47, bhj_value48, bhj_value36);
/* 506 */           }
/* 507 */         }
/* 508 */
/* 509 */         if (agg_fastAggBuffer == null) {
/* 510 */           // generate grouping key
/* 511 */           agg_holder.reset();
/* 512 */
/* 513 */           agg_rowWriter.zeroOutNullBytes();
/* 514 */
/* 515 */           if (bhj_isNull47) {
/* 516 */             agg_rowWriter.setNullAt(0);
/* 517 */           } else {
/* 518 */             agg_rowWriter.write(0, bhj_value47);
/* 519 */           }
/* 520 */
/* 521 */           if (bhj_isNull48) {
/* 522 */             agg_rowWriter.setNullAt(1);
/* 523 */           } else {
/* 524 */             agg_rowWriter.write(1, bhj_value48);
/* 525 */           }
/* 526 */
/* 527 */           if (bhj_isNull36) {
/* 528 */             agg_rowWriter.setNullAt(2);
/* 529 */           } else {
/* 530 */             agg_rowWriter.write(2, bhj_value36);
/* 531 */           }
/* 532 */           agg_result3.setTotalSize(agg_holder.totalSize());
/* 533 */           agg_value83 = 42;
/* 534 */
/* 535 */           if (!bhj_isNull47) {
/* 536 */             agg_value83 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value47.getBaseObject(), bhj_value47.getBaseOffset(), bhj_value47.numBytes(), agg_value83);
/* 537 */           }
/* 538 */
/* 539 */           if (!bhj_isNull48) {
/* 540 */             agg_value83 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value48.getBaseObject(), bhj_value48.getBaseOffset(), bhj_value48.numBytes(), agg_value83);
/* 541 */           }
/* 542 */
/* 543 */           if (!bhj_isNull36) {
/* 544 */             agg_value83 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value36.getBaseObject(), bhj_value36.getBaseOffset(), bhj_value36.numBytes(), agg_value83);
/* 545 */           }
/* 546 */           if (true) {
/* 547 */             // try to get the buffer from hash map
/* 548 */             agg_unsafeRowAggBuffer =
/* 549 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value83);
/* 550 */           }
/* 551 */           if (agg_unsafeRowAggBuffer == null) {
/* 552 */             if (agg_sorter == null) {
/* 553 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 554 */             } else {
/* 555 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 556 */             }
/* 557 */
/* 558 */             // the hash map had be spilled, it should have enough memory now,
/* 559 */             // try  to allocate buffer again.
/* 560 */             agg_unsafeRowAggBuffer =
/* 561 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value83);
/* 562 */             if (agg_unsafeRowAggBuffer == null) {
/* 563 */               // failed to allocate the first page
/* 564 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 565 */             }
/* 566 */           }
/* 567 */         }
/* 568 */
/* 569 */         if (agg_fastAggBuffer != null) {
/* 570 */           // update fast row
/* 571 */
/* 572 */           // common sub-expressions
/* 573 */           boolean agg_isNull392 = smj_isNull16;
/* 574 */           long agg_value427 = -1L;
/* 575 */           if (!smj_isNull16) {
/* 576 */             agg_value427 = (long) smj_value20;
/* 577 */           }
/* 578 */           boolean agg_isNull395 = smj_isNull8;
/* 579 */           double agg_value430 = -1.0;
/* 580 */           if (!smj_isNull8) {
/* 581 */             agg_value430 = (double) smj_value12;
/* 582 */           }
/* 583 */           boolean agg_isNull397 = smj_isNull8;
/* 584 */           long agg_value432 = -1L;
/* 585 */           if (!smj_isNull8) {
/* 586 */             agg_value432 = (long) smj_value12;
/* 587 */           }
/* 588 */           boolean agg_isNull400 = smj_isNull16;
/* 589 */           double agg_value435 = -1.0;
/* 590 */           if (!smj_isNull16) {
/* 591 */             agg_value435 = (double) smj_value20;
/* 592 */           }
/* 593 */           boolean agg_isNull404 = smj_isNull16;
/* 594 */           long agg_value439 = -1L;
/* 595 */           if (!smj_isNull16) {
/* 596 */             agg_value439 = (long) smj_value20;
/* 597 */           }
/* 598 */           boolean agg_isNull403 = agg_isNull404;
/* 599 */           double agg_value438 = -1.0;
/* 600 */           if (!agg_isNull404) {
/* 601 */             agg_value438 = (double) agg_value439;
/* 602 */           }
/* 603 */           boolean agg_isNull402 = agg_isNull403;
/* 604 */           double agg_value437 = agg_value438;
/* 605 */           if (agg_isNull402) {
/* 606 */             boolean agg_isNull406 = false;
/* 607 */             double agg_value441 = -1.0;
/* 608 */             if (!false) {
/* 609 */               agg_value441 = (double) 0;
/* 610 */             }
/* 611 */             if (!agg_isNull406) {
/* 612 */               agg_isNull402 = false;
/* 613 */               agg_value437 = agg_value441;
/* 614 */             }
/* 615 */           }
/* 616 */           boolean agg_isNull409 = smj_isNull16;
/* 617 */           long agg_value444 = -1L;
/* 618 */           if (!smj_isNull16) {
/* 619 */             agg_value444 = (long) smj_value20;
/* 620 */           }
/* 621 */           boolean agg_isNull412 = smj_isNull8;
/* 622 */           long agg_value447 = -1L;
/* 623 */           if (!smj_isNull8) {
/* 624 */             agg_value447 = (long) smj_value12;
/* 625 */           }
/* 626 */           boolean agg_isNull415 = smj_isNull12;
/* 627 */           double agg_value450 = -1.0;
/* 628 */           if (!smj_isNull12) {
/* 629 */             agg_value450 = (double) smj_value16;
/* 630 */           }
/* 631 */           boolean agg_isNull414 = agg_isNull415;
/* 632 */           double agg_value449 = agg_value450;
/* 633 */           if (agg_isNull414) {
/* 634 */             boolean agg_isNull417 = false;
/* 635 */             double agg_value452 = -1.0;
/* 636 */             if (!false) {
/* 637 */               agg_value452 = (double) 0;
/* 638 */             }
/* 639 */             if (!agg_isNull417) {
/* 640 */               agg_isNull414 = false;
/* 641 */               agg_value449 = agg_value452;
/* 642 */             }
/* 643 */           }
/* 644 */           boolean agg_isNull421 = smj_isNull8;
/* 645 */           long agg_value456 = -1L;
/* 646 */           if (!smj_isNull8) {
/* 647 */             agg_value456 = (long) smj_value12;
/* 648 */           }
/* 649 */           boolean agg_isNull420 = agg_isNull421;
/* 650 */           double agg_value455 = -1.0;
/* 651 */           if (!agg_isNull421) {
/* 652 */             agg_value455 = (double) agg_value456;
/* 653 */           }
/* 654 */           boolean agg_isNull419 = agg_isNull420;
/* 655 */           double agg_value454 = agg_value455;
/* 656 */           if (agg_isNull419) {
/* 657 */             boolean agg_isNull423 = false;
/* 658 */             double agg_value458 = -1.0;
/* 659 */             if (!false) {
/* 660 */               agg_value458 = (double) 0;
/* 661 */             }
/* 662 */             if (!agg_isNull423) {
/* 663 */               agg_isNull419 = false;
/* 664 */               agg_value454 = agg_value458;
/* 665 */             }
/* 666 */           }
/* 667 */
/* 668 */           boolean agg_isNull428 = smj_isNull12;
/* 669 */           double agg_value463 = -1.0;
/* 670 */           if (!smj_isNull12) {
/* 671 */             agg_value463 = (double) smj_value16;
/* 672 */           }
/* 673 */           // evaluate aggregate function
/* 674 */           boolean agg_isNull430 = false;
/* 675 */           long agg_value465 = -1L;
/* 676 */           if (!false && smj_isNull8) {
/* 677 */             long agg_value468 = agg_fastAggBuffer.getLong(0);
/* 678 */             agg_isNull430 = false;
/* 679 */             agg_value465 = agg_value468;
/* 680 */           } else {
/* 681 */             boolean agg_isNull434 = false;
/* 682 */
/* 683 */             long agg_value470 = agg_fastAggBuffer.getLong(0);
/* 684 */
/* 685 */             long agg_value469 = -1L;
/* 686 */             agg_value469 = agg_value470 + 1L;
/* 687 */             agg_isNull430 = false;
/* 688 */             agg_value465 = agg_value469;
/* 689 */           }
/* 690 */           boolean agg_isNull437 = true;
/* 691 */           double agg_value472 = -1.0;
/* 692 */
/* 693 */           boolean agg_isNull438 = agg_fastAggBuffer.isNullAt(1);
/* 694 */           double agg_value473 = agg_isNull438 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 695 */           if (!agg_isNull438) {
/* 696 */             agg_isNull437 = false; // resultCode could change nullability.
/* 697 */             agg_value472 = agg_value473 + agg_value454;
/* 698 */
/* 699 */           }
/* 700 */           boolean agg_isNull439 = false;
/* 701 */           long agg_value474 = -1L;
/* 702 */           if (!false && agg_isNull412) {
/* 703 */             boolean agg_isNull440 = agg_fastAggBuffer.isNullAt(2);
/* 704 */             long agg_value475 = agg_isNull440 ? -1L : (agg_fastAggBuffer.getLong(2));
/* 705 */             agg_isNull439 = agg_isNull440;
/* 706 */             agg_value474 = agg_value475;
/* 707 */           } else {
/* 708 */             boolean agg_isNull441 = true;
/* 709 */             long agg_value476 = -1L;
/* 710 */
/* 711 */             boolean agg_isNull442 = agg_fastAggBuffer.isNullAt(2);
/* 712 */             long agg_value477 = agg_isNull442 ? -1L : (agg_fastAggBuffer.getLong(2));
/* 713 */             if (!agg_isNull442) {
/* 714 */               agg_isNull441 = false; // resultCode could change nullability.
/* 715 */               agg_value476 = agg_value477 + 1L;
/* 716 */
/* 717 */             }
/* 718 */             agg_isNull439 = agg_isNull441;
/* 719 */             agg_value474 = agg_value476;
/* 720 */           }
/* 721 */           boolean agg_isNull444 = false;
/* 722 */           double agg_value479 = -1.0;
/* 723 */           if (!false && agg_isNull395) {
/* 724 */             double agg_value480 = agg_fastAggBuffer.getDouble(3);
/* 725 */             agg_isNull444 = false;
/* 726 */             agg_value479 = agg_value480;
/* 727 */           } else {
/* 728 */             boolean agg_isNull446 = false;
/* 729 */
/* 730 */             double agg_value482 = agg_fastAggBuffer.getDouble(3);
/* 731 */
/* 732 */             double agg_value481 = -1.0;
/* 733 */             agg_value481 = agg_value482 + 1.0D;
/* 734 */             agg_isNull444 = false;
/* 735 */             agg_value479 = agg_value481;
/* 736 */           }
/* 737 */           boolean agg_isNull449 = false;
/* 738 */           double agg_value484 = -1.0;
/* 739 */           if (!false && agg_isNull395) {
/* 740 */             double agg_value485 = agg_fastAggBuffer.getDouble(4);
/* 741 */             agg_isNull449 = false;
/* 742 */             agg_value484 = agg_value485;
/* 743 */           } else {
/* 744 */             boolean agg_isNull451 = true;
/* 745 */             double agg_value486 = -1.0;
/* 746 */
/* 747 */             double agg_value487 = agg_fastAggBuffer.getDouble(4);
/* 748 */
/* 749 */             boolean agg_isNull458 = false;
/* 750 */
/* 751 */             double agg_value494 = agg_fastAggBuffer.getDouble(3);
/* 752 */
/* 753 */             double agg_value493 = -1.0;
/* 754 */             agg_value493 = agg_value494 + 1.0D;
/* 755 */             boolean agg_isNull453 = false;
/* 756 */             double agg_value488 = -1.0;
/* 757 */             if (false || agg_value493 == 0) {
/* 758 */               agg_isNull453 = true;
/* 759 */             } else {
/* 760 */               boolean agg_isNull454 = true;
/* 761 */               double agg_value489 = -1.0;
/* 762 */
/* 763 */               boolean agg_isNull455 = smj_isNull8;
/* 764 */               double agg_value490 = -1.0;
/* 765 */               if (!smj_isNull8) {
/* 766 */                 agg_value490 = (double) smj_value12;
/* 767 */               }
/* 768 */               if (!agg_isNull455) {
/* 769 */                 double agg_value492 = agg_fastAggBuffer.getDouble(4);
/* 770 */
/* 771 */                 agg_isNull454 = false; // resultCode could change nullability.
/* 772 */                 agg_value489 = agg_value490 - agg_value492;
/* 773 */
/* 774 */               }
/* 775 */               if (agg_isNull454) {
/* 776 */                 agg_isNull453 = true;
/* 777 */               } else {
/* 778 */                 agg_value488 = (double)(agg_value489 / agg_value493);
/* 779 */               }
/* 780 */             }
/* 781 */             if (!agg_isNull453) {
/* 782 */               agg_isNull451 = false; // resultCode could change nullability.
/* 783 */               agg_value486 = agg_value487 + agg_value488;
/* 784 */
/* 785 */             }
/* 786 */             agg_isNull449 = agg_isNull451;
/* 787 */             agg_value484 = agg_value486;
/* 788 */           }
/* 789 */           boolean agg_isNull461 = false;
/* 790 */           double agg_value496 = -1.0;
/* 791 */           if (!false && agg_isNull395) {
/* 792 */             double agg_value497 = agg_fastAggBuffer.getDouble(5);
/* 793 */             agg_isNull461 = false;
/* 794 */             agg_value496 = agg_value497;
/* 795 */           } else {
/* 796 */             boolean agg_isNull463 = true;
/* 797 */             double agg_value498 = -1.0;
/* 798 */
/* 799 */             double agg_value499 = agg_fastAggBuffer.getDouble(5);
/* 800 */
/* 801 */             boolean agg_isNull465 = true;
/* 802 */             double agg_value500 = -1.0;
/* 803 */
/* 804 */             boolean agg_isNull466 = true;
/* 805 */             double agg_value501 = -1.0;
/* 806 */
/* 807 */             boolean agg_isNull467 = smj_isNull8;
/* 808 */             double agg_value502 = -1.0;
/* 809 */             if (!smj_isNull8) {
/* 810 */               agg_value502 = (double) smj_value12;
/* 811 */             }
/* 812 */             if (!agg_isNull467) {
/* 813 */               double agg_value504 = agg_fastAggBuffer.getDouble(4);
/* 814 */
/* 815 */               agg_isNull466 = false; // resultCode could change nullability.
/* 816 */               agg_value501 = agg_value502 - agg_value504;
/* 817 */
/* 818 */             }
/* 819 */             if (!agg_isNull466) {
/* 820 */               boolean agg_isNull470 = true;
/* 821 */               double agg_value505 = -1.0;
/* 822 */
/* 823 */               boolean agg_isNull471 = true;
/* 824 */               double agg_value506 = -1.0;
/* 825 */
/* 826 */               boolean agg_isNull472 = smj_isNull8;
/* 827 */               double agg_value507 = -1.0;
/* 828 */               if (!smj_isNull8) {
/* 829 */                 agg_value507 = (double) smj_value12;
/* 830 */               }
/* 831 */               if (!agg_isNull472) {
/* 832 */                 double agg_value509 = agg_fastAggBuffer.getDouble(4);
/* 833 */
/* 834 */                 agg_isNull471 = false; // resultCode could change nullability.
/* 835 */                 agg_value506 = agg_value507 - agg_value509;
/* 836 */
/* 837 */               }
/* 838 */               if (!agg_isNull471) {
/* 839 */                 boolean agg_isNull480 = false;
/* 840 */
/* 841 */                 double agg_value516 = agg_fastAggBuffer.getDouble(3);
/* 842 */
/* 843 */                 double agg_value515 = -1.0;
/* 844 */                 agg_value515 = agg_value516 + 1.0D;
/* 845 */                 boolean agg_isNull475 = false;
/* 846 */                 double agg_value510 = -1.0;
/* 847 */                 if (false || agg_value515 == 0) {
/* 848 */                   agg_isNull475 = true;
/* 849 */                 } else {
/* 850 */                   boolean agg_isNull476 = true;
/* 851 */                   double agg_value511 = -1.0;
/* 852 */
/* 853 */                   boolean agg_isNull477 = smj_isNull8;
/* 854 */                   double agg_value512 = -1.0;
/* 855 */                   if (!smj_isNull8) {
/* 856 */                     agg_value512 = (double) smj_value12;
/* 857 */                   }
/* 858 */                   if (!agg_isNull477) {
/* 859 */                     double agg_value514 = agg_fastAggBuffer.getDouble(4);
/* 860 */
/* 861 */                     agg_isNull476 = false; // resultCode could change nullability.
/* 862 */                     agg_value511 = agg_value512 - agg_value514;
/* 863 */
/* 864 */                   }
/* 865 */                   if (agg_isNull476) {
/* 866 */                     agg_isNull475 = true;
/* 867 */                   } else {
/* 868 */                     agg_value510 = (double)(agg_value511 / agg_value515);
/* 869 */                   }
/* 870 */                 }
/* 871 */                 if (!agg_isNull475) {
/* 872 */                   agg_isNull470 = false; // resultCode could change nullability.
/* 873 */                   agg_value505 = agg_value506 - agg_value510;
/* 874 */
/* 875 */                 }
/* 876 */
/* 877 */               }
/* 878 */               if (!agg_isNull470) {
/* 879 */                 agg_isNull465 = false; // resultCode could change nullability.
/* 880 */                 agg_value500 = agg_value501 * agg_value505;
/* 881 */
/* 882 */               }
/* 883 */
/* 884 */             }
/* 885 */             if (!agg_isNull465) {
/* 886 */               agg_isNull463 = false; // resultCode could change nullability.
/* 887 */               agg_value498 = agg_value499 + agg_value500;
/* 888 */
/* 889 */             }
/* 890 */             agg_isNull461 = agg_isNull463;
/* 891 */             agg_value496 = agg_value498;
/* 892 */           }
/* 893 */           boolean agg_isNull483 = false;
/* 894 */           double agg_value518 = -1.0;
/* 895 */           if (!false && agg_isNull395) {
/* 896 */             double agg_value519 = agg_fastAggBuffer.getDouble(6);
/* 897 */             agg_isNull483 = false;
/* 898 */             agg_value518 = agg_value519;
/* 899 */           } else {
/* 900 */             boolean agg_isNull485 = false;
/* 901 */
/* 902 */             double agg_value521 = agg_fastAggBuffer.getDouble(6);
/* 903 */
/* 904 */             double agg_value520 = -1.0;
/* 905 */             agg_value520 = agg_value521 + 1.0D;
/* 906 */             agg_isNull483 = false;
/* 907 */             agg_value518 = agg_value520;
/* 908 */           }
/* 909 */           boolean agg_isNull488 = false;
/* 910 */           double agg_value523 = -1.0;
/* 911 */           if (!false && agg_isNull395) {
/* 912 */             double agg_value524 = agg_fastAggBuffer.getDouble(7);
/* 913 */             agg_isNull488 = false;
/* 914 */             agg_value523 = agg_value524;
/* 915 */           } else {
/* 916 */             boolean agg_isNull490 = true;
/* 917 */             double agg_value525 = -1.0;
/* 918 */
/* 919 */             double agg_value526 = agg_fastAggBuffer.getDouble(7);
/* 920 */
/* 921 */             boolean agg_isNull497 = false;
/* 922 */
/* 923 */             double agg_value533 = agg_fastAggBuffer.getDouble(6);
/* 924 */
/* 925 */             double agg_value532 = -1.0;
/* 926 */             agg_value532 = agg_value533 + 1.0D;
/* 927 */             boolean agg_isNull492 = false;
/* 928 */             double agg_value527 = -1.0;
/* 929 */             if (false || agg_value532 == 0) {
/* 930 */               agg_isNull492 = true;
/* 931 */             } else {
/* 932 */               boolean agg_isNull493 = true;
/* 933 */               double agg_value528 = -1.0;
/* 934 */
/* 935 */               boolean agg_isNull494 = smj_isNull8;
/* 936 */               double agg_value529 = -1.0;
/* 937 */               if (!smj_isNull8) {
/* 938 */                 agg_value529 = (double) smj_value12;
/* 939 */               }
/* 940 */               if (!agg_isNull494) {
/* 941 */                 double agg_value531 = agg_fastAggBuffer.getDouble(7);
/* 942 */
/* 943 */                 agg_isNull493 = false; // resultCode could change nullability.
/* 944 */                 agg_value528 = agg_value529 - agg_value531;
/* 945 */
/* 946 */               }
/* 947 */               if (agg_isNull493) {
/* 948 */                 agg_isNull492 = true;
/* 949 */               } else {
/* 950 */                 agg_value527 = (double)(agg_value528 / agg_value532);
/* 951 */               }
/* 952 */             }
/* 953 */             if (!agg_isNull492) {
/* 954 */               agg_isNull490 = false; // resultCode could change nullability.
/* 955 */               agg_value525 = agg_value526 + agg_value527;
/* 956 */
/* 957 */             }
/* 958 */             agg_isNull488 = agg_isNull490;
/* 959 */             agg_value523 = agg_value525;
/* 960 */           }
/* 961 */           boolean agg_isNull500 = false;
/* 962 */           double agg_value535 = -1.0;
/* 963 */           if (!false && agg_isNull395) {
/* 964 */             double agg_value536 = agg_fastAggBuffer.getDouble(8);
/* 965 */             agg_isNull500 = false;
/* 966 */             agg_value535 = agg_value536;
/* 967 */           } else {
/* 968 */             boolean agg_isNull502 = true;
/* 969 */             double agg_value537 = -1.0;
/* 970 */
/* 971 */             double agg_value538 = agg_fastAggBuffer.getDouble(8);
/* 972 */
/* 973 */             boolean agg_isNull504 = true;
/* 974 */             double agg_value539 = -1.0;
/* 975 */
/* 976 */             boolean agg_isNull505 = true;
/* 977 */             double agg_value540 = -1.0;
/* 978 */
/* 979 */             boolean agg_isNull506 = smj_isNull8;
/* 980 */             double agg_value541 = -1.0;
/* 981 */             if (!smj_isNull8) {
/* 982 */               agg_value541 = (double) smj_value12;
/* 983 */             }
/* 984 */             if (!agg_isNull506) {
/* 985 */               double agg_value543 = agg_fastAggBuffer.getDouble(7);
/* 986 */
/* 987 */               agg_isNull505 = false; // resultCode could change nullability.
/* 988 */               agg_value540 = agg_value541 - agg_value543;
/* 989 */
/* 990 */             }
/* 991 */             if (!agg_isNull505) {
/* 992 */               boolean agg_isNull509 = true;
/* 993 */               double agg_value544 = -1.0;
/* 994 */
/* 995 */               boolean agg_isNull510 = true;
/* 996 */               double agg_value545 = -1.0;
/* 997 */
/* 998 */               boolean agg_isNull511 = smj_isNull8;
/* 999 */               double agg_value546 = -1.0;
/* 1000 */               if (!smj_isNull8) {
/* 1001 */                 agg_value546 = (double) smj_value12;
/* 1002 */               }
/* 1003 */               if (!agg_isNull511) {
/* 1004 */                 double agg_value548 = agg_fastAggBuffer.getDouble(7);
/* 1005 */
/* 1006 */                 agg_isNull510 = false; // resultCode could change nullability.
/* 1007 */                 agg_value545 = agg_value546 - agg_value548;
/* 1008 */
/* 1009 */               }
/* 1010 */               if (!agg_isNull510) {
/* 1011 */                 boolean agg_isNull519 = false;
/* 1012 */
/* 1013 */                 double agg_value555 = agg_fastAggBuffer.getDouble(6);
/* 1014 */
/* 1015 */                 double agg_value554 = -1.0;
/* 1016 */                 agg_value554 = agg_value555 + 1.0D;
/* 1017 */                 boolean agg_isNull514 = false;
/* 1018 */                 double agg_value549 = -1.0;
/* 1019 */                 if (false || agg_value554 == 0) {
/* 1020 */                   agg_isNull514 = true;
/* 1021 */                 } else {
/* 1022 */                   boolean agg_isNull515 = true;
/* 1023 */                   double agg_value550 = -1.0;
/* 1024 */
/* 1025 */                   boolean agg_isNull516 = smj_isNull8;
/* 1026 */                   double agg_value551 = -1.0;
/* 1027 */                   if (!smj_isNull8) {
/* 1028 */                     agg_value551 = (double) smj_value12;
/* 1029 */                   }
/* 1030 */                   if (!agg_isNull516) {
/* 1031 */                     double agg_value553 = agg_fastAggBuffer.getDouble(7);
/* 1032 */
/* 1033 */                     agg_isNull515 = false; // resultCode could change nullability.
/* 1034 */                     agg_value550 = agg_value551 - agg_value553;
/* 1035 */
/* 1036 */                   }
/* 1037 */                   if (agg_isNull515) {
/* 1038 */                     agg_isNull514 = true;
/* 1039 */                   } else {
/* 1040 */                     agg_value549 = (double)(agg_value550 / agg_value554);
/* 1041 */                   }
/* 1042 */                 }
/* 1043 */                 if (!agg_isNull514) {
/* 1044 */                   agg_isNull509 = false; // resultCode could change nullability.
/* 1045 */                   agg_value544 = agg_value545 - agg_value549;
/* 1046 */
/* 1047 */                 }
/* 1048 */
/* 1049 */               }
/* 1050 */               if (!agg_isNull509) {
/* 1051 */                 agg_isNull504 = false; // resultCode could change nullability.
/* 1052 */                 agg_value539 = agg_value540 * agg_value544;
/* 1053 */
/* 1054 */               }
/* 1055 */
/* 1056 */             }
/* 1057 */             if (!agg_isNull504) {
/* 1058 */               agg_isNull502 = false; // resultCode could change nullability.
/* 1059 */               agg_value537 = agg_value538 + agg_value539;
/* 1060 */
/* 1061 */             }
/* 1062 */             agg_isNull500 = agg_isNull502;
/* 1063 */             agg_value535 = agg_value537;
/* 1064 */           }
/* 1065 */           boolean agg_isNull522 = true;
/* 1066 */           double agg_value557 = -1.0;
/* 1067 */
/* 1068 */           boolean agg_isNull523 = agg_fastAggBuffer.isNullAt(9);
/* 1069 */           double agg_value558 = agg_isNull523 ? -1.0 : (agg_fastAggBuffer.getDouble(9));
/* 1070 */           if (!agg_isNull523) {
/* 1071 */             agg_isNull522 = false; // resultCode could change nullability.
/* 1072 */             agg_value557 = agg_value558 + agg_value454;
/* 1073 */
/* 1074 */           }
/* 1075 */           boolean agg_isNull524 = false;
/* 1076 */           long agg_value559 = -1L;
/* 1077 */           if (!false && agg_isNull412) {
/* 1078 */             boolean agg_isNull525 = agg_fastAggBuffer.isNullAt(10);
/* 1079 */             long agg_value560 = agg_isNull525 ? -1L : (agg_fastAggBuffer.getLong(10));
/* 1080 */             agg_isNull524 = agg_isNull525;
/* 1081 */             agg_value559 = agg_value560;
/* 1082 */           } else {
/* 1083 */             boolean agg_isNull526 = true;
/* 1084 */             long agg_value561 = -1L;
/* 1085 */
/* 1086 */             boolean agg_isNull527 = agg_fastAggBuffer.isNullAt(10);
/* 1087 */             long agg_value562 = agg_isNull527 ? -1L : (agg_fastAggBuffer.getLong(10));
/* 1088 */             if (!agg_isNull527) {
/* 1089 */               agg_isNull526 = false; // resultCode could change nullability.
/* 1090 */               agg_value561 = agg_value562 + 1L;
/* 1091 */
/* 1092 */             }
/* 1093 */             agg_isNull524 = agg_isNull526;
/* 1094 */             agg_value559 = agg_value561;
/* 1095 */           }
/* 1096 */           boolean agg_isNull529 = false;
/* 1097 */           long agg_value564 = -1L;
/* 1098 */           if (!false && smj_isNull12) {
/* 1099 */             long agg_value565 = agg_fastAggBuffer.getLong(11);
/* 1100 */             agg_isNull529 = false;
/* 1101 */             agg_value564 = agg_value565;
/* 1102 */           } else {
/* 1103 */             boolean agg_isNull531 = false;
/* 1104 */
/* 1105 */             long agg_value567 = agg_fastAggBuffer.getLong(11);
/* 1106 */
/* 1107 */             long agg_value566 = -1L;
/* 1108 */             agg_value566 = agg_value567 + 1L;
/* 1109 */             agg_isNull529 = false;
/* 1110 */             agg_value564 = agg_value566;
/* 1111 */           }
/* 1112 */           boolean agg_isNull534 = true;
/* 1113 */           double agg_value569 = -1.0;
/* 1114 */
/* 1115 */           boolean agg_isNull535 = agg_fastAggBuffer.isNullAt(12);
/* 1116 */           double agg_value570 = agg_isNull535 ? -1.0 : (agg_fastAggBuffer.getDouble(12));
/* 1117 */           if (!agg_isNull535) {
/* 1118 */             agg_isNull534 = false; // resultCode could change nullability.
/* 1119 */             agg_value569 = agg_value570 + agg_value449;
/* 1120 */
/* 1121 */           }
/* 1122 */           boolean agg_isNull536 = false;
/* 1123 */           long agg_value571 = -1L;
/* 1124 */           if (!false && smj_isNull12) {
/* 1125 */             boolean agg_isNull537 = agg_fastAggBuffer.isNullAt(13);
/* 1126 */             long agg_value572 = agg_isNull537 ? -1L : (agg_fastAggBuffer.getLong(13));
/* 1127 */             agg_isNull536 = agg_isNull537;
/* 1128 */             agg_value571 = agg_value572;
/* 1129 */           } else {
/* 1130 */             boolean agg_isNull538 = true;
/* 1131 */             long agg_value573 = -1L;
/* 1132 */
/* 1133 */             boolean agg_isNull539 = agg_fastAggBuffer.isNullAt(13);
/* 1134 */             long agg_value574 = agg_isNull539 ? -1L : (agg_fastAggBuffer.getLong(13));
/* 1135 */             if (!agg_isNull539) {
/* 1136 */               agg_isNull538 = false; // resultCode could change nullability.
/* 1137 */               agg_value573 = agg_value574 + 1L;
/* 1138 */
/* 1139 */             }
/* 1140 */             agg_isNull536 = agg_isNull538;
/* 1141 */             agg_value571 = agg_value573;
/* 1142 */           }
/* 1143 */           boolean agg_isNull541 = false;
/* 1144 */           double agg_value576 = -1.0;
/* 1145 */           if (!false && agg_isNull428) {
/* 1146 */             double agg_value577 = agg_fastAggBuffer.getDouble(14);
/* 1147 */             agg_isNull541 = false;
/* 1148 */             agg_value576 = agg_value577;
/* 1149 */           } else {
/* 1150 */             boolean agg_isNull543 = false;
/* 1151 */
/* 1152 */             double agg_value579 = agg_fastAggBuffer.getDouble(14);
/* 1153 */
/* 1154 */             double agg_value578 = -1.0;
/* 1155 */             agg_value578 = agg_value579 + 1.0D;
/* 1156 */             agg_isNull541 = false;
/* 1157 */             agg_value576 = agg_value578;
/* 1158 */           }
/* 1159 */           boolean agg_isNull546 = false;
/* 1160 */           double agg_value581 = -1.0;
/* 1161 */           if (!false && agg_isNull428) {
/* 1162 */             double agg_value582 = agg_fastAggBuffer.getDouble(15);
/* 1163 */             agg_isNull546 = false;
/* 1164 */             agg_value581 = agg_value582;
/* 1165 */           } else {
/* 1166 */             boolean agg_isNull548 = true;
/* 1167 */             double agg_value583 = -1.0;
/* 1168 */
/* 1169 */             double agg_value584 = agg_fastAggBuffer.getDouble(15);
/* 1170 */
/* 1171 */             boolean agg_isNull555 = false;
/* 1172 */
/* 1173 */             double agg_value591 = agg_fastAggBuffer.getDouble(14);
/* 1174 */
/* 1175 */             double agg_value590 = -1.0;
/* 1176 */             agg_value590 = agg_value591 + 1.0D;
/* 1177 */             boolean agg_isNull550 = false;
/* 1178 */             double agg_value585 = -1.0;
/* 1179 */             if (false || agg_value590 == 0) {
/* 1180 */               agg_isNull550 = true;
/* 1181 */             } else {
/* 1182 */               boolean agg_isNull551 = true;
/* 1183 */               double agg_value586 = -1.0;
/* 1184 */
/* 1185 */               boolean agg_isNull552 = smj_isNull12;
/* 1186 */               double agg_value587 = -1.0;
/* 1187 */               if (!smj_isNull12) {
/* 1188 */                 agg_value587 = (double) smj_value16;
/* 1189 */               }
/* 1190 */               if (!agg_isNull552) {
/* 1191 */                 double agg_value589 = agg_fastAggBuffer.getDouble(15);
/* 1192 */
/* 1193 */                 agg_isNull551 = false; // resultCode could change nullability.
/* 1194 */                 agg_value586 = agg_value587 - agg_value589;
/* 1195 */
/* 1196 */               }
/* 1197 */               if (agg_isNull551) {
/* 1198 */                 agg_isNull550 = true;
/* 1199 */               } else {
/* 1200 */                 agg_value585 = (double)(agg_value586 / agg_value590);
/* 1201 */               }
/* 1202 */             }
/* 1203 */             if (!agg_isNull550) {
/* 1204 */               agg_isNull548 = false; // resultCode could change nullability.
/* 1205 */               agg_value583 = agg_value584 + agg_value585;
/* 1206 */
/* 1207 */             }
/* 1208 */             agg_isNull546 = agg_isNull548;
/* 1209 */             agg_value581 = agg_value583;
/* 1210 */           }
/* 1211 */           boolean agg_isNull558 = false;
/* 1212 */           double agg_value593 = -1.0;
/* 1213 */           if (!false && agg_isNull428) {
/* 1214 */             double agg_value594 = agg_fastAggBuffer.getDouble(16);
/* 1215 */             agg_isNull558 = false;
/* 1216 */             agg_value593 = agg_value594;
/* 1217 */           } else {
/* 1218 */             boolean agg_isNull560 = true;
/* 1219 */             double agg_value595 = -1.0;
/* 1220 */
/* 1221 */             double agg_value596 = agg_fastAggBuffer.getDouble(16);
/* 1222 */
/* 1223 */             boolean agg_isNull562 = true;
/* 1224 */             double agg_value597 = -1.0;
/* 1225 */
/* 1226 */             boolean agg_isNull563 = true;
/* 1227 */             double agg_value598 = -1.0;
/* 1228 */
/* 1229 */             boolean agg_isNull564 = smj_isNull12;
/* 1230 */             double agg_value599 = -1.0;
/* 1231 */             if (!smj_isNull12) {
/* 1232 */               agg_value599 = (double) smj_value16;
/* 1233 */             }
/* 1234 */             if (!agg_isNull564) {
/* 1235 */               double agg_value601 = agg_fastAggBuffer.getDouble(15);
/* 1236 */
/* 1237 */               agg_isNull563 = false; // resultCode could change nullability.
/* 1238 */               agg_value598 = agg_value599 - agg_value601;
/* 1239 */
/* 1240 */             }
/* 1241 */             if (!agg_isNull563) {
/* 1242 */               boolean agg_isNull567 = true;
/* 1243 */               double agg_value602 = -1.0;
/* 1244 */
/* 1245 */               boolean agg_isNull568 = true;
/* 1246 */               double agg_value603 = -1.0;
/* 1247 */
/* 1248 */               boolean agg_isNull569 = smj_isNull12;
/* 1249 */               double agg_value604 = -1.0;
/* 1250 */               if (!smj_isNull12) {
/* 1251 */                 agg_value604 = (double) smj_value16;
/* 1252 */               }
/* 1253 */               if (!agg_isNull569) {
/* 1254 */                 double agg_value606 = agg_fastAggBuffer.getDouble(15);
/* 1255 */
/* 1256 */                 agg_isNull568 = false; // resultCode could change nullability.
/* 1257 */                 agg_value603 = agg_value604 - agg_value606;
/* 1258 */
/* 1259 */               }
/* 1260 */               if (!agg_isNull568) {
/* 1261 */                 boolean agg_isNull577 = false;
/* 1262 */
/* 1263 */                 double agg_value613 = agg_fastAggBuffer.getDouble(14);
/* 1264 */
/* 1265 */                 double agg_value612 = -1.0;
/* 1266 */                 agg_value612 = agg_value613 + 1.0D;
/* 1267 */                 boolean agg_isNull572 = false;
/* 1268 */                 double agg_value607 = -1.0;
/* 1269 */                 if (false || agg_value612 == 0) {
/* 1270 */                   agg_isNull572 = true;
/* 1271 */                 } else {
/* 1272 */                   boolean agg_isNull573 = true;
/* 1273 */                   double agg_value608 = -1.0;
/* 1274 */
/* 1275 */                   boolean agg_isNull574 = smj_isNull12;
/* 1276 */                   double agg_value609 = -1.0;
/* 1277 */                   if (!smj_isNull12) {
/* 1278 */                     agg_value609 = (double) smj_value16;
/* 1279 */                   }
/* 1280 */                   if (!agg_isNull574) {
/* 1281 */                     double agg_value611 = agg_fastAggBuffer.getDouble(15);
/* 1282 */
/* 1283 */                     agg_isNull573 = false; // resultCode could change nullability.
/* 1284 */                     agg_value608 = agg_value609 - agg_value611;
/* 1285 */
/* 1286 */                   }
/* 1287 */                   if (agg_isNull573) {
/* 1288 */                     agg_isNull572 = true;
/* 1289 */                   } else {
/* 1290 */                     agg_value607 = (double)(agg_value608 / agg_value612);
/* 1291 */                   }
/* 1292 */                 }
/* 1293 */                 if (!agg_isNull572) {
/* 1294 */                   agg_isNull567 = false; // resultCode could change nullability.
/* 1295 */                   agg_value602 = agg_value603 - agg_value607;
/* 1296 */
/* 1297 */                 }
/* 1298 */
/* 1299 */               }
/* 1300 */               if (!agg_isNull567) {
/* 1301 */                 agg_isNull562 = false; // resultCode could change nullability.
/* 1302 */                 agg_value597 = agg_value598 * agg_value602;
/* 1303 */
/* 1304 */               }
/* 1305 */
/* 1306 */             }
/* 1307 */             if (!agg_isNull562) {
/* 1308 */               agg_isNull560 = false; // resultCode could change nullability.
/* 1309 */               agg_value595 = agg_value596 + agg_value597;
/* 1310 */
/* 1311 */             }
/* 1312 */             agg_isNull558 = agg_isNull560;
/* 1313 */             agg_value593 = agg_value595;
/* 1314 */           }
/* 1315 */           boolean agg_isNull580 = false;
/* 1316 */           double agg_value615 = -1.0;
/* 1317 */           if (!false && agg_isNull428) {
/* 1318 */             double agg_value616 = agg_fastAggBuffer.getDouble(17);
/* 1319 */             agg_isNull580 = false;
/* 1320 */             agg_value615 = agg_value616;
/* 1321 */           } else {
/* 1322 */             boolean agg_isNull582 = false;
/* 1323 */
/* 1324 */             double agg_value618 = agg_fastAggBuffer.getDouble(17);
/* 1325 */
/* 1326 */             double agg_value617 = -1.0;
/* 1327 */             agg_value617 = agg_value618 + 1.0D;
/* 1328 */             agg_isNull580 = false;
/* 1329 */             agg_value615 = agg_value617;
/* 1330 */           }
/* 1331 */           boolean agg_isNull585 = false;
/* 1332 */           double agg_value620 = -1.0;
/* 1333 */           if (!false && agg_isNull428) {
/* 1334 */             double agg_value621 = agg_fastAggBuffer.getDouble(18);
/* 1335 */             agg_isNull585 = false;
/* 1336 */             agg_value620 = agg_value621;
/* 1337 */           } else {
/* 1338 */             boolean agg_isNull587 = true;
/* 1339 */             double agg_value622 = -1.0;
/* 1340 */
/* 1341 */             double agg_value623 = agg_fastAggBuffer.getDouble(18);
/* 1342 */
/* 1343 */             boolean agg_isNull594 = false;
/* 1344 */
/* 1345 */             double agg_value630 = agg_fastAggBuffer.getDouble(17);
/* 1346 */
/* 1347 */             double agg_value629 = -1.0;
/* 1348 */             agg_value629 = agg_value630 + 1.0D;
/* 1349 */             boolean agg_isNull589 = false;
/* 1350 */             double agg_value624 = -1.0;
/* 1351 */             if (false || agg_value629 == 0) {
/* 1352 */               agg_isNull589 = true;
/* 1353 */             } else {
/* 1354 */               boolean agg_isNull590 = true;
/* 1355 */               double agg_value625 = -1.0;
/* 1356 */
/* 1357 */               boolean agg_isNull591 = smj_isNull12;
/* 1358 */               double agg_value626 = -1.0;
/* 1359 */               if (!smj_isNull12) {
/* 1360 */                 agg_value626 = (double) smj_value16;
/* 1361 */               }
/* 1362 */               if (!agg_isNull591) {
/* 1363 */                 double agg_value628 = agg_fastAggBuffer.getDouble(18);
/* 1364 */
/* 1365 */                 agg_isNull590 = false; // resultCode could change nullability.
/* 1366 */                 agg_value625 = agg_value626 - agg_value628;
/* 1367 */
/* 1368 */               }
/* 1369 */               if (agg_isNull590) {
/* 1370 */                 agg_isNull589 = true;
/* 1371 */               } else {
/* 1372 */                 agg_value624 = (double)(agg_value625 / agg_value629);
/* 1373 */               }
/* 1374 */             }
/* 1375 */             if (!agg_isNull589) {
/* 1376 */               agg_isNull587 = false; // resultCode could change nullability.
/* 1377 */               agg_value622 = agg_value623 + agg_value624;
/* 1378 */
/* 1379 */             }
/* 1380 */             agg_isNull585 = agg_isNull587;
/* 1381 */             agg_value620 = agg_value622;
/* 1382 */           }
/* 1383 */           boolean agg_isNull597 = false;
/* 1384 */           double agg_value632 = -1.0;
/* 1385 */           if (!false && agg_isNull428) {
/* 1386 */             double agg_value633 = agg_fastAggBuffer.getDouble(19);
/* 1387 */             agg_isNull597 = false;
/* 1388 */             agg_value632 = agg_value633;
/* 1389 */           } else {
/* 1390 */             boolean agg_isNull599 = true;
/* 1391 */             double agg_value634 = -1.0;
/* 1392 */
/* 1393 */             double agg_value635 = agg_fastAggBuffer.getDouble(19);
/* 1394 */
/* 1395 */             boolean agg_isNull601 = true;
/* 1396 */             double agg_value636 = -1.0;
/* 1397 */
/* 1398 */             boolean agg_isNull602 = true;
/* 1399 */             double agg_value637 = -1.0;
/* 1400 */
/* 1401 */             boolean agg_isNull603 = smj_isNull12;
/* 1402 */             double agg_value638 = -1.0;
/* 1403 */             if (!smj_isNull12) {
/* 1404 */               agg_value638 = (double) smj_value16;
/* 1405 */             }
/* 1406 */             if (!agg_isNull603) {
/* 1407 */               double agg_value640 = agg_fastAggBuffer.getDouble(18);
/* 1408 */
/* 1409 */               agg_isNull602 = false; // resultCode could change nullability.
/* 1410 */               agg_value637 = agg_value638 - agg_value640;
/* 1411 */
/* 1412 */             }
/* 1413 */             if (!agg_isNull602) {
/* 1414 */               boolean agg_isNull606 = true;
/* 1415 */               double agg_value641 = -1.0;
/* 1416 */
/* 1417 */               boolean agg_isNull607 = true;
/* 1418 */               double agg_value642 = -1.0;
/* 1419 */
/* 1420 */               boolean agg_isNull608 = smj_isNull12;
/* 1421 */               double agg_value643 = -1.0;
/* 1422 */               if (!smj_isNull12) {
/* 1423 */                 agg_value643 = (double) smj_value16;
/* 1424 */               }
/* 1425 */               if (!agg_isNull608) {
/* 1426 */                 double agg_value645 = agg_fastAggBuffer.getDouble(18);
/* 1427 */
/* 1428 */                 agg_isNull607 = false; // resultCode could change nullability.
/* 1429 */                 agg_value642 = agg_value643 - agg_value645;
/* 1430 */
/* 1431 */               }
/* 1432 */               if (!agg_isNull607) {
/* 1433 */                 boolean agg_isNull616 = false;
/* 1434 */
/* 1435 */                 double agg_value652 = agg_fastAggBuffer.getDouble(17);
/* 1436 */
/* 1437 */                 double agg_value651 = -1.0;
/* 1438 */                 agg_value651 = agg_value652 + 1.0D;
/* 1439 */                 boolean agg_isNull611 = false;
/* 1440 */                 double agg_value646 = -1.0;
/* 1441 */                 if (false || agg_value651 == 0) {
/* 1442 */                   agg_isNull611 = true;
/* 1443 */                 } else {
/* 1444 */                   boolean agg_isNull612 = true;
/* 1445 */                   double agg_value647 = -1.0;
/* 1446 */
/* 1447 */                   boolean agg_isNull613 = smj_isNull12;
/* 1448 */                   double agg_value648 = -1.0;
/* 1449 */                   if (!smj_isNull12) {
/* 1450 */                     agg_value648 = (double) smj_value16;
/* 1451 */                   }
/* 1452 */                   if (!agg_isNull613) {
/* 1453 */                     double agg_value650 = agg_fastAggBuffer.getDouble(18);
/* 1454 */
/* 1455 */                     agg_isNull612 = false; // resultCode could change nullability.
/* 1456 */                     agg_value647 = agg_value648 - agg_value650;
/* 1457 */
/* 1458 */                   }
/* 1459 */                   if (agg_isNull612) {
/* 1460 */                     agg_isNull611 = true;
/* 1461 */                   } else {
/* 1462 */                     agg_value646 = (double)(agg_value647 / agg_value651);
/* 1463 */                   }
/* 1464 */                 }
/* 1465 */                 if (!agg_isNull611) {
/* 1466 */                   agg_isNull606 = false; // resultCode could change nullability.
/* 1467 */                   agg_value641 = agg_value642 - agg_value646;
/* 1468 */
/* 1469 */                 }
/* 1470 */
/* 1471 */               }
/* 1472 */               if (!agg_isNull606) {
/* 1473 */                 agg_isNull601 = false; // resultCode could change nullability.
/* 1474 */                 agg_value636 = agg_value637 * agg_value641;
/* 1475 */
/* 1476 */               }
/* 1477 */
/* 1478 */             }
/* 1479 */             if (!agg_isNull601) {
/* 1480 */               agg_isNull599 = false; // resultCode could change nullability.
/* 1481 */               agg_value634 = agg_value635 + agg_value636;
/* 1482 */
/* 1483 */             }
/* 1484 */             agg_isNull597 = agg_isNull599;
/* 1485 */             agg_value632 = agg_value634;
/* 1486 */           }
/* 1487 */           boolean agg_isNull619 = true;
/* 1488 */           double agg_value654 = -1.0;
/* 1489 */
/* 1490 */           boolean agg_isNull620 = agg_fastAggBuffer.isNullAt(20);
/* 1491 */           double agg_value655 = agg_isNull620 ? -1.0 : (agg_fastAggBuffer.getDouble(20));
/* 1492 */           if (!agg_isNull620) {
/* 1493 */             agg_isNull619 = false; // resultCode could change nullability.
/* 1494 */             agg_value654 = agg_value655 + agg_value449;
/* 1495 */
/* 1496 */           }
/* 1497 */           boolean agg_isNull621 = false;
/* 1498 */           long agg_value656 = -1L;
/* 1499 */           if (!false && smj_isNull12) {
/* 1500 */             boolean agg_isNull622 = agg_fastAggBuffer.isNullAt(21);
/* 1501 */             long agg_value657 = agg_isNull622 ? -1L : (agg_fastAggBuffer.getLong(21));
/* 1502 */             agg_isNull621 = agg_isNull622;
/* 1503 */             agg_value656 = agg_value657;
/* 1504 */           } else {
/* 1505 */             boolean agg_isNull623 = true;
/* 1506 */             long agg_value658 = -1L;
/* 1507 */
/* 1508 */             boolean agg_isNull624 = agg_fastAggBuffer.isNullAt(21);
/* 1509 */             long agg_value659 = agg_isNull624 ? -1L : (agg_fastAggBuffer.getLong(21));
/* 1510 */             if (!agg_isNull624) {
/* 1511 */               agg_isNull623 = false; // resultCode could change nullability.
/* 1512 */               agg_value658 = agg_value659 + 1L;
/* 1513 */
/* 1514 */             }
/* 1515 */             agg_isNull621 = agg_isNull623;
/* 1516 */             agg_value656 = agg_value658;
/* 1517 */           }
/* 1518 */           boolean agg_isNull626 = false;
/* 1519 */           long agg_value661 = -1L;
/* 1520 */           if (!false && smj_isNull16) {
/* 1521 */             long agg_value664 = agg_fastAggBuffer.getLong(22);
/* 1522 */             agg_isNull626 = false;
/* 1523 */             agg_value661 = agg_value664;
/* 1524 */           } else {
/* 1525 */             boolean agg_isNull630 = false;
/* 1526 */
/* 1527 */             long agg_value666 = agg_fastAggBuffer.getLong(22);
/* 1528 */
/* 1529 */             long agg_value665 = -1L;
/* 1530 */             agg_value665 = agg_value666 + 1L;
/* 1531 */             agg_isNull626 = false;
/* 1532 */             agg_value661 = agg_value665;
/* 1533 */           }
/* 1534 */           boolean agg_isNull633 = true;
/* 1535 */           double agg_value668 = -1.0;
/* 1536 */
/* 1537 */           boolean agg_isNull634 = agg_fastAggBuffer.isNullAt(23);
/* 1538 */           double agg_value669 = agg_isNull634 ? -1.0 : (agg_fastAggBuffer.getDouble(23));
/* 1539 */           if (!agg_isNull634) {
/* 1540 */             agg_isNull633 = false; // resultCode could change nullability.
/* 1541 */             agg_value668 = agg_value669 + agg_value437;
/* 1542 */
/* 1543 */           }
/* 1544 */           boolean agg_isNull635 = false;
/* 1545 */           long agg_value670 = -1L;
/* 1546 */           if (!false && agg_isNull409) {
/* 1547 */             boolean agg_isNull636 = agg_fastAggBuffer.isNullAt(24);
/* 1548 */             long agg_value671 = agg_isNull636 ? -1L : (agg_fastAggBuffer.getLong(24));
/* 1549 */             agg_isNull635 = agg_isNull636;
/* 1550 */             agg_value670 = agg_value671;
/* 1551 */           } else {
/* 1552 */             boolean agg_isNull637 = true;
/* 1553 */             long agg_value672 = -1L;
/* 1554 */
/* 1555 */             boolean agg_isNull638 = agg_fastAggBuffer.isNullAt(24);
/* 1556 */             long agg_value673 = agg_isNull638 ? -1L : (agg_fastAggBuffer.getLong(24));
/* 1557 */             if (!agg_isNull638) {
/* 1558 */               agg_isNull637 = false; // resultCode could change nullability.
/* 1559 */               agg_value672 = agg_value673 + 1L;
/* 1560 */
/* 1561 */             }
/* 1562 */             agg_isNull635 = agg_isNull637;
/* 1563 */             agg_value670 = agg_value672;
/* 1564 */           }
/* 1565 */           boolean agg_isNull640 = false;
/* 1566 */           double agg_value675 = -1.0;
/* 1567 */           if (!false && agg_isNull400) {
/* 1568 */             double agg_value676 = agg_fastAggBuffer.getDouble(25);
/* 1569 */             agg_isNull640 = false;
/* 1570 */             agg_value675 = agg_value676;
/* 1571 */           } else {
/* 1572 */             boolean agg_isNull642 = false;
/* 1573 */
/* 1574 */             double agg_value678 = agg_fastAggBuffer.getDouble(25);
/* 1575 */
/* 1576 */             double agg_value677 = -1.0;
/* 1577 */             agg_value677 = agg_value678 + 1.0D;
/* 1578 */             agg_isNull640 = false;
/* 1579 */             agg_value675 = agg_value677;
/* 1580 */           }
/* 1581 */           boolean agg_isNull645 = false;
/* 1582 */           double agg_value680 = -1.0;
/* 1583 */           if (!false && agg_isNull400) {
/* 1584 */             double agg_value681 = agg_fastAggBuffer.getDouble(26);
/* 1585 */             agg_isNull645 = false;
/* 1586 */             agg_value680 = agg_value681;
/* 1587 */           } else {
/* 1588 */             boolean agg_isNull647 = true;
/* 1589 */             double agg_value682 = -1.0;
/* 1590 */
/* 1591 */             double agg_value683 = agg_fastAggBuffer.getDouble(26);
/* 1592 */
/* 1593 */             boolean agg_isNull654 = false;
/* 1594 */
/* 1595 */             double agg_value690 = agg_fastAggBuffer.getDouble(25);
/* 1596 */
/* 1597 */             double agg_value689 = -1.0;
/* 1598 */             agg_value689 = agg_value690 + 1.0D;
/* 1599 */             boolean agg_isNull649 = false;
/* 1600 */             double agg_value684 = -1.0;
/* 1601 */             if (false || agg_value689 == 0) {
/* 1602 */               agg_isNull649 = true;
/* 1603 */             } else {
/* 1604 */               boolean agg_isNull650 = true;
/* 1605 */               double agg_value685 = -1.0;
/* 1606 */
/* 1607 */               boolean agg_isNull651 = smj_isNull16;
/* 1608 */               double agg_value686 = -1.0;
/* 1609 */               if (!smj_isNull16) {
/* 1610 */                 agg_value686 = (double) smj_value20;
/* 1611 */               }
/* 1612 */               if (!agg_isNull651) {
/* 1613 */                 double agg_value688 = agg_fastAggBuffer.getDouble(26);
/* 1614 */
/* 1615 */                 agg_isNull650 = false; // resultCode could change nullability.
/* 1616 */                 agg_value685 = agg_value686 - agg_value688;
/* 1617 */
/* 1618 */               }
/* 1619 */               if (agg_isNull650) {
/* 1620 */                 agg_isNull649 = true;
/* 1621 */               } else {
/* 1622 */                 agg_value684 = (double)(agg_value685 / agg_value689);
/* 1623 */               }
/* 1624 */             }
/* 1625 */             if (!agg_isNull649) {
/* 1626 */               agg_isNull647 = false; // resultCode could change nullability.
/* 1627 */               agg_value682 = agg_value683 + agg_value684;
/* 1628 */
/* 1629 */             }
/* 1630 */             agg_isNull645 = agg_isNull647;
/* 1631 */             agg_value680 = agg_value682;
/* 1632 */           }
/* 1633 */           boolean agg_isNull657 = false;
/* 1634 */           double agg_value692 = -1.0;
/* 1635 */           if (!false && agg_isNull400) {
/* 1636 */             double agg_value693 = agg_fastAggBuffer.getDouble(27);
/* 1637 */             agg_isNull657 = false;
/* 1638 */             agg_value692 = agg_value693;
/* 1639 */           } else {
/* 1640 */             boolean agg_isNull659 = true;
/* 1641 */             double agg_value694 = -1.0;
/* 1642 */
/* 1643 */             double agg_value695 = agg_fastAggBuffer.getDouble(27);
/* 1644 */
/* 1645 */             boolean agg_isNull661 = true;
/* 1646 */             double agg_value696 = -1.0;
/* 1647 */
/* 1648 */             boolean agg_isNull662 = true;
/* 1649 */             double agg_value697 = -1.0;
/* 1650 */
/* 1651 */             boolean agg_isNull663 = smj_isNull16;
/* 1652 */             double agg_value698 = -1.0;
/* 1653 */             if (!smj_isNull16) {
/* 1654 */               agg_value698 = (double) smj_value20;
/* 1655 */             }
/* 1656 */             if (!agg_isNull663) {
/* 1657 */               double agg_value700 = agg_fastAggBuffer.getDouble(26);
/* 1658 */
/* 1659 */               agg_isNull662 = false; // resultCode could change nullability.
/* 1660 */               agg_value697 = agg_value698 - agg_value700;
/* 1661 */
/* 1662 */             }
/* 1663 */             if (!agg_isNull662) {
/* 1664 */               boolean agg_isNull666 = true;
/* 1665 */               double agg_value701 = -1.0;
/* 1666 */
/* 1667 */               boolean agg_isNull667 = true;
/* 1668 */               double agg_value702 = -1.0;
/* 1669 */
/* 1670 */               boolean agg_isNull668 = smj_isNull16;
/* 1671 */               double agg_value703 = -1.0;
/* 1672 */               if (!smj_isNull16) {
/* 1673 */                 agg_value703 = (double) smj_value20;
/* 1674 */               }
/* 1675 */               if (!agg_isNull668) {
/* 1676 */                 double agg_value705 = agg_fastAggBuffer.getDouble(26);
/* 1677 */
/* 1678 */                 agg_isNull667 = false; // resultCode could change nullability.
/* 1679 */                 agg_value702 = agg_value703 - agg_value705;
/* 1680 */
/* 1681 */               }
/* 1682 */               if (!agg_isNull667) {
/* 1683 */                 boolean agg_isNull676 = false;
/* 1684 */
/* 1685 */                 double agg_value712 = agg_fastAggBuffer.getDouble(25);
/* 1686 */
/* 1687 */                 double agg_value711 = -1.0;
/* 1688 */                 agg_value711 = agg_value712 + 1.0D;
/* 1689 */                 boolean agg_isNull671 = false;
/* 1690 */                 double agg_value706 = -1.0;
/* 1691 */                 if (false || agg_value711 == 0) {
/* 1692 */                   agg_isNull671 = true;
/* 1693 */                 } else {
/* 1694 */                   boolean agg_isNull672 = true;
/* 1695 */                   double agg_value707 = -1.0;
/* 1696 */
/* 1697 */                   boolean agg_isNull673 = smj_isNull16;
/* 1698 */                   double agg_value708 = -1.0;
/* 1699 */                   if (!smj_isNull16) {
/* 1700 */                     agg_value708 = (double) smj_value20;
/* 1701 */                   }
/* 1702 */                   if (!agg_isNull673) {
/* 1703 */                     double agg_value710 = agg_fastAggBuffer.getDouble(26);
/* 1704 */
/* 1705 */                     agg_isNull672 = false; // resultCode could change nullability.
/* 1706 */                     agg_value707 = agg_value708 - agg_value710;
/* 1707 */
/* 1708 */                   }
/* 1709 */                   if (agg_isNull672) {
/* 1710 */                     agg_isNull671 = true;
/* 1711 */                   } else {
/* 1712 */                     agg_value706 = (double)(agg_value707 / agg_value711);
/* 1713 */                   }
/* 1714 */                 }
/* 1715 */                 if (!agg_isNull671) {
/* 1716 */                   agg_isNull666 = false; // resultCode could change nullability.
/* 1717 */                   agg_value701 = agg_value702 - agg_value706;
/* 1718 */
/* 1719 */                 }
/* 1720 */
/* 1721 */               }
/* 1722 */               if (!agg_isNull666) {
/* 1723 */                 agg_isNull661 = false; // resultCode could change nullability.
/* 1724 */                 agg_value696 = agg_value697 * agg_value701;
/* 1725 */
/* 1726 */               }
/* 1727 */
/* 1728 */             }
/* 1729 */             if (!agg_isNull661) {
/* 1730 */               agg_isNull659 = false; // resultCode could change nullability.
/* 1731 */               agg_value694 = agg_value695 + agg_value696;
/* 1732 */
/* 1733 */             }
/* 1734 */             agg_isNull657 = agg_isNull659;
/* 1735 */             agg_value692 = agg_value694;
/* 1736 */           }
/* 1737 */           boolean agg_isNull679 = true;
/* 1738 */           double agg_value714 = -1.0;
/* 1739 */
/* 1740 */           boolean agg_isNull680 = agg_fastAggBuffer.isNullAt(28);
/* 1741 */           double agg_value715 = agg_isNull680 ? -1.0 : (agg_fastAggBuffer.getDouble(28));
/* 1742 */           if (!agg_isNull680) {
/* 1743 */             agg_isNull679 = false; // resultCode could change nullability.
/* 1744 */             agg_value714 = agg_value715 + agg_value437;
/* 1745 */
/* 1746 */           }
/* 1747 */           boolean agg_isNull681 = false;
/* 1748 */           long agg_value716 = -1L;
/* 1749 */           if (!false && agg_isNull409) {
/* 1750 */             boolean agg_isNull682 = agg_fastAggBuffer.isNullAt(29);
/* 1751 */             long agg_value717 = agg_isNull682 ? -1L : (agg_fastAggBuffer.getLong(29));
/* 1752 */             agg_isNull681 = agg_isNull682;
/* 1753 */             agg_value716 = agg_value717;
/* 1754 */           } else {
/* 1755 */             boolean agg_isNull683 = true;
/* 1756 */             long agg_value718 = -1L;
/* 1757 */
/* 1758 */             boolean agg_isNull684 = agg_fastAggBuffer.isNullAt(29);
/* 1759 */             long agg_value719 = agg_isNull684 ? -1L : (agg_fastAggBuffer.getLong(29));
/* 1760 */             if (!agg_isNull684) {
/* 1761 */               agg_isNull683 = false; // resultCode could change nullability.
/* 1762 */               agg_value718 = agg_value719 + 1L;
/* 1763 */
/* 1764 */             }
/* 1765 */             agg_isNull681 = agg_isNull683;
/* 1766 */             agg_value716 = agg_value718;
/* 1767 */           }
/* 1768 */           boolean agg_isNull686 = false;
/* 1769 */           double agg_value721 = -1.0;
/* 1770 */           if (!false && agg_isNull400) {
/* 1771 */             double agg_value722 = agg_fastAggBuffer.getDouble(30);
/* 1772 */             agg_isNull686 = false;
/* 1773 */             agg_value721 = agg_value722;
/* 1774 */           } else {
/* 1775 */             boolean agg_isNull688 = false;
/* 1776 */
/* 1777 */             double agg_value724 = agg_fastAggBuffer.getDouble(30);
/* 1778 */
/* 1779 */             double agg_value723 = -1.0;
/* 1780 */             agg_value723 = agg_value724 + 1.0D;
/* 1781 */             agg_isNull686 = false;
/* 1782 */             agg_value721 = agg_value723;
/* 1783 */           }
/* 1784 */           boolean agg_isNull691 = false;
/* 1785 */           double agg_value726 = -1.0;
/* 1786 */           if (!false && agg_isNull400) {
/* 1787 */             double agg_value727 = agg_fastAggBuffer.getDouble(31);
/* 1788 */             agg_isNull691 = false;
/* 1789 */             agg_value726 = agg_value727;
/* 1790 */           } else {
/* 1791 */             boolean agg_isNull693 = true;
/* 1792 */             double agg_value728 = -1.0;
/* 1793 */
/* 1794 */             double agg_value729 = agg_fastAggBuffer.getDouble(31);
/* 1795 */
/* 1796 */             boolean agg_isNull700 = false;
/* 1797 */
/* 1798 */             double agg_value736 = agg_fastAggBuffer.getDouble(30);
/* 1799 */
/* 1800 */             double agg_value735 = -1.0;
/* 1801 */             agg_value735 = agg_value736 + 1.0D;
/* 1802 */             boolean agg_isNull695 = false;
/* 1803 */             double agg_value730 = -1.0;
/* 1804 */             if (false || agg_value735 == 0) {
/* 1805 */               agg_isNull695 = true;
/* 1806 */             } else {
/* 1807 */               boolean agg_isNull696 = true;
/* 1808 */               double agg_value731 = -1.0;
/* 1809 */
/* 1810 */               boolean agg_isNull697 = smj_isNull16;
/* 1811 */               double agg_value732 = -1.0;
/* 1812 */               if (!smj_isNull16) {
/* 1813 */                 agg_value732 = (double) smj_value20;
/* 1814 */               }
/* 1815 */               if (!agg_isNull697) {
/* 1816 */                 double agg_value734 = agg_fastAggBuffer.getDouble(31);
/* 1817 */
/* 1818 */                 agg_isNull696 = false; // resultCode could change nullability.
/* 1819 */                 agg_value731 = agg_value732 - agg_value734;
/* 1820 */
/* 1821 */               }
/* 1822 */               if (agg_isNull696) {
/* 1823 */                 agg_isNull695 = true;
/* 1824 */               } else {
/* 1825 */                 agg_value730 = (double)(agg_value731 / agg_value735);
/* 1826 */               }
/* 1827 */             }
/* 1828 */             if (!agg_isNull695) {
/* 1829 */               agg_isNull693 = false; // resultCode could change nullability.
/* 1830 */               agg_value728 = agg_value729 + agg_value730;
/* 1831 */
/* 1832 */             }
/* 1833 */             agg_isNull691 = agg_isNull693;
/* 1834 */             agg_value726 = agg_value728;
/* 1835 */           }
/* 1836 */           boolean agg_isNull703 = false;
/* 1837 */           double agg_value738 = -1.0;
/* 1838 */           if (!false && agg_isNull400) {
/* 1839 */             double agg_value739 = agg_fastAggBuffer.getDouble(32);
/* 1840 */             agg_isNull703 = false;
/* 1841 */             agg_value738 = agg_value739;
/* 1842 */           } else {
/* 1843 */             boolean agg_isNull705 = true;
/* 1844 */             double agg_value740 = -1.0;
/* 1845 */
/* 1846 */             double agg_value741 = agg_fastAggBuffer.getDouble(32);
/* 1847 */
/* 1848 */             boolean agg_isNull707 = true;
/* 1849 */             double agg_value742 = -1.0;
/* 1850 */
/* 1851 */             boolean agg_isNull708 = true;
/* 1852 */             double agg_value743 = -1.0;
/* 1853 */
/* 1854 */             boolean agg_isNull709 = smj_isNull16;
/* 1855 */             double agg_value744 = -1.0;
/* 1856 */             if (!smj_isNull16) {
/* 1857 */               agg_value744 = (double) smj_value20;
/* 1858 */             }
/* 1859 */             if (!agg_isNull709) {
/* 1860 */               double agg_value746 = agg_fastAggBuffer.getDouble(31);
/* 1861 */
/* 1862 */               agg_isNull708 = false; // resultCode could change nullability.
/* 1863 */               agg_value743 = agg_value744 - agg_value746;
/* 1864 */
/* 1865 */             }
/* 1866 */             if (!agg_isNull708) {
/* 1867 */               boolean agg_isNull712 = true;
/* 1868 */               double agg_value747 = -1.0;
/* 1869 */
/* 1870 */               boolean agg_isNull713 = true;
/* 1871 */               double agg_value748 = -1.0;
/* 1872 */
/* 1873 */               boolean agg_isNull714 = smj_isNull16;
/* 1874 */               double agg_value749 = -1.0;
/* 1875 */               if (!smj_isNull16) {
/* 1876 */                 agg_value749 = (double) smj_value20;
/* 1877 */               }
/* 1878 */               if (!agg_isNull714) {
/* 1879 */                 double agg_value751 = agg_fastAggBuffer.getDouble(31);
/* 1880 */
/* 1881 */                 agg_isNull713 = false; // resultCode could change nullability.
/* 1882 */                 agg_value748 = agg_value749 - agg_value751;
/* 1883 */
/* 1884 */               }
/* 1885 */               if (!agg_isNull713) {
/* 1886 */                 boolean agg_isNull722 = false;
/* 1887 */
/* 1888 */                 double agg_value758 = agg_fastAggBuffer.getDouble(30);
/* 1889 */
/* 1890 */                 double agg_value757 = -1.0;
/* 1891 */                 agg_value757 = agg_value758 + 1.0D;
/* 1892 */                 boolean agg_isNull717 = false;
/* 1893 */                 double agg_value752 = -1.0;
/* 1894 */                 if (false || agg_value757 == 0) {
/* 1895 */                   agg_isNull717 = true;
/* 1896 */                 } else {
/* 1897 */                   boolean agg_isNull718 = true;
/* 1898 */                   double agg_value753 = -1.0;
/* 1899 */
/* 1900 */                   boolean agg_isNull719 = smj_isNull16;
/* 1901 */                   double agg_value754 = -1.0;
/* 1902 */                   if (!smj_isNull16) {
/* 1903 */                     agg_value754 = (double) smj_value20;
/* 1904 */                   }
/* 1905 */                   if (!agg_isNull719) {
/* 1906 */                     double agg_value756 = agg_fastAggBuffer.getDouble(31);
/* 1907 */
/* 1908 */                     agg_isNull718 = false; // resultCode could change nullability.
/* 1909 */                     agg_value753 = agg_value754 - agg_value756;
/* 1910 */
/* 1911 */                   }
/* 1912 */                   if (agg_isNull718) {
/* 1913 */                     agg_isNull717 = true;
/* 1914 */                   } else {
/* 1915 */                     agg_value752 = (double)(agg_value753 / agg_value757);
/* 1916 */                   }
/* 1917 */                 }
/* 1918 */                 if (!agg_isNull717) {
/* 1919 */                   agg_isNull712 = false; // resultCode could change nullability.
/* 1920 */                   agg_value747 = agg_value748 - agg_value752;
/* 1921 */
/* 1922 */                 }
/* 1923 */
/* 1924 */               }
/* 1925 */               if (!agg_isNull712) {
/* 1926 */                 agg_isNull707 = false; // resultCode could change nullability.
/* 1927 */                 agg_value742 = agg_value743 * agg_value747;
/* 1928 */
/* 1929 */               }
/* 1930 */
/* 1931 */             }
/* 1932 */             if (!agg_isNull707) {
/* 1933 */               agg_isNull705 = false; // resultCode could change nullability.
/* 1934 */               agg_value740 = agg_value741 + agg_value742;
/* 1935 */
/* 1936 */             }
/* 1937 */             agg_isNull703 = agg_isNull705;
/* 1938 */             agg_value738 = agg_value740;
/* 1939 */           }
/* 1940 */           boolean agg_isNull725 = true;
/* 1941 */           double agg_value760 = -1.0;
/* 1942 */
/* 1943 */           boolean agg_isNull726 = agg_fastAggBuffer.isNullAt(33);
/* 1944 */           double agg_value761 = agg_isNull726 ? -1.0 : (agg_fastAggBuffer.getDouble(33));
/* 1945 */           if (!agg_isNull726) {
/* 1946 */             agg_isNull725 = false; // resultCode could change nullability.
/* 1947 */             agg_value760 = agg_value761 + agg_value437;
/* 1948 */
/* 1949 */           }
/* 1950 */           boolean agg_isNull727 = false;
/* 1951 */           long agg_value762 = -1L;
/* 1952 */           if (!false && agg_isNull409) {
/* 1953 */             boolean agg_isNull728 = agg_fastAggBuffer.isNullAt(34);
/* 1954 */             long agg_value763 = agg_isNull728 ? -1L : (agg_fastAggBuffer.getLong(34));
/* 1955 */             agg_isNull727 = agg_isNull728;
/* 1956 */             agg_value762 = agg_value763;
/* 1957 */           } else {
/* 1958 */             boolean agg_isNull729 = true;
/* 1959 */             long agg_value764 = -1L;
/* 1960 */
/* 1961 */             boolean agg_isNull730 = agg_fastAggBuffer.isNullAt(34);
/* 1962 */             long agg_value765 = agg_isNull730 ? -1L : (agg_fastAggBuffer.getLong(34));
/* 1963 */             if (!agg_isNull730) {
/* 1964 */               agg_isNull729 = false; // resultCode could change nullability.
/* 1965 */               agg_value764 = agg_value765 + 1L;
/* 1966 */
/* 1967 */             }
/* 1968 */             agg_isNull727 = agg_isNull729;
/* 1969 */             agg_value762 = agg_value764;
/* 1970 */           }
/* 1971 */           // update fast row
/* 1972 */           agg_fastAggBuffer.setLong(0, agg_value465);
/* 1973 */
/* 1974 */           if (!agg_isNull437) {
/* 1975 */             agg_fastAggBuffer.setDouble(1, agg_value472);
/* 1976 */           } else {
/* 1977 */             agg_fastAggBuffer.setNullAt(1);
/* 1978 */           }
/* 1979 */
/* 1980 */           if (!agg_isNull439) {
/* 1981 */             agg_fastAggBuffer.setLong(2, agg_value474);
/* 1982 */           } else {
/* 1983 */             agg_fastAggBuffer.setNullAt(2);
/* 1984 */           }
/* 1985 */
/* 1986 */           agg_fastAggBuffer.setDouble(3, agg_value479);
/* 1987 */
/* 1988 */           if (!agg_isNull449) {
/* 1989 */             agg_fastAggBuffer.setDouble(4, agg_value484);
/* 1990 */           } else {
/* 1991 */             agg_fastAggBuffer.setNullAt(4);
/* 1992 */           }
/* 1993 */
/* 1994 */           if (!agg_isNull461) {
/* 1995 */             agg_fastAggBuffer.setDouble(5, agg_value496);
/* 1996 */           } else {
/* 1997 */             agg_fastAggBuffer.setNullAt(5);
/* 1998 */           }
/* 1999 */
/* 2000 */           agg_fastAggBuffer.setDouble(6, agg_value518);
/* 2001 */
/* 2002 */           if (!agg_isNull488) {
/* 2003 */             agg_fastAggBuffer.setDouble(7, agg_value523);
/* 2004 */           } else {
/* 2005 */             agg_fastAggBuffer.setNullAt(7);
/* 2006 */           }
/* 2007 */
/* 2008 */           if (!agg_isNull500) {
/* 2009 */             agg_fastAggBuffer.setDouble(8, agg_value535);
/* 2010 */           } else {
/* 2011 */             agg_fastAggBuffer.setNullAt(8);
/* 2012 */           }
/* 2013 */
/* 2014 */           if (!agg_isNull522) {
/* 2015 */             agg_fastAggBuffer.setDouble(9, agg_value557);
/* 2016 */           } else {
/* 2017 */             agg_fastAggBuffer.setNullAt(9);
/* 2018 */           }
/* 2019 */
/* 2020 */           if (!agg_isNull524) {
/* 2021 */             agg_fastAggBuffer.setLong(10, agg_value559);
/* 2022 */           } else {
/* 2023 */             agg_fastAggBuffer.setNullAt(10);
/* 2024 */           }
/* 2025 */
/* 2026 */           agg_fastAggBuffer.setLong(11, agg_value564);
/* 2027 */
/* 2028 */           if (!agg_isNull534) {
/* 2029 */             agg_fastAggBuffer.setDouble(12, agg_value569);
/* 2030 */           } else {
/* 2031 */             agg_fastAggBuffer.setNullAt(12);
/* 2032 */           }
/* 2033 */
/* 2034 */           if (!agg_isNull536) {
/* 2035 */             agg_fastAggBuffer.setLong(13, agg_value571);
/* 2036 */           } else {
/* 2037 */             agg_fastAggBuffer.setNullAt(13);
/* 2038 */           }
/* 2039 */
/* 2040 */           agg_fastAggBuffer.setDouble(14, agg_value576);
/* 2041 */
/* 2042 */           if (!agg_isNull546) {
/* 2043 */             agg_fastAggBuffer.setDouble(15, agg_value581);
/* 2044 */           } else {
/* 2045 */             agg_fastAggBuffer.setNullAt(15);
/* 2046 */           }
/* 2047 */
/* 2048 */           if (!agg_isNull558) {
/* 2049 */             agg_fastAggBuffer.setDouble(16, agg_value593);
/* 2050 */           } else {
/* 2051 */             agg_fastAggBuffer.setNullAt(16);
/* 2052 */           }
/* 2053 */
/* 2054 */           agg_fastAggBuffer.setDouble(17, agg_value615);
/* 2055 */
/* 2056 */           if (!agg_isNull585) {
/* 2057 */             agg_fastAggBuffer.setDouble(18, agg_value620);
/* 2058 */           } else {
/* 2059 */             agg_fastAggBuffer.setNullAt(18);
/* 2060 */           }
/* 2061 */
/* 2062 */           if (!agg_isNull597) {
/* 2063 */             agg_fastAggBuffer.setDouble(19, agg_value632);
/* 2064 */           } else {
/* 2065 */             agg_fastAggBuffer.setNullAt(19);
/* 2066 */           }
/* 2067 */
/* 2068 */           if (!agg_isNull619) {
/* 2069 */             agg_fastAggBuffer.setDouble(20, agg_value654);
/* 2070 */           } else {
/* 2071 */             agg_fastAggBuffer.setNullAt(20);
/* 2072 */           }
/* 2073 */
/* 2074 */           if (!agg_isNull621) {
/* 2075 */             agg_fastAggBuffer.setLong(21, agg_value656);
/* 2076 */           } else {
/* 2077 */             agg_fastAggBuffer.setNullAt(21);
/* 2078 */           }
/* 2079 */
/* 2080 */           agg_fastAggBuffer.setLong(22, agg_value661);
/* 2081 */
/* 2082 */           if (!agg_isNull633) {
/* 2083 */             agg_fastAggBuffer.setDouble(23, agg_value668);
/* 2084 */           } else {
/* 2085 */             agg_fastAggBuffer.setNullAt(23);
/* 2086 */           }
/* 2087 */
/* 2088 */           if (!agg_isNull635) {
/* 2089 */             agg_fastAggBuffer.setLong(24, agg_value670);
/* 2090 */           } else {
/* 2091 */             agg_fastAggBuffer.setNullAt(24);
/* 2092 */           }
/* 2093 */
/* 2094 */           agg_fastAggBuffer.setDouble(25, agg_value675);
/* 2095 */
/* 2096 */           if (!agg_isNull645) {
/* 2097 */             agg_fastAggBuffer.setDouble(26, agg_value680);
/* 2098 */           } else {
/* 2099 */             agg_fastAggBuffer.setNullAt(26);
/* 2100 */           }
/* 2101 */
/* 2102 */           if (!agg_isNull657) {
/* 2103 */             agg_fastAggBuffer.setDouble(27, agg_value692);
/* 2104 */           } else {
/* 2105 */             agg_fastAggBuffer.setNullAt(27);
/* 2106 */           }
/* 2107 */
/* 2108 */           if (!agg_isNull679) {
/* 2109 */             agg_fastAggBuffer.setDouble(28, agg_value714);
/* 2110 */           } else {
/* 2111 */             agg_fastAggBuffer.setNullAt(28);
/* 2112 */           }
/* 2113 */
/* 2114 */           if (!agg_isNull681) {
/* 2115 */             agg_fastAggBuffer.setLong(29, agg_value716);
/* 2116 */           } else {
/* 2117 */             agg_fastAggBuffer.setNullAt(29);
/* 2118 */           }
/* 2119 */
/* 2120 */           agg_fastAggBuffer.setDouble(30, agg_value721);
/* 2121 */
/* 2122 */           if (!agg_isNull691) {
/* 2123 */             agg_fastAggBuffer.setDouble(31, agg_value726);
/* 2124 */           } else {
/* 2125 */             agg_fastAggBuffer.setNullAt(31);
/* 2126 */           }
/* 2127 */
/* 2128 */           if (!agg_isNull703) {
/* 2129 */             agg_fastAggBuffer.setDouble(32, agg_value738);
/* 2130 */           } else {
/* 2131 */             agg_fastAggBuffer.setNullAt(32);
/* 2132 */           }
/* 2133 */
/* 2134 */           if (!agg_isNull725) {
/* 2135 */             agg_fastAggBuffer.setDouble(33, agg_value760);
/* 2136 */           } else {
/* 2137 */             agg_fastAggBuffer.setNullAt(33);
/* 2138 */           }
/* 2139 */
/* 2140 */           if (!agg_isNull727) {
/* 2141 */             agg_fastAggBuffer.setLong(34, agg_value762);
/* 2142 */           } else {
/* 2143 */             agg_fastAggBuffer.setNullAt(34);
/* 2144 */           }
/* 2145 */
/* 2146 */         } else {
/* 2147 */           // update unsafe row
/* 2148 */
/* 2149 */           // common sub-expressions
/* 2150 */           boolean agg_isNull52 = smj_isNull16;
/* 2151 */           long agg_value87 = -1L;
/* 2152 */           if (!smj_isNull16) {
/* 2153 */             agg_value87 = (long) smj_value20;
/* 2154 */           }
/* 2155 */           boolean agg_isNull55 = smj_isNull8;
/* 2156 */           double agg_value90 = -1.0;
/* 2157 */           if (!smj_isNull8) {
/* 2158 */             agg_value90 = (double) smj_value12;
/* 2159 */           }
/* 2160 */           boolean agg_isNull57 = smj_isNull8;
/* 2161 */           long agg_value92 = -1L;
/* 2162 */           if (!smj_isNull8) {
/* 2163 */             agg_value92 = (long) smj_value12;
/* 2164 */           }
/* 2165 */           boolean agg_isNull60 = smj_isNull16;
/* 2166 */           double agg_value95 = -1.0;
/* 2167 */           if (!smj_isNull16) {
/* 2168 */             agg_value95 = (double) smj_value20;
/* 2169 */           }
/* 2170 */           boolean agg_isNull64 = smj_isNull16;
/* 2171 */           long agg_value99 = -1L;
/* 2172 */           if (!smj_isNull16) {
/* 2173 */             agg_value99 = (long) smj_value20;
/* 2174 */           }
/* 2175 */           boolean agg_isNull63 = agg_isNull64;
/* 2176 */           double agg_value98 = -1.0;
/* 2177 */           if (!agg_isNull64) {
/* 2178 */             agg_value98 = (double) agg_value99;
/* 2179 */           }
/* 2180 */           boolean agg_isNull62 = agg_isNull63;
/* 2181 */           double agg_value97 = agg_value98;
/* 2182 */           if (agg_isNull62) {
/* 2183 */             boolean agg_isNull66 = false;
/* 2184 */             double agg_value101 = -1.0;
/* 2185 */             if (!false) {
/* 2186 */               agg_value101 = (double) 0;
/* 2187 */             }
/* 2188 */             if (!agg_isNull66) {
/* 2189 */               agg_isNull62 = false;
/* 2190 */               agg_value97 = agg_value101;
/* 2191 */             }
/* 2192 */           }
/* 2193 */           boolean agg_isNull69 = smj_isNull16;
/* 2194 */           long agg_value104 = -1L;
/* 2195 */           if (!smj_isNull16) {
/* 2196 */             agg_value104 = (long) smj_value20;
/* 2197 */           }
/* 2198 */           boolean agg_isNull72 = smj_isNull8;
/* 2199 */           long agg_value107 = -1L;
/* 2200 */           if (!smj_isNull8) {
/* 2201 */             agg_value107 = (long) smj_value12;
/* 2202 */           }
/* 2203 */           boolean agg_isNull75 = smj_isNull12;
/* 2204 */           double agg_value110 = -1.0;
/* 2205 */           if (!smj_isNull12) {
/* 2206 */             agg_value110 = (double) smj_value16;
/* 2207 */           }
/* 2208 */           boolean agg_isNull74 = agg_isNull75;
/* 2209 */           double agg_value109 = agg_value110;
/* 2210 */           if (agg_isNull74) {
/* 2211 */             boolean agg_isNull77 = false;
/* 2212 */             double agg_value112 = -1.0;
/* 2213 */             if (!false) {
/* 2214 */               agg_value112 = (double) 0;
/* 2215 */             }
/* 2216 */             if (!agg_isNull77) {
/* 2217 */               agg_isNull74 = false;
/* 2218 */               agg_value109 = agg_value112;
/* 2219 */             }
/* 2220 */           }
/* 2221 */           boolean agg_isNull81 = smj_isNull8;
/* 2222 */           long agg_value116 = -1L;
/* 2223 */           if (!smj_isNull8) {
/* 2224 */             agg_value116 = (long) smj_value12;
/* 2225 */           }
/* 2226 */           boolean agg_isNull80 = agg_isNull81;
/* 2227 */           double agg_value115 = -1.0;
/* 2228 */           if (!agg_isNull81) {
/* 2229 */             agg_value115 = (double) agg_value116;
/* 2230 */           }
/* 2231 */           boolean agg_isNull79 = agg_isNull80;
/* 2232 */           double agg_value114 = agg_value115;
/* 2233 */           if (agg_isNull79) {
/* 2234 */             boolean agg_isNull83 = false;
/* 2235 */             double agg_value118 = -1.0;
/* 2236 */             if (!false) {
/* 2237 */               agg_value118 = (double) 0;
/* 2238 */             }
/* 2239 */             if (!agg_isNull83) {
/* 2240 */               agg_isNull79 = false;
/* 2241 */               agg_value114 = agg_value118;
/* 2242 */             }
/* 2243 */           }
/* 2244 */
/* 2245 */           boolean agg_isNull88 = smj_isNull12;
/* 2246 */           double agg_value123 = -1.0;
/* 2247 */           if (!smj_isNull12) {
/* 2248 */             agg_value123 = (double) smj_value16;
/* 2249 */           }
/* 2250 */           // evaluate aggregate function
/* 2251 */           boolean agg_isNull90 = false;
/* 2252 */           long agg_value125 = -1L;
/* 2253 */           if (!false && smj_isNull8) {
/* 2254 */             long agg_value128 = agg_unsafeRowAggBuffer.getLong(0);
/* 2255 */             agg_isNull90 = false;
/* 2256 */             agg_value125 = agg_value128;
/* 2257 */           } else {
/* 2258 */             boolean agg_isNull94 = false;
/* 2259 */
/* 2260 */             long agg_value130 = agg_unsafeRowAggBuffer.getLong(0);
/* 2261 */
/* 2262 */             long agg_value129 = -1L;
/* 2263 */             agg_value129 = agg_value130 + 1L;
/* 2264 */             agg_isNull90 = false;
/* 2265 */             agg_value125 = agg_value129;
/* 2266 */           }
/* 2267 */           boolean agg_isNull97 = true;
/* 2268 */           double agg_value132 = -1.0;
/* 2269 */
/* 2270 */           boolean agg_isNull98 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 2271 */           double agg_value133 = agg_isNull98 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 2272 */           if (!agg_isNull98) {
/* 2273 */             agg_isNull97 = false; // resultCode could change nullability.
/* 2274 */             agg_value132 = agg_value133 + agg_value114;
/* 2275 */
/* 2276 */           }
/* 2277 */           boolean agg_isNull99 = false;
/* 2278 */           long agg_value134 = -1L;
/* 2279 */           if (!false && agg_isNull72) {
/* 2280 */             boolean agg_isNull100 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2281 */             long agg_value135 = agg_isNull100 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 2282 */             agg_isNull99 = agg_isNull100;
/* 2283 */             agg_value134 = agg_value135;
/* 2284 */           } else {
/* 2285 */             boolean agg_isNull101 = true;
/* 2286 */             long agg_value136 = -1L;
/* 2287 */
/* 2288 */             boolean agg_isNull102 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2289 */             long agg_value137 = agg_isNull102 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 2290 */             if (!agg_isNull102) {
/* 2291 */               agg_isNull101 = false; // resultCode could change nullability.
/* 2292 */               agg_value136 = agg_value137 + 1L;
/* 2293 */
/* 2294 */             }
/* 2295 */             agg_isNull99 = agg_isNull101;
/* 2296 */             agg_value134 = agg_value136;
/* 2297 */           }
/* 2298 */           boolean agg_isNull104 = false;
/* 2299 */           double agg_value139 = -1.0;
/* 2300 */           if (!false && agg_isNull55) {
/* 2301 */             double agg_value140 = agg_unsafeRowAggBuffer.getDouble(3);
/* 2302 */             agg_isNull104 = false;
/* 2303 */             agg_value139 = agg_value140;
/* 2304 */           } else {
/* 2305 */             boolean agg_isNull106 = false;
/* 2306 */
/* 2307 */             double agg_value142 = agg_unsafeRowAggBuffer.getDouble(3);
/* 2308 */
/* 2309 */             double agg_value141 = -1.0;
/* 2310 */             agg_value141 = agg_value142 + 1.0D;
/* 2311 */             agg_isNull104 = false;
/* 2312 */             agg_value139 = agg_value141;
/* 2313 */           }
/* 2314 */           boolean agg_isNull109 = false;
/* 2315 */           double agg_value144 = -1.0;
/* 2316 */           if (!false && agg_isNull55) {
/* 2317 */             double agg_value145 = agg_unsafeRowAggBuffer.getDouble(4);
/* 2318 */             agg_isNull109 = false;
/* 2319 */             agg_value144 = agg_value145;
/* 2320 */           } else {
/* 2321 */             boolean agg_isNull111 = true;
/* 2322 */             double agg_value146 = -1.0;
/* 2323 */
/* 2324 */             double agg_value147 = agg_unsafeRowAggBuffer.getDouble(4);
/* 2325 */
/* 2326 */             boolean agg_isNull118 = false;
/* 2327 */
/* 2328 */             double agg_value154 = agg_unsafeRowAggBuffer.getDouble(3);
/* 2329 */
/* 2330 */             double agg_value153 = -1.0;
/* 2331 */             agg_value153 = agg_value154 + 1.0D;
/* 2332 */             boolean agg_isNull113 = false;
/* 2333 */             double agg_value148 = -1.0;
/* 2334 */             if (false || agg_value153 == 0) {
/* 2335 */               agg_isNull113 = true;
/* 2336 */             } else {
/* 2337 */               boolean agg_isNull114 = true;
/* 2338 */               double agg_value149 = -1.0;
/* 2339 */
/* 2340 */               boolean agg_isNull115 = smj_isNull8;
/* 2341 */               double agg_value150 = -1.0;
/* 2342 */               if (!smj_isNull8) {
/* 2343 */                 agg_value150 = (double) smj_value12;
/* 2344 */               }
/* 2345 */               if (!agg_isNull115) {
/* 2346 */                 double agg_value152 = agg_unsafeRowAggBuffer.getDouble(4);
/* 2347 */
/* 2348 */                 agg_isNull114 = false; // resultCode could change nullability.
/* 2349 */                 agg_value149 = agg_value150 - agg_value152;
/* 2350 */
/* 2351 */               }
/* 2352 */               if (agg_isNull114) {
/* 2353 */                 agg_isNull113 = true;
/* 2354 */               } else {
/* 2355 */                 agg_value148 = (double)(agg_value149 / agg_value153);
/* 2356 */               }
/* 2357 */             }
/* 2358 */             if (!agg_isNull113) {
/* 2359 */               agg_isNull111 = false; // resultCode could change nullability.
/* 2360 */               agg_value146 = agg_value147 + agg_value148;
/* 2361 */
/* 2362 */             }
/* 2363 */             agg_isNull109 = agg_isNull111;
/* 2364 */             agg_value144 = agg_value146;
/* 2365 */           }
/* 2366 */           boolean agg_isNull121 = false;
/* 2367 */           double agg_value156 = -1.0;
/* 2368 */           if (!false && agg_isNull55) {
/* 2369 */             double agg_value157 = agg_unsafeRowAggBuffer.getDouble(5);
/* 2370 */             agg_isNull121 = false;
/* 2371 */             agg_value156 = agg_value157;
/* 2372 */           } else {
/* 2373 */             boolean agg_isNull123 = true;
/* 2374 */             double agg_value158 = -1.0;
/* 2375 */
/* 2376 */             double agg_value159 = agg_unsafeRowAggBuffer.getDouble(5);
/* 2377 */
/* 2378 */             boolean agg_isNull125 = true;
/* 2379 */             double agg_value160 = -1.0;
/* 2380 */
/* 2381 */             boolean agg_isNull126 = true;
/* 2382 */             double agg_value161 = -1.0;
/* 2383 */
/* 2384 */             boolean agg_isNull127 = smj_isNull8;
/* 2385 */             double agg_value162 = -1.0;
/* 2386 */             if (!smj_isNull8) {
/* 2387 */               agg_value162 = (double) smj_value12;
/* 2388 */             }
/* 2389 */             if (!agg_isNull127) {
/* 2390 */               double agg_value164 = agg_unsafeRowAggBuffer.getDouble(4);
/* 2391 */
/* 2392 */               agg_isNull126 = false; // resultCode could change nullability.
/* 2393 */               agg_value161 = agg_value162 - agg_value164;
/* 2394 */
/* 2395 */             }
/* 2396 */             if (!agg_isNull126) {
/* 2397 */               boolean agg_isNull130 = true;
/* 2398 */               double agg_value165 = -1.0;
/* 2399 */
/* 2400 */               boolean agg_isNull131 = true;
/* 2401 */               double agg_value166 = -1.0;
/* 2402 */
/* 2403 */               boolean agg_isNull132 = smj_isNull8;
/* 2404 */               double agg_value167 = -1.0;
/* 2405 */               if (!smj_isNull8) {
/* 2406 */                 agg_value167 = (double) smj_value12;
/* 2407 */               }
/* 2408 */               if (!agg_isNull132) {
/* 2409 */                 double agg_value169 = agg_unsafeRowAggBuffer.getDouble(4);
/* 2410 */
/* 2411 */                 agg_isNull131 = false; // resultCode could change nullability.
/* 2412 */                 agg_value166 = agg_value167 - agg_value169;
/* 2413 */
/* 2414 */               }
/* 2415 */               if (!agg_isNull131) {
/* 2416 */                 boolean agg_isNull140 = false;
/* 2417 */
/* 2418 */                 double agg_value176 = agg_unsafeRowAggBuffer.getDouble(3);
/* 2419 */
/* 2420 */                 double agg_value175 = -1.0;
/* 2421 */                 agg_value175 = agg_value176 + 1.0D;
/* 2422 */                 boolean agg_isNull135 = false;
/* 2423 */                 double agg_value170 = -1.0;
/* 2424 */                 if (false || agg_value175 == 0) {
/* 2425 */                   agg_isNull135 = true;
/* 2426 */                 } else {
/* 2427 */                   boolean agg_isNull136 = true;
/* 2428 */                   double agg_value171 = -1.0;
/* 2429 */
/* 2430 */                   boolean agg_isNull137 = smj_isNull8;
/* 2431 */                   double agg_value172 = -1.0;
/* 2432 */                   if (!smj_isNull8) {
/* 2433 */                     agg_value172 = (double) smj_value12;
/* 2434 */                   }
/* 2435 */                   if (!agg_isNull137) {
/* 2436 */                     double agg_value174 = agg_unsafeRowAggBuffer.getDouble(4);
/* 2437 */
/* 2438 */                     agg_isNull136 = false; // resultCode could change nullability.
/* 2439 */                     agg_value171 = agg_value172 - agg_value174;
/* 2440 */
/* 2441 */                   }
/* 2442 */                   if (agg_isNull136) {
/* 2443 */                     agg_isNull135 = true;
/* 2444 */                   } else {
/* 2445 */                     agg_value170 = (double)(agg_value171 / agg_value175);
/* 2446 */                   }
/* 2447 */                 }
/* 2448 */                 if (!agg_isNull135) {
/* 2449 */                   agg_isNull130 = false; // resultCode could change nullability.
/* 2450 */                   agg_value165 = agg_value166 - agg_value170;
/* 2451 */
/* 2452 */                 }
/* 2453 */
/* 2454 */               }
/* 2455 */               if (!agg_isNull130) {
/* 2456 */                 agg_isNull125 = false; // resultCode could change nullability.
/* 2457 */                 agg_value160 = agg_value161 * agg_value165;
/* 2458 */
/* 2459 */               }
/* 2460 */
/* 2461 */             }
/* 2462 */             if (!agg_isNull125) {
/* 2463 */               agg_isNull123 = false; // resultCode could change nullability.
/* 2464 */               agg_value158 = agg_value159 + agg_value160;
/* 2465 */
/* 2466 */             }
/* 2467 */             agg_isNull121 = agg_isNull123;
/* 2468 */             agg_value156 = agg_value158;
/* 2469 */           }
/* 2470 */           boolean agg_isNull143 = false;
/* 2471 */           double agg_value178 = -1.0;
/* 2472 */           if (!false && agg_isNull55) {
/* 2473 */             double agg_value179 = agg_unsafeRowAggBuffer.getDouble(6);
/* 2474 */             agg_isNull143 = false;
/* 2475 */             agg_value178 = agg_value179;
/* 2476 */           } else {
/* 2477 */             boolean agg_isNull145 = false;
/* 2478 */
/* 2479 */             double agg_value181 = agg_unsafeRowAggBuffer.getDouble(6);
/* 2480 */
/* 2481 */             double agg_value180 = -1.0;
/* 2482 */             agg_value180 = agg_value181 + 1.0D;
/* 2483 */             agg_isNull143 = false;
/* 2484 */             agg_value178 = agg_value180;
/* 2485 */           }
/* 2486 */           boolean agg_isNull148 = false;
/* 2487 */           double agg_value183 = -1.0;
/* 2488 */           if (!false && agg_isNull55) {
/* 2489 */             double agg_value184 = agg_unsafeRowAggBuffer.getDouble(7);
/* 2490 */             agg_isNull148 = false;
/* 2491 */             agg_value183 = agg_value184;
/* 2492 */           } else {
/* 2493 */             boolean agg_isNull150 = true;
/* 2494 */             double agg_value185 = -1.0;
/* 2495 */
/* 2496 */             double agg_value186 = agg_unsafeRowAggBuffer.getDouble(7);
/* 2497 */
/* 2498 */             boolean agg_isNull157 = false;
/* 2499 */
/* 2500 */             double agg_value193 = agg_unsafeRowAggBuffer.getDouble(6);
/* 2501 */
/* 2502 */             double agg_value192 = -1.0;
/* 2503 */             agg_value192 = agg_value193 + 1.0D;
/* 2504 */             boolean agg_isNull152 = false;
/* 2505 */             double agg_value187 = -1.0;
/* 2506 */             if (false || agg_value192 == 0) {
/* 2507 */               agg_isNull152 = true;
/* 2508 */             } else {
/* 2509 */               boolean agg_isNull153 = true;
/* 2510 */               double agg_value188 = -1.0;
/* 2511 */
/* 2512 */               boolean agg_isNull154 = smj_isNull8;
/* 2513 */               double agg_value189 = -1.0;
/* 2514 */               if (!smj_isNull8) {
/* 2515 */                 agg_value189 = (double) smj_value12;
/* 2516 */               }
/* 2517 */               if (!agg_isNull154) {
/* 2518 */                 double agg_value191 = agg_unsafeRowAggBuffer.getDouble(7);
/* 2519 */
/* 2520 */                 agg_isNull153 = false; // resultCode could change nullability.
/* 2521 */                 agg_value188 = agg_value189 - agg_value191;
/* 2522 */
/* 2523 */               }
/* 2524 */               if (agg_isNull153) {
/* 2525 */                 agg_isNull152 = true;
/* 2526 */               } else {
/* 2527 */                 agg_value187 = (double)(agg_value188 / agg_value192);
/* 2528 */               }
/* 2529 */             }
/* 2530 */             if (!agg_isNull152) {
/* 2531 */               agg_isNull150 = false; // resultCode could change nullability.
/* 2532 */               agg_value185 = agg_value186 + agg_value187;
/* 2533 */
/* 2534 */             }
/* 2535 */             agg_isNull148 = agg_isNull150;
/* 2536 */             agg_value183 = agg_value185;
/* 2537 */           }
/* 2538 */           boolean agg_isNull160 = false;
/* 2539 */           double agg_value195 = -1.0;
/* 2540 */           if (!false && agg_isNull55) {
/* 2541 */             double agg_value196 = agg_unsafeRowAggBuffer.getDouble(8);
/* 2542 */             agg_isNull160 = false;
/* 2543 */             agg_value195 = agg_value196;
/* 2544 */           } else {
/* 2545 */             boolean agg_isNull162 = true;
/* 2546 */             double agg_value197 = -1.0;
/* 2547 */
/* 2548 */             double agg_value198 = agg_unsafeRowAggBuffer.getDouble(8);
/* 2549 */
/* 2550 */             boolean agg_isNull164 = true;
/* 2551 */             double agg_value199 = -1.0;
/* 2552 */
/* 2553 */             boolean agg_isNull165 = true;
/* 2554 */             double agg_value200 = -1.0;
/* 2555 */
/* 2556 */             boolean agg_isNull166 = smj_isNull8;
/* 2557 */             double agg_value201 = -1.0;
/* 2558 */             if (!smj_isNull8) {
/* 2559 */               agg_value201 = (double) smj_value12;
/* 2560 */             }
/* 2561 */             if (!agg_isNull166) {
/* 2562 */               double agg_value203 = agg_unsafeRowAggBuffer.getDouble(7);
/* 2563 */
/* 2564 */               agg_isNull165 = false; // resultCode could change nullability.
/* 2565 */               agg_value200 = agg_value201 - agg_value203;
/* 2566 */
/* 2567 */             }
/* 2568 */             if (!agg_isNull165) {
/* 2569 */               boolean agg_isNull169 = true;
/* 2570 */               double agg_value204 = -1.0;
/* 2571 */
/* 2572 */               boolean agg_isNull170 = true;
/* 2573 */               double agg_value205 = -1.0;
/* 2574 */
/* 2575 */               boolean agg_isNull171 = smj_isNull8;
/* 2576 */               double agg_value206 = -1.0;
/* 2577 */               if (!smj_isNull8) {
/* 2578 */                 agg_value206 = (double) smj_value12;
/* 2579 */               }
/* 2580 */               if (!agg_isNull171) {
/* 2581 */                 double agg_value208 = agg_unsafeRowAggBuffer.getDouble(7);
/* 2582 */
/* 2583 */                 agg_isNull170 = false; // resultCode could change nullability.
/* 2584 */                 agg_value205 = agg_value206 - agg_value208;
/* 2585 */
/* 2586 */               }
/* 2587 */               if (!agg_isNull170) {
/* 2588 */                 boolean agg_isNull179 = false;
/* 2589 */
/* 2590 */                 double agg_value215 = agg_unsafeRowAggBuffer.getDouble(6);
/* 2591 */
/* 2592 */                 double agg_value214 = -1.0;
/* 2593 */                 agg_value214 = agg_value215 + 1.0D;
/* 2594 */                 boolean agg_isNull174 = false;
/* 2595 */                 double agg_value209 = -1.0;
/* 2596 */                 if (false || agg_value214 == 0) {
/* 2597 */                   agg_isNull174 = true;
/* 2598 */                 } else {
/* 2599 */                   boolean agg_isNull175 = true;
/* 2600 */                   double agg_value210 = -1.0;
/* 2601 */
/* 2602 */                   boolean agg_isNull176 = smj_isNull8;
/* 2603 */                   double agg_value211 = -1.0;
/* 2604 */                   if (!smj_isNull8) {
/* 2605 */                     agg_value211 = (double) smj_value12;
/* 2606 */                   }
/* 2607 */                   if (!agg_isNull176) {
/* 2608 */                     double agg_value213 = agg_unsafeRowAggBuffer.getDouble(7);
/* 2609 */
/* 2610 */                     agg_isNull175 = false; // resultCode could change nullability.
/* 2611 */                     agg_value210 = agg_value211 - agg_value213;
/* 2612 */
/* 2613 */                   }
/* 2614 */                   if (agg_isNull175) {
/* 2615 */                     agg_isNull174 = true;
/* 2616 */                   } else {
/* 2617 */                     agg_value209 = (double)(agg_value210 / agg_value214);
/* 2618 */                   }
/* 2619 */                 }
/* 2620 */                 if (!agg_isNull174) {
/* 2621 */                   agg_isNull169 = false; // resultCode could change nullability.
/* 2622 */                   agg_value204 = agg_value205 - agg_value209;
/* 2623 */
/* 2624 */                 }
/* 2625 */
/* 2626 */               }
/* 2627 */               if (!agg_isNull169) {
/* 2628 */                 agg_isNull164 = false; // resultCode could change nullability.
/* 2629 */                 agg_value199 = agg_value200 * agg_value204;
/* 2630 */
/* 2631 */               }
/* 2632 */
/* 2633 */             }
/* 2634 */             if (!agg_isNull164) {
/* 2635 */               agg_isNull162 = false; // resultCode could change nullability.
/* 2636 */               agg_value197 = agg_value198 + agg_value199;
/* 2637 */
/* 2638 */             }
/* 2639 */             agg_isNull160 = agg_isNull162;
/* 2640 */             agg_value195 = agg_value197;
/* 2641 */           }
/* 2642 */           boolean agg_isNull182 = true;
/* 2643 */           double agg_value217 = -1.0;
/* 2644 */
/* 2645 */           boolean agg_isNull183 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 2646 */           double agg_value218 = agg_isNull183 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 2647 */           if (!agg_isNull183) {
/* 2648 */             agg_isNull182 = false; // resultCode could change nullability.
/* 2649 */             agg_value217 = agg_value218 + agg_value114;
/* 2650 */
/* 2651 */           }
/* 2652 */           boolean agg_isNull184 = false;
/* 2653 */           long agg_value219 = -1L;
/* 2654 */           if (!false && agg_isNull72) {
/* 2655 */             boolean agg_isNull185 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 2656 */             long agg_value220 = agg_isNull185 ? -1L : (agg_unsafeRowAggBuffer.getLong(10));
/* 2657 */             agg_isNull184 = agg_isNull185;
/* 2658 */             agg_value219 = agg_value220;
/* 2659 */           } else {
/* 2660 */             boolean agg_isNull186 = true;
/* 2661 */             long agg_value221 = -1L;
/* 2662 */
/* 2663 */             boolean agg_isNull187 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 2664 */             long agg_value222 = agg_isNull187 ? -1L : (agg_unsafeRowAggBuffer.getLong(10));
/* 2665 */             if (!agg_isNull187) {
/* 2666 */               agg_isNull186 = false; // resultCode could change nullability.
/* 2667 */               agg_value221 = agg_value222 + 1L;
/* 2668 */
/* 2669 */             }
/* 2670 */             agg_isNull184 = agg_isNull186;
/* 2671 */             agg_value219 = agg_value221;
/* 2672 */           }
/* 2673 */           boolean agg_isNull189 = false;
/* 2674 */           long agg_value224 = -1L;
/* 2675 */           if (!false && smj_isNull12) {
/* 2676 */             long agg_value225 = agg_unsafeRowAggBuffer.getLong(11);
/* 2677 */             agg_isNull189 = false;
/* 2678 */             agg_value224 = agg_value225;
/* 2679 */           } else {
/* 2680 */             boolean agg_isNull191 = false;
/* 2681 */
/* 2682 */             long agg_value227 = agg_unsafeRowAggBuffer.getLong(11);
/* 2683 */
/* 2684 */             long agg_value226 = -1L;
/* 2685 */             agg_value226 = agg_value227 + 1L;
/* 2686 */             agg_isNull189 = false;
/* 2687 */             agg_value224 = agg_value226;
/* 2688 */           }
/* 2689 */           boolean agg_isNull194 = true;
/* 2690 */           double agg_value229 = -1.0;
/* 2691 */
/* 2692 */           boolean agg_isNull195 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 2693 */           double agg_value230 = agg_isNull195 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 2694 */           if (!agg_isNull195) {
/* 2695 */             agg_isNull194 = false; // resultCode could change nullability.
/* 2696 */             agg_value229 = agg_value230 + agg_value109;
/* 2697 */
/* 2698 */           }
/* 2699 */           boolean agg_isNull196 = false;
/* 2700 */           long agg_value231 = -1L;
/* 2701 */           if (!false && smj_isNull12) {
/* 2702 */             boolean agg_isNull197 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 2703 */             long agg_value232 = agg_isNull197 ? -1L : (agg_unsafeRowAggBuffer.getLong(13));
/* 2704 */             agg_isNull196 = agg_isNull197;
/* 2705 */             agg_value231 = agg_value232;
/* 2706 */           } else {
/* 2707 */             boolean agg_isNull198 = true;
/* 2708 */             long agg_value233 = -1L;
/* 2709 */
/* 2710 */             boolean agg_isNull199 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 2711 */             long agg_value234 = agg_isNull199 ? -1L : (agg_unsafeRowAggBuffer.getLong(13));
/* 2712 */             if (!agg_isNull199) {
/* 2713 */               agg_isNull198 = false; // resultCode could change nullability.
/* 2714 */               agg_value233 = agg_value234 + 1L;
/* 2715 */
/* 2716 */             }
/* 2717 */             agg_isNull196 = agg_isNull198;
/* 2718 */             agg_value231 = agg_value233;
/* 2719 */           }
/* 2720 */           boolean agg_isNull201 = false;
/* 2721 */           double agg_value236 = -1.0;
/* 2722 */           if (!false && agg_isNull88) {
/* 2723 */             double agg_value237 = agg_unsafeRowAggBuffer.getDouble(14);
/* 2724 */             agg_isNull201 = false;
/* 2725 */             agg_value236 = agg_value237;
/* 2726 */           } else {
/* 2727 */             boolean agg_isNull203 = false;
/* 2728 */
/* 2729 */             double agg_value239 = agg_unsafeRowAggBuffer.getDouble(14);
/* 2730 */
/* 2731 */             double agg_value238 = -1.0;
/* 2732 */             agg_value238 = agg_value239 + 1.0D;
/* 2733 */             agg_isNull201 = false;
/* 2734 */             agg_value236 = agg_value238;
/* 2735 */           }
/* 2736 */           boolean agg_isNull206 = false;
/* 2737 */           double agg_value241 = -1.0;
/* 2738 */           if (!false && agg_isNull88) {
/* 2739 */             double agg_value242 = agg_unsafeRowAggBuffer.getDouble(15);
/* 2740 */             agg_isNull206 = false;
/* 2741 */             agg_value241 = agg_value242;
/* 2742 */           } else {
/* 2743 */             boolean agg_isNull208 = true;
/* 2744 */             double agg_value243 = -1.0;
/* 2745 */
/* 2746 */             double agg_value244 = agg_unsafeRowAggBuffer.getDouble(15);
/* 2747 */
/* 2748 */             boolean agg_isNull215 = false;
/* 2749 */
/* 2750 */             double agg_value251 = agg_unsafeRowAggBuffer.getDouble(14);
/* 2751 */
/* 2752 */             double agg_value250 = -1.0;
/* 2753 */             agg_value250 = agg_value251 + 1.0D;
/* 2754 */             boolean agg_isNull210 = false;
/* 2755 */             double agg_value245 = -1.0;
/* 2756 */             if (false || agg_value250 == 0) {
/* 2757 */               agg_isNull210 = true;
/* 2758 */             } else {
/* 2759 */               boolean agg_isNull211 = true;
/* 2760 */               double agg_value246 = -1.0;
/* 2761 */
/* 2762 */               boolean agg_isNull212 = smj_isNull12;
/* 2763 */               double agg_value247 = -1.0;
/* 2764 */               if (!smj_isNull12) {
/* 2765 */                 agg_value247 = (double) smj_value16;
/* 2766 */               }
/* 2767 */               if (!agg_isNull212) {
/* 2768 */                 double agg_value249 = agg_unsafeRowAggBuffer.getDouble(15);
/* 2769 */
/* 2770 */                 agg_isNull211 = false; // resultCode could change nullability.
/* 2771 */                 agg_value246 = agg_value247 - agg_value249;
/* 2772 */
/* 2773 */               }
/* 2774 */               if (agg_isNull211) {
/* 2775 */                 agg_isNull210 = true;
/* 2776 */               } else {
/* 2777 */                 agg_value245 = (double)(agg_value246 / agg_value250);
/* 2778 */               }
/* 2779 */             }
/* 2780 */             if (!agg_isNull210) {
/* 2781 */               agg_isNull208 = false; // resultCode could change nullability.
/* 2782 */               agg_value243 = agg_value244 + agg_value245;
/* 2783 */
/* 2784 */             }
/* 2785 */             agg_isNull206 = agg_isNull208;
/* 2786 */             agg_value241 = agg_value243;
/* 2787 */           }
/* 2788 */           boolean agg_isNull218 = false;
/* 2789 */           double agg_value253 = -1.0;
/* 2790 */           if (!false && agg_isNull88) {
/* 2791 */             double agg_value254 = agg_unsafeRowAggBuffer.getDouble(16);
/* 2792 */             agg_isNull218 = false;
/* 2793 */             agg_value253 = agg_value254;
/* 2794 */           } else {
/* 2795 */             boolean agg_isNull220 = true;
/* 2796 */             double agg_value255 = -1.0;
/* 2797 */
/* 2798 */             double agg_value256 = agg_unsafeRowAggBuffer.getDouble(16);
/* 2799 */
/* 2800 */             boolean agg_isNull222 = true;
/* 2801 */             double agg_value257 = -1.0;
/* 2802 */
/* 2803 */             boolean agg_isNull223 = true;
/* 2804 */             double agg_value258 = -1.0;
/* 2805 */
/* 2806 */             boolean agg_isNull224 = smj_isNull12;
/* 2807 */             double agg_value259 = -1.0;
/* 2808 */             if (!smj_isNull12) {
/* 2809 */               agg_value259 = (double) smj_value16;
/* 2810 */             }
/* 2811 */             if (!agg_isNull224) {
/* 2812 */               double agg_value261 = agg_unsafeRowAggBuffer.getDouble(15);
/* 2813 */
/* 2814 */               agg_isNull223 = false; // resultCode could change nullability.
/* 2815 */               agg_value258 = agg_value259 - agg_value261;
/* 2816 */
/* 2817 */             }
/* 2818 */             if (!agg_isNull223) {
/* 2819 */               boolean agg_isNull227 = true;
/* 2820 */               double agg_value262 = -1.0;
/* 2821 */
/* 2822 */               boolean agg_isNull228 = true;
/* 2823 */               double agg_value263 = -1.0;
/* 2824 */
/* 2825 */               boolean agg_isNull229 = smj_isNull12;
/* 2826 */               double agg_value264 = -1.0;
/* 2827 */               if (!smj_isNull12) {
/* 2828 */                 agg_value264 = (double) smj_value16;
/* 2829 */               }
/* 2830 */               if (!agg_isNull229) {
/* 2831 */                 double agg_value266 = agg_unsafeRowAggBuffer.getDouble(15);
/* 2832 */
/* 2833 */                 agg_isNull228 = false; // resultCode could change nullability.
/* 2834 */                 agg_value263 = agg_value264 - agg_value266;
/* 2835 */
/* 2836 */               }
/* 2837 */               if (!agg_isNull228) {
/* 2838 */                 boolean agg_isNull237 = false;
/* 2839 */
/* 2840 */                 double agg_value273 = agg_unsafeRowAggBuffer.getDouble(14);
/* 2841 */
/* 2842 */                 double agg_value272 = -1.0;
/* 2843 */                 agg_value272 = agg_value273 + 1.0D;
/* 2844 */                 boolean agg_isNull232 = false;
/* 2845 */                 double agg_value267 = -1.0;
/* 2846 */                 if (false || agg_value272 == 0) {
/* 2847 */                   agg_isNull232 = true;
/* 2848 */                 } else {
/* 2849 */                   boolean agg_isNull233 = true;
/* 2850 */                   double agg_value268 = -1.0;
/* 2851 */
/* 2852 */                   boolean agg_isNull234 = smj_isNull12;
/* 2853 */                   double agg_value269 = -1.0;
/* 2854 */                   if (!smj_isNull12) {
/* 2855 */                     agg_value269 = (double) smj_value16;
/* 2856 */                   }
/* 2857 */                   if (!agg_isNull234) {
/* 2858 */                     double agg_value271 = agg_unsafeRowAggBuffer.getDouble(15);
/* 2859 */
/* 2860 */                     agg_isNull233 = false; // resultCode could change nullability.
/* 2861 */                     agg_value268 = agg_value269 - agg_value271;
/* 2862 */
/* 2863 */                   }
/* 2864 */                   if (agg_isNull233) {
/* 2865 */                     agg_isNull232 = true;
/* 2866 */                   } else {
/* 2867 */                     agg_value267 = (double)(agg_value268 / agg_value272);
/* 2868 */                   }
/* 2869 */                 }
/* 2870 */                 if (!agg_isNull232) {
/* 2871 */                   agg_isNull227 = false; // resultCode could change nullability.
/* 2872 */                   agg_value262 = agg_value263 - agg_value267;
/* 2873 */
/* 2874 */                 }
/* 2875 */
/* 2876 */               }
/* 2877 */               if (!agg_isNull227) {
/* 2878 */                 agg_isNull222 = false; // resultCode could change nullability.
/* 2879 */                 agg_value257 = agg_value258 * agg_value262;
/* 2880 */
/* 2881 */               }
/* 2882 */
/* 2883 */             }
/* 2884 */             if (!agg_isNull222) {
/* 2885 */               agg_isNull220 = false; // resultCode could change nullability.
/* 2886 */               agg_value255 = agg_value256 + agg_value257;
/* 2887 */
/* 2888 */             }
/* 2889 */             agg_isNull218 = agg_isNull220;
/* 2890 */             agg_value253 = agg_value255;
/* 2891 */           }
/* 2892 */           boolean agg_isNull240 = false;
/* 2893 */           double agg_value275 = -1.0;
/* 2894 */           if (!false && agg_isNull88) {
/* 2895 */             double agg_value276 = agg_unsafeRowAggBuffer.getDouble(17);
/* 2896 */             agg_isNull240 = false;
/* 2897 */             agg_value275 = agg_value276;
/* 2898 */           } else {
/* 2899 */             boolean agg_isNull242 = false;
/* 2900 */
/* 2901 */             double agg_value278 = agg_unsafeRowAggBuffer.getDouble(17);
/* 2902 */
/* 2903 */             double agg_value277 = -1.0;
/* 2904 */             agg_value277 = agg_value278 + 1.0D;
/* 2905 */             agg_isNull240 = false;
/* 2906 */             agg_value275 = agg_value277;
/* 2907 */           }
/* 2908 */           boolean agg_isNull245 = false;
/* 2909 */           double agg_value280 = -1.0;
/* 2910 */           if (!false && agg_isNull88) {
/* 2911 */             double agg_value281 = agg_unsafeRowAggBuffer.getDouble(18);
/* 2912 */             agg_isNull245 = false;
/* 2913 */             agg_value280 = agg_value281;
/* 2914 */           } else {
/* 2915 */             boolean agg_isNull247 = true;
/* 2916 */             double agg_value282 = -1.0;
/* 2917 */
/* 2918 */             double agg_value283 = agg_unsafeRowAggBuffer.getDouble(18);
/* 2919 */
/* 2920 */             boolean agg_isNull254 = false;
/* 2921 */
/* 2922 */             double agg_value290 = agg_unsafeRowAggBuffer.getDouble(17);
/* 2923 */
/* 2924 */             double agg_value289 = -1.0;
/* 2925 */             agg_value289 = agg_value290 + 1.0D;
/* 2926 */             boolean agg_isNull249 = false;
/* 2927 */             double agg_value284 = -1.0;
/* 2928 */             if (false || agg_value289 == 0) {
/* 2929 */               agg_isNull249 = true;
/* 2930 */             } else {
/* 2931 */               boolean agg_isNull250 = true;
/* 2932 */               double agg_value285 = -1.0;
/* 2933 */
/* 2934 */               boolean agg_isNull251 = smj_isNull12;
/* 2935 */               double agg_value286 = -1.0;
/* 2936 */               if (!smj_isNull12) {
/* 2937 */                 agg_value286 = (double) smj_value16;
/* 2938 */               }
/* 2939 */               if (!agg_isNull251) {
/* 2940 */                 double agg_value288 = agg_unsafeRowAggBuffer.getDouble(18);
/* 2941 */
/* 2942 */                 agg_isNull250 = false; // resultCode could change nullability.
/* 2943 */                 agg_value285 = agg_value286 - agg_value288;
/* 2944 */
/* 2945 */               }
/* 2946 */               if (agg_isNull250) {
/* 2947 */                 agg_isNull249 = true;
/* 2948 */               } else {
/* 2949 */                 agg_value284 = (double)(agg_value285 / agg_value289);
/* 2950 */               }
/* 2951 */             }
/* 2952 */             if (!agg_isNull249) {
/* 2953 */               agg_isNull247 = false; // resultCode could change nullability.
/* 2954 */               agg_value282 = agg_value283 + agg_value284;
/* 2955 */
/* 2956 */             }
/* 2957 */             agg_isNull245 = agg_isNull247;
/* 2958 */             agg_value280 = agg_value282;
/* 2959 */           }
/* 2960 */           boolean agg_isNull257 = false;
/* 2961 */           double agg_value292 = -1.0;
/* 2962 */           if (!false && agg_isNull88) {
/* 2963 */             double agg_value293 = agg_unsafeRowAggBuffer.getDouble(19);
/* 2964 */             agg_isNull257 = false;
/* 2965 */             agg_value292 = agg_value293;
/* 2966 */           } else {
/* 2967 */             boolean agg_isNull259 = true;
/* 2968 */             double agg_value294 = -1.0;
/* 2969 */
/* 2970 */             double agg_value295 = agg_unsafeRowAggBuffer.getDouble(19);
/* 2971 */
/* 2972 */             boolean agg_isNull261 = true;
/* 2973 */             double agg_value296 = -1.0;
/* 2974 */
/* 2975 */             boolean agg_isNull262 = true;
/* 2976 */             double agg_value297 = -1.0;
/* 2977 */
/* 2978 */             boolean agg_isNull263 = smj_isNull12;
/* 2979 */             double agg_value298 = -1.0;
/* 2980 */             if (!smj_isNull12) {
/* 2981 */               agg_value298 = (double) smj_value16;
/* 2982 */             }
/* 2983 */             if (!agg_isNull263) {
/* 2984 */               double agg_value300 = agg_unsafeRowAggBuffer.getDouble(18);
/* 2985 */
/* 2986 */               agg_isNull262 = false; // resultCode could change nullability.
/* 2987 */               agg_value297 = agg_value298 - agg_value300;
/* 2988 */
/* 2989 */             }
/* 2990 */             if (!agg_isNull262) {
/* 2991 */               boolean agg_isNull266 = true;
/* 2992 */               double agg_value301 = -1.0;
/* 2993 */
/* 2994 */               boolean agg_isNull267 = true;
/* 2995 */               double agg_value302 = -1.0;
/* 2996 */
/* 2997 */               boolean agg_isNull268 = smj_isNull12;
/* 2998 */               double agg_value303 = -1.0;
/* 2999 */               if (!smj_isNull12) {
/* 3000 */                 agg_value303 = (double) smj_value16;
/* 3001 */               }
/* 3002 */               if (!agg_isNull268) {
/* 3003 */                 double agg_value305 = agg_unsafeRowAggBuffer.getDouble(18);
/* 3004 */
/* 3005 */                 agg_isNull267 = false; // resultCode could change nullability.
/* 3006 */                 agg_value302 = agg_value303 - agg_value305;
/* 3007 */
/* 3008 */               }
/* 3009 */               if (!agg_isNull267) {
/* 3010 */                 boolean agg_isNull276 = false;
/* 3011 */
/* 3012 */                 double agg_value312 = agg_unsafeRowAggBuffer.getDouble(17);
/* 3013 */
/* 3014 */                 double agg_value311 = -1.0;
/* 3015 */                 agg_value311 = agg_value312 + 1.0D;
/* 3016 */                 boolean agg_isNull271 = false;
/* 3017 */                 double agg_value306 = -1.0;
/* 3018 */                 if (false || agg_value311 == 0) {
/* 3019 */                   agg_isNull271 = true;
/* 3020 */                 } else {
/* 3021 */                   boolean agg_isNull272 = true;
/* 3022 */                   double agg_value307 = -1.0;
/* 3023 */
/* 3024 */                   boolean agg_isNull273 = smj_isNull12;
/* 3025 */                   double agg_value308 = -1.0;
/* 3026 */                   if (!smj_isNull12) {
/* 3027 */                     agg_value308 = (double) smj_value16;
/* 3028 */                   }
/* 3029 */                   if (!agg_isNull273) {
/* 3030 */                     double agg_value310 = agg_unsafeRowAggBuffer.getDouble(18);
/* 3031 */
/* 3032 */                     agg_isNull272 = false; // resultCode could change nullability.
/* 3033 */                     agg_value307 = agg_value308 - agg_value310;
/* 3034 */
/* 3035 */                   }
/* 3036 */                   if (agg_isNull272) {
/* 3037 */                     agg_isNull271 = true;
/* 3038 */                   } else {
/* 3039 */                     agg_value306 = (double)(agg_value307 / agg_value311);
/* 3040 */                   }
/* 3041 */                 }
/* 3042 */                 if (!agg_isNull271) {
/* 3043 */                   agg_isNull266 = false; // resultCode could change nullability.
/* 3044 */                   agg_value301 = agg_value302 - agg_value306;
/* 3045 */
/* 3046 */                 }
/* 3047 */
/* 3048 */               }
/* 3049 */               if (!agg_isNull266) {
/* 3050 */                 agg_isNull261 = false; // resultCode could change nullability.
/* 3051 */                 agg_value296 = agg_value297 * agg_value301;
/* 3052 */
/* 3053 */               }
/* 3054 */
/* 3055 */             }
/* 3056 */             if (!agg_isNull261) {
/* 3057 */               agg_isNull259 = false; // resultCode could change nullability.
/* 3058 */               agg_value294 = agg_value295 + agg_value296;
/* 3059 */
/* 3060 */             }
/* 3061 */             agg_isNull257 = agg_isNull259;
/* 3062 */             agg_value292 = agg_value294;
/* 3063 */           }
/* 3064 */           boolean agg_isNull279 = true;
/* 3065 */           double agg_value314 = -1.0;
/* 3066 */
/* 3067 */           boolean agg_isNull280 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 3068 */           double agg_value315 = agg_isNull280 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 3069 */           if (!agg_isNull280) {
/* 3070 */             agg_isNull279 = false; // resultCode could change nullability.
/* 3071 */             agg_value314 = agg_value315 + agg_value109;
/* 3072 */
/* 3073 */           }
/* 3074 */           boolean agg_isNull281 = false;
/* 3075 */           long agg_value316 = -1L;
/* 3076 */           if (!false && smj_isNull12) {
/* 3077 */             boolean agg_isNull282 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 3078 */             long agg_value317 = agg_isNull282 ? -1L : (agg_unsafeRowAggBuffer.getLong(21));
/* 3079 */             agg_isNull281 = agg_isNull282;
/* 3080 */             agg_value316 = agg_value317;
/* 3081 */           } else {
/* 3082 */             boolean agg_isNull283 = true;
/* 3083 */             long agg_value318 = -1L;
/* 3084 */
/* 3085 */             boolean agg_isNull284 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 3086 */             long agg_value319 = agg_isNull284 ? -1L : (agg_unsafeRowAggBuffer.getLong(21));
/* 3087 */             if (!agg_isNull284) {
/* 3088 */               agg_isNull283 = false; // resultCode could change nullability.
/* 3089 */               agg_value318 = agg_value319 + 1L;
/* 3090 */
/* 3091 */             }
/* 3092 */             agg_isNull281 = agg_isNull283;
/* 3093 */             agg_value316 = agg_value318;
/* 3094 */           }
/* 3095 */           boolean agg_isNull286 = false;
/* 3096 */           long agg_value321 = -1L;
/* 3097 */           if (!false && smj_isNull16) {
/* 3098 */             long agg_value324 = agg_unsafeRowAggBuffer.getLong(22);
/* 3099 */             agg_isNull286 = false;
/* 3100 */             agg_value321 = agg_value324;
/* 3101 */           } else {
/* 3102 */             boolean agg_isNull290 = false;
/* 3103 */
/* 3104 */             long agg_value326 = agg_unsafeRowAggBuffer.getLong(22);
/* 3105 */
/* 3106 */             long agg_value325 = -1L;
/* 3107 */             agg_value325 = agg_value326 + 1L;
/* 3108 */             agg_isNull286 = false;
/* 3109 */             agg_value321 = agg_value325;
/* 3110 */           }
/* 3111 */           boolean agg_isNull293 = true;
/* 3112 */           double agg_value328 = -1.0;
/* 3113 */
/* 3114 */           boolean agg_isNull294 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 3115 */           double agg_value329 = agg_isNull294 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 3116 */           if (!agg_isNull294) {
/* 3117 */             agg_isNull293 = false; // resultCode could change nullability.
/* 3118 */             agg_value328 = agg_value329 + agg_value97;
/* 3119 */
/* 3120 */           }
/* 3121 */           boolean agg_isNull295 = false;
/* 3122 */           long agg_value330 = -1L;
/* 3123 */           if (!false && agg_isNull69) {
/* 3124 */             boolean agg_isNull296 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 3125 */             long agg_value331 = agg_isNull296 ? -1L : (agg_unsafeRowAggBuffer.getLong(24));
/* 3126 */             agg_isNull295 = agg_isNull296;
/* 3127 */             agg_value330 = agg_value331;
/* 3128 */           } else {
/* 3129 */             boolean agg_isNull297 = true;
/* 3130 */             long agg_value332 = -1L;
/* 3131 */
/* 3132 */             boolean agg_isNull298 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 3133 */             long agg_value333 = agg_isNull298 ? -1L : (agg_unsafeRowAggBuffer.getLong(24));
/* 3134 */             if (!agg_isNull298) {
/* 3135 */               agg_isNull297 = false; // resultCode could change nullability.
/* 3136 */               agg_value332 = agg_value333 + 1L;
/* 3137 */
/* 3138 */             }
/* 3139 */             agg_isNull295 = agg_isNull297;
/* 3140 */             agg_value330 = agg_value332;
/* 3141 */           }
/* 3142 */           boolean agg_isNull300 = false;
/* 3143 */           double agg_value335 = -1.0;
/* 3144 */           if (!false && agg_isNull60) {
/* 3145 */             double agg_value336 = agg_unsafeRowAggBuffer.getDouble(25);
/* 3146 */             agg_isNull300 = false;
/* 3147 */             agg_value335 = agg_value336;
/* 3148 */           } else {
/* 3149 */             boolean agg_isNull302 = false;
/* 3150 */
/* 3151 */             double agg_value338 = agg_unsafeRowAggBuffer.getDouble(25);
/* 3152 */
/* 3153 */             double agg_value337 = -1.0;
/* 3154 */             agg_value337 = agg_value338 + 1.0D;
/* 3155 */             agg_isNull300 = false;
/* 3156 */             agg_value335 = agg_value337;
/* 3157 */           }
/* 3158 */           boolean agg_isNull305 = false;
/* 3159 */           double agg_value340 = -1.0;
/* 3160 */           if (!false && agg_isNull60) {
/* 3161 */             double agg_value341 = agg_unsafeRowAggBuffer.getDouble(26);
/* 3162 */             agg_isNull305 = false;
/* 3163 */             agg_value340 = agg_value341;
/* 3164 */           } else {
/* 3165 */             boolean agg_isNull307 = true;
/* 3166 */             double agg_value342 = -1.0;
/* 3167 */
/* 3168 */             double agg_value343 = agg_unsafeRowAggBuffer.getDouble(26);
/* 3169 */
/* 3170 */             boolean agg_isNull314 = false;
/* 3171 */
/* 3172 */             double agg_value350 = agg_unsafeRowAggBuffer.getDouble(25);
/* 3173 */
/* 3174 */             double agg_value349 = -1.0;
/* 3175 */             agg_value349 = agg_value350 + 1.0D;
/* 3176 */             boolean agg_isNull309 = false;
/* 3177 */             double agg_value344 = -1.0;
/* 3178 */             if (false || agg_value349 == 0) {
/* 3179 */               agg_isNull309 = true;
/* 3180 */             } else {
/* 3181 */               boolean agg_isNull310 = true;
/* 3182 */               double agg_value345 = -1.0;
/* 3183 */
/* 3184 */               boolean agg_isNull311 = smj_isNull16;
/* 3185 */               double agg_value346 = -1.0;
/* 3186 */               if (!smj_isNull16) {
/* 3187 */                 agg_value346 = (double) smj_value20;
/* 3188 */               }
/* 3189 */               if (!agg_isNull311) {
/* 3190 */                 double agg_value348 = agg_unsafeRowAggBuffer.getDouble(26);
/* 3191 */
/* 3192 */                 agg_isNull310 = false; // resultCode could change nullability.
/* 3193 */                 agg_value345 = agg_value346 - agg_value348;
/* 3194 */
/* 3195 */               }
/* 3196 */               if (agg_isNull310) {
/* 3197 */                 agg_isNull309 = true;
/* 3198 */               } else {
/* 3199 */                 agg_value344 = (double)(agg_value345 / agg_value349);
/* 3200 */               }
/* 3201 */             }
/* 3202 */             if (!agg_isNull309) {
/* 3203 */               agg_isNull307 = false; // resultCode could change nullability.
/* 3204 */               agg_value342 = agg_value343 + agg_value344;
/* 3205 */
/* 3206 */             }
/* 3207 */             agg_isNull305 = agg_isNull307;
/* 3208 */             agg_value340 = agg_value342;
/* 3209 */           }
/* 3210 */           boolean agg_isNull317 = false;
/* 3211 */           double agg_value352 = -1.0;
/* 3212 */           if (!false && agg_isNull60) {
/* 3213 */             double agg_value353 = agg_unsafeRowAggBuffer.getDouble(27);
/* 3214 */             agg_isNull317 = false;
/* 3215 */             agg_value352 = agg_value353;
/* 3216 */           } else {
/* 3217 */             boolean agg_isNull319 = true;
/* 3218 */             double agg_value354 = -1.0;
/* 3219 */
/* 3220 */             double agg_value355 = agg_unsafeRowAggBuffer.getDouble(27);
/* 3221 */
/* 3222 */             boolean agg_isNull321 = true;
/* 3223 */             double agg_value356 = -1.0;
/* 3224 */
/* 3225 */             boolean agg_isNull322 = true;
/* 3226 */             double agg_value357 = -1.0;
/* 3227 */
/* 3228 */             boolean agg_isNull323 = smj_isNull16;
/* 3229 */             double agg_value358 = -1.0;
/* 3230 */             if (!smj_isNull16) {
/* 3231 */               agg_value358 = (double) smj_value20;
/* 3232 */             }
/* 3233 */             if (!agg_isNull323) {
/* 3234 */               double agg_value360 = agg_unsafeRowAggBuffer.getDouble(26);
/* 3235 */
/* 3236 */               agg_isNull322 = false; // resultCode could change nullability.
/* 3237 */               agg_value357 = agg_value358 - agg_value360;
/* 3238 */
/* 3239 */             }
/* 3240 */             if (!agg_isNull322) {
/* 3241 */               boolean agg_isNull326 = true;
/* 3242 */               double agg_value361 = -1.0;
/* 3243 */
/* 3244 */               boolean agg_isNull327 = true;
/* 3245 */               double agg_value362 = -1.0;
/* 3246 */
/* 3247 */               boolean agg_isNull328 = smj_isNull16;
/* 3248 */               double agg_value363 = -1.0;
/* 3249 */               if (!smj_isNull16) {
/* 3250 */                 agg_value363 = (double) smj_value20;
/* 3251 */               }
/* 3252 */               if (!agg_isNull328) {
/* 3253 */                 double agg_value365 = agg_unsafeRowAggBuffer.getDouble(26);
/* 3254 */
/* 3255 */                 agg_isNull327 = false; // resultCode could change nullability.
/* 3256 */                 agg_value362 = agg_value363 - agg_value365;
/* 3257 */
/* 3258 */               }
/* 3259 */               if (!agg_isNull327) {
/* 3260 */                 boolean agg_isNull336 = false;
/* 3261 */
/* 3262 */                 double agg_value372 = agg_unsafeRowAggBuffer.getDouble(25);
/* 3263 */
/* 3264 */                 double agg_value371 = -1.0;
/* 3265 */                 agg_value371 = agg_value372 + 1.0D;
/* 3266 */                 boolean agg_isNull331 = false;
/* 3267 */                 double agg_value366 = -1.0;
/* 3268 */                 if (false || agg_value371 == 0) {
/* 3269 */                   agg_isNull331 = true;
/* 3270 */                 } else {
/* 3271 */                   boolean agg_isNull332 = true;
/* 3272 */                   double agg_value367 = -1.0;
/* 3273 */
/* 3274 */                   boolean agg_isNull333 = smj_isNull16;
/* 3275 */                   double agg_value368 = -1.0;
/* 3276 */                   if (!smj_isNull16) {
/* 3277 */                     agg_value368 = (double) smj_value20;
/* 3278 */                   }
/* 3279 */                   if (!agg_isNull333) {
/* 3280 */                     double agg_value370 = agg_unsafeRowAggBuffer.getDouble(26);
/* 3281 */
/* 3282 */                     agg_isNull332 = false; // resultCode could change nullability.
/* 3283 */                     agg_value367 = agg_value368 - agg_value370;
/* 3284 */
/* 3285 */                   }
/* 3286 */                   if (agg_isNull332) {
/* 3287 */                     agg_isNull331 = true;
/* 3288 */                   } else {
/* 3289 */                     agg_value366 = (double)(agg_value367 / agg_value371);
/* 3290 */                   }
/* 3291 */                 }
/* 3292 */                 if (!agg_isNull331) {
/* 3293 */                   agg_isNull326 = false; // resultCode could change nullability.
/* 3294 */                   agg_value361 = agg_value362 - agg_value366;
/* 3295 */
/* 3296 */                 }
/* 3297 */
/* 3298 */               }
/* 3299 */               if (!agg_isNull326) {
/* 3300 */                 agg_isNull321 = false; // resultCode could change nullability.
/* 3301 */                 agg_value356 = agg_value357 * agg_value361;
/* 3302 */
/* 3303 */               }
/* 3304 */
/* 3305 */             }
/* 3306 */             if (!agg_isNull321) {
/* 3307 */               agg_isNull319 = false; // resultCode could change nullability.
/* 3308 */               agg_value354 = agg_value355 + agg_value356;
/* 3309 */
/* 3310 */             }
/* 3311 */             agg_isNull317 = agg_isNull319;
/* 3312 */             agg_value352 = agg_value354;
/* 3313 */           }
/* 3314 */           boolean agg_isNull339 = true;
/* 3315 */           double agg_value374 = -1.0;
/* 3316 */
/* 3317 */           boolean agg_isNull340 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 3318 */           double agg_value375 = agg_isNull340 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 3319 */           if (!agg_isNull340) {
/* 3320 */             agg_isNull339 = false; // resultCode could change nullability.
/* 3321 */             agg_value374 = agg_value375 + agg_value97;
/* 3322 */
/* 3323 */           }
/* 3324 */           boolean agg_isNull341 = false;
/* 3325 */           long agg_value376 = -1L;
/* 3326 */           if (!false && agg_isNull69) {
/* 3327 */             boolean agg_isNull342 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 3328 */             long agg_value377 = agg_isNull342 ? -1L : (agg_unsafeRowAggBuffer.getLong(29));
/* 3329 */             agg_isNull341 = agg_isNull342;
/* 3330 */             agg_value376 = agg_value377;
/* 3331 */           } else {
/* 3332 */             boolean agg_isNull343 = true;
/* 3333 */             long agg_value378 = -1L;
/* 3334 */
/* 3335 */             boolean agg_isNull344 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 3336 */             long agg_value379 = agg_isNull344 ? -1L : (agg_unsafeRowAggBuffer.getLong(29));
/* 3337 */             if (!agg_isNull344) {
/* 3338 */               agg_isNull343 = false; // resultCode could change nullability.
/* 3339 */               agg_value378 = agg_value379 + 1L;
/* 3340 */
/* 3341 */             }
/* 3342 */             agg_isNull341 = agg_isNull343;
/* 3343 */             agg_value376 = agg_value378;
/* 3344 */           }
/* 3345 */           boolean agg_isNull346 = false;
/* 3346 */           double agg_value381 = -1.0;
/* 3347 */           if (!false && agg_isNull60) {
/* 3348 */             double agg_value382 = agg_unsafeRowAggBuffer.getDouble(30);
/* 3349 */             agg_isNull346 = false;
/* 3350 */             agg_value381 = agg_value382;
/* 3351 */           } else {
/* 3352 */             boolean agg_isNull348 = false;
/* 3353 */
/* 3354 */             double agg_value384 = agg_unsafeRowAggBuffer.getDouble(30);
/* 3355 */
/* 3356 */             double agg_value383 = -1.0;
/* 3357 */             agg_value383 = agg_value384 + 1.0D;
/* 3358 */             agg_isNull346 = false;
/* 3359 */             agg_value381 = agg_value383;
/* 3360 */           }
/* 3361 */           boolean agg_isNull351 = false;
/* 3362 */           double agg_value386 = -1.0;
/* 3363 */           if (!false && agg_isNull60) {
/* 3364 */             double agg_value387 = agg_unsafeRowAggBuffer.getDouble(31);
/* 3365 */             agg_isNull351 = false;
/* 3366 */             agg_value386 = agg_value387;
/* 3367 */           } else {
/* 3368 */             boolean agg_isNull353 = true;
/* 3369 */             double agg_value388 = -1.0;
/* 3370 */
/* 3371 */             double agg_value389 = agg_unsafeRowAggBuffer.getDouble(31);
/* 3372 */
/* 3373 */             boolean agg_isNull360 = false;
/* 3374 */
/* 3375 */             double agg_value396 = agg_unsafeRowAggBuffer.getDouble(30);
/* 3376 */
/* 3377 */             double agg_value395 = -1.0;
/* 3378 */             agg_value395 = agg_value396 + 1.0D;
/* 3379 */             boolean agg_isNull355 = false;
/* 3380 */             double agg_value390 = -1.0;
/* 3381 */             if (false || agg_value395 == 0) {
/* 3382 */               agg_isNull355 = true;
/* 3383 */             } else {
/* 3384 */               boolean agg_isNull356 = true;
/* 3385 */               double agg_value391 = -1.0;
/* 3386 */
/* 3387 */               boolean agg_isNull357 = smj_isNull16;
/* 3388 */               double agg_value392 = -1.0;
/* 3389 */               if (!smj_isNull16) {
/* 3390 */                 agg_value392 = (double) smj_value20;
/* 3391 */               }
/* 3392 */               if (!agg_isNull357) {
/* 3393 */                 double agg_value394 = agg_unsafeRowAggBuffer.getDouble(31);
/* 3394 */
/* 3395 */                 agg_isNull356 = false; // resultCode could change nullability.
/* 3396 */                 agg_value391 = agg_value392 - agg_value394;
/* 3397 */
/* 3398 */               }
/* 3399 */               if (agg_isNull356) {
/* 3400 */                 agg_isNull355 = true;
/* 3401 */               } else {
/* 3402 */                 agg_value390 = (double)(agg_value391 / agg_value395);
/* 3403 */               }
/* 3404 */             }
/* 3405 */             if (!agg_isNull355) {
/* 3406 */               agg_isNull353 = false; // resultCode could change nullability.
/* 3407 */               agg_value388 = agg_value389 + agg_value390;
/* 3408 */
/* 3409 */             }
/* 3410 */             agg_isNull351 = agg_isNull353;
/* 3411 */             agg_value386 = agg_value388;
/* 3412 */           }
/* 3413 */           boolean agg_isNull363 = false;
/* 3414 */           double agg_value398 = -1.0;
/* 3415 */           if (!false && agg_isNull60) {
/* 3416 */             double agg_value399 = agg_unsafeRowAggBuffer.getDouble(32);
/* 3417 */             agg_isNull363 = false;
/* 3418 */             agg_value398 = agg_value399;
/* 3419 */           } else {
/* 3420 */             boolean agg_isNull365 = true;
/* 3421 */             double agg_value400 = -1.0;
/* 3422 */
/* 3423 */             double agg_value401 = agg_unsafeRowAggBuffer.getDouble(32);
/* 3424 */
/* 3425 */             boolean agg_isNull367 = true;
/* 3426 */             double agg_value402 = -1.0;
/* 3427 */
/* 3428 */             boolean agg_isNull368 = true;
/* 3429 */             double agg_value403 = -1.0;
/* 3430 */
/* 3431 */             boolean agg_isNull369 = smj_isNull16;
/* 3432 */             double agg_value404 = -1.0;
/* 3433 */             if (!smj_isNull16) {
/* 3434 */               agg_value404 = (double) smj_value20;
/* 3435 */             }
/* 3436 */             if (!agg_isNull369) {
/* 3437 */               double agg_value406 = agg_unsafeRowAggBuffer.getDouble(31);
/* 3438 */
/* 3439 */               agg_isNull368 = false; // resultCode could change nullability.
/* 3440 */               agg_value403 = agg_value404 - agg_value406;
/* 3441 */
/* 3442 */             }
/* 3443 */             if (!agg_isNull368) {
/* 3444 */               boolean agg_isNull372 = true;
/* 3445 */               double agg_value407 = -1.0;
/* 3446 */
/* 3447 */               boolean agg_isNull373 = true;
/* 3448 */               double agg_value408 = -1.0;
/* 3449 */
/* 3450 */               boolean agg_isNull374 = smj_isNull16;
/* 3451 */               double agg_value409 = -1.0;
/* 3452 */               if (!smj_isNull16) {
/* 3453 */                 agg_value409 = (double) smj_value20;
/* 3454 */               }
/* 3455 */               if (!agg_isNull374) {
/* 3456 */                 double agg_value411 = agg_unsafeRowAggBuffer.getDouble(31);
/* 3457 */
/* 3458 */                 agg_isNull373 = false; // resultCode could change nullability.
/* 3459 */                 agg_value408 = agg_value409 - agg_value411;
/* 3460 */
/* 3461 */               }
/* 3462 */               if (!agg_isNull373) {
/* 3463 */                 boolean agg_isNull382 = false;
/* 3464 */
/* 3465 */                 double agg_value418 = agg_unsafeRowAggBuffer.getDouble(30);
/* 3466 */
/* 3467 */                 double agg_value417 = -1.0;
/* 3468 */                 agg_value417 = agg_value418 + 1.0D;
/* 3469 */                 boolean agg_isNull377 = false;
/* 3470 */                 double agg_value412 = -1.0;
/* 3471 */                 if (false || agg_value417 == 0) {
/* 3472 */                   agg_isNull377 = true;
/* 3473 */                 } else {
/* 3474 */                   boolean agg_isNull378 = true;
/* 3475 */                   double agg_value413 = -1.0;
/* 3476 */
/* 3477 */                   boolean agg_isNull379 = smj_isNull16;
/* 3478 */                   double agg_value414 = -1.0;
/* 3479 */                   if (!smj_isNull16) {
/* 3480 */                     agg_value414 = (double) smj_value20;
/* 3481 */                   }
/* 3482 */                   if (!agg_isNull379) {
/* 3483 */                     double agg_value416 = agg_unsafeRowAggBuffer.getDouble(31);
/* 3484 */
/* 3485 */                     agg_isNull378 = false; // resultCode could change nullability.
/* 3486 */                     agg_value413 = agg_value414 - agg_value416;
/* 3487 */
/* 3488 */                   }
/* 3489 */                   if (agg_isNull378) {
/* 3490 */                     agg_isNull377 = true;
/* 3491 */                   } else {
/* 3492 */                     agg_value412 = (double)(agg_value413 / agg_value417);
/* 3493 */                   }
/* 3494 */                 }
/* 3495 */                 if (!agg_isNull377) {
/* 3496 */                   agg_isNull372 = false; // resultCode could change nullability.
/* 3497 */                   agg_value407 = agg_value408 - agg_value412;
/* 3498 */
/* 3499 */                 }
/* 3500 */
/* 3501 */               }
/* 3502 */               if (!agg_isNull372) {
/* 3503 */                 agg_isNull367 = false; // resultCode could change nullability.
/* 3504 */                 agg_value402 = agg_value403 * agg_value407;
/* 3505 */
/* 3506 */               }
/* 3507 */
/* 3508 */             }
/* 3509 */             if (!agg_isNull367) {
/* 3510 */               agg_isNull365 = false; // resultCode could change nullability.
/* 3511 */               agg_value400 = agg_value401 + agg_value402;
/* 3512 */
/* 3513 */             }
/* 3514 */             agg_isNull363 = agg_isNull365;
/* 3515 */             agg_value398 = agg_value400;
/* 3516 */           }
/* 3517 */           boolean agg_isNull385 = true;
/* 3518 */           double agg_value420 = -1.0;
/* 3519 */
/* 3520 */           boolean agg_isNull386 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 3521 */           double agg_value421 = agg_isNull386 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 3522 */           if (!agg_isNull386) {
/* 3523 */             agg_isNull385 = false; // resultCode could change nullability.
/* 3524 */             agg_value420 = agg_value421 + agg_value97;
/* 3525 */
/* 3526 */           }
/* 3527 */           boolean agg_isNull387 = false;
/* 3528 */           long agg_value422 = -1L;
/* 3529 */           if (!false && agg_isNull69) {
/* 3530 */             boolean agg_isNull388 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 3531 */             long agg_value423 = agg_isNull388 ? -1L : (agg_unsafeRowAggBuffer.getLong(34));
/* 3532 */             agg_isNull387 = agg_isNull388;
/* 3533 */             agg_value422 = agg_value423;
/* 3534 */           } else {
/* 3535 */             boolean agg_isNull389 = true;
/* 3536 */             long agg_value424 = -1L;
/* 3537 */
/* 3538 */             boolean agg_isNull390 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 3539 */             long agg_value425 = agg_isNull390 ? -1L : (agg_unsafeRowAggBuffer.getLong(34));
/* 3540 */             if (!agg_isNull390) {
/* 3541 */               agg_isNull389 = false; // resultCode could change nullability.
/* 3542 */               agg_value424 = agg_value425 + 1L;
/* 3543 */
/* 3544 */             }
/* 3545 */             agg_isNull387 = agg_isNull389;
/* 3546 */             agg_value422 = agg_value424;
/* 3547 */           }
/* 3548 */           // update unsafe row buffer
/* 3549 */           agg_unsafeRowAggBuffer.setLong(0, agg_value125);
/* 3550 */
/* 3551 */           if (!agg_isNull97) {
/* 3552 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value132);
/* 3553 */           } else {
/* 3554 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 3555 */           }
/* 3556 */
/* 3557 */           if (!agg_isNull99) {
/* 3558 */             agg_unsafeRowAggBuffer.setLong(2, agg_value134);
/* 3559 */           } else {
/* 3560 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 3561 */           }
/* 3562 */
/* 3563 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value139);
/* 3564 */
/* 3565 */           if (!agg_isNull109) {
/* 3566 */             agg_unsafeRowAggBuffer.setDouble(4, agg_value144);
/* 3567 */           } else {
/* 3568 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 3569 */           }
/* 3570 */
/* 3571 */           if (!agg_isNull121) {
/* 3572 */             agg_unsafeRowAggBuffer.setDouble(5, agg_value156);
/* 3573 */           } else {
/* 3574 */             agg_unsafeRowAggBuffer.setNullAt(5);
/* 3575 */           }
/* 3576 */
/* 3577 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value178);
/* 3578 */
/* 3579 */           if (!agg_isNull148) {
/* 3580 */             agg_unsafeRowAggBuffer.setDouble(7, agg_value183);
/* 3581 */           } else {
/* 3582 */             agg_unsafeRowAggBuffer.setNullAt(7);
/* 3583 */           }
/* 3584 */
/* 3585 */           if (!agg_isNull160) {
/* 3586 */             agg_unsafeRowAggBuffer.setDouble(8, agg_value195);
/* 3587 */           } else {
/* 3588 */             agg_unsafeRowAggBuffer.setNullAt(8);
/* 3589 */           }
/* 3590 */
/* 3591 */           if (!agg_isNull182) {
/* 3592 */             agg_unsafeRowAggBuffer.setDouble(9, agg_value217);
/* 3593 */           } else {
/* 3594 */             agg_unsafeRowAggBuffer.setNullAt(9);
/* 3595 */           }
/* 3596 */
/* 3597 */           if (!agg_isNull184) {
/* 3598 */             agg_unsafeRowAggBuffer.setLong(10, agg_value219);
/* 3599 */           } else {
/* 3600 */             agg_unsafeRowAggBuffer.setNullAt(10);
/* 3601 */           }
/* 3602 */
/* 3603 */           agg_unsafeRowAggBuffer.setLong(11, agg_value224);
/* 3604 */
/* 3605 */           if (!agg_isNull194) {
/* 3606 */             agg_unsafeRowAggBuffer.setDouble(12, agg_value229);
/* 3607 */           } else {
/* 3608 */             agg_unsafeRowAggBuffer.setNullAt(12);
/* 3609 */           }
/* 3610 */
/* 3611 */           if (!agg_isNull196) {
/* 3612 */             agg_unsafeRowAggBuffer.setLong(13, agg_value231);
/* 3613 */           } else {
/* 3614 */             agg_unsafeRowAggBuffer.setNullAt(13);
/* 3615 */           }
/* 3616 */
/* 3617 */           agg_unsafeRowAggBuffer.setDouble(14, agg_value236);
/* 3618 */
/* 3619 */           if (!agg_isNull206) {
/* 3620 */             agg_unsafeRowAggBuffer.setDouble(15, agg_value241);
/* 3621 */           } else {
/* 3622 */             agg_unsafeRowAggBuffer.setNullAt(15);
/* 3623 */           }
/* 3624 */
/* 3625 */           if (!agg_isNull218) {
/* 3626 */             agg_unsafeRowAggBuffer.setDouble(16, agg_value253);
/* 3627 */           } else {
/* 3628 */             agg_unsafeRowAggBuffer.setNullAt(16);
/* 3629 */           }
/* 3630 */
/* 3631 */           agg_unsafeRowAggBuffer.setDouble(17, agg_value275);
/* 3632 */
/* 3633 */           if (!agg_isNull245) {
/* 3634 */             agg_unsafeRowAggBuffer.setDouble(18, agg_value280);
/* 3635 */           } else {
/* 3636 */             agg_unsafeRowAggBuffer.setNullAt(18);
/* 3637 */           }
/* 3638 */
/* 3639 */           if (!agg_isNull257) {
/* 3640 */             agg_unsafeRowAggBuffer.setDouble(19, agg_value292);
/* 3641 */           } else {
/* 3642 */             agg_unsafeRowAggBuffer.setNullAt(19);
/* 3643 */           }
/* 3644 */
/* 3645 */           if (!agg_isNull279) {
/* 3646 */             agg_unsafeRowAggBuffer.setDouble(20, agg_value314);
/* 3647 */           } else {
/* 3648 */             agg_unsafeRowAggBuffer.setNullAt(20);
/* 3649 */           }
/* 3650 */
/* 3651 */           if (!agg_isNull281) {
/* 3652 */             agg_unsafeRowAggBuffer.setLong(21, agg_value316);
/* 3653 */           } else {
/* 3654 */             agg_unsafeRowAggBuffer.setNullAt(21);
/* 3655 */           }
/* 3656 */
/* 3657 */           agg_unsafeRowAggBuffer.setLong(22, agg_value321);
/* 3658 */
/* 3659 */           if (!agg_isNull293) {
/* 3660 */             agg_unsafeRowAggBuffer.setDouble(23, agg_value328);
/* 3661 */           } else {
/* 3662 */             agg_unsafeRowAggBuffer.setNullAt(23);
/* 3663 */           }
/* 3664 */
/* 3665 */           if (!agg_isNull295) {
/* 3666 */             agg_unsafeRowAggBuffer.setLong(24, agg_value330);
/* 3667 */           } else {
/* 3668 */             agg_unsafeRowAggBuffer.setNullAt(24);
/* 3669 */           }
/* 3670 */
/* 3671 */           agg_unsafeRowAggBuffer.setDouble(25, agg_value335);
/* 3672 */
/* 3673 */           if (!agg_isNull305) {
/* 3674 */             agg_unsafeRowAggBuffer.setDouble(26, agg_value340);
/* 3675 */           } else {
/* 3676 */             agg_unsafeRowAggBuffer.setNullAt(26);
/* 3677 */           }
/* 3678 */
/* 3679 */           if (!agg_isNull317) {
/* 3680 */             agg_unsafeRowAggBuffer.setDouble(27, agg_value352);
/* 3681 */           } else {
/* 3682 */             agg_unsafeRowAggBuffer.setNullAt(27);
/* 3683 */           }
/* 3684 */
/* 3685 */           if (!agg_isNull339) {
/* 3686 */             agg_unsafeRowAggBuffer.setDouble(28, agg_value374);
/* 3687 */           } else {
/* 3688 */             agg_unsafeRowAggBuffer.setNullAt(28);
/* 3689 */           }
/* 3690 */
/* 3691 */           if (!agg_isNull341) {
/* 3692 */             agg_unsafeRowAggBuffer.setLong(29, agg_value376);
/* 3693 */           } else {
/* 3694 */             agg_unsafeRowAggBuffer.setNullAt(29);
/* 3695 */           }
/* 3696 */
/* 3697 */           agg_unsafeRowAggBuffer.setDouble(30, agg_value381);
/* 3698 */
/* 3699 */           if (!agg_isNull351) {
/* 3700 */             agg_unsafeRowAggBuffer.setDouble(31, agg_value386);
/* 3701 */           } else {
/* 3702 */             agg_unsafeRowAggBuffer.setNullAt(31);
/* 3703 */           }
/* 3704 */
/* 3705 */           if (!agg_isNull363) {
/* 3706 */             agg_unsafeRowAggBuffer.setDouble(32, agg_value398);
/* 3707 */           } else {
/* 3708 */             agg_unsafeRowAggBuffer.setNullAt(32);
/* 3709 */           }
/* 3710 */
/* 3711 */           if (!agg_isNull385) {
/* 3712 */             agg_unsafeRowAggBuffer.setDouble(33, agg_value420);
/* 3713 */           } else {
/* 3714 */             agg_unsafeRowAggBuffer.setNullAt(33);
/* 3715 */           }
/* 3716 */
/* 3717 */           if (!agg_isNull387) {
/* 3718 */             agg_unsafeRowAggBuffer.setLong(34, agg_value422);
/* 3719 */           } else {
/* 3720 */             agg_unsafeRowAggBuffer.setNullAt(34);
/* 3721 */           }
/* 3722 */
/* 3723 */         }
/* 3724 */
/* 3725 */       }
/* 3726 */       if (shouldStop()) return;
/* 3727 */     }
/* 3728 */
/* 3729 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 3730 */
/* 3731 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 3732 */   }
/* 3733 */
/* 3734 */   private boolean findNextInnerJoinRows(
/* 3735 */     scala.collection.Iterator leftIter,
/* 3736 */     scala.collection.Iterator rightIter) {
/* 3737 */     smj_leftRow = null;
/* 3738 */     int comp = 0;
/* 3739 */     while (smj_leftRow == null) {
/* 3740 */       if (!leftIter.hasNext()) return false;
/* 3741 */       smj_leftRow = (InternalRow) leftIter.next();
/* 3742 */
/* 3743 */       boolean smj_isNull = smj_leftRow.isNullAt(5);
/* 3744 */       long smj_value = smj_isNull ? -1L : (smj_leftRow.getLong(5));
/* 3745 */
/* 3746 */       boolean smj_isNull1 = smj_leftRow.isNullAt(4);
/* 3747 */       long smj_value1 = smj_isNull1 ? -1L : (smj_leftRow.getLong(4));
/* 3748 */       if (smj_isNull || smj_isNull1) {
/* 3749 */         smj_leftRow = null;
/* 3750 */         continue;
/* 3751 */       }
/* 3752 */       if (!smj_matches.isEmpty()) {
/* 3753 */         comp = 0;
/* 3754 */         if (comp == 0) {
/* 3755 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 3756 */         }
/* 3757 */         if (comp == 0) {
/* 3758 */           comp = (smj_value1 > smj_value9 ? 1 : smj_value1 < smj_value9 ? -1 : 0);
/* 3759 */         }
/* 3760 */
/* 3761 */         if (comp == 0) {
/* 3762 */           return true;
/* 3763 */         }
/* 3764 */         smj_matches.clear();
/* 3765 */       }
/* 3766 */
/* 3767 */       do {
/* 3768 */         if (smj_rightRow == null) {
/* 3769 */           if (!rightIter.hasNext()) {
/* 3770 */             smj_value8 = smj_value;
/* 3771 */             smj_value9 = smj_value1;
/* 3772 */             return !smj_matches.isEmpty();
/* 3773 */           }
/* 3774 */           smj_rightRow = (InternalRow) rightIter.next();
/* 3775 */
/* 3776 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 3777 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 3778 */           boolean smj_isNull2 = smj_isNull3;
/* 3779 */           long smj_value2 = -1L;
/* 3780 */           if (!smj_isNull3) {
/* 3781 */             smj_value2 = (long) smj_value3;
/* 3782 */           }
/* 3783 */
/* 3784 */           boolean smj_isNull5 = smj_rightRow.isNullAt(1);
/* 3785 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(1));
/* 3786 */           boolean smj_isNull4 = smj_isNull5;
/* 3787 */           long smj_value4 = -1L;
/* 3788 */           if (!smj_isNull5) {
/* 3789 */             smj_value4 = (long) smj_value5;
/* 3790 */           }
/* 3791 */           if (smj_isNull2 || smj_isNull4) {
/* 3792 */             smj_rightRow = null;
/* 3793 */             continue;
/* 3794 */           }
/* 3795 */           smj_value6 = smj_value2;
/* 3796 */           smj_value7 = smj_value4;
/* 3797 */         }
/* 3798 */
/* 3799 */         comp = 0;
/* 3800 */         if (comp == 0) {
/* 3801 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 3802 */         }
/* 3803 */         if (comp == 0) {
/* 3804 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 3805 */         }
/* 3806 */
/* 3807 */         if (comp > 0) {
/* 3808 */           smj_rightRow = null;
/* 3809 */         } else if (comp < 0) {
/* 3810 */           if (!smj_matches.isEmpty()) {
/* 3811 */             smj_value8 = smj_value;
/* 3812 */             smj_value9 = smj_value1;
/* 3813 */             return true;
/* 3814 */           }
/* 3815 */           smj_leftRow = null;
/* 3816 */         } else {
/* 3817 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 3818 */           smj_rightRow = null;;
/* 3819 */         }
/* 3820 */       } while (smj_leftRow != null);
/* 3821 */     }
/* 3822 */     return false; // unreachable
/* 3823 */   }
/* 3824 */
/* 3825 */   private void wholestagecodegen_init_5() {
/* 3826 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 6);
/* 3827 */     agg_result3 = new UnsafeRow(3);
/* 3828 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 96);
/* 3829 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 3830 */
/* 3831 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 3832 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[52];
/* 3833 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[53];
/* 3834 */
/* 3835 */   }
/* 3836 */
/* 3837 */   private void wholestagecodegen_init_2() {
/* 3838 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[44];
/* 3839 */
/* 3840 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 3841 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 3842 */
/* 3843 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[45];
/* 3844 */     bhj_result1 = new UnsafeRow(8);
/* 3845 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 3846 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 3847 */     project_result2 = new UnsafeRow(6);
/* 3848 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 3849 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 3850 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[46];
/* 3851 */
/* 3852 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 3853 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 3854 */
/* 3855 */   }
/* 3856 */
/* 3857 */   private void wholestagecodegen_init_1() {
/* 3858 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 3859 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 3860 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[42];
/* 3861 */
/* 3862 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 3863 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 3864 */
/* 3865 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[43];
/* 3866 */     bhj_result = new UnsafeRow(9);
/* 3867 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 3868 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 3869 */     project_result1 = new UnsafeRow(7);
/* 3870 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 3871 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 3872 */
/* 3873 */   }
/* 3874 */
/* 3875 */   private void wholestagecodegen_init_4() {
/* 3876 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 7);
/* 3877 */     project_result4 = new UnsafeRow(5);
/* 3878 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 32);
/* 3879 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 5);
/* 3880 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[50];
/* 3881 */
/* 3882 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 3883 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 3884 */
/* 3885 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[51];
/* 3886 */     bhj_result4 = new UnsafeRow(8);
/* 3887 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 96);
/* 3888 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 8);
/* 3889 */     project_result5 = new UnsafeRow(6);
/* 3890 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 96);
/* 3891 */
/* 3892 */   }
/* 3893 */
/* 3894 */   protected void processNext() throws java.io.IOException {
/* 3895 */     if (!agg_initAgg) {
/* 3896 */       agg_initAgg = true;
/* 3897 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 3898 */       agg_doAggregateWithKeys();
/* 3899 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 3900 */     }
/* 3901 */
/* 3902 */     // output the result
/* 3903 */
/* 3904 */     while (agg_fastHashMapIter.next()) {
/* 3905 */       wholestagecodegen_numOutputRows.add(1);
/* 3906 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 3907 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 3908 */
/* 3909 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 3910 */
/* 3911 */       append(agg_resultRow.copy());
/* 3912 */
/* 3913 */       if (shouldStop()) return;
/* 3914 */     }
/* 3915 */     agg_fastHashMap.close();
/* 3916 */
/* 3917 */     while (agg_mapIter.next()) {
/* 3918 */       wholestagecodegen_numOutputRows.add(1);
/* 3919 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 3920 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 3921 */
/* 3922 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 3923 */
/* 3924 */       append(agg_resultRow.copy());
/* 3925 */
/* 3926 */       if (shouldStop()) return;
/* 3927 */     }
/* 3928 */
/* 3929 */     agg_mapIter.close();
/* 3930 */     if (agg_sorter == null) {
/* 3931 */       agg_hashMap.free();
/* 3932 */     }
/* 3933 */   }
/* 3934 */ }
