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
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value16;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     agg_initAgg = false;
/* 040 */
/* 041 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 042 */
/* 043 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 045 */     inputadapter_input = inputs[0];
/* 046 */     agg_result = new UnsafeRow(5);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(8);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 8);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 071 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 072 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 073 */       long inputadapter_value5 = inputadapter_row.getLong(5);
/* 074 */       long inputadapter_value6 = inputadapter_row.getLong(6);
/* 075 */       long inputadapter_value7 = inputadapter_row.getLong(7);
/* 076 */
/* 077 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 078 */
/* 079 */       UnsafeRow agg_fastAggBuffer = null;
/* 080 */
/* 081 */       if (agg_fastAggBuffer == null) {
/* 082 */         // generate grouping key
/* 083 */         agg_holder.reset();
/* 084 */
/* 085 */         agg_rowWriter.zeroOutNullBytes();
/* 086 */
/* 087 */         if (inputadapter_isNull) {
/* 088 */           agg_rowWriter.setNullAt(0);
/* 089 */         } else {
/* 090 */           agg_rowWriter.write(0, inputadapter_value);
/* 091 */         }
/* 092 */
/* 093 */         if (inputadapter_isNull1) {
/* 094 */           agg_rowWriter.setNullAt(1);
/* 095 */         } else {
/* 096 */           agg_rowWriter.write(1, inputadapter_value1);
/* 097 */         }
/* 098 */
/* 099 */         if (inputadapter_isNull2) {
/* 100 */           agg_rowWriter.setNullAt(2);
/* 101 */         } else {
/* 102 */           agg_rowWriter.write(2, inputadapter_value2);
/* 103 */         }
/* 104 */
/* 105 */         if (inputadapter_isNull3) {
/* 106 */           agg_rowWriter.setNullAt(3);
/* 107 */         } else {
/* 108 */           agg_rowWriter.write(3, inputadapter_value3);
/* 109 */         }
/* 110 */
/* 111 */         if (inputadapter_isNull4) {
/* 112 */           agg_rowWriter.setNullAt(4);
/* 113 */         } else {
/* 114 */           agg_rowWriter.write(4, inputadapter_value4);
/* 115 */         }
/* 116 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 117 */         agg_value16 = 42;
/* 118 */
/* 119 */         if (!inputadapter_isNull) {
/* 120 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value16);
/* 121 */         }
/* 122 */
/* 123 */         if (!inputadapter_isNull1) {
/* 124 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value16);
/* 125 */         }
/* 126 */
/* 127 */         if (!inputadapter_isNull2) {
/* 128 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value16);
/* 129 */         }
/* 130 */
/* 131 */         if (!inputadapter_isNull3) {
/* 132 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value16);
/* 133 */         }
/* 134 */
/* 135 */         if (!inputadapter_isNull4) {
/* 136 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value16);
/* 137 */         }
/* 138 */         if (true) {
/* 139 */           // try to get the buffer from hash map
/* 140 */           agg_unsafeRowAggBuffer =
/* 141 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 142 */         }
/* 143 */         if (agg_unsafeRowAggBuffer == null) {
/* 144 */           if (agg_sorter == null) {
/* 145 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 146 */           } else {
/* 147 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 148 */           }
/* 149 */
/* 150 */           // the hash map had be spilled, it should have enough memory now,
/* 151 */           // try  to allocate buffer again.
/* 152 */           agg_unsafeRowAggBuffer =
/* 153 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 154 */           if (agg_unsafeRowAggBuffer == null) {
/* 155 */             // failed to allocate the first page
/* 156 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 157 */           }
/* 158 */         }
/* 159 */       }
/* 160 */
/* 161 */       if (agg_fastAggBuffer != null) {
/* 162 */         // update fast row
/* 163 */
/* 164 */       } else {
/* 165 */         // update unsafe row
/* 166 */
/* 167 */         // common sub-expressions
/* 168 */
/* 169 */         // evaluate aggregate function
/* 170 */         boolean agg_isNull19 = false;
/* 171 */
/* 172 */         long agg_value23 = agg_unsafeRowAggBuffer.getLong(0);
/* 173 */
/* 174 */         long agg_value22 = -1L;
/* 175 */         agg_value22 = agg_value23 + inputadapter_value5;
/* 176 */         boolean agg_isNull22 = false;
/* 177 */
/* 178 */         long agg_value26 = agg_unsafeRowAggBuffer.getLong(1);
/* 179 */
/* 180 */         long agg_value25 = -1L;
/* 181 */         agg_value25 = agg_value26 + inputadapter_value6;
/* 182 */         boolean agg_isNull25 = false;
/* 183 */
/* 184 */         long agg_value29 = agg_unsafeRowAggBuffer.getLong(2);
/* 185 */
/* 186 */         long agg_value28 = -1L;
/* 187 */         agg_value28 = agg_value29 + inputadapter_value7;
/* 188 */         // update unsafe row buffer
/* 189 */         agg_unsafeRowAggBuffer.setLong(0, agg_value22);
/* 190 */         agg_unsafeRowAggBuffer.setLong(1, agg_value25);
/* 191 */         agg_unsafeRowAggBuffer.setLong(2, agg_value28);
/* 192 */
/* 193 */       }
/* 194 */       if (shouldStop()) return;
/* 195 */     }
/* 196 */
/* 197 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 198 */   }
/* 199 */
/* 200 */   protected void processNext() throws java.io.IOException {
/* 201 */     if (!agg_initAgg) {
/* 202 */       agg_initAgg = true;
/* 203 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 204 */       agg_doAggregateWithKeys();
/* 205 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 206 */     }
/* 207 */
/* 208 */     // output the result
/* 209 */
/* 210 */     while (agg_mapIter.next()) {
/* 211 */       wholestagecodegen_numOutputRows.add(1);
/* 212 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 213 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 214 */
/* 215 */       boolean agg_isNull28 = agg_aggKey.isNullAt(0);
/* 216 */       UTF8String agg_value31 = agg_isNull28 ? null : (agg_aggKey.getUTF8String(0));
/* 217 */       boolean agg_isNull29 = agg_aggKey.isNullAt(1);
/* 218 */       UTF8String agg_value32 = agg_isNull29 ? null : (agg_aggKey.getUTF8String(1));
/* 219 */       boolean agg_isNull30 = agg_aggKey.isNullAt(2);
/* 220 */       UTF8String agg_value33 = agg_isNull30 ? null : (agg_aggKey.getUTF8String(2));
/* 221 */       boolean agg_isNull31 = agg_aggKey.isNullAt(3);
/* 222 */       int agg_value34 = agg_isNull31 ? -1 : (agg_aggKey.getInt(3));
/* 223 */       boolean agg_isNull32 = agg_aggKey.isNullAt(4);
/* 224 */       UTF8String agg_value35 = agg_isNull32 ? null : (agg_aggKey.getUTF8String(4));
/* 225 */       long agg_value36 = agg_aggBuffer.getLong(0);
/* 226 */       long agg_value37 = agg_aggBuffer.getLong(1);
/* 227 */       long agg_value38 = agg_aggBuffer.getLong(2);
/* 228 */
/* 229 */       agg_holder1.reset();
/* 230 */
/* 231 */       agg_rowWriter1.zeroOutNullBytes();
/* 232 */
/* 233 */       if (agg_isNull28) {
/* 234 */         agg_rowWriter1.setNullAt(0);
/* 235 */       } else {
/* 236 */         agg_rowWriter1.write(0, agg_value31);
/* 237 */       }
/* 238 */
/* 239 */       if (agg_isNull29) {
/* 240 */         agg_rowWriter1.setNullAt(1);
/* 241 */       } else {
/* 242 */         agg_rowWriter1.write(1, agg_value32);
/* 243 */       }
/* 244 */
/* 245 */       if (agg_isNull30) {
/* 246 */         agg_rowWriter1.setNullAt(2);
/* 247 */       } else {
/* 248 */         agg_rowWriter1.write(2, agg_value33);
/* 249 */       }
/* 250 */
/* 251 */       agg_rowWriter1.write(3, agg_value36);
/* 252 */
/* 253 */       if (agg_isNull31) {
/* 254 */         agg_rowWriter1.setNullAt(4);
/* 255 */       } else {
/* 256 */         agg_rowWriter1.write(4, agg_value34);
/* 257 */       }
/* 258 */
/* 259 */       agg_rowWriter1.write(5, agg_value37);
/* 260 */
/* 261 */       if (agg_isNull32) {
/* 262 */         agg_rowWriter1.setNullAt(6);
/* 263 */       } else {
/* 264 */         agg_rowWriter1.write(6, agg_value35);
/* 265 */       }
/* 266 */
/* 267 */       agg_rowWriter1.write(7, agg_value38);
/* 268 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 269 */       append(agg_result1);
/* 270 */
/* 271 */       if (shouldStop()) return;
/* 272 */     }
/* 273 */
/* 274 */     agg_mapIter.close();
/* 275 */     if (agg_sorter == null) {
/* 276 */       agg_hashMap.free();
/* 277 */     }
/* 278 */   }
/* 279 */ }
