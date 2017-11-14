/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private UnsafeRow scan_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 020 */   private UnsafeRow filter_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */
/* 027 */   public GeneratedIterator(Object[] references) {
/* 028 */     this.references = references;
/* 029 */   }
/* 030 */
/* 031 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 032 */     partitionIndex = index;
/* 033 */     this.inputs = inputs;
/* 034 */     wholestagecodegen_init_0();
/* 035 */     wholestagecodegen_init_1();
/* 036 */
/* 037 */   }
/* 038 */
/* 039 */   private void wholestagecodegen_init_0() {
/* 040 */     scan_input = inputs[0];
/* 041 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 042 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 043 */     scan_scanTime1 = 0;
/* 044 */     scan_batch = null;
/* 045 */     scan_batchIdx = 0;
/* 046 */     scan_colInstance0 = null;
/* 047 */     scan_colInstance1 = null;
/* 048 */     scan_result = new UnsafeRow(2);
/* 049 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 050 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 051 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 052 */     filter_result = new UnsafeRow(2);
/* 053 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 054 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 055 */     project_result = new UnsafeRow(1);
/* 056 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void scan_nextBatch() throws java.io.IOException {
/* 061 */     long getBatchStart = System.nanoTime();
/* 062 */     if (scan_input.hasNext()) {
/* 063 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 064 */       scan_numOutputRows.add(scan_batch.numRows());
/* 065 */       scan_batchIdx = 0;
/* 066 */       scan_colInstance0 = scan_batch.column(0);
/* 067 */       scan_colInstance1 = scan_batch.column(1);
/* 068 */
/* 069 */     }
/* 070 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 071 */   }
/* 072 */
/* 073 */   private void wholestagecodegen_init_1() {
/* 074 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   protected void processNext() throws java.io.IOException {
/* 079 */     if (scan_batch == null) {
/* 080 */       scan_nextBatch();
/* 081 */     }
/* 082 */     while (scan_batch != null) {
/* 083 */       int numRows = scan_batch.numRows();
/* 084 */       while (scan_batchIdx < numRows) {
/* 085 */         int scan_rowIdx = scan_batchIdx++;
/* 086 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 087 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 088 */
/* 089 */         boolean filter_value = false;
/* 090 */         boolean filter_isNull = scan_isNull;
/* 091 */         if (!filter_isNull) {
/* 092 */           if (!filter_value) {
/* 093 */             if (false) {
/* 094 */               filter_isNull = true;
/* 095 */             } else if (scan_value == 2) {
/* 096 */               filter_isNull = false;
/* 097 */               filter_value = true;
/* 098 */             }
/* 099 */           }
/* 100 */
/* 101 */           if (!filter_value) {
/* 102 */             if (false) {
/* 103 */               filter_isNull = true;
/* 104 */             } else if (scan_value == 3) {
/* 105 */               filter_isNull = false;
/* 106 */               filter_value = true;
/* 107 */             }
/* 108 */           }
/* 109 */
/* 110 */           if (!filter_value) {
/* 111 */             if (false) {
/* 112 */               filter_isNull = true;
/* 113 */             } else if (scan_value == 5) {
/* 114 */               filter_isNull = false;
/* 115 */               filter_value = true;
/* 116 */             }
/* 117 */           }
/* 118 */
/* 119 */           if (!filter_value) {
/* 120 */             if (false) {
/* 121 */               filter_isNull = true;
/* 122 */             } else if (scan_value == 7) {
/* 123 */               filter_isNull = false;
/* 124 */               filter_value = true;
/* 125 */             }
/* 126 */           }
/* 127 */
/* 128 */           if (!filter_value) {
/* 129 */             if (false) {
/* 130 */               filter_isNull = true;
/* 131 */             } else if (scan_value == 11) {
/* 132 */               filter_isNull = false;
/* 133 */               filter_value = true;
/* 134 */             }
/* 135 */           }
/* 136 */
/* 137 */           if (!filter_value) {
/* 138 */             if (false) {
/* 139 */               filter_isNull = true;
/* 140 */             } else if (scan_value == 13) {
/* 141 */               filter_isNull = false;
/* 142 */               filter_value = true;
/* 143 */             }
/* 144 */           }
/* 145 */
/* 146 */           if (!filter_value) {
/* 147 */             if (false) {
/* 148 */               filter_isNull = true;
/* 149 */             } else if (scan_value == 17) {
/* 150 */               filter_isNull = false;
/* 151 */               filter_value = true;
/* 152 */             }
/* 153 */           }
/* 154 */
/* 155 */           if (!filter_value) {
/* 156 */             if (false) {
/* 157 */               filter_isNull = true;
/* 158 */             } else if (scan_value == 19) {
/* 159 */               filter_isNull = false;
/* 160 */               filter_value = true;
/* 161 */             }
/* 162 */           }
/* 163 */
/* 164 */           if (!filter_value) {
/* 165 */             if (false) {
/* 166 */               filter_isNull = true;
/* 167 */             } else if (scan_value == 23) {
/* 168 */               filter_isNull = false;
/* 169 */               filter_value = true;
/* 170 */             }
/* 171 */           }
/* 172 */
/* 173 */           if (!filter_value) {
/* 174 */             if (false) {
/* 175 */               filter_isNull = true;
/* 176 */             } else if (scan_value == 29) {
/* 177 */               filter_isNull = false;
/* 178 */               filter_value = true;
/* 179 */             }
/* 180 */           }
/* 181 */
/* 182 */         }
/* 183 */         if (filter_isNull || !filter_value) continue;
/* 184 */
/* 185 */         filter_numOutputRows.add(1);
/* 186 */
/* 187 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 188 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 189 */         project_holder.reset();
/* 190 */
/* 191 */         project_rowWriter.zeroOutNullBytes();
/* 192 */
/* 193 */         if (scan_isNull1) {
/* 194 */           project_rowWriter.setNullAt(0);
/* 195 */         } else {
/* 196 */           project_rowWriter.write(0, scan_value1);
/* 197 */         }
/* 198 */         project_result.setTotalSize(project_holder.totalSize());
/* 199 */         append(project_result);
/* 200 */         if (shouldStop()) return;
/* 201 */       }
/* 202 */       scan_batch = null;
/* 203 */       scan_nextBatch();
/* 204 */     }
/* 205 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 206 */     scan_scanTime1 = 0;
/* 207 */   }
/* 208 */ }
