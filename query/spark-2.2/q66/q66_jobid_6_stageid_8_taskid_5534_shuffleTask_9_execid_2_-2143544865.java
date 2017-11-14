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
/* 057 */   private boolean agg_bufIsNull24;
/* 058 */   private double agg_bufValue24;
/* 059 */   private boolean agg_bufIsNull25;
/* 060 */   private double agg_bufValue25;
/* 061 */   private boolean agg_bufIsNull26;
/* 062 */   private double agg_bufValue26;
/* 063 */   private boolean agg_bufIsNull27;
/* 064 */   private double agg_bufValue27;
/* 065 */   private boolean agg_bufIsNull28;
/* 066 */   private double agg_bufValue28;
/* 067 */   private boolean agg_bufIsNull29;
/* 068 */   private double agg_bufValue29;
/* 069 */   private boolean agg_bufIsNull30;
/* 070 */   private double agg_bufValue30;
/* 071 */   private boolean agg_bufIsNull31;
/* 072 */   private double agg_bufValue31;
/* 073 */   private boolean agg_bufIsNull32;
/* 074 */   private double agg_bufValue32;
/* 075 */   private boolean agg_bufIsNull33;
/* 076 */   private double agg_bufValue33;
/* 077 */   private boolean agg_bufIsNull34;
/* 078 */   private double agg_bufValue34;
/* 079 */   private boolean agg_bufIsNull35;
/* 080 */   private double agg_bufValue35;
/* 081 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 082 */   private agg_FastHashMap agg_fastHashMap;
/* 083 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 084 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 085 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 086 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 087 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 088 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 089 */   private scala.collection.Iterator inputadapter_input;
/* 090 */   private UnsafeRow agg_result8;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 093 */   private int agg_value88;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 095 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 096 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 097 */
/* 098 */   public GeneratedIterator(Object[] references) {
/* 099 */     this.references = references;
/* 100 */   }
/* 101 */
/* 102 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 103 */     partitionIndex = index;
/* 104 */     this.inputs = inputs;
/* 105 */     agg_initAgg = false;
/* 106 */
/* 107 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 108 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 109 */
/* 110 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 111 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 112 */     inputadapter_input = inputs[0];
/* 113 */     agg_result8 = new UnsafeRow(8);
/* 114 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 192);
/* 115 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 116 */
/* 117 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 118 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[47];
/* 119 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[48];
/* 120 */
/* 121 */   }
/* 122 */
/* 123 */   public class agg_FastHashMap {
/* 124 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 125 */     private int[] buckets;
/* 126 */     private int capacity = 1 << 16;
/* 127 */     private double loadFactor = 0.5;
/* 128 */     private int numBuckets = (int) (capacity / loadFactor);
/* 129 */     private int maxSteps = 2;
/* 130 */     private int numRows = 0;
/* 131 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 132 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 133 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 134 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 135 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 136 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.StringType)
/* 137 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.StringType)
/* 138 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 139 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 140 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 141 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 142 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 143 */     .add("((java.lang.String) references[15])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 144 */     .add("((java.lang.String) references[16])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 145 */     .add("((java.lang.String) references[17])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 146 */     .add("((java.lang.String) references[18])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 147 */     .add("((java.lang.String) references[19])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 148 */     .add("((java.lang.String) references[20])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 149 */     .add("((java.lang.String) references[21])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 150 */     .add("((java.lang.String) references[22])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 151 */     .add("((java.lang.String) references[23])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 152 */     .add("((java.lang.String) references[24])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 153 */     .add("((java.lang.String) references[25])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 154 */     .add("((java.lang.String) references[26])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 155 */     .add("((java.lang.String) references[27])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 156 */     .add("((java.lang.String) references[28])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 157 */     .add("((java.lang.String) references[29])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 158 */     .add("((java.lang.String) references[30])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 159 */     .add("((java.lang.String) references[31])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 160 */     .add("((java.lang.String) references[32])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 161 */     .add("((java.lang.String) references[33])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 162 */     .add("((java.lang.String) references[34])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 163 */     .add("((java.lang.String) references[35])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 164 */     .add("((java.lang.String) references[36])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 165 */     .add("((java.lang.String) references[37])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 166 */     .add("((java.lang.String) references[38])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 167 */     .add("((java.lang.String) references[39])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 168 */     .add("((java.lang.String) references[40])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 169 */     .add("((java.lang.String) references[41])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 170 */     .add("((java.lang.String) references[42])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 171 */     .add("((java.lang.String) references[43])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 172 */     .add("((java.lang.String) references[44])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 173 */     .add("((java.lang.String) references[45])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 174 */     .add("((java.lang.String) references[46])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 175 */     private Object emptyVBase;
/* 176 */     private long emptyVOff;
/* 177 */     private int emptyVLen;
/* 178 */     private boolean isBatchFull = false;
/* 179 */
/* 180 */     public agg_FastHashMap(
/* 181 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 182 */       InternalRow emptyAggregationBuffer) {
/* 183 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 184 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 185 */
/* 186 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 187 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 188 */
/* 189 */       emptyVBase = emptyBuffer;
/* 190 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 191 */       emptyVLen = emptyBuffer.length;
/* 192 */
/* 193 */       buckets = new int[numBuckets];
/* 194 */       java.util.Arrays.fill(buckets, -1);
/* 195 */     }
/* 196 */
/* 197 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 198 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 199 */       int step = 0;
/* 200 */       int idx = (int) h & (numBuckets - 1);
/* 201 */       while (step < maxSteps) {
/* 202 */         // Return bucket index if it's either an empty slot or already contains the key
/* 203 */         if (buckets[idx] == -1) {
/* 204 */           if (numRows < capacity && !isBatchFull) {
/* 205 */             // creating the unsafe for new entry
/* 206 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 207 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 208 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 209 */               192);
/* 210 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 211 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 212 */               agg_holder,
/* 213 */               8);
/* 214 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 215 */             agg_rowWriter.zeroOutNullBytes();
/* 216 */             agg_rowWriter.write(0, agg_key);
/* 217 */             agg_rowWriter.write(1, agg_key1);
/* 218 */             agg_rowWriter.write(2, agg_key2);
/* 219 */             agg_rowWriter.write(3, agg_key3);
/* 220 */             agg_rowWriter.write(4, agg_key4);
/* 221 */             agg_rowWriter.write(5, agg_key5);
/* 222 */             agg_rowWriter.write(6, agg_key6);
/* 223 */             agg_rowWriter.write(7, agg_key7);
/* 224 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 225 */             Object kbase = agg_result.getBaseObject();
/* 226 */             long koff = agg_result.getBaseOffset();
/* 227 */             int klen = agg_result.getSizeInBytes();
/* 228 */
/* 229 */             UnsafeRow vRow
/* 230 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 231 */             if (vRow == null) {
/* 232 */               isBatchFull = true;
/* 233 */             } else {
/* 234 */               buckets[idx] = numRows++;
/* 235 */             }
/* 236 */             return vRow;
/* 237 */           } else {
/* 238 */             // No more space
/* 239 */             return null;
/* 240 */           }
/* 241 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 242 */           return batch.getValueRow(buckets[idx]);
/* 243 */         }
/* 244 */         idx = (idx + 1) & (numBuckets - 1);
/* 245 */         step++;
/* 246 */       }
/* 247 */       // Didn't find it
/* 248 */       return null;
/* 249 */     }
/* 250 */
/* 251 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 252 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 253 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getInt(7) == agg_key7);
/* 254 */     }
/* 255 */
/* 256 */     private long hash(UTF8String agg_key, int agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 257 */       long agg_hash = 0;
/* 258 */
/* 259 */       int agg_result = 0;
/* 260 */       byte[] agg_bytes = agg_key.getBytes();
/* 261 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 262 */         int agg_hash1 = agg_bytes[i];
/* 263 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 264 */       }
/* 265 */
/* 266 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 267 */
/* 268 */       int agg_result1 = agg_key1;
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       int agg_result2 = 0;
/* 272 */       byte[] agg_bytes1 = agg_key2.getBytes();
/* 273 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 274 */         int agg_hash2 = agg_bytes1[i];
/* 275 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash2 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 276 */       }
/* 277 */
/* 278 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 279 */
/* 280 */       int agg_result3 = 0;
/* 281 */       byte[] agg_bytes2 = agg_key3.getBytes();
/* 282 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 283 */         int agg_hash3 = agg_bytes2[i];
/* 284 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash3 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 285 */       }
/* 286 */
/* 287 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 288 */
/* 289 */       int agg_result4 = 0;
/* 290 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 291 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 292 */         int agg_hash4 = agg_bytes3[i];
/* 293 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 294 */       }
/* 295 */
/* 296 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 297 */
/* 298 */       int agg_result5 = 0;
/* 299 */       byte[] agg_bytes4 = agg_key5.getBytes();
/* 300 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 301 */         int agg_hash5 = agg_bytes4[i];
/* 302 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash5 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 303 */       }
/* 304 */
/* 305 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 306 */
/* 307 */       int agg_result6 = 0;
/* 308 */       byte[] agg_bytes5 = agg_key6.getBytes();
/* 309 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 310 */         int agg_hash6 = agg_bytes5[i];
/* 311 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash6 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 312 */       }
/* 313 */
/* 314 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 315 */
/* 316 */       int agg_result7 = agg_key7;
/* 317 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 318 */
/* 319 */       return agg_hash;
/* 320 */     }
/* 321 */
/* 322 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 323 */       return batch.rowIterator();
/* 324 */     }
/* 325 */
/* 326 */     public void close() {
/* 327 */       batch.close();
/* 328 */     }
/* 329 */
/* 330 */   }
/* 331 */
/* 332 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 333 */     agg_hashMap = agg_plan.createHashMap();
/* 334 */
/* 335 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 336 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 337 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 338 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 339 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 340 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 341 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 342 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 343 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 344 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 345 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 346 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 347 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 348 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 349 */       UTF8String inputadapter_value6 = inputadapter_row.getUTF8String(6);
/* 350 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 351 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 352 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 353 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 354 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 355 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 356 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 357 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 358 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 359 */       double inputadapter_value11 = inputadapter_isNull11 ? -1.0 : (inputadapter_row.getDouble(11));
/* 360 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 361 */       double inputadapter_value12 = inputadapter_isNull12 ? -1.0 : (inputadapter_row.getDouble(12));
/* 362 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 363 */       double inputadapter_value13 = inputadapter_isNull13 ? -1.0 : (inputadapter_row.getDouble(13));
/* 364 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 365 */       double inputadapter_value14 = inputadapter_isNull14 ? -1.0 : (inputadapter_row.getDouble(14));
/* 366 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 367 */       double inputadapter_value15 = inputadapter_isNull15 ? -1.0 : (inputadapter_row.getDouble(15));
/* 368 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 369 */       double inputadapter_value16 = inputadapter_isNull16 ? -1.0 : (inputadapter_row.getDouble(16));
/* 370 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 371 */       double inputadapter_value17 = inputadapter_isNull17 ? -1.0 : (inputadapter_row.getDouble(17));
/* 372 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 373 */       double inputadapter_value18 = inputadapter_isNull18 ? -1.0 : (inputadapter_row.getDouble(18));
/* 374 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 375 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 376 */       boolean inputadapter_isNull20 = inputadapter_row.isNullAt(20);
/* 377 */       double inputadapter_value20 = inputadapter_isNull20 ? -1.0 : (inputadapter_row.getDouble(20));
/* 378 */       boolean inputadapter_isNull21 = inputadapter_row.isNullAt(21);
/* 379 */       double inputadapter_value21 = inputadapter_isNull21 ? -1.0 : (inputadapter_row.getDouble(21));
/* 380 */       boolean inputadapter_isNull22 = inputadapter_row.isNullAt(22);
/* 381 */       double inputadapter_value22 = inputadapter_isNull22 ? -1.0 : (inputadapter_row.getDouble(22));
/* 382 */       boolean inputadapter_isNull23 = inputadapter_row.isNullAt(23);
/* 383 */       double inputadapter_value23 = inputadapter_isNull23 ? -1.0 : (inputadapter_row.getDouble(23));
/* 384 */       boolean inputadapter_isNull24 = inputadapter_row.isNullAt(24);
/* 385 */       double inputadapter_value24 = inputadapter_isNull24 ? -1.0 : (inputadapter_row.getDouble(24));
/* 386 */       boolean inputadapter_isNull25 = inputadapter_row.isNullAt(25);
/* 387 */       double inputadapter_value25 = inputadapter_isNull25 ? -1.0 : (inputadapter_row.getDouble(25));
/* 388 */       boolean inputadapter_isNull26 = inputadapter_row.isNullAt(26);
/* 389 */       double inputadapter_value26 = inputadapter_isNull26 ? -1.0 : (inputadapter_row.getDouble(26));
/* 390 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 391 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 392 */       boolean inputadapter_isNull28 = inputadapter_row.isNullAt(28);
/* 393 */       double inputadapter_value28 = inputadapter_isNull28 ? -1.0 : (inputadapter_row.getDouble(28));
/* 394 */       boolean inputadapter_isNull29 = inputadapter_row.isNullAt(29);
/* 395 */       double inputadapter_value29 = inputadapter_isNull29 ? -1.0 : (inputadapter_row.getDouble(29));
/* 396 */       boolean inputadapter_isNull30 = inputadapter_row.isNullAt(30);
/* 397 */       double inputadapter_value30 = inputadapter_isNull30 ? -1.0 : (inputadapter_row.getDouble(30));
/* 398 */       boolean inputadapter_isNull31 = inputadapter_row.isNullAt(31);
/* 399 */       double inputadapter_value31 = inputadapter_isNull31 ? -1.0 : (inputadapter_row.getDouble(31));
/* 400 */
/* 401 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 402 */
/* 403 */       UnsafeRow agg_fastAggBuffer = null;
/* 404 */
/* 405 */       if (true) {
/* 406 */         if (!inputadapter_isNull && !inputadapter_isNull1 && !inputadapter_isNull2 && !inputadapter_isNull3 && !inputadapter_isNull4 && !inputadapter_isNull5 && !false && !inputadapter_isNull7) {
/* 407 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 408 */             inputadapter_value, inputadapter_value1, inputadapter_value2, inputadapter_value3, inputadapter_value4, inputadapter_value5, inputadapter_value6, inputadapter_value7);
/* 409 */         }
/* 410 */       }
/* 411 */
/* 412 */       if (agg_fastAggBuffer == null) {
/* 413 */         // generate grouping key
/* 414 */         agg_holder.reset();
/* 415 */
/* 416 */         agg_rowWriter.zeroOutNullBytes();
/* 417 */
/* 418 */         if (inputadapter_isNull) {
/* 419 */           agg_rowWriter.setNullAt(0);
/* 420 */         } else {
/* 421 */           agg_rowWriter.write(0, inputadapter_value);
/* 422 */         }
/* 423 */
/* 424 */         if (inputadapter_isNull1) {
/* 425 */           agg_rowWriter.setNullAt(1);
/* 426 */         } else {
/* 427 */           agg_rowWriter.write(1, inputadapter_value1);
/* 428 */         }
/* 429 */
/* 430 */         if (inputadapter_isNull2) {
/* 431 */           agg_rowWriter.setNullAt(2);
/* 432 */         } else {
/* 433 */           agg_rowWriter.write(2, inputadapter_value2);
/* 434 */         }
/* 435 */
/* 436 */         if (inputadapter_isNull3) {
/* 437 */           agg_rowWriter.setNullAt(3);
/* 438 */         } else {
/* 439 */           agg_rowWriter.write(3, inputadapter_value3);
/* 440 */         }
/* 441 */
/* 442 */         if (inputadapter_isNull4) {
/* 443 */           agg_rowWriter.setNullAt(4);
/* 444 */         } else {
/* 445 */           agg_rowWriter.write(4, inputadapter_value4);
/* 446 */         }
/* 447 */
/* 448 */         if (inputadapter_isNull5) {
/* 449 */           agg_rowWriter.setNullAt(5);
/* 450 */         } else {
/* 451 */           agg_rowWriter.write(5, inputadapter_value5);
/* 452 */         }
/* 453 */
/* 454 */         agg_rowWriter.write(6, inputadapter_value6);
/* 455 */
/* 456 */         if (inputadapter_isNull7) {
/* 457 */           agg_rowWriter.setNullAt(7);
/* 458 */         } else {
/* 459 */           agg_rowWriter.write(7, inputadapter_value7);
/* 460 */         }
/* 461 */         agg_result8.setTotalSize(agg_holder.totalSize());
/* 462 */         agg_value88 = 42;
/* 463 */
/* 464 */         if (!inputadapter_isNull) {
/* 465 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value88);
/* 466 */         }
/* 467 */
/* 468 */         if (!inputadapter_isNull1) {
/* 469 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value88);
/* 470 */         }
/* 471 */
/* 472 */         if (!inputadapter_isNull2) {
/* 473 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value88);
/* 474 */         }
/* 475 */
/* 476 */         if (!inputadapter_isNull3) {
/* 477 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value88);
/* 478 */         }
/* 479 */
/* 480 */         if (!inputadapter_isNull4) {
/* 481 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value88);
/* 482 */         }
/* 483 */
/* 484 */         if (!inputadapter_isNull5) {
/* 485 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value88);
/* 486 */         }
/* 487 */
/* 488 */         agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value88);
/* 489 */
/* 490 */         if (!inputadapter_isNull7) {
/* 491 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value88);
/* 492 */         }
/* 493 */         if (true) {
/* 494 */           // try to get the buffer from hash map
/* 495 */           agg_unsafeRowAggBuffer =
/* 496 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value88);
/* 497 */         }
/* 498 */         if (agg_unsafeRowAggBuffer == null) {
/* 499 */           if (agg_sorter == null) {
/* 500 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 501 */           } else {
/* 502 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 503 */           }
/* 504 */
/* 505 */           // the hash map had be spilled, it should have enough memory now,
/* 506 */           // try  to allocate buffer again.
/* 507 */           agg_unsafeRowAggBuffer =
/* 508 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value88);
/* 509 */           if (agg_unsafeRowAggBuffer == null) {
/* 510 */             // failed to allocate the first page
/* 511 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 512 */           }
/* 513 */         }
/* 514 */       }
/* 515 */
/* 516 */       if (agg_fastAggBuffer != null) {
/* 517 */         // update fast row
/* 518 */
/* 519 */         // common sub-expressions
/* 520 */         boolean agg_isNull363 = inputadapter_isNull1;
/* 521 */         double agg_value399 = -1.0;
/* 522 */         if (!inputadapter_isNull1) {
/* 523 */           agg_value399 = (double) inputadapter_value1;
/* 524 */         }
/* 525 */         // evaluate aggregate function
/* 526 */         boolean agg_isNull366 = true;
/* 527 */         double agg_value402 = -1.0;
/* 528 */
/* 529 */         boolean agg_isNull368 = agg_fastAggBuffer.isNullAt(0);
/* 530 */         double agg_value404 = agg_isNull368 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 531 */         boolean agg_isNull367 = agg_isNull368;
/* 532 */         double agg_value403 = agg_value404;
/* 533 */         if (agg_isNull367) {
/* 534 */           boolean agg_isNull369 = false;
/* 535 */           double agg_value405 = -1.0;
/* 536 */           if (!false) {
/* 537 */             agg_value405 = (double) 0;
/* 538 */           }
/* 539 */           if (!agg_isNull369) {
/* 540 */             agg_isNull367 = false;
/* 541 */             agg_value403 = agg_value405;
/* 542 */           }
/* 543 */         }
/* 544 */
/* 545 */         if (!inputadapter_isNull8) {
/* 546 */           agg_isNull366 = false; // resultCode could change nullability.
/* 547 */           agg_value402 = agg_value403 + inputadapter_value8;
/* 548 */
/* 549 */         }
/* 550 */         boolean agg_isNull365 = agg_isNull366;
/* 551 */         double agg_value401 = agg_value402;
/* 552 */         if (agg_isNull365) {
/* 553 */           boolean agg_isNull372 = agg_fastAggBuffer.isNullAt(0);
/* 554 */           double agg_value408 = agg_isNull372 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 555 */           if (!agg_isNull372) {
/* 556 */             agg_isNull365 = false;
/* 557 */             agg_value401 = agg_value408;
/* 558 */           }
/* 559 */         }
/* 560 */         boolean agg_isNull374 = true;
/* 561 */         double agg_value410 = -1.0;
/* 562 */
/* 563 */         boolean agg_isNull376 = agg_fastAggBuffer.isNullAt(1);
/* 564 */         double agg_value412 = agg_isNull376 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 565 */         boolean agg_isNull375 = agg_isNull376;
/* 566 */         double agg_value411 = agg_value412;
/* 567 */         if (agg_isNull375) {
/* 568 */           boolean agg_isNull377 = false;
/* 569 */           double agg_value413 = -1.0;
/* 570 */           if (!false) {
/* 571 */             agg_value413 = (double) 0;
/* 572 */           }
/* 573 */           if (!agg_isNull377) {
/* 574 */             agg_isNull375 = false;
/* 575 */             agg_value411 = agg_value413;
/* 576 */           }
/* 577 */         }
/* 578 */
/* 579 */         if (!inputadapter_isNull9) {
/* 580 */           agg_isNull374 = false; // resultCode could change nullability.
/* 581 */           agg_value410 = agg_value411 + inputadapter_value9;
/* 582 */
/* 583 */         }
/* 584 */         boolean agg_isNull373 = agg_isNull374;
/* 585 */         double agg_value409 = agg_value410;
/* 586 */         if (agg_isNull373) {
/* 587 */           boolean agg_isNull380 = agg_fastAggBuffer.isNullAt(1);
/* 588 */           double agg_value416 = agg_isNull380 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 589 */           if (!agg_isNull380) {
/* 590 */             agg_isNull373 = false;
/* 591 */             agg_value409 = agg_value416;
/* 592 */           }
/* 593 */         }
/* 594 */         boolean agg_isNull382 = true;
/* 595 */         double agg_value418 = -1.0;
/* 596 */
/* 597 */         boolean agg_isNull384 = agg_fastAggBuffer.isNullAt(2);
/* 598 */         double agg_value420 = agg_isNull384 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 599 */         boolean agg_isNull383 = agg_isNull384;
/* 600 */         double agg_value419 = agg_value420;
/* 601 */         if (agg_isNull383) {
/* 602 */           boolean agg_isNull385 = false;
/* 603 */           double agg_value421 = -1.0;
/* 604 */           if (!false) {
/* 605 */             agg_value421 = (double) 0;
/* 606 */           }
/* 607 */           if (!agg_isNull385) {
/* 608 */             agg_isNull383 = false;
/* 609 */             agg_value419 = agg_value421;
/* 610 */           }
/* 611 */         }
/* 612 */
/* 613 */         if (!inputadapter_isNull10) {
/* 614 */           agg_isNull382 = false; // resultCode could change nullability.
/* 615 */           agg_value418 = agg_value419 + inputadapter_value10;
/* 616 */
/* 617 */         }
/* 618 */         boolean agg_isNull381 = agg_isNull382;
/* 619 */         double agg_value417 = agg_value418;
/* 620 */         if (agg_isNull381) {
/* 621 */           boolean agg_isNull388 = agg_fastAggBuffer.isNullAt(2);
/* 622 */           double agg_value424 = agg_isNull388 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 623 */           if (!agg_isNull388) {
/* 624 */             agg_isNull381 = false;
/* 625 */             agg_value417 = agg_value424;
/* 626 */           }
/* 627 */         }
/* 628 */         boolean agg_isNull390 = true;
/* 629 */         double agg_value426 = -1.0;
/* 630 */
/* 631 */         boolean agg_isNull392 = agg_fastAggBuffer.isNullAt(3);
/* 632 */         double agg_value428 = agg_isNull392 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 633 */         boolean agg_isNull391 = agg_isNull392;
/* 634 */         double agg_value427 = agg_value428;
/* 635 */         if (agg_isNull391) {
/* 636 */           boolean agg_isNull393 = false;
/* 637 */           double agg_value429 = -1.0;
/* 638 */           if (!false) {
/* 639 */             agg_value429 = (double) 0;
/* 640 */           }
/* 641 */           if (!agg_isNull393) {
/* 642 */             agg_isNull391 = false;
/* 643 */             agg_value427 = agg_value429;
/* 644 */           }
/* 645 */         }
/* 646 */
/* 647 */         if (!inputadapter_isNull11) {
/* 648 */           agg_isNull390 = false; // resultCode could change nullability.
/* 649 */           agg_value426 = agg_value427 + inputadapter_value11;
/* 650 */
/* 651 */         }
/* 652 */         boolean agg_isNull389 = agg_isNull390;
/* 653 */         double agg_value425 = agg_value426;
/* 654 */         if (agg_isNull389) {
/* 655 */           boolean agg_isNull396 = agg_fastAggBuffer.isNullAt(3);
/* 656 */           double agg_value432 = agg_isNull396 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 657 */           if (!agg_isNull396) {
/* 658 */             agg_isNull389 = false;
/* 659 */             agg_value425 = agg_value432;
/* 660 */           }
/* 661 */         }
/* 662 */         boolean agg_isNull398 = true;
/* 663 */         double agg_value434 = -1.0;
/* 664 */
/* 665 */         boolean agg_isNull400 = agg_fastAggBuffer.isNullAt(4);
/* 666 */         double agg_value436 = agg_isNull400 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 667 */         boolean agg_isNull399 = agg_isNull400;
/* 668 */         double agg_value435 = agg_value436;
/* 669 */         if (agg_isNull399) {
/* 670 */           boolean agg_isNull401 = false;
/* 671 */           double agg_value437 = -1.0;
/* 672 */           if (!false) {
/* 673 */             agg_value437 = (double) 0;
/* 674 */           }
/* 675 */           if (!agg_isNull401) {
/* 676 */             agg_isNull399 = false;
/* 677 */             agg_value435 = agg_value437;
/* 678 */           }
/* 679 */         }
/* 680 */
/* 681 */         if (!inputadapter_isNull12) {
/* 682 */           agg_isNull398 = false; // resultCode could change nullability.
/* 683 */           agg_value434 = agg_value435 + inputadapter_value12;
/* 684 */
/* 685 */         }
/* 686 */         boolean agg_isNull397 = agg_isNull398;
/* 687 */         double agg_value433 = agg_value434;
/* 688 */         if (agg_isNull397) {
/* 689 */           boolean agg_isNull404 = agg_fastAggBuffer.isNullAt(4);
/* 690 */           double agg_value440 = agg_isNull404 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 691 */           if (!agg_isNull404) {
/* 692 */             agg_isNull397 = false;
/* 693 */             agg_value433 = agg_value440;
/* 694 */           }
/* 695 */         }
/* 696 */         boolean agg_isNull406 = true;
/* 697 */         double agg_value442 = -1.0;
/* 698 */
/* 699 */         boolean agg_isNull408 = agg_fastAggBuffer.isNullAt(5);
/* 700 */         double agg_value444 = agg_isNull408 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 701 */         boolean agg_isNull407 = agg_isNull408;
/* 702 */         double agg_value443 = agg_value444;
/* 703 */         if (agg_isNull407) {
/* 704 */           boolean agg_isNull409 = false;
/* 705 */           double agg_value445 = -1.0;
/* 706 */           if (!false) {
/* 707 */             agg_value445 = (double) 0;
/* 708 */           }
/* 709 */           if (!agg_isNull409) {
/* 710 */             agg_isNull407 = false;
/* 711 */             agg_value443 = agg_value445;
/* 712 */           }
/* 713 */         }
/* 714 */
/* 715 */         if (!inputadapter_isNull13) {
/* 716 */           agg_isNull406 = false; // resultCode could change nullability.
/* 717 */           agg_value442 = agg_value443 + inputadapter_value13;
/* 718 */
/* 719 */         }
/* 720 */         boolean agg_isNull405 = agg_isNull406;
/* 721 */         double agg_value441 = agg_value442;
/* 722 */         if (agg_isNull405) {
/* 723 */           boolean agg_isNull412 = agg_fastAggBuffer.isNullAt(5);
/* 724 */           double agg_value448 = agg_isNull412 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 725 */           if (!agg_isNull412) {
/* 726 */             agg_isNull405 = false;
/* 727 */             agg_value441 = agg_value448;
/* 728 */           }
/* 729 */         }
/* 730 */         boolean agg_isNull414 = true;
/* 731 */         double agg_value450 = -1.0;
/* 732 */
/* 733 */         boolean agg_isNull416 = agg_fastAggBuffer.isNullAt(6);
/* 734 */         double agg_value452 = agg_isNull416 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 735 */         boolean agg_isNull415 = agg_isNull416;
/* 736 */         double agg_value451 = agg_value452;
/* 737 */         if (agg_isNull415) {
/* 738 */           boolean agg_isNull417 = false;
/* 739 */           double agg_value453 = -1.0;
/* 740 */           if (!false) {
/* 741 */             agg_value453 = (double) 0;
/* 742 */           }
/* 743 */           if (!agg_isNull417) {
/* 744 */             agg_isNull415 = false;
/* 745 */             agg_value451 = agg_value453;
/* 746 */           }
/* 747 */         }
/* 748 */
/* 749 */         if (!inputadapter_isNull14) {
/* 750 */           agg_isNull414 = false; // resultCode could change nullability.
/* 751 */           agg_value450 = agg_value451 + inputadapter_value14;
/* 752 */
/* 753 */         }
/* 754 */         boolean agg_isNull413 = agg_isNull414;
/* 755 */         double agg_value449 = agg_value450;
/* 756 */         if (agg_isNull413) {
/* 757 */           boolean agg_isNull420 = agg_fastAggBuffer.isNullAt(6);
/* 758 */           double agg_value456 = agg_isNull420 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 759 */           if (!agg_isNull420) {
/* 760 */             agg_isNull413 = false;
/* 761 */             agg_value449 = agg_value456;
/* 762 */           }
/* 763 */         }
/* 764 */         boolean agg_isNull422 = true;
/* 765 */         double agg_value458 = -1.0;
/* 766 */
/* 767 */         boolean agg_isNull424 = agg_fastAggBuffer.isNullAt(7);
/* 768 */         double agg_value460 = agg_isNull424 ? -1.0 : (agg_fastAggBuffer.getDouble(7));
/* 769 */         boolean agg_isNull423 = agg_isNull424;
/* 770 */         double agg_value459 = agg_value460;
/* 771 */         if (agg_isNull423) {
/* 772 */           boolean agg_isNull425 = false;
/* 773 */           double agg_value461 = -1.0;
/* 774 */           if (!false) {
/* 775 */             agg_value461 = (double) 0;
/* 776 */           }
/* 777 */           if (!agg_isNull425) {
/* 778 */             agg_isNull423 = false;
/* 779 */             agg_value459 = agg_value461;
/* 780 */           }
/* 781 */         }
/* 782 */
/* 783 */         if (!inputadapter_isNull15) {
/* 784 */           agg_isNull422 = false; // resultCode could change nullability.
/* 785 */           agg_value458 = agg_value459 + inputadapter_value15;
/* 786 */
/* 787 */         }
/* 788 */         boolean agg_isNull421 = agg_isNull422;
/* 789 */         double agg_value457 = agg_value458;
/* 790 */         if (agg_isNull421) {
/* 791 */           boolean agg_isNull428 = agg_fastAggBuffer.isNullAt(7);
/* 792 */           double agg_value464 = agg_isNull428 ? -1.0 : (agg_fastAggBuffer.getDouble(7));
/* 793 */           if (!agg_isNull428) {
/* 794 */             agg_isNull421 = false;
/* 795 */             agg_value457 = agg_value464;
/* 796 */           }
/* 797 */         }
/* 798 */         boolean agg_isNull430 = true;
/* 799 */         double agg_value466 = -1.0;
/* 800 */
/* 801 */         boolean agg_isNull432 = agg_fastAggBuffer.isNullAt(8);
/* 802 */         double agg_value468 = agg_isNull432 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 803 */         boolean agg_isNull431 = agg_isNull432;
/* 804 */         double agg_value467 = agg_value468;
/* 805 */         if (agg_isNull431) {
/* 806 */           boolean agg_isNull433 = false;
/* 807 */           double agg_value469 = -1.0;
/* 808 */           if (!false) {
/* 809 */             agg_value469 = (double) 0;
/* 810 */           }
/* 811 */           if (!agg_isNull433) {
/* 812 */             agg_isNull431 = false;
/* 813 */             agg_value467 = agg_value469;
/* 814 */           }
/* 815 */         }
/* 816 */
/* 817 */         if (!inputadapter_isNull16) {
/* 818 */           agg_isNull430 = false; // resultCode could change nullability.
/* 819 */           agg_value466 = agg_value467 + inputadapter_value16;
/* 820 */
/* 821 */         }
/* 822 */         boolean agg_isNull429 = agg_isNull430;
/* 823 */         double agg_value465 = agg_value466;
/* 824 */         if (agg_isNull429) {
/* 825 */           boolean agg_isNull436 = agg_fastAggBuffer.isNullAt(8);
/* 826 */           double agg_value472 = agg_isNull436 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 827 */           if (!agg_isNull436) {
/* 828 */             agg_isNull429 = false;
/* 829 */             agg_value465 = agg_value472;
/* 830 */           }
/* 831 */         }
/* 832 */         boolean agg_isNull438 = true;
/* 833 */         double agg_value474 = -1.0;
/* 834 */
/* 835 */         boolean agg_isNull440 = agg_fastAggBuffer.isNullAt(9);
/* 836 */         double agg_value476 = agg_isNull440 ? -1.0 : (agg_fastAggBuffer.getDouble(9));
/* 837 */         boolean agg_isNull439 = agg_isNull440;
/* 838 */         double agg_value475 = agg_value476;
/* 839 */         if (agg_isNull439) {
/* 840 */           boolean agg_isNull441 = false;
/* 841 */           double agg_value477 = -1.0;
/* 842 */           if (!false) {
/* 843 */             agg_value477 = (double) 0;
/* 844 */           }
/* 845 */           if (!agg_isNull441) {
/* 846 */             agg_isNull439 = false;
/* 847 */             agg_value475 = agg_value477;
/* 848 */           }
/* 849 */         }
/* 850 */
/* 851 */         if (!inputadapter_isNull17) {
/* 852 */           agg_isNull438 = false; // resultCode could change nullability.
/* 853 */           agg_value474 = agg_value475 + inputadapter_value17;
/* 854 */
/* 855 */         }
/* 856 */         boolean agg_isNull437 = agg_isNull438;
/* 857 */         double agg_value473 = agg_value474;
/* 858 */         if (agg_isNull437) {
/* 859 */           boolean agg_isNull444 = agg_fastAggBuffer.isNullAt(9);
/* 860 */           double agg_value480 = agg_isNull444 ? -1.0 : (agg_fastAggBuffer.getDouble(9));
/* 861 */           if (!agg_isNull444) {
/* 862 */             agg_isNull437 = false;
/* 863 */             agg_value473 = agg_value480;
/* 864 */           }
/* 865 */         }
/* 866 */         boolean agg_isNull446 = true;
/* 867 */         double agg_value482 = -1.0;
/* 868 */
/* 869 */         boolean agg_isNull448 = agg_fastAggBuffer.isNullAt(10);
/* 870 */         double agg_value484 = agg_isNull448 ? -1.0 : (agg_fastAggBuffer.getDouble(10));
/* 871 */         boolean agg_isNull447 = agg_isNull448;
/* 872 */         double agg_value483 = agg_value484;
/* 873 */         if (agg_isNull447) {
/* 874 */           boolean agg_isNull449 = false;
/* 875 */           double agg_value485 = -1.0;
/* 876 */           if (!false) {
/* 877 */             agg_value485 = (double) 0;
/* 878 */           }
/* 879 */           if (!agg_isNull449) {
/* 880 */             agg_isNull447 = false;
/* 881 */             agg_value483 = agg_value485;
/* 882 */           }
/* 883 */         }
/* 884 */
/* 885 */         if (!inputadapter_isNull18) {
/* 886 */           agg_isNull446 = false; // resultCode could change nullability.
/* 887 */           agg_value482 = agg_value483 + inputadapter_value18;
/* 888 */
/* 889 */         }
/* 890 */         boolean agg_isNull445 = agg_isNull446;
/* 891 */         double agg_value481 = agg_value482;
/* 892 */         if (agg_isNull445) {
/* 893 */           boolean agg_isNull452 = agg_fastAggBuffer.isNullAt(10);
/* 894 */           double agg_value488 = agg_isNull452 ? -1.0 : (agg_fastAggBuffer.getDouble(10));
/* 895 */           if (!agg_isNull452) {
/* 896 */             agg_isNull445 = false;
/* 897 */             agg_value481 = agg_value488;
/* 898 */           }
/* 899 */         }
/* 900 */         boolean agg_isNull454 = true;
/* 901 */         double agg_value490 = -1.0;
/* 902 */
/* 903 */         boolean agg_isNull456 = agg_fastAggBuffer.isNullAt(11);
/* 904 */         double agg_value492 = agg_isNull456 ? -1.0 : (agg_fastAggBuffer.getDouble(11));
/* 905 */         boolean agg_isNull455 = agg_isNull456;
/* 906 */         double agg_value491 = agg_value492;
/* 907 */         if (agg_isNull455) {
/* 908 */           boolean agg_isNull457 = false;
/* 909 */           double agg_value493 = -1.0;
/* 910 */           if (!false) {
/* 911 */             agg_value493 = (double) 0;
/* 912 */           }
/* 913 */           if (!agg_isNull457) {
/* 914 */             agg_isNull455 = false;
/* 915 */             agg_value491 = agg_value493;
/* 916 */           }
/* 917 */         }
/* 918 */
/* 919 */         if (!inputadapter_isNull19) {
/* 920 */           agg_isNull454 = false; // resultCode could change nullability.
/* 921 */           agg_value490 = agg_value491 + inputadapter_value19;
/* 922 */
/* 923 */         }
/* 924 */         boolean agg_isNull453 = agg_isNull454;
/* 925 */         double agg_value489 = agg_value490;
/* 926 */         if (agg_isNull453) {
/* 927 */           boolean agg_isNull460 = agg_fastAggBuffer.isNullAt(11);
/* 928 */           double agg_value496 = agg_isNull460 ? -1.0 : (agg_fastAggBuffer.getDouble(11));
/* 929 */           if (!agg_isNull460) {
/* 930 */             agg_isNull453 = false;
/* 931 */             agg_value489 = agg_value496;
/* 932 */           }
/* 933 */         }
/* 934 */         boolean agg_isNull462 = true;
/* 935 */         double agg_value498 = -1.0;
/* 936 */
/* 937 */         boolean agg_isNull464 = agg_fastAggBuffer.isNullAt(12);
/* 938 */         double agg_value500 = agg_isNull464 ? -1.0 : (agg_fastAggBuffer.getDouble(12));
/* 939 */         boolean agg_isNull463 = agg_isNull464;
/* 940 */         double agg_value499 = agg_value500;
/* 941 */         if (agg_isNull463) {
/* 942 */           boolean agg_isNull465 = false;
/* 943 */           double agg_value501 = -1.0;
/* 944 */           if (!false) {
/* 945 */             agg_value501 = (double) 0;
/* 946 */           }
/* 947 */           if (!agg_isNull465) {
/* 948 */             agg_isNull463 = false;
/* 949 */             agg_value499 = agg_value501;
/* 950 */           }
/* 951 */         }
/* 952 */
/* 953 */         boolean agg_isNull467 = false;
/* 954 */         double agg_value503 = -1.0;
/* 955 */         if (agg_isNull363 || agg_value399 == 0) {
/* 956 */           agg_isNull467 = true;
/* 957 */         } else {
/* 958 */           if (inputadapter_isNull8) {
/* 959 */             agg_isNull467 = true;
/* 960 */           } else {
/* 961 */             agg_value503 = (double)(inputadapter_value8 / agg_value399);
/* 962 */           }
/* 963 */         }
/* 964 */         if (!agg_isNull467) {
/* 965 */           agg_isNull462 = false; // resultCode could change nullability.
/* 966 */           agg_value498 = agg_value499 + agg_value503;
/* 967 */
/* 968 */         }
/* 969 */         boolean agg_isNull461 = agg_isNull462;
/* 970 */         double agg_value497 = agg_value498;
/* 971 */         if (agg_isNull461) {
/* 972 */           boolean agg_isNull469 = agg_fastAggBuffer.isNullAt(12);
/* 973 */           double agg_value505 = agg_isNull469 ? -1.0 : (agg_fastAggBuffer.getDouble(12));
/* 974 */           if (!agg_isNull469) {
/* 975 */             agg_isNull461 = false;
/* 976 */             agg_value497 = agg_value505;
/* 977 */           }
/* 978 */         }
/* 979 */         boolean agg_isNull471 = true;
/* 980 */         double agg_value507 = -1.0;
/* 981 */
/* 982 */         boolean agg_isNull473 = agg_fastAggBuffer.isNullAt(13);
/* 983 */         double agg_value509 = agg_isNull473 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 984 */         boolean agg_isNull472 = agg_isNull473;
/* 985 */         double agg_value508 = agg_value509;
/* 986 */         if (agg_isNull472) {
/* 987 */           boolean agg_isNull474 = false;
/* 988 */           double agg_value510 = -1.0;
/* 989 */           if (!false) {
/* 990 */             agg_value510 = (double) 0;
/* 991 */           }
/* 992 */           if (!agg_isNull474) {
/* 993 */             agg_isNull472 = false;
/* 994 */             agg_value508 = agg_value510;
/* 995 */           }
/* 996 */         }
/* 997 */
/* 998 */         boolean agg_isNull476 = false;
/* 999 */         double agg_value512 = -1.0;
/* 1000 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1001 */           agg_isNull476 = true;
/* 1002 */         } else {
/* 1003 */           if (inputadapter_isNull9) {
/* 1004 */             agg_isNull476 = true;
/* 1005 */           } else {
/* 1006 */             agg_value512 = (double)(inputadapter_value9 / agg_value399);
/* 1007 */           }
/* 1008 */         }
/* 1009 */         if (!agg_isNull476) {
/* 1010 */           agg_isNull471 = false; // resultCode could change nullability.
/* 1011 */           agg_value507 = agg_value508 + agg_value512;
/* 1012 */
/* 1013 */         }
/* 1014 */         boolean agg_isNull470 = agg_isNull471;
/* 1015 */         double agg_value506 = agg_value507;
/* 1016 */         if (agg_isNull470) {
/* 1017 */           boolean agg_isNull478 = agg_fastAggBuffer.isNullAt(13);
/* 1018 */           double agg_value514 = agg_isNull478 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 1019 */           if (!agg_isNull478) {
/* 1020 */             agg_isNull470 = false;
/* 1021 */             agg_value506 = agg_value514;
/* 1022 */           }
/* 1023 */         }
/* 1024 */         boolean agg_isNull480 = true;
/* 1025 */         double agg_value516 = -1.0;
/* 1026 */
/* 1027 */         boolean agg_isNull482 = agg_fastAggBuffer.isNullAt(14);
/* 1028 */         double agg_value518 = agg_isNull482 ? -1.0 : (agg_fastAggBuffer.getDouble(14));
/* 1029 */         boolean agg_isNull481 = agg_isNull482;
/* 1030 */         double agg_value517 = agg_value518;
/* 1031 */         if (agg_isNull481) {
/* 1032 */           boolean agg_isNull483 = false;
/* 1033 */           double agg_value519 = -1.0;
/* 1034 */           if (!false) {
/* 1035 */             agg_value519 = (double) 0;
/* 1036 */           }
/* 1037 */           if (!agg_isNull483) {
/* 1038 */             agg_isNull481 = false;
/* 1039 */             agg_value517 = agg_value519;
/* 1040 */           }
/* 1041 */         }
/* 1042 */
/* 1043 */         boolean agg_isNull485 = false;
/* 1044 */         double agg_value521 = -1.0;
/* 1045 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1046 */           agg_isNull485 = true;
/* 1047 */         } else {
/* 1048 */           if (inputadapter_isNull10) {
/* 1049 */             agg_isNull485 = true;
/* 1050 */           } else {
/* 1051 */             agg_value521 = (double)(inputadapter_value10 / agg_value399);
/* 1052 */           }
/* 1053 */         }
/* 1054 */         if (!agg_isNull485) {
/* 1055 */           agg_isNull480 = false; // resultCode could change nullability.
/* 1056 */           agg_value516 = agg_value517 + agg_value521;
/* 1057 */
/* 1058 */         }
/* 1059 */         boolean agg_isNull479 = agg_isNull480;
/* 1060 */         double agg_value515 = agg_value516;
/* 1061 */         if (agg_isNull479) {
/* 1062 */           boolean agg_isNull487 = agg_fastAggBuffer.isNullAt(14);
/* 1063 */           double agg_value523 = agg_isNull487 ? -1.0 : (agg_fastAggBuffer.getDouble(14));
/* 1064 */           if (!agg_isNull487) {
/* 1065 */             agg_isNull479 = false;
/* 1066 */             agg_value515 = agg_value523;
/* 1067 */           }
/* 1068 */         }
/* 1069 */         boolean agg_isNull489 = true;
/* 1070 */         double agg_value525 = -1.0;
/* 1071 */
/* 1072 */         boolean agg_isNull491 = agg_fastAggBuffer.isNullAt(15);
/* 1073 */         double agg_value527 = agg_isNull491 ? -1.0 : (agg_fastAggBuffer.getDouble(15));
/* 1074 */         boolean agg_isNull490 = agg_isNull491;
/* 1075 */         double agg_value526 = agg_value527;
/* 1076 */         if (agg_isNull490) {
/* 1077 */           boolean agg_isNull492 = false;
/* 1078 */           double agg_value528 = -1.0;
/* 1079 */           if (!false) {
/* 1080 */             agg_value528 = (double) 0;
/* 1081 */           }
/* 1082 */           if (!agg_isNull492) {
/* 1083 */             agg_isNull490 = false;
/* 1084 */             agg_value526 = agg_value528;
/* 1085 */           }
/* 1086 */         }
/* 1087 */
/* 1088 */         boolean agg_isNull494 = false;
/* 1089 */         double agg_value530 = -1.0;
/* 1090 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1091 */           agg_isNull494 = true;
/* 1092 */         } else {
/* 1093 */           if (inputadapter_isNull11) {
/* 1094 */             agg_isNull494 = true;
/* 1095 */           } else {
/* 1096 */             agg_value530 = (double)(inputadapter_value11 / agg_value399);
/* 1097 */           }
/* 1098 */         }
/* 1099 */         if (!agg_isNull494) {
/* 1100 */           agg_isNull489 = false; // resultCode could change nullability.
/* 1101 */           agg_value525 = agg_value526 + agg_value530;
/* 1102 */
/* 1103 */         }
/* 1104 */         boolean agg_isNull488 = agg_isNull489;
/* 1105 */         double agg_value524 = agg_value525;
/* 1106 */         if (agg_isNull488) {
/* 1107 */           boolean agg_isNull496 = agg_fastAggBuffer.isNullAt(15);
/* 1108 */           double agg_value532 = agg_isNull496 ? -1.0 : (agg_fastAggBuffer.getDouble(15));
/* 1109 */           if (!agg_isNull496) {
/* 1110 */             agg_isNull488 = false;
/* 1111 */             agg_value524 = agg_value532;
/* 1112 */           }
/* 1113 */         }
/* 1114 */         boolean agg_isNull498 = true;
/* 1115 */         double agg_value534 = -1.0;
/* 1116 */
/* 1117 */         boolean agg_isNull500 = agg_fastAggBuffer.isNullAt(16);
/* 1118 */         double agg_value536 = agg_isNull500 ? -1.0 : (agg_fastAggBuffer.getDouble(16));
/* 1119 */         boolean agg_isNull499 = agg_isNull500;
/* 1120 */         double agg_value535 = agg_value536;
/* 1121 */         if (agg_isNull499) {
/* 1122 */           boolean agg_isNull501 = false;
/* 1123 */           double agg_value537 = -1.0;
/* 1124 */           if (!false) {
/* 1125 */             agg_value537 = (double) 0;
/* 1126 */           }
/* 1127 */           if (!agg_isNull501) {
/* 1128 */             agg_isNull499 = false;
/* 1129 */             agg_value535 = agg_value537;
/* 1130 */           }
/* 1131 */         }
/* 1132 */
/* 1133 */         boolean agg_isNull503 = false;
/* 1134 */         double agg_value539 = -1.0;
/* 1135 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1136 */           agg_isNull503 = true;
/* 1137 */         } else {
/* 1138 */           if (inputadapter_isNull12) {
/* 1139 */             agg_isNull503 = true;
/* 1140 */           } else {
/* 1141 */             agg_value539 = (double)(inputadapter_value12 / agg_value399);
/* 1142 */           }
/* 1143 */         }
/* 1144 */         if (!agg_isNull503) {
/* 1145 */           agg_isNull498 = false; // resultCode could change nullability.
/* 1146 */           agg_value534 = agg_value535 + agg_value539;
/* 1147 */
/* 1148 */         }
/* 1149 */         boolean agg_isNull497 = agg_isNull498;
/* 1150 */         double agg_value533 = agg_value534;
/* 1151 */         if (agg_isNull497) {
/* 1152 */           boolean agg_isNull505 = agg_fastAggBuffer.isNullAt(16);
/* 1153 */           double agg_value541 = agg_isNull505 ? -1.0 : (agg_fastAggBuffer.getDouble(16));
/* 1154 */           if (!agg_isNull505) {
/* 1155 */             agg_isNull497 = false;
/* 1156 */             agg_value533 = agg_value541;
/* 1157 */           }
/* 1158 */         }
/* 1159 */         boolean agg_isNull507 = true;
/* 1160 */         double agg_value543 = -1.0;
/* 1161 */
/* 1162 */         boolean agg_isNull509 = agg_fastAggBuffer.isNullAt(17);
/* 1163 */         double agg_value545 = agg_isNull509 ? -1.0 : (agg_fastAggBuffer.getDouble(17));
/* 1164 */         boolean agg_isNull508 = agg_isNull509;
/* 1165 */         double agg_value544 = agg_value545;
/* 1166 */         if (agg_isNull508) {
/* 1167 */           boolean agg_isNull510 = false;
/* 1168 */           double agg_value546 = -1.0;
/* 1169 */           if (!false) {
/* 1170 */             agg_value546 = (double) 0;
/* 1171 */           }
/* 1172 */           if (!agg_isNull510) {
/* 1173 */             agg_isNull508 = false;
/* 1174 */             agg_value544 = agg_value546;
/* 1175 */           }
/* 1176 */         }
/* 1177 */
/* 1178 */         boolean agg_isNull512 = false;
/* 1179 */         double agg_value548 = -1.0;
/* 1180 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1181 */           agg_isNull512 = true;
/* 1182 */         } else {
/* 1183 */           if (inputadapter_isNull13) {
/* 1184 */             agg_isNull512 = true;
/* 1185 */           } else {
/* 1186 */             agg_value548 = (double)(inputadapter_value13 / agg_value399);
/* 1187 */           }
/* 1188 */         }
/* 1189 */         if (!agg_isNull512) {
/* 1190 */           agg_isNull507 = false; // resultCode could change nullability.
/* 1191 */           agg_value543 = agg_value544 + agg_value548;
/* 1192 */
/* 1193 */         }
/* 1194 */         boolean agg_isNull506 = agg_isNull507;
/* 1195 */         double agg_value542 = agg_value543;
/* 1196 */         if (agg_isNull506) {
/* 1197 */           boolean agg_isNull514 = agg_fastAggBuffer.isNullAt(17);
/* 1198 */           double agg_value550 = agg_isNull514 ? -1.0 : (agg_fastAggBuffer.getDouble(17));
/* 1199 */           if (!agg_isNull514) {
/* 1200 */             agg_isNull506 = false;
/* 1201 */             agg_value542 = agg_value550;
/* 1202 */           }
/* 1203 */         }
/* 1204 */         boolean agg_isNull516 = true;
/* 1205 */         double agg_value552 = -1.0;
/* 1206 */
/* 1207 */         boolean agg_isNull518 = agg_fastAggBuffer.isNullAt(18);
/* 1208 */         double agg_value554 = agg_isNull518 ? -1.0 : (agg_fastAggBuffer.getDouble(18));
/* 1209 */         boolean agg_isNull517 = agg_isNull518;
/* 1210 */         double agg_value553 = agg_value554;
/* 1211 */         if (agg_isNull517) {
/* 1212 */           boolean agg_isNull519 = false;
/* 1213 */           double agg_value555 = -1.0;
/* 1214 */           if (!false) {
/* 1215 */             agg_value555 = (double) 0;
/* 1216 */           }
/* 1217 */           if (!agg_isNull519) {
/* 1218 */             agg_isNull517 = false;
/* 1219 */             agg_value553 = agg_value555;
/* 1220 */           }
/* 1221 */         }
/* 1222 */
/* 1223 */         boolean agg_isNull521 = false;
/* 1224 */         double agg_value557 = -1.0;
/* 1225 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1226 */           agg_isNull521 = true;
/* 1227 */         } else {
/* 1228 */           if (inputadapter_isNull14) {
/* 1229 */             agg_isNull521 = true;
/* 1230 */           } else {
/* 1231 */             agg_value557 = (double)(inputadapter_value14 / agg_value399);
/* 1232 */           }
/* 1233 */         }
/* 1234 */         if (!agg_isNull521) {
/* 1235 */           agg_isNull516 = false; // resultCode could change nullability.
/* 1236 */           agg_value552 = agg_value553 + agg_value557;
/* 1237 */
/* 1238 */         }
/* 1239 */         boolean agg_isNull515 = agg_isNull516;
/* 1240 */         double agg_value551 = agg_value552;
/* 1241 */         if (agg_isNull515) {
/* 1242 */           boolean agg_isNull523 = agg_fastAggBuffer.isNullAt(18);
/* 1243 */           double agg_value559 = agg_isNull523 ? -1.0 : (agg_fastAggBuffer.getDouble(18));
/* 1244 */           if (!agg_isNull523) {
/* 1245 */             agg_isNull515 = false;
/* 1246 */             agg_value551 = agg_value559;
/* 1247 */           }
/* 1248 */         }
/* 1249 */         boolean agg_isNull525 = true;
/* 1250 */         double agg_value561 = -1.0;
/* 1251 */
/* 1252 */         boolean agg_isNull527 = agg_fastAggBuffer.isNullAt(19);
/* 1253 */         double agg_value563 = agg_isNull527 ? -1.0 : (agg_fastAggBuffer.getDouble(19));
/* 1254 */         boolean agg_isNull526 = agg_isNull527;
/* 1255 */         double agg_value562 = agg_value563;
/* 1256 */         if (agg_isNull526) {
/* 1257 */           boolean agg_isNull528 = false;
/* 1258 */           double agg_value564 = -1.0;
/* 1259 */           if (!false) {
/* 1260 */             agg_value564 = (double) 0;
/* 1261 */           }
/* 1262 */           if (!agg_isNull528) {
/* 1263 */             agg_isNull526 = false;
/* 1264 */             agg_value562 = agg_value564;
/* 1265 */           }
/* 1266 */         }
/* 1267 */
/* 1268 */         boolean agg_isNull530 = false;
/* 1269 */         double agg_value566 = -1.0;
/* 1270 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1271 */           agg_isNull530 = true;
/* 1272 */         } else {
/* 1273 */           if (inputadapter_isNull15) {
/* 1274 */             agg_isNull530 = true;
/* 1275 */           } else {
/* 1276 */             agg_value566 = (double)(inputadapter_value15 / agg_value399);
/* 1277 */           }
/* 1278 */         }
/* 1279 */         if (!agg_isNull530) {
/* 1280 */           agg_isNull525 = false; // resultCode could change nullability.
/* 1281 */           agg_value561 = agg_value562 + agg_value566;
/* 1282 */
/* 1283 */         }
/* 1284 */         boolean agg_isNull524 = agg_isNull525;
/* 1285 */         double agg_value560 = agg_value561;
/* 1286 */         if (agg_isNull524) {
/* 1287 */           boolean agg_isNull532 = agg_fastAggBuffer.isNullAt(19);
/* 1288 */           double agg_value568 = agg_isNull532 ? -1.0 : (agg_fastAggBuffer.getDouble(19));
/* 1289 */           if (!agg_isNull532) {
/* 1290 */             agg_isNull524 = false;
/* 1291 */             agg_value560 = agg_value568;
/* 1292 */           }
/* 1293 */         }
/* 1294 */         boolean agg_isNull534 = true;
/* 1295 */         double agg_value570 = -1.0;
/* 1296 */
/* 1297 */         boolean agg_isNull536 = agg_fastAggBuffer.isNullAt(20);
/* 1298 */         double agg_value572 = agg_isNull536 ? -1.0 : (agg_fastAggBuffer.getDouble(20));
/* 1299 */         boolean agg_isNull535 = agg_isNull536;
/* 1300 */         double agg_value571 = agg_value572;
/* 1301 */         if (agg_isNull535) {
/* 1302 */           boolean agg_isNull537 = false;
/* 1303 */           double agg_value573 = -1.0;
/* 1304 */           if (!false) {
/* 1305 */             agg_value573 = (double) 0;
/* 1306 */           }
/* 1307 */           if (!agg_isNull537) {
/* 1308 */             agg_isNull535 = false;
/* 1309 */             agg_value571 = agg_value573;
/* 1310 */           }
/* 1311 */         }
/* 1312 */
/* 1313 */         boolean agg_isNull539 = false;
/* 1314 */         double agg_value575 = -1.0;
/* 1315 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1316 */           agg_isNull539 = true;
/* 1317 */         } else {
/* 1318 */           if (inputadapter_isNull16) {
/* 1319 */             agg_isNull539 = true;
/* 1320 */           } else {
/* 1321 */             agg_value575 = (double)(inputadapter_value16 / agg_value399);
/* 1322 */           }
/* 1323 */         }
/* 1324 */         if (!agg_isNull539) {
/* 1325 */           agg_isNull534 = false; // resultCode could change nullability.
/* 1326 */           agg_value570 = agg_value571 + agg_value575;
/* 1327 */
/* 1328 */         }
/* 1329 */         boolean agg_isNull533 = agg_isNull534;
/* 1330 */         double agg_value569 = agg_value570;
/* 1331 */         if (agg_isNull533) {
/* 1332 */           boolean agg_isNull541 = agg_fastAggBuffer.isNullAt(20);
/* 1333 */           double agg_value577 = agg_isNull541 ? -1.0 : (agg_fastAggBuffer.getDouble(20));
/* 1334 */           if (!agg_isNull541) {
/* 1335 */             agg_isNull533 = false;
/* 1336 */             agg_value569 = agg_value577;
/* 1337 */           }
/* 1338 */         }
/* 1339 */         boolean agg_isNull543 = true;
/* 1340 */         double agg_value579 = -1.0;
/* 1341 */
/* 1342 */         boolean agg_isNull545 = agg_fastAggBuffer.isNullAt(21);
/* 1343 */         double agg_value581 = agg_isNull545 ? -1.0 : (agg_fastAggBuffer.getDouble(21));
/* 1344 */         boolean agg_isNull544 = agg_isNull545;
/* 1345 */         double agg_value580 = agg_value581;
/* 1346 */         if (agg_isNull544) {
/* 1347 */           boolean agg_isNull546 = false;
/* 1348 */           double agg_value582 = -1.0;
/* 1349 */           if (!false) {
/* 1350 */             agg_value582 = (double) 0;
/* 1351 */           }
/* 1352 */           if (!agg_isNull546) {
/* 1353 */             agg_isNull544 = false;
/* 1354 */             agg_value580 = agg_value582;
/* 1355 */           }
/* 1356 */         }
/* 1357 */
/* 1358 */         boolean agg_isNull548 = false;
/* 1359 */         double agg_value584 = -1.0;
/* 1360 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1361 */           agg_isNull548 = true;
/* 1362 */         } else {
/* 1363 */           if (inputadapter_isNull17) {
/* 1364 */             agg_isNull548 = true;
/* 1365 */           } else {
/* 1366 */             agg_value584 = (double)(inputadapter_value17 / agg_value399);
/* 1367 */           }
/* 1368 */         }
/* 1369 */         if (!agg_isNull548) {
/* 1370 */           agg_isNull543 = false; // resultCode could change nullability.
/* 1371 */           agg_value579 = agg_value580 + agg_value584;
/* 1372 */
/* 1373 */         }
/* 1374 */         boolean agg_isNull542 = agg_isNull543;
/* 1375 */         double agg_value578 = agg_value579;
/* 1376 */         if (agg_isNull542) {
/* 1377 */           boolean agg_isNull550 = agg_fastAggBuffer.isNullAt(21);
/* 1378 */           double agg_value586 = agg_isNull550 ? -1.0 : (agg_fastAggBuffer.getDouble(21));
/* 1379 */           if (!agg_isNull550) {
/* 1380 */             agg_isNull542 = false;
/* 1381 */             agg_value578 = agg_value586;
/* 1382 */           }
/* 1383 */         }
/* 1384 */         boolean agg_isNull552 = true;
/* 1385 */         double agg_value588 = -1.0;
/* 1386 */
/* 1387 */         boolean agg_isNull554 = agg_fastAggBuffer.isNullAt(22);
/* 1388 */         double agg_value590 = agg_isNull554 ? -1.0 : (agg_fastAggBuffer.getDouble(22));
/* 1389 */         boolean agg_isNull553 = agg_isNull554;
/* 1390 */         double agg_value589 = agg_value590;
/* 1391 */         if (agg_isNull553) {
/* 1392 */           boolean agg_isNull555 = false;
/* 1393 */           double agg_value591 = -1.0;
/* 1394 */           if (!false) {
/* 1395 */             agg_value591 = (double) 0;
/* 1396 */           }
/* 1397 */           if (!agg_isNull555) {
/* 1398 */             agg_isNull553 = false;
/* 1399 */             agg_value589 = agg_value591;
/* 1400 */           }
/* 1401 */         }
/* 1402 */
/* 1403 */         boolean agg_isNull557 = false;
/* 1404 */         double agg_value593 = -1.0;
/* 1405 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1406 */           agg_isNull557 = true;
/* 1407 */         } else {
/* 1408 */           if (inputadapter_isNull18) {
/* 1409 */             agg_isNull557 = true;
/* 1410 */           } else {
/* 1411 */             agg_value593 = (double)(inputadapter_value18 / agg_value399);
/* 1412 */           }
/* 1413 */         }
/* 1414 */         if (!agg_isNull557) {
/* 1415 */           agg_isNull552 = false; // resultCode could change nullability.
/* 1416 */           agg_value588 = agg_value589 + agg_value593;
/* 1417 */
/* 1418 */         }
/* 1419 */         boolean agg_isNull551 = agg_isNull552;
/* 1420 */         double agg_value587 = agg_value588;
/* 1421 */         if (agg_isNull551) {
/* 1422 */           boolean agg_isNull559 = agg_fastAggBuffer.isNullAt(22);
/* 1423 */           double agg_value595 = agg_isNull559 ? -1.0 : (agg_fastAggBuffer.getDouble(22));
/* 1424 */           if (!agg_isNull559) {
/* 1425 */             agg_isNull551 = false;
/* 1426 */             agg_value587 = agg_value595;
/* 1427 */           }
/* 1428 */         }
/* 1429 */         boolean agg_isNull561 = true;
/* 1430 */         double agg_value597 = -1.0;
/* 1431 */
/* 1432 */         boolean agg_isNull563 = agg_fastAggBuffer.isNullAt(23);
/* 1433 */         double agg_value599 = agg_isNull563 ? -1.0 : (agg_fastAggBuffer.getDouble(23));
/* 1434 */         boolean agg_isNull562 = agg_isNull563;
/* 1435 */         double agg_value598 = agg_value599;
/* 1436 */         if (agg_isNull562) {
/* 1437 */           boolean agg_isNull564 = false;
/* 1438 */           double agg_value600 = -1.0;
/* 1439 */           if (!false) {
/* 1440 */             agg_value600 = (double) 0;
/* 1441 */           }
/* 1442 */           if (!agg_isNull564) {
/* 1443 */             agg_isNull562 = false;
/* 1444 */             agg_value598 = agg_value600;
/* 1445 */           }
/* 1446 */         }
/* 1447 */
/* 1448 */         boolean agg_isNull566 = false;
/* 1449 */         double agg_value602 = -1.0;
/* 1450 */         if (agg_isNull363 || agg_value399 == 0) {
/* 1451 */           agg_isNull566 = true;
/* 1452 */         } else {
/* 1453 */           if (inputadapter_isNull19) {
/* 1454 */             agg_isNull566 = true;
/* 1455 */           } else {
/* 1456 */             agg_value602 = (double)(inputadapter_value19 / agg_value399);
/* 1457 */           }
/* 1458 */         }
/* 1459 */         if (!agg_isNull566) {
/* 1460 */           agg_isNull561 = false; // resultCode could change nullability.
/* 1461 */           agg_value597 = agg_value598 + agg_value602;
/* 1462 */
/* 1463 */         }
/* 1464 */         boolean agg_isNull560 = agg_isNull561;
/* 1465 */         double agg_value596 = agg_value597;
/* 1466 */         if (agg_isNull560) {
/* 1467 */           boolean agg_isNull568 = agg_fastAggBuffer.isNullAt(23);
/* 1468 */           double agg_value604 = agg_isNull568 ? -1.0 : (agg_fastAggBuffer.getDouble(23));
/* 1469 */           if (!agg_isNull568) {
/* 1470 */             agg_isNull560 = false;
/* 1471 */             agg_value596 = agg_value604;
/* 1472 */           }
/* 1473 */         }
/* 1474 */         boolean agg_isNull570 = true;
/* 1475 */         double agg_value606 = -1.0;
/* 1476 */
/* 1477 */         boolean agg_isNull572 = agg_fastAggBuffer.isNullAt(24);
/* 1478 */         double agg_value608 = agg_isNull572 ? -1.0 : (agg_fastAggBuffer.getDouble(24));
/* 1479 */         boolean agg_isNull571 = agg_isNull572;
/* 1480 */         double agg_value607 = agg_value608;
/* 1481 */         if (agg_isNull571) {
/* 1482 */           boolean agg_isNull573 = false;
/* 1483 */           double agg_value609 = -1.0;
/* 1484 */           if (!false) {
/* 1485 */             agg_value609 = (double) 0;
/* 1486 */           }
/* 1487 */           if (!agg_isNull573) {
/* 1488 */             agg_isNull571 = false;
/* 1489 */             agg_value607 = agg_value609;
/* 1490 */           }
/* 1491 */         }
/* 1492 */
/* 1493 */         if (!inputadapter_isNull20) {
/* 1494 */           agg_isNull570 = false; // resultCode could change nullability.
/* 1495 */           agg_value606 = agg_value607 + inputadapter_value20;
/* 1496 */
/* 1497 */         }
/* 1498 */         boolean agg_isNull569 = agg_isNull570;
/* 1499 */         double agg_value605 = agg_value606;
/* 1500 */         if (agg_isNull569) {
/* 1501 */           boolean agg_isNull576 = agg_fastAggBuffer.isNullAt(24);
/* 1502 */           double agg_value612 = agg_isNull576 ? -1.0 : (agg_fastAggBuffer.getDouble(24));
/* 1503 */           if (!agg_isNull576) {
/* 1504 */             agg_isNull569 = false;
/* 1505 */             agg_value605 = agg_value612;
/* 1506 */           }
/* 1507 */         }
/* 1508 */         boolean agg_isNull578 = true;
/* 1509 */         double agg_value614 = -1.0;
/* 1510 */
/* 1511 */         boolean agg_isNull580 = agg_fastAggBuffer.isNullAt(25);
/* 1512 */         double agg_value616 = agg_isNull580 ? -1.0 : (agg_fastAggBuffer.getDouble(25));
/* 1513 */         boolean agg_isNull579 = agg_isNull580;
/* 1514 */         double agg_value615 = agg_value616;
/* 1515 */         if (agg_isNull579) {
/* 1516 */           boolean agg_isNull581 = false;
/* 1517 */           double agg_value617 = -1.0;
/* 1518 */           if (!false) {
/* 1519 */             agg_value617 = (double) 0;
/* 1520 */           }
/* 1521 */           if (!agg_isNull581) {
/* 1522 */             agg_isNull579 = false;
/* 1523 */             agg_value615 = agg_value617;
/* 1524 */           }
/* 1525 */         }
/* 1526 */
/* 1527 */         if (!inputadapter_isNull21) {
/* 1528 */           agg_isNull578 = false; // resultCode could change nullability.
/* 1529 */           agg_value614 = agg_value615 + inputadapter_value21;
/* 1530 */
/* 1531 */         }
/* 1532 */         boolean agg_isNull577 = agg_isNull578;
/* 1533 */         double agg_value613 = agg_value614;
/* 1534 */         if (agg_isNull577) {
/* 1535 */           boolean agg_isNull584 = agg_fastAggBuffer.isNullAt(25);
/* 1536 */           double agg_value620 = agg_isNull584 ? -1.0 : (agg_fastAggBuffer.getDouble(25));
/* 1537 */           if (!agg_isNull584) {
/* 1538 */             agg_isNull577 = false;
/* 1539 */             agg_value613 = agg_value620;
/* 1540 */           }
/* 1541 */         }
/* 1542 */         boolean agg_isNull586 = true;
/* 1543 */         double agg_value622 = -1.0;
/* 1544 */
/* 1545 */         boolean agg_isNull588 = agg_fastAggBuffer.isNullAt(26);
/* 1546 */         double agg_value624 = agg_isNull588 ? -1.0 : (agg_fastAggBuffer.getDouble(26));
/* 1547 */         boolean agg_isNull587 = agg_isNull588;
/* 1548 */         double agg_value623 = agg_value624;
/* 1549 */         if (agg_isNull587) {
/* 1550 */           boolean agg_isNull589 = false;
/* 1551 */           double agg_value625 = -1.0;
/* 1552 */           if (!false) {
/* 1553 */             agg_value625 = (double) 0;
/* 1554 */           }
/* 1555 */           if (!agg_isNull589) {
/* 1556 */             agg_isNull587 = false;
/* 1557 */             agg_value623 = agg_value625;
/* 1558 */           }
/* 1559 */         }
/* 1560 */
/* 1561 */         if (!inputadapter_isNull22) {
/* 1562 */           agg_isNull586 = false; // resultCode could change nullability.
/* 1563 */           agg_value622 = agg_value623 + inputadapter_value22;
/* 1564 */
/* 1565 */         }
/* 1566 */         boolean agg_isNull585 = agg_isNull586;
/* 1567 */         double agg_value621 = agg_value622;
/* 1568 */         if (agg_isNull585) {
/* 1569 */           boolean agg_isNull592 = agg_fastAggBuffer.isNullAt(26);
/* 1570 */           double agg_value628 = agg_isNull592 ? -1.0 : (agg_fastAggBuffer.getDouble(26));
/* 1571 */           if (!agg_isNull592) {
/* 1572 */             agg_isNull585 = false;
/* 1573 */             agg_value621 = agg_value628;
/* 1574 */           }
/* 1575 */         }
/* 1576 */         boolean agg_isNull594 = true;
/* 1577 */         double agg_value630 = -1.0;
/* 1578 */
/* 1579 */         boolean agg_isNull596 = agg_fastAggBuffer.isNullAt(27);
/* 1580 */         double agg_value632 = agg_isNull596 ? -1.0 : (agg_fastAggBuffer.getDouble(27));
/* 1581 */         boolean agg_isNull595 = agg_isNull596;
/* 1582 */         double agg_value631 = agg_value632;
/* 1583 */         if (agg_isNull595) {
/* 1584 */           boolean agg_isNull597 = false;
/* 1585 */           double agg_value633 = -1.0;
/* 1586 */           if (!false) {
/* 1587 */             agg_value633 = (double) 0;
/* 1588 */           }
/* 1589 */           if (!agg_isNull597) {
/* 1590 */             agg_isNull595 = false;
/* 1591 */             agg_value631 = agg_value633;
/* 1592 */           }
/* 1593 */         }
/* 1594 */
/* 1595 */         if (!inputadapter_isNull23) {
/* 1596 */           agg_isNull594 = false; // resultCode could change nullability.
/* 1597 */           agg_value630 = agg_value631 + inputadapter_value23;
/* 1598 */
/* 1599 */         }
/* 1600 */         boolean agg_isNull593 = agg_isNull594;
/* 1601 */         double agg_value629 = agg_value630;
/* 1602 */         if (agg_isNull593) {
/* 1603 */           boolean agg_isNull600 = agg_fastAggBuffer.isNullAt(27);
/* 1604 */           double agg_value636 = agg_isNull600 ? -1.0 : (agg_fastAggBuffer.getDouble(27));
/* 1605 */           if (!agg_isNull600) {
/* 1606 */             agg_isNull593 = false;
/* 1607 */             agg_value629 = agg_value636;
/* 1608 */           }
/* 1609 */         }
/* 1610 */         boolean agg_isNull602 = true;
/* 1611 */         double agg_value638 = -1.0;
/* 1612 */
/* 1613 */         boolean agg_isNull604 = agg_fastAggBuffer.isNullAt(28);
/* 1614 */         double agg_value640 = agg_isNull604 ? -1.0 : (agg_fastAggBuffer.getDouble(28));
/* 1615 */         boolean agg_isNull603 = agg_isNull604;
/* 1616 */         double agg_value639 = agg_value640;
/* 1617 */         if (agg_isNull603) {
/* 1618 */           boolean agg_isNull605 = false;
/* 1619 */           double agg_value641 = -1.0;
/* 1620 */           if (!false) {
/* 1621 */             agg_value641 = (double) 0;
/* 1622 */           }
/* 1623 */           if (!agg_isNull605) {
/* 1624 */             agg_isNull603 = false;
/* 1625 */             agg_value639 = agg_value641;
/* 1626 */           }
/* 1627 */         }
/* 1628 */
/* 1629 */         if (!inputadapter_isNull24) {
/* 1630 */           agg_isNull602 = false; // resultCode could change nullability.
/* 1631 */           agg_value638 = agg_value639 + inputadapter_value24;
/* 1632 */
/* 1633 */         }
/* 1634 */         boolean agg_isNull601 = agg_isNull602;
/* 1635 */         double agg_value637 = agg_value638;
/* 1636 */         if (agg_isNull601) {
/* 1637 */           boolean agg_isNull608 = agg_fastAggBuffer.isNullAt(28);
/* 1638 */           double agg_value644 = agg_isNull608 ? -1.0 : (agg_fastAggBuffer.getDouble(28));
/* 1639 */           if (!agg_isNull608) {
/* 1640 */             agg_isNull601 = false;
/* 1641 */             agg_value637 = agg_value644;
/* 1642 */           }
/* 1643 */         }
/* 1644 */         boolean agg_isNull610 = true;
/* 1645 */         double agg_value646 = -1.0;
/* 1646 */
/* 1647 */         boolean agg_isNull612 = agg_fastAggBuffer.isNullAt(29);
/* 1648 */         double agg_value648 = agg_isNull612 ? -1.0 : (agg_fastAggBuffer.getDouble(29));
/* 1649 */         boolean agg_isNull611 = agg_isNull612;
/* 1650 */         double agg_value647 = agg_value648;
/* 1651 */         if (agg_isNull611) {
/* 1652 */           boolean agg_isNull613 = false;
/* 1653 */           double agg_value649 = -1.0;
/* 1654 */           if (!false) {
/* 1655 */             agg_value649 = (double) 0;
/* 1656 */           }
/* 1657 */           if (!agg_isNull613) {
/* 1658 */             agg_isNull611 = false;
/* 1659 */             agg_value647 = agg_value649;
/* 1660 */           }
/* 1661 */         }
/* 1662 */
/* 1663 */         if (!inputadapter_isNull25) {
/* 1664 */           agg_isNull610 = false; // resultCode could change nullability.
/* 1665 */           agg_value646 = agg_value647 + inputadapter_value25;
/* 1666 */
/* 1667 */         }
/* 1668 */         boolean agg_isNull609 = agg_isNull610;
/* 1669 */         double agg_value645 = agg_value646;
/* 1670 */         if (agg_isNull609) {
/* 1671 */           boolean agg_isNull616 = agg_fastAggBuffer.isNullAt(29);
/* 1672 */           double agg_value652 = agg_isNull616 ? -1.0 : (agg_fastAggBuffer.getDouble(29));
/* 1673 */           if (!agg_isNull616) {
/* 1674 */             agg_isNull609 = false;
/* 1675 */             agg_value645 = agg_value652;
/* 1676 */           }
/* 1677 */         }
/* 1678 */         boolean agg_isNull618 = true;
/* 1679 */         double agg_value654 = -1.0;
/* 1680 */
/* 1681 */         boolean agg_isNull620 = agg_fastAggBuffer.isNullAt(30);
/* 1682 */         double agg_value656 = agg_isNull620 ? -1.0 : (agg_fastAggBuffer.getDouble(30));
/* 1683 */         boolean agg_isNull619 = agg_isNull620;
/* 1684 */         double agg_value655 = agg_value656;
/* 1685 */         if (agg_isNull619) {
/* 1686 */           boolean agg_isNull621 = false;
/* 1687 */           double agg_value657 = -1.0;
/* 1688 */           if (!false) {
/* 1689 */             agg_value657 = (double) 0;
/* 1690 */           }
/* 1691 */           if (!agg_isNull621) {
/* 1692 */             agg_isNull619 = false;
/* 1693 */             agg_value655 = agg_value657;
/* 1694 */           }
/* 1695 */         }
/* 1696 */
/* 1697 */         if (!inputadapter_isNull26) {
/* 1698 */           agg_isNull618 = false; // resultCode could change nullability.
/* 1699 */           agg_value654 = agg_value655 + inputadapter_value26;
/* 1700 */
/* 1701 */         }
/* 1702 */         boolean agg_isNull617 = agg_isNull618;
/* 1703 */         double agg_value653 = agg_value654;
/* 1704 */         if (agg_isNull617) {
/* 1705 */           boolean agg_isNull624 = agg_fastAggBuffer.isNullAt(30);
/* 1706 */           double agg_value660 = agg_isNull624 ? -1.0 : (agg_fastAggBuffer.getDouble(30));
/* 1707 */           if (!agg_isNull624) {
/* 1708 */             agg_isNull617 = false;
/* 1709 */             agg_value653 = agg_value660;
/* 1710 */           }
/* 1711 */         }
/* 1712 */         boolean agg_isNull626 = true;
/* 1713 */         double agg_value662 = -1.0;
/* 1714 */
/* 1715 */         boolean agg_isNull628 = agg_fastAggBuffer.isNullAt(31);
/* 1716 */         double agg_value664 = agg_isNull628 ? -1.0 : (agg_fastAggBuffer.getDouble(31));
/* 1717 */         boolean agg_isNull627 = agg_isNull628;
/* 1718 */         double agg_value663 = agg_value664;
/* 1719 */         if (agg_isNull627) {
/* 1720 */           boolean agg_isNull629 = false;
/* 1721 */           double agg_value665 = -1.0;
/* 1722 */           if (!false) {
/* 1723 */             agg_value665 = (double) 0;
/* 1724 */           }
/* 1725 */           if (!agg_isNull629) {
/* 1726 */             agg_isNull627 = false;
/* 1727 */             agg_value663 = agg_value665;
/* 1728 */           }
/* 1729 */         }
/* 1730 */
/* 1731 */         if (!inputadapter_isNull27) {
/* 1732 */           agg_isNull626 = false; // resultCode could change nullability.
/* 1733 */           agg_value662 = agg_value663 + inputadapter_value27;
/* 1734 */
/* 1735 */         }
/* 1736 */         boolean agg_isNull625 = agg_isNull626;
/* 1737 */         double agg_value661 = agg_value662;
/* 1738 */         if (agg_isNull625) {
/* 1739 */           boolean agg_isNull632 = agg_fastAggBuffer.isNullAt(31);
/* 1740 */           double agg_value668 = agg_isNull632 ? -1.0 : (agg_fastAggBuffer.getDouble(31));
/* 1741 */           if (!agg_isNull632) {
/* 1742 */             agg_isNull625 = false;
/* 1743 */             agg_value661 = agg_value668;
/* 1744 */           }
/* 1745 */         }
/* 1746 */         boolean agg_isNull634 = true;
/* 1747 */         double agg_value670 = -1.0;
/* 1748 */
/* 1749 */         boolean agg_isNull636 = agg_fastAggBuffer.isNullAt(32);
/* 1750 */         double agg_value672 = agg_isNull636 ? -1.0 : (agg_fastAggBuffer.getDouble(32));
/* 1751 */         boolean agg_isNull635 = agg_isNull636;
/* 1752 */         double agg_value671 = agg_value672;
/* 1753 */         if (agg_isNull635) {
/* 1754 */           boolean agg_isNull637 = false;
/* 1755 */           double agg_value673 = -1.0;
/* 1756 */           if (!false) {
/* 1757 */             agg_value673 = (double) 0;
/* 1758 */           }
/* 1759 */           if (!agg_isNull637) {
/* 1760 */             agg_isNull635 = false;
/* 1761 */             agg_value671 = agg_value673;
/* 1762 */           }
/* 1763 */         }
/* 1764 */
/* 1765 */         if (!inputadapter_isNull28) {
/* 1766 */           agg_isNull634 = false; // resultCode could change nullability.
/* 1767 */           agg_value670 = agg_value671 + inputadapter_value28;
/* 1768 */
/* 1769 */         }
/* 1770 */         boolean agg_isNull633 = agg_isNull634;
/* 1771 */         double agg_value669 = agg_value670;
/* 1772 */         if (agg_isNull633) {
/* 1773 */           boolean agg_isNull640 = agg_fastAggBuffer.isNullAt(32);
/* 1774 */           double agg_value676 = agg_isNull640 ? -1.0 : (agg_fastAggBuffer.getDouble(32));
/* 1775 */           if (!agg_isNull640) {
/* 1776 */             agg_isNull633 = false;
/* 1777 */             agg_value669 = agg_value676;
/* 1778 */           }
/* 1779 */         }
/* 1780 */         boolean agg_isNull642 = true;
/* 1781 */         double agg_value678 = -1.0;
/* 1782 */
/* 1783 */         boolean agg_isNull644 = agg_fastAggBuffer.isNullAt(33);
/* 1784 */         double agg_value680 = agg_isNull644 ? -1.0 : (agg_fastAggBuffer.getDouble(33));
/* 1785 */         boolean agg_isNull643 = agg_isNull644;
/* 1786 */         double agg_value679 = agg_value680;
/* 1787 */         if (agg_isNull643) {
/* 1788 */           boolean agg_isNull645 = false;
/* 1789 */           double agg_value681 = -1.0;
/* 1790 */           if (!false) {
/* 1791 */             agg_value681 = (double) 0;
/* 1792 */           }
/* 1793 */           if (!agg_isNull645) {
/* 1794 */             agg_isNull643 = false;
/* 1795 */             agg_value679 = agg_value681;
/* 1796 */           }
/* 1797 */         }
/* 1798 */
/* 1799 */         if (!inputadapter_isNull29) {
/* 1800 */           agg_isNull642 = false; // resultCode could change nullability.
/* 1801 */           agg_value678 = agg_value679 + inputadapter_value29;
/* 1802 */
/* 1803 */         }
/* 1804 */         boolean agg_isNull641 = agg_isNull642;
/* 1805 */         double agg_value677 = agg_value678;
/* 1806 */         if (agg_isNull641) {
/* 1807 */           boolean agg_isNull648 = agg_fastAggBuffer.isNullAt(33);
/* 1808 */           double agg_value684 = agg_isNull648 ? -1.0 : (agg_fastAggBuffer.getDouble(33));
/* 1809 */           if (!agg_isNull648) {
/* 1810 */             agg_isNull641 = false;
/* 1811 */             agg_value677 = agg_value684;
/* 1812 */           }
/* 1813 */         }
/* 1814 */         boolean agg_isNull650 = true;
/* 1815 */         double agg_value686 = -1.0;
/* 1816 */
/* 1817 */         boolean agg_isNull652 = agg_fastAggBuffer.isNullAt(34);
/* 1818 */         double agg_value688 = agg_isNull652 ? -1.0 : (agg_fastAggBuffer.getDouble(34));
/* 1819 */         boolean agg_isNull651 = agg_isNull652;
/* 1820 */         double agg_value687 = agg_value688;
/* 1821 */         if (agg_isNull651) {
/* 1822 */           boolean agg_isNull653 = false;
/* 1823 */           double agg_value689 = -1.0;
/* 1824 */           if (!false) {
/* 1825 */             agg_value689 = (double) 0;
/* 1826 */           }
/* 1827 */           if (!agg_isNull653) {
/* 1828 */             agg_isNull651 = false;
/* 1829 */             agg_value687 = agg_value689;
/* 1830 */           }
/* 1831 */         }
/* 1832 */
/* 1833 */         if (!inputadapter_isNull30) {
/* 1834 */           agg_isNull650 = false; // resultCode could change nullability.
/* 1835 */           agg_value686 = agg_value687 + inputadapter_value30;
/* 1836 */
/* 1837 */         }
/* 1838 */         boolean agg_isNull649 = agg_isNull650;
/* 1839 */         double agg_value685 = agg_value686;
/* 1840 */         if (agg_isNull649) {
/* 1841 */           boolean agg_isNull656 = agg_fastAggBuffer.isNullAt(34);
/* 1842 */           double agg_value692 = agg_isNull656 ? -1.0 : (agg_fastAggBuffer.getDouble(34));
/* 1843 */           if (!agg_isNull656) {
/* 1844 */             agg_isNull649 = false;
/* 1845 */             agg_value685 = agg_value692;
/* 1846 */           }
/* 1847 */         }
/* 1848 */         boolean agg_isNull658 = true;
/* 1849 */         double agg_value694 = -1.0;
/* 1850 */
/* 1851 */         boolean agg_isNull660 = agg_fastAggBuffer.isNullAt(35);
/* 1852 */         double agg_value696 = agg_isNull660 ? -1.0 : (agg_fastAggBuffer.getDouble(35));
/* 1853 */         boolean agg_isNull659 = agg_isNull660;
/* 1854 */         double agg_value695 = agg_value696;
/* 1855 */         if (agg_isNull659) {
/* 1856 */           boolean agg_isNull661 = false;
/* 1857 */           double agg_value697 = -1.0;
/* 1858 */           if (!false) {
/* 1859 */             agg_value697 = (double) 0;
/* 1860 */           }
/* 1861 */           if (!agg_isNull661) {
/* 1862 */             agg_isNull659 = false;
/* 1863 */             agg_value695 = agg_value697;
/* 1864 */           }
/* 1865 */         }
/* 1866 */
/* 1867 */         if (!inputadapter_isNull31) {
/* 1868 */           agg_isNull658 = false; // resultCode could change nullability.
/* 1869 */           agg_value694 = agg_value695 + inputadapter_value31;
/* 1870 */
/* 1871 */         }
/* 1872 */         boolean agg_isNull657 = agg_isNull658;
/* 1873 */         double agg_value693 = agg_value694;
/* 1874 */         if (agg_isNull657) {
/* 1875 */           boolean agg_isNull664 = agg_fastAggBuffer.isNullAt(35);
/* 1876 */           double agg_value700 = agg_isNull664 ? -1.0 : (agg_fastAggBuffer.getDouble(35));
/* 1877 */           if (!agg_isNull664) {
/* 1878 */             agg_isNull657 = false;
/* 1879 */             agg_value693 = agg_value700;
/* 1880 */           }
/* 1881 */         }
/* 1882 */         // update fast row
/* 1883 */         if (!agg_isNull365) {
/* 1884 */           agg_fastAggBuffer.setDouble(0, agg_value401);
/* 1885 */         } else {
/* 1886 */           agg_fastAggBuffer.setNullAt(0);
/* 1887 */         }
/* 1888 */
/* 1889 */         if (!agg_isNull373) {
/* 1890 */           agg_fastAggBuffer.setDouble(1, agg_value409);
/* 1891 */         } else {
/* 1892 */           agg_fastAggBuffer.setNullAt(1);
/* 1893 */         }
/* 1894 */
/* 1895 */         if (!agg_isNull381) {
/* 1896 */           agg_fastAggBuffer.setDouble(2, agg_value417);
/* 1897 */         } else {
/* 1898 */           agg_fastAggBuffer.setNullAt(2);
/* 1899 */         }
/* 1900 */
/* 1901 */         if (!agg_isNull389) {
/* 1902 */           agg_fastAggBuffer.setDouble(3, agg_value425);
/* 1903 */         } else {
/* 1904 */           agg_fastAggBuffer.setNullAt(3);
/* 1905 */         }
/* 1906 */
/* 1907 */         if (!agg_isNull397) {
/* 1908 */           agg_fastAggBuffer.setDouble(4, agg_value433);
/* 1909 */         } else {
/* 1910 */           agg_fastAggBuffer.setNullAt(4);
/* 1911 */         }
/* 1912 */
/* 1913 */         if (!agg_isNull405) {
/* 1914 */           agg_fastAggBuffer.setDouble(5, agg_value441);
/* 1915 */         } else {
/* 1916 */           agg_fastAggBuffer.setNullAt(5);
/* 1917 */         }
/* 1918 */
/* 1919 */         if (!agg_isNull413) {
/* 1920 */           agg_fastAggBuffer.setDouble(6, agg_value449);
/* 1921 */         } else {
/* 1922 */           agg_fastAggBuffer.setNullAt(6);
/* 1923 */         }
/* 1924 */
/* 1925 */         if (!agg_isNull421) {
/* 1926 */           agg_fastAggBuffer.setDouble(7, agg_value457);
/* 1927 */         } else {
/* 1928 */           agg_fastAggBuffer.setNullAt(7);
/* 1929 */         }
/* 1930 */
/* 1931 */         if (!agg_isNull429) {
/* 1932 */           agg_fastAggBuffer.setDouble(8, agg_value465);
/* 1933 */         } else {
/* 1934 */           agg_fastAggBuffer.setNullAt(8);
/* 1935 */         }
/* 1936 */
/* 1937 */         if (!agg_isNull437) {
/* 1938 */           agg_fastAggBuffer.setDouble(9, agg_value473);
/* 1939 */         } else {
/* 1940 */           agg_fastAggBuffer.setNullAt(9);
/* 1941 */         }
/* 1942 */
/* 1943 */         if (!agg_isNull445) {
/* 1944 */           agg_fastAggBuffer.setDouble(10, agg_value481);
/* 1945 */         } else {
/* 1946 */           agg_fastAggBuffer.setNullAt(10);
/* 1947 */         }
/* 1948 */
/* 1949 */         if (!agg_isNull453) {
/* 1950 */           agg_fastAggBuffer.setDouble(11, agg_value489);
/* 1951 */         } else {
/* 1952 */           agg_fastAggBuffer.setNullAt(11);
/* 1953 */         }
/* 1954 */
/* 1955 */         if (!agg_isNull461) {
/* 1956 */           agg_fastAggBuffer.setDouble(12, agg_value497);
/* 1957 */         } else {
/* 1958 */           agg_fastAggBuffer.setNullAt(12);
/* 1959 */         }
/* 1960 */
/* 1961 */         if (!agg_isNull470) {
/* 1962 */           agg_fastAggBuffer.setDouble(13, agg_value506);
/* 1963 */         } else {
/* 1964 */           agg_fastAggBuffer.setNullAt(13);
/* 1965 */         }
/* 1966 */
/* 1967 */         if (!agg_isNull479) {
/* 1968 */           agg_fastAggBuffer.setDouble(14, agg_value515);
/* 1969 */         } else {
/* 1970 */           agg_fastAggBuffer.setNullAt(14);
/* 1971 */         }
/* 1972 */
/* 1973 */         if (!agg_isNull488) {
/* 1974 */           agg_fastAggBuffer.setDouble(15, agg_value524);
/* 1975 */         } else {
/* 1976 */           agg_fastAggBuffer.setNullAt(15);
/* 1977 */         }
/* 1978 */
/* 1979 */         if (!agg_isNull497) {
/* 1980 */           agg_fastAggBuffer.setDouble(16, agg_value533);
/* 1981 */         } else {
/* 1982 */           agg_fastAggBuffer.setNullAt(16);
/* 1983 */         }
/* 1984 */
/* 1985 */         if (!agg_isNull506) {
/* 1986 */           agg_fastAggBuffer.setDouble(17, agg_value542);
/* 1987 */         } else {
/* 1988 */           agg_fastAggBuffer.setNullAt(17);
/* 1989 */         }
/* 1990 */
/* 1991 */         if (!agg_isNull515) {
/* 1992 */           agg_fastAggBuffer.setDouble(18, agg_value551);
/* 1993 */         } else {
/* 1994 */           agg_fastAggBuffer.setNullAt(18);
/* 1995 */         }
/* 1996 */
/* 1997 */         if (!agg_isNull524) {
/* 1998 */           agg_fastAggBuffer.setDouble(19, agg_value560);
/* 1999 */         } else {
/* 2000 */           agg_fastAggBuffer.setNullAt(19);
/* 2001 */         }
/* 2002 */
/* 2003 */         if (!agg_isNull533) {
/* 2004 */           agg_fastAggBuffer.setDouble(20, agg_value569);
/* 2005 */         } else {
/* 2006 */           agg_fastAggBuffer.setNullAt(20);
/* 2007 */         }
/* 2008 */
/* 2009 */         if (!agg_isNull542) {
/* 2010 */           agg_fastAggBuffer.setDouble(21, agg_value578);
/* 2011 */         } else {
/* 2012 */           agg_fastAggBuffer.setNullAt(21);
/* 2013 */         }
/* 2014 */
/* 2015 */         if (!agg_isNull551) {
/* 2016 */           agg_fastAggBuffer.setDouble(22, agg_value587);
/* 2017 */         } else {
/* 2018 */           agg_fastAggBuffer.setNullAt(22);
/* 2019 */         }
/* 2020 */
/* 2021 */         if (!agg_isNull560) {
/* 2022 */           agg_fastAggBuffer.setDouble(23, agg_value596);
/* 2023 */         } else {
/* 2024 */           agg_fastAggBuffer.setNullAt(23);
/* 2025 */         }
/* 2026 */
/* 2027 */         if (!agg_isNull569) {
/* 2028 */           agg_fastAggBuffer.setDouble(24, agg_value605);
/* 2029 */         } else {
/* 2030 */           agg_fastAggBuffer.setNullAt(24);
/* 2031 */         }
/* 2032 */
/* 2033 */         if (!agg_isNull577) {
/* 2034 */           agg_fastAggBuffer.setDouble(25, agg_value613);
/* 2035 */         } else {
/* 2036 */           agg_fastAggBuffer.setNullAt(25);
/* 2037 */         }
/* 2038 */
/* 2039 */         if (!agg_isNull585) {
/* 2040 */           agg_fastAggBuffer.setDouble(26, agg_value621);
/* 2041 */         } else {
/* 2042 */           agg_fastAggBuffer.setNullAt(26);
/* 2043 */         }
/* 2044 */
/* 2045 */         if (!agg_isNull593) {
/* 2046 */           agg_fastAggBuffer.setDouble(27, agg_value629);
/* 2047 */         } else {
/* 2048 */           agg_fastAggBuffer.setNullAt(27);
/* 2049 */         }
/* 2050 */
/* 2051 */         if (!agg_isNull601) {
/* 2052 */           agg_fastAggBuffer.setDouble(28, agg_value637);
/* 2053 */         } else {
/* 2054 */           agg_fastAggBuffer.setNullAt(28);
/* 2055 */         }
/* 2056 */
/* 2057 */         if (!agg_isNull609) {
/* 2058 */           agg_fastAggBuffer.setDouble(29, agg_value645);
/* 2059 */         } else {
/* 2060 */           agg_fastAggBuffer.setNullAt(29);
/* 2061 */         }
/* 2062 */
/* 2063 */         if (!agg_isNull617) {
/* 2064 */           agg_fastAggBuffer.setDouble(30, agg_value653);
/* 2065 */         } else {
/* 2066 */           agg_fastAggBuffer.setNullAt(30);
/* 2067 */         }
/* 2068 */
/* 2069 */         if (!agg_isNull625) {
/* 2070 */           agg_fastAggBuffer.setDouble(31, agg_value661);
/* 2071 */         } else {
/* 2072 */           agg_fastAggBuffer.setNullAt(31);
/* 2073 */         }
/* 2074 */
/* 2075 */         if (!agg_isNull633) {
/* 2076 */           agg_fastAggBuffer.setDouble(32, agg_value669);
/* 2077 */         } else {
/* 2078 */           agg_fastAggBuffer.setNullAt(32);
/* 2079 */         }
/* 2080 */
/* 2081 */         if (!agg_isNull641) {
/* 2082 */           agg_fastAggBuffer.setDouble(33, agg_value677);
/* 2083 */         } else {
/* 2084 */           agg_fastAggBuffer.setNullAt(33);
/* 2085 */         }
/* 2086 */
/* 2087 */         if (!agg_isNull649) {
/* 2088 */           agg_fastAggBuffer.setDouble(34, agg_value685);
/* 2089 */         } else {
/* 2090 */           agg_fastAggBuffer.setNullAt(34);
/* 2091 */         }
/* 2092 */
/* 2093 */         if (!agg_isNull657) {
/* 2094 */           agg_fastAggBuffer.setDouble(35, agg_value693);
/* 2095 */         } else {
/* 2096 */           agg_fastAggBuffer.setNullAt(35);
/* 2097 */         }
/* 2098 */
/* 2099 */       } else {
/* 2100 */         // update unsafe row
/* 2101 */
/* 2102 */         // common sub-expressions
/* 2103 */         boolean agg_isNull61 = inputadapter_isNull1;
/* 2104 */         double agg_value97 = -1.0;
/* 2105 */         if (!inputadapter_isNull1) {
/* 2106 */           agg_value97 = (double) inputadapter_value1;
/* 2107 */         }
/* 2108 */         // evaluate aggregate function
/* 2109 */         boolean agg_isNull64 = true;
/* 2110 */         double agg_value100 = -1.0;
/* 2111 */
/* 2112 */         boolean agg_isNull66 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 2113 */         double agg_value102 = agg_isNull66 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 2114 */         boolean agg_isNull65 = agg_isNull66;
/* 2115 */         double agg_value101 = agg_value102;
/* 2116 */         if (agg_isNull65) {
/* 2117 */           boolean agg_isNull67 = false;
/* 2118 */           double agg_value103 = -1.0;
/* 2119 */           if (!false) {
/* 2120 */             agg_value103 = (double) 0;
/* 2121 */           }
/* 2122 */           if (!agg_isNull67) {
/* 2123 */             agg_isNull65 = false;
/* 2124 */             agg_value101 = agg_value103;
/* 2125 */           }
/* 2126 */         }
/* 2127 */
/* 2128 */         if (!inputadapter_isNull8) {
/* 2129 */           agg_isNull64 = false; // resultCode could change nullability.
/* 2130 */           agg_value100 = agg_value101 + inputadapter_value8;
/* 2131 */
/* 2132 */         }
/* 2133 */         boolean agg_isNull63 = agg_isNull64;
/* 2134 */         double agg_value99 = agg_value100;
/* 2135 */         if (agg_isNull63) {
/* 2136 */           boolean agg_isNull70 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 2137 */           double agg_value106 = agg_isNull70 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 2138 */           if (!agg_isNull70) {
/* 2139 */             agg_isNull63 = false;
/* 2140 */             agg_value99 = agg_value106;
/* 2141 */           }
/* 2142 */         }
/* 2143 */         boolean agg_isNull72 = true;
/* 2144 */         double agg_value108 = -1.0;
/* 2145 */
/* 2146 */         boolean agg_isNull74 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 2147 */         double agg_value110 = agg_isNull74 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 2148 */         boolean agg_isNull73 = agg_isNull74;
/* 2149 */         double agg_value109 = agg_value110;
/* 2150 */         if (agg_isNull73) {
/* 2151 */           boolean agg_isNull75 = false;
/* 2152 */           double agg_value111 = -1.0;
/* 2153 */           if (!false) {
/* 2154 */             agg_value111 = (double) 0;
/* 2155 */           }
/* 2156 */           if (!agg_isNull75) {
/* 2157 */             agg_isNull73 = false;
/* 2158 */             agg_value109 = agg_value111;
/* 2159 */           }
/* 2160 */         }
/* 2161 */
/* 2162 */         if (!inputadapter_isNull9) {
/* 2163 */           agg_isNull72 = false; // resultCode could change nullability.
/* 2164 */           agg_value108 = agg_value109 + inputadapter_value9;
/* 2165 */
/* 2166 */         }
/* 2167 */         boolean agg_isNull71 = agg_isNull72;
/* 2168 */         double agg_value107 = agg_value108;
/* 2169 */         if (agg_isNull71) {
/* 2170 */           boolean agg_isNull78 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 2171 */           double agg_value114 = agg_isNull78 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 2172 */           if (!agg_isNull78) {
/* 2173 */             agg_isNull71 = false;
/* 2174 */             agg_value107 = agg_value114;
/* 2175 */           }
/* 2176 */         }
/* 2177 */         boolean agg_isNull80 = true;
/* 2178 */         double agg_value116 = -1.0;
/* 2179 */
/* 2180 */         boolean agg_isNull82 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2181 */         double agg_value118 = agg_isNull82 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 2182 */         boolean agg_isNull81 = agg_isNull82;
/* 2183 */         double agg_value117 = agg_value118;
/* 2184 */         if (agg_isNull81) {
/* 2185 */           boolean agg_isNull83 = false;
/* 2186 */           double agg_value119 = -1.0;
/* 2187 */           if (!false) {
/* 2188 */             agg_value119 = (double) 0;
/* 2189 */           }
/* 2190 */           if (!agg_isNull83) {
/* 2191 */             agg_isNull81 = false;
/* 2192 */             agg_value117 = agg_value119;
/* 2193 */           }
/* 2194 */         }
/* 2195 */
/* 2196 */         if (!inputadapter_isNull10) {
/* 2197 */           agg_isNull80 = false; // resultCode could change nullability.
/* 2198 */           agg_value116 = agg_value117 + inputadapter_value10;
/* 2199 */
/* 2200 */         }
/* 2201 */         boolean agg_isNull79 = agg_isNull80;
/* 2202 */         double agg_value115 = agg_value116;
/* 2203 */         if (agg_isNull79) {
/* 2204 */           boolean agg_isNull86 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 2205 */           double agg_value122 = agg_isNull86 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 2206 */           if (!agg_isNull86) {
/* 2207 */             agg_isNull79 = false;
/* 2208 */             agg_value115 = agg_value122;
/* 2209 */           }
/* 2210 */         }
/* 2211 */         boolean agg_isNull88 = true;
/* 2212 */         double agg_value124 = -1.0;
/* 2213 */
/* 2214 */         boolean agg_isNull90 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 2215 */         double agg_value126 = agg_isNull90 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 2216 */         boolean agg_isNull89 = agg_isNull90;
/* 2217 */         double agg_value125 = agg_value126;
/* 2218 */         if (agg_isNull89) {
/* 2219 */           boolean agg_isNull91 = false;
/* 2220 */           double agg_value127 = -1.0;
/* 2221 */           if (!false) {
/* 2222 */             agg_value127 = (double) 0;
/* 2223 */           }
/* 2224 */           if (!agg_isNull91) {
/* 2225 */             agg_isNull89 = false;
/* 2226 */             agg_value125 = agg_value127;
/* 2227 */           }
/* 2228 */         }
/* 2229 */
/* 2230 */         if (!inputadapter_isNull11) {
/* 2231 */           agg_isNull88 = false; // resultCode could change nullability.
/* 2232 */           agg_value124 = agg_value125 + inputadapter_value11;
/* 2233 */
/* 2234 */         }
/* 2235 */         boolean agg_isNull87 = agg_isNull88;
/* 2236 */         double agg_value123 = agg_value124;
/* 2237 */         if (agg_isNull87) {
/* 2238 */           boolean agg_isNull94 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 2239 */           double agg_value130 = agg_isNull94 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 2240 */           if (!agg_isNull94) {
/* 2241 */             agg_isNull87 = false;
/* 2242 */             agg_value123 = agg_value130;
/* 2243 */           }
/* 2244 */         }
/* 2245 */         boolean agg_isNull96 = true;
/* 2246 */         double agg_value132 = -1.0;
/* 2247 */
/* 2248 */         boolean agg_isNull98 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 2249 */         double agg_value134 = agg_isNull98 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 2250 */         boolean agg_isNull97 = agg_isNull98;
/* 2251 */         double agg_value133 = agg_value134;
/* 2252 */         if (agg_isNull97) {
/* 2253 */           boolean agg_isNull99 = false;
/* 2254 */           double agg_value135 = -1.0;
/* 2255 */           if (!false) {
/* 2256 */             agg_value135 = (double) 0;
/* 2257 */           }
/* 2258 */           if (!agg_isNull99) {
/* 2259 */             agg_isNull97 = false;
/* 2260 */             agg_value133 = agg_value135;
/* 2261 */           }
/* 2262 */         }
/* 2263 */
/* 2264 */         if (!inputadapter_isNull12) {
/* 2265 */           agg_isNull96 = false; // resultCode could change nullability.
/* 2266 */           agg_value132 = agg_value133 + inputadapter_value12;
/* 2267 */
/* 2268 */         }
/* 2269 */         boolean agg_isNull95 = agg_isNull96;
/* 2270 */         double agg_value131 = agg_value132;
/* 2271 */         if (agg_isNull95) {
/* 2272 */           boolean agg_isNull102 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 2273 */           double agg_value138 = agg_isNull102 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 2274 */           if (!agg_isNull102) {
/* 2275 */             agg_isNull95 = false;
/* 2276 */             agg_value131 = agg_value138;
/* 2277 */           }
/* 2278 */         }
/* 2279 */         boolean agg_isNull104 = true;
/* 2280 */         double agg_value140 = -1.0;
/* 2281 */
/* 2282 */         boolean agg_isNull106 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 2283 */         double agg_value142 = agg_isNull106 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 2284 */         boolean agg_isNull105 = agg_isNull106;
/* 2285 */         double agg_value141 = agg_value142;
/* 2286 */         if (agg_isNull105) {
/* 2287 */           boolean agg_isNull107 = false;
/* 2288 */           double agg_value143 = -1.0;
/* 2289 */           if (!false) {
/* 2290 */             agg_value143 = (double) 0;
/* 2291 */           }
/* 2292 */           if (!agg_isNull107) {
/* 2293 */             agg_isNull105 = false;
/* 2294 */             agg_value141 = agg_value143;
/* 2295 */           }
/* 2296 */         }
/* 2297 */
/* 2298 */         if (!inputadapter_isNull13) {
/* 2299 */           agg_isNull104 = false; // resultCode could change nullability.
/* 2300 */           agg_value140 = agg_value141 + inputadapter_value13;
/* 2301 */
/* 2302 */         }
/* 2303 */         boolean agg_isNull103 = agg_isNull104;
/* 2304 */         double agg_value139 = agg_value140;
/* 2305 */         if (agg_isNull103) {
/* 2306 */           boolean agg_isNull110 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 2307 */           double agg_value146 = agg_isNull110 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 2308 */           if (!agg_isNull110) {
/* 2309 */             agg_isNull103 = false;
/* 2310 */             agg_value139 = agg_value146;
/* 2311 */           }
/* 2312 */         }
/* 2313 */         boolean agg_isNull112 = true;
/* 2314 */         double agg_value148 = -1.0;
/* 2315 */
/* 2316 */         boolean agg_isNull114 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 2317 */         double agg_value150 = agg_isNull114 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 2318 */         boolean agg_isNull113 = agg_isNull114;
/* 2319 */         double agg_value149 = agg_value150;
/* 2320 */         if (agg_isNull113) {
/* 2321 */           boolean agg_isNull115 = false;
/* 2322 */           double agg_value151 = -1.0;
/* 2323 */           if (!false) {
/* 2324 */             agg_value151 = (double) 0;
/* 2325 */           }
/* 2326 */           if (!agg_isNull115) {
/* 2327 */             agg_isNull113 = false;
/* 2328 */             agg_value149 = agg_value151;
/* 2329 */           }
/* 2330 */         }
/* 2331 */
/* 2332 */         if (!inputadapter_isNull14) {
/* 2333 */           agg_isNull112 = false; // resultCode could change nullability.
/* 2334 */           agg_value148 = agg_value149 + inputadapter_value14;
/* 2335 */
/* 2336 */         }
/* 2337 */         boolean agg_isNull111 = agg_isNull112;
/* 2338 */         double agg_value147 = agg_value148;
/* 2339 */         if (agg_isNull111) {
/* 2340 */           boolean agg_isNull118 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 2341 */           double agg_value154 = agg_isNull118 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 2342 */           if (!agg_isNull118) {
/* 2343 */             agg_isNull111 = false;
/* 2344 */             agg_value147 = agg_value154;
/* 2345 */           }
/* 2346 */         }
/* 2347 */         boolean agg_isNull120 = true;
/* 2348 */         double agg_value156 = -1.0;
/* 2349 */
/* 2350 */         boolean agg_isNull122 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 2351 */         double agg_value158 = agg_isNull122 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 2352 */         boolean agg_isNull121 = agg_isNull122;
/* 2353 */         double agg_value157 = agg_value158;
/* 2354 */         if (agg_isNull121) {
/* 2355 */           boolean agg_isNull123 = false;
/* 2356 */           double agg_value159 = -1.0;
/* 2357 */           if (!false) {
/* 2358 */             agg_value159 = (double) 0;
/* 2359 */           }
/* 2360 */           if (!agg_isNull123) {
/* 2361 */             agg_isNull121 = false;
/* 2362 */             agg_value157 = agg_value159;
/* 2363 */           }
/* 2364 */         }
/* 2365 */
/* 2366 */         if (!inputadapter_isNull15) {
/* 2367 */           agg_isNull120 = false; // resultCode could change nullability.
/* 2368 */           agg_value156 = agg_value157 + inputadapter_value15;
/* 2369 */
/* 2370 */         }
/* 2371 */         boolean agg_isNull119 = agg_isNull120;
/* 2372 */         double agg_value155 = agg_value156;
/* 2373 */         if (agg_isNull119) {
/* 2374 */           boolean agg_isNull126 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 2375 */           double agg_value162 = agg_isNull126 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 2376 */           if (!agg_isNull126) {
/* 2377 */             agg_isNull119 = false;
/* 2378 */             agg_value155 = agg_value162;
/* 2379 */           }
/* 2380 */         }
/* 2381 */         boolean agg_isNull128 = true;
/* 2382 */         double agg_value164 = -1.0;
/* 2383 */
/* 2384 */         boolean agg_isNull130 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 2385 */         double agg_value166 = agg_isNull130 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 2386 */         boolean agg_isNull129 = agg_isNull130;
/* 2387 */         double agg_value165 = agg_value166;
/* 2388 */         if (agg_isNull129) {
/* 2389 */           boolean agg_isNull131 = false;
/* 2390 */           double agg_value167 = -1.0;
/* 2391 */           if (!false) {
/* 2392 */             agg_value167 = (double) 0;
/* 2393 */           }
/* 2394 */           if (!agg_isNull131) {
/* 2395 */             agg_isNull129 = false;
/* 2396 */             agg_value165 = agg_value167;
/* 2397 */           }
/* 2398 */         }
/* 2399 */
/* 2400 */         if (!inputadapter_isNull16) {
/* 2401 */           agg_isNull128 = false; // resultCode could change nullability.
/* 2402 */           agg_value164 = agg_value165 + inputadapter_value16;
/* 2403 */
/* 2404 */         }
/* 2405 */         boolean agg_isNull127 = agg_isNull128;
/* 2406 */         double agg_value163 = agg_value164;
/* 2407 */         if (agg_isNull127) {
/* 2408 */           boolean agg_isNull134 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 2409 */           double agg_value170 = agg_isNull134 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 2410 */           if (!agg_isNull134) {
/* 2411 */             agg_isNull127 = false;
/* 2412 */             agg_value163 = agg_value170;
/* 2413 */           }
/* 2414 */         }
/* 2415 */         boolean agg_isNull136 = true;
/* 2416 */         double agg_value172 = -1.0;
/* 2417 */
/* 2418 */         boolean agg_isNull138 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 2419 */         double agg_value174 = agg_isNull138 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 2420 */         boolean agg_isNull137 = agg_isNull138;
/* 2421 */         double agg_value173 = agg_value174;
/* 2422 */         if (agg_isNull137) {
/* 2423 */           boolean agg_isNull139 = false;
/* 2424 */           double agg_value175 = -1.0;
/* 2425 */           if (!false) {
/* 2426 */             agg_value175 = (double) 0;
/* 2427 */           }
/* 2428 */           if (!agg_isNull139) {
/* 2429 */             agg_isNull137 = false;
/* 2430 */             agg_value173 = agg_value175;
/* 2431 */           }
/* 2432 */         }
/* 2433 */
/* 2434 */         if (!inputadapter_isNull17) {
/* 2435 */           agg_isNull136 = false; // resultCode could change nullability.
/* 2436 */           agg_value172 = agg_value173 + inputadapter_value17;
/* 2437 */
/* 2438 */         }
/* 2439 */         boolean agg_isNull135 = agg_isNull136;
/* 2440 */         double agg_value171 = agg_value172;
/* 2441 */         if (agg_isNull135) {
/* 2442 */           boolean agg_isNull142 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 2443 */           double agg_value178 = agg_isNull142 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 2444 */           if (!agg_isNull142) {
/* 2445 */             agg_isNull135 = false;
/* 2446 */             agg_value171 = agg_value178;
/* 2447 */           }
/* 2448 */         }
/* 2449 */         boolean agg_isNull144 = true;
/* 2450 */         double agg_value180 = -1.0;
/* 2451 */
/* 2452 */         boolean agg_isNull146 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 2453 */         double agg_value182 = agg_isNull146 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 2454 */         boolean agg_isNull145 = agg_isNull146;
/* 2455 */         double agg_value181 = agg_value182;
/* 2456 */         if (agg_isNull145) {
/* 2457 */           boolean agg_isNull147 = false;
/* 2458 */           double agg_value183 = -1.0;
/* 2459 */           if (!false) {
/* 2460 */             agg_value183 = (double) 0;
/* 2461 */           }
/* 2462 */           if (!agg_isNull147) {
/* 2463 */             agg_isNull145 = false;
/* 2464 */             agg_value181 = agg_value183;
/* 2465 */           }
/* 2466 */         }
/* 2467 */
/* 2468 */         if (!inputadapter_isNull18) {
/* 2469 */           agg_isNull144 = false; // resultCode could change nullability.
/* 2470 */           agg_value180 = agg_value181 + inputadapter_value18;
/* 2471 */
/* 2472 */         }
/* 2473 */         boolean agg_isNull143 = agg_isNull144;
/* 2474 */         double agg_value179 = agg_value180;
/* 2475 */         if (agg_isNull143) {
/* 2476 */           boolean agg_isNull150 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 2477 */           double agg_value186 = agg_isNull150 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 2478 */           if (!agg_isNull150) {
/* 2479 */             agg_isNull143 = false;
/* 2480 */             agg_value179 = agg_value186;
/* 2481 */           }
/* 2482 */         }
/* 2483 */         boolean agg_isNull152 = true;
/* 2484 */         double agg_value188 = -1.0;
/* 2485 */
/* 2486 */         boolean agg_isNull154 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 2487 */         double agg_value190 = agg_isNull154 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 2488 */         boolean agg_isNull153 = agg_isNull154;
/* 2489 */         double agg_value189 = agg_value190;
/* 2490 */         if (agg_isNull153) {
/* 2491 */           boolean agg_isNull155 = false;
/* 2492 */           double agg_value191 = -1.0;
/* 2493 */           if (!false) {
/* 2494 */             agg_value191 = (double) 0;
/* 2495 */           }
/* 2496 */           if (!agg_isNull155) {
/* 2497 */             agg_isNull153 = false;
/* 2498 */             agg_value189 = agg_value191;
/* 2499 */           }
/* 2500 */         }
/* 2501 */
/* 2502 */         if (!inputadapter_isNull19) {
/* 2503 */           agg_isNull152 = false; // resultCode could change nullability.
/* 2504 */           agg_value188 = agg_value189 + inputadapter_value19;
/* 2505 */
/* 2506 */         }
/* 2507 */         boolean agg_isNull151 = agg_isNull152;
/* 2508 */         double agg_value187 = agg_value188;
/* 2509 */         if (agg_isNull151) {
/* 2510 */           boolean agg_isNull158 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 2511 */           double agg_value194 = agg_isNull158 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 2512 */           if (!agg_isNull158) {
/* 2513 */             agg_isNull151 = false;
/* 2514 */             agg_value187 = agg_value194;
/* 2515 */           }
/* 2516 */         }
/* 2517 */         boolean agg_isNull160 = true;
/* 2518 */         double agg_value196 = -1.0;
/* 2519 */
/* 2520 */         boolean agg_isNull162 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 2521 */         double agg_value198 = agg_isNull162 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 2522 */         boolean agg_isNull161 = agg_isNull162;
/* 2523 */         double agg_value197 = agg_value198;
/* 2524 */         if (agg_isNull161) {
/* 2525 */           boolean agg_isNull163 = false;
/* 2526 */           double agg_value199 = -1.0;
/* 2527 */           if (!false) {
/* 2528 */             agg_value199 = (double) 0;
/* 2529 */           }
/* 2530 */           if (!agg_isNull163) {
/* 2531 */             agg_isNull161 = false;
/* 2532 */             agg_value197 = agg_value199;
/* 2533 */           }
/* 2534 */         }
/* 2535 */
/* 2536 */         boolean agg_isNull165 = false;
/* 2537 */         double agg_value201 = -1.0;
/* 2538 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2539 */           agg_isNull165 = true;
/* 2540 */         } else {
/* 2541 */           if (inputadapter_isNull8) {
/* 2542 */             agg_isNull165 = true;
/* 2543 */           } else {
/* 2544 */             agg_value201 = (double)(inputadapter_value8 / agg_value97);
/* 2545 */           }
/* 2546 */         }
/* 2547 */         if (!agg_isNull165) {
/* 2548 */           agg_isNull160 = false; // resultCode could change nullability.
/* 2549 */           agg_value196 = agg_value197 + agg_value201;
/* 2550 */
/* 2551 */         }
/* 2552 */         boolean agg_isNull159 = agg_isNull160;
/* 2553 */         double agg_value195 = agg_value196;
/* 2554 */         if (agg_isNull159) {
/* 2555 */           boolean agg_isNull167 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 2556 */           double agg_value203 = agg_isNull167 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 2557 */           if (!agg_isNull167) {
/* 2558 */             agg_isNull159 = false;
/* 2559 */             agg_value195 = agg_value203;
/* 2560 */           }
/* 2561 */         }
/* 2562 */         boolean agg_isNull169 = true;
/* 2563 */         double agg_value205 = -1.0;
/* 2564 */
/* 2565 */         boolean agg_isNull171 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 2566 */         double agg_value207 = agg_isNull171 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 2567 */         boolean agg_isNull170 = agg_isNull171;
/* 2568 */         double agg_value206 = agg_value207;
/* 2569 */         if (agg_isNull170) {
/* 2570 */           boolean agg_isNull172 = false;
/* 2571 */           double agg_value208 = -1.0;
/* 2572 */           if (!false) {
/* 2573 */             agg_value208 = (double) 0;
/* 2574 */           }
/* 2575 */           if (!agg_isNull172) {
/* 2576 */             agg_isNull170 = false;
/* 2577 */             agg_value206 = agg_value208;
/* 2578 */           }
/* 2579 */         }
/* 2580 */
/* 2581 */         boolean agg_isNull174 = false;
/* 2582 */         double agg_value210 = -1.0;
/* 2583 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2584 */           agg_isNull174 = true;
/* 2585 */         } else {
/* 2586 */           if (inputadapter_isNull9) {
/* 2587 */             agg_isNull174 = true;
/* 2588 */           } else {
/* 2589 */             agg_value210 = (double)(inputadapter_value9 / agg_value97);
/* 2590 */           }
/* 2591 */         }
/* 2592 */         if (!agg_isNull174) {
/* 2593 */           agg_isNull169 = false; // resultCode could change nullability.
/* 2594 */           agg_value205 = agg_value206 + agg_value210;
/* 2595 */
/* 2596 */         }
/* 2597 */         boolean agg_isNull168 = agg_isNull169;
/* 2598 */         double agg_value204 = agg_value205;
/* 2599 */         if (agg_isNull168) {
/* 2600 */           boolean agg_isNull176 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 2601 */           double agg_value212 = agg_isNull176 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 2602 */           if (!agg_isNull176) {
/* 2603 */             agg_isNull168 = false;
/* 2604 */             agg_value204 = agg_value212;
/* 2605 */           }
/* 2606 */         }
/* 2607 */         boolean agg_isNull178 = true;
/* 2608 */         double agg_value214 = -1.0;
/* 2609 */
/* 2610 */         boolean agg_isNull180 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 2611 */         double agg_value216 = agg_isNull180 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 2612 */         boolean agg_isNull179 = agg_isNull180;
/* 2613 */         double agg_value215 = agg_value216;
/* 2614 */         if (agg_isNull179) {
/* 2615 */           boolean agg_isNull181 = false;
/* 2616 */           double agg_value217 = -1.0;
/* 2617 */           if (!false) {
/* 2618 */             agg_value217 = (double) 0;
/* 2619 */           }
/* 2620 */           if (!agg_isNull181) {
/* 2621 */             agg_isNull179 = false;
/* 2622 */             agg_value215 = agg_value217;
/* 2623 */           }
/* 2624 */         }
/* 2625 */
/* 2626 */         boolean agg_isNull183 = false;
/* 2627 */         double agg_value219 = -1.0;
/* 2628 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2629 */           agg_isNull183 = true;
/* 2630 */         } else {
/* 2631 */           if (inputadapter_isNull10) {
/* 2632 */             agg_isNull183 = true;
/* 2633 */           } else {
/* 2634 */             agg_value219 = (double)(inputadapter_value10 / agg_value97);
/* 2635 */           }
/* 2636 */         }
/* 2637 */         if (!agg_isNull183) {
/* 2638 */           agg_isNull178 = false; // resultCode could change nullability.
/* 2639 */           agg_value214 = agg_value215 + agg_value219;
/* 2640 */
/* 2641 */         }
/* 2642 */         boolean agg_isNull177 = agg_isNull178;
/* 2643 */         double agg_value213 = agg_value214;
/* 2644 */         if (agg_isNull177) {
/* 2645 */           boolean agg_isNull185 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 2646 */           double agg_value221 = agg_isNull185 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 2647 */           if (!agg_isNull185) {
/* 2648 */             agg_isNull177 = false;
/* 2649 */             agg_value213 = agg_value221;
/* 2650 */           }
/* 2651 */         }
/* 2652 */         boolean agg_isNull187 = true;
/* 2653 */         double agg_value223 = -1.0;
/* 2654 */
/* 2655 */         boolean agg_isNull189 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 2656 */         double agg_value225 = agg_isNull189 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 2657 */         boolean agg_isNull188 = agg_isNull189;
/* 2658 */         double agg_value224 = agg_value225;
/* 2659 */         if (agg_isNull188) {
/* 2660 */           boolean agg_isNull190 = false;
/* 2661 */           double agg_value226 = -1.0;
/* 2662 */           if (!false) {
/* 2663 */             agg_value226 = (double) 0;
/* 2664 */           }
/* 2665 */           if (!agg_isNull190) {
/* 2666 */             agg_isNull188 = false;
/* 2667 */             agg_value224 = agg_value226;
/* 2668 */           }
/* 2669 */         }
/* 2670 */
/* 2671 */         boolean agg_isNull192 = false;
/* 2672 */         double agg_value228 = -1.0;
/* 2673 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2674 */           agg_isNull192 = true;
/* 2675 */         } else {
/* 2676 */           if (inputadapter_isNull11) {
/* 2677 */             agg_isNull192 = true;
/* 2678 */           } else {
/* 2679 */             agg_value228 = (double)(inputadapter_value11 / agg_value97);
/* 2680 */           }
/* 2681 */         }
/* 2682 */         if (!agg_isNull192) {
/* 2683 */           agg_isNull187 = false; // resultCode could change nullability.
/* 2684 */           agg_value223 = agg_value224 + agg_value228;
/* 2685 */
/* 2686 */         }
/* 2687 */         boolean agg_isNull186 = agg_isNull187;
/* 2688 */         double agg_value222 = agg_value223;
/* 2689 */         if (agg_isNull186) {
/* 2690 */           boolean agg_isNull194 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 2691 */           double agg_value230 = agg_isNull194 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 2692 */           if (!agg_isNull194) {
/* 2693 */             agg_isNull186 = false;
/* 2694 */             agg_value222 = agg_value230;
/* 2695 */           }
/* 2696 */         }
/* 2697 */         boolean agg_isNull196 = true;
/* 2698 */         double agg_value232 = -1.0;
/* 2699 */
/* 2700 */         boolean agg_isNull198 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 2701 */         double agg_value234 = agg_isNull198 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 2702 */         boolean agg_isNull197 = agg_isNull198;
/* 2703 */         double agg_value233 = agg_value234;
/* 2704 */         if (agg_isNull197) {
/* 2705 */           boolean agg_isNull199 = false;
/* 2706 */           double agg_value235 = -1.0;
/* 2707 */           if (!false) {
/* 2708 */             agg_value235 = (double) 0;
/* 2709 */           }
/* 2710 */           if (!agg_isNull199) {
/* 2711 */             agg_isNull197 = false;
/* 2712 */             agg_value233 = agg_value235;
/* 2713 */           }
/* 2714 */         }
/* 2715 */
/* 2716 */         boolean agg_isNull201 = false;
/* 2717 */         double agg_value237 = -1.0;
/* 2718 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2719 */           agg_isNull201 = true;
/* 2720 */         } else {
/* 2721 */           if (inputadapter_isNull12) {
/* 2722 */             agg_isNull201 = true;
/* 2723 */           } else {
/* 2724 */             agg_value237 = (double)(inputadapter_value12 / agg_value97);
/* 2725 */           }
/* 2726 */         }
/* 2727 */         if (!agg_isNull201) {
/* 2728 */           agg_isNull196 = false; // resultCode could change nullability.
/* 2729 */           agg_value232 = agg_value233 + agg_value237;
/* 2730 */
/* 2731 */         }
/* 2732 */         boolean agg_isNull195 = agg_isNull196;
/* 2733 */         double agg_value231 = agg_value232;
/* 2734 */         if (agg_isNull195) {
/* 2735 */           boolean agg_isNull203 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 2736 */           double agg_value239 = agg_isNull203 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 2737 */           if (!agg_isNull203) {
/* 2738 */             agg_isNull195 = false;
/* 2739 */             agg_value231 = agg_value239;
/* 2740 */           }
/* 2741 */         }
/* 2742 */         boolean agg_isNull205 = true;
/* 2743 */         double agg_value241 = -1.0;
/* 2744 */
/* 2745 */         boolean agg_isNull207 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 2746 */         double agg_value243 = agg_isNull207 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 2747 */         boolean agg_isNull206 = agg_isNull207;
/* 2748 */         double agg_value242 = agg_value243;
/* 2749 */         if (agg_isNull206) {
/* 2750 */           boolean agg_isNull208 = false;
/* 2751 */           double agg_value244 = -1.0;
/* 2752 */           if (!false) {
/* 2753 */             agg_value244 = (double) 0;
/* 2754 */           }
/* 2755 */           if (!agg_isNull208) {
/* 2756 */             agg_isNull206 = false;
/* 2757 */             agg_value242 = agg_value244;
/* 2758 */           }
/* 2759 */         }
/* 2760 */
/* 2761 */         boolean agg_isNull210 = false;
/* 2762 */         double agg_value246 = -1.0;
/* 2763 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2764 */           agg_isNull210 = true;
/* 2765 */         } else {
/* 2766 */           if (inputadapter_isNull13) {
/* 2767 */             agg_isNull210 = true;
/* 2768 */           } else {
/* 2769 */             agg_value246 = (double)(inputadapter_value13 / agg_value97);
/* 2770 */           }
/* 2771 */         }
/* 2772 */         if (!agg_isNull210) {
/* 2773 */           agg_isNull205 = false; // resultCode could change nullability.
/* 2774 */           agg_value241 = agg_value242 + agg_value246;
/* 2775 */
/* 2776 */         }
/* 2777 */         boolean agg_isNull204 = agg_isNull205;
/* 2778 */         double agg_value240 = agg_value241;
/* 2779 */         if (agg_isNull204) {
/* 2780 */           boolean agg_isNull212 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 2781 */           double agg_value248 = agg_isNull212 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 2782 */           if (!agg_isNull212) {
/* 2783 */             agg_isNull204 = false;
/* 2784 */             agg_value240 = agg_value248;
/* 2785 */           }
/* 2786 */         }
/* 2787 */         boolean agg_isNull214 = true;
/* 2788 */         double agg_value250 = -1.0;
/* 2789 */
/* 2790 */         boolean agg_isNull216 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 2791 */         double agg_value252 = agg_isNull216 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 2792 */         boolean agg_isNull215 = agg_isNull216;
/* 2793 */         double agg_value251 = agg_value252;
/* 2794 */         if (agg_isNull215) {
/* 2795 */           boolean agg_isNull217 = false;
/* 2796 */           double agg_value253 = -1.0;
/* 2797 */           if (!false) {
/* 2798 */             agg_value253 = (double) 0;
/* 2799 */           }
/* 2800 */           if (!agg_isNull217) {
/* 2801 */             agg_isNull215 = false;
/* 2802 */             agg_value251 = agg_value253;
/* 2803 */           }
/* 2804 */         }
/* 2805 */
/* 2806 */         boolean agg_isNull219 = false;
/* 2807 */         double agg_value255 = -1.0;
/* 2808 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2809 */           agg_isNull219 = true;
/* 2810 */         } else {
/* 2811 */           if (inputadapter_isNull14) {
/* 2812 */             agg_isNull219 = true;
/* 2813 */           } else {
/* 2814 */             agg_value255 = (double)(inputadapter_value14 / agg_value97);
/* 2815 */           }
/* 2816 */         }
/* 2817 */         if (!agg_isNull219) {
/* 2818 */           agg_isNull214 = false; // resultCode could change nullability.
/* 2819 */           agg_value250 = agg_value251 + agg_value255;
/* 2820 */
/* 2821 */         }
/* 2822 */         boolean agg_isNull213 = agg_isNull214;
/* 2823 */         double agg_value249 = agg_value250;
/* 2824 */         if (agg_isNull213) {
/* 2825 */           boolean agg_isNull221 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 2826 */           double agg_value257 = agg_isNull221 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 2827 */           if (!agg_isNull221) {
/* 2828 */             agg_isNull213 = false;
/* 2829 */             agg_value249 = agg_value257;
/* 2830 */           }
/* 2831 */         }
/* 2832 */         boolean agg_isNull223 = true;
/* 2833 */         double agg_value259 = -1.0;
/* 2834 */
/* 2835 */         boolean agg_isNull225 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 2836 */         double agg_value261 = agg_isNull225 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 2837 */         boolean agg_isNull224 = agg_isNull225;
/* 2838 */         double agg_value260 = agg_value261;
/* 2839 */         if (agg_isNull224) {
/* 2840 */           boolean agg_isNull226 = false;
/* 2841 */           double agg_value262 = -1.0;
/* 2842 */           if (!false) {
/* 2843 */             agg_value262 = (double) 0;
/* 2844 */           }
/* 2845 */           if (!agg_isNull226) {
/* 2846 */             agg_isNull224 = false;
/* 2847 */             agg_value260 = agg_value262;
/* 2848 */           }
/* 2849 */         }
/* 2850 */
/* 2851 */         boolean agg_isNull228 = false;
/* 2852 */         double agg_value264 = -1.0;
/* 2853 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2854 */           agg_isNull228 = true;
/* 2855 */         } else {
/* 2856 */           if (inputadapter_isNull15) {
/* 2857 */             agg_isNull228 = true;
/* 2858 */           } else {
/* 2859 */             agg_value264 = (double)(inputadapter_value15 / agg_value97);
/* 2860 */           }
/* 2861 */         }
/* 2862 */         if (!agg_isNull228) {
/* 2863 */           agg_isNull223 = false; // resultCode could change nullability.
/* 2864 */           agg_value259 = agg_value260 + agg_value264;
/* 2865 */
/* 2866 */         }
/* 2867 */         boolean agg_isNull222 = agg_isNull223;
/* 2868 */         double agg_value258 = agg_value259;
/* 2869 */         if (agg_isNull222) {
/* 2870 */           boolean agg_isNull230 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 2871 */           double agg_value266 = agg_isNull230 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 2872 */           if (!agg_isNull230) {
/* 2873 */             agg_isNull222 = false;
/* 2874 */             agg_value258 = agg_value266;
/* 2875 */           }
/* 2876 */         }
/* 2877 */         boolean agg_isNull232 = true;
/* 2878 */         double agg_value268 = -1.0;
/* 2879 */
/* 2880 */         boolean agg_isNull234 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 2881 */         double agg_value270 = agg_isNull234 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 2882 */         boolean agg_isNull233 = agg_isNull234;
/* 2883 */         double agg_value269 = agg_value270;
/* 2884 */         if (agg_isNull233) {
/* 2885 */           boolean agg_isNull235 = false;
/* 2886 */           double agg_value271 = -1.0;
/* 2887 */           if (!false) {
/* 2888 */             agg_value271 = (double) 0;
/* 2889 */           }
/* 2890 */           if (!agg_isNull235) {
/* 2891 */             agg_isNull233 = false;
/* 2892 */             agg_value269 = agg_value271;
/* 2893 */           }
/* 2894 */         }
/* 2895 */
/* 2896 */         boolean agg_isNull237 = false;
/* 2897 */         double agg_value273 = -1.0;
/* 2898 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2899 */           agg_isNull237 = true;
/* 2900 */         } else {
/* 2901 */           if (inputadapter_isNull16) {
/* 2902 */             agg_isNull237 = true;
/* 2903 */           } else {
/* 2904 */             agg_value273 = (double)(inputadapter_value16 / agg_value97);
/* 2905 */           }
/* 2906 */         }
/* 2907 */         if (!agg_isNull237) {
/* 2908 */           agg_isNull232 = false; // resultCode could change nullability.
/* 2909 */           agg_value268 = agg_value269 + agg_value273;
/* 2910 */
/* 2911 */         }
/* 2912 */         boolean agg_isNull231 = agg_isNull232;
/* 2913 */         double agg_value267 = agg_value268;
/* 2914 */         if (agg_isNull231) {
/* 2915 */           boolean agg_isNull239 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 2916 */           double agg_value275 = agg_isNull239 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 2917 */           if (!agg_isNull239) {
/* 2918 */             agg_isNull231 = false;
/* 2919 */             agg_value267 = agg_value275;
/* 2920 */           }
/* 2921 */         }
/* 2922 */         boolean agg_isNull241 = true;
/* 2923 */         double agg_value277 = -1.0;
/* 2924 */
/* 2925 */         boolean agg_isNull243 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 2926 */         double agg_value279 = agg_isNull243 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 2927 */         boolean agg_isNull242 = agg_isNull243;
/* 2928 */         double agg_value278 = agg_value279;
/* 2929 */         if (agg_isNull242) {
/* 2930 */           boolean agg_isNull244 = false;
/* 2931 */           double agg_value280 = -1.0;
/* 2932 */           if (!false) {
/* 2933 */             agg_value280 = (double) 0;
/* 2934 */           }
/* 2935 */           if (!agg_isNull244) {
/* 2936 */             agg_isNull242 = false;
/* 2937 */             agg_value278 = agg_value280;
/* 2938 */           }
/* 2939 */         }
/* 2940 */
/* 2941 */         boolean agg_isNull246 = false;
/* 2942 */         double agg_value282 = -1.0;
/* 2943 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2944 */           agg_isNull246 = true;
/* 2945 */         } else {
/* 2946 */           if (inputadapter_isNull17) {
/* 2947 */             agg_isNull246 = true;
/* 2948 */           } else {
/* 2949 */             agg_value282 = (double)(inputadapter_value17 / agg_value97);
/* 2950 */           }
/* 2951 */         }
/* 2952 */         if (!agg_isNull246) {
/* 2953 */           agg_isNull241 = false; // resultCode could change nullability.
/* 2954 */           agg_value277 = agg_value278 + agg_value282;
/* 2955 */
/* 2956 */         }
/* 2957 */         boolean agg_isNull240 = agg_isNull241;
/* 2958 */         double agg_value276 = agg_value277;
/* 2959 */         if (agg_isNull240) {
/* 2960 */           boolean agg_isNull248 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 2961 */           double agg_value284 = agg_isNull248 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 2962 */           if (!agg_isNull248) {
/* 2963 */             agg_isNull240 = false;
/* 2964 */             agg_value276 = agg_value284;
/* 2965 */           }
/* 2966 */         }
/* 2967 */         boolean agg_isNull250 = true;
/* 2968 */         double agg_value286 = -1.0;
/* 2969 */
/* 2970 */         boolean agg_isNull252 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 2971 */         double agg_value288 = agg_isNull252 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 2972 */         boolean agg_isNull251 = agg_isNull252;
/* 2973 */         double agg_value287 = agg_value288;
/* 2974 */         if (agg_isNull251) {
/* 2975 */           boolean agg_isNull253 = false;
/* 2976 */           double agg_value289 = -1.0;
/* 2977 */           if (!false) {
/* 2978 */             agg_value289 = (double) 0;
/* 2979 */           }
/* 2980 */           if (!agg_isNull253) {
/* 2981 */             agg_isNull251 = false;
/* 2982 */             agg_value287 = agg_value289;
/* 2983 */           }
/* 2984 */         }
/* 2985 */
/* 2986 */         boolean agg_isNull255 = false;
/* 2987 */         double agg_value291 = -1.0;
/* 2988 */         if (agg_isNull61 || agg_value97 == 0) {
/* 2989 */           agg_isNull255 = true;
/* 2990 */         } else {
/* 2991 */           if (inputadapter_isNull18) {
/* 2992 */             agg_isNull255 = true;
/* 2993 */           } else {
/* 2994 */             agg_value291 = (double)(inputadapter_value18 / agg_value97);
/* 2995 */           }
/* 2996 */         }
/* 2997 */         if (!agg_isNull255) {
/* 2998 */           agg_isNull250 = false; // resultCode could change nullability.
/* 2999 */           agg_value286 = agg_value287 + agg_value291;
/* 3000 */
/* 3001 */         }
/* 3002 */         boolean agg_isNull249 = agg_isNull250;
/* 3003 */         double agg_value285 = agg_value286;
/* 3004 */         if (agg_isNull249) {
/* 3005 */           boolean agg_isNull257 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 3006 */           double agg_value293 = agg_isNull257 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 3007 */           if (!agg_isNull257) {
/* 3008 */             agg_isNull249 = false;
/* 3009 */             agg_value285 = agg_value293;
/* 3010 */           }
/* 3011 */         }
/* 3012 */         boolean agg_isNull259 = true;
/* 3013 */         double agg_value295 = -1.0;
/* 3014 */
/* 3015 */         boolean agg_isNull261 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 3016 */         double agg_value297 = agg_isNull261 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 3017 */         boolean agg_isNull260 = agg_isNull261;
/* 3018 */         double agg_value296 = agg_value297;
/* 3019 */         if (agg_isNull260) {
/* 3020 */           boolean agg_isNull262 = false;
/* 3021 */           double agg_value298 = -1.0;
/* 3022 */           if (!false) {
/* 3023 */             agg_value298 = (double) 0;
/* 3024 */           }
/* 3025 */           if (!agg_isNull262) {
/* 3026 */             agg_isNull260 = false;
/* 3027 */             agg_value296 = agg_value298;
/* 3028 */           }
/* 3029 */         }
/* 3030 */
/* 3031 */         boolean agg_isNull264 = false;
/* 3032 */         double agg_value300 = -1.0;
/* 3033 */         if (agg_isNull61 || agg_value97 == 0) {
/* 3034 */           agg_isNull264 = true;
/* 3035 */         } else {
/* 3036 */           if (inputadapter_isNull19) {
/* 3037 */             agg_isNull264 = true;
/* 3038 */           } else {
/* 3039 */             agg_value300 = (double)(inputadapter_value19 / agg_value97);
/* 3040 */           }
/* 3041 */         }
/* 3042 */         if (!agg_isNull264) {
/* 3043 */           agg_isNull259 = false; // resultCode could change nullability.
/* 3044 */           agg_value295 = agg_value296 + agg_value300;
/* 3045 */
/* 3046 */         }
/* 3047 */         boolean agg_isNull258 = agg_isNull259;
/* 3048 */         double agg_value294 = agg_value295;
/* 3049 */         if (agg_isNull258) {
/* 3050 */           boolean agg_isNull266 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 3051 */           double agg_value302 = agg_isNull266 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 3052 */           if (!agg_isNull266) {
/* 3053 */             agg_isNull258 = false;
/* 3054 */             agg_value294 = agg_value302;
/* 3055 */           }
/* 3056 */         }
/* 3057 */         boolean agg_isNull268 = true;
/* 3058 */         double agg_value304 = -1.0;
/* 3059 */
/* 3060 */         boolean agg_isNull270 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 3061 */         double agg_value306 = agg_isNull270 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 3062 */         boolean agg_isNull269 = agg_isNull270;
/* 3063 */         double agg_value305 = agg_value306;
/* 3064 */         if (agg_isNull269) {
/* 3065 */           boolean agg_isNull271 = false;
/* 3066 */           double agg_value307 = -1.0;
/* 3067 */           if (!false) {
/* 3068 */             agg_value307 = (double) 0;
/* 3069 */           }
/* 3070 */           if (!agg_isNull271) {
/* 3071 */             agg_isNull269 = false;
/* 3072 */             agg_value305 = agg_value307;
/* 3073 */           }
/* 3074 */         }
/* 3075 */
/* 3076 */         if (!inputadapter_isNull20) {
/* 3077 */           agg_isNull268 = false; // resultCode could change nullability.
/* 3078 */           agg_value304 = agg_value305 + inputadapter_value20;
/* 3079 */
/* 3080 */         }
/* 3081 */         boolean agg_isNull267 = agg_isNull268;
/* 3082 */         double agg_value303 = agg_value304;
/* 3083 */         if (agg_isNull267) {
/* 3084 */           boolean agg_isNull274 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 3085 */           double agg_value310 = agg_isNull274 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 3086 */           if (!agg_isNull274) {
/* 3087 */             agg_isNull267 = false;
/* 3088 */             agg_value303 = agg_value310;
/* 3089 */           }
/* 3090 */         }
/* 3091 */         boolean agg_isNull276 = true;
/* 3092 */         double agg_value312 = -1.0;
/* 3093 */
/* 3094 */         boolean agg_isNull278 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 3095 */         double agg_value314 = agg_isNull278 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 3096 */         boolean agg_isNull277 = agg_isNull278;
/* 3097 */         double agg_value313 = agg_value314;
/* 3098 */         if (agg_isNull277) {
/* 3099 */           boolean agg_isNull279 = false;
/* 3100 */           double agg_value315 = -1.0;
/* 3101 */           if (!false) {
/* 3102 */             agg_value315 = (double) 0;
/* 3103 */           }
/* 3104 */           if (!agg_isNull279) {
/* 3105 */             agg_isNull277 = false;
/* 3106 */             agg_value313 = agg_value315;
/* 3107 */           }
/* 3108 */         }
/* 3109 */
/* 3110 */         if (!inputadapter_isNull21) {
/* 3111 */           agg_isNull276 = false; // resultCode could change nullability.
/* 3112 */           agg_value312 = agg_value313 + inputadapter_value21;
/* 3113 */
/* 3114 */         }
/* 3115 */         boolean agg_isNull275 = agg_isNull276;
/* 3116 */         double agg_value311 = agg_value312;
/* 3117 */         if (agg_isNull275) {
/* 3118 */           boolean agg_isNull282 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 3119 */           double agg_value318 = agg_isNull282 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 3120 */           if (!agg_isNull282) {
/* 3121 */             agg_isNull275 = false;
/* 3122 */             agg_value311 = agg_value318;
/* 3123 */           }
/* 3124 */         }
/* 3125 */         boolean agg_isNull284 = true;
/* 3126 */         double agg_value320 = -1.0;
/* 3127 */
/* 3128 */         boolean agg_isNull286 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 3129 */         double agg_value322 = agg_isNull286 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 3130 */         boolean agg_isNull285 = agg_isNull286;
/* 3131 */         double agg_value321 = agg_value322;
/* 3132 */         if (agg_isNull285) {
/* 3133 */           boolean agg_isNull287 = false;
/* 3134 */           double agg_value323 = -1.0;
/* 3135 */           if (!false) {
/* 3136 */             agg_value323 = (double) 0;
/* 3137 */           }
/* 3138 */           if (!agg_isNull287) {
/* 3139 */             agg_isNull285 = false;
/* 3140 */             agg_value321 = agg_value323;
/* 3141 */           }
/* 3142 */         }
/* 3143 */
/* 3144 */         if (!inputadapter_isNull22) {
/* 3145 */           agg_isNull284 = false; // resultCode could change nullability.
/* 3146 */           agg_value320 = agg_value321 + inputadapter_value22;
/* 3147 */
/* 3148 */         }
/* 3149 */         boolean agg_isNull283 = agg_isNull284;
/* 3150 */         double agg_value319 = agg_value320;
/* 3151 */         if (agg_isNull283) {
/* 3152 */           boolean agg_isNull290 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 3153 */           double agg_value326 = agg_isNull290 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 3154 */           if (!agg_isNull290) {
/* 3155 */             agg_isNull283 = false;
/* 3156 */             agg_value319 = agg_value326;
/* 3157 */           }
/* 3158 */         }
/* 3159 */         boolean agg_isNull292 = true;
/* 3160 */         double agg_value328 = -1.0;
/* 3161 */
/* 3162 */         boolean agg_isNull294 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 3163 */         double agg_value330 = agg_isNull294 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 3164 */         boolean agg_isNull293 = agg_isNull294;
/* 3165 */         double agg_value329 = agg_value330;
/* 3166 */         if (agg_isNull293) {
/* 3167 */           boolean agg_isNull295 = false;
/* 3168 */           double agg_value331 = -1.0;
/* 3169 */           if (!false) {
/* 3170 */             agg_value331 = (double) 0;
/* 3171 */           }
/* 3172 */           if (!agg_isNull295) {
/* 3173 */             agg_isNull293 = false;
/* 3174 */             agg_value329 = agg_value331;
/* 3175 */           }
/* 3176 */         }
/* 3177 */
/* 3178 */         if (!inputadapter_isNull23) {
/* 3179 */           agg_isNull292 = false; // resultCode could change nullability.
/* 3180 */           agg_value328 = agg_value329 + inputadapter_value23;
/* 3181 */
/* 3182 */         }
/* 3183 */         boolean agg_isNull291 = agg_isNull292;
/* 3184 */         double agg_value327 = agg_value328;
/* 3185 */         if (agg_isNull291) {
/* 3186 */           boolean agg_isNull298 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 3187 */           double agg_value334 = agg_isNull298 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 3188 */           if (!agg_isNull298) {
/* 3189 */             agg_isNull291 = false;
/* 3190 */             agg_value327 = agg_value334;
/* 3191 */           }
/* 3192 */         }
/* 3193 */         boolean agg_isNull300 = true;
/* 3194 */         double agg_value336 = -1.0;
/* 3195 */
/* 3196 */         boolean agg_isNull302 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 3197 */         double agg_value338 = agg_isNull302 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 3198 */         boolean agg_isNull301 = agg_isNull302;
/* 3199 */         double agg_value337 = agg_value338;
/* 3200 */         if (agg_isNull301) {
/* 3201 */           boolean agg_isNull303 = false;
/* 3202 */           double agg_value339 = -1.0;
/* 3203 */           if (!false) {
/* 3204 */             agg_value339 = (double) 0;
/* 3205 */           }
/* 3206 */           if (!agg_isNull303) {
/* 3207 */             agg_isNull301 = false;
/* 3208 */             agg_value337 = agg_value339;
/* 3209 */           }
/* 3210 */         }
/* 3211 */
/* 3212 */         if (!inputadapter_isNull24) {
/* 3213 */           agg_isNull300 = false; // resultCode could change nullability.
/* 3214 */           agg_value336 = agg_value337 + inputadapter_value24;
/* 3215 */
/* 3216 */         }
/* 3217 */         boolean agg_isNull299 = agg_isNull300;
/* 3218 */         double agg_value335 = agg_value336;
/* 3219 */         if (agg_isNull299) {
/* 3220 */           boolean agg_isNull306 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 3221 */           double agg_value342 = agg_isNull306 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 3222 */           if (!agg_isNull306) {
/* 3223 */             agg_isNull299 = false;
/* 3224 */             agg_value335 = agg_value342;
/* 3225 */           }
/* 3226 */         }
/* 3227 */         boolean agg_isNull308 = true;
/* 3228 */         double agg_value344 = -1.0;
/* 3229 */
/* 3230 */         boolean agg_isNull310 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 3231 */         double agg_value346 = agg_isNull310 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 3232 */         boolean agg_isNull309 = agg_isNull310;
/* 3233 */         double agg_value345 = agg_value346;
/* 3234 */         if (agg_isNull309) {
/* 3235 */           boolean agg_isNull311 = false;
/* 3236 */           double agg_value347 = -1.0;
/* 3237 */           if (!false) {
/* 3238 */             agg_value347 = (double) 0;
/* 3239 */           }
/* 3240 */           if (!agg_isNull311) {
/* 3241 */             agg_isNull309 = false;
/* 3242 */             agg_value345 = agg_value347;
/* 3243 */           }
/* 3244 */         }
/* 3245 */
/* 3246 */         if (!inputadapter_isNull25) {
/* 3247 */           agg_isNull308 = false; // resultCode could change nullability.
/* 3248 */           agg_value344 = agg_value345 + inputadapter_value25;
/* 3249 */
/* 3250 */         }
/* 3251 */         boolean agg_isNull307 = agg_isNull308;
/* 3252 */         double agg_value343 = agg_value344;
/* 3253 */         if (agg_isNull307) {
/* 3254 */           boolean agg_isNull314 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 3255 */           double agg_value350 = agg_isNull314 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 3256 */           if (!agg_isNull314) {
/* 3257 */             agg_isNull307 = false;
/* 3258 */             agg_value343 = agg_value350;
/* 3259 */           }
/* 3260 */         }
/* 3261 */         boolean agg_isNull316 = true;
/* 3262 */         double agg_value352 = -1.0;
/* 3263 */
/* 3264 */         boolean agg_isNull318 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 3265 */         double agg_value354 = agg_isNull318 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 3266 */         boolean agg_isNull317 = agg_isNull318;
/* 3267 */         double agg_value353 = agg_value354;
/* 3268 */         if (agg_isNull317) {
/* 3269 */           boolean agg_isNull319 = false;
/* 3270 */           double agg_value355 = -1.0;
/* 3271 */           if (!false) {
/* 3272 */             agg_value355 = (double) 0;
/* 3273 */           }
/* 3274 */           if (!agg_isNull319) {
/* 3275 */             agg_isNull317 = false;
/* 3276 */             agg_value353 = agg_value355;
/* 3277 */           }
/* 3278 */         }
/* 3279 */
/* 3280 */         if (!inputadapter_isNull26) {
/* 3281 */           agg_isNull316 = false; // resultCode could change nullability.
/* 3282 */           agg_value352 = agg_value353 + inputadapter_value26;
/* 3283 */
/* 3284 */         }
/* 3285 */         boolean agg_isNull315 = agg_isNull316;
/* 3286 */         double agg_value351 = agg_value352;
/* 3287 */         if (agg_isNull315) {
/* 3288 */           boolean agg_isNull322 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 3289 */           double agg_value358 = agg_isNull322 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 3290 */           if (!agg_isNull322) {
/* 3291 */             agg_isNull315 = false;
/* 3292 */             agg_value351 = agg_value358;
/* 3293 */           }
/* 3294 */         }
/* 3295 */         boolean agg_isNull324 = true;
/* 3296 */         double agg_value360 = -1.0;
/* 3297 */
/* 3298 */         boolean agg_isNull326 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 3299 */         double agg_value362 = agg_isNull326 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 3300 */         boolean agg_isNull325 = agg_isNull326;
/* 3301 */         double agg_value361 = agg_value362;
/* 3302 */         if (agg_isNull325) {
/* 3303 */           boolean agg_isNull327 = false;
/* 3304 */           double agg_value363 = -1.0;
/* 3305 */           if (!false) {
/* 3306 */             agg_value363 = (double) 0;
/* 3307 */           }
/* 3308 */           if (!agg_isNull327) {
/* 3309 */             agg_isNull325 = false;
/* 3310 */             agg_value361 = agg_value363;
/* 3311 */           }
/* 3312 */         }
/* 3313 */
/* 3314 */         if (!inputadapter_isNull27) {
/* 3315 */           agg_isNull324 = false; // resultCode could change nullability.
/* 3316 */           agg_value360 = agg_value361 + inputadapter_value27;
/* 3317 */
/* 3318 */         }
/* 3319 */         boolean agg_isNull323 = agg_isNull324;
/* 3320 */         double agg_value359 = agg_value360;
/* 3321 */         if (agg_isNull323) {
/* 3322 */           boolean agg_isNull330 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 3323 */           double agg_value366 = agg_isNull330 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 3324 */           if (!agg_isNull330) {
/* 3325 */             agg_isNull323 = false;
/* 3326 */             agg_value359 = agg_value366;
/* 3327 */           }
/* 3328 */         }
/* 3329 */         boolean agg_isNull332 = true;
/* 3330 */         double agg_value368 = -1.0;
/* 3331 */
/* 3332 */         boolean agg_isNull334 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 3333 */         double agg_value370 = agg_isNull334 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 3334 */         boolean agg_isNull333 = agg_isNull334;
/* 3335 */         double agg_value369 = agg_value370;
/* 3336 */         if (agg_isNull333) {
/* 3337 */           boolean agg_isNull335 = false;
/* 3338 */           double agg_value371 = -1.0;
/* 3339 */           if (!false) {
/* 3340 */             agg_value371 = (double) 0;
/* 3341 */           }
/* 3342 */           if (!agg_isNull335) {
/* 3343 */             agg_isNull333 = false;
/* 3344 */             agg_value369 = agg_value371;
/* 3345 */           }
/* 3346 */         }
/* 3347 */
/* 3348 */         if (!inputadapter_isNull28) {
/* 3349 */           agg_isNull332 = false; // resultCode could change nullability.
/* 3350 */           agg_value368 = agg_value369 + inputadapter_value28;
/* 3351 */
/* 3352 */         }
/* 3353 */         boolean agg_isNull331 = agg_isNull332;
/* 3354 */         double agg_value367 = agg_value368;
/* 3355 */         if (agg_isNull331) {
/* 3356 */           boolean agg_isNull338 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 3357 */           double agg_value374 = agg_isNull338 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 3358 */           if (!agg_isNull338) {
/* 3359 */             agg_isNull331 = false;
/* 3360 */             agg_value367 = agg_value374;
/* 3361 */           }
/* 3362 */         }
/* 3363 */         boolean agg_isNull340 = true;
/* 3364 */         double agg_value376 = -1.0;
/* 3365 */
/* 3366 */         boolean agg_isNull342 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 3367 */         double agg_value378 = agg_isNull342 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 3368 */         boolean agg_isNull341 = agg_isNull342;
/* 3369 */         double agg_value377 = agg_value378;
/* 3370 */         if (agg_isNull341) {
/* 3371 */           boolean agg_isNull343 = false;
/* 3372 */           double agg_value379 = -1.0;
/* 3373 */           if (!false) {
/* 3374 */             agg_value379 = (double) 0;
/* 3375 */           }
/* 3376 */           if (!agg_isNull343) {
/* 3377 */             agg_isNull341 = false;
/* 3378 */             agg_value377 = agg_value379;
/* 3379 */           }
/* 3380 */         }
/* 3381 */
/* 3382 */         if (!inputadapter_isNull29) {
/* 3383 */           agg_isNull340 = false; // resultCode could change nullability.
/* 3384 */           agg_value376 = agg_value377 + inputadapter_value29;
/* 3385 */
/* 3386 */         }
/* 3387 */         boolean agg_isNull339 = agg_isNull340;
/* 3388 */         double agg_value375 = agg_value376;
/* 3389 */         if (agg_isNull339) {
/* 3390 */           boolean agg_isNull346 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 3391 */           double agg_value382 = agg_isNull346 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 3392 */           if (!agg_isNull346) {
/* 3393 */             agg_isNull339 = false;
/* 3394 */             agg_value375 = agg_value382;
/* 3395 */           }
/* 3396 */         }
/* 3397 */         boolean agg_isNull348 = true;
/* 3398 */         double agg_value384 = -1.0;
/* 3399 */
/* 3400 */         boolean agg_isNull350 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 3401 */         double agg_value386 = agg_isNull350 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 3402 */         boolean agg_isNull349 = agg_isNull350;
/* 3403 */         double agg_value385 = agg_value386;
/* 3404 */         if (agg_isNull349) {
/* 3405 */           boolean agg_isNull351 = false;
/* 3406 */           double agg_value387 = -1.0;
/* 3407 */           if (!false) {
/* 3408 */             agg_value387 = (double) 0;
/* 3409 */           }
/* 3410 */           if (!agg_isNull351) {
/* 3411 */             agg_isNull349 = false;
/* 3412 */             agg_value385 = agg_value387;
/* 3413 */           }
/* 3414 */         }
/* 3415 */
/* 3416 */         if (!inputadapter_isNull30) {
/* 3417 */           agg_isNull348 = false; // resultCode could change nullability.
/* 3418 */           agg_value384 = agg_value385 + inputadapter_value30;
/* 3419 */
/* 3420 */         }
/* 3421 */         boolean agg_isNull347 = agg_isNull348;
/* 3422 */         double agg_value383 = agg_value384;
/* 3423 */         if (agg_isNull347) {
/* 3424 */           boolean agg_isNull354 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 3425 */           double agg_value390 = agg_isNull354 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 3426 */           if (!agg_isNull354) {
/* 3427 */             agg_isNull347 = false;
/* 3428 */             agg_value383 = agg_value390;
/* 3429 */           }
/* 3430 */         }
/* 3431 */         boolean agg_isNull356 = true;
/* 3432 */         double agg_value392 = -1.0;
/* 3433 */
/* 3434 */         boolean agg_isNull358 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 3435 */         double agg_value394 = agg_isNull358 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 3436 */         boolean agg_isNull357 = agg_isNull358;
/* 3437 */         double agg_value393 = agg_value394;
/* 3438 */         if (agg_isNull357) {
/* 3439 */           boolean agg_isNull359 = false;
/* 3440 */           double agg_value395 = -1.0;
/* 3441 */           if (!false) {
/* 3442 */             agg_value395 = (double) 0;
/* 3443 */           }
/* 3444 */           if (!agg_isNull359) {
/* 3445 */             agg_isNull357 = false;
/* 3446 */             agg_value393 = agg_value395;
/* 3447 */           }
/* 3448 */         }
/* 3449 */
/* 3450 */         if (!inputadapter_isNull31) {
/* 3451 */           agg_isNull356 = false; // resultCode could change nullability.
/* 3452 */           agg_value392 = agg_value393 + inputadapter_value31;
/* 3453 */
/* 3454 */         }
/* 3455 */         boolean agg_isNull355 = agg_isNull356;
/* 3456 */         double agg_value391 = agg_value392;
/* 3457 */         if (agg_isNull355) {
/* 3458 */           boolean agg_isNull362 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 3459 */           double agg_value398 = agg_isNull362 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 3460 */           if (!agg_isNull362) {
/* 3461 */             agg_isNull355 = false;
/* 3462 */             agg_value391 = agg_value398;
/* 3463 */           }
/* 3464 */         }
/* 3465 */         // update unsafe row buffer
/* 3466 */         if (!agg_isNull63) {
/* 3467 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value99);
/* 3468 */         } else {
/* 3469 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 3470 */         }
/* 3471 */
/* 3472 */         if (!agg_isNull71) {
/* 3473 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value107);
/* 3474 */         } else {
/* 3475 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 3476 */         }
/* 3477 */
/* 3478 */         if (!agg_isNull79) {
/* 3479 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value115);
/* 3480 */         } else {
/* 3481 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 3482 */         }
/* 3483 */
/* 3484 */         if (!agg_isNull87) {
/* 3485 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value123);
/* 3486 */         } else {
/* 3487 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 3488 */         }
/* 3489 */
/* 3490 */         if (!agg_isNull95) {
/* 3491 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value131);
/* 3492 */         } else {
/* 3493 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 3494 */         }
/* 3495 */
/* 3496 */         if (!agg_isNull103) {
/* 3497 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value139);
/* 3498 */         } else {
/* 3499 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 3500 */         }
/* 3501 */
/* 3502 */         if (!agg_isNull111) {
/* 3503 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value147);
/* 3504 */         } else {
/* 3505 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 3506 */         }
/* 3507 */
/* 3508 */         if (!agg_isNull119) {
/* 3509 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value155);
/* 3510 */         } else {
/* 3511 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 3512 */         }
/* 3513 */
/* 3514 */         if (!agg_isNull127) {
/* 3515 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value163);
/* 3516 */         } else {
/* 3517 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 3518 */         }
/* 3519 */
/* 3520 */         if (!agg_isNull135) {
/* 3521 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value171);
/* 3522 */         } else {
/* 3523 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 3524 */         }
/* 3525 */
/* 3526 */         if (!agg_isNull143) {
/* 3527 */           agg_unsafeRowAggBuffer.setDouble(10, agg_value179);
/* 3528 */         } else {
/* 3529 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 3530 */         }
/* 3531 */
/* 3532 */         if (!agg_isNull151) {
/* 3533 */           agg_unsafeRowAggBuffer.setDouble(11, agg_value187);
/* 3534 */         } else {
/* 3535 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 3536 */         }
/* 3537 */
/* 3538 */         if (!agg_isNull159) {
/* 3539 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value195);
/* 3540 */         } else {
/* 3541 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 3542 */         }
/* 3543 */
/* 3544 */         if (!agg_isNull168) {
/* 3545 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value204);
/* 3546 */         } else {
/* 3547 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 3548 */         }
/* 3549 */
/* 3550 */         if (!agg_isNull177) {
/* 3551 */           agg_unsafeRowAggBuffer.setDouble(14, agg_value213);
/* 3552 */         } else {
/* 3553 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 3554 */         }
/* 3555 */
/* 3556 */         if (!agg_isNull186) {
/* 3557 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value222);
/* 3558 */         } else {
/* 3559 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 3560 */         }
/* 3561 */
/* 3562 */         if (!agg_isNull195) {
/* 3563 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value231);
/* 3564 */         } else {
/* 3565 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 3566 */         }
/* 3567 */
/* 3568 */         if (!agg_isNull204) {
/* 3569 */           agg_unsafeRowAggBuffer.setDouble(17, agg_value240);
/* 3570 */         } else {
/* 3571 */           agg_unsafeRowAggBuffer.setNullAt(17);
/* 3572 */         }
/* 3573 */
/* 3574 */         if (!agg_isNull213) {
/* 3575 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value249);
/* 3576 */         } else {
/* 3577 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 3578 */         }
/* 3579 */
/* 3580 */         if (!agg_isNull222) {
/* 3581 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value258);
/* 3582 */         } else {
/* 3583 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 3584 */         }
/* 3585 */
/* 3586 */         if (!agg_isNull231) {
/* 3587 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value267);
/* 3588 */         } else {
/* 3589 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 3590 */         }
/* 3591 */
/* 3592 */         if (!agg_isNull240) {
/* 3593 */           agg_unsafeRowAggBuffer.setDouble(21, agg_value276);
/* 3594 */         } else {
/* 3595 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 3596 */         }
/* 3597 */
/* 3598 */         if (!agg_isNull249) {
/* 3599 */           agg_unsafeRowAggBuffer.setDouble(22, agg_value285);
/* 3600 */         } else {
/* 3601 */           agg_unsafeRowAggBuffer.setNullAt(22);
/* 3602 */         }
/* 3603 */
/* 3604 */         if (!agg_isNull258) {
/* 3605 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value294);
/* 3606 */         } else {
/* 3607 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 3608 */         }
/* 3609 */
/* 3610 */         if (!agg_isNull267) {
/* 3611 */           agg_unsafeRowAggBuffer.setDouble(24, agg_value303);
/* 3612 */         } else {
/* 3613 */           agg_unsafeRowAggBuffer.setNullAt(24);
/* 3614 */         }
/* 3615 */
/* 3616 */         if (!agg_isNull275) {
/* 3617 */           agg_unsafeRowAggBuffer.setDouble(25, agg_value311);
/* 3618 */         } else {
/* 3619 */           agg_unsafeRowAggBuffer.setNullAt(25);
/* 3620 */         }
/* 3621 */
/* 3622 */         if (!agg_isNull283) {
/* 3623 */           agg_unsafeRowAggBuffer.setDouble(26, agg_value319);
/* 3624 */         } else {
/* 3625 */           agg_unsafeRowAggBuffer.setNullAt(26);
/* 3626 */         }
/* 3627 */
/* 3628 */         if (!agg_isNull291) {
/* 3629 */           agg_unsafeRowAggBuffer.setDouble(27, agg_value327);
/* 3630 */         } else {
/* 3631 */           agg_unsafeRowAggBuffer.setNullAt(27);
/* 3632 */         }
/* 3633 */
/* 3634 */         if (!agg_isNull299) {
/* 3635 */           agg_unsafeRowAggBuffer.setDouble(28, agg_value335);
/* 3636 */         } else {
/* 3637 */           agg_unsafeRowAggBuffer.setNullAt(28);
/* 3638 */         }
/* 3639 */
/* 3640 */         if (!agg_isNull307) {
/* 3641 */           agg_unsafeRowAggBuffer.setDouble(29, agg_value343);
/* 3642 */         } else {
/* 3643 */           agg_unsafeRowAggBuffer.setNullAt(29);
/* 3644 */         }
/* 3645 */
/* 3646 */         if (!agg_isNull315) {
/* 3647 */           agg_unsafeRowAggBuffer.setDouble(30, agg_value351);
/* 3648 */         } else {
/* 3649 */           agg_unsafeRowAggBuffer.setNullAt(30);
/* 3650 */         }
/* 3651 */
/* 3652 */         if (!agg_isNull323) {
/* 3653 */           agg_unsafeRowAggBuffer.setDouble(31, agg_value359);
/* 3654 */         } else {
/* 3655 */           agg_unsafeRowAggBuffer.setNullAt(31);
/* 3656 */         }
/* 3657 */
/* 3658 */         if (!agg_isNull331) {
/* 3659 */           agg_unsafeRowAggBuffer.setDouble(32, agg_value367);
/* 3660 */         } else {
/* 3661 */           agg_unsafeRowAggBuffer.setNullAt(32);
/* 3662 */         }
/* 3663 */
/* 3664 */         if (!agg_isNull339) {
/* 3665 */           agg_unsafeRowAggBuffer.setDouble(33, agg_value375);
/* 3666 */         } else {
/* 3667 */           agg_unsafeRowAggBuffer.setNullAt(33);
/* 3668 */         }
/* 3669 */
/* 3670 */         if (!agg_isNull347) {
/* 3671 */           agg_unsafeRowAggBuffer.setDouble(34, agg_value383);
/* 3672 */         } else {
/* 3673 */           agg_unsafeRowAggBuffer.setNullAt(34);
/* 3674 */         }
/* 3675 */
/* 3676 */         if (!agg_isNull355) {
/* 3677 */           agg_unsafeRowAggBuffer.setDouble(35, agg_value391);
/* 3678 */         } else {
/* 3679 */           agg_unsafeRowAggBuffer.setNullAt(35);
/* 3680 */         }
/* 3681 */
/* 3682 */       }
/* 3683 */       if (shouldStop()) return;
/* 3684 */     }
/* 3685 */
/* 3686 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 3687 */
/* 3688 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 3689 */   }
/* 3690 */
/* 3691 */   protected void processNext() throws java.io.IOException {
/* 3692 */     if (!agg_initAgg) {
/* 3693 */       agg_initAgg = true;
/* 3694 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 3695 */       agg_doAggregateWithKeys();
/* 3696 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 3697 */     }
/* 3698 */
/* 3699 */     // output the result
/* 3700 */
/* 3701 */     while (agg_fastHashMapIter.next()) {
/* 3702 */       wholestagecodegen_numOutputRows.add(1);
/* 3703 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 3704 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 3705 */
/* 3706 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 3707 */
/* 3708 */       append(agg_resultRow);
/* 3709 */
/* 3710 */       if (shouldStop()) return;
/* 3711 */     }
/* 3712 */     agg_fastHashMap.close();
/* 3713 */
/* 3714 */     while (agg_mapIter.next()) {
/* 3715 */       wholestagecodegen_numOutputRows.add(1);
/* 3716 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 3717 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 3718 */
/* 3719 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 3720 */
/* 3721 */       append(agg_resultRow);
/* 3722 */
/* 3723 */       if (shouldStop()) return;
/* 3724 */     }
/* 3725 */
/* 3726 */     agg_mapIter.close();
/* 3727 */     if (agg_sorter == null) {
/* 3728 */       agg_hashMap.free();
/* 3729 */     }
/* 3730 */   }
/* 3731 */ }
