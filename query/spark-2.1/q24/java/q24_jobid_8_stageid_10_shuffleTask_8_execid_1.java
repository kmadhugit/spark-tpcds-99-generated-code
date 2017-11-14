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
/* 019 */   private scala.collection.Iterator smj_leftInput;
/* 020 */   private scala.collection.Iterator smj_rightInput;
/* 021 */   private InternalRow smj_leftRow;
/* 022 */   private InternalRow smj_rightRow;
/* 023 */   private long smj_value6;
/* 024 */   private long smj_value7;
/* 025 */   private java.util.ArrayList smj_matches;
/* 026 */   private long smj_value8;
/* 027 */   private long smj_value9;
/* 028 */   private int smj_value10;
/* 029 */   private boolean smj_isNull6;
/* 030 */   private int smj_value11;
/* 031 */   private boolean smj_isNull7;
/* 032 */   private int smj_value12;
/* 033 */   private boolean smj_isNull8;
/* 034 */   private int smj_value13;
/* 035 */   private boolean smj_isNull9;
/* 036 */   private double smj_value14;
/* 037 */   private boolean smj_isNull10;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 039 */   private UnsafeRow smj_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private UnsafeRow project_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 054 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 055 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 057 */   private UnsafeRow bhj_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 060 */   private UnsafeRow project_result2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 066 */   private UnsafeRow bhj_result2;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 069 */   private UnsafeRow project_result3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 072 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 073 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation3;
/* 074 */   private UnsafeRow bhj_result3;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 078 */   private UnsafeRow bhj_result4;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 081 */   private UnsafeRow project_result4;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 084 */   private UnsafeRow agg_result10;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 087 */   private int agg_value22;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 089 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 090 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 091 */
/* 092 */   public GeneratedIterator(Object[] references) {
/* 093 */     this.references = references;
/* 094 */   }
/* 095 */
/* 096 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 097 */     partitionIndex = index;
/* 098 */     this.inputs = inputs;
/* 099 */     wholestagecodegen_init_0();
/* 100 */     wholestagecodegen_init_1();
/* 101 */     wholestagecodegen_init_2();
/* 102 */     wholestagecodegen_init_3();
/* 103 */     wholestagecodegen_init_4();
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */   private void wholestagecodegen_init_0() {
/* 108 */     agg_initAgg = false;
/* 109 */
/* 110 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 111 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 112 */
/* 113 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 114 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 115 */     smj_leftInput = inputs[0];
/* 116 */     smj_rightInput = inputs[1];
/* 117 */
/* 118 */     smj_rightRow = null;
/* 119 */
/* 120 */     smj_matches = new java.util.ArrayList();
/* 121 */
/* 122 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 123 */     smj_result = new UnsafeRow(7);
/* 124 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 125 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
/* 126 */     project_result = new UnsafeRow(4);
/* 127 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 128 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 129 */
/* 130 */   }
/* 131 */
/* 132 */   private void wholestagecodegen_init_3() {
/* 133 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 14);
/* 134 */     project_result3 = new UnsafeRow(12);
/* 135 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 288);
/* 136 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 12);
/* 137 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 138 */
/* 139 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 140 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 141 */
/* 142 */     bhj_result3 = new UnsafeRow(2);
/* 143 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 64);
/* 144 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 2);
/* 145 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 146 */     bhj_result4 = new UnsafeRow(15);
/* 147 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 384);
/* 148 */
/* 149 */   }
/* 150 */
/* 151 */   public class agg_FastHashMap {
/* 152 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 153 */     private int[] buckets;
/* 154 */     private int capacity = 1 << 16;
/* 155 */     private double loadFactor = 0.5;
/* 156 */     private int numBuckets = (int) (capacity / loadFactor);
/* 157 */     private int maxSteps = 2;
/* 158 */     private int numRows = 0;
/* 159 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("c_last_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 160 */     .add("c_first_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 161 */     .add("s_store_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 162 */     .add("ca_state", org.apache.spark.sql.types.DataTypes.StringType)
/* 163 */     .add("s_state", org.apache.spark.sql.types.DataTypes.StringType)
/* 164 */     .add("i_color", org.apache.spark.sql.types.DataTypes.StringType)
/* 165 */     .add("i_current_price", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 166 */     .add("i_manager_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 167 */     .add("i_units", org.apache.spark.sql.types.DataTypes.StringType)
/* 168 */     .add("i_size", org.apache.spark.sql.types.DataTypes.StringType);
/* 169 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 170 */     private Object emptyVBase;
/* 171 */     private long emptyVOff;
/* 172 */     private int emptyVLen;
/* 173 */     private boolean isBatchFull = false;
/* 174 */
/* 175 */     public agg_FastHashMap(
/* 176 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 177 */       InternalRow emptyAggregationBuffer) {
/* 178 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 179 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 180 */
/* 181 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 182 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 183 */
/* 184 */       emptyVBase = emptyBuffer;
/* 185 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 186 */       emptyVLen = emptyBuffer.length;
/* 187 */
/* 188 */       buckets = new int[numBuckets];
/* 189 */       java.util.Arrays.fill(buckets, -1);
/* 190 */     }
/* 191 */
/* 192 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, double agg_key6, int agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 193 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9);
/* 194 */       int step = 0;
/* 195 */       int idx = (int) h & (numBuckets - 1);
/* 196 */       while (step < maxSteps) {
/* 197 */         // Return bucket index if it's either an empty slot or already contains the key
/* 198 */         if (buckets[idx] == -1) {
/* 199 */           if (numRows < capacity && !isBatchFull) {
/* 200 */             // creating the unsafe for new entry
/* 201 */             UnsafeRow agg_result = new UnsafeRow(10);
/* 202 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 203 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 204 */               256);
/* 205 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 206 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 207 */               agg_holder,
/* 208 */               10);
/* 209 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 210 */             agg_rowWriter.zeroOutNullBytes();
/* 211 */             agg_rowWriter.write(0, agg_key);
/* 212 */             agg_rowWriter.write(1, agg_key1);
/* 213 */             agg_rowWriter.write(2, agg_key2);
/* 214 */             agg_rowWriter.write(3, agg_key3);
/* 215 */             agg_rowWriter.write(4, agg_key4);
/* 216 */             agg_rowWriter.write(5, agg_key5);
/* 217 */             agg_rowWriter.write(6, agg_key6);
/* 218 */             agg_rowWriter.write(7, agg_key7);
/* 219 */             agg_rowWriter.write(8, agg_key8);
/* 220 */             agg_rowWriter.write(9, agg_key9);
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
/* 238 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7, agg_key8, agg_key9)) {
/* 239 */           return batch.getValueRow(buckets[idx]);
/* 240 */         }
/* 241 */         idx = (idx + 1) & (numBuckets - 1);
/* 242 */         step++;
/* 243 */       }
/* 244 */       // Didn't find it
/* 245 */       return null;
/* 246 */     }
/* 247 */
/* 248 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, double agg_key6, int agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
/* 249 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 250 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && ((java.lang.Double.isNaN(row.getDouble(6)) && java.lang.Double.isNaN(agg_key6)) || row.getDouble(6) == agg_key6) && (row.getInt(7) == agg_key7) && (row.getUTF8String(8).equals(agg_key8)) && (row.getUTF8String(9).equals(agg_key9));
/* 251 */     }
/* 252 */
/* 253 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, double agg_key6, int agg_key7, UTF8String agg_key8, UTF8String agg_key9) {
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
/* 292 */       int agg_result4 = 0;
/* 293 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 294 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 295 */         int agg_hash5 = agg_bytes4[i];
/* 296 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 297 */       }
/* 298 */
/* 299 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 300 */
/* 301 */       int agg_result5 = 0;
/* 302 */       byte[] agg_bytes5 = agg_key5.getBytes();
/* 303 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 304 */         int agg_hash6 = agg_bytes5[i];
/* 305 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash6 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 306 */       }
/* 307 */
/* 308 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 309 */
/* 310 */       long agg_result6 = Double.doubleToLongBits(agg_key6);
/* 311 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 312 */
/* 313 */       int agg_result7 = agg_key7;
/* 314 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 315 */
/* 316 */       int agg_result8 = 0;
/* 317 */       byte[] agg_bytes6 = agg_key8.getBytes();
/* 318 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 319 */         int agg_hash7 = agg_bytes6[i];
/* 320 */         agg_result8 = (agg_result8 ^ (0x9e3779b9)) + agg_hash7 + (agg_result8 << 6) + (agg_result8 >>> 2);
/* 321 */       }
/* 322 */
/* 323 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result8 + (agg_hash << 6) + (agg_hash >>> 2);
/* 324 */
/* 325 */       int agg_result9 = 0;
/* 326 */       byte[] agg_bytes7 = agg_key9.getBytes();
/* 327 */       for (int i = 0; i < agg_bytes7.length; i++) {
/* 328 */         int agg_hash8 = agg_bytes7[i];
/* 329 */         agg_result9 = (agg_result9 ^ (0x9e3779b9)) + agg_hash8 + (agg_result9 << 6) + (agg_result9 >>> 2);
/* 330 */       }
/* 331 */
/* 332 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result9 + (agg_hash << 6) + (agg_hash >>> 2);
/* 333 */
/* 334 */       return agg_hash;
/* 335 */     }
/* 336 */
/* 337 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 338 */       return batch.rowIterator();
/* 339 */     }
/* 340 */
/* 341 */     public void close() {
/* 342 */       batch.close();
/* 343 */     }
/* 344 */
/* 345 */   }
/* 346 */
/* 347 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 348 */     agg_hashMap = agg_plan.createHashMap();
/* 349 */
/* 350 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 351 */       int smj_size = smj_matches.size();
/* 352 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 353 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 354 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 355 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 356 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 357 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 358 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 359 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 360 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 361 */       smj_value14 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 362 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 363 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 364 */
/* 365 */         smj_numOutputRows.add(1);
/* 366 */
/* 367 */         // generate join key for stream side
/* 368 */
/* 369 */         boolean bhj_isNull = smj_isNull8;
/* 370 */         long bhj_value = -1L;
/* 371 */         if (!smj_isNull8) {
/* 372 */           bhj_value = (long) smj_value12;
/* 373 */         }
/* 374 */         // find matches from HashedRelation
/* 375 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 376 */         if (bhj_matched == null) continue;
/* 377 */
/* 378 */         bhj_numOutputRows.add(1);
/* 379 */
/* 380 */         // generate join key for stream side
/* 381 */
/* 382 */         boolean bhj_isNull14 = smj_isNull6;
/* 383 */         long bhj_value14 = -1L;
/* 384 */         if (!smj_isNull6) {
/* 385 */           bhj_value14 = (long) smj_value10;
/* 386 */         }
/* 387 */         // find matches from HashedRelation
/* 388 */         UnsafeRow bhj_matched1 = bhj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value14);
/* 389 */         if (bhj_matched1 == null) continue;
/* 390 */
/* 391 */         bhj_numOutputRows1.add(1);
/* 392 */
/* 393 */         // generate join key for stream side
/* 394 */
/* 395 */         boolean bhj_isNull34 = smj_isNull7;
/* 396 */         long bhj_value34 = -1L;
/* 397 */         if (!smj_isNull7) {
/* 398 */           bhj_value34 = (long) smj_value11;
/* 399 */         }
/* 400 */         // find matches from HashedRelation
/* 401 */         UnsafeRow bhj_matched2 = bhj_isNull34 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value34);
/* 402 */         if (bhj_matched2 == null) continue;
/* 403 */
/* 404 */         bhj_numOutputRows2.add(1);
/* 405 */
/* 406 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 407 */         UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 408 */         boolean bhj_isNull39 = bhj_matched2.isNullAt(3);
/* 409 */         UTF8String bhj_value39 = bhj_isNull39 ? null : (bhj_matched2.getUTF8String(3));
/* 410 */
/* 411 */         // generate join key for stream side
/* 412 */
/* 413 */         bhj_holder3.reset();
/* 414 */
/* 415 */         bhj_rowWriter3.zeroOutNullBytes();
/* 416 */
/* 417 */         if (bhj_isNull39) {
/* 418 */           bhj_rowWriter3.setNullAt(0);
/* 419 */         } else {
/* 420 */           bhj_rowWriter3.write(0, bhj_value39);
/* 421 */         }
/* 422 */
/* 423 */         if (bhj_isNull5) {
/* 424 */           bhj_rowWriter3.setNullAt(1);
/* 425 */         } else {
/* 426 */           bhj_rowWriter3.write(1, bhj_value5);
/* 427 */         }
/* 428 */         bhj_result3.setTotalSize(bhj_holder3.totalSize());
/* 429 */
/* 430 */         // find matches from HashRelation
/* 431 */         scala.collection.Iterator bhj_matches = bhj_result3.anyNull() ? null : (scala.collection.Iterator)bhj_relation3.get(bhj_result3);
/* 432 */         if (bhj_matches == null) continue;
/* 433 */         while (bhj_matches.hasNext()) {
/* 434 */           UnsafeRow bhj_matched3 = (UnsafeRow) bhj_matches.next();
/* 435 */
/* 436 */           bhj_numOutputRows3.add(1);
/* 437 */
/* 438 */           boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 439 */           UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 440 */           boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 441 */           UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 442 */           boolean bhj_isNull17 = bhj_matched1.isNullAt(1);
/* 443 */           double bhj_value17 = bhj_isNull17 ? -1.0 : (bhj_matched1.getDouble(1));
/* 444 */           boolean bhj_isNull18 = bhj_matched1.isNullAt(2);
/* 445 */           UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched1.getUTF8String(2));
/* 446 */           boolean bhj_isNull19 = bhj_matched1.isNullAt(3);
/* 447 */           UTF8String bhj_value19 = bhj_isNull19 ? null : (bhj_matched1.getUTF8String(3));
/* 448 */           boolean bhj_isNull20 = bhj_matched1.isNullAt(4);
/* 449 */           UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched1.getUTF8String(4));
/* 450 */           boolean bhj_isNull21 = bhj_matched1.isNullAt(5);
/* 451 */           int bhj_value21 = bhj_isNull21 ? -1 : (bhj_matched1.getInt(5));
/* 452 */           boolean bhj_isNull37 = bhj_matched2.isNullAt(1);
/* 453 */           UTF8String bhj_value37 = bhj_isNull37 ? null : (bhj_matched2.getUTF8String(1));
/* 454 */           boolean bhj_isNull38 = bhj_matched2.isNullAt(2);
/* 455 */           UTF8String bhj_value38 = bhj_isNull38 ? null : (bhj_matched2.getUTF8String(2));
/* 456 */           boolean bhj_isNull56 = bhj_matched3.isNullAt(0);
/* 457 */           UTF8String bhj_value56 = bhj_isNull56 ? null : (bhj_matched3.getUTF8String(0));
/* 458 */
/* 459 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 460 */
/* 461 */           UnsafeRow agg_fastAggBuffer = null;
/* 462 */
/* 463 */           if (true) {
/* 464 */             if (!bhj_isNull38 && !bhj_isNull37 && !bhj_isNull3 && !bhj_isNull56 && !bhj_isNull4 && !bhj_isNull19 && !bhj_isNull17 && !bhj_isNull21 && !bhj_isNull20 && !bhj_isNull18) {
/* 465 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 466 */                 bhj_value38, bhj_value37, bhj_value3, bhj_value56, bhj_value4, bhj_value19, bhj_value17, bhj_value21, bhj_value20, bhj_value18);
/* 467 */             }
/* 468 */           }
/* 469 */
/* 470 */           if (agg_fastAggBuffer == null) {
/* 471 */             // generate grouping key
/* 472 */             agg_holder.reset();
/* 473 */
/* 474 */             agg_rowWriter.zeroOutNullBytes();
/* 475 */
/* 476 */             if (bhj_isNull38) {
/* 477 */               agg_rowWriter.setNullAt(0);
/* 478 */             } else {
/* 479 */               agg_rowWriter.write(0, bhj_value38);
/* 480 */             }
/* 481 */
/* 482 */             if (bhj_isNull37) {
/* 483 */               agg_rowWriter.setNullAt(1);
/* 484 */             } else {
/* 485 */               agg_rowWriter.write(1, bhj_value37);
/* 486 */             }
/* 487 */
/* 488 */             if (bhj_isNull3) {
/* 489 */               agg_rowWriter.setNullAt(2);
/* 490 */             } else {
/* 491 */               agg_rowWriter.write(2, bhj_value3);
/* 492 */             }
/* 493 */
/* 494 */             if (bhj_isNull56) {
/* 495 */               agg_rowWriter.setNullAt(3);
/* 496 */             } else {
/* 497 */               agg_rowWriter.write(3, bhj_value56);
/* 498 */             }
/* 499 */
/* 500 */             if (bhj_isNull4) {
/* 501 */               agg_rowWriter.setNullAt(4);
/* 502 */             } else {
/* 503 */               agg_rowWriter.write(4, bhj_value4);
/* 504 */             }
/* 505 */
/* 506 */             if (bhj_isNull19) {
/* 507 */               agg_rowWriter.setNullAt(5);
/* 508 */             } else {
/* 509 */               agg_rowWriter.write(5, bhj_value19);
/* 510 */             }
/* 511 */
/* 512 */             if (bhj_isNull17) {
/* 513 */               agg_rowWriter.setNullAt(6);
/* 514 */             } else {
/* 515 */               agg_rowWriter.write(6, bhj_value17);
/* 516 */             }
/* 517 */
/* 518 */             if (bhj_isNull21) {
/* 519 */               agg_rowWriter.setNullAt(7);
/* 520 */             } else {
/* 521 */               agg_rowWriter.write(7, bhj_value21);
/* 522 */             }
/* 523 */
/* 524 */             if (bhj_isNull20) {
/* 525 */               agg_rowWriter.setNullAt(8);
/* 526 */             } else {
/* 527 */               agg_rowWriter.write(8, bhj_value20);
/* 528 */             }
/* 529 */
/* 530 */             if (bhj_isNull18) {
/* 531 */               agg_rowWriter.setNullAt(9);
/* 532 */             } else {
/* 533 */               agg_rowWriter.write(9, bhj_value18);
/* 534 */             }
/* 535 */             agg_result10.setTotalSize(agg_holder.totalSize());
/* 536 */             agg_value22 = 42;
/* 537 */
/* 538 */             if (!bhj_isNull38) {
/* 539 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value38.getBaseObject(), bhj_value38.getBaseOffset(), bhj_value38.numBytes(), agg_value22);
/* 540 */             }
/* 541 */
/* 542 */             if (!bhj_isNull37) {
/* 543 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value37.getBaseObject(), bhj_value37.getBaseOffset(), bhj_value37.numBytes(), agg_value22);
/* 544 */             }
/* 545 */
/* 546 */             if (!bhj_isNull3) {
/* 547 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value22);
/* 548 */             }
/* 549 */
/* 550 */             if (!bhj_isNull56) {
/* 551 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value56.getBaseObject(), bhj_value56.getBaseOffset(), bhj_value56.numBytes(), agg_value22);
/* 552 */             }
/* 553 */
/* 554 */             if (!bhj_isNull4) {
/* 555 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value4.getBaseObject(), bhj_value4.getBaseOffset(), bhj_value4.numBytes(), agg_value22);
/* 556 */             }
/* 557 */
/* 558 */             if (!bhj_isNull19) {
/* 559 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value19.getBaseObject(), bhj_value19.getBaseOffset(), bhj_value19.numBytes(), agg_value22);
/* 560 */             }
/* 561 */
/* 562 */             if (!bhj_isNull17) {
/* 563 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(bhj_value17), agg_value22);
/* 564 */             }
/* 565 */
/* 566 */             if (!bhj_isNull21) {
/* 567 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value21, agg_value22);
/* 568 */             }
/* 569 */
/* 570 */             if (!bhj_isNull20) {
/* 571 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value20.getBaseObject(), bhj_value20.getBaseOffset(), bhj_value20.numBytes(), agg_value22);
/* 572 */             }
/* 573 */
/* 574 */             if (!bhj_isNull18) {
/* 575 */               agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value18.getBaseObject(), bhj_value18.getBaseOffset(), bhj_value18.numBytes(), agg_value22);
/* 576 */             }
/* 577 */             if (true) {
/* 578 */               // try to get the buffer from hash map
/* 579 */               agg_unsafeRowAggBuffer =
/* 580 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result10, agg_value22);
/* 581 */             }
/* 582 */             if (agg_unsafeRowAggBuffer == null) {
/* 583 */               if (agg_sorter == null) {
/* 584 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 585 */               } else {
/* 586 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 587 */               }
/* 588 */
/* 589 */               // the hash map had be spilled, it should have enough memory now,
/* 590 */               // try  to allocate buffer again.
/* 591 */               agg_unsafeRowAggBuffer =
/* 592 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result10, agg_value22);
/* 593 */               if (agg_unsafeRowAggBuffer == null) {
/* 594 */                 // failed to allocate the first page
/* 595 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 596 */               }
/* 597 */             }
/* 598 */           }
/* 599 */
/* 600 */           if (agg_fastAggBuffer != null) {
/* 601 */             // update fast row
/* 602 */
/* 603 */             // common sub-expressions
/* 604 */
/* 605 */             // evaluate aggregate function
/* 606 */             boolean agg_isNull42 = true;
/* 607 */             double agg_value43 = -1.0;
/* 608 */
/* 609 */             boolean agg_isNull44 = agg_fastAggBuffer.isNullAt(0);
/* 610 */             double agg_value45 = agg_isNull44 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 611 */             boolean agg_isNull43 = agg_isNull44;
/* 612 */             double agg_value44 = agg_value45;
/* 613 */             if (agg_isNull43) {
/* 614 */               boolean agg_isNull45 = false;
/* 615 */               double agg_value46 = -1.0;
/* 616 */               if (!false) {
/* 617 */                 agg_value46 = (double) 0;
/* 618 */               }
/* 619 */               if (!agg_isNull45) {
/* 620 */                 agg_isNull43 = false;
/* 621 */                 agg_value44 = agg_value46;
/* 622 */               }
/* 623 */             }
/* 624 */
/* 625 */             boolean agg_isNull47 = smj_isNull10;
/* 626 */             double agg_value48 = -1.0;
/* 627 */             if (!smj_isNull10) {
/* 628 */               agg_value48 = smj_value14;
/* 629 */             }
/* 630 */             if (!agg_isNull47) {
/* 631 */               agg_isNull42 = false; // resultCode could change nullability.
/* 632 */               agg_value43 = agg_value44 + agg_value48;
/* 633 */
/* 634 */             }
/* 635 */             boolean agg_isNull41 = agg_isNull42;
/* 636 */             double agg_value42 = agg_value43;
/* 637 */             if (agg_isNull41) {
/* 638 */               boolean agg_isNull49 = agg_fastAggBuffer.isNullAt(0);
/* 639 */               double agg_value50 = agg_isNull49 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 640 */               if (!agg_isNull49) {
/* 641 */                 agg_isNull41 = false;
/* 642 */                 agg_value42 = agg_value50;
/* 643 */               }
/* 644 */             }
/* 645 */             // update fast row
/* 646 */             if (!agg_isNull41) {
/* 647 */               agg_fastAggBuffer.setDouble(0, agg_value42);
/* 648 */             } else {
/* 649 */               agg_fastAggBuffer.setNullAt(0);
/* 650 */             }
/* 651 */
/* 652 */           } else {
/* 653 */             // update unsafe row
/* 654 */
/* 655 */             // common sub-expressions
/* 656 */
/* 657 */             // evaluate aggregate function
/* 658 */             boolean agg_isNull33 = true;
/* 659 */             double agg_value34 = -1.0;
/* 660 */
/* 661 */             boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 662 */             double agg_value36 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 663 */             boolean agg_isNull34 = agg_isNull35;
/* 664 */             double agg_value35 = agg_value36;
/* 665 */             if (agg_isNull34) {
/* 666 */               boolean agg_isNull36 = false;
/* 667 */               double agg_value37 = -1.0;
/* 668 */               if (!false) {
/* 669 */                 agg_value37 = (double) 0;
/* 670 */               }
/* 671 */               if (!agg_isNull36) {
/* 672 */                 agg_isNull34 = false;
/* 673 */                 agg_value35 = agg_value37;
/* 674 */               }
/* 675 */             }
/* 676 */
/* 677 */             boolean agg_isNull38 = smj_isNull10;
/* 678 */             double agg_value39 = -1.0;
/* 679 */             if (!smj_isNull10) {
/* 680 */               agg_value39 = smj_value14;
/* 681 */             }
/* 682 */             if (!agg_isNull38) {
/* 683 */               agg_isNull33 = false; // resultCode could change nullability.
/* 684 */               agg_value34 = agg_value35 + agg_value39;
/* 685 */
/* 686 */             }
/* 687 */             boolean agg_isNull32 = agg_isNull33;
/* 688 */             double agg_value33 = agg_value34;
/* 689 */             if (agg_isNull32) {
/* 690 */               boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 691 */               double agg_value41 = agg_isNull40 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 692 */               if (!agg_isNull40) {
/* 693 */                 agg_isNull32 = false;
/* 694 */                 agg_value33 = agg_value41;
/* 695 */               }
/* 696 */             }
/* 697 */             // update unsafe row buffer
/* 698 */             if (!agg_isNull32) {
/* 699 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value33);
/* 700 */             } else {
/* 701 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 702 */             }
/* 703 */
/* 704 */           }
/* 705 */
/* 706 */         }
/* 707 */
/* 708 */       }
/* 709 */       if (shouldStop()) return;
/* 710 */     }
/* 711 */
/* 712 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 713 */
/* 714 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 715 */   }
/* 716 */
/* 717 */   private boolean findNextInnerJoinRows(
/* 718 */     scala.collection.Iterator leftIter,
/* 719 */     scala.collection.Iterator rightIter) {
/* 720 */     smj_leftRow = null;
/* 721 */     int comp = 0;
/* 722 */     while (smj_leftRow == null) {
/* 723 */       if (!leftIter.hasNext()) return false;
/* 724 */       smj_leftRow = (InternalRow) leftIter.next();
/* 725 */
/* 726 */       boolean smj_isNull1 = smj_leftRow.isNullAt(3);
/* 727 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(3));
/* 728 */       boolean smj_isNull = smj_isNull1;
/* 729 */       long smj_value = -1L;
/* 730 */       if (!smj_isNull1) {
/* 731 */         smj_value = (long) smj_value1;
/* 732 */       }
/* 733 */
/* 734 */       boolean smj_isNull3 = smj_leftRow.isNullAt(0);
/* 735 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(0));
/* 736 */       boolean smj_isNull2 = smj_isNull3;
/* 737 */       long smj_value2 = -1L;
/* 738 */       if (!smj_isNull3) {
/* 739 */         smj_value2 = (long) smj_value3;
/* 740 */       }
/* 741 */       if (smj_isNull || smj_isNull2) {
/* 742 */         smj_leftRow = null;
/* 743 */         continue;
/* 744 */       }
/* 745 */       if (!smj_matches.isEmpty()) {
/* 746 */         comp = 0;
/* 747 */         if (comp == 0) {
/* 748 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 749 */         }
/* 750 */         if (comp == 0) {
/* 751 */           comp = (smj_value2 > smj_value9 ? 1 : smj_value2 < smj_value9 ? -1 : 0);
/* 752 */         }
/* 753 */
/* 754 */         if (comp == 0) {
/* 755 */           return true;
/* 756 */         }
/* 757 */         smj_matches.clear();
/* 758 */       }
/* 759 */
/* 760 */       do {
/* 761 */         if (smj_rightRow == null) {
/* 762 */           if (!rightIter.hasNext()) {
/* 763 */             smj_value8 = smj_value;
/* 764 */             smj_value9 = smj_value2;
/* 765 */             return !smj_matches.isEmpty();
/* 766 */           }
/* 767 */           smj_rightRow = (InternalRow) rightIter.next();
/* 768 */
/* 769 */           boolean smj_isNull4 = smj_rightRow.isNullAt(1);
/* 770 */           long smj_value4 = smj_isNull4 ? -1L : (smj_rightRow.getLong(1));
/* 771 */
/* 772 */           boolean smj_isNull5 = smj_rightRow.isNullAt(0);
/* 773 */           long smj_value5 = smj_isNull5 ? -1L : (smj_rightRow.getLong(0));
/* 774 */           if (smj_isNull4 || smj_isNull5) {
/* 775 */             smj_rightRow = null;
/* 776 */             continue;
/* 777 */           }
/* 778 */           smj_value6 = smj_value4;
/* 779 */           smj_value7 = smj_value5;
/* 780 */         }
/* 781 */
/* 782 */         comp = 0;
/* 783 */         if (comp == 0) {
/* 784 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 785 */         }
/* 786 */         if (comp == 0) {
/* 787 */           comp = (smj_value2 > smj_value7 ? 1 : smj_value2 < smj_value7 ? -1 : 0);
/* 788 */         }
/* 789 */
/* 790 */         if (comp > 0) {
/* 791 */           smj_rightRow = null;
/* 792 */         } else if (comp < 0) {
/* 793 */           if (!smj_matches.isEmpty()) {
/* 794 */             smj_value8 = smj_value;
/* 795 */             smj_value9 = smj_value2;
/* 796 */             return true;
/* 797 */           }
/* 798 */           smj_leftRow = null;
/* 799 */         } else {
/* 800 */           smj_matches.add(smj_rightRow.copy());
/* 801 */           smj_rightRow = null;;
/* 802 */         }
/* 803 */       } while (smj_leftRow != null);
/* 804 */     }
/* 805 */     return false; // unreachable
/* 806 */   }
/* 807 */
/* 808 */   private void wholestagecodegen_init_2() {
/* 809 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 810 */     bhj_result1 = new UnsafeRow(12);
/* 811 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 192);
/* 812 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 12);
/* 813 */     project_result2 = new UnsafeRow(10);
/* 814 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 192);
/* 815 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 10);
/* 816 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 817 */
/* 818 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 819 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 820 */
/* 821 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 822 */     bhj_result2 = new UnsafeRow(14);
/* 823 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 288);
/* 824 */
/* 825 */   }
/* 826 */
/* 827 */   private void wholestagecodegen_init_1() {
/* 828 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[4];
/* 829 */
/* 830 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 831 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 832 */
/* 833 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 834 */     bhj_result = new UnsafeRow(8);
/* 835 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 836 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 837 */     project_result1 = new UnsafeRow(6);
/* 838 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 839 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 840 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 841 */
/* 842 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 843 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 844 */
/* 845 */   }
/* 846 */
/* 847 */   private void wholestagecodegen_init_4() {
/* 848 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 15);
/* 849 */     project_result4 = new UnsafeRow(11);
/* 850 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 256);
/* 851 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 11);
/* 852 */     agg_result10 = new UnsafeRow(10);
/* 853 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result10, 256);
/* 854 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 10);
/* 855 */
/* 856 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 857 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 858 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 859 */
/* 860 */   }
/* 861 */
/* 862 */   protected void processNext() throws java.io.IOException {
/* 863 */     if (!agg_initAgg) {
/* 864 */       agg_initAgg = true;
/* 865 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 866 */       agg_doAggregateWithKeys();
/* 867 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 868 */     }
/* 869 */
/* 870 */     // output the result
/* 871 */
/* 872 */     while (agg_fastHashMapIter.next()) {
/* 873 */       wholestagecodegen_numOutputRows.add(1);
/* 874 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 875 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 876 */
/* 877 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 878 */
/* 879 */       append(agg_resultRow.copy());
/* 880 */
/* 881 */       if (shouldStop()) return;
/* 882 */     }
/* 883 */     agg_fastHashMap.close();
/* 884 */
/* 885 */     while (agg_mapIter.next()) {
/* 886 */       wholestagecodegen_numOutputRows.add(1);
/* 887 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 888 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 889 */
/* 890 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 891 */
/* 892 */       append(agg_resultRow.copy());
/* 893 */
/* 894 */       if (shouldStop()) return;
/* 895 */     }
/* 896 */
/* 897 */     agg_mapIter.close();
/* 898 */     if (agg_sorter == null) {
/* 899 */       agg_hashMap.free();
/* 900 */     }
/* 901 */   }
/* 902 */ }
