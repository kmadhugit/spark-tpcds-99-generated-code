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
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value8;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */
/* 039 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     agg_result = new UnsafeRow(3);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(4);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 4);
/* 049 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 050 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 055 */     agg_hashMap = agg_plan.createHashMap();
/* 056 */
/* 057 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 058 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 059 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 060 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 061 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 062 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 065 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 066 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 067 */
/* 068 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 069 */
/* 070 */       UnsafeRow agg_fastAggBuffer = null;
/* 071 */
/* 072 */       if (agg_fastAggBuffer == null) {
/* 073 */         // generate grouping key
/* 074 */         agg_holder.reset();
/* 075 */
/* 076 */         agg_rowWriter.zeroOutNullBytes();
/* 077 */
/* 078 */         if (inputadapter_isNull) {
/* 079 */           agg_rowWriter.setNullAt(0);
/* 080 */         } else {
/* 081 */           agg_rowWriter.write(0, inputadapter_value);
/* 082 */         }
/* 083 */
/* 084 */         if (inputadapter_isNull1) {
/* 085 */           agg_rowWriter.setNullAt(1);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(1, inputadapter_value1);
/* 088 */         }
/* 089 */
/* 090 */         if (inputadapter_isNull2) {
/* 091 */           agg_rowWriter.setNullAt(2);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(2, inputadapter_value2);
/* 094 */         }
/* 095 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 096 */         agg_value8 = 42;
/* 097 */
/* 098 */         if (!inputadapter_isNull) {
/* 099 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value8);
/* 100 */         }
/* 101 */
/* 102 */         if (!inputadapter_isNull1) {
/* 103 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value8);
/* 104 */         }
/* 105 */
/* 106 */         if (!inputadapter_isNull2) {
/* 107 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value8);
/* 108 */         }
/* 109 */         if (true) {
/* 110 */           // try to get the buffer from hash map
/* 111 */           agg_unsafeRowAggBuffer =
/* 112 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 113 */         }
/* 114 */         if (agg_unsafeRowAggBuffer == null) {
/* 115 */           if (agg_sorter == null) {
/* 116 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 117 */           } else {
/* 118 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 119 */           }
/* 120 */
/* 121 */           // the hash map had be spilled, it should have enough memory now,
/* 122 */           // try  to allocate buffer again.
/* 123 */           agg_unsafeRowAggBuffer =
/* 124 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 125 */           if (agg_unsafeRowAggBuffer == null) {
/* 126 */             // failed to allocate the first page
/* 127 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 128 */           }
/* 129 */         }
/* 130 */       }
/* 131 */
/* 132 */       if (agg_fastAggBuffer != null) {
/* 133 */         // update fast row
/* 134 */
/* 135 */       } else {
/* 136 */         // update unsafe row
/* 137 */
/* 138 */         // common sub-expressions
/* 139 */
/* 140 */         // evaluate aggregate function
/* 141 */         boolean agg_isNull12 = true;
/* 142 */         double agg_value13 = -1.0;
/* 143 */
/* 144 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 145 */         double agg_value15 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 146 */         boolean agg_isNull13 = agg_isNull14;
/* 147 */         double agg_value14 = agg_value15;
/* 148 */         if (agg_isNull13) {
/* 149 */           boolean agg_isNull15 = false;
/* 150 */           double agg_value16 = -1.0;
/* 151 */           if (!false) {
/* 152 */             agg_value16 = (double) 0;
/* 153 */           }
/* 154 */           if (!agg_isNull15) {
/* 155 */             agg_isNull13 = false;
/* 156 */             agg_value14 = agg_value16;
/* 157 */           }
/* 158 */         }
/* 159 */
/* 160 */         if (!inputadapter_isNull3) {
/* 161 */           agg_isNull12 = false; // resultCode could change nullability.
/* 162 */           agg_value13 = agg_value14 + inputadapter_value3;
/* 163 */
/* 164 */         }
/* 165 */         boolean agg_isNull11 = agg_isNull12;
/* 166 */         double agg_value12 = agg_value13;
/* 167 */         if (agg_isNull11) {
/* 168 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 169 */           double agg_value19 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 170 */           if (!agg_isNull18) {
/* 171 */             agg_isNull11 = false;
/* 172 */             agg_value12 = agg_value19;
/* 173 */           }
/* 174 */         }
/* 175 */         // update unsafe row buffer
/* 176 */         if (!agg_isNull11) {
/* 177 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 178 */         } else {
/* 179 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 180 */         }
/* 181 */
/* 182 */       }
/* 183 */       if (shouldStop()) return;
/* 184 */     }
/* 185 */
/* 186 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 187 */   }
/* 188 */
/* 189 */   protected void processNext() throws java.io.IOException {
/* 190 */     if (!agg_initAgg) {
/* 191 */       agg_initAgg = true;
/* 192 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 193 */       agg_doAggregateWithKeys();
/* 194 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 195 */     }
/* 196 */
/* 197 */     // output the result
/* 198 */
/* 199 */     while (agg_mapIter.next()) {
/* 200 */       wholestagecodegen_numOutputRows.add(1);
/* 201 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 202 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 203 */
/* 204 */       boolean agg_isNull19 = agg_aggKey.isNullAt(0);
/* 205 */       int agg_value20 = agg_isNull19 ? -1 : (agg_aggKey.getInt(0));
/* 206 */       boolean agg_isNull20 = agg_aggKey.isNullAt(1);
/* 207 */       int agg_value21 = agg_isNull20 ? -1 : (agg_aggKey.getInt(1));
/* 208 */       boolean agg_isNull21 = agg_aggKey.isNullAt(2);
/* 209 */       UTF8String agg_value22 = agg_isNull21 ? null : (agg_aggKey.getUTF8String(2));
/* 210 */       boolean agg_isNull22 = agg_aggBuffer.isNullAt(0);
/* 211 */       double agg_value23 = agg_isNull22 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 212 */
/* 213 */       agg_holder1.reset();
/* 214 */
/* 215 */       agg_rowWriter1.zeroOutNullBytes();
/* 216 */
/* 217 */       if (agg_isNull19) {
/* 218 */         agg_rowWriter1.setNullAt(0);
/* 219 */       } else {
/* 220 */         agg_rowWriter1.write(0, agg_value20);
/* 221 */       }
/* 222 */
/* 223 */       if (agg_isNull20) {
/* 224 */         agg_rowWriter1.setNullAt(1);
/* 225 */       } else {
/* 226 */         agg_rowWriter1.write(1, agg_value21);
/* 227 */       }
/* 228 */
/* 229 */       if (agg_isNull21) {
/* 230 */         agg_rowWriter1.setNullAt(2);
/* 231 */       } else {
/* 232 */         agg_rowWriter1.write(2, agg_value22);
/* 233 */       }
/* 234 */
/* 235 */       if (agg_isNull22) {
/* 236 */         agg_rowWriter1.setNullAt(3);
/* 237 */       } else {
/* 238 */         agg_rowWriter1.write(3, agg_value23);
/* 239 */       }
/* 240 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 241 */       append(agg_result1);
/* 242 */
/* 243 */       if (shouldStop()) return;
/* 244 */     }
/* 245 */
/* 246 */     agg_mapIter.close();
/* 247 */     if (agg_sorter == null) {
/* 248 */       agg_hashMap.free();
/* 249 */     }
/* 250 */   }
/* 251 */ }
