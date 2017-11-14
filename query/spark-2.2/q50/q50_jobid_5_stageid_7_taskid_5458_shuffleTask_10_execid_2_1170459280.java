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
/* 019 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 020 */   private agg_FastHashMap agg_fastHashMap;
/* 021 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 022 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 023 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 024 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 027 */   private scala.collection.Iterator smj_leftInput;
/* 028 */   private scala.collection.Iterator smj_rightInput;
/* 029 */   private InternalRow smj_leftRow;
/* 030 */   private InternalRow smj_rightRow;
/* 031 */   private long smj_value9;
/* 032 */   private long smj_value10;
/* 033 */   private long smj_value11;
/* 034 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 035 */   private long smj_value12;
/* 036 */   private long smj_value13;
/* 037 */   private long smj_value14;
/* 038 */   private int smj_value15;
/* 039 */   private boolean smj_isNull9;
/* 040 */   private int smj_value16;
/* 041 */   private boolean smj_isNull10;
/* 042 */   private int smj_value17;
/* 043 */   private boolean smj_isNull11;
/* 044 */   private int smj_value18;
/* 045 */   private boolean smj_isNull12;
/* 046 */   private int smj_value19;
/* 047 */   private boolean smj_isNull13;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 049 */   private UnsafeRow smj_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 052 */   private UnsafeRow project_result;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 055 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 056 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 058 */   private UnsafeRow bhj_result;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 061 */   private UnsafeRow project_result1;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 064 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 065 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 067 */   private UnsafeRow bhj_result1;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 070 */   private UnsafeRow project_result2;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 073 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 074 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 075 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 076 */   private UnsafeRow bhj_result2;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 079 */   private UnsafeRow project_result3;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 081 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 082 */   private UnsafeRow agg_result10;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 085 */   private int agg_value30;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 087 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 088 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 089 */
/* 090 */   public GeneratedIterator(Object[] references) {
/* 091 */     this.references = references;
/* 092 */   }
/* 093 */
/* 094 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 095 */     partitionIndex = index;
/* 096 */     this.inputs = inputs;
/* 097 */     wholestagecodegen_init_0();
/* 098 */     wholestagecodegen_init_1();
/* 099 */     wholestagecodegen_init_2();
/* 100 */     wholestagecodegen_init_3();
/* 101 */
/* 102 */   }
/* 103 */
/* 104 */   private void wholestagecodegen_init_0() {
/* 105 */     agg_initAgg = false;
/* 106 */
/* 107 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 108 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 109 */
/* 110 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 111 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 112 */     smj_leftInput = inputs[0];
/* 113 */     smj_rightInput = inputs[1];
/* 114 */
/* 115 */     smj_rightRow = null;
/* 116 */
/* 117 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 118 */
/* 119 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 120 */     smj_result = new UnsafeRow(9);
/* 121 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 122 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 123 */     project_result = new UnsafeRow(3);
/* 124 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 125 */
/* 126 */   }
/* 127 */
/* 128 */   private void wholestagecodegen_init_3() {
/* 129 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 130 */     bhj_result2 = new UnsafeRow(13);
/* 131 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 288);
/* 132 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 13);
/* 133 */     project_result3 = new UnsafeRow(12);
/* 134 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 288);
/* 135 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 12);
/* 136 */     agg_result10 = new UnsafeRow(10);
/* 137 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result10, 288);
/* 138 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 10);
/* 139 */
/* 140 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 141 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[25];
/* 142 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[26];
/* 143 */
/* 144 */   }
/* 145 */
/* 146 */   public class agg_FastHashMap {
/* 147 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 148 */     private int[] buckets;
/* 149 */     private int capacity = 1 << 16;
/* 150 */     private double loadFactor = 0.5;
/* 151 */     private int numBuckets = (int) (capacity / loadFactor);
/* 152 */     private int maxSteps = 2;
/* 153 */     private int numRows = 0;
/* 154 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 155 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 156 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 157 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 158 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 159 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.StringType)
/* 160 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.StringType)
/* 161 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.StringType)
/* 162 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.StringType)
/* 163 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.StringType);
/* 164 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.LongType)
/* 165 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.LongType)
/* 166 */     .add("((java.lang.String) references[15])", org.apache.spark.sql.types.DataTypes.LongType)
/* 167 */     .add("((java.lang.String) references[16])", org.apache.spark.sql.types.DataTypes.LongType)
/* 168 */     .add("((java.lang.String) references[17])", org.apache.spark.sql.types.DataTypes.LongType);
/* 169 */     private Object emptyVBase;
/* 170 */     private long emptyVOff;
/* 171 */     private int emptyVLen;
/* 172 */     private boolean isBatchFull = false;
/* 173 */
/* 174 */     public agg_FastHashMap(
/* 175 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 176 */       InternalRow emptyAggregationBuffer) {
/* 177 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 178 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 179 */
/* 180 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 181 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 182 */
/* 183 */       emptyVBase = emptyBuffer;
/* 184 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 185 */       emptyVLen = emptyBuffer.length;
/* 186 */
/* 187 */       buckets = new int[numBuckets];
/* 188 */       java.util.Arrays.fill(buckets, -1);
/* 189 */     }
/* 190 */
/* 191 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 192 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9);
/* 193 */       int step = 0;
/* 194 */       int idx = (int) h & (numBuckets - 1);
/* 195 */       while (step < maxSteps) {
/* 196 */         // Return bucket index if it's either an empty slot or already contains the key
/* 197 */         if (buckets[idx] == -1) {
/* 198 */           if (numRows < capacity && !isBatchFull) {
/* 199 */             // creating the unsafe for new entry
/* 200 */             UnsafeRow agg_result = new UnsafeRow(10);
/* 201 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 202 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 203 */               288);
/* 204 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 205 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 206 */               agg_holder,
/* 207 */               10);
/* 208 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 209 */             agg_rowWriter.zeroOutNullBytes();
/* 210 */             agg_rowWriter.write(0, agg_key);
/* 211 */             agg_rowWriter.write(1, agg_key1);
/* 212 */             agg_rowWriter.write(2, agg_key2);
/* 213 */             agg_rowWriter.write(3, agg_key3);
/* 214 */             agg_rowWriter.write(4, agg_key4);
/* 215 */             agg_rowWriter.write(5, agg_key5);
/* 216 */             agg_rowWriter.write(6, agg_key6);
/* 217 */             agg_rowWriter.write(7, agg_key7);
/* 218 */             agg_rowWriter.write(8, agg_key8);
/* 219 */             agg_rowWriter.write(9, agg_key9);
/* 220 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 221 */             Object kbase = agg_result.getBaseObject();
/* 222 */             long koff = agg_result.getBaseOffset();
/* 223 */             int klen = agg_result.getSizeInBytes();
/* 224 */
/* 225 */             UnsafeRow vRow
/* 226 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 227 */             if (vRow == null) {
/* 228 */               isBatchFull = true;
/* 229 */             } else {
/* 230 */               buckets[idx] = numRows++;
/* 231 */             }
/* 232 */             return vRow;
/* 233 */           } else {
/* 234 */             // No more space
/* 235 */             return null;
/* 236 */           }
/* 237 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9)) {
/* 238 */           return batch.getValueRow(buckets[idx]);
/* 239 */         }
/* 240 */         idx = (idx + 1) & (numBuckets - 1);
/* 241 */         step++;
/* 242 */       }
/* 243 */       // Didn't find it
/* 244 */       return null;
/* 245 */     }
/* 246 */
/* 247 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 248 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 249 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getUTF8String(7).equals(agg_key7)) && (row.getUTF8String(8).equals(agg_key8)) && (row.getUTF8String(9).equals(agg_key9));
/* 250 */     }
/* 251 */
/* 252 */     private long hash(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, UTF8String agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 253 */       long agg_hash = 0;
/* 254 */
/* 255 */       int agg_result = 0;
/* 256 */       byte[] agg_bytes = agg_key.getBytes();
/* 257 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 258 */         int agg_hash1 = agg_bytes[i];
/* 259 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 260 */       }
/* 261 */
/* 262 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 263 */
/* 264 */       int agg_result1 = agg_key1;
/* 265 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 266 */
/* 267 */       int agg_result2 = 0;
/* 268 */       byte[] agg_bytes1 = agg_key2.getBytes();
/* 269 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 270 */         int agg_hash2 = agg_bytes1[i];
/* 271 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash2 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 272 */       }
/* 273 */
/* 274 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 275 */
/* 276 */       int agg_result3 = 0;
/* 277 */       byte[] agg_bytes2 = agg_key3.getBytes();
/* 278 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 279 */         int agg_hash3 = agg_bytes2[i];
/* 280 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash3 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 281 */       }
/* 282 */
/* 283 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 284 */
/* 285 */       int agg_result4 = 0;
/* 286 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 287 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 288 */         int agg_hash4 = agg_bytes3[i];
/* 289 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 290 */       }
/* 291 */
/* 292 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 293 */
/* 294 */       int agg_result5 = 0;
/* 295 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 296 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 297 */         int agg_hash5 = agg_bytes4[i];
/* 298 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 299 */       }
/* 300 */
/* 301 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 302 */
/* 303 */       int agg_result6 = 0;
/* 304 */       byte[] agg_bytes5 = agg_key6.getBytes();
/* 305 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 306 */         int agg_hash6 = agg_bytes5[i];
/* 307 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash6 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 308 */       }
/* 309 */
/* 310 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 311 */
/* 312 */       int agg_result7 = 0;
/* 313 */       byte[] agg_bytes6 = agg_key7.getBytes();
/* 314 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 315 */         int agg_hash7 = agg_bytes6[i];
/* 316 */         agg_result7 = (agg_result7 ^ (0x9e3779b9)) + agg_hash7 + (agg_result7 << 6) + (agg_result7 >>> 2);
/* 317 */       }
/* 318 */
/* 319 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 320 */
/* 321 */       int agg_result8 = 0;
/* 322 */       byte[] agg_bytes7 = agg_key8.getBytes();
/* 323 */       for (int i = 0; i < agg_bytes7.length; i++) {
/* 324 */         int agg_hash8 = agg_bytes7[i];
/* 325 */         agg_result8 = (agg_result8 ^ (0x9e3779b9)) + agg_hash8 + (agg_result8 << 6) + (agg_result8 >>> 2);
/* 326 */       }
/* 327 */
/* 328 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result8 + (agg_hash << 6) + (agg_hash >>> 2);
/* 329 */
/* 330 */       int agg_result9 = 0;
/* 331 */       byte[] agg_bytes8 = agg_key9.getBytes();
/* 332 */       for (int i = 0; i < agg_bytes8.length; i++) {
/* 333 */         int agg_hash9 = agg_bytes8[i];
/* 334 */         agg_result9 = (agg_result9 ^ (0x9e3779b9)) + agg_hash9 + (agg_result9 << 6) + (agg_result9 >>> 2);
/* 335 */       }
/* 336 */
/* 337 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result9 + (agg_hash << 6) + (agg_hash >>> 2);
/* 338 */
/* 339 */       return agg_hash;
/* 340 */     }
/* 341 */
/* 342 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 343 */       return batch.rowIterator();
/* 344 */     }
/* 345 */
/* 346 */     public void close() {
/* 347 */       batch.close();
/* 348 */     }
/* 349 */
/* 350 */   }
/* 351 */
/* 352 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 353 */     agg_hashMap = agg_plan.createHashMap();
/* 354 */
/* 355 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 356 */       smj_isNull9 = smj_leftRow.isNullAt(0);
/* 357 */       smj_value15 = smj_isNull9 ? -1 : (smj_leftRow.getInt(0));
/* 358 */       smj_isNull10 = smj_leftRow.isNullAt(1);
/* 359 */       smj_value16 = smj_isNull10 ? -1 : (smj_leftRow.getInt(1));
/* 360 */       smj_isNull11 = smj_leftRow.isNullAt(2);
/* 361 */       smj_value17 = smj_isNull11 ? -1 : (smj_leftRow.getInt(2));
/* 362 */       smj_isNull12 = smj_leftRow.isNullAt(3);
/* 363 */       smj_value18 = smj_isNull12 ? -1 : (smj_leftRow.getInt(3));
/* 364 */       smj_isNull13 = smj_leftRow.isNullAt(4);
/* 365 */       smj_value19 = smj_isNull13 ? -1 : (smj_leftRow.getInt(4));
/* 366 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 367 */       while (smj_iterator.hasNext()) {
/* 368 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 369 */
/* 370 */         smj_numOutputRows.add(1);
/* 371 */
/* 372 */         // generate join key for stream side
/* 373 */
/* 374 */         boolean bhj_isNull = smj_isNull11;
/* 375 */         long bhj_value = -1L;
/* 376 */         if (!smj_isNull11) {
/* 377 */           bhj_value = (long) smj_value17;
/* 378 */         }
/* 379 */         // find matches from HashedRelation
/* 380 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 381 */         if (bhj_matched == null) continue;
/* 382 */
/* 383 */         bhj_numOutputRows.add(1);
/* 384 */
/* 385 */         // generate join key for stream side
/* 386 */
/* 387 */         boolean bhj_isNull27 = smj_isNull13;
/* 388 */         long bhj_value27 = -1L;
/* 389 */         if (!smj_isNull13) {
/* 390 */           bhj_value27 = (long) smj_value19;
/* 391 */         }
/* 392 */         // find matches from HashedRelation
/* 393 */         UnsafeRow bhj_matched1 = bhj_isNull27 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value27);
/* 394 */         if (bhj_matched1 == null) continue;
/* 395 */
/* 396 */         bhj_numOutputRows1.add(1);
/* 397 */
/* 398 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(3);
/* 399 */         int smj_value23 = smj_isNull17 ? -1 : (smj_rightRow1.getInt(3));
/* 400 */
/* 401 */         // generate join key for stream side
/* 402 */
/* 403 */         boolean bhj_isNull43 = smj_isNull17;
/* 404 */         long bhj_value43 = -1L;
/* 405 */         if (!smj_isNull17) {
/* 406 */           bhj_value43 = (long) smj_value23;
/* 407 */         }
/* 408 */         // find matches from HashedRelation
/* 409 */         UnsafeRow bhj_matched2 = bhj_isNull43 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value43);
/* 410 */         if (bhj_matched2 == null) continue;
/* 411 */
/* 412 */         bhj_numOutputRows2.add(1);
/* 413 */
/* 414 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 415 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 416 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 417 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 418 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 419 */         UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 420 */         boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 421 */         UTF8String bhj_value6 = bhj_isNull6 ? null : (bhj_matched.getUTF8String(4));
/* 422 */         boolean bhj_isNull7 = bhj_matched.isNullAt(5);
/* 423 */         UTF8String bhj_value7 = bhj_isNull7 ? null : (bhj_matched.getUTF8String(5));
/* 424 */         boolean bhj_isNull8 = bhj_matched.isNullAt(6);
/* 425 */         UTF8String bhj_value8 = bhj_isNull8 ? null : (bhj_matched.getUTF8String(6));
/* 426 */         boolean bhj_isNull9 = bhj_matched.isNullAt(7);
/* 427 */         UTF8String bhj_value9 = bhj_isNull9 ? null : (bhj_matched.getUTF8String(7));
/* 428 */         boolean bhj_isNull10 = bhj_matched.isNullAt(8);
/* 429 */         UTF8String bhj_value10 = bhj_isNull10 ? null : (bhj_matched.getUTF8String(8));
/* 430 */         boolean bhj_isNull11 = bhj_matched.isNullAt(9);
/* 431 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched.getUTF8String(9));
/* 432 */         boolean bhj_isNull12 = bhj_matched.isNullAt(10);
/* 433 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched.getUTF8String(10));
/* 434 */
/* 435 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 436 */
/* 437 */         UnsafeRow agg_fastAggBuffer = null;
/* 438 */
/* 439 */         if (true) {
/* 440 */           if (!bhj_isNull3 && !bhj_isNull4 && !bhj_isNull5 && !bhj_isNull6 && !bhj_isNull7 && !bhj_isNull8 && !bhj_isNull9 && !bhj_isNull10 && !bhj_isNull11 && !bhj_isNull12) {
/* 441 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 442 */               bhj_value3, bhj_value4, bhj_value5, bhj_value6, bhj_value7, bhj_value8, bhj_value9, bhj_value10, bhj_value11, bhj_value12);
/* 443 */           }
/* 444 */         }
/* 445 */
/* 446 */         if (agg_fastAggBuffer == null) {
/* 447 */           // generate grouping key
/* 448 */           agg_holder.reset();
/* 449 */
/* 450 */           agg_rowWriter.zeroOutNullBytes();
/* 451 */
/* 452 */           if (bhj_isNull3) {
/* 453 */             agg_rowWriter.setNullAt(0);
/* 454 */           } else {
/* 455 */             agg_rowWriter.write(0, bhj_value3);
/* 456 */           }
/* 457 */
/* 458 */           if (bhj_isNull4) {
/* 459 */             agg_rowWriter.setNullAt(1);
/* 460 */           } else {
/* 461 */             agg_rowWriter.write(1, bhj_value4);
/* 462 */           }
/* 463 */
/* 464 */           if (bhj_isNull5) {
/* 465 */             agg_rowWriter.setNullAt(2);
/* 466 */           } else {
/* 467 */             agg_rowWriter.write(2, bhj_value5);
/* 468 */           }
/* 469 */
/* 470 */           if (bhj_isNull6) {
/* 471 */             agg_rowWriter.setNullAt(3);
/* 472 */           } else {
/* 473 */             agg_rowWriter.write(3, bhj_value6);
/* 474 */           }
/* 475 */
/* 476 */           if (bhj_isNull7) {
/* 477 */             agg_rowWriter.setNullAt(4);
/* 478 */           } else {
/* 479 */             agg_rowWriter.write(4, bhj_value7);
/* 480 */           }
/* 481 */
/* 482 */           if (bhj_isNull8) {
/* 483 */             agg_rowWriter.setNullAt(5);
/* 484 */           } else {
/* 485 */             agg_rowWriter.write(5, bhj_value8);
/* 486 */           }
/* 487 */
/* 488 */           if (bhj_isNull9) {
/* 489 */             agg_rowWriter.setNullAt(6);
/* 490 */           } else {
/* 491 */             agg_rowWriter.write(6, bhj_value9);
/* 492 */           }
/* 493 */
/* 494 */           if (bhj_isNull10) {
/* 495 */             agg_rowWriter.setNullAt(7);
/* 496 */           } else {
/* 497 */             agg_rowWriter.write(7, bhj_value10);
/* 498 */           }
/* 499 */
/* 500 */           if (bhj_isNull11) {
/* 501 */             agg_rowWriter.setNullAt(8);
/* 502 */           } else {
/* 503 */             agg_rowWriter.write(8, bhj_value11);
/* 504 */           }
/* 505 */
/* 506 */           if (bhj_isNull12) {
/* 507 */             agg_rowWriter.setNullAt(9);
/* 508 */           } else {
/* 509 */             agg_rowWriter.write(9, bhj_value12);
/* 510 */           }
/* 511 */           agg_result10.setTotalSize(agg_holder.totalSize());
/* 512 */           agg_value30 = 42;
/* 513 */
/* 514 */           if (!bhj_isNull3) {
/* 515 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value30);
/* 516 */           }
/* 517 */
/* 518 */           if (!bhj_isNull4) {
/* 519 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value4, agg_value30);
/* 520 */           }
/* 521 */
/* 522 */           if (!bhj_isNull5) {
/* 523 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value5.getBaseObject(), bhj_value5.getBaseOffset(), bhj_value5.numBytes(), agg_value30);
/* 524 */           }
/* 525 */
/* 526 */           if (!bhj_isNull6) {
/* 527 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value6.getBaseObject(), bhj_value6.getBaseOffset(), bhj_value6.numBytes(), agg_value30);
/* 528 */           }
/* 529 */
/* 530 */           if (!bhj_isNull7) {
/* 531 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value7.getBaseObject(), bhj_value7.getBaseOffset(), bhj_value7.numBytes(), agg_value30);
/* 532 */           }
/* 533 */
/* 534 */           if (!bhj_isNull8) {
/* 535 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value8.getBaseObject(), bhj_value8.getBaseOffset(), bhj_value8.numBytes(), agg_value30);
/* 536 */           }
/* 537 */
/* 538 */           if (!bhj_isNull9) {
/* 539 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value9.getBaseObject(), bhj_value9.getBaseOffset(), bhj_value9.numBytes(), agg_value30);
/* 540 */           }
/* 541 */
/* 542 */           if (!bhj_isNull10) {
/* 543 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value10.getBaseObject(), bhj_value10.getBaseOffset(), bhj_value10.numBytes(), agg_value30);
/* 544 */           }
/* 545 */
/* 546 */           if (!bhj_isNull11) {
/* 547 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value11.getBaseObject(), bhj_value11.getBaseOffset(), bhj_value11.numBytes(), agg_value30);
/* 548 */           }
/* 549 */
/* 550 */           if (!bhj_isNull12) {
/* 551 */             agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value12.getBaseObject(), bhj_value12.getBaseOffset(), bhj_value12.numBytes(), agg_value30);
/* 552 */           }
/* 553 */           if (true) {
/* 554 */             // try to get the buffer from hash map
/* 555 */             agg_unsafeRowAggBuffer =
/* 556 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result10, agg_value30);
/* 557 */           }
/* 558 */           if (agg_unsafeRowAggBuffer == null) {
/* 559 */             if (agg_sorter == null) {
/* 560 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 561 */             } else {
/* 562 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 563 */             }
/* 564 */
/* 565 */             // the hash map had be spilled, it should have enough memory now,
/* 566 */             // try  to allocate buffer again.
/* 567 */             agg_unsafeRowAggBuffer =
/* 568 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result10, agg_value30);
/* 569 */             if (agg_unsafeRowAggBuffer == null) {
/* 570 */               // failed to allocate the first page
/* 571 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 572 */             }
/* 573 */           }
/* 574 */         }
/* 575 */
/* 576 */         if (agg_fastAggBuffer != null) {
/* 577 */           // update fast row
/* 578 */
/* 579 */           // common sub-expressions
/* 580 */           boolean agg_isNull103 = true;
/* 581 */           int agg_value108 = -1;
/* 582 */
/* 583 */           if (!smj_isNull17) {
/* 584 */             if (!smj_isNull13) {
/* 585 */               agg_isNull103 = false; // resultCode could change nullability.
/* 586 */               agg_value108 = smj_value23 - smj_value19;
/* 587 */
/* 588 */             }
/* 589 */
/* 590 */           }
/* 591 */           // evaluate aggregate function
/* 592 */           boolean agg_isNull106 = false;
/* 593 */
/* 594 */           boolean agg_isNull108 = agg_fastAggBuffer.isNullAt(0);
/* 595 */           long agg_value113 = agg_isNull108 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 596 */           boolean agg_isNull107 = agg_isNull108;
/* 597 */           long agg_value112 = agg_value113;
/* 598 */           if (agg_isNull107) {
/* 599 */             boolean agg_isNull109 = false;
/* 600 */             long agg_value114 = -1L;
/* 601 */             if (!false) {
/* 602 */               agg_value114 = (long) 0;
/* 603 */             }
/* 604 */             if (!agg_isNull109) {
/* 605 */               agg_isNull107 = false;
/* 606 */               agg_value112 = agg_value114;
/* 607 */             }
/* 608 */           }
/* 609 */
/* 610 */           boolean agg_isNull112 = true;
/* 611 */           int agg_value117 = -1;
/* 612 */
/* 613 */           boolean agg_isNull113 = true;
/* 614 */           boolean agg_value118 = false;
/* 615 */
/* 616 */           if (!agg_isNull103) {
/* 617 */             agg_isNull113 = false; // resultCode could change nullability.
/* 618 */             agg_value118 = agg_value108 <= 30;
/* 619 */
/* 620 */           }
/* 621 */           if (!agg_isNull113 && agg_value118) {
/* 622 */             agg_isNull112 = false;
/* 623 */             agg_value117 = 1;
/* 624 */           }
/* 625 */
/* 626 */           else {
/* 627 */             agg_isNull112 = false;
/* 628 */             agg_value117 = 0;
/* 629 */           }
/* 630 */           boolean agg_isNull111 = agg_isNull112;
/* 631 */           long agg_value116 = -1L;
/* 632 */           if (!agg_isNull112) {
/* 633 */             agg_value116 = (long) agg_value117;
/* 634 */           }
/* 635 */           long agg_value111 = -1L;
/* 636 */           agg_value111 = agg_value112 + agg_value116;
/* 637 */           boolean agg_isNull117 = false;
/* 638 */
/* 639 */           boolean agg_isNull119 = agg_fastAggBuffer.isNullAt(1);
/* 640 */           long agg_value124 = agg_isNull119 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 641 */           boolean agg_isNull118 = agg_isNull119;
/* 642 */           long agg_value123 = agg_value124;
/* 643 */           if (agg_isNull118) {
/* 644 */             boolean agg_isNull120 = false;
/* 645 */             long agg_value125 = -1L;
/* 646 */             if (!false) {
/* 647 */               agg_value125 = (long) 0;
/* 648 */             }
/* 649 */             if (!agg_isNull120) {
/* 650 */               agg_isNull118 = false;
/* 651 */               agg_value123 = agg_value125;
/* 652 */             }
/* 653 */           }
/* 654 */
/* 655 */           boolean agg_isNull123 = true;
/* 656 */           int agg_value128 = -1;
/* 657 */
/* 658 */           boolean agg_isNull125 = true;
/* 659 */           boolean agg_value130 = false;
/* 660 */
/* 661 */           if (!agg_isNull103) {
/* 662 */             agg_isNull125 = false; // resultCode could change nullability.
/* 663 */             agg_value130 = agg_value108 > 30;
/* 664 */
/* 665 */           }
/* 666 */           boolean agg_isNull124 = false;
/* 667 */           boolean agg_value129 = false;
/* 668 */
/* 669 */           if (!agg_isNull125 && !agg_value130) {
/* 670 */           } else {
/* 671 */             boolean agg_isNull127 = true;
/* 672 */             boolean agg_value132 = false;
/* 673 */
/* 674 */             if (!agg_isNull103) {
/* 675 */               agg_isNull127 = false; // resultCode could change nullability.
/* 676 */               agg_value132 = agg_value108 <= 60;
/* 677 */
/* 678 */             }
/* 679 */             if (!agg_isNull127 && !agg_value132) {
/* 680 */             } else if (!agg_isNull125 && !agg_isNull127) {
/* 681 */               agg_value129 = true;
/* 682 */             } else {
/* 683 */               agg_isNull124 = true;
/* 684 */             }
/* 685 */           }
/* 686 */           if (!agg_isNull124 && agg_value129) {
/* 687 */             agg_isNull123 = false;
/* 688 */             agg_value128 = 1;
/* 689 */           }
/* 690 */
/* 691 */           else {
/* 692 */             agg_isNull123 = false;
/* 693 */             agg_value128 = 0;
/* 694 */           }
/* 695 */           boolean agg_isNull122 = agg_isNull123;
/* 696 */           long agg_value127 = -1L;
/* 697 */           if (!agg_isNull123) {
/* 698 */             agg_value127 = (long) agg_value128;
/* 699 */           }
/* 700 */           long agg_value122 = -1L;
/* 701 */           agg_value122 = agg_value123 + agg_value127;
/* 702 */           boolean agg_isNull131 = false;
/* 703 */
/* 704 */           boolean agg_isNull133 = agg_fastAggBuffer.isNullAt(2);
/* 705 */           long agg_value138 = agg_isNull133 ? -1L : (agg_fastAggBuffer.getLong(2));
/* 706 */           boolean agg_isNull132 = agg_isNull133;
/* 707 */           long agg_value137 = agg_value138;
/* 708 */           if (agg_isNull132) {
/* 709 */             boolean agg_isNull134 = false;
/* 710 */             long agg_value139 = -1L;
/* 711 */             if (!false) {
/* 712 */               agg_value139 = (long) 0;
/* 713 */             }
/* 714 */             if (!agg_isNull134) {
/* 715 */               agg_isNull132 = false;
/* 716 */               agg_value137 = agg_value139;
/* 717 */             }
/* 718 */           }
/* 719 */
/* 720 */           boolean agg_isNull137 = true;
/* 721 */           int agg_value142 = -1;
/* 722 */
/* 723 */           boolean agg_isNull139 = true;
/* 724 */           boolean agg_value144 = false;
/* 725 */
/* 726 */           if (!agg_isNull103) {
/* 727 */             agg_isNull139 = false; // resultCode could change nullability.
/* 728 */             agg_value144 = agg_value108 > 60;
/* 729 */
/* 730 */           }
/* 731 */           boolean agg_isNull138 = false;
/* 732 */           boolean agg_value143 = false;
/* 733 */
/* 734 */           if (!agg_isNull139 && !agg_value144) {
/* 735 */           } else {
/* 736 */             boolean agg_isNull141 = true;
/* 737 */             boolean agg_value146 = false;
/* 738 */
/* 739 */             if (!agg_isNull103) {
/* 740 */               agg_isNull141 = false; // resultCode could change nullability.
/* 741 */               agg_value146 = agg_value108 <= 90;
/* 742 */
/* 743 */             }
/* 744 */             if (!agg_isNull141 && !agg_value146) {
/* 745 */             } else if (!agg_isNull139 && !agg_isNull141) {
/* 746 */               agg_value143 = true;
/* 747 */             } else {
/* 748 */               agg_isNull138 = true;
/* 749 */             }
/* 750 */           }
/* 751 */           if (!agg_isNull138 && agg_value143) {
/* 752 */             agg_isNull137 = false;
/* 753 */             agg_value142 = 1;
/* 754 */           }
/* 755 */
/* 756 */           else {
/* 757 */             agg_isNull137 = false;
/* 758 */             agg_value142 = 0;
/* 759 */           }
/* 760 */           boolean agg_isNull136 = agg_isNull137;
/* 761 */           long agg_value141 = -1L;
/* 762 */           if (!agg_isNull137) {
/* 763 */             agg_value141 = (long) agg_value142;
/* 764 */           }
/* 765 */           long agg_value136 = -1L;
/* 766 */           agg_value136 = agg_value137 + agg_value141;
/* 767 */           boolean agg_isNull145 = false;
/* 768 */
/* 769 */           boolean agg_isNull147 = agg_fastAggBuffer.isNullAt(3);
/* 770 */           long agg_value152 = agg_isNull147 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 771 */           boolean agg_isNull146 = agg_isNull147;
/* 772 */           long agg_value151 = agg_value152;
/* 773 */           if (agg_isNull146) {
/* 774 */             boolean agg_isNull148 = false;
/* 775 */             long agg_value153 = -1L;
/* 776 */             if (!false) {
/* 777 */               agg_value153 = (long) 0;
/* 778 */             }
/* 779 */             if (!agg_isNull148) {
/* 780 */               agg_isNull146 = false;
/* 781 */               agg_value151 = agg_value153;
/* 782 */             }
/* 783 */           }
/* 784 */
/* 785 */           boolean agg_isNull151 = true;
/* 786 */           int agg_value156 = -1;
/* 787 */
/* 788 */           boolean agg_isNull153 = true;
/* 789 */           boolean agg_value158 = false;
/* 790 */
/* 791 */           if (!agg_isNull103) {
/* 792 */             agg_isNull153 = false; // resultCode could change nullability.
/* 793 */             agg_value158 = agg_value108 > 90;
/* 794 */
/* 795 */           }
/* 796 */           boolean agg_isNull152 = false;
/* 797 */           boolean agg_value157 = false;
/* 798 */
/* 799 */           if (!agg_isNull153 && !agg_value158) {
/* 800 */           } else {
/* 801 */             boolean agg_isNull155 = true;
/* 802 */             boolean agg_value160 = false;
/* 803 */
/* 804 */             if (!agg_isNull103) {
/* 805 */               agg_isNull155 = false; // resultCode could change nullability.
/* 806 */               agg_value160 = agg_value108 <= 120;
/* 807 */
/* 808 */             }
/* 809 */             if (!agg_isNull155 && !agg_value160) {
/* 810 */             } else if (!agg_isNull153 && !agg_isNull155) {
/* 811 */               agg_value157 = true;
/* 812 */             } else {
/* 813 */               agg_isNull152 = true;
/* 814 */             }
/* 815 */           }
/* 816 */           if (!agg_isNull152 && agg_value157) {
/* 817 */             agg_isNull151 = false;
/* 818 */             agg_value156 = 1;
/* 819 */           }
/* 820 */
/* 821 */           else {
/* 822 */             agg_isNull151 = false;
/* 823 */             agg_value156 = 0;
/* 824 */           }
/* 825 */           boolean agg_isNull150 = agg_isNull151;
/* 826 */           long agg_value155 = -1L;
/* 827 */           if (!agg_isNull151) {
/* 828 */             agg_value155 = (long) agg_value156;
/* 829 */           }
/* 830 */           long agg_value150 = -1L;
/* 831 */           agg_value150 = agg_value151 + agg_value155;
/* 832 */           boolean agg_isNull159 = false;
/* 833 */
/* 834 */           boolean agg_isNull161 = agg_fastAggBuffer.isNullAt(4);
/* 835 */           long agg_value166 = agg_isNull161 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 836 */           boolean agg_isNull160 = agg_isNull161;
/* 837 */           long agg_value165 = agg_value166;
/* 838 */           if (agg_isNull160) {
/* 839 */             boolean agg_isNull162 = false;
/* 840 */             long agg_value167 = -1L;
/* 841 */             if (!false) {
/* 842 */               agg_value167 = (long) 0;
/* 843 */             }
/* 844 */             if (!agg_isNull162) {
/* 845 */               agg_isNull160 = false;
/* 846 */               agg_value165 = agg_value167;
/* 847 */             }
/* 848 */           }
/* 849 */
/* 850 */           boolean agg_isNull165 = true;
/* 851 */           int agg_value170 = -1;
/* 852 */
/* 853 */           boolean agg_isNull166 = true;
/* 854 */           boolean agg_value171 = false;
/* 855 */
/* 856 */           if (!agg_isNull103) {
/* 857 */             agg_isNull166 = false; // resultCode could change nullability.
/* 858 */             agg_value171 = agg_value108 > 120;
/* 859 */
/* 860 */           }
/* 861 */           if (!agg_isNull166 && agg_value171) {
/* 862 */             agg_isNull165 = false;
/* 863 */             agg_value170 = 1;
/* 864 */           }
/* 865 */
/* 866 */           else {
/* 867 */             agg_isNull165 = false;
/* 868 */             agg_value170 = 0;
/* 869 */           }
/* 870 */           boolean agg_isNull164 = agg_isNull165;
/* 871 */           long agg_value169 = -1L;
/* 872 */           if (!agg_isNull165) {
/* 873 */             agg_value169 = (long) agg_value170;
/* 874 */           }
/* 875 */           long agg_value164 = -1L;
/* 876 */           agg_value164 = agg_value165 + agg_value169;
/* 877 */           // update fast row
/* 878 */           agg_fastAggBuffer.setLong(0, agg_value111);
/* 879 */           agg_fastAggBuffer.setLong(1, agg_value122);
/* 880 */           agg_fastAggBuffer.setLong(2, agg_value136);
/* 881 */           agg_fastAggBuffer.setLong(3, agg_value150);
/* 882 */           agg_fastAggBuffer.setLong(4, agg_value164);
/* 883 */
/* 884 */         } else {
/* 885 */           // update unsafe row
/* 886 */
/* 887 */           // common sub-expressions
/* 888 */           boolean agg_isNull36 = true;
/* 889 */           int agg_value41 = -1;
/* 890 */
/* 891 */           if (!smj_isNull17) {
/* 892 */             if (!smj_isNull13) {
/* 893 */               agg_isNull36 = false; // resultCode could change nullability.
/* 894 */               agg_value41 = smj_value23 - smj_value19;
/* 895 */
/* 896 */             }
/* 897 */
/* 898 */           }
/* 899 */           // evaluate aggregate function
/* 900 */           boolean agg_isNull39 = false;
/* 901 */
/* 902 */           boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 903 */           long agg_value46 = agg_isNull41 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 904 */           boolean agg_isNull40 = agg_isNull41;
/* 905 */           long agg_value45 = agg_value46;
/* 906 */           if (agg_isNull40) {
/* 907 */             boolean agg_isNull42 = false;
/* 908 */             long agg_value47 = -1L;
/* 909 */             if (!false) {
/* 910 */               agg_value47 = (long) 0;
/* 911 */             }
/* 912 */             if (!agg_isNull42) {
/* 913 */               agg_isNull40 = false;
/* 914 */               agg_value45 = agg_value47;
/* 915 */             }
/* 916 */           }
/* 917 */
/* 918 */           boolean agg_isNull45 = true;
/* 919 */           int agg_value50 = -1;
/* 920 */
/* 921 */           boolean agg_isNull46 = true;
/* 922 */           boolean agg_value51 = false;
/* 923 */
/* 924 */           if (!agg_isNull36) {
/* 925 */             agg_isNull46 = false; // resultCode could change nullability.
/* 926 */             agg_value51 = agg_value41 <= 30;
/* 927 */
/* 928 */           }
/* 929 */           if (!agg_isNull46 && agg_value51) {
/* 930 */             agg_isNull45 = false;
/* 931 */             agg_value50 = 1;
/* 932 */           }
/* 933 */
/* 934 */           else {
/* 935 */             agg_isNull45 = false;
/* 936 */             agg_value50 = 0;
/* 937 */           }
/* 938 */           boolean agg_isNull44 = agg_isNull45;
/* 939 */           long agg_value49 = -1L;
/* 940 */           if (!agg_isNull45) {
/* 941 */             agg_value49 = (long) agg_value50;
/* 942 */           }
/* 943 */           long agg_value44 = -1L;
/* 944 */           agg_value44 = agg_value45 + agg_value49;
/* 945 */           boolean agg_isNull50 = false;
/* 946 */
/* 947 */           boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 948 */           long agg_value57 = agg_isNull52 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 949 */           boolean agg_isNull51 = agg_isNull52;
/* 950 */           long agg_value56 = agg_value57;
/* 951 */           if (agg_isNull51) {
/* 952 */             boolean agg_isNull53 = false;
/* 953 */             long agg_value58 = -1L;
/* 954 */             if (!false) {
/* 955 */               agg_value58 = (long) 0;
/* 956 */             }
/* 957 */             if (!agg_isNull53) {
/* 958 */               agg_isNull51 = false;
/* 959 */               agg_value56 = agg_value58;
/* 960 */             }
/* 961 */           }
/* 962 */
/* 963 */           boolean agg_isNull56 = true;
/* 964 */           int agg_value61 = -1;
/* 965 */
/* 966 */           boolean agg_isNull58 = true;
/* 967 */           boolean agg_value63 = false;
/* 968 */
/* 969 */           if (!agg_isNull36) {
/* 970 */             agg_isNull58 = false; // resultCode could change nullability.
/* 971 */             agg_value63 = agg_value41 > 30;
/* 972 */
/* 973 */           }
/* 974 */           boolean agg_isNull57 = false;
/* 975 */           boolean agg_value62 = false;
/* 976 */
/* 977 */           if (!agg_isNull58 && !agg_value63) {
/* 978 */           } else {
/* 979 */             boolean agg_isNull60 = true;
/* 980 */             boolean agg_value65 = false;
/* 981 */
/* 982 */             if (!agg_isNull36) {
/* 983 */               agg_isNull60 = false; // resultCode could change nullability.
/* 984 */               agg_value65 = agg_value41 <= 60;
/* 985 */
/* 986 */             }
/* 987 */             if (!agg_isNull60 && !agg_value65) {
/* 988 */             } else if (!agg_isNull58 && !agg_isNull60) {
/* 989 */               agg_value62 = true;
/* 990 */             } else {
/* 991 */               agg_isNull57 = true;
/* 992 */             }
/* 993 */           }
/* 994 */           if (!agg_isNull57 && agg_value62) {
/* 995 */             agg_isNull56 = false;
/* 996 */             agg_value61 = 1;
/* 997 */           }
/* 998 */
/* 999 */           else {
/* 1000 */             agg_isNull56 = false;
/* 1001 */             agg_value61 = 0;
/* 1002 */           }
/* 1003 */           boolean agg_isNull55 = agg_isNull56;
/* 1004 */           long agg_value60 = -1L;
/* 1005 */           if (!agg_isNull56) {
/* 1006 */             agg_value60 = (long) agg_value61;
/* 1007 */           }
/* 1008 */           long agg_value55 = -1L;
/* 1009 */           agg_value55 = agg_value56 + agg_value60;
/* 1010 */           boolean agg_isNull64 = false;
/* 1011 */
/* 1012 */           boolean agg_isNull66 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 1013 */           long agg_value71 = agg_isNull66 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 1014 */           boolean agg_isNull65 = agg_isNull66;
/* 1015 */           long agg_value70 = agg_value71;
/* 1016 */           if (agg_isNull65) {
/* 1017 */             boolean agg_isNull67 = false;
/* 1018 */             long agg_value72 = -1L;
/* 1019 */             if (!false) {
/* 1020 */               agg_value72 = (long) 0;
/* 1021 */             }
/* 1022 */             if (!agg_isNull67) {
/* 1023 */               agg_isNull65 = false;
/* 1024 */               agg_value70 = agg_value72;
/* 1025 */             }
/* 1026 */           }
/* 1027 */
/* 1028 */           boolean agg_isNull70 = true;
/* 1029 */           int agg_value75 = -1;
/* 1030 */
/* 1031 */           boolean agg_isNull72 = true;
/* 1032 */           boolean agg_value77 = false;
/* 1033 */
/* 1034 */           if (!agg_isNull36) {
/* 1035 */             agg_isNull72 = false; // resultCode could change nullability.
/* 1036 */             agg_value77 = agg_value41 > 60;
/* 1037 */
/* 1038 */           }
/* 1039 */           boolean agg_isNull71 = false;
/* 1040 */           boolean agg_value76 = false;
/* 1041 */
/* 1042 */           if (!agg_isNull72 && !agg_value77) {
/* 1043 */           } else {
/* 1044 */             boolean agg_isNull74 = true;
/* 1045 */             boolean agg_value79 = false;
/* 1046 */
/* 1047 */             if (!agg_isNull36) {
/* 1048 */               agg_isNull74 = false; // resultCode could change nullability.
/* 1049 */               agg_value79 = agg_value41 <= 90;
/* 1050 */
/* 1051 */             }
/* 1052 */             if (!agg_isNull74 && !agg_value79) {
/* 1053 */             } else if (!agg_isNull72 && !agg_isNull74) {
/* 1054 */               agg_value76 = true;
/* 1055 */             } else {
/* 1056 */               agg_isNull71 = true;
/* 1057 */             }
/* 1058 */           }
/* 1059 */           if (!agg_isNull71 && agg_value76) {
/* 1060 */             agg_isNull70 = false;
/* 1061 */             agg_value75 = 1;
/* 1062 */           }
/* 1063 */
/* 1064 */           else {
/* 1065 */             agg_isNull70 = false;
/* 1066 */             agg_value75 = 0;
/* 1067 */           }
/* 1068 */           boolean agg_isNull69 = agg_isNull70;
/* 1069 */           long agg_value74 = -1L;
/* 1070 */           if (!agg_isNull70) {
/* 1071 */             agg_value74 = (long) agg_value75;
/* 1072 */           }
/* 1073 */           long agg_value69 = -1L;
/* 1074 */           agg_value69 = agg_value70 + agg_value74;
/* 1075 */           boolean agg_isNull78 = false;
/* 1076 */
/* 1077 */           boolean agg_isNull80 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1078 */           long agg_value85 = agg_isNull80 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 1079 */           boolean agg_isNull79 = agg_isNull80;
/* 1080 */           long agg_value84 = agg_value85;
/* 1081 */           if (agg_isNull79) {
/* 1082 */             boolean agg_isNull81 = false;
/* 1083 */             long agg_value86 = -1L;
/* 1084 */             if (!false) {
/* 1085 */               agg_value86 = (long) 0;
/* 1086 */             }
/* 1087 */             if (!agg_isNull81) {
/* 1088 */               agg_isNull79 = false;
/* 1089 */               agg_value84 = agg_value86;
/* 1090 */             }
/* 1091 */           }
/* 1092 */
/* 1093 */           boolean agg_isNull84 = true;
/* 1094 */           int agg_value89 = -1;
/* 1095 */
/* 1096 */           boolean agg_isNull86 = true;
/* 1097 */           boolean agg_value91 = false;
/* 1098 */
/* 1099 */           if (!agg_isNull36) {
/* 1100 */             agg_isNull86 = false; // resultCode could change nullability.
/* 1101 */             agg_value91 = agg_value41 > 90;
/* 1102 */
/* 1103 */           }
/* 1104 */           boolean agg_isNull85 = false;
/* 1105 */           boolean agg_value90 = false;
/* 1106 */
/* 1107 */           if (!agg_isNull86 && !agg_value91) {
/* 1108 */           } else {
/* 1109 */             boolean agg_isNull88 = true;
/* 1110 */             boolean agg_value93 = false;
/* 1111 */
/* 1112 */             if (!agg_isNull36) {
/* 1113 */               agg_isNull88 = false; // resultCode could change nullability.
/* 1114 */               agg_value93 = agg_value41 <= 120;
/* 1115 */
/* 1116 */             }
/* 1117 */             if (!agg_isNull88 && !agg_value93) {
/* 1118 */             } else if (!agg_isNull86 && !agg_isNull88) {
/* 1119 */               agg_value90 = true;
/* 1120 */             } else {
/* 1121 */               agg_isNull85 = true;
/* 1122 */             }
/* 1123 */           }
/* 1124 */           if (!agg_isNull85 && agg_value90) {
/* 1125 */             agg_isNull84 = false;
/* 1126 */             agg_value89 = 1;
/* 1127 */           }
/* 1128 */
/* 1129 */           else {
/* 1130 */             agg_isNull84 = false;
/* 1131 */             agg_value89 = 0;
/* 1132 */           }
/* 1133 */           boolean agg_isNull83 = agg_isNull84;
/* 1134 */           long agg_value88 = -1L;
/* 1135 */           if (!agg_isNull84) {
/* 1136 */             agg_value88 = (long) agg_value89;
/* 1137 */           }
/* 1138 */           long agg_value83 = -1L;
/* 1139 */           agg_value83 = agg_value84 + agg_value88;
/* 1140 */           boolean agg_isNull92 = false;
/* 1141 */
/* 1142 */           boolean agg_isNull94 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1143 */           long agg_value99 = agg_isNull94 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 1144 */           boolean agg_isNull93 = agg_isNull94;
/* 1145 */           long agg_value98 = agg_value99;
/* 1146 */           if (agg_isNull93) {
/* 1147 */             boolean agg_isNull95 = false;
/* 1148 */             long agg_value100 = -1L;
/* 1149 */             if (!false) {
/* 1150 */               agg_value100 = (long) 0;
/* 1151 */             }
/* 1152 */             if (!agg_isNull95) {
/* 1153 */               agg_isNull93 = false;
/* 1154 */               agg_value98 = agg_value100;
/* 1155 */             }
/* 1156 */           }
/* 1157 */
/* 1158 */           boolean agg_isNull98 = true;
/* 1159 */           int agg_value103 = -1;
/* 1160 */
/* 1161 */           boolean agg_isNull99 = true;
/* 1162 */           boolean agg_value104 = false;
/* 1163 */
/* 1164 */           if (!agg_isNull36) {
/* 1165 */             agg_isNull99 = false; // resultCode could change nullability.
/* 1166 */             agg_value104 = agg_value41 > 120;
/* 1167 */
/* 1168 */           }
/* 1169 */           if (!agg_isNull99 && agg_value104) {
/* 1170 */             agg_isNull98 = false;
/* 1171 */             agg_value103 = 1;
/* 1172 */           }
/* 1173 */
/* 1174 */           else {
/* 1175 */             agg_isNull98 = false;
/* 1176 */             agg_value103 = 0;
/* 1177 */           }
/* 1178 */           boolean agg_isNull97 = agg_isNull98;
/* 1179 */           long agg_value102 = -1L;
/* 1180 */           if (!agg_isNull98) {
/* 1181 */             agg_value102 = (long) agg_value103;
/* 1182 */           }
/* 1183 */           long agg_value97 = -1L;
/* 1184 */           agg_value97 = agg_value98 + agg_value102;
/* 1185 */           // update unsafe row buffer
/* 1186 */           agg_unsafeRowAggBuffer.setLong(0, agg_value44);
/* 1187 */           agg_unsafeRowAggBuffer.setLong(1, agg_value55);
/* 1188 */           agg_unsafeRowAggBuffer.setLong(2, agg_value69);
/* 1189 */           agg_unsafeRowAggBuffer.setLong(3, agg_value83);
/* 1190 */           agg_unsafeRowAggBuffer.setLong(4, agg_value97);
/* 1191 */
/* 1192 */         }
/* 1193 */
/* 1194 */       }
/* 1195 */       if (shouldStop()) return;
/* 1196 */     }
/* 1197 */
/* 1198 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1199 */
/* 1200 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1201 */   }
/* 1202 */
/* 1203 */   private boolean findNextInnerJoinRows(
/* 1204 */     scala.collection.Iterator leftIter,
/* 1205 */     scala.collection.Iterator rightIter) {
/* 1206 */     smj_leftRow = null;
/* 1207 */     int comp = 0;
/* 1208 */     while (smj_leftRow == null) {
/* 1209 */       if (!leftIter.hasNext()) return false;
/* 1210 */       smj_leftRow = (InternalRow) leftIter.next();
/* 1211 */
/* 1212 */       boolean smj_isNull1 = smj_leftRow.isNullAt(3);
/* 1213 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(3));
/* 1214 */       boolean smj_isNull = smj_isNull1;
/* 1215 */       long smj_value = -1L;
/* 1216 */       if (!smj_isNull1) {
/* 1217 */         smj_value = (long) smj_value1;
/* 1218 */       }
/* 1219 */
/* 1220 */       boolean smj_isNull3 = smj_leftRow.isNullAt(0);
/* 1221 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(0));
/* 1222 */       boolean smj_isNull2 = smj_isNull3;
/* 1223 */       long smj_value2 = -1L;
/* 1224 */       if (!smj_isNull3) {
/* 1225 */         smj_value2 = (long) smj_value3;
/* 1226 */       }
/* 1227 */
/* 1228 */       boolean smj_isNull5 = smj_leftRow.isNullAt(1);
/* 1229 */       int smj_value5 = smj_isNull5 ? -1 : (smj_leftRow.getInt(1));
/* 1230 */       boolean smj_isNull4 = smj_isNull5;
/* 1231 */       long smj_value4 = -1L;
/* 1232 */       if (!smj_isNull5) {
/* 1233 */         smj_value4 = (long) smj_value5;
/* 1234 */       }
/* 1235 */       if (smj_isNull || smj_isNull2 || smj_isNull4) {
/* 1236 */         smj_leftRow = null;
/* 1237 */         continue;
/* 1238 */       }
/* 1239 */       if (!smj_matches.isEmpty()) {
/* 1240 */         comp = 0;
/* 1241 */         if (comp == 0) {
/* 1242 */           comp = (smj_value > smj_value12 ? 1 : smj_value < smj_value12 ? -1 : 0);
/* 1243 */         }
/* 1244 */         if (comp == 0) {
/* 1245 */           comp = (smj_value2 > smj_value13 ? 1 : smj_value2 < smj_value13 ? -1 : 0);
/* 1246 */         }
/* 1247 */         if (comp == 0) {
/* 1248 */           comp = (smj_value4 > smj_value14 ? 1 : smj_value4 < smj_value14 ? -1 : 0);
/* 1249 */         }
/* 1250 */
/* 1251 */         if (comp == 0) {
/* 1252 */           return true;
/* 1253 */         }
/* 1254 */         smj_matches.clear();
/* 1255 */       }
/* 1256 */
/* 1257 */       do {
/* 1258 */         if (smj_rightRow == null) {
/* 1259 */           if (!rightIter.hasNext()) {
/* 1260 */             smj_value12 = smj_value;
/* 1261 */             smj_value13 = smj_value2;
/* 1262 */             smj_value14 = smj_value4;
/* 1263 */             return !smj_matches.isEmpty();
/* 1264 */           }
/* 1265 */           smj_rightRow = (InternalRow) rightIter.next();
/* 1266 */
/* 1267 */           boolean smj_isNull6 = smj_rightRow.isNullAt(2);
/* 1268 */           long smj_value6 = smj_isNull6 ? -1L : (smj_rightRow.getLong(2));
/* 1269 */
/* 1270 */           boolean smj_isNull7 = smj_rightRow.isNullAt(0);
/* 1271 */           long smj_value7 = smj_isNull7 ? -1L : (smj_rightRow.getLong(0));
/* 1272 */
/* 1273 */           boolean smj_isNull8 = smj_rightRow.isNullAt(1);
/* 1274 */           long smj_value8 = smj_isNull8 ? -1L : (smj_rightRow.getLong(1));
/* 1275 */           if (smj_isNull6 || smj_isNull7 || smj_isNull8) {
/* 1276 */             smj_rightRow = null;
/* 1277 */             continue;
/* 1278 */           }
/* 1279 */           smj_value9 = smj_value6;
/* 1280 */           smj_value10 = smj_value7;
/* 1281 */           smj_value11 = smj_value8;
/* 1282 */         }
/* 1283 */
/* 1284 */         comp = 0;
/* 1285 */         if (comp == 0) {
/* 1286 */           comp = (smj_value > smj_value9 ? 1 : smj_value < smj_value9 ? -1 : 0);
/* 1287 */         }
/* 1288 */         if (comp == 0) {
/* 1289 */           comp = (smj_value2 > smj_value10 ? 1 : smj_value2 < smj_value10 ? -1 : 0);
/* 1290 */         }
/* 1291 */         if (comp == 0) {
/* 1292 */           comp = (smj_value4 > smj_value11 ? 1 : smj_value4 < smj_value11 ? -1 : 0);
/* 1293 */         }
/* 1294 */
/* 1295 */         if (comp > 0) {
/* 1296 */           smj_rightRow = null;
/* 1297 */         } else if (comp < 0) {
/* 1298 */           if (!smj_matches.isEmpty()) {
/* 1299 */             smj_value12 = smj_value;
/* 1300 */             smj_value13 = smj_value2;
/* 1301 */             smj_value14 = smj_value4;
/* 1302 */             return true;
/* 1303 */           }
/* 1304 */           smj_leftRow = null;
/* 1305 */         } else {
/* 1306 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 1307 */           smj_rightRow = null;;
/* 1308 */         }
/* 1309 */       } while (smj_leftRow != null);
/* 1310 */     }
/* 1311 */     return false; // unreachable
/* 1312 */   }
/* 1313 */
/* 1314 */   private void wholestagecodegen_init_2() {
/* 1315 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1316 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1317 */
/* 1318 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 1319 */     bhj_result1 = new UnsafeRow(13);
/* 1320 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 288);
/* 1321 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 13);
/* 1322 */     project_result2 = new UnsafeRow(12);
/* 1323 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 288);
/* 1324 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 12);
/* 1325 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[23];
/* 1326 */
/* 1327 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1328 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1329 */
/* 1330 */   }
/* 1331 */
/* 1332 */   private void wholestagecodegen_init_1() {
/* 1333 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 1334 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 1335 */
/* 1336 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1337 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1338 */
/* 1339 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 1340 */     bhj_result = new UnsafeRow(14);
/* 1341 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 288);
/* 1342 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 14);
/* 1343 */     project_result1 = new UnsafeRow(12);
/* 1344 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 288);
/* 1345 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 12);
/* 1346 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[21];
/* 1347 */
/* 1348 */   }
/* 1349 */
/* 1350 */   protected void processNext() throws java.io.IOException {
/* 1351 */     if (!agg_initAgg) {
/* 1352 */       agg_initAgg = true;
/* 1353 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1354 */       agg_doAggregateWithKeys();
/* 1355 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1356 */     }
/* 1357 */
/* 1358 */     // output the result
/* 1359 */
/* 1360 */     while (agg_fastHashMapIter.next()) {
/* 1361 */       wholestagecodegen_numOutputRows.add(1);
/* 1362 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1363 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1364 */
/* 1365 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1366 */
/* 1367 */       append(agg_resultRow.copy());
/* 1368 */
/* 1369 */       if (shouldStop()) return;
/* 1370 */     }
/* 1371 */     agg_fastHashMap.close();
/* 1372 */
/* 1373 */     while (agg_mapIter.next()) {
/* 1374 */       wholestagecodegen_numOutputRows.add(1);
/* 1375 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1376 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1377 */
/* 1378 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1379 */
/* 1380 */       append(agg_resultRow.copy());
/* 1381 */
/* 1382 */       if (shouldStop()) return;
/* 1383 */     }
/* 1384 */
/* 1385 */     agg_mapIter.close();
/* 1386 */     if (agg_sorter == null) {
/* 1387 */       agg_hashMap.free();
/* 1388 */     }
/* 1389 */   }
/* 1390 */ }
