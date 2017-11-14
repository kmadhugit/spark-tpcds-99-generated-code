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
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private boolean locallimit_stopEarly;
/* 022 */   private int locallimit_count;
/* 023 */   private UnsafeRow locallimit_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder locallimit_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter locallimit_rowWriter;
/* 026 */   private boolean globallimit_stopEarly;
/* 027 */   private int globallimit_count;
/* 028 */   private UnsafeRow globallimit_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder globallimit_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter globallimit_rowWriter;
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
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     agg_result = new UnsafeRow(3);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 047 */     locallimit_stopEarly = false;
/* 048 */     locallimit_count = 0;
/* 049 */     locallimit_result = new UnsafeRow(3);
/* 050 */     this.locallimit_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(locallimit_result, 0);
/* 051 */     this.locallimit_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(locallimit_holder, 3);
/* 052 */     globallimit_stopEarly = false;
/* 053 */     globallimit_count = 0;
/* 054 */     globallimit_result = new UnsafeRow(3);
/* 055 */     this.globallimit_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(globallimit_result, 0);
/* 056 */     this.globallimit_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(globallimit_holder, 3);
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 061 */     // initialize aggregation buffer
/* 062 */     final long agg_value = -1L;
/* 063 */     agg_bufIsNull = true;
/* 064 */     agg_bufValue = agg_value;
/* 065 */     final long agg_value1 = -1L;
/* 066 */     agg_bufIsNull1 = true;
/* 067 */     agg_bufValue1 = agg_value1;
/* 068 */     final long agg_value2 = -1L;
/* 069 */     agg_bufIsNull2 = true;
/* 070 */     agg_bufValue2 = agg_value2;
/* 071 */
/* 072 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 073 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 074 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 075 */       long inputadapter_value = inputadapter_isNull ? -1L : (inputadapter_row.getLong(0));
/* 076 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 077 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 078 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 079 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 080 */
/* 081 */       // do aggregate
/* 082 */       // common sub-expressions
/* 083 */
/* 084 */       // evaluate aggregate function
/* 085 */       boolean agg_isNull10 = true;
/* 086 */       long agg_value10 = -1L;
/* 087 */
/* 088 */       boolean agg_isNull11 = agg_bufIsNull;
/* 089 */       long agg_value11 = agg_bufValue;
/* 090 */       if (agg_isNull11) {
/* 091 */         boolean agg_isNull13 = false;
/* 092 */         long agg_value13 = -1L;
/* 093 */         if (!false) {
/* 094 */           agg_value13 = (long) 0;
/* 095 */         }
/* 096 */         if (!agg_isNull13) {
/* 097 */           agg_isNull11 = false;
/* 098 */           agg_value11 = agg_value13;
/* 099 */         }
/* 100 */       }
/* 101 */
/* 102 */       if (!inputadapter_isNull) {
/* 103 */         agg_isNull10 = false; // resultCode could change nullability.
/* 104 */         agg_value10 = agg_value11 + inputadapter_value;
/* 105 */
/* 106 */       }
/* 107 */       boolean agg_isNull9 = agg_isNull10;
/* 108 */       long agg_value9 = agg_value10;
/* 109 */       if (agg_isNull9) {
/* 110 */         if (!agg_bufIsNull) {
/* 111 */           agg_isNull9 = false;
/* 112 */           agg_value9 = agg_bufValue;
/* 113 */         }
/* 114 */       }
/* 115 */       boolean agg_isNull18 = true;
/* 116 */       long agg_value18 = -1L;
/* 117 */
/* 118 */       boolean agg_isNull19 = agg_bufIsNull1;
/* 119 */       long agg_value19 = agg_bufValue1;
/* 120 */       if (agg_isNull19) {
/* 121 */         boolean agg_isNull21 = false;
/* 122 */         long agg_value21 = -1L;
/* 123 */         if (!false) {
/* 124 */           agg_value21 = (long) 0;
/* 125 */         }
/* 126 */         if (!agg_isNull21) {
/* 127 */           agg_isNull19 = false;
/* 128 */           agg_value19 = agg_value21;
/* 129 */         }
/* 130 */       }
/* 131 */
/* 132 */       if (!inputadapter_isNull1) {
/* 133 */         agg_isNull18 = false; // resultCode could change nullability.
/* 134 */         agg_value18 = agg_value19 + inputadapter_value1;
/* 135 */
/* 136 */       }
/* 137 */       boolean agg_isNull17 = agg_isNull18;
/* 138 */       long agg_value17 = agg_value18;
/* 139 */       if (agg_isNull17) {
/* 140 */         if (!agg_bufIsNull1) {
/* 141 */           agg_isNull17 = false;
/* 142 */           agg_value17 = agg_bufValue1;
/* 143 */         }
/* 144 */       }
/* 145 */       boolean agg_isNull26 = true;
/* 146 */       long agg_value26 = -1L;
/* 147 */
/* 148 */       boolean agg_isNull27 = agg_bufIsNull2;
/* 149 */       long agg_value27 = agg_bufValue2;
/* 150 */       if (agg_isNull27) {
/* 151 */         boolean agg_isNull29 = false;
/* 152 */         long agg_value29 = -1L;
/* 153 */         if (!false) {
/* 154 */           agg_value29 = (long) 0;
/* 155 */         }
/* 156 */         if (!agg_isNull29) {
/* 157 */           agg_isNull27 = false;
/* 158 */           agg_value27 = agg_value29;
/* 159 */         }
/* 160 */       }
/* 161 */
/* 162 */       if (!inputadapter_isNull2) {
/* 163 */         agg_isNull26 = false; // resultCode could change nullability.
/* 164 */         agg_value26 = agg_value27 + inputadapter_value2;
/* 165 */
/* 166 */       }
/* 167 */       boolean agg_isNull25 = agg_isNull26;
/* 168 */       long agg_value25 = agg_value26;
/* 169 */       if (agg_isNull25) {
/* 170 */         if (!agg_bufIsNull2) {
/* 171 */           agg_isNull25 = false;
/* 172 */           agg_value25 = agg_bufValue2;
/* 173 */         }
/* 174 */       }
/* 175 */       // update aggregation buffer
/* 176 */       agg_bufIsNull = agg_isNull9;
/* 177 */       agg_bufValue = agg_value9;
/* 178 */
/* 179 */       agg_bufIsNull1 = agg_isNull17;
/* 180 */       agg_bufValue1 = agg_value17;
/* 181 */
/* 182 */       agg_bufIsNull2 = agg_isNull25;
/* 183 */       agg_bufValue2 = agg_value25;
/* 184 */       if (shouldStop()) return;
/* 185 */     }
/* 186 */
/* 187 */   }
/* 188 */
/* 189 */   @Override
/* 190 */   protected boolean stopEarly() {
/* 191 */     return globallimit_stopEarly;
/* 192 */   }
/* 193 */
/* 194 */   protected void processNext() throws java.io.IOException {
/* 195 */     while (!agg_initAgg) {
/* 196 */       agg_initAgg = true;
/* 197 */       long agg_beforeAgg = System.nanoTime();
/* 198 */       agg_doAggregateWithoutKey();
/* 199 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 200 */
/* 201 */       // output the result
/* 202 */
/* 203 */       agg_numOutputRows.add(1);
/* 204 */       if (locallimit_count < 100) {
/* 205 */         locallimit_count += 1;
/* 206 */
/* 207 */         if (globallimit_count < 100) {
/* 208 */           globallimit_count += 1;
/* 209 */
/* 210 */           globallimit_rowWriter.zeroOutNullBytes();
/* 211 */
/* 212 */           if (agg_bufIsNull) {
/* 213 */             globallimit_rowWriter.setNullAt(0);
/* 214 */           } else {
/* 215 */             globallimit_rowWriter.write(0, agg_bufValue);
/* 216 */           }
/* 217 */
/* 218 */           if (agg_bufIsNull1) {
/* 219 */             globallimit_rowWriter.setNullAt(1);
/* 220 */           } else {
/* 221 */             globallimit_rowWriter.write(1, agg_bufValue1);
/* 222 */           }
/* 223 */
/* 224 */           if (agg_bufIsNull2) {
/* 225 */             globallimit_rowWriter.setNullAt(2);
/* 226 */           } else {
/* 227 */             globallimit_rowWriter.write(2, agg_bufValue2);
/* 228 */           }
/* 229 */           append(globallimit_result);
/* 230 */
/* 231 */         } else {
/* 232 */           globallimit_stopEarly = true;
/* 233 */         }
/* 234 */
/* 235 */       } else {
/* 236 */         locallimit_stopEarly = true;
/* 237 */       }
/* 238 */     }
/* 239 */   }
/* 240 */ }
